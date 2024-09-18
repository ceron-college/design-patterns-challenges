/*
 * Subject: Software Design Patterns
 * Structural Pattern -> Bridge
 * Class Type: Main()
 */

package com.ceron.bridge;

import com.ceron.encryption.AESEncryptionProcess;
import com.ceron.encryption.BlowfishEncryptionProcess;
import com.ceron.encryption.DESEncryptionProcess;
import com.ceron.encryption.NoEncryptionProcess;
import com.ceron.implementation.EncryptionMessageBridge;
import com.ceron.implementation.EncryptionMessageInterface;

/**
 * @author Fabrizio Bolaño
 */
public class BridgePatternMain {

    public static void main(String[] args) {
        EncryptionMessageInterface AESFormat = new EncryptionMessageBridge(new AESEncryptionProcess());
        EncryptionMessageInterface DESFormat = new EncryptionMessageBridge(new DESEncryptionProcess());
        EncryptionMessageInterface NoFormat = new EncryptionMessageBridge(new NoEncryptionProcess());
        EncryptionMessageInterface BlowfishFormat = new EncryptionMessageBridge(new BlowfishEncryptionProcess());


        try {
            final String message = "<Course><Name>Software Design Patterns</Name></Course>";
            String messageAES = AESFormat.EncryptMessage(message, "HG58YZ3CR9123456");
            System.out.println("AES Format > " + messageAES + "\n");

            String messageDES = DESFormat.EncryptMessage(message, "XMzDdG4D03CKm2Ix");
            System.out.println("DES Format > " + messageDES + "\n");

            String messageNO = NoFormat.EncryptMessage(message, null);
            System.out.println("No Format > " + messageNO + "\n");

            String messageBlowfish = BlowfishFormat.EncryptMessage(message, "4D03R91");
            System.out.println("Blowfish Format > " + messageBlowfish + "\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}