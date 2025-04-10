package org.quantumturf.pageobjects.profilepage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.quantumturf.pageobjects.mainpage.MainPage;

import java.util.Objects;

public class ProfilePage extends MainPage {

    public final By myTeamOptionMenu = By.xpath("//div[.='My Team'][@class='dwn-navbar-option']");
    public final By myProfileOptionMenu = By.xpath("//div[.='My Profile'][@class='dwn-navbar-option']");
    public final By editButton = By.cssSelector("button.green-button-outlined");
    public final By zipCodeInput = By.xpath("//div[.='Zip Code']/../following-sibling::div/input");
    public final By saveButton = By.cssSelector("button.green-button");

    public final By addTeamMemberButton = By.tagName("button");
    public final By addFirstName = By.xpath("//div[.='First Name']/../following-sibling::div/input");
    public final By addLastName = By.xpath("//div[.='Last Name']/../following-sibling::div/input");
    public final By addEmail = By.xpath("//div[.='Email']/../following-sibling::div/input");
    public final By addPhoneNumber = By.xpath("//div[.='Phone Number']/../following-sibling::div/input");
    public final By addMemberButton = By.cssSelector(".drawer .green-button");
    public final By operatorTab = By.xpath("//div[.='Operator']");

    public ProfilePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
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

    public WebElement getAddTeamMemberButton() {
        return driver.findElement(By.id("add-member-button"));

    }

    public void clickOnOperatorTab() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(operatorTab)).click();
    }

    public void clickOnMyProfileOptionMenu() {
        driver.findElement(myProfileOptionMenu).click();
    }

    public void editButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(editButton)).click();
    }

    public String incrementZipCode() {
        WebElement zipCodeElement = wait.until(ExpectedConditions.visibilityOfElementLocated(zipCodeInput));
        String oldZip = Objects.requireNonNull(zipCodeElement.getDomAttribute("value")).trim();
        String newZip = String.valueOf(Integer.parseInt(oldZip) + 1);
        zipCodeElement.clear();
        zipCodeElement.sendKeys(newZip);
        return newZip;
    }
    public String  getZipCode(){
        WebElement zipCodeElement = wait.until(ExpectedConditions.visibilityOfElementLocated(zipCodeInput));
        return zipCodeElement.getDomAttribute("value");
    }

    public void clickButtonForSave() {
        driver.findElement(saveButton).click();
    }
}

