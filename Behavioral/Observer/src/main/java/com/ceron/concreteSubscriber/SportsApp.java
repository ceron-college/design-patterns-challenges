package com.ceron.concreteSubscriber;

import com.ceron.subscriber.InterfaceSubscriber;

public class SportsApp implements InterfaceSubscriber {
    private String appName;

    public SportsApp(String appName) {
        this.appName = appName;
    }

    @Override
    public void update(String weatherUpdate) {
        // Filter: Only act on "Clear Weather" or "Rain" updates
        if (weatherUpdate.equalsIgnoreCase("Clear Weather") || weatherUpdate.equalsIgnoreCase("Rain")) {
            System.out.println(appName + " updated sports events based on weather: " + weatherUpdate);
        }
    }
}
