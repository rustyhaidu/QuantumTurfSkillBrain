package org.testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.By;

public class Login {

    @Test
    public void LoginUser(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://qase.io/");
        WebElement loginButton = driver.findElement(By.cssSelector("a[href*='/login']"));
        loginButton.click();
        driver.findElement(By.cssSelector("input[name='email']")).sendKeys("alinamarie0426@gmail.com");
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys("Alina@2024Test123");
        driver.findElement(By.xpath("//button[@type='submit']//span[text()='Sign in']")).click();
        WebElement errorMessage = driver.findElement(By.xpath("//div[contains(text(), 'Invalid email or password')]"));
        if (errorMessage.isDisplayed()) {
            System.out.println("Error message is displayed correctly");
        } else {
            System.out.println("Error message is not displayed");
        }
        Assert.assertTrue(errorMessage.isDisplayed(), "Error message is not displayed!");




    }


}
