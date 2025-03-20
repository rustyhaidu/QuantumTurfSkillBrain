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
    public final By programsTab = By.xpath("//div[.='Programs']");
    public final By clientTab = By.xpath("//div[.= 'Clients']");
    public final By myTeamOptionMenu = By.xpath("//div[.='My Team'][@class='dwn-navbar-option']");
    public final By logOutOptionMenu = By.xpath("//div[.='Logout']");
    public final By createProgramSelector = By.cssSelector(".green-button");

    public MainPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public boolean isLogoDisplayed() {

        return wait.until(ExpectedConditions.visibilityOfElementLocated(logoSelector)).isDisplayed();
    }

    public void clickOnProfileDropDownMenu() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(profileDropDownMenu)).click();
    }

    public void clickOnLogOutOptionMenu() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(logOutOptionMenu)).click();
    }

    public void clickOnMyTeamOptionMenu() {
        driver.findElement(myTeamOptionMenu).click();
    }

    public void clickOnProgramsTab() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(programsTab)).click();
//        driver.findElement(programsTab).click();
    }

    public void clickOnCreateProgram() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(createProgramSelector)).click();
//        driver.findElement(createProgramSelector).click();
    }

    public void clickOnClientTab(){
        identify(clientTab).click();
    }
}
