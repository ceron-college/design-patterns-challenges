package com.ceron.products;

import java.util.ArrayList;
import java.util.List;

/**
 * Subject: Software Design Patterns
 * Structural Pattern -> Composite
 * Class Type: Java
 * Class for configuring composite products.
 * Inherits from AbstractProduct to maintain a structure compatible with simple configuration products.
 *
 * Author: Fabrizio Bolaño
 */
public class CompositeProductConfiguration extends AbstractProduct {
    private List<AbstractProduct> products = new ArrayList<AbstractProduct>();

    /**
     * Constructor for CompositeProductConfiguration.
     * Composite products derive their price and tax from child products.
     *
     * @param name Name of the composite product
     */
    public CompositeProductConfiguration(String name) {
        super(name, 0.0, 0.0, 1); // price and taxRate are computed from child products
    }

    /**
     * Adds a product to the composite.
     *
     * @param product The product to add
     */
    public void addProduct(AbstractProduct product) {
        this.products.add(product);
    }

    /**
     * Removes a product from the composite.
     *
     * @param product The product to remove
     * @return true if removed, false otherwise
     */
    public boolean removeProduct(AbstractProduct product) {
        return this.products.remove(product);
    }

    /**
     * Calculates the total price of the composite by summing up the total prices of child products.
     *
     * @return Total price without tax
     */
    @Override
    public double calculateTotalPrice() {
        double total = 0.0;
        for (AbstractProduct product : products) {
            total += product.calculateTotalPrice();
        }
        return total;
    }

    /**
     * Calculates the total tax of the composite by summing up the taxes of child products.
     *
     * @return Total tax amount
     */
    @Override
    public double calculateTax() {
        double totalTax = 0.0;
        for (AbstractProduct product : products) {
            totalTax += product.calculateTax();
        }
        return totalTax;
    }

    /**
     * Calculates the final price including tax.
     *
     * @return Total price with tax
     */
    public double calculateFinalPrice() {
        return calculateTotalPrice() + calculateTax();
    }

    /**
     * Displays information about the composite product and its child products.
     */
    @Override
    public void displayProductInfo() {
        System.out.println("Composite Product Name: " + this.name);
        System.out.println("Number of Items: " + this.products.size());
        System.out.println("Items:");
        for (AbstractProduct product : products) {
            product.displayProductInfo();
            System.out.println("---------------------------");
        }
        System.out.println("Total Price (without tax): $" + String.format("%.2f", calculateTotalPrice()));
        System.out.println("Total Tax Amount: $" + String.format("%.2f", calculateTax()));
        System.out.println("Total Price (with tax): $" + String.format("%.2f", calculateFinalPrice()));
    }

    /**
     * Overrides getPrice to return the final price with tax.
     * This ensures that when composite products are treated as single products (e.g., added to an order),
     * their aggregated price is used.
     *
     * @return Final price with tax
     */
    @Override
    public double getPrice() {
        return calculateFinalPrice();
    }

    /**
     * Overrides setPrice to prevent manual setting of price for composite products.
     *
     * @param price Not used
     */
    @Override
    public void setPrice(double price) {
        throw new UnsupportedOperationException("Cannot set price for composite products directly.");
    }
}
