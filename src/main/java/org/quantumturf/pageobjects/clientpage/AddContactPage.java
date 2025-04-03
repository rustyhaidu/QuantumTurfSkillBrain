package org.quantumturf.pageobjects.clientpage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
    private final By addressList = By.cssSelector("div.drawer-content table tr td:nth-child(1)");
    private final By buttonBack = By.xpath("(//div[@class='drawer-content'])[2]//button[@class='very-light-grey-button btn btn-primary']");
    private final By popUP = By.cssSelector("button.close-btnbutton.close-btn");
    private final By contactListSelector = By.xpath("//div[.='Contacts']/../..//table/tbody/tr/td[1]");
    private final By invalidFirstName = By.xpath("//div[.='First Name']/../following-sibling::div[contains(@class,'text-red')]");
    private final By invalidLastName = By.xpath("//div[.='Last Name']/../following-sibling::div[contains(@class,'text-red')]");
    private final By invalidEmail = By.xpath("//div[.='Email']/../following-sibling::div[contains(@class,'text-red')]");
    private final By invalidPhoneNumber = By.xpath("//div[.='Phone Number']/../following-sibling::div[contains(@class,'text-red')]");

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
        WebElement nameElement = identify(firstName);
        nameElement.clear();
        nameElement.sendKeys(name);
    }

    public void inputLastName(String name) {
        WebElement lastNameElement = identify(lastName);
        lastNameElement.clear();
        lastNameElement.sendKeys(name);
    }

    public void inputEmail(String mail) {
        WebElement emailElement = identify(email);
        emailElement.clear();
        emailElement.sendKeys(mail);
    }

    public void inputPhoneNumber(String number) {
        WebElement phoneNumberElemnent = identify(phoneNumber);
        phoneNumberElemnent.clear();
        phoneNumberElemnent.sendKeys(number);
    }

    public void clickOnAddClient() {
        identify(buttonSave).click();
    }

    public boolean isAddressInList(String value) {
        List<WebElement> elements = identifyList(addressList);

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

    public void closePopUp() {
        wait.until(ExpectedConditions.elementToBeClickable(popUP)).click();
    }

    public String getFirstContactInList() {
        List<WebElement> contacts = identifyList(contactListSelector);
        return contacts.getFirst().getText();
    }

    public String getFirstNameInvalidMessage() {
        return identify(invalidFirstName).getText();
    }

    public String getLastNameInvalidMessage() {
        return identify(invalidLastName).getText();
    }

    public String getEmailInvalidMessage() {
        return identify(invalidEmail).getText();
    }

    public void typeAndDeletePhoneNumber(String phoneNumber) {
        WebElement phoneInput = identify(this.phoneNumber);
        phoneInput.sendKeys(phoneNumber);
        for (int i = 0; i < phoneNumber.length(); i++) {
            phoneInput.sendKeys(Keys.BACK_SPACE);
        }
    }

    public String getPhoneNumberInvalidMessage() {
        return identify(invalidPhoneNumber).getText();
    }
}
