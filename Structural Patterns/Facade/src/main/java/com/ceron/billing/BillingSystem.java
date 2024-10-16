/*
 * Subject: Software Design Patterns
 * Structural Pattern -> Facade
 * Class Type: Java
 */

package com.ceron.billing;

import com.ceron.utilities.Client;
import com.ceron.utilities.SimulatedDBData;

/**
 *
 * @author Fabrizio Bolaño
 */
public class BillingSystem {

    public double checkClientBalance(Long clientId) {
        Client client = SimulatedDBData.findClientById(clientId);
        return client.getBalance();
    }

    public double makePayment(FacturePaymentRequest paymentRequest) {
        Client customer = SimulatedDBData.findClientById(paymentRequest.getClientId());
        customer.setBalance(customer.getBalance() - paymentRequest.getPayment());
        System.out.println("Payment applied to client '"+customer.getName() +"', "
                + "the new balance is '"+customer.getBalance()+"'");
        return customer.getBalance(); // new Balance.
    }
}
