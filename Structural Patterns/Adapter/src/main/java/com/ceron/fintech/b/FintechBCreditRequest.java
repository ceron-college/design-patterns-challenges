/*
 * Subject: Software Design Patterns
 * Structural Pattern -> Adapter
 * Class Type: Java
 */
package com.ceron.fintech.b;

/**
 *
 * @author Fabrizio Bolaño
 */
public class FintechBCreditRequest {
    private String ClientName;
    private double RequestedAmount;

    public String getClientName() {
        return ClientName;
    }

    public void setClientName(String ClientName) {
        this.ClientName = ClientName;
    }

    public double getRequestedAmount() {
        return RequestedAmount;
    }

    public void setRequestedAmount(double RequestedAmount) {
        this.RequestedAmount = RequestedAmount;
    }
}