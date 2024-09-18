/*
 * Subject: Software Design Patterns
 * Structural Pattern -> Adapter
 * Class Type: Main()
 */
package com.ceron.adapter;

import com.ceron.implementation.*;

/**
 * @author Fabrizio Bolaño
 */
public class AdapterPatternMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        FintechCreditRequest request = new FintechCreditRequest();
        request.setClient("Cristiano Ronaldo");
        // Approve if <= 4000
        request.setAmount(4200);

        // Fintech B
        InterfaceFintechAdapter FinanceB = new FintechBAdapter();
        FintechCreditResponse FBresponse = FinanceB.SendCreditRequest(request);
        System.out.println("\nFinancial <<B>> approval result: > " + FBresponse.isApproval() + "\n");

        if (FBresponse.isApproval()) {
            System.out.println("Congratulations!!!!! Financial <<B>> approved your credit request.\n");
        } else {
            System.out.println("We're sorry, Financial <<B>> did not approve your credit.\n");
        }

        // Fintech A
        InterfaceFintechAdapter FinanceA = new FintechAAdapter();
        FintechCreditResponse FAresponse = FinanceA.SendCreditRequest(request);
        System.out.println("\nFinancial <<A>> approval result: > " + FAresponse.isApproval() + "\n");

        if (FAresponse.isApproval()) {
            System.out.println("Congratulations!!!!! Financial <<A>> approved your credit request.\n");
        } else {
            System.out.println("We're sorry, Financial <<A>> did not approve your credit.\n");
        }

        // Fintech C
        InterfaceFintechAdapter financeC = new FintechCAdapter();
        FintechCreditResponse fcResponse = financeC.SendCreditRequest(request);
        System.out.println("\nFinancial <<C>> approval result: > " + fcResponse.isApproval() + "\n");

        if (fcResponse.isApproval()) {
            System.out.println("Congratulations!!!!! Financial <<C>> approved your credit request.\n");
        } else {
            System.out.println("We're sorry, Financial <<C>> did not approve your credit.\n");
        }
    }
}
