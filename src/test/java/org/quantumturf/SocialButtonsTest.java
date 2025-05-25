package org.quantumturf;

import org.quantumturf.pageobjects.SocialPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SocialButtonsTest extends org.quantumturf.BaseTest {
    SocialPage socialPage;

    @BeforeMethod
    public void setUpPage() {
        socialPage = new SocialPage(driver);
    }

    @Test
    public void instagramSocialButton() {
        socialPage.clickOnInstagramButton();
        String expectedURL = "https://www.instagram.com/quantumturf/";
        String originalURL = driver.getCurrentUrl();
        Assert.assertEquals(originalURL, expectedURL);
    }

    @Test
    public void facebookSocialButton() {
        socialPage.clickOnFacebookButoon();
        String expectedURL = "https://www.facebook.com/quantumturf";
        String originalURL = driver.getCurrentUrl();
        Assert.assertEquals(originalURL, expectedURL);
    }

    @Test
    public void linkedinSocialButton() {
        socialPage.clickOnLinkedinButton();
        String expectedURL = "https://www.linkedin.com/company/quantumturf/";
        String originalURL = driver.getCurrentUrl();
        Assert.assertEquals(originalURL, expectedURL);
    }
}