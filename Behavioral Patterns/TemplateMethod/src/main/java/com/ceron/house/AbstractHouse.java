// Package: com.ceron
// Class: AbstractHouse

package com.ceron.house;

public abstract class AbstractHouse {
    // Template method that defines the skeleton of the construction
    public final void buildHouse() {
        buildFoundation();
        buildStructure();
        installDoors();
        installWindows();
        if (hasGarage()) { // Hook
            buildGarage();
        }
        paintHouse();
        System.out.println("House built.\n");
    }

    // Common steps that subclasses can override
    protected abstract void buildFoundation();
    protected abstract void buildStructure();
    protected abstract void installDoors();
    protected abstract void installWindows();
    protected abstract void paintHouse();

    // Optional method (hook) that can be overridden
    protected boolean hasGarage() {
        return true; // Default value
    }

    // Additional method only if there is a garage
    protected void buildGarage() {
        System.out.println("Building a garage.");
    }
}
