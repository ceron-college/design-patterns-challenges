/*
 * Subject: Software Design Patterns
 * Structural Pattern -> Facade
 * Class Type: Java
 */

package com.ceron.billing;

/**
 *
 */
public class FacturePaymentRequest {
    private Long clientId;
    private double payment;

    public FacturePaymentRequest(Long clientId, double payment) {
        this.clientId = clientId;
        this.payment = payment;
    }

    public Long getClientId() {
        return clientId;
    }

    public double getPayment() {
        return payment;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public void setPayment(double payment) {
        this.payment = payment;
    }
}
