/*
 * Subject: Software Design Patterns
 * Structural Pattern -> Bridge
 * Class Type: Interface
 * Interface that defines the structure that bridge classes should have.
 * Through this interface, the client will communicate with the concrete encryption algorithms.
 */
package com.ceron.implementation;

/**
 * @author Fabrizio Bolaño
 */
public interface EncryptionMessageInterface {
    public String EncryptMessage(String message, String password) throws Exception;
}