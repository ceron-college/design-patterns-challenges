package com.ceron.implementation;

import com.ceron.fintech.c.FintechCCreditsAPI;
import com.ceron.implementation.FintechCreditRequest;
import com.ceron.implementation.FintechCreditResponse;

/**
 * Adaptador para Fintech C
 *
 * Este adaptador implementa la interfaz InterfaceFintechAdapter para integrar Fintech C en el sistema existente.
 * Convierte las solicitudes y respuestas entre el formato genérico y el específico de Fintech C.
 *
 * @autor Fabrizio Bolaño
 */
public class FintechCAdapter implements InterfaceFintechAdapter {

    private FintechCCreditsAPI fintechCAPI;

    public FintechCAdapter() {
        this.fintechCAPI = new FintechCCreditsAPI();
    }

    @Override
    public FintechCreditResponse SendCreditRequest(FintechCreditRequest request) {
        FintechCreditResponse response = new FintechCreditResponse();
        try {
            boolean isApproved = fintechCAPI.sendCreditRequest(request.getClient(), request.getAmount());
            response.setApproval(isApproved);
        } catch (FintechCCreditsAPI.CreditNotApprovedException e) {
            response.setApproval(false);
            System.out.println("Fintech C: " + e.getMessage());
        }
        return response;
    }
}
