package org.quantumturf.pageobjects.authorization;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.quantumturf.pageobjects.HomePage;

public class LoginPage extends HomePage {

    private final By emailFieldSelector = By.xpath("//div[.='Email']/following-sibling::div/input");
    private final By passworldFieldSelector = By.xpath("//div[.='Password']/following-sibling::div/input");
    private final By continueButtonSelector = By.cssSelector(".green-button");
    public String loginURL = "https://www.quantumturf.io/login";
    public final By invalidFirstNameErrorMessage = By.xpath("//div[.='Invalid first name format.']");

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void fillEmailField(String email) {
        driver.findElement(emailFieldSelector).sendKeys(email);
    }

    public void fillPasswordField(String password) {
        driver.findElement(passworldFieldSelector).sendKeys(password);
    }

    public void clickOnContinue() {
        driver.findElement(continueButtonSelector).click();
    }

    public void performLogin(String email, String password) {
        clickOnSignInButton();
        fillEmailField(email);
        fillPasswordField(password);
        clickOnContinue();
    }

    public void performLogin() {
        performLogin("rustyhaidu@gmail.com", "SkillBrain06@");
    }

    public WebElement getInvalidFirstNameFormatErrorElement() {
        return driver.findElement(By.xpath("//div[.='Invalid first name format.']"));
    }

    public String getInvalidFirstNameFormatErrorMessage() {
        return getInvalidFirstNameFormatErrorElement().getText();
    }
}
