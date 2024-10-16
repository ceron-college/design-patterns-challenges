/*
 * Subject: Software Design Patterns
 * Structural Pattern -> Facade
 * Class Type: Java
 */

package com.ceron.mail;

import java.util.Map;

/**
 *
 */
public class EmailSystem {

    public void sendEmail(Map<String, String> values) {
        String template = "\n**************************************\n"
                + "|To: $name\n"
                + "|From: Facade_System\n"
                + "|\n"
                + "|Thank you for using our online services\n"
                + "|to make your payments.\n"
                + "|\n"
                + "|We have just received a payment:\n"
                + "|\n"
                + "|Total payment amount: $Amount.\n"
                + "|Amount covered by points: $AmountCoveredByPoints.\n"
                + "|Points used: $PointsUsed.\n"
                + "|New balance: $NewBalance.\n"
                + "|Card last numbers: $CardNumber\n"
                + "|Payment reference: $Reference\n"
                + "|New status: $NewStatus\n"
                + "|\n"
                + "|Thank you for choosing us.\n"
                + "|\n"
                + "|Please do not reply to this email, \n"
                + "|it is part of an automatic process"
                + "\n**************************************";

        // Replace each placeholder with the corresponding value
        for(Map.Entry<String, String> entry : values.entrySet()){
            String placeholder = "$" + entry.getKey();
            String value = entry.getValue();
            template = template.replace(placeholder, value);
        }

        System.out.println(template);
    }
}
