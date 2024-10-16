/*
 * Subject: Software Design Patterns
 * Structural Pattern -> Facade
 * Class Type: Java
 */

package com.ceron.implementation;

/**
 *
 */
public class PaymentRequest {
    private Long clientId;
    private double amount;
    private String cardNumber;
    private String cardName;
    private String cardExpirationDate;
    private String cardSecurityNumber;

    public PaymentRequest() {
    }

    public Long getClientId() {
        return clientId;
    }

    public double getAmount() {
        return amount;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getCardName() {
        return cardName;
    }

    public String getCardExpirationDate() {
        return cardExpirationDate;
    }

    public String getCardSecurityNumber() {
        return cardSecurityNumber;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public void setCardExpirationDate(String cardExpirationDate) {
        this.cardExpirationDate = cardExpirationDate;
    }

    public void setCardSecurityNumber(String cardSecurityNumber) {
        this.cardSecurityNumber = cardSecurityNumber;
    }
}
