package org.quantumturf.main.clienttest;

import net.datafaker.Faker;
import org.quantumturf.BaseTest;
import org.quantumturf.pageobjects.authorization.LoginPage;
import org.quantumturf.pageobjects.clientpage.AddContactPage;
import org.quantumturf.pageobjects.mainpage.MainPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddContactTest extends BaseTest {
    LoginPage loginPage;
    MainPage mainPage;
    AddContactPage addContactPage;
    Faker faker;

    @BeforeMethod
    public void setUpAddClient() {
        loginPage = new LoginPage(driver, wait);
        mainPage = new MainPage(driver, wait);
        addContactPage = new AddContactPage(driver, wait);
        faker = new Faker();
    }

    @Test
    public void addContactTestNegativ() throws InterruptedException {
        loginPage.performLogin();
        mainPage.clickOnClientTab();
        mainPage.searchItem("Claudiu Haidu");
        addContactPage.clickOnThreePoints();
        addContactPage.clickOnAddContact();
        addContactPage.inputFirstName("Ana");
        addContactPage.inputLastName("Ionescu");
        addContactPage.inputEmail("anaionescu23@gmail.com");
        addContactPage.inputPhoneNumber("0786543223");
        addContactPage.clickOnAddClient();
        Assert.assertEquals(addContactPage.getNotificationMessage(), "User is already associated with this company in this role.");
        Thread.sleep(10000);
        // addContactPage.closePopUp();
        addContactPage.clickOnBack();
        Assert.assertTrue(addContactPage.isAddressInList("Ana Ionescu"));
    }
    @Test
    public void addContactTestPozitiv(){
        loginPage.performLogin();
        mainPage.clickOnClientTab();
        mainPage.searchItem("Maria PopescuLebsacke");
        addContactPage.clickOnFirstThreeDotsButton();
        addContactPage.clickOnAddContact();
        String firstNameFaker = faker.name().firstName();
        addContactPage.inputFirstName(firstNameFaker);
        String lastNameFaker = faker.name().lastName();
        addContactPage.inputLastName(lastNameFaker);
        String emailFaker = faker.internet().emailAddress();
        addContactPage.inputEmail(emailFaker);
        String phoneFaker= faker.phoneNumber().phoneNumber().replace("(","").replace(")","");
        addContactPage.inputPhoneNumber(phoneFaker);
        addContactPage.clickOnAddClient();
        Assert.assertEquals(addContactPage.getNotificationMessage(),"Contact added.");
        String firstNameInList = addContactPage.getFirstContactInList();
        Assert.assertEquals(firstNameInList,firstNameFaker + " " + lastNameFaker);
    }
}
