package com.ceron.products;

/**
 * Represents the most basic form of a product.
 * Cannot be composed of other elements.
 * Implements the Composite Pattern as a Leaf node.
 *
 * Author: Fabrizio Bolaño
 */
public class SimpleProductConfiguration extends AbstractProduct {
    protected String brand;

    /**
     * Constructor with default taxRate and quantity.
     *
     * @param name  Name of the product
     * @param price Price per unit
     * @param brand Brand of the product
     */
    public SimpleProductConfiguration(String name, double price, String brand) {
        super(name, price, 0.15, 1); // Default taxRate = 15%, quantity = 1
        this.brand = brand;
    }

    /**
     * Constructor with specified taxRate and quantity.
     *
     * @param name      Name of the product
     * @param price     Price per unit
     * @param brand     Brand of the product
     * @param taxRate   Tax rate (e.g., 0.1 for 10%)
     * @param quantity  Quantity of the product
     */
    public SimpleProductConfiguration(String name, double price, String brand, double taxRate, int quantity) {
        super(name, price, taxRate, quantity);
        this.brand = brand;
    }

    // Getter and Setter for brand
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * Displays product information, including brand.
     */
    @Override
    public void displayProductInfo() {
        super.displayProductInfo();
        System.out.println("Brand: " + this.brand);
    }
}
