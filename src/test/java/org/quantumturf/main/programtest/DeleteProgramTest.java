package org.quantumturf.main.programtest;

import org.quantumturf.BaseTest;
import org.quantumturf.pageobjects.authorization.LoginPage;
import org.quantumturf.pageobjects.mainpage.MainPage;
import org.quantumturf.pageobjects.programpage.DeleteProgram;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteProgramTest extends BaseTest {
    LoginPage loginPage;
    MainPage mainPage;
    DeleteProgram deleteProgram;

    @BeforeMethod
    public void setUpPages() {
        loginPage = new LoginPage(driver, wait);
        mainPage = new MainPage(driver, wait);
        deleteProgram = new DeleteProgram(driver, wait);
    }
    @Test
    public void testPozitivForDelete() throws InterruptedException {
        loginPage.performLogin();
        mainPage.clickOnProgramsTab();
        mainPage.clickOnCreateProgram();
        deleteProgram.fillProgramNameField("Program5");
        deleteProgram.fillZipCodeField("43215");
        deleteProgram.clickOnTurfTypeMenu();
        deleteProgram.clickOnButtonSelect();
        Thread.sleep(1000);
        deleteProgram.clickOnWarmSeason();
        Thread.sleep(1000);
        deleteProgram.clickOnNextCreateProgram();
        Thread.sleep(1000);
        deleteProgram.clickOnWeedControl();
        Thread.sleep(1000);
        deleteProgram.clickOnSelectMonths();
        deleteProgram.clickOnPestControl();
        Thread.sleep(1000);
        deleteProgram.clickOnSelectMonthsPC();
        deleteProgram.clickOnButtonNext();
        Thread.sleep(1000);
        deleteProgram.clickOnTrash();
    }
}
