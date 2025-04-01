package org.quantumturf.main.scheduler;

import org.openqa.selenium.By;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v131.network.Network;
import org.quantumturf.BaseTest;
import org.quantumturf.pageobjects.authorization.LoginPage;
import org.quantumturf.pageobjects.mainpage.MainPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;

public class SchedulerTest extends BaseTest {
    LoginPage loginPage;
    MainPage mainPage;


    @BeforeMethod
    public void setUpPages() {
        loginPage = new LoginPage(driver, wait);
        mainPage = new MainPage(driver, wait);

    }

    @Test
    public void mapTest() throws InterruptedException {
        loginPage.performLogin();
        mainPage.clickOnSchedulerTab();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("button[aria-label='Map camera controls']")).click();
        Thread.sleep(2000);

        DevTools devTools = driver.getDevTools();
        devTools.createSession();

        // Enable network interception
        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));

        // Flag to check if the required request exists
        AtomicBoolean requestFound = new AtomicBoolean(false);

        driver.findElement(By.cssSelector("button[aria-label='Move down']")).click();
        Thread.sleep(5000);
        // Listen for network responses
        devTools.addListener(Network.responseReceived(), response -> {
            String url = response.getResponse().getUrl();
            int statusCode = response.getResponse().getStatus();

            // Check if request contains "maps.googleapis.com" and status is 200
            if (url.contains("maps.googleapis.com") && statusCode == 200) {
                System.out.println("✅ Found successful request: " + url);
                requestFound.set(true);
            }
        });
        driver.findElement(By.cssSelector("button[aria-label='Move down']")).click();
    }
}
