package org.quantumturf.pageobjects.clientpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.quantumturf.pageobjects.mainpage.MainPage;

import java.util.List;

public class AddContactPage extends MainPage {
    private final By threePoints = By.xpath("//table/tbody/tr/td[5]");
    private final By addContact = By.xpath("//div[.='Add Contact']//following-sibling::div");
    private final By firstName = By.cssSelector("input[placeholder='First Name']");
    private final By lastName = By.cssSelector("input[placeholder='Last Name']");
    private final By email = By.cssSelector("input[placeholder='Email']");
    private final By phoneNumber = By.cssSelector("input[placeholder='000000000']");
    private final By buttonSave = By.xpath("//div[.='Add Contact']/../following-sibling::div/button");
    private final By contactList = By.cssSelector("div.drawer-content table tr td:nth-child(1)");
    private final By buttonBack = By.xpath("(//div[@class='drawer-content'])[2]//button[@class='very-light-grey-button btn btn-primary']");
    private final By popUP = By.cssSelector("button.close-btnbutton.close-btn");


    public AddContactPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void clickOnThreePoints() {
        identify(threePoints).click();
    }

    public void clickOnAddContact() {
        identify(addContact).click();
    }

    public void inputFirstName(String name) {
        identify(firstName).sendKeys(name);
    }

    public void inputLastName(String name) {
        identify(lastName).sendKeys(name);
    }

    public void inputEmail(String mail) {
        identify(email).sendKeys(mail);
    }

    public void inputPhoneNumber(String number) {
        identify(phoneNumber).sendKeys(number);
    }

    public void clickOnAddClient() {
        identify(buttonSave).click();
    }

    public boolean isContactInList(String value) {
        List<WebElement> elements = identifyList(contactList);

        for (WebElement webElement : elements) {
            if (webElement.getText().equals(value)) {
                return true;
            }
        }
        return false;
    }

    public void clickOnBack() {
        wait.until(ExpectedConditions.elementToBeClickable(buttonBack)).click();
    }
    public void closePopUp(){
        wait.until(ExpectedConditions.elementToBeClickable(popUP)).click();
    }
}
