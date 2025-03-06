package org.quantumturf.main;

import org.quantumturf.BaseTest;
import org.quantumturf.pageobjects.authorization.LoginPage;
import org.quantumturf.pageobjects.mainpage.MainPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddTeamMemberTest extends BaseTest {

    MainPage mainPage;
    LoginPage loginPage;

    @BeforeMethod
    public void setUpPages() {
        loginPage = new LoginPage(driver, wait);
        mainPage = new MainPage(driver, wait);
    }

    @Test
    public void addTeamMemberWorker() {
        loginPage.performLogin();
        mainPage.clickOnProfileDropDownMenu();
        mainPage.clickOnMyTeamOptionMenu();
        mainPage.clickOnAddTeamMemberButton();
        mainPage.typeInFirstName("Mihai");
        mainPage.typeInLastName("Stoenescu");
        mainPage.typeInEmail("stoenescumihai88@gmail.com");
        mainPage.typePhoneNumber("00000000");
        mainPage.clickOnAddMemberButton();
    }

}
