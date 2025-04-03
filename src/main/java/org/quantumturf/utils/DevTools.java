package org.quantumturf.utils;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v131.network.Network;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;

public class DevTools {
    private final ChromeDriver driver;
    private final AtomicBoolean requestFound = new AtomicBoolean(false);

    public DevTools(ChromeDriver driver) {
        this.driver = driver;
    }

    public void startInterception(String requestURL) {
        org.openqa.selenium.devtools.DevTools devTools = driver.getDevTools();
        devTools.createSession();

        // Enable network interception
        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));

        devTools.addListener(Network.responseReceived(), response -> {
            String url = response.getResponse().getUrl();
            int statusCode = response.getResponse().getStatus();

            // Check if request contains "maps.googleapis.com" and status is 200
            if (url.contains(requestURL) && statusCode == 200) {
                System.out.println("✅ Found successful request: " + url);
                requestFound.set(true);
            }
        });
    }

    public AtomicBoolean isRequestFound() {
        return requestFound;
    }
}
