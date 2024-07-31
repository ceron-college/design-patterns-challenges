/*
 * Course: Software Design Patterns
 * Creational Pattern -> Abstract Factory
 * Class for creating factory services
 */
package org.example.db;

import org.example.utilities.AccessUtilities;

import java.util.Properties;

/**
 * Author: Fabrizio Bolaño
 */
public class GenericServiceFactory {
    public GenericServiceFactory() {
    }

    public static IGenericServiceFactory createServiceFactory() {
        Properties props = AccessUtilities.loadProperty("properties/AbstractFactoryProperties.properties");
        String factoryClass = props.getProperty("implementedService");
        try {
            return (IGenericServiceFactory) Class.forName(factoryClass).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
