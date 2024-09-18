/*
 * Subject: Software Design Patterns
 * Structural Pattern -> Adapter
 * Class Type: Java
 */

package com.ceron.implementation;
import com.ceron.fintech.a.FintechACredits;
import com.ceron.fintech.a.FintechACreditReception;
import com.ceron.fintech.a.FintechAApprovalResult;
import com.ceron.fintech.a.IntFintechACreditReception;


/**
 *
 * @author Fabrizio Bolaño
 */
public class FintechAAdapter implements InterfaceFintechAdapter, IntFintechACreditReception {
    private FintechAApprovalResult FAresponse;

    @Override
    public FintechCreditResponse SendCreditRequest(FintechCreditRequest request) {
        FintechACredits FArequest = new FintechACredits();
        FArequest.setCredit((float) request.getAmount());
        FArequest.setName(request.getClient());

        FintechACreditReception sender = new FintechACreditReception();
        sender.sendCreditForValidate(FArequest, this);

        do {
            try {
                Thread.sleep(10000);
                System.out.println("Fintech_A request pending....");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } while (FAresponse == null);

        FintechCreditResponse response = new FintechCreditResponse();
        response.setApproval(FAresponse.getApproved() == "Y" ? true : false);
        return response;
    }

    @Override
    public void NotifyResult(FintechAApprovalResult result) {
        this.FAresponse = result;
    }
}