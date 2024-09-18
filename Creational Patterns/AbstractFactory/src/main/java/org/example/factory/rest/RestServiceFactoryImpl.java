/*
 * Course: Software Design Patterns
 * Creational Pattern -> Abstract Factory
 * This class represents the factory of objects for the Restful service family
 */
package org.example.factory.rest;


import org.example.db.IGenericServiceFactory;
import org.example.services.IArticleService;
import org.example.services.IEmployeeService;

/**
 * Author: Fabrizio Bolaño
 */
public class RestServiceFactoryImpl implements IGenericServiceFactory {

    @Override
    public IEmployeeService getEmployeeService() {
        return new RestEmployeeServiceImpl();
    }

    @Override
    public IArticleService getArticleService() {
        return new RestArticleServiceImpl();
    }
}
