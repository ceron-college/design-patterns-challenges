package org.example;


import org.example.db.GenericServiceFactory;
import org.example.db.IGenericServiceFactory;
import org.example.services.IArticleService;
import org.example.services.IEmployeeService;

import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        IGenericServiceFactory factory = GenericServiceFactory.createServiceFactory();
        IEmployeeService employeeService = factory.getEmployeeService();
        IArticleService productService = factory.getArticleService();

        System.out.println("Employee Service class > " + employeeService.getClass().getCanonicalName());
        System.out.println("Article Service class  > " + productService.getClass().getCanonicalName());

        System.out.println("getEmployees > " + Arrays.toString(employeeService.getEmployees()));
        System.out.println("getArticles  > " + Arrays.toString(productService.getArticles()));
    }
}