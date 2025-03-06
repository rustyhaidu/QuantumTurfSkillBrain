package org.quantumturf.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    private By registerButtonSelector = By.cssSelector(".header a[href*='signup']");
    private By signInButtonSelector = By.cssSelector(".header a[href*='login']");

    public HomePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        // PageFactory.initElements(driver, HomePage.class);
    }

    public void clickOnRegisterButton() {
        driver.findElement(registerButtonSelector).click();
    }

    public void clickOnSignInButton() {
        driver.findElement(signInButtonSelector).click();
    }

}
