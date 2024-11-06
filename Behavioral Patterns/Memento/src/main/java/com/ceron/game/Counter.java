package com.ceron.game;

public class Counter {
    private int count;

    public Counter() {
        this.count = 0;
    }

    // Increments the counter
    public void increment() {
        count++;
        System.out.println("Counter incremented to: " + count);
    }

    // Decrements the counter
    public void decrement() {
        count--;
        System.out.println("Counter decremented to: " + count);
    }

    // Retrieves the current count
    public int getCount() {
        return count;
    }

    // Creates a memento containing the current state
    public Memento save() {
        return new Memento(count);
    }

    // Restores the state from a memento
    public void restore(Memento memento) {
        this.count = memento.getState();
        System.out.println("Counter restored to: " + count);
    }
}
