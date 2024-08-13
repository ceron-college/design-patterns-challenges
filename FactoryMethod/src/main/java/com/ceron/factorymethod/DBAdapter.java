// Package: factorymethod
// Class: DBAdapter.java
// Class Type: Interface

/*
 * Course: Software Design Patterns
 * Creational Pattern -> Factory Method
 * File Type: Interface
 */
package com.ceron.factorymethod;

import java.sql.Connection;

/**
 *
 * @author Fabrizio Bolaño
 */
public interface DBAdapter {
    public Connection getConnection();
}