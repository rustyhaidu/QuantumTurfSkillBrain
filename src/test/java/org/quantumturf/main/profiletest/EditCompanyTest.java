package org.quantumturf.main.profiletest;

import org.quantumturf.BaseTest;
import org.quantumturf.pageobjects.authorization.LoginPage;
import org.quantumturf.pageobjects.profilepage.EditCompanyPage;
import org.quantumturf.pageobjects.profilepage.ProfilePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EditCompanyTest extends BaseTest {
    LoginPage loginPage;
    EditCompanyPage editCompanyPage;

    @BeforeMethod
    public void setUpPages() {
        loginPage = new LoginPage(driver, wait);
        editCompanyPage = new EditCompanyPage(driver, wait);
    }

    @Test
    public void editCompany() {
        loginPage.performLogin();
        editCompanyPage.clickOnProfileDropDownMenu();
        editCompanyPage.clickOnMyProfileOptionMenu();
        editCompanyPage.editButton();
        editCompanyPage.incrementZipCode();
    }

}