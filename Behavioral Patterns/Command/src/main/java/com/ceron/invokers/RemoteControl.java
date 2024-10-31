/*
 * Subject: Software Design Patterns
 * Behavioral Pattern -> Command
 * Class Type: Invoker
 */
package com.ceron.invokers;

import com.ceron.commands.Command;

/**
 * The invoker holds a command and can execute or undo it
 */
public class RemoteControl {
    private Command command;
    private Command lastCommand;

    /**
     * Sets the current command to be executed
     *
     * @param command The command to set
     */
    public void setCommand(Command command) {
        this.command = command;
    }

    /**
     * Executes the current command and records it as the last command
     */
    public void pressButton() {
        if (command != null) {
            System.out.println("Executing Command");
            command.execute();
            lastCommand = command;
        }
    }

    /**
     * Undoes the last executed command
     */
    public void pressUndo() {
        if (lastCommand != null) {
            System.out.println("Undoing Command");
            lastCommand.undo();
            lastCommand = null; // Clear after undoing
        }

    }
}
