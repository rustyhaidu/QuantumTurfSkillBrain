package org.quantumturf.properties;

import org.quantumturf.BaseTest;
import org.quantumturf.pageobjects.authorization.LoginPage;
import org.quantumturf.pageobjects.mainpage.MainPage;
import org.quantumturf.pageobjects.properties.PropertiesPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PropertiesTest extends BaseTest {
    LoginPage loginPage;
    MainPage mainPage;
    PropertiesPage propertiesPage;

    @BeforeMethod
    public void setUpPropertyPages() {
        loginPage = new LoginPage(driver, wait);
        mainPage = new MainPage(driver, wait);
        propertiesPage = new PropertiesPage(driver, wait);
    }

    @Test
    public void addressProperty() {
        loginPage.performLogin();
        mainPage.clickOnPropertiesTab();
        propertiesPage.insertSearchTab("Adresa 12 ");
        Assert.assertTrue(propertiesPage.isPropertyFound("Adresa12"));

    }
}


