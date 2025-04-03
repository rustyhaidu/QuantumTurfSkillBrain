package org.quantumturf.main.clienttest;

import org.quantumturf.BaseTest;
import org.quantumturf.pageobjects.authorization.LoginPage;
import org.quantumturf.pageobjects.clientpage.AddContactPage;
import org.quantumturf.pageobjects.mainpage.MainPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddContactTest extends BaseTest {
    LoginPage loginPage;
    MainPage mainPage;
    AddContactPage addContactPage;

    @BeforeMethod
    public void setUpAddClient() {
        loginPage = new LoginPage(driver, wait);
        mainPage = new MainPage(driver, wait);
        addContactPage = new AddContactPage(driver, wait);
    }

    @Test
    public void addContactTestNegativ() throws InterruptedException {
        loginPage.performLogin();
        mainPage.clickOnClientTab();
        mainPage.searchItem("Claudiu Haidu");
        addContactPage.clickOnThreePoints();
        addContactPage.clickOnAddContact();
        addContactPage.inputFirstName("Ana");
        addContactPage.inputLastName("Ionescu");
        addContactPage.inputEmail("anaionescu23@gmail.com");
        addContactPage.inputPhoneNumber("0786543223");
        addContactPage.clickOnAddClient();
        Assert.assertEquals(addContactPage.getNotificationMessage(), "User is already associated with this company in this role.");
        Thread.sleep(10000);
        // addContactPage.closePopUp();
        addContactPage.clickOnBack();
        Assert.assertTrue(addContactPage.isContactInList("Ana Ionescu"));
    }
}
