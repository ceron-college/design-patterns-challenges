package com.ceron.game;

import com.ceron.game.Caretaker;
import com.ceron.game.Counter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Counter counter = new Counter();
        Caretaker caretaker = new Caretaker();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        System.out.println("Welcome to the Simple Counter with Undo Feature!");
        System.out.println("Current count: " + counter.getCount());

        while (!exit) {
            System.out.println("\nEnter a command: 'i' to increment, 'd' to decrement, 'u' to undo, 'q' to quit");
            String input = scanner.nextLine();

            switch (input.toLowerCase()) {
                case "i":
                    caretaker.save(counter); // Save state before action
                    counter.increment();
                    break;
                case "d":
                    caretaker.save(counter); // Save state before action
                    counter.decrement();
                    break;
                case "u":
                    caretaker.undo(counter);
                    break;
                case "q":
                    exit = true;
                    System.out.println("Exiting the application. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid command. Please try again.");
            }

            if (!exit) {
                System.out.println("Current count: " + counter.getCount());
            }
        }

        scanner.close();
    }
}
