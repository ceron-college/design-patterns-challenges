package com.ceron.orders;

import com.ceron.products.AbstractProduct;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a sales order containing multiple products.
 * Author: Fabrizio Bolaño
 */
public class SalesOrder {
    private int orderId;
    private String customerName;
    private List<AbstractProduct> products;

    /**
     * Constructor for SalesOrder.
     *
     * @param orderId      Unique identifier for the order
     * @param customerName Name of the customer
     */
    public SalesOrder(int orderId, String customerName) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.products = new ArrayList<>();
    }

    /**
     * Adds a product to the sales order.
     *
     * @param product The product to add
     */
    public void addProduct(AbstractProduct product) {
        this.products.add(product);
    }

    /**
     * Prints the sales order details, including total price and tax.
     */
    public void printSalesOrder() {
        System.out.println("========================================");
        System.out.println("Order ID: " + this.orderId);
        System.out.println("Customer Name: " + this.customerName);
        System.out.println("Products in Order:");
        double totalPrice = 0.0;
        double totalTax = 0.0;

        for (AbstractProduct product : products) {
            product.displayProductInfo();
            System.out.println("---------------------------");
            totalPrice += product.calculateTotalPrice();
            totalTax += product.calculateTax();
        }

        System.out.println("Order Total (without tax): $" + String.format("%.2f", totalPrice));
        System.out.println("Order Total Tax: $" + String.format("%.2f", totalTax));
        System.out.println("Order Final Total (with tax): $" + String.format("%.2f", (totalPrice + totalTax)));
        System.out.println("========================================\n");
    }
}
