/*
 * Subject: Software Design Patterns
 * Structural Pattern -> Facade
 * Class Type: Java
 */

package com.ceron.implementation;

/**
 *
 */
public interface PaymentFacadeInterface {
    public PaymentResponse pay(PaymentRequest paymentRequest) throws GeneralPaymentError;
}
