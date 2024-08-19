//----------------------------------------------------------
//-----------------Package: com.ceron.implementation -------
//----------- Class: ProductCatalog.java -------------------
//----------------------------------------------------------
/*
 * Subject: Software Design Patterns
 * Creational Pattern -> Prototype
 * Class Type: Java
 * Class for managing the catalog of offered products.
 */
package com.ceron.implementation;

/**
 * @author Fabrizio Bolaño
 */
public class ProductCatalog implements InterfacePrototype<ProductCatalog> {
    private String productName;
    private double productPrice;

    public ProductCatalog() {
    }

    public ProductCatalog(String name, double price) {
        this();
        this.productName = name;
        this.productPrice = price;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    @Override
    public ProductCatalog clone() {
        return new ProductCatalog(this.productName, this.productPrice);
    }

    @Override
    public ProductCatalog deepClone() {
        return clone();
    }

    @Override
    public String toString() {
        return "Catalog{" + "productName=" + productName + ", productPrice=" + productPrice + '}';
    }
}