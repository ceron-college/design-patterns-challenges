package com.ceron.main;

import com.ceron.orders.SalesOrder;
import com.ceron.products.CompositeProductConfiguration;
import com.ceron.products.SimpleProductConfiguration;

import java.util.Random;

/**
 * Subject: Software Design Patterns
 * Structural Pattern -> Composite
 * Class Type: Main()
 * Author: Fabrizio Bolaño
 */
public class CompositePattern {
    private final Random random = new Random();

    private SimpleProductConfiguration ram4gb;
    private SimpleProductConfiguration ram8gb;
    private SimpleProductConfiguration disk500gb;
    private SimpleProductConfiguration disk1tb;
    private SimpleProductConfiguration cpuAMD;
    private SimpleProductConfiguration cpuIntel;
    private SimpleProductConfiguration smallCabinet;
    private SimpleProductConfiguration bigCabinet;
    private SimpleProductConfiguration monitor20inch;
    private SimpleProductConfiguration monitor30inch;
    private SimpleProductConfiguration simpleMouse;
    private SimpleProductConfiguration gammerMouse;
    private SimpleProductConfiguration discountProduct;  // Discount product

    private CompositeProductConfiguration gammerPC;
    private CompositeProductConfiguration homePC;
    private CompositeProductConfiguration pc2x1;

    public static void main(String[] args) {
        CompositePattern main = new CompositePattern();
        main.createProducts();

        // Uncomment the desired sales order to test
        // main.salesOrderForSimpleProductConfiguration();
        // main.salesOrderHomePC();
        // main.salesOrderGammerPC();  // Use this method to see the discount applied
        // main.salesOrderCombo();
        main.salesOrderMega();
    }

    /**
     * Creates simple and composite products, including discounts.
     */
    private void createProducts() {
        // Define tax rates for each product
        // For simplicity, assigning arbitrary tax rates
        // In a real-world scenario, these would be based on product categories or regulations
        double taxRAM = 0.10;        // 10%
        double taxHDD = 0.08;        // 8%
        double taxCPU = 0.12;        // 12%
        double taxCabinet = 0.05;    // 5%
        double taxMonitor = 0.07;    // 7%
        double taxMouse = 0.06;      // 6%
        double taxDiscount = 0.00;   // 0% tax on discounts

        // Simple product configurations with distinct tax rates
        ram4gb = new SimpleProductConfiguration("RAM 4GB", 750, "Kingston", taxRAM, 1);
        ram8gb = new SimpleProductConfiguration("RAM 8GB", 1000, "Kingston", taxRAM, 1);
        disk500gb = new SimpleProductConfiguration("HDD 500GB", 1500, "ACME", taxHDD, 1);
        disk1tb = new SimpleProductConfiguration("HDD 1TB", 2000, "ACME", taxHDD, 1);
        cpuAMD = new SimpleProductConfiguration("AMD Phenom", 4000, "AMD", taxCPU, 1);
        cpuIntel = new SimpleProductConfiguration("Intel i7", 4500, "Intel", taxCPU, 1);
        smallCabinet = new SimpleProductConfiguration("Small Cabinet", 2000, "ExCom", taxCabinet, 1);
        bigCabinet = new SimpleProductConfiguration("Big Cabinet", 2200, "ExCom", taxCabinet, 1);
        monitor20inch = new SimpleProductConfiguration("Display 20'", 1500, "HP", taxMonitor, 1);
        monitor30inch = new SimpleProductConfiguration("Display 30'", 2000, "HP", taxMonitor, 1);
        simpleMouse = new SimpleProductConfiguration("Simple Mouse", 150, "Genius", taxMouse, 1);
        gammerMouse = new SimpleProductConfiguration("Gamer Mouse", 750, "Alien", taxMouse, 1);

        // Discount product configuration: Negative price to apply discount
        discountProduct = new SimpleProductConfiguration("Special Discount", -500, "Promo", taxDiscount, 1);

        // Composite product: Gamer PC with 8GB RAM, 1TB HDD, Intel i7 processor
        // Big cabinet, 30' display, and one gamer mouse, plus a discount.
        gammerPC = new CompositeProductConfiguration("Gamer PC");
        gammerPC.addProduct(ram8gb);
        gammerPC.addProduct(disk1tb);
        gammerPC.addProduct(cpuIntel);
        gammerPC.addProduct(bigCabinet);
        gammerPC.addProduct(monitor30inch);
        gammerPC.addProduct(gammerMouse);
        gammerPC.addProduct(discountProduct);  // Adding discount to Gamer PC

        // Composite product: Home PC with 4GB RAM, 500GB HDD, AMD Phenom processor
        // Small cabinet, 20' display, and simple mouse.
        homePC = new CompositeProductConfiguration("Home PC");
        homePC.addProduct(ram4gb);
        homePC.addProduct(disk500gb);
        homePC.addProduct(cpuAMD);
        homePC.addProduct(smallCabinet);
        homePC.addProduct(monitor20inch);
        homePC.addProduct(simpleMouse);

        // Combo consisting of 2 packages: Gamer PC + Home PC
        pc2x1 = new CompositeProductConfiguration("Pack PC Gamer + Home PC");
        pc2x1.addProduct(gammerPC);
        pc2x1.addProduct(homePC);
    }

    /**
     * Creates a sales order with simple products.
     */
    private void salesOrderForSimpleProductConfiguration() {
        SalesOrder simpleConfigurationOrder = new SalesOrder(random.nextInt(1000), "Hector Lavoe");
        simpleConfigurationOrder.addProduct(ram4gb);
        simpleConfigurationOrder.addProduct(disk1tb);
        simpleConfigurationOrder.addProduct(simpleMouse);
        simpleConfigurationOrder.printSalesOrder();
    }

    /**
     * Creates a sales order with Gamer PC, which includes a discount.
     */
    private void salesOrderGammerPC() {
        SalesOrder gamerSalesOrder = new SalesOrder(1, "Ismael Rivera");
        gamerSalesOrder.addProduct(gammerPC);  // The Gamer PC has a discount
        gamerSalesOrder.printSalesOrder();
    }

    /**
     * Creates a sales order with Home PC.
     */
    private void salesOrderHomePC() {
        SalesOrder homeSalesOrder = new SalesOrder(2, "Celia Cruz");
        homeSalesOrder.addProduct(homePC);
        homeSalesOrder.printSalesOrder();
    }

    /**
     * Creates a sales order with a combo package: Gamer PC + Home PC.
     */
    private void salesOrderCombo() {
        SalesOrder comboSalesOrder = new SalesOrder(3, "2-for-1 PC Package");
        comboSalesOrder.addProduct(pc2x1);
        comboSalesOrder.printSalesOrder();
    }

    /**
     * Creates a comprehensive sales order with multiple products and a discount.
     */
    private void salesOrderMega() {
        SalesOrder customSalesOrder = new SalesOrder(4, "Tito Nieves");
        customSalesOrder.addProduct(homePC);
        customSalesOrder.addProduct(ram8gb);
        customSalesOrder.addProduct(ram4gb);
        customSalesOrder.addProduct(monitor30inch);
        customSalesOrder.addProduct(gammerMouse);
        customSalesOrder.printSalesOrder();
    }
}
