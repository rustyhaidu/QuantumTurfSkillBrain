package org.quantumturf;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    WebDriver driver ;

    @BeforeMethod
            private void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @AfterMethod
    private void tearDown(){
        driver.quit();
    }
}
