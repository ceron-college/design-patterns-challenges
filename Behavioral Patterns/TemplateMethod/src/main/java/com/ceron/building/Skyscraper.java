// Package: com.ceron
// Class: Skyscraper

package com.ceron.building;

public class Skyscraper extends AbstractBuilding {

    @Override
    protected void buildFoundation() {
        System.out.println("Building deep pile foundations for skyscraper.");
    }

    @Override
    protected void buildStructure() {
        System.out.println("Constructing steel and glass structure for skyscraper.");
    }

    @Override
    protected void installUtilities() {
        System.out.println("Installing high-capacity electrical and plumbing systems.");
    }

    @Override
    protected void finishExterior() {
        System.out.println("Finishing exterior with reflective glass panels.");
    }

    @Override
    protected void finishInterior() {
        System.out.println("Designing and completing luxurious interiors.");
    }

    @Override
    protected boolean hasElevator() {
        return true; // Skyscrapers have elevators
    }

    @Override
    protected void installElevator() {
        System.out.println("Installing high-speed elevators with advanced controls.");
    }

    @Override
    protected String getBuildingType() {
        return "Skyscraper";
    }
}
