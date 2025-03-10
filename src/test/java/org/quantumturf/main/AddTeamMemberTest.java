package org.quantumturf.main;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.quantumturf.BaseTest;
import org.quantumturf.pageobjects.authorization.LoginPage;
import org.quantumturf.pageobjects.mainpage.MainPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class AddTeamMemberTest extends BaseTest {

    MainPage mainPage;
    LoginPage loginPage;

    @BeforeMethod
    public void setUpPages() {
        loginPage = new LoginPage(driver, wait);
        mainPage = new MainPage(driver, wait);
    }

    @Test
    public void addTeamMemberWorker() {
        loginPage.performLogin();
        mainPage.clickOnProfileDropDownMenu();
        mainPage.clickOnMyTeamOptionMenu();
        mainPage.clickOnAddTeamMemberButton();
        mainPage.typeInFirstName("Mihai");
        mainPage.typeInLastName("Stoenescu");
        mainPage.typeInEmail("stoenescumihai88@gmail.com");
        mainPage.typePhoneNumber("00000000");
        mainPage.clickOnAddMemberButton();


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(mainPage.getAddTeamMemberButton()));

        mainPage.clickOnAddTeamMemberButton();
        mainPage.typeInFirstName("Mihai");
        mainPage.typeInLastName("Stoenescu");
        mainPage.typeInEmail("stoenescumihai88@gmail.com");
        mainPage.typePhoneNumber("00000000");

        // Apăsăm din nou butonul de adăugare a membrului
        mainPage.clickOnAddMemberButton();

        // Așteptăm mesajul de eroare să fie vizibil
        wait.until(ExpectedConditions.visibilityOf(mainPage.getErrorMessageElement()));

        // Verificăm mesajul de eroare
        String expectedErrorMessage = "Un membru al echipei cu acest e-mail există deja.";
        String actualErrorMessage = mainPage.getErrorMessage().trim();  // Eliminăm spațiile suplimentare

        // Comparația între mesajul de eroare așteptat și cel efectiv
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Mesajul de eroare nu a aparut sau nu este corect.");
    }

}


