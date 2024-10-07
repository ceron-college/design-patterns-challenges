/*
 * Subject: Software Design Patterns
 * Structural Pattern -> Decorator
 * Class Type: Java
 */

package com.ceron.decorators;

import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import com.ceron.messages.MessageInterface;
import java.util.Base64;

/**
 *
 * @author Fabrizio Bolaño
 */
public class EncryptMessage extends MessageDecorator {

    private String user;
    private String password;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public EncryptMessage(String user, String password, MessageInterface messageFormat) {
        super(messageFormat);
        this.user = user;
        this.password = password;
    }

    @Override
    public MessageInterface ProcessMessage() {
        this.messageFormat = messageFormat.ProcessMessage();
        encryptMessage();
        return messageFormat;
    }

    private MessageInterface encryptMessage() {
        try {
            Key key = new SecretKeySpec(password.getBytes(), "AES");
            Cipher c = Cipher.getInstance("AES");

            c.init(Cipher.ENCRYPT_MODE, key);
            byte[] encVal = c.doFinal(messageFormat.getContent().getBytes());
            Base64.Encoder encoder = Base64.getEncoder();
            String encryptedValue = encoder.encodeToString(encVal);

            messageFormat.setContent(encryptedValue);
            return messageFormat;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}
