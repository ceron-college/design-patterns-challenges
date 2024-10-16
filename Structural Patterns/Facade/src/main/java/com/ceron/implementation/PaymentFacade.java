/*
 * Subject: Software Design Patterns
 * Structural Pattern -> Facade
 * Class Type: Java
 */

package com.ceron.implementation;

import java.util.HashMap;
import com.ceron.finance.BankingSystem;
import com.ceron.finance.TransferRequest;
import com.ceron.billing.BillingSystem;
import com.ceron.billing.FacturePaymentRequest;
import com.ceron.crm.CRMSystem;
import com.ceron.mail.EmailSystem;
import com.ceron.utilities.SimulatedDBData;
import com.ceron.utilities.Client;
import com.ceron.loyalty.LoyaltySystem;

/**
 *
 */
public class PaymentFacade implements PaymentFacadeInterface {

    private static final CRMSystem crmSystem = new CRMSystem();
    private static final BillingSystem billingSystem = new BillingSystem();
    private static final BankingSystem bankingSystem = new BankingSystem();
    private static final EmailSystem emailSystem = new EmailSystem();
    private static final LoyaltySystem loyaltySystem = new LoyaltySystem(); // New LoyaltySystem instance

    @Override
    public PaymentResponse pay(PaymentRequest request)
            throws GeneralPaymentError {
        Client customer = crmSystem.findClient(request.getClientId());
        // Validate
        if(customer == null){
            throw new GeneralPaymentError("Client ID '" + request.getClientId() + "' does not exist.");
        } else if("Inactive".equals(customer.getStatus())){
            throw new GeneralPaymentError("Client ID '" + request.getClientId() + "' is inactive.");
        } else if(request.getAmount() >
                billingSystem.checkClientBalance(customer.getId())){
            throw new GeneralPaymentError("You are trying to make a payment "
                    + "\nhigher than the client's balance.");
        }

        double amountToPay = request.getAmount();
        int pointsUsed = 0;
        double amountCoveredByPoints = 0;

        // Check if points can cover the purchase
        int usablePoints = loyaltySystem.calculateUsablePoints(customer.getId(), amountToPay);
        if(usablePoints > 0){
            pointsUsed = (usablePoints / 10) * 10; // Use points in multiples of 10
            amountCoveredByPoints = pointsUsed / 10.0; // Each 10 points = $1
            if(amountCoveredByPoints >= amountToPay){
                // Points can cover the entire purchase
                pointsUsed = (int) (amountToPay * 10);
                amountCoveredByPoints = amountToPay;
                loyaltySystem.usePoints(customer.getId(), pointsUsed);
                amountToPay = 0;
                System.out.println("Payment covered entirely by points.");
            } else {
                // Points can cover part of the purchase
                loyaltySystem.usePoints(customer.getId(), pointsUsed);
                amountToPay -= amountCoveredByPoints;
                System.out.println("Payment partially covered by points. Remaining amount to pay: $" + amountToPay);
            }
        }

        String paymentReference = "";
        if(amountToPay > 0){
            // Charge the card for the remaining amount
            TransferRequest transfer = new TransferRequest(
                    amountToPay,
                    request.getCardNumber(),
                    request.getCardName(),
                    request.getCardExpirationDate(),
                    request.getCardSecurityNumber());
            paymentReference = bankingSystem.transfer(transfer);
        } else {
            paymentReference = "POINTS_ONLY_PAYMENT";
        }

        // Impact of the transaction if any amount was paid via bank
        double newBalance = billingSystem.checkClientBalance(request.getClientId());
        String newStatus = customer.getStatus();

        if(amountToPay > 0){
            FacturePaymentRequest paymentRequest = new FacturePaymentRequest(
                    request.getClientId(), amountToPay);
            newBalance = billingSystem.makePayment(paymentRequest);

            // Award points based on the amount paid via bank
            loyaltySystem.awardPoints(request.getClientId(), amountToPay);
        }

        // Reactivate client if new balance is <= 50
        if(newBalance <= 50){
            SimulatedDBData.changeClientStatus(request.getClientId(), "Active");
            newStatus = "Active";
        }

        // Send payment confirmation via Email.
        HashMap<String,String> params = new HashMap<>();
        params.put("name", customer.getName());
        params.put("Amount", String.format("%.2f", request.getAmount()));
        params.put("NewBalance", String.format("%.2f", newBalance));
        String number = request.getCardNumber();
        String suffix = number.substring(number.length()-4, number.length());
        params.put("CardNumber", suffix);
        params.put("Reference", paymentReference);
        params.put("NewStatus", newStatus);
        params.put("PointsUsed", String.valueOf(pointsUsed));
        params.put("AmountCoveredByPoints", String.format("%.2f", amountCoveredByPoints));
        emailSystem.sendEmail(params);

        return new PaymentResponse(paymentReference, newBalance, newStatus, pointsUsed, amountCoveredByPoints);

    }

}
