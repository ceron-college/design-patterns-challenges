/*
 * Course: Software Design Patterns
 * Creational Pattern -> Singleton
 * Class Type: Java
 * Sub-objective is the configuration and parameterization of the pattern.
 */
package com.ceron.singleton;

import com.ceron.utilities.AccessUtilities;

import java.util.Properties;

/**
 * @author Fabrizio Bolaño
 */
public class SingletonConfiguration {
    private static final String CONFIGURATION_PROP = "properties/ConfigProperties.properties";
    private static final String APP_NAME_PROP = "appName";
    private static final String VERSION_NUMBER_PROP = "versionNumber";
    private static SingletonConfiguration singleton;
    private String appName;
    private String versionNumber;

    private SingletonConfiguration() {
        Properties prop = AccessUtilities.loadProperty(CONFIGURATION_PROP);
        this.appName = prop.getProperty(APP_NAME_PROP);
        this.versionNumber = prop.getProperty(VERSION_NUMBER_PROP);
    }

    private static synchronized void createInstance() {
        if (singleton == null) {
            singleton = new SingletonConfiguration();
        }
    }

    public static SingletonConfiguration getInstance() {
        if (singleton == null) {
            createInstance();
        }
        return singleton;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getVersionNumber() {
        return versionNumber;
    }

    public void setVersionNumber(String versionNumber) {
        this.versionNumber = versionNumber;
    }

    @Override
    public String toString() {
        return "SingletonConfiguration{" + "appName=" + appName + ", versionNumber=" + versionNumber + '}';
    }
}