/*
 * Subject: Software Design Patterns
 * Structural Pattern -> Adapter
 * Class Type: Java
 */
package com.ceron.implementation;

import com.ceron.fintech.b.FintechBCreditRequest;
import com.ceron.fintech.b.FintechBCreditResponse;
import com.ceron.fintech.b.FintechBCreditsAPI;

/**
 * @author Fabrizio Bolaño
 */
public class FintechBAdapter implements InterfaceFintechAdapter {

    @Override
    public FintechCreditResponse SendCreditRequest(FintechCreditRequest request) {
        FintechBCreditRequest FBrequest = new FintechBCreditRequest();
        FBrequest.setClientName(request.getClient());
        FBrequest.setRequestedAmount(request.getAmount());

        FintechBCreditsAPI api = new FintechBCreditsAPI();
        FintechBCreditResponse FBresponse = api.sendCreditRequest(FBrequest);

        FintechCreditResponse response = new FintechCreditResponse();
        response.setApproval(FBresponse.isApprovalResult());
        return response;
    }
}