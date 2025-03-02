package org.quantumturf;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SocialButton {

    @Test
    public static void  InstagramSocialButton(){

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.quantumturf.com");
        driver.findElement(By.xpath("/html/body/div/div[2]/footer/div/div/div/div/div[1]/div/div[1]/div[2]/div/div/div/div/a[3]")).click();

    }
    @Test
    public static void  FacebookSocialButton(){

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.quantumturf.com");
        driver.findElement(By.xpath("/html/body/div/div[2]/footer/div/div/div/div/div[1]/div/div[1]/div[2]/div/div/div/div/a[1]")).click();

    }

    @Test
    public static void  LinkedinSocialButton(){

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.quantumturf.com");
        driver.findElement(By.xpath("/html/body/div/div[2]/footer/div/div/div/div/div[1]/div/div[1]/div[2]/div/div/div/div/a[2]")).click();

    }

}
