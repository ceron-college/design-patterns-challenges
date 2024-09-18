/*
 * Subject: Software Design Patterns
 * Creational Pattern -> Builder
 * Class: Phones
 */
package com.ceron.data.transfer;

/**
 * Author: Fabrizio Bolaño
 */
public class Phones {
    private String phoneNumber;
    private String extension;
    private String type;

    public Phones() {
    }

    public Phones(String phoneNumber, String extension, String type) {
        this.phoneNumber = phoneNumber;
        this.extension = extension;
        this.type = type;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Phone{" + "Phone_Number=" + phoneNumber + ", Extension=" + extension + ", Type=" + type + '}';
    }
}