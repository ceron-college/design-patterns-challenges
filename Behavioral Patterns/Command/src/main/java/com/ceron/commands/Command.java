/*
 * Subject: Software Design Patterns
 * Behavioral Pattern -> Command
 * Class Type: Interface
 */
package com.ceron.commands;

/**
 * Command interface that declares the execute method
 */
public interface Command {
    void execute();
    void undo();
}
