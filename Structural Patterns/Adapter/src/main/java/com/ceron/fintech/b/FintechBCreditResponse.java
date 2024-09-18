/*
 * Subject: Software Design Patterns
 * Structural Pattern -> Adapter
 * Class Type: Java
 */
package com.ceron.fintech.b;

/**
 *
 * @author Fabrizio Bolaño
 */
public class FintechBCreditResponse {
    public boolean ApprovalResult;

    public boolean isApprovalResult() {
        return ApprovalResult;
    }

    public void setApprovalResult(boolean ApprovalResult) {
        this.ApprovalResult = ApprovalResult;
    }
}