/*
 * Subject: Software Design Patterns
 * Structural Pattern -> Adapter
 * Class Type: Java
 */

package com.ceron.fintech.c;

/**
 * Fintech C Credit API
 *
 * This class simulates a credit API that responds synchronously.
 * Returns true if the credit is approved and throws an exception if it is not.
 */
public class FintechCCreditsAPI {

    /**
     * Sends a credit request and returns true if approved.
     * Throws an exception if the credit is not approved.
     *
     * @param clientName Name of the client
     * @param amount     Requested credit amount
     * @return true if the credit is approved
     * @throws CreditNotApprovedException if the credit is not approved
     */
    public boolean sendCreditRequest(String clientName, double amount) throws CreditNotApprovedException {
        System.out.println("Fintech C is processing the credit request for " + clientName + " for an amount of " + amount);

        // Simple approval logic: approves if the amount is <= 4000
        if (amount <= 4000) {
            System.out.println("Fintech C has approved the credit.");
            return true;
        } else {
            System.out.println("Fintech C has not approved the credit.");
            throw new CreditNotApprovedException("Credit not approved for the requested amount: " + amount);
        }
    }

    /**
     * Exception thrown when the credit is not approved.
     */
    public static class CreditNotApprovedException extends Exception {
        public CreditNotApprovedException(String message) {
            super(message);
        }
    }
}
