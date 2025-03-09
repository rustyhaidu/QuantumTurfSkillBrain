package org.quantumturf.main;

import org.quantumturf.BaseTest;
import org.quantumturf.pageobjects.authorization.LoginPage;
import org.quantumturf.pageobjects.mainpage.MainPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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

        // Verificam dacă mesajul de succes a apărut (în funcție de implementare)
        // Adaugam o aserțiune pentru a verifica succesul adăugării
        Assert.assertTrue(mainPage.isMemberAddedSuccessfully(), "Membru adăugat cu succes!");

        // Încercăm să adăugăm același membru din nou
        mainPage.clickOnAddTeamMemberButton();
        mainPage.typeInFirstName("Mihai");
        mainPage.typeInLastName("Stoenescu");
        mainPage.typeInEmail("stoenescumihai88@gmail.com");
        mainPage.typePhoneNumber("00000000");

        // Adăugarea din nou a membrului
        mainPage.clickOnAddMemberButton();

        // Verificam daca apare mesajul de eroare ca membrii există deja
        Assert.assertTrue(mainPage.isErrorMessageDisplayed("Acest Team Member exista deja!"), "Mesajul de eroare nu a apărut!");
    }
}


