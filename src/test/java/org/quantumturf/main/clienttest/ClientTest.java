package org.quantumturf.main.clienttest;

import org.quantumturf.BaseTest;
import org.quantumturf.pageobjects.authorization.LoginPage;
import org.quantumturf.pageobjects.clientpage.ClientPage;
import org.quantumturf.pageobjects.mainpage.MainPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ClientTest extends BaseTest {
    LoginPage loginPage;
    MainPage mainPage;
    ClientPage clientPage;

    @BeforeMethod
    public void setUpClientPages(){
        loginPage = new LoginPage(driver,wait);
        mainPage = new MainPage(driver,wait);
        clientPage = new ClientPage(driver,wait);
    }
    @Test
    public void addClientTest(){
        loginPage.performLogin();
        mainPage.clickOnClientTab();
    }
}
