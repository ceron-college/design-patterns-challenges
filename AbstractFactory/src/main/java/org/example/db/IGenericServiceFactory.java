/*
 * Course: Software Design Patterns
 * Creational Pattern -> Abstract Factory
 * Class Type: Interface -> Generic Service Factory
 */
package org.example.db;


import org.example.services.IArticleService;
import org.example.services.IEmployeeService;

/**
 * Author: Fabrizio Bolaño
 */
public interface IGenericServiceFactory {
    public IEmployeeService getEmployeeService();
    public IArticleService getArticleService();
}
