/*
 * Subject: Software Design Patterns
 * Structural Pattern -> Facade
 * Class Type: Java
 * Class to simulate CRM system.
 */

package com.ceron.crm;

import com.ceron.utilities.Client;
import com.ceron.utilities.SimulatedDBData;

/**
 *
 */
public class CRMSystem {

    public Client findClient(Long clientId){
        return SimulatedDBData.findClientById(clientId);
    }
}
