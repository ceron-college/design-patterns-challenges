/*
 * Subject: Software Design Patterns
 * Structural Pattern -> Facade
 * Class Type: Java
 */

package com.ceron.implementation;

/**
 *
 */
public class PaymentResponse {
    private String paymentConfirmationNumber;
    private double newBalance;
    private String clientStatus;
    private int pointsUsed; // New field
    private double amountCoveredByPoints; // New field

    public PaymentResponse(String paymentConfirmationNumber, double newBalance, String clientStatus, int pointsUsed, double amountCoveredByPoints) {
        this.paymentConfirmationNumber = paymentConfirmationNumber;
        this.newBalance = newBalance;
        this.clientStatus = clientStatus;
        this.pointsUsed = pointsUsed;
        this.amountCoveredByPoints = amountCoveredByPoints;
    }

    public String getPaymentConfirmationNumber() {
        return paymentConfirmationNumber;
    }

    public void setPaymentConfirmationNumber(String paymentConfirmationNumber) {
        this.paymentConfirmationNumber = paymentConfirmationNumber;
    }

    public double getNewBalance() {
        return newBalance;
    }

    public void setNewBalance(double newBalance) {
        this.newBalance = newBalance;
    }

    public String getClientStatus() {
        return clientStatus;
    }

    public void setClientStatus(String clientStatus) {
        this.clientStatus = clientStatus;
    }

    public int getPointsUsed() {
        return pointsUsed;
    }

    public void setPointsUsed(int pointsUsed) {
        this.pointsUsed = pointsUsed;
    }

    public double getAmountCoveredByPoints() {
        return amountCoveredByPoints;
    }

    public void setAmountCoveredByPoints(double amountCoveredByPoints) {
        this.amountCoveredByPoints = amountCoveredByPoints;
    }

    @Override
    public String toString() {
        return "PaymentResponse{" +
                "paymentConfirmationNumber='" + paymentConfirmationNumber + '\'' +
                ", newBalance=" + newBalance +
                ", clientStatus='" + clientStatus + '\'' +
                ", pointsUsed=" + pointsUsed +
                ", amountCoveredByPoints=" + amountCoveredByPoints +
                '}';
    }
}
