package org.quantumturf.pageobjects.mainpage;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.quantumturf.pageobjects.HomePage;


public class MainPage extends HomePage {

    public final By logoSelector = By.cssSelector("img[src*='quantum-turf'");
    public final By profileDropDownMenu = By.cssSelector("img[src*='down_icon']");
    public final By notificationMessage = By.cssSelector(".notification span");

    public final By myTeamOptionMenu = By.xpath("//div[.='My Team'][@class='dwn-navbar-option']");
    public final By logOutOptionMenu = By.xpath("//div[.='Logout']");


    public MainPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public boolean isLogoDisplayed() {

        return wait.until(ExpectedConditions.visibilityOfElementLocated(logoSelector)).isDisplayed();
    }

    public void clickOnProfileDropDownMenu() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(profileDropDownMenu)).click();
    }

    public String getNotificationMessage() {
        WebElement notificationElement = wait.until(ExpectedConditions.visibilityOfElementLocated(notificationMessage));
        return notificationElement.getText() ;
    }

    public void clickOnLogOutOptionMenu() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(logOutOptionMenu)).click();
    }

    public void clickOnMyTeamOptionMenu() {
        driver.findElement(myTeamOptionMenu).click();
    }
}
