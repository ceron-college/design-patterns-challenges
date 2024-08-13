// Package: factorymethod
// Class: DatabaseFactory.java

/*
 * Course: Software Design Patterns
 * Creational Pattern -> Factory Method
 */
package com.ceron.factorymethod;
import java.util.Properties;
import com.ceron.implementation.MysqlAdapter;
import com.ceron.implementation.PostgresqlAdapter;
import com.ceron.utilities.AccessUtilities;
/**
 *
 * @author Fabrizio Bolaño
 */
public class DatabaseFactory {

    private static final String DB_FACTORY_PROPERTY_URL = "properties/ConfigFactory.properties";
    private static final String DEFAULT_DB_CLASS_PROP = "defaultDBClass";

    public static DBAdapter getDBadapter(DatabaseTypes dbType) {
        switch (dbType) {
            case MySQL:
                return new MysqlAdapter();
            case PostgreSQL:
                return new PostgresqlAdapter();
            default:
                throw new IllegalArgumentException("Not supported");
        }
    }

    public static DBAdapter getDefaultDBAdapter() {
        try {
            Properties prop = AccessUtilities.loadProperty(DB_FACTORY_PROPERTY_URL);
            String defaultDBClass = prop.getProperty(DEFAULT_DB_CLASS_PROP);
            System.out.println("DefaultDBClass ==> " + defaultDBClass);
            return (DBAdapter) Class.forName(defaultDBClass).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}