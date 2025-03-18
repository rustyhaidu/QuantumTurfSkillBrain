package org.quantumturf.main.programtest;

import org.quantumturf.BaseTest;
import org.quantumturf.pageobjects.authorization.LoginPage;
import org.quantumturf.pageobjects.mainpage.MainPage;
import org.quantumturf.pageobjects.programpage.ProgramPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteProgramTest extends BaseTest {
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
    public void testPozitivForDelete() throws InterruptedException {
        loginPage.performLogin();
        mainPage.clickOnProgramsTab();
        mainPage.clickOnCreateProgram();

        String uniqueProgram = "Program " + System.currentTimeMillis();

        programPage.fillProgramNameField(uniqueProgram);
        programPage.fillZipCodeField("43215");
        programPage.clickOnTurfTypeMenu();
        programPage.clickOnCoolSeason();
        Thread.sleep(1000);
        programPage.clickOnNextCreateProgram();
        programPage.clickOnWeedControl();
        programPage.selectMonths("Mar", "Feb");
        Thread.sleep(1000);
        programPage.clickOnNextCreateProgram();
        mainPage.clickOnProgramsTab();
        Thread.sleep(1000);
        programPage.clickOnFirstTrashIcon();
        Thread.sleep(1000);
        programPage.searchPrograms(uniqueProgram);
        boolean isProgramFound = programPage.isProgramFound(uniqueProgram);
        Assert.assertFalse(isProgramFound);
    }
}
