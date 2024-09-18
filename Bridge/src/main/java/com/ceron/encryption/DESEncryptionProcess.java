/*
 * Subject: Software Design Patterns
 * Structural Pattern -> Bridge
 * Class Type: Java
 * Class that inherits from EncryptInterface and encrypts the message using the DES algorithm.
 */
package com.ceron.encryption;

import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

/**
 *
 * @author Fabrizio Bolaño
 */
public class DESEncryptionProcess implements EncryptInterface {

    @Override
    public String encrypt(String message, String password) throws Exception {
        DESKeySpec dks = new DESKeySpec(message.getBytes());
        SecretKeyFactory skf = SecretKeyFactory.getInstance("DES");
        SecretKey desKey = skf.generateSecret(dks);
        Cipher desCipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
        desCipher.init(Cipher.ENCRYPT_MODE, desKey);
        Base64.Encoder encoder = Base64.getEncoder();
        String encodedString = encoder.encodeToString(desCipher.doFinal(message.getBytes()));
        return encodedString;
    }
}

