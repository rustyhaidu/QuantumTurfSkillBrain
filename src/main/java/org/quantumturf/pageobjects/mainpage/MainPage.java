package org.quantumturf.pageobjects.mainpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.quantumturf.pageobjects.HomePage;

public class MainPage extends HomePage {

    public final By logoSelector = By.cssSelector("img[src*='quantum-turf'");
    public final By profileDropDownMenu = By.cssSelector("img[src*='down_icon']");
    public final By myTeamOptionMenu = By.xpath("//div[.='My Team'][@class='dwn-navbar-option']");
    public final By addTeamMemberButton = By.tagName("button");
    public final By addFirstName = By.xpath("//div[.='First Name']/../following-sibling::div/input");
    public final By addLastName = By.xpath("//div[.='Last Name']/../following-sibling::div/input");
    public final By addEmail = By.xpath("//div[.='Email']/../following-sibling::div/input");
    public final By addPhoneNumber = By.xpath("//div[.='Phone Number']/../following-sibling::div/input");
    public final By addMemberButton = By.cssSelector(".drawer .green-button");

    public MainPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public boolean isLogoDisplayed() {

        return wait.until(ExpectedConditions.visibilityOfElementLocated(logoSelector)).isDisplayed();
    }

    public void clickOnProfileDropDownMenu() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(profileDropDownMenu)).click();
    }

    public void clickOnMyTeamOptionMenu() {
        driver.findElement(myTeamOptionMenu).click();
    }

    public void clickOnAddTeamMemberButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(addTeamMemberButton)).click();

//        driver.findElement(addTeamMemberButton).click();
    }

    public void typeInFirstName(String firstName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(addFirstName)).sendKeys(firstName);

//        driver.findElement(addFirstName).sendKeys();
    }

    public void typeInLastName(String lastName) {
        driver.findElement(addLastName).sendKeys(lastName);
    }

    public void typeInEmail(String email) {
        driver.findElement(addEmail).sendKeys(email);
    }

    public void typePhoneNumber(String phoneNumber) {
        driver.findElement(addPhoneNumber).sendKeys(phoneNumber);
    }

    public void clickOnAddMemberButton() {
        driver.findElement(addMemberButton).click();
    }
}
