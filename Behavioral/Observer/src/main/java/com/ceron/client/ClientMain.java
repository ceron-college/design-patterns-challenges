package com.ceron.client;

import com.ceron.concreteSubscriber.EmergencyApp;
import com.ceron.concreteSubscriber.NewsApp;
import com.ceron.concreteSubscriber.SportsApp;
import com.ceron.publisher.WeatherStation;
import com.ceron.subscriber.InterfaceSubscriber;

public class ClientMain {
    public static void main(String[] args) {
        // Create Weather Station (Publisher)
        WeatherStation weatherStation = new WeatherStation();

        // Create subscriber applications
        InterfaceSubscriber newsApp = new NewsApp("News App");
        InterfaceSubscriber sportsApp = new SportsApp("Sports App");
        InterfaceSubscriber emergencyApp = new EmergencyApp("Emergency App");

        // Subscribe the applications to the weather station
        weatherStation.subscribe(newsApp);
        weatherStation.subscribe(sportsApp);
        weatherStation.subscribe(emergencyApp);

        // Weather update and notify apps
        System.out.println("Setting weather to 'Severe Storm':");
        weatherStation.setWeatherState("Severe Storm");
        System.out.println();

        // Unsubscribe an app
        System.out.println("Unsubscribing 'Sports App':");
        weatherStation.unsubscribe(sportsApp);
        System.out.println();

        // Another weather update
        System.out.println("Setting weather to 'Clear Weather':");
        weatherStation.setWeatherState("Clear Weather");
        System.out.println();

        // Another weather update
        System.out.println("Setting weather to 'Rain':");
        weatherStation.setWeatherState("Rain");
        System.out.println();

        // Another weather update that doesn't match any filter
        System.out.println("Setting weather to 'Foggy':");
        weatherStation.setWeatherState("Foggy");
        System.out.println();
    }
}
