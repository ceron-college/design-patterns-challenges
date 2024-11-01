// Package: com.ceron
// Class: CommercialBuilding

package com.ceron.building;

public class CommercialBuilding extends AbstractBuilding {

    @Override
    protected void buildFoundation() {
        System.out.println("Building reinforced concrete foundations for commercial building.");
    }

    @Override
    protected void buildStructure() {
        System.out.println("Constructing reinforced steel structure for commercial building.");
    }

    @Override
    protected void installUtilities() {
        System.out.println("Installing commercial-grade electrical and HVAC systems.");
    }

    @Override
    protected void finishExterior() {
        System.out.println("Finishing exterior with durable materials suitable for high traffic.");
    }

    @Override
    protected void finishInterior() {
        System.out.println("Setting up office spaces and retail areas for commercial use.");
    }

    @Override
    protected boolean hasElevator() {
        return true; // Commercial buildings often have elevators
    }

    @Override
    protected void installElevator() {
        System.out.println("Installing freight and passenger elevators.");
    }

    @Override
    protected String getBuildingType() {
        return "Commercial Building";
    }
}
