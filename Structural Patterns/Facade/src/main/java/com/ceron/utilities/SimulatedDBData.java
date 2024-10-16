/*
 * Subject: Software Design Patterns
 * Structural Pattern -> Facade
 * Class Type: Java
 * Class to simulate database records
 */

package com.ceron.utilities;

import java.util.HashMap;

/**
 *
 */
public class SimulatedDBData {
    private static final HashMap<Long, Client> CLIENT_MAP = new HashMap<>();
    private static final HashMap<String, Card> CARD_BINS = new HashMap<>();

    static {
        // Initializing clients with points
        CLIENT_MAP.put(1L, new Client(1L, "Mo Salah", 500, "Discontinued", 100)); // 100 points
        CLIENT_MAP.put(2L, new Client(2L, "Luis Diaz", 300, "Discontinued", 50)); // 50 points
        CLIENT_MAP.put(3L, new Client(3L, "Sadio Mane", 100, "Active", 200)); // 200 points
        CLIENT_MAP.put(4L, new Client(4L, "Alisson Becker", 100, "Inactive", 0)); // 0 points

        CARD_BINS.put("123", new Card("123", "VISA", "Credit"));
        CARD_BINS.put("234", new Card("234", "MASTERCARD", "Debit"));
        CARD_BINS.put("345", new Card("345", "NEQUI", "Credit"));
    }

    public static Client findClientById(Long id) {
        return CLIENT_MAP.get(id);
    }

    public static void changeClientStatus(Long id, String newStatus) {
        Client clientReference = findClientById(id);
        clientReference.setStatus(newStatus);
        System.out.println("Changed status of client '" + clientReference.getName()
                + "' : " + newStatus);
    }

    public static boolean validateCard(String cardPrefix) {
        if (CARD_BINS.containsKey(cardPrefix)) {
            String company = CARD_BINS.get(cardPrefix).getCompany();
            System.out.println("Valid Card > '" + cardPrefix + "', " + company + "\n");
            return true;
        } else {
            System.out.println("Invalid Card >\n");
            return false;
        }
    }

    public static String getCardCompany(String cardPrefix) {
        if (CARD_BINS.containsKey(cardPrefix)) {
            return CARD_BINS.get(cardPrefix).getCompany();
        }
        throw new RuntimeException("Card does not exist");
    }

    // Methods to manage points
    public static int getClientPoints(Long clientId) {
        Client client = findClientById(clientId);
        return client.getPoints();
    }

    public static void addClientPoints(Long clientId, int points) {
        Client client = findClientById(clientId);
        client.setPoints(client.getPoints() + points);
        System.out.println("Added " + points + " points to client '" + client.getName() + "'. Total points: " + client.getPoints());
    }

    public static void deductClientPoints(Long clientId, int points) {
        Client client = findClientById(clientId);
        if (client.getPoints() >= points) {
            client.setPoints(client.getPoints() - points);
            System.out.println("Deducted " + points + " points from client '" + client.getName() + "'. Remaining points: " + client.getPoints());
        } else {
            throw new RuntimeException("Insufficient points for client '" + client.getName() + "'.");
        }
    }
}
