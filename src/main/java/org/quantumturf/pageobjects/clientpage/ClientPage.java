package org.quantumturf.pageobjects.clientpage;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.quantumturf.pageobjects.mainpage.MainPage;

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
    public final By stateSelector = By.cssSelector(".dwn-item");
    public final By searchState = By.xpath("//div[.='State']/../following-sibling::div/div/input");
    public final By saveForm = By.xpath("//div[.= 'Add Client']/../following-sibling::div/button");

    public ClientPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void clickOnClientButton() {
        driver.findElement(addClientButton).click();
    }

    public void inputFirstName(String firstName) {
        identify(this.firstName).sendKeys(firstName);
    }

    public void inputLastName(String lastName) {
        identify(this.lastName).sendKeys(lastName);
    }

    public void inputEmail(String emailInput) {
        identify(this.emailInput).sendKeys(emailInput);
    }

    public void inputPhoneNumber(String phoneNumber) {
        identify(this.phoneNumber).sendKeys(phoneNumber);
    }

    public void inputAddress(String addressInput) {
        identify(this.addressInput).sendKeys(addressInput);
    }

    public void inputCitySelector(String citySelector) {
        identify(this.citySelector).sendKeys(citySelector);
    }

    public void inputZipCode(String zipCode) {
        identify(this.zipCode).sendKeys(zipCode);
    }

    public void inputStateSelector() {
        driver.findElement(selectState).click();
    }

    public void inputSearchState(String state) {
        identify(searchState).sendKeys(state);
        identifyList(stateSelector).getFirst().click();
    }

    public void clickOnSaveForm() {
        WebElement saveButton = wait.until(ExpectedConditions.elementToBeClickable(saveForm));

        try {
            saveButton.click();
        } catch (ElementClickInterceptedException e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", saveButton);
        }
    }
}
