/*
 * Subject: Software Design Patterns
 * Structural Pattern -> Decorator
 * Class Type: Java
 */
package com.ceron.decorators;

import com.ceron.messages.MessageInterface;

/**
 *
 * @author Fabrizio Bolaño
 */
public class SOAPMessage extends MessageDecorator {

    public SOAPMessage(MessageInterface messageFormat) {
        super(messageFormat);
    }

    @Override
    public MessageInterface ProcessMessage() {
        messageFormat.ProcessMessage();
        messageFormat = EnvelopMessage();
        return messageFormat;
    }

    private MessageInterface EnvelopMessage() {
        String soap = "<soapenv:Envelope xmlns:soapenv="
                + "\n\"http://schemas.xmlsoap.org/soap/envelope/\" "
                + "\nxmlns:ser=\"http://service.dishweb.cl.com/\">\n"
                + "   <soapenv:Header/>\n"
                + "   <soapenv:Body>\n"
                + messageFormat.getContent()
                + "\n"
                + "   </soapenv:Body>\n"
                + "</soapenv:Envelope>";
        messageFormat.setContent(soap);
        return messageFormat;
    }
}

