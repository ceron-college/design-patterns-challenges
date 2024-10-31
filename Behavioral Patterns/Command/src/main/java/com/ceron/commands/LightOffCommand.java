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
public class LightOffCommand implements Command {
    private Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOff();
    }

    @Override
    public void undo() {
        light.turnOn();
    }
}
