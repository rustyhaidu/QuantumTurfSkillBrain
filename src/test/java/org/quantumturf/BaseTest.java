package org.quantumturf;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {
    public WebDriver driver;
    public WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        // options.addArguments("--force-device-scale-factor=0.75");
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://quantumturf.com");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @AfterClass
    public void tearDown() {
       // driver.quit();
    }
}


