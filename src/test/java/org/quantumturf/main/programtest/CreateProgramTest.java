package org.quantumturf.main.programtest;

import org.quantumturf.BaseTest;
import org.quantumturf.pageobjects.authorization.LoginPage;
import org.quantumturf.pageobjects.mainpage.MainPage;
import org.quantumturf.pageobjects.programpage.ProgramPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateProgramTest extends BaseTest {
    LoginPage loginPage;
    MainPage mainPage;
    ProgramPage programPage;

    @BeforeMethod
    public void setUpPages() {
        loginPage = new LoginPage(driver, wait);
        mainPage = new MainPage(driver, wait);
        programPage = new ProgramPage(driver, wait);
    }

    @Test
    public void createDuplicatedProgramNegativeTest() throws InterruptedException {
        loginPage.performLogin();
        mainPage.clickOnProgramsTab();
        mainPage.clickOnCreateProgram();
        programPage.fillProgramNameField("Program123");
        programPage.fillZipCodeField("31231");
        programPage.clickOnTurfTypeMenu();
        programPage.clickOnWarmSeason();
        Thread.sleep(1000);
        programPage.clickOnNextCreateProgram();

        Assert.assertEquals(programPage.getNotificationMessage(),"Duplicate name for program builder.");
        // Bug: Duplicate program should have displayed
    }
}
