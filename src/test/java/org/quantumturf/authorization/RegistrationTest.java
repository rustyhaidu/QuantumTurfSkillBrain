package org.quantumturf.authorization;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.quantumturf.BaseTest;
import org.quantumturf.pageobjects.HomePage;
import org.quantumturf.pageobjects.authorization.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import javax.swing.*;
import java.time.Duration;


public class RegistrationTest extends BaseTest {
    HomePage homePage;

    @BeforeMethod
    public void setUpPage() {
        homePage = new HomePage(driver, wait);
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
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.quantumturf.com");
        driver.findElement(By.cssSelector(".header a[href*='signup'")).click();
        driver.findElement(By.xpath("//div[.='Email']/following-sibling::div/input"))
                .sendKeys("alinamarie0426gmail.com");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//div[.='Email']/following-sibling::div[@class='text-red text-small mt-1']")));

        Assert.assertTrue(errorMessage.isDisplayed());
        Assert.assertEquals(errorMessage.getText(), "Invalid email format.");
    }

    @Test
    public void registrationInvalidFirstName() {
        homePage.clickOnRegisterButton();
        driver.findElement(By.xpath("//div[.='First Name']/following-sibling::div/input")).sendKeys("A");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement errorFirstNameMessage = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//div[.='Invalid first name format.']")));
        Assert.assertTrue(errorFirstNameMessage.isDisplayed());
        Assert.assertEquals(errorFirstNameMessage.getText(), "Invalid first name format.");

    }

}