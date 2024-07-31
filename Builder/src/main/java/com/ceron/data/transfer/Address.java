/*
 * Subject: Software Design Patterns
 * Creational Pattern -> Builder
 * Class: Address
 */
package com.ceron.data.transfer;

/**
 * Author: Fabrizio Bolaño
 */
public class Address {
    private String address;
    private String city;
    private String country;
    private String locality;

    public Address() {
    }

    public Address(String address, String city, String country, String locality) {
        this.address = address;
        this.city = city;
        this.country = country;
        this.locality = locality;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    @Override
    public String toString() {
        return "Address{" + "address=" + address + ", City=" + city + ", Country=" + country + ", Locality=" + locality + '}';
    }
}