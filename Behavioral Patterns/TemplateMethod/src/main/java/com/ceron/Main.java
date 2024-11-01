// Package: com.ceron
// Class: Main

package com.ceron;

import com.ceron.building.AbstractBuilding;
import com.ceron.building.CommercialBuilding;
import com.ceron.building.ResidentialBuilding;
import com.ceron.building.Skyscraper;
import com.ceron.house.AbstractHouse;
import com.ceron.house.StandardHouse;
import com.ceron.house.CustomizedHouse;

public class Main {
    public static void main(String[] args) {

        System.out.println("=== House Projects ===\n");

        System.out.println("Building a standard house:");
        AbstractHouse standardHouse = new StandardHouse();
        standardHouse.buildHouse();

        System.out.println("Building a customized house:");
        AbstractHouse customizedHouse = new CustomizedHouse();
        customizedHouse.buildHouse();

        System.out.println("=== Construction Projects ===\n");

        AbstractBuilding skyscraper = new Skyscraper();
        System.out.println("Starting construction of a skyscraper:");
        skyscraper.constructBuilding();

        AbstractBuilding residentialBuilding = new ResidentialBuilding();
        System.out.println("Starting construction of a residential building:");
        residentialBuilding.constructBuilding();

        AbstractBuilding commercialBuilding = new CommercialBuilding();
        System.out.println("Starting construction of a commercial building:");
        commercialBuilding.constructBuilding();
    }
}
