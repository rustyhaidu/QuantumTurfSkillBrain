package org.QuantumTurf.main.producttest;

import org.quantumturf.BaseTest;
import org.quantumturf.pageobjects.authorization.LoginPage;
import org.quantumturf.pageobjects.inventorypage.InventoryPage;
import org.quantumturf.pageobjects.mainpage.MainPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FilterProductTest extends BaseTest {
    LoginPage loginPage;
    MainPage mainPage;
    InventoryPage inventoryPage;

    @BeforeMethod
    public void setupPage() {
        loginPage = new LoginPage(driver, wait);
        mainPage = new MainPage(driver, wait);
        inventoryPage=new InventoryPage(driver,wait);
    }

    @Test
    public void filterProductTest() {
        loginPage.performLogin();
        mainPage.clickOnInventoryTab();
        inventoryPage.searchProduct("Apple");
        inventoryPage.isProductPresent("Apple");


    }
}
