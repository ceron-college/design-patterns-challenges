/*
 * Subject: Software Design Patterns
 * Structural Pattern -> Facade
 * Class Type: Java
 */

package com.ceron.implementation;

/**
 *
 */
public class GeneralPaymentError extends Exception {
    public GeneralPaymentError(String message) {
        super(message);
    }
}
