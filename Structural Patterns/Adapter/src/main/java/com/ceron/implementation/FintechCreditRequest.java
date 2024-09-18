/*
 * Subject: Software Design Patterns
 * Structural Pattern -> Adapter
 * Class Type: Java
 */
package com.ceron.implementation;

/**
 *
 * @author Fabrizio Bolaño
 */
public class FintechCreditRequest {
    private String Client;
    private double Amount;

    public String getClient() {
        return Client;
    }

    public void setClient(String Client) {
        this.Client = Client;
    }

    public double getAmount() {
        return Amount;
    }

    public void setAmount(double Amount) {
        this.Amount = Amount;
    }
}