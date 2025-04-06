package org.quantumturf.authorization;

import net.bytebuddy.asm.Advice;
import net.datafaker.Faker;
import org.quantumturf.BaseTest;
import org.quantumturf.pageobjects.authorization.LoginPage;
import org.quantumturf.pageobjects.mainpage.MainPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    MainPage mainPage;
    LoginPage loginPage;
    Faker faker;

    @BeforeMethod
    public void setUpPages() {
        loginPage = new LoginPage(driver, wait);
        mainPage = new MainPage(driver, wait);
        faker = new Faker();
    }

    @Test
    public void successfulLogin() {
        loginPage.clickOnSignInButton();
        loginPage.fillEmailField("rustyhaidu@gmail.com");
        loginPage.fillPasswordField("SkillBrain06@");
        loginPage.clickOnContinue();
        Assert.assertTrue(mainPage.isLogoDisplayed(), "Verificam ca apare logo-ul pe pagina");
    }

    @Test
    public void forgotPassword() {
        loginPage.clickOnSignInButton();
        loginPage.fillEmailField("rustyhaidu@gmail.com");
        String passwordFaker = faker.lorem().characters(6, 6, true, true);
        loginPage.typePassword(passwordFaker);
        loginPage.clickOnContinue();
        Assert.assertEquals(loginPage.getNotificationMessage(),"Username/Password incorrect!");
    }
}
