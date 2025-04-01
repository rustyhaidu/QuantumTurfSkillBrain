package org.quantumturf.main.programtest;

import org.quantumturf.BaseTest;
import org.quantumturf.pageobjects.authorization.LoginPage;
import org.quantumturf.pageobjects.mainpage.MainPage;
import org.quantumturf.pageobjects.programpage.EditProgramPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EditProgramTest extends BaseTest {
    LoginPage loginPage;
    MainPage mainPage;
    EditProgramPage editProgramPage;

    @BeforeMethod
    public void setUpEdit() {
        loginPage = new LoginPage(driver, wait);
        mainPage = new MainPage(driver, wait);
        editProgramPage = new EditProgramPage(driver, wait);
    }

    @Test
    public void editProgramNegativeTest() {
        loginPage.performLogin();
        mainPage.clickOnProgramsTab();
        mainPage.searchItem("Program123");
        editProgramPage.clickOnFirstEditButton();
        editProgramPage.clickOnEditButton(0);
        editProgramPage.clickOnAdd();
        editProgramPage.clickOnSelectProduct();
        editProgramPage.clickOnSelectedProduct("orange");
        editProgramPage.insertRate("11");
        editProgramPage.clickOnSave();
        Assert.assertEquals(editProgramPage.getNotificationMessage(), "Product is already in this program builder.");
    }

    @Test
    public void editProgramPositiveTest() throws InterruptedException {
        loginPage.performLogin();
        mainPage.clickOnProgramsTab();
        mainPage.searchItem("Program123");
        editProgramPage.clickOnFirstEditButton();
        editProgramPage.clickOnEditButton(0);
        editProgramPage.clickOnTrashByProductName("Plant1");
        if (editProgramPage.isProductFound()) {
            Assert.assertEquals(editProgramPage.getNotificationMessage(), "Product removed from program builder.");
        }
        editProgramPage.clickOnAdd();
        editProgramPage.clickOnSelectProduct();
        editProgramPage.clickOnSelectedProduct("Plant1");
        editProgramPage.insertRate("11");
        editProgramPage.clickOnSave();
        Thread.sleep(2000);
        Assert.assertEquals(editProgramPage.getNotificationMessage(), "Product to program builder added.");
    }


}
