package com.ceron.game;

// Memento class is immutable
public class Memento {
    private final int state;

    public Memento(int state) {
        this.state = state;
    }

    // Retrieves the stored state
    public int getState() {
        return state;
    }
}
