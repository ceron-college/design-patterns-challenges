//----------------------------------------------------------
//-----------------Package: com.ceron.implementation -------
//----------- Class: PrototypeFactory.java -----------------
//----------------------------------------------------------
/*
 * Subject: Software Design Patterns
 * Creational Pattern -> Prototype
 * Class Type: Java
 * Class to delegate the responsibility of creating prototypes.
 */
package com.ceron.implementation;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Fabrizio Bolaño
 */
public class PrototypeFactory {
    private static Map<String, InterfacePrototype> prototypes = new HashMap<String, InterfacePrototype>();

    public static InterfacePrototype getPrototype(String prototypeName) {
        return prototypes.get(prototypeName).deepClone();
    }

    public static void addPrototype(String prototypeName, InterfacePrototype prototype) {
        prototypes.put(prototypeName, prototype);
    }
}
