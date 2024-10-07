/*
 * Subject: Software Design Patterns
 * Structural Pattern -> Decorator
 * Class Type: Interface
 */

package com.ceron.messages;

/**
 *
 * @author Fabrizio Bolaño
 */
public interface MessageInterface {

    public MessageInterface ProcessMessage();
    public String getContent();
    public void setContent(String content);
}


