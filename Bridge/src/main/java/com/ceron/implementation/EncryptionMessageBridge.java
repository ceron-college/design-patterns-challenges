/*
 * Subject: Software Design Patterns
 * Structural Pattern -> Bridge
 * Class Type: Java
 * Class that represents the bridge.
 * The class implements EncryptionMessageInterface and delegates the responsibility to the encryption method assigned during object creation.
 */
package com.ceron.implementation;

import com.ceron.encryption.EncryptInterface;

/**
 * @author Fabrizio Bolaño
 */
public class EncryptionMessageBridge implements EncryptionMessageInterface {
    private EncryptInterface EncryptionProcess;

    public EncryptionMessageBridge(EncryptInterface EncryptionProcess) {
        this.EncryptionProcess = EncryptionProcess;
    }

    @Override
    public String EncryptMessage(String message, String password) throws Exception {
        return EncryptionProcess.encrypt(message, password);
    }
}
