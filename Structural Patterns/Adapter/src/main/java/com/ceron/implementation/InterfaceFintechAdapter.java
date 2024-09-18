/*
 * Subject: Software Design Patterns
 * Structural Pattern -> Adapter
 * Class Type: Interface
 */
package com.ceron.implementation;

/**
 * @author Fabrizio Bolaño
 */
public interface InterfaceFintechAdapter {
    public FintechCreditResponse SendCreditRequest(FintechCreditRequest request);
}
