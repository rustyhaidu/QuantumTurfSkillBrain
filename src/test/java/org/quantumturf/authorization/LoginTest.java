package org.quantumturf.authorization;

import org.quantumturf.BaseTest;
import org.quantumturf.pageobjects.authorization.LoginPage;
import org.quantumturf.pageobjects.mainpage.MainPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    MainPage mainPage;
    LoginPage loginPage;

    @BeforeMethod
    public void setUpPages() {
        loginPage = new LoginPage(driver, wait);
        mainPage = new MainPage(driver, wait);
    }

    @Test
    public void successfulLogin() {
        loginPage.clickOnSignInButton();
        loginPage.fillEmailField("rustyhaidu@gmail.com");
        loginPage.fillPasswordField("SkillBrain06@");
        loginPage.clickOnContinue();
        Assert.assertTrue(mainPage.isLogoDisplayed(), "Verificam ca apare logo-ul pe pagina");
    }


}
