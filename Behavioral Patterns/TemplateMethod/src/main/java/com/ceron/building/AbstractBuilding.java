// Package: com.ceron
// Class: AbstractBuilding

package com.ceron.building;

public abstract class AbstractBuilding {
    // Template method defining the skeleton of the construction process
    public final void constructBuilding() {
        prepareSite();
        buildFoundation();
        buildStructure();
        installUtilities();
        if (hasElevator()) { // Hook
            installElevator();
        }
        finishExterior();
        finishInterior();
        System.out.println(getBuildingType() + " construction completed.\n");
    }

    // Common steps that may be overridden by subclasses
    protected void prepareSite() {
        System.out.println("Preparing the construction site.");
    }

    protected abstract void buildFoundation();
    protected abstract void buildStructure();
    protected abstract void installUtilities();
    protected abstract void finishExterior();
    protected abstract void finishInterior();

    // Hook method that can be overridden by subclasses
    protected boolean hasElevator() {
        return false; // Default implementation
    }

    // Optional step that can be overridden
    protected void installElevator() {
        System.out.println("Installing elevator system.");
    }

    // Abstract method to get the type of building
    protected abstract String getBuildingType();
}
