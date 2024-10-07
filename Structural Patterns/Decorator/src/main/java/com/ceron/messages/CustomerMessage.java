/*
 * Subject: Software Design Patterns
 * Structural Pattern -> Decorator
 * Class Type: Java
 * Customer Message Characteristics
 */
package com.ceron.messages;

/**
 * @author Fabrizio Bolaño
 */
public class CustomerMessage implements MessageInterface {

    private String name;
    private String email;
    private String phone;

    public CustomerMessage(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public MessageInterface ProcessMessage() {
        return this;
    }

    @Override
    public String getContent() {
        return toString();
    }

    @Override
    public void setContent(String content) {
        throw new UnsupportedOperationException("Not supported.");
    }

    @Override
    public String toString() {
        return "CustomerMessage{" + "name=" + name + ", \nemail=" + email + ", phone=" + phone + '}';
    }
}
