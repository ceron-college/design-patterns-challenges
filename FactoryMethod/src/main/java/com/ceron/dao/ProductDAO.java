// Package: dao
// Class: ProductDAO.java

/*
 * Course: Software Design Patterns
 * Creational Pattern -> Factory Method
 * DAO -> Data Access Object
 * Code to configure access to the database tables (Mysql/Postgresql)
 */
package com.ceron.dao;

import com.ceron.entities.Product;
import com.ceron.factorymethod.DBAdapter;
import com.ceron.factorymethod.DatabaseFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author Fabrizio Bolaño
 */
public class ProductDAO {
    private DBAdapter dbAdapter;

    public ProductDAO(){
        dbAdapter = DatabaseFactory.getDefaultDBAdapter();
    }

    public List<Product> findAllProducts(){
        Connection connection = dbAdapter.getConnection();
        List<Product> productList = new ArrayList<>();
        try {
            PreparedStatement statement = connection
                    .prepareStatement("SELECT id, name, value FROM products");
            ResultSet results = statement.executeQuery();
            while(results.next()){
                productList.add(new Product(results.getLong(1),
                        results.getString(2), results.getDouble(3)));
            }
            return productList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }finally{
            try {
                connection.close();
            } catch (Exception e) {}
        }
    }

    public boolean saveProduct(Product product){
        Connection connection = dbAdapter.getConnection();
        try {
            PreparedStatement statement = connection
                    .prepareStatement("INSERT INTO products(id, name, value) VALUES (?,?,?)");
            statement.setLong(1, product.getId());
            statement.setString(2, product.getName());
            statement.setDouble(3, product.getValue());
            statement.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }finally{
            try {
                connection.close();
            } catch (Exception e) {}
        }
    }

}