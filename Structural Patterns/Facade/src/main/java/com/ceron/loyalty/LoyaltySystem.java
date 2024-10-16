/*
 * Subject: Software Design Patterns
 * Structural Pattern -> Facade
 * Class Type: Java
 */

package com.ceron.loyalty;

import com.ceron.utilities.SimulatedDBData;

/**
 *
 */
public class LoyaltySystem {

    /**
     * Awards points to a client based on the purchase amount.
     * For every 100 pesos spent, the client earns 10 points.
     * @param clientId The ID of the client.
     * @param amount The amount spent in pesos.
     */
    public void awardPoints(Long clientId, double amount) {
        int pointsEarned = (int) (amount / 100) * 10;
        SimulatedDBData.addClientPoints(clientId, pointsEarned);
    }

    /**
     * Calculates the maximum points that can be used for a given amount.
     * Each 10 points can cover $1 USD.
     * @param clientId The ID of the client.
     * @param amount The amount to cover in USD.
     * @return The points that can be used.
     */
    public int calculateUsablePoints(Long clientId, double amount) {
        int requiredPoints = (int) (amount * 10); // 10 points = $1
        int availablePoints = SimulatedDBData.getClientPoints(clientId);
        return Math.min(requiredPoints, availablePoints);
    }

    /**
     * Uses points to cover a portion or all of the purchase.
     * @param clientId The ID of the client.
     * @param pointsToUse The number of points to use.
     */
    public void usePoints(Long clientId, int pointsToUse) {
        SimulatedDBData.deductClientPoints(clientId, pointsToUse);
    }

    /**
     * Retrieves the current points of a client.
     * @param clientId The ID of the client.
     * @return The current points.
     */
    public int getClientPoints(Long clientId) {
        return SimulatedDBData.getClientPoints(clientId);
    }
}
