package org.quantumturf.authorization;

import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.quantumturf.BaseTest;
import org.quantumturf.pageobjects.HomePage;
import org.quantumturf.pageobjects.authorization.RegistrationPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import java.time.Duration;


public class RegistrationTest extends BaseTest {
    private static final Logger log = LoggerFactory.getLogger(RegistrationTest.class);
    HomePage homePage;
    RegistrationPage registrationPage;

    @BeforeMethod
    public void setUpPage() {
        homePage = new HomePage(driver, wait);
        registrationPage = new RegistrationPage(driver, wait);
    }

    @Test
    public void registerUser() {
        homePage.clickOnRegisterButton();

        driver.findElement(By.xpath("//div[.='First Name']/following-sibling::div/input")).sendKeys("Alina");
        driver.findElement(By.xpath("//div[.='Last Name']/following-sibling::div/input")).sendKeys("Mocanu");
        driver.findElement(By.xpath("//div[.='Email']/following-sibling::div/input")).sendKeys("alinamarie0426@gmail.com");
        driver.findElement(By.xpath("//div[.='Password']/following-sibling::div/input")).sendKeys("Skillbrain34@");

        driver.findElement(By.xpath("//span[.='Privacy Policy']/preceding-sibling::span")).click();
        driver.findElement(By.xpath("//span[.='Tems and Conditions']/preceding-sibling::span")).click();
        WebElement getStarted = driver.findElement(By.cssSelector("button.btn"));
        Actions actions = new Actions(driver);
        actions.moveToElement(getStarted).click().perform();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement alert = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.text-red")));

        Assert.assertTrue(alert.isDisplayed());
        Assert.assertEquals(alert.getText(), "This username already exists");
    }

    @Test
    public void registrationInvalidEmail() {
        homePage.clickOnRegisterButton();
        registrationPage.fillEmailField("stoenescumihai.com");
        registrationPage.getInvalidEmailFormatErrorMessage();
        Assert.assertEquals(registrationPage.getInvalidEmailFormatErrorMessage(), "Invalid email format.");
    }

    @Test
    public void registrationInvalidFirstName() {
        homePage.clickOnRegisterButton();
        registrationPage.fillFirstNameField("Ana@");
        registrationPage.getInvalidFirstNameFormatErrorMessage();
        Assert.assertEquals(registrationPage.getInvalidFirstNameFormatErrorMessage(), "Invalid first name format.");

    }

    @Test
    public void registrationInvalidLastName() {
        homePage.clickOnRegisterButton();
        registrationPage.fillLastNameField("Ana@");
        registrationPage.getInvalidLastNameFormatErrorMessage();
        Assert.assertEquals(registrationPage.getInvalidLastNameFormatErrorMessage(), "Invalid last name format.");
    }

    @Test
    public void registrationInvalidPassword() {
        homePage.clickOnRegisterButton();
        registrationPage.fillFirstNameField("Ana");
        registrationPage.fillLastNameField("Banana");
        registrationPage.fillEmailField("anabanana@gmail.com");
        registrationPage.fillPasswordFieldSelector("1");
        registrationPage.clickOnTemsAndConditionsCheckbox();
        registrationPage.clickOnPrivacyPolicyCheckbox();
        registrationPage.clickOnGetStartedButton();
        registrationPage.getRegistrationPageErrorMessage();
        Assert.assertEquals(registrationPage.getRegistrationPageErrorMessage(), "Password does not contain minimum security requirements (8 chars., 1 digit, 1 upper and 1 special char.)");
    }

    @Test
    public void registrationInvalidBothCheckBoxes() {
        homePage.clickOnRegisterButton();
        registrationPage.fillFirstNameField("Ana");
        registrationPage.fillLastNameField("Banana");
        registrationPage.fillEmailField("anabanana@gmail.com");
        registrationPage.clickOnGetStartedButton();
        Assert.assertEquals(registrationPage.getRegistrationPageErrorMessage(), "You have to accept the privacy policy and the terms and conditions.");
    }

    @Test
    public void registrationInvalidPrivacyPolicyCheckBoxe() {
        homePage.clickOnRegisterButton();
        registrationPage.fillFirstNameField("Ana");
        registrationPage.fillLastNameField("Banana");
        registrationPage.fillEmailField("anabanana@gmail.com");
        registrationPage.clickOnTemsAndConditionsCheckbox();
        registrationPage.clickOnGetStartedButton();
        Assert.assertEquals(registrationPage.getRegistrationPageErrorMessage(), "You have to accept the privacy policy and the terms and conditions.");
    }

    @Test
    public void registrationInvalidTemsAndCoditionsCheckBoxe() {
        homePage.clickOnRegisterButton();
        registrationPage.fillFirstNameField("Ana");
        registrationPage.fillLastNameField("Banana");
        registrationPage.fillEmailField("anabanana@gmail.com");
        registrationPage.clickOnPrivacyPolicyCheckbox();
        registrationPage.clickOnGetStartedButton();
        Assert.assertEquals(registrationPage.getRegistrationPageErrorMessage(), "You have to accept the privacy policy and the terms and conditions.");
    }
}