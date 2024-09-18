/*
 * Course: Software Design Patterns
 * Creational Pattern -> Abstract Factory
 * Implementation for the WebService Article Service
 */
package org.example.factory.ws;


import org.example.services.IArticleService;

/**
 * Author: Fabrizio Bolaño
 */
public class WSArticleServiceImpl implements IArticleService {
    private static final String[] ARTICLES = new String[]{"Hard Drive", "Keyboards", "Mouse"};
    private static final String API_URL = "https://mocktarget.apigee.net/xml";

    @Override
    public String[] getArticles() {
        System.out.println("Service Type: WebServices");
        return ARTICLES;
    }
}
