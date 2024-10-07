/*
 * Subject: Software Design Patterns
 * Structural Pattern -> Decorator
 * Class Type: Java
 */
package com.ceron.messages;

/**
 *
 * @author Fabrizio Bolaño
 */
public class MessageContent implements MessageInterface {
    private String messageContent;

    public MessageContent() {
    }

    public MessageContent(String message) {
        this.messageContent = message;
    }

    @Override
    public MessageInterface ProcessMessage() {
        return this;
    }

    @Override
    public String getContent() {
        return messageContent;
    }

    @Override
    public void setContent(String content) {
        this.messageContent = content;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }
}
