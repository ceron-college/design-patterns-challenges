/**
 * Course: Software Design Patterns
 * Creational Pattern: Singleton
 * Class Type: Main()
 * Purpose: Demonstrates the Singleton pattern in action with multi-threading.
 */
package com.ceron.singleton;

public class SingletonPatternMain {
    public static void main(String[] args) {

        //ORIGINAL

//        // Check the final state of the Singleton
//        SingletonConfiguration finalSingleton = SingletonConfiguration.getInstance();
//        System.out.println("Final Singleton Configuration after all threads: " + finalSingleton);
//
//        // Property Configuration for Module No->1
//        SingletonConfiguration singletonAHA = SingletonConfiguration.getInstance();
//        // Property Configuration for Module No->1
//        SingletonConfiguration singletonB = SingletonConfiguration.getInstance();
//        System.out.println(singletonAHA);
//        System.out.println(singletonB);
//        System.out.println("Same reference ==> " + (singletonAHA == singletonB));
//        singletonAHA.setAppName("Creational Singleton Pattern");
//        singletonB.setVersionNumber("2.0x");
//        System.out.println("SingletonA ==> " + singletonAHA);
//        System.out.println("SingletonB ==> " + singletonB);
//        singletonAHA = null;
//        singletonB = null;
//        singletonAHA = SingletonConfiguration.getInstance();
//        System.out.println("singletonA ==> " + singletonAHA);
//        // Property configuration for Module No->1
//        SingletonConfiguration singletonA = SingletonConfiguration.getInstance();
//        System.out.println("Original Singleton Configuration: " + singletonA);

//        CHALLENGE

        Thread thread1 = new Thread(() -> {
            SingletonConfiguration instance = SingletonConfiguration.getInstance();
            instance.setAppName("Thread 1 App Name");
            instance.setVersionNumber("1.1");
            System.out.println("Thread 1: " + instance);
        });

        Thread thread2 = new Thread(() -> {
            SingletonConfiguration instance = SingletonConfiguration.getInstance();
            instance.setAppName("Thread 2 App Name");
            instance.setVersionNumber("1.2");
            System.out.println("Thread 2: " + instance);
        });

        Thread thread3 = new Thread(() -> {
            SingletonConfiguration instance = SingletonConfiguration.getInstance();
            instance.setAppName("Thread 3 App Name");
            instance.setVersionNumber("1.3");
            System.out.println("Thread 3: " + instance);
        });

        thread1.start();
        thread2.start();
        thread3.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


