/*
 * Subject: Software Design Patterns
 * Structural Pattern -> Decorator
 * Class Type: Java
 */
package com.ceron.decorators;

import com.ceron.messages.MessageContent;
import com.ceron.messages.MessageInterface;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.ByteArrayOutputStream;

/**
 * @author Fabrizio Bolaño
 */
public class XMLFormatDecorator extends MessageDecorator {

    public XMLFormatDecorator(MessageInterface messageFormat) {
        super(messageFormat);
    }

    @Override
    public MessageInterface ProcessMessage() {
        messageFormat = messageFormat.ProcessMessage();
        messageFormat = xmlMessage();
        return messageFormat;
    }

    private MessageInterface xmlMessage() {
        try {
            XmlMapper xmlMapper = new XmlMapper();
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            xmlMapper.writeValue(output, messageFormat);
            return new MessageContent(new String(output.toByteArray()));
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("XML format conversion error");
        }
    }
}
