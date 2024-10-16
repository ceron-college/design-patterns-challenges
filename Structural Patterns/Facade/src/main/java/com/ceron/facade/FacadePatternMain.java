/*
 * Subject: Software Design Patterns
 * Structural Pattern -> Facade
 * Class Type: Main()
 */

package com.ceron.facade;

import com.ceron.implementation.PaymentFacadeInterface;
import com.ceron.implementation.PaymentFacade;
import com.ceron.implementation.PaymentRequest;
import com.ceron.implementation.PaymentResponse;

/**
 *
 */
public class FacadePatternMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // Example 1: Payment covered entirely by points
        PaymentRequest request1 = new PaymentRequest();
        request1.setAmount(10); // $10 USD
        request1.setCardExpirationDate("10/2025");
        request1.setCardName("Mo Salah");
        request1.setCardNumber("1234567890123456");
        request1.setCardSecurityNumber("345");
        request1.setClientId(1L); // Client with 100 points

        // Example 2: Payment partially covered by points
        PaymentRequest request2 = new PaymentRequest();
        request2.setAmount(15); // $15 USD
        request2.setCardExpirationDate("11/2024");
        request2.setCardName("Luis Diaz");
        request2.setCardNumber("2345678901234567");
        request2.setCardSecurityNumber("456");
        request2.setClientId(2L); // Client with 50 points

        // Example 3: Payment entirely covered by points
        PaymentRequest request3 = new PaymentRequest();
        request3.setAmount(5); // $5 USD
        request3.setCardExpirationDate("12/2023");
        request3.setCardName("Sadio Mane");
        request3.setCardNumber("3456789012345678");
        request3.setCardSecurityNumber("567");
        request3.setClientId(3L); // Client with 200 points

        try {
            PaymentFacadeInterface paymentFacade = new PaymentFacade();

            System.out.println("\n--- Processing Payment 1: Entirely with Points ---");
            PaymentResponse response1 = paymentFacade.pay(request1);
            System.out.println(response1);

            System.out.println("\n--- Processing Payment 2: Partially with Points ---");
            PaymentResponse response2 = paymentFacade.pay(request2);
            System.out.println(response2);

            System.out.println("\n--- Processing Payment 3: Entirely with Points ---");
            PaymentResponse response3 = paymentFacade.pay(request3);
            System.out.println(response3);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
