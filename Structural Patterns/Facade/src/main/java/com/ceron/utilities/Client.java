/*
 * Subject: Software Design Patterns
 * Structural Pattern -> Facade
 * Class Type: Java
 */

package com.ceron.utilities;

/**
 *
 */
public class Client {
    private Long id;
    private String name;
    private double balance;
    private String status;
    private int points; // New field for loyalty points

    public Client() {
        this.points = 0; // Initialize points to 0
    }

    public Client(Long id, String name, double balance, String status) {
        this.id = id;
        this.name = name;
        this.balance = balance;
        this.status = status;
        this.points = 0; // Initialize points to 0
    }

    public Client(Long id, String name, double balance, String status, int points) {
        this.id = id;
        this.name = name;
        this.balance = balance;
        this.status = status;
        this.points = points;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public String getStatus() {
        return status;
    }

    public int getPoints() {
        return points;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    @Override
    public String toString() {
        return "Client{" + "id=" + id + ", name=" + name + ", "
                + "\nbalance=" + balance + ", status=" + status + ", points=" + points + '}';
    }
}
