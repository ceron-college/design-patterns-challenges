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
public class FintechBCreditsAPI {

    public FintechBCreditResponse sendCreditRequest(FintechBCreditRequest request){
        FintechBCreditResponse response = new FintechBCreditResponse();
        if(request.getRequestedAmount() <= 5000){
            response.setApprovalResult(true);
        }else{
            response.setApprovalResult(false);
        }
        return response;
    }
}
