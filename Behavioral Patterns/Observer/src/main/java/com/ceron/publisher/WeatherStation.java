package com.ceron.publisher;

import com.ceron.subscriber.InterfaceSubscriber;

import java.util.ArrayList;
import java.util.List;

// Publisher class
public class WeatherStation {
    private List<InterfaceSubscriber> subscribers = new ArrayList<>();
    private String weatherState;

    // Subscribe an observer
    public void subscribe(InterfaceSubscriber subscriber) {
        subscribers.add(subscriber);
    }

    // Unsubscribe an observer
    public void unsubscribe(InterfaceSubscriber subscriber) {
        subscribers.remove(subscriber);
    }

    // Notify all subscribers
    public void notifySubscribers() {
        for (InterfaceSubscriber subscriber : subscribers) {
            subscriber.update(weatherState);
        }
    }

    // Change the weather state and notify subscribers
    public void setWeatherState(String newWeatherState) {
        this.weatherState = newWeatherState;
        notifySubscribers();
    }
}
