/*
 * Subject: Software Design Patterns
 * Structural Pattern -> Decorator
 * Class Type: Abstract Class
 */
package com.ceron.decorators;

import com.ceron.messages.MessageInterface;

/**
 * @author Fabrizio Bolaño
 */
public abstract class MessageDecorator implements MessageInterface {
    protected MessageInterface messageFormat;

    public MessageDecorator(MessageInterface message) {
        this.messageFormat = message;
    }

    @Override
    public String getContent() {
        return messageFormat.getContent();
    }

    @Override
    public void setContent(String content) {
        messageFormat.setContent(content);
    }
}
