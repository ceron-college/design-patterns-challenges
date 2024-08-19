//----------------------------------------------------------
//-----------------Package: com.ceron.implementation -------
//--------------- Class: InterfacePrototype ---------------
//------------------- Type: Interface ---------------------
//----------------------------------------------------------
/*
 * Subject: Software Design Patterns
 * Creational Pattern -> Prototype
 * Class Type: Interface
 * This class implements the Cloneable interface to utilize Java's standard cloning functionality.
 * We define the generic type T to ensure that all prototypes implement the InterfacePrototype interface.
 */
package com.ceron.implementation;

/**
 * @author Fabrizio Bolaño
 */
public interface InterfacePrototype<T extends InterfacePrototype> extends Cloneable {
    public T clone();

    public T deepClone();
}