package com.ceron.game;

import java.util.Stack;

public class Caretaker {
    private final Stack<Memento> history = new Stack<>();

    // Saves the current state of the counter
    public void save(Counter counter) {
        history.push(counter.save());
    }

    // Undoes the last action
    public void undo(Counter counter) {
        if (!history.isEmpty()) {
            Memento memento = history.pop();
            counter.restore(memento);
            System.out.println("Undo successful.");
        } else {
            System.out.println("No actions to undo.");
        }
    }

    // Checks if there are states to undo
    public boolean canUndo() {
        return !history.isEmpty();
    }
}
