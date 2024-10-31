/*
 * Subject: Software Design Patterns
 * Behavioral Pattern -> Command
 * Class Type: Receiver
 */
package com.ceron.receivers;

/**
 * Receiver that performs the action
 */
public class Light {
    public void turnOn() {
        System.out.println("Light is on");
    }

    public void turnOff() {
        System.out.println("Light is off");
    }
}
