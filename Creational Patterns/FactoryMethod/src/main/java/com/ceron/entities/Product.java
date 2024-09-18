// Package: entities
// Class: Product.java

/*
 * Course: Software Design Patterns
 * Creational Pattern -> Factory Method
 * Class for mapping the Products table of the DB (Mysql / Postgres)
 */
package com.ceron.entities;

/**
 *
 * @author Fabrizio Bolaño
 */
public class Product {
    private Long id;
    private String name;
    private double value;

    public Product(Long id, String name, double value) {
        this.id = id;
        this.name = name;
        this.value = value;
    }

    public Product() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", name=" + name + ", value=" + value + '}';
    }
}