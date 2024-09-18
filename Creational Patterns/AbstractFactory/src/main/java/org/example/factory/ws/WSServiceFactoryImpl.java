/*
 * Course: Software Design Patterns
 * Creational Pattern -> Abstract Factory
 * This class represents the factory of objects for the WebService family
 */
package org.example.factory.ws;


import org.example.db.IGenericServiceFactory;
import org.example.services.IArticleService;
import org.example.services.IEmployeeService;

/**
 * Author: Fabrizio Bolaño
 */
public class WSServiceFactoryImpl implements IGenericServiceFactory {

    @Override
    public IEmployeeService getEmployeeService() {
        return new WSEmployeeServiceImpl();
    }

    @Override
    public IArticleService getArticleService() {
        return new WSArticleServiceImpl();
    }
}
