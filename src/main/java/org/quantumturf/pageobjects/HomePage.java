package org.quantumturf.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;

    private By registerButtonSelector = By.cssSelector(".header a[href*='signup']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
       // PageFactory.initElements(driver, HomePage.class);
    }

    public void clickOnRegisterButton() {
        driver.findElement(registerButtonSelector).click();
    }

}
