package org.quantumturf.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HomePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    private final By registerButtonSelector = By.cssSelector(".header a[href*='signup']");
    private final By signInButtonSelector = By.cssSelector(".header a[href*='login']");
    public final By notificationMessage = By.cssSelector(".notification span");

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

    public WebElement identify(By by) {
        return this.wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public List<WebElement> identifyList(By by) {
        return this.wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }

    public String getNotificationMessage() {
        WebElement notificationElement = wait.until(ExpectedConditions.visibilityOfElementLocated(notificationMessage));
        return notificationElement.getText();
    }
}
