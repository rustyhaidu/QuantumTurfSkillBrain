package org.QuantumTurf.propertytest;

import org.quantumturf.BaseTest;
import org.quantumturf.pageobjects.authorization.LoginPage;
import org.quantumturf.pageobjects.mainpage.MainPage;
import org.quantumturf.pageobjects.propertypage.PropertyPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PropertyTest extends BaseTest {
    LoginPage loginPage;
    MainPage mainPage;
    PropertyPage propertyPage;

    @BeforeMethod
    public void setupPropertyPages(){
        loginPage=new LoginPage(driver,wait);
        mainPage=new MainPage(driver,wait);
        propertyPage=new PropertyPage(driver,wait);
    }

    @Test
    public void filterPropertyByAddress() throws InterruptedException {
        loginPage.performLogin();
        mainPage.clickOnPropertyTab();
        propertyPage.searchProperty("Adresa12");
        Thread.sleep(1000);
        Assert.assertTrue(propertyPage.isPropertyFound("Adresa12"));
    }
}

