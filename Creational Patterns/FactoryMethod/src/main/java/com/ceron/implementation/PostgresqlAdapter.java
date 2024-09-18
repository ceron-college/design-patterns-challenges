// Package: implementation
// Class: PostgresqlAdapter.java

/*
 * Course: Software Design Patterns
 * Creational Pattern -> Factory Method
 */
package com.ceron.implementation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import com.ceron.factorymethod.DBAdapter;
import com.ceron.utilities.AccessUtilities;

/**
 *
 * @author Fabrizio Bolaño
 */
public class PostgresqlAdapter implements DBAdapter {

    private static final String DB_PROPERTIES = "properties/PostgresqlData.properties";

    private static final String DB_SERVICE_PROP = "service";
    private static final String DB_HOST_PROP = "host";
    private static final String DB_PASSWORD_PROP = "password";
    private static final String DB_PORT_PROP = "port";
    private static final String DB_USER_PROP = "user";

    static {
        // Block to register the Oracle Driver
        try {
            Class.forName("org.postgresql.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Connection getConnection() {
        try {
            Properties prop = AccessUtilities.loadProperty(DB_PROPERTIES);
            String user = prop.getProperty(DB_USER_PROP);
            String password = prop.getProperty(DB_PASSWORD_PROP);
            String connectionString = createConnectionString();
            Connection connection = DriverManager.getConnection(connectionString, user, password);
            System.out.println("Connection class ==> " + connection.getClass().getName());
            return connection;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private String createConnectionString() {
        Properties prop = AccessUtilities.loadProperty(DB_PROPERTIES);
        String host = prop.getProperty(DB_HOST_PROP);
        String port = prop.getProperty(DB_PORT_PROP);
        String service = prop.getProperty(DB_SERVICE_PROP);

        String connectionString = "jdbc:postgresql://" + host + ":" + port + "/" + service;
        System.out.println("ConnectionString ==> " + connectionString);
        return connectionString;
    }

}