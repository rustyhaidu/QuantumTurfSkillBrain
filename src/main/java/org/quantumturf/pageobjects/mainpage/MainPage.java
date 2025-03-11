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
    public final By erorrMessage =By.cssSelector(".notification span");

    public MainPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public boolean isLogoDisplayed() {

        return wait.until(ExpectedConditions.visibilityOfElementLocated(logoSelector)).isDisplayed();
    }

    public void clickOnProfileDropDownMenu() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(profileDropDownMenu)).click();
    }

    public String getErrorMessage(){
       WebElement errorElement =wait.until(ExpectedConditions.visibilityOfElementLocated(erorrMessage));
        return errorElement.getText();
    }
}






