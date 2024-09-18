
/*
 * Subject: Software Design Patterns
 * Structural Pattern -> Bridge
 * Class Type: Interface
 * Common interface for all encryption algorithm implementations.
 */
package com.ceron.encryption;

/**
 * @author Fabrizio Bolaño
 */
public interface EncryptInterface {
    public String encrypt(String message, String password) throws Exception;
}

