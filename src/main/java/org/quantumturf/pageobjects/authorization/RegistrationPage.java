package org.quantumturf.pageobjects.authorization;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.quantumturf.pageobjects.mainpage.MainPage;

public class RegistrationPage extends MainPage {
    public final By invalidFirstNameErrorMessage = By.xpath("//div[.='Invalid first name format.']");
    public final By invalidEmailErrorMessage = By.xpath("//div[.='Invalid email format.']");
    public final By invalidLastNameErrorMessage = By.xpath("//div[.='Invalid last name format.']");
    public final By lastNameFieldSelector = By.xpath("//div[.='Last Name']/../following-sibling::div/input");
    public final By fistNameFieldSelector = By.xpath("//div[.='First Name']/../following-sibling::div/input");
    public final By emailFieldSelector = By.xpath("//div[.='Email']/../following-sibling::div/input");
    public final By passwordFieldSelector = By.xpath("//div[.='Password']/../following-sibling::div/input");
    public final By privacyPolicyCheckboxSelector = By.xpath("//span[.='Privacy Policy']/preceding-sibling::span");
    public final By temsAndConditionsCheckboxSelector = By.xpath("//span[.='Tems and Conditions']/preceding-sibling::span");
    public final By getStartedButtonSelector = By.cssSelector("button.btn");
    public final By registrationPageErrorMessage = By.cssSelector(".text-red");

    public RegistrationPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public String getInvalidFirstNameFormatErrorMessage() {
        return identify(invalidFirstNameErrorMessage).getText();
    }

    public String getInvalidLastNameFormatErrorMessage() {
        return identify(invalidLastNameErrorMessage).getText();
    }

    public String getInvalidEmailFormatErrorMessage() {
        return identify(invalidEmailErrorMessage).getText();
    }

    public void fillLastNameField(String lastName) {
        identify(lastNameFieldSelector).sendKeys(lastName);
    }

    public void fillEmailField(String email) {
        identify(emailFieldSelector).sendKeys(email);
    }

    public void fillFirstNameField(String firstName) {
        identify(fistNameFieldSelector).sendKeys(firstName);
    }

    public void fillPasswordFieldSelector(String password) {
        identify(passwordFieldSelector).sendKeys(password);
    }


    public void clickOnPrivacyPolicyCheckbox() {
        identify(privacyPolicyCheckboxSelector).click();
    }

    public void clickOnTemsAndConditionsCheckbox() {
        identify(temsAndConditionsCheckboxSelector).click();
    }

    public void clickOnGetStartedButton() {
        identify(getStartedButtonSelector).click();
    }

    public String getRegistrationPageErrorMessage() {
        return identify(registrationPageErrorMessage).getText();
    }


}
