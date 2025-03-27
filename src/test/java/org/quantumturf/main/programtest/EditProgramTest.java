package org.quantumturf.main.programtest;

import org.quantumturf.BaseTest;
import org.quantumturf.pageobjects.authorization.LoginPage;
import org.quantumturf.pageobjects.mainpage.MainPage;
import org.quantumturf.pageobjects.programpage.EditProgramPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EditProgramTest extends BaseTest {
    LoginPage loginPage;
    MainPage mainPage;
    EditProgramPage editProgramPage;

    @BeforeMethod
    public void setUpEdit(){
        loginPage = new LoginPage(driver,wait);
        mainPage = new MainPage(driver,wait);
        editProgramPage = new EditProgramPage(driver,wait);
    }
    @Test
    public void editProgramTest(){
        loginPage.performLogin();
        mainPage.clickOnProgramsTab();
        editProgramPage.clickOnPoints();
        editProgramPage.clickOnButton();
        editProgramPage.clickOnAdd();
        editProgramPage.clickOnSelect();
        editProgramPage.clickOnPlant();
        editProgramPage.insertbRate("11");
        editProgramPage.clickOnSave();
//        editProgramPage.clickOnEditAgain();
    }
}
