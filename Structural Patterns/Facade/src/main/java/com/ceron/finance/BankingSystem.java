/*
 * Subject: Software Design Patterns
 * Structural Pattern -> Facade
 * Class Type: Java
 */

package com.ceron.finance;

import com.ceron.implementation.GeneralPaymentError;
import com.ceron.utilities.SimulatedDBData;

import java.util.UUID;

/**
 *
 * @author Fabrizio Bolaño
 */
public class BankingSystem {
    public String transfer(TransferRequest request) throws GeneralPaymentError {
        String cardPrefixNumber = request.getCardNumber().substring(0, 3);
        if (!SimulatedDBData.validateCard(cardPrefixNumber)) {
            throw new GeneralPaymentError("Invalid Card.");
        }
        String cardCompany = SimulatedDBData.getCardCompany(cardPrefixNumber);
        if ("NEQUI".equals(cardCompany) && request.getCardNumber().length() != 15) {
            throw new GeneralPaymentError("Invalid Card Number");
        } else if (("VISA".equals(cardCompany) || "MASTERCARD".equals(cardCompany))
                && request.getCardNumber().length() != 16) {
            throw new GeneralPaymentError("Invalid Card Number");
        }
        String number = request.getCardNumber();
        String cardSuffixNumber = number.substring(number.length()-4, number.length());
        System.out.println("A charge has been made to client '"
                + request.getCardName() + "' \n"
                + "\tFor an amount of: '" + request.getAmount() + "' to the card "
                + "ending in '"+cardSuffixNumber+"'.\n");

        return UUID.randomUUID().toString();
    }
}
