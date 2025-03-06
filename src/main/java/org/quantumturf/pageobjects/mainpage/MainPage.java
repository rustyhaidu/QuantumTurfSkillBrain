package org.quantumturf.pageobjects.mainpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.quantumturf.pageobjects.HomePage;

public class MainPage extends HomePage {

    public final By logoSelector = By.cssSelector("img[src*='quantum-turf'");

    public MainPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public boolean isLogoDisplayed() {

        return wait.until(ExpectedConditions.visibilityOfElementLocated(logoSelector)).isDisplayed();
    }
}
