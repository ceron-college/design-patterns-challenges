/*
 * Subject: Software Design Patterns
 * Structural Pattern -> Adapter
 * Class Type: Java
 */
package com.ceron.fintech.a;

/**
 *
 * @author Fabrizio Bolaño
 */
public class FintechACreditReception {

    public void sendCreditForValidate(final FintechACredits request, final IntFintechACreditReception listener) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Fintech A has received your request, you will receive a response shortly");
                FintechAApprovalResult response = new FintechAApprovalResult();
                if (request.getCredit() <= 1500) {
                    response.setApproved("Y");
                } else {
                    response.setApproved("N");
                }
                try {
                    Thread.sleep(1000 * 30);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                listener.NotifyResult(response);
            }
        }).start();
    }
}

