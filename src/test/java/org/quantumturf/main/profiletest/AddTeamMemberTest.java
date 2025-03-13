package org.quantumturf.main.profiletest;

import org.quantumturf.BaseTest;
import org.quantumturf.pageobjects.authorization.LoginPage;
import org.quantumturf.pageobjects.profilepage.ProfilePage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddTeamMemberTest extends BaseTest {

    ProfilePage profilePage;
    LoginPage loginPage;

    @BeforeMethod
    public void setUpPages() {
        loginPage = new LoginPage(driver, wait);
        profilePage = new ProfilePage(driver, wait);
    }

    @Test
    public void addTeamMemberWorker() {
        loginPage.performLogin();
        profilePage.clickOnProfileDropDownMenu();
        profilePage.clickOnMyTeamOptionMenu();
        profilePage.clickOnAddTeamMemberButton();
        profilePage.typeInFirstName("Mihai");
        profilePage.typeInLastName("Stoenescu");
        profilePage.typeInEmail("stoenescumihai88@gmail.com");
        profilePage.typePhoneNumber("00000000");

        // Apăsăm din nou butonul de adăugare a membrului
        profilePage.clickOnAddMemberButton();

        // Verificăm mesajul de eroare
        String expectedErrorMessage = "Lawn Provider already exists.";
        String actualErrorMessage = profilePage.getNotificationMessage().trim();  // Eliminăm spațiile suplimentare

        // Comparația între mesajul de eroare așteptat și cel efectiv
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Verifica mesajul de eroare aparut.");
    }

    @Test
    public void addTeamOperater() {
        loginPage.performLogin();
        profilePage.clickOnProfileDropDownMenu();
        profilePage.clickOnMyTeamOptionMenu();
        profilePage.clickOnAddTeamMemberButton();
        profilePage.clickOnOperatorTab();
        profilePage.typeInFirstName("Mihai");
        profilePage.typeInLastName("Stoenescu");
        profilePage.typeInEmail("stoenescumihai88@gmail.com");
        profilePage.typePhoneNumber("00000000");
        profilePage.clickOnAddMemberButton();


        // Verificăm mesajul de eroare
        String expectedErrorMessage = "Lawn Provider already exists.";
        String actualErrorMessage = profilePage.getNotificationMessage().trim();  // Eliminăm spațiile suplimentare

        // Comparația între mesajul de eroare așteptat și cel efectiv
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Mesajul de eroare nu a aparut sau nu este corect.");
    }
}


