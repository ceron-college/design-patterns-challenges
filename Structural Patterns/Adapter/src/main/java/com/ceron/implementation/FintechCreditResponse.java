/*
 * Subject: Software Design Patterns
 * Structural Pattern -> Adapter
 * Class Type: Java
 */
package com.ceron.implementation;

/**
 *
 * @author Fabrizio Bolaño
 */
public class FintechCreditResponse {
    public boolean approval;

    public boolean isApproval() {
        return approval;
    }

    public void setApproval(boolean approval) {
        this.approval = approval;
    }
}