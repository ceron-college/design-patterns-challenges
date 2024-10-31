/*
 * Subject: Software Design Patterns
 * Behavioral Pattern -> Command
 * Class Type: Concrete Command
 */
package com.ceron.commands;

import com.ceron.receivers.Light;

/**
 * Concrete command to turn on the light
 */
public class LightOnCommand implements Command {
    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOn();
    }

    @Override
    public void undo() {
        light.turnOff();
    }
}
