package org.quantumturf.main.producttest;

import org.quantumturf.BaseTest;
import org.quantumturf.pageobjects.authorization.LoginPage;
import org.quantumturf.pageobjects.mainpage.MainPage;
import org.quantumturf.pageobjects.productpage.AddProductPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddProductTest extends BaseTest {
    LoginPage loginPage;
    MainPage mainPage;
    AddProductPage addProductPage;

    @BeforeMethod
    public void setUpAddPruduct() {
        loginPage = new LoginPage(driver, wait);
        mainPage = new MainPage(driver, wait);
        addProductPage = new AddProductPage(driver, wait);
    }

    @Test
    public void addProduct() {
        loginPage.performLogin();
        mainPage.clickOnInventoryTab();
        addProductPage.clickOnAddProduct();
        addProductPage.fillProductForm();

        //addProductPage.nameProductField("Banana");
        String crtMills = String.valueOf(System.currentTimeMillis());
        addProductPage.nameProductField(crtMills);
        addProductPage.clickOnAdd();

        addProductPage.searchItem(crtMills);
        Assert.assertTrue(addProductPage.isItemFound(crtMills));
    }

    @Test
    public void addProductNegativeTest() {
        loginPage.performLogin();
        mainPage.clickOnInventoryTab();
        addProductPage.clickOnAddProduct();
        addProductPage.fillProductForm();
        addProductPage.nameProductField("Banana");
        addProductPage.clickOnAdd();
        Assert.assertEquals(addProductPage.getNotificationMessage(), "Duplicate name for products.");

    }

}
