package org.quantumturf;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SocialButton {

    @Test
    public static void  instagramSocialButton(){

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.quantumturf.com");
        driver.findElement(By.xpath("//*[@id=\"hs_cos_wrapper_footer-module-2\"]/div/a[3]")).click();

        String expectedURL = "https://www.instagram.com/quantumturf/";
        String originalURL = driver.getCurrentUrl();
        Assert.assertEquals(originalURL, expectedURL);

    }
    @Test
    public static void  facebookSocialButton(){

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.quantumturf.com");
        driver.findElement(By.xpath("//*[@id=\"hs_cos_wrapper_footer-module-2\"]/div/a[1]")).click();

        String expectedURL = "https://www.facebook.com/quantumturf";
        String originalURL = driver.getCurrentUrl();
        Assert.assertEquals(originalURL, expectedURL);

    }

    @Test
    public static void  linkedinSocialButton(){

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.quantumturf.com");
        driver.findElement(By.xpath("//*[@id=\"hs_cos_wrapper_footer-module-2\"]/div/a[2]")).click();

        String expectedURL = "https://www.linkedin.com/company/quantumturf/";
        String originalURL = driver.getCurrentUrl();
        Assert.assertEquals(originalURL, expectedURL);

    }

}
