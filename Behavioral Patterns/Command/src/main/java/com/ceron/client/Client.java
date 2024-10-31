/*
 * Subject: Software Design Patterns
 * Behavioral Pattern -> Command
 * Class Type: Client
 */
package com.ceron.client;

import com.ceron.commands.Command;
import com.ceron.commands.LightOnCommand;
import com.ceron.commands.LightOffCommand;
import com.ceron.invokers.RemoteControl;
import com.ceron.receivers.Light;

/**
 * Main class that executes the Command pattern with undo functionality
 */
public class Client {
    public static void main(String[] args) {
        // Receiver
        Light light = new Light();

        // Commands
        Command lightOn = new LightOnCommand(light);
        Command lightOff = new LightOffCommand(light);

        // Invoker
        RemoteControl remote = new RemoteControl();

        // Turn the light on
        remote.setCommand(lightOn);
        remote.pressButton(); // Output: Light is on

        // Undo the last action (turn off the light)
        remote.pressUndo(); // Output: Light is off

        // Turn the light off
        remote.setCommand(lightOff);
        remote.pressButton(); // Output: Light is off

        // Undo the last action (turn on the light)
        remote.pressUndo(); // Output: Light is on
    }
}
