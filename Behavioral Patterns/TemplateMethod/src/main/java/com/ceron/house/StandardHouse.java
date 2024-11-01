// Package: com.ceron
// Class: StandardHouse

package com.ceron.house;

public class StandardHouse extends AbstractHouse {

    @Override
    protected void buildFoundation() {
        System.out.println("Building concrete foundations.");
    }

    @Override
    protected void buildStructure() {
        System.out.println("Building wooden structure.");
    }

    @Override
    protected void installDoors() {
        System.out.println("Installing standard doors.");
    }

    @Override
    protected void installWindows() {
        System.out.println("Installing standard windows.");
    }

    @Override
    protected void paintHouse() {
        System.out.println("Painting house white.");
    }
}
