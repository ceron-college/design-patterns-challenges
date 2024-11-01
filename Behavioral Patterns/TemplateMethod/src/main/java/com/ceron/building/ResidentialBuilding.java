// Package: com.ceron
// Class: ResidentialBuilding

package com.ceron.building;

public class ResidentialBuilding extends AbstractBuilding {

    @Override
    protected void buildFoundation() {
        System.out.println("Building slab foundations for residential building.");
    }

    @Override
    protected void buildStructure() {
        System.out.println("Constructing brick and mortar structure for residential building.");
    }

    @Override
    protected void installUtilities() {
        System.out.println("Installing standard electrical and plumbing systems.");
    }

    @Override
    protected void finishExterior() {
        System.out.println("Finishing exterior with stucco and siding.");
    }

    @Override
    protected void finishInterior() {
        System.out.println("Painting walls and installing flooring for residences.");
    }

    @Override
    protected boolean hasElevator() {
        return false; // Typically, residential buildings may not have elevators
    }

    @Override
    protected String getBuildingType() {
        return "Residential Building";
    }
}
