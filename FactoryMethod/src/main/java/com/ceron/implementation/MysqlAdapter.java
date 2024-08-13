// Package: implementation
// Class: MysqlAdapter.java

/*
 * Course: Software Design Patterns
 * Creational Pattern -> Factory Method
 */
package com.ceron.implementation;

import com.ceron.factorymethod.DBAdapter;
import com.ceron.utilities.AccessUtilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 * @author Fabrizio Bolaño
 */
public class MysqlAdapter implements DBAdapter {

    private static final String DB_PROPERTIES = "properties/MysqlData.properties";

    // Properties of the configuration file for Mysql
    private static final String DB_NAME_PROP = "dbname";
    private static final String DB_HOST_PROP = "host";
    private static final String DB_PASSWORD_PROP = "password";
    private static final String DB_PORT_PROP = "port";
    private static final String DB_USER_PROP = "user";

    static {
        // Block to register the MySQL Driver
        try {
            new com.mysql.jdbc.Driver();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Connection getConnection() {
        try {
            String connectionString = createConnectionString();
            Connection connection = DriverManager.getConnection(connectionString);
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
        String db = prop.getProperty(DB_NAME_PROP);
        String user = prop.getProperty(DB_USER_PROP);
        String password = prop.getProperty(DB_PASSWORD_PROP);

        String connectionString = "jdbc:mysql://" + host + ":" + port + "/" + db + "?user=" + user + "&password=" + password;
        System.out.println("ConnectionString ==> " + connectionString);
        return connectionString;
    }

}
