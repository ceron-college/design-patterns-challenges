//----------------------------------------------------------
//-----------------Package: com.ceron.implementation -------
//----------- Class: PriceList.java ------------------------
//----------------------------------------------------------
/*
 * Subject: Software Design Patterns
 * Creational Pattern -> Prototype
 * Class Type: Java
 * Class for managing the price list and its variants.
 */
package com.ceron.implementation;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Fabrizio Bolaño
 */
public class PriceList implements InterfacePrototype<PriceList> {

    private String listName;
    private List<ProductCatalog> products = new ArrayList<ProductCatalog>();

    public PriceList(String listName) {
        this.listName = listName;
    }

    public String getListName() {
        return listName;
    }

    public void setListName(String listName) {
        this.listName = listName;
    }

    public List<ProductCatalog> getProducts() {
        return products;
    }

    public void setProducts(List<ProductCatalog> products) {
        this.products = products;
    }

    public void addCatalogItem(ProductCatalog item) {
        this.products.add(item);
    }

    @Override
    public PriceList clone() {
        PriceList clone = new PriceList(listName);
        clone.setProducts(products);
        return clone;
    }

    @Override
    public PriceList deepClone() {
        List<ProductCatalog> cloneProducts = new ArrayList<>();
        for (ProductCatalog item : this.products) {
            ProductCatalog cloneItem = item.clone();
            cloneProducts.add(cloneItem);
        }
        PriceList clone = new PriceList(listName);
        clone.setProducts(cloneProducts);
        return clone;
    }

    @Override
    public String toString() {
        String items = "";
        String newline = System.getProperty("line.separator");
        for (ProductCatalog item : this.products) {
            items += "\t" + item.toString() + "\n";
        }
        return "Price List{List Type:=" + listName + ", Products=\n" + items + '}';
    }
}