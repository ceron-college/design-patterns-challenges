/*
 * Subject: Software Design Patterns
 * Structural Pattern -> Bridge
 * Class Type: Java
 * Class that inherits from EncryptInterface and returns the message without any encryption process.
 */
package com.ceron.encryption;

/**
 *
 * @author Fabrizio Bolaño
 */
public class NoEncryptionProcess implements EncryptInterface {

    @Override
    public String encrypt(String message, String password) throws Exception {
        return message;
    }
}
