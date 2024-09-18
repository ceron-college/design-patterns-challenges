/*
 * Course: Software Design Patterns
 * Creational Pattern -> Singleton
 * Class Type: Property Configuration
 */
package com.ceron.utilities;

import java.io.InputStream;
import java.util.Properties;

/**
 * @author Fabrizio Bolaño
 */
public class AccessUtilities {
    public static Properties loadProperty(String propertiesURL) {
        try {
            Properties properties = new Properties();
            InputStream inputStream = AccessUtilities.class.getClassLoader().getResourceAsStream(propertiesURL);
            properties.load(inputStream);
            return properties;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}