//-------------------------------------------------------
//-------------Package: com.ceron.prototypepattern --------
//----------- Class: PrototypePatternMain.java -----------
//----------------- Type: Main() ------------------------
//-------------------------------------------------------
/*
 * Subject: Software Design Patterns
 * Creational Pattern -> Prototype
 * Class Type: Main()
 */
package com.ceron.prototype;

import com.ceron.implementation.PriceList;
import com.ceron.implementation.ProductCatalog;
import com.ceron.implementation.PrototypeFactory;

/**
 * @author Fabrizio Bolaño
 */
public class PrototypePatternMain {

    public static void main(String[] args) {

        // Creation of the Initial Price List
        PriceList standardList = new PriceList("Standard Price List");
        for (int i = 1; i <= 5; i++) {
            ProductCatalog item = new ProductCatalog("Product " + i, i * 2);
            standardList.addCatalogItem(item);
        }

        // Adding the standard list to the prototype factory
        PrototypeFactory.addPrototype(standardList.getListName(), standardList);

        // Creating the Wholesale Price List with a 10% discount
        PriceList wholesaleList = (PriceList) PrototypeFactory.getPrototype("Standard Price List");
        wholesaleList.setListName("Wholesale Price List");
        for (ProductCatalog item : wholesaleList.getProducts()) {
            item.setProductPrice(item.getProductPrice() * 0.90);
        }
        PrototypeFactory.addPrototype(wholesaleList.getListName(), wholesaleList);

        // Creating the Special Customer Price List with an additional 10% discount
        PriceList specialCustomerList = (PriceList) PrototypeFactory.getPrototype("Wholesale Price List");
        specialCustomerList.setListName("Special Customer Price List");
        for (ProductCatalog item : specialCustomerList.getProducts()) {
            item.setProductPrice(item.getProductPrice() * 0.90);
        }

        // Creating the 19% Tax Price List
        PriceList tax19CustomerList = (PriceList) PrototypeFactory.getPrototype("Standard Price List");
        tax19CustomerList.setListName("19% Tax Price List");
        for (ProductCatalog item : tax19CustomerList.getProducts()) {
            item.setProductPrice(item.getProductPrice() * 1.19);
        }
        PrototypeFactory.addPrototype(tax19CustomerList.getListName(), tax19CustomerList);

        // Creating the 5% Tax Price List
        PriceList tax5CustomerList = (PriceList) PrototypeFactory.getPrototype("Standard Price List");
        tax5CustomerList.setListName("5% Tax Price List");
        for (ProductCatalog item : tax5CustomerList.getProducts()) {
            item.setProductPrice(item.getProductPrice() * 1.05);
        }
        PrototypeFactory.addPrototype(tax5CustomerList.getListName(), tax5CustomerList);

        // Print the different lists
        System.out.println(standardList);
        System.out.println(wholesaleList);
        System.out.println(specialCustomerList);
        System.out.println(tax19CustomerList);
        System.out.println(tax5CustomerList);
    }
}
