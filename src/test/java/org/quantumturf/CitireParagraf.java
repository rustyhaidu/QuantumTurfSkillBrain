package org.quantumturf;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class CitireParagraf {

    @Test
    public void extragereparagraf() {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://quantumturf.com/?trk=public_post_main-feed-card-text");

        WebDriverWait wait = new WebDriverWait(driver ,Duration.ofSeconds(10) );

        WebElement makesButton = driver.findElement(By.cssSelector("#hs_cos_wrapper_widget_1739158895626 > " +
                "section > details:nth-child(1) > summary"));
        makesButton.click();

        WebElement citireText = driver.findElement(By.cssSelector("#hs_cos_wrapper_widget_1739158895626 >" +
                " section > details:nth-child(1) > div > div > p > span"));

       String textExtras =  citireText.getText();
        System.out.println("Textul este :" + textExtras );
    }
}
