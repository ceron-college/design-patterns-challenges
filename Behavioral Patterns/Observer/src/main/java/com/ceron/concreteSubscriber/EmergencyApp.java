package com.ceron.concreteSubscriber;

import com.ceron.subscriber.InterfaceSubscriber;

public class EmergencyApp implements InterfaceSubscriber {
    private String appName;

    public EmergencyApp(String appName) {
        this.appName = appName;
    }

    @Override
    public void update(String weatherUpdate) {
        // Filter: Only act on "Severe Storm" or "Emergency" updates
        if (weatherUpdate.equalsIgnoreCase("Severe Storm") || weatherUpdate.equalsIgnoreCase("Emergency")) {
            System.out.println(appName + " received weather update: " + weatherUpdate);
        }
    }
}
