/*
 * Subject: Software Design Patterns
 * Creational Pattern -> Builder
 * Class: Contacts
 */
package com.ceron.data.transfer;

/**
 * Author: Fabrizio Bolaño
 */
public class Contacts {
    private String names;
    private Phones phones;
    private Address address;

    public Contacts() {
    }

    public Contacts(String names, Phones phones, Address address) {
        this.names = names;
        this.phones = phones;
        this.address = address;
    }

    public Contacts(String names, Phones phones) {
        this.names = names;
        this.phones = phones;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public Phones getPhones() {
        return phones;
    }

    public void setPhones(Phones phones) {
        this.phones = phones;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Contacts{" + "Names=" + names + ", Phones=" + phones + '}';
    }
}
