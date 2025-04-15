package org.quantumturf.pageobjects.clientpage;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.quantumturf.pageobjects.mainpage.MainPage;

import java.util.ArrayList;
import java.util.List;

public class ClientPage extends MainPage {
    public final By addClientButton = By.cssSelector(".green-button");
    public final By firstName = By.xpath("//div[.='First Name']/../following-sibling::div/input");
    public final By lastName = By.xpath("//div[.='Last Name']/../following-sibling::div/input");
    public final By emailInput = By.cssSelector("input[placeholder='Email']");
    public final By phoneNumber = By.cssSelector("input[placeholder*='0000000']");
    public final By addressInput = By.cssSelector("input[placeholder *='12345']");
    public final By citySelector = By.xpath("//div[.='City']/../following-sibling::div/input");
    public final By zipCode = By.cssSelector("input[placeholder= '000000']");
    public final By selectState = By.cssSelector(".dwn-toggle");
    public final By searchState = By.xpath("//div[.='State']/../following-sibling::div/div/input");
    public final By saveForm = By.xpath("//div[.= 'Add Client']/../following-sibling::div/button");
    public final By addPropertiesButton = By.xpath("//div/div[.='Add Properties']");
    public final By addPropertieAddress = By.cssSelector("input[placeholder='12345 Address St.']");
    public final By addPropertieCity = By.cssSelector("input[placeholder='City']");
    public final By addPropertieZipCode = By.cssSelector("input[placeholder='000000']");
    public final By addPropertiesTurfType = By.xpath("//div[.='Turf Type']/../following-sibling::div/button");
    public final By addPropertiesArea = By.cssSelector("input[placeholder='00000']");
    public final By addPropertyButton = By.xpath("//button[.='Add Property']");
    public final By propertiesAddress = By.xpath("//div[.='Properties']/../following-sibling::div//td[contains(text(),',')]");
    public final By editButton = By.cssSelector("div.drawer.open .green-button-outlined");
    public final By editClient = By.xpath("//div[.='Edit Client']/../following-sibling::div/button");
    public final By name = By.xpath("//div[.='Name']/../following-sibling::div/input");
    private final By invalidName = By.xpath("//div[.='Name']/../following-sibling::div[contains(@class,'text-red')]");
    private final By invalidPhoneNumber = By.xpath("//div[.='Phone Number']/../following-sibling::div[contains(@class,'text-red')]");
    public final By buttonBack = By.xpath("(//div[@class='drawer-content'])[2]//button[@class='very-light-grey-button btn btn-primary']");
    public final By nameField = By.cssSelector("input[placeholder='First Name Last Name']");
    public final By invalidAdress = By.xpath("//div[.='Address']/../following-sibling::div[contains(@class,'text-red')]");
    public final By invalidCitySelector = By.xpath("//div[.='City']/../following-sibling::div[contains(@class,'text-red')]");
    public final By invalidZipCode = By.xpath("//div[.='Zip Code']/../following-sibling::div[contains(@class,'text-red')]");

    public ClientPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public String getFirstItemFound() {
        return identifyList(itemSelector).getFirst().getText();
    }

    public String getInvalidZipCodeMessage() {
        return identify(invalidZipCode).getText();
    }

    public String getInvalidCityMessage() {
        return identify(invalidCitySelector).getText();
    }

    public String getInvalidPhoneNumberMessage() {
        return identify(invalidPhoneNumber).getText();

    }

    public String getInvalidAdressMessage() {
        return identify(invalidAdress).getText();
    }

    public void clickOnClientButton() {
        driver.findElement(addClientButton).click();
    }


    public void inputFirstName(String firstName) {
        WebElement name = identify(this.firstName);
        name.clear();
        name.sendKeys(firstName);
    }

    public String getInvalidNameMessage() {
        return identify(invalidName).getText();

    }

    public void inputName(String name) {
        WebElement nameElement = identify(this.name);
        nameElement.clear();
        nameElement.sendKeys(name);
    }

    public void inputLastName(String lastName) {
        identify(this.lastName).sendKeys(lastName);
    }

    public void inputEmail(String emailInput) {
        identify(this.emailInput).sendKeys(emailInput);
    }

    public void inputPhoneNumber(String phoneNumber) {
        WebElement number = identify(this.phoneNumber);
        number.clear();
        number.sendKeys(phoneNumber);
    }

    public void inputAddress(String addressInput) {
        WebElement address = identify(this.addressInput);
        address.clear();
        address.sendKeys(addressInput);
    }

    public void inputCity(String city) {
        WebElement cityElement = identify(this.citySelector);
        cityElement.clear();
        cityElement.sendKeys(city);
    }

    public void inputZipCode(String zipCode) {
        WebElement zipCodeElement = identify(this.zipCode);
        zipCodeElement.clear();
        zipCodeElement.sendKeys(zipCode);
    }

    public void clickOnInputState() {
        driver.findElement(selectState).click();
    }


    public void clickOnSaveForm() {
        WebElement saveButton = wait.until(ExpectedConditions.elementToBeClickable(saveForm));

        try {
            saveButton.click();
        } catch (ElementClickInterceptedException e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", saveButton);
        }
    }

    public void clickOnAddPropertiesButton() {
        identify(addPropertiesButton).click();
    }

    public void typeInPropertiesAddress(String propertiesAddress) {
        identify(addPropertieAddress).sendKeys(propertiesAddress);
    }

    public void typeInPropertiesCity(String propertieCity) {
        identify(addPropertieCity).sendKeys(propertieCity);
    }

    public void typeInPropertiesZipCode(String propertieZipCode) {
        identify(addPropertieZipCode).sendKeys(propertieZipCode);
    }

    public void clickOnPropertiesTurfType() {
        identify(addPropertiesTurfType).click();
    }

    public void typeInPropertiesArea(String propertiesArea) {
        identify(addPropertiesArea).sendKeys(propertiesArea);
    }

    public void clickOnAddPropertyButton() {
        identify(addPropertyButton).click();
    }

    public List<String> getPropertiesAddress() {
        List<WebElement> addressElements = identifyList(propertiesAddress);
        List<String> addressTexts = new ArrayList<>();
        for (WebElement crtElement : addressElements) {
            addressTexts.add(crtElement.getText());
        }
        return addressTexts;
    }

    public void clickOnEdit() {
        identify(editButton).click();
    }

    public void clickOnEditClient() {
        identify(editClient).click();
    }

    public void clickOnBack() {
        identify(buttonBack).click();
    }

    public void insertName(String name) {
        identify(nameField).sendKeys(name);
    }

    public void searchAndSelectState(String item) {
        identify(searchState).sendKeys(item);
        selectFirstFoundItemFromDropDown();
    }
}

