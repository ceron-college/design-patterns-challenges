package com.ceron.products;

/**
 * Subject: Software Design Patterns
 * Structural Pattern -> Composite
 * Class Type: Abstract
 * Author: Fabrizio Bolaño
 */
public abstract class AbstractProduct {
    protected String name;
    protected double price;
    protected double taxRate; // Tax rate (e.g., 0.1 for 10%)
    protected int quantity;    // Quantity of the product

    /**
     * Constructor with taxRate and quantity.
     *
     * @param name      Name of the product
     * @param price     Price per unit
     * @param taxRate   Tax rate (e.g., 0.1 for 10%)
     * @param quantity  Quantity of the product
     */
    public AbstractProduct(String name, double price, double taxRate, int quantity) {
        this.name = name;
        this.price = price;
        this.taxRate = taxRate;
        this.quantity = quantity;
    }

    // Getters and Setters for name, price, taxRate, and quantity

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(double taxRate) {
        this.taxRate = taxRate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Calculates the total tax for the product.
     *
     * @return Total tax amount
     */
    public double calculateTax() {
        return this.price * this.taxRate * this.quantity;
    }

    /**
     * Calculates the total price without tax.
     *
     * @return Total price (price * quantity)
     */
    public double calculateTotalPrice() {
        return this.price * this.quantity;
    }

    /**
     * Displays product information, including total price and tax.
     */
    public void displayProductInfo() {
        System.out.println("Product Name: " + this.name);
        System.out.println("Product Price per Unit: $" + String.format("%.2f", this.price));
        System.out.println("Quantity: " + this.quantity);
        System.out.println("Total Price (without tax): $" + String.format("%.2f", calculateTotalPrice()));
        System.out.println("Tax Rate: " + (this.taxRate * 100) + "%");
        System.out.println("Total Tax Amount: $" + String.format("%.2f", calculateTax()));
        System.out.println("Total Price (with tax): $" + String.format("%.2f", (calculateTotalPrice() + calculateTax())));
    }
}
