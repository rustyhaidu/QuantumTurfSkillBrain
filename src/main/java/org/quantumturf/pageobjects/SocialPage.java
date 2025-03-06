package org.quantumturf.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SocialPage {
    WebDriver driver;

    private By instagramCssSelector = By.cssSelector("svg[aria-labelledby=\"instagram3\"]");
    private By facebookCssSelector = By.cssSelector("svg[aria-labelledby=\"facebook-f1\"]");
    private By linkedinCssSelector = By.cssSelector("svg[aria-labelledby=\"linkedin-in2\"]");

    public SocialPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickOnInstagramButton(){
        driver.findElement(instagramCssSelector).click();
    }

    public void clickOnFacebookButoon(){
        driver.findElement(facebookCssSelector).click();
    }

    public void clickOnLinkedinButton(){
        driver.findElement(linkedinCssSelector).click();
    }
}