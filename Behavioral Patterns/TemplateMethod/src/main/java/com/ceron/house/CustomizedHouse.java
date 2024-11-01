// Package: com.ceron
// Class: CustomizedHouse

package com.ceron.house;

public class CustomizedHouse extends AbstractHouse {

    @Override
    protected void buildFoundation() {
        System.out.println("Building reinforced foundations.");
    }

    @Override
    protected void buildStructure() {
        System.out.println("Building steel structure.");
    }

    @Override
    protected void installDoors() {
        System.out.println("Installing custom-designed doors.");
    }

    @Override
    protected void installWindows() {
        System.out.println("Installing high energy-efficiency windows.");
    }

    @Override
    protected void paintHouse() {
        System.out.println("Painting house blue.");
    }

    // We override the hook to indicate that this house does not have a garage
    @Override
    protected boolean hasGarage() {
        return false; // A garage will not be built
    }
}
