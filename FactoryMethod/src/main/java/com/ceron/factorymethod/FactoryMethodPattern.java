// Package: factorymethod
// Class: FactoryMethodPattern.java
// Class Type: Main()

/*
 * Course: Software Design Patterns
 * Creational Pattern -> Factory Method
 */
package com.ceron.factorymethod;

import java.sql.SQLException;
import java.util.List;

import com.ceron.dao.ProductDAO;
import com.ceron.entities.Product;

/**
 *
 * @author Fabrizio Bolaño
 */
public class FactoryMethodPattern {

    public static void main(String[] args) throws SQLException {

        // Creation of the DAO instance  
        ProductDAO productDAO = new ProductDAO();

        List<Product> products = productDAO.findAllProducts();
        long totalRecords = products.size() + 1;
        // Create the new products to register
        Product productA = new Product(totalRecords, "Product A" + totalRecords, 120);
        totalRecords = totalRecords + 1;
        Product productB = new Product(totalRecords, "Product B" + totalRecords, 130);

        // Persist the products
        productDAO.saveProduct(productA);
        productDAO.saveProduct(productB);

        // Retrieve the products
        List<Product> elements = productDAO.findAllProducts();
        System.out.println("Number of Products ==> " + elements.size());
        for(Product record : elements){
            System.out.println(record);
        }

    }

}