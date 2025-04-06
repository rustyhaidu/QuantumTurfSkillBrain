package org.quantumturf.pageobjects.authorization;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.quantumturf.pageobjects.HomePage;

public class LoginPage extends HomePage {

    private final By emailFieldSelector = By.xpath("//div[.='Email']/following-sibling::div/input");
    private final By passworldFieldSelector = By.xpath("//div[.='Password']/following-sibling::div/input");
    private final By continueButtonSelector = By.cssSelector(".green-button");
    private final By forgotPassword= By.xpath("//div[.='Forgot Password?']");
    public String loginURL = "https://www.quantumturf.io/login";

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

    public void clickOnForgotPassword(){
        identify(forgotPassword).click();
    }
}
