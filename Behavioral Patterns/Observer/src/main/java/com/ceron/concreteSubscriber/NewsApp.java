package com.ceron.concreteSubscriber;

import com.ceron.subscriber.InterfaceSubscriber;

public class NewsApp implements InterfaceSubscriber {
    private String appName;

    public NewsApp(String appName) {
        this.appName = appName;
    }

    @Override
    public void update(String weatherUpdate) {
        System.out.println(appName + " received weather update: " + weatherUpdate);
    }
}
