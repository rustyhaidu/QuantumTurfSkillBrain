package org.quantumturf.main.producttest;

import org.quantumturf.BaseTest;
import org.quantumturf.pageobjects.authorization.LoginPage;
import org.quantumturf.pageobjects.mainpage.MainPage;
import org.quantumturf.pageobjects.productpage.AddProductPage;
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
    public void addProduct() throws InterruptedException {
        loginPage.performLogin();
        mainPage.clickOnInventoryTab();
        addProductPage.clickOnAddProduct();
        addProductPage.nameProductField("Banana");
//        addProductPage.selectCategory();
//        addProductPage.selectorType();
        addProductPage.inputNumberRegistration("2");
        addProductPage.insertPrice("20");
        addProductPage.insertQuantity("8");
        addProductPage.attributesNField("6");
        addProductPage.attributesPField("8");
        addProductPage.attributesValueK("9");
        addProductPage.attributesValueCa("19");
        addProductPage.attributesValueMg("17");
        addProductPage.attributesValueS("15");
        addProductPage.attributesValueFe("16");
        addProductPage.attributesValueMn("21");
        addProductPage.clickOnAdd();

    }
}
