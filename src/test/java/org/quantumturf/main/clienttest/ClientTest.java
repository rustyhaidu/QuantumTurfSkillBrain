package org.quantumturf.main.clienttest;

import org.quantumturf.BaseTest;
import org.quantumturf.pageobjects.authorization.LoginPage;
import org.quantumturf.pageobjects.clientpage.ClientPage;
import org.quantumturf.pageobjects.mainpage.MainPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ClientTest extends BaseTest {
    LoginPage loginPage;
    MainPage mainPage;
    ClientPage clientPage;

    @BeforeMethod
    public void setUpClientPages() {
        loginPage = new LoginPage(driver, wait);
        mainPage = new MainPage(driver, wait);
        clientPage = new ClientPage(driver, wait);
    }

    @Test
    public void addClientNegativeTest() throws InterruptedException {
        loginPage.performLogin();
        mainPage.clickOnClientTab();
        Thread.sleep(1000);
        clientPage.clickOnClientButton();
        clientPage.inputFirstName("Maria");
        clientPage.inputLastName("Popescu");
        clientPage.inputEmail("mariapopecu24@yahoo.com");
        clientPage.inputPhoneNumber("0785432149");
        clientPage.inputAddress("Strada Florilor");
        clientPage.inputCitySelector("Alabama");
        clientPage.inputZipCode("123456");
        clientPage.inputStateSelector();
        clientPage.inputSearchState("NY");
        Thread.sleep(1000);
        clientPage.clickOnSaveForm();
        Assert.assertEquals(clientPage.getNotificationMessage(), "Lawn Customer already exists.");
    }
}
