package com.ceron.main;

import com.ceron.decorators.*;
import com.ceron.messages.CustomerMessage;
import com.ceron.messages.MessageInterface;

public class DecoratorPatternMain {
    public static void main(String[] args) {
        CustomerMessage userMessage = new CustomerMessage("Fabrizio Bolaño", "fbolano@javeriana.edu.co", "99887766");
        System.out.println("Original Message ==> " + userMessage);

        MessageInterface message1 = new EncryptMessage("user", "HG58YZ3CR9123456", new CompanyInfoDecorator(new SOAPCredentialsDecorator(new SOAPMessage(new XMLFormatDecorator(userMessage)), "user", "HG58YZ3CR9123456"), "Javeriana", "Carrera 7", "3008522437", "jav@javeriana.edu.co")).ProcessMessage();
        System.out.println("Message No. 1 =====================================>\n" + message1.getContent() + "\n\n");

        MessageInterface message2 = new SOAPCredentialsDecorator(new CompanyInfoDecorator(new SOAPMessage(new EncryptMessage("user", "HG58YZ3CR9123456", new XMLFormatDecorator(userMessage))), "Javeriana", "Carrera 7", "3008522437", "jav@javeriana.edu.co"), "user", "HG58YZ3CR9123456").ProcessMessage();
        System.out.println("Message 2 =====================================>\n" + message2.getContent() + "\n\n");

        MessageInterface message3 = new CompanyInfoDecorator(new SOAPCredentialsDecorator(new SOAPMessage(new XMLFormatDecorator(userMessage)), "juand", "password"), "Javeriana", "Carrera 7", "3008522437", "jav@javeriana.edu.co").ProcessMessage();
        System.out.println("Message 3 =====================================>\n" + message3.getContent() + "\n\n");
    }
}