package org.quantumturf.main.clienttest;

import net.datafaker.Faker;
import org.quantumturf.BaseTest;
import org.quantumturf.pageobjects.authorization.LoginPage;
import org.quantumturf.pageobjects.clientpage.ClientPage;
import org.quantumturf.pageobjects.mainpage.MainPage;
import org.quantumturf.pageobjects.programpage.ProgramPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class ClientTest extends BaseTest {
    LoginPage loginPage;
    MainPage mainPage;
    ClientPage clientPage;
    ProgramPage programPage;
    Faker faker;

    @BeforeMethod
    public void setUpClientPages() {
        loginPage = new LoginPage(driver, wait);
        mainPage = new MainPage(driver, wait);
        clientPage = new ClientPage(driver, wait);
        programPage = new ProgramPage(driver, wait);
        faker = new Faker();
    }

    @Test
    public void addClientNegativeTest() throws InterruptedException {
        loginPage.performLogin();
        mainPage.clickOnClientTab();
        Thread.sleep(1000);
        clientPage.clickOnClientButton();
        clientPage.inputFirstName("Maria");
        clientPage.inputLastName("Popescu");
        clientPage.inputEmail("mariapopecu24@yahoo.com");
        clientPage.inputPhoneNumber("0785432149");
        clientPage.inputAddress("Strada Florilor");
        clientPage.inputCitySelector("Alabama");
        clientPage.inputZipCode("123456");
        clientPage.clickOnInputStateSelector();
        clientPage.inputSearchState("NY");
        Thread.sleep(1000);
        clientPage.clickOnSaveForm();
        Assert.assertEquals(clientPage.getNotificationMessage(), "Lawn Customer already exists.");
    }

    @Test

    public void addAnotherProperty() {
        loginPage.performLogin();
        mainPage.clickOnClientTab();
        clientPage.clickOnFirstThreeDotsButton();
        clientPage.clickOnAddPropertiesButton();
        clientPage.typeInPropertiesAddress("Adresa12");
        clientPage.typeInPropertiesCity("Bucharest");
        clientPage.typeInPropertiesZipCode("123456");
        clientPage.clickOnInputStateSelector();
        clientPage.inputSearchState("NY");
        clientPage.clickOnPropertiesTurfType();
        programPage.clickOnWarmSeason();
        clientPage.typeInPropertiesArea("1000");
        clientPage.clickOnAddPropertyButton();
        Assert.assertEquals(clientPage.getNotificationMessage(), "Property added.");
        List<String> addressList = clientPage.getPropertiesAddress();
        Assert.assertTrue(addressList.contains("Adresa12, 123456"));
        Assert.assertEquals(addressList.getFirst(), "Adresa12, 123456");
    }

    @Test
    public void editClientTestPozitiv() {
        loginPage.performLogin();
        mainPage.clickOnClientTab();
        mainPage.clickOnFirstThreeDotsButton();
        clientPage.clickOnEdit();
        String name = faker.name().lastName();
        clientPage.insertName(name);
        String phoneNumber = faker.phoneNumber().phoneNumber().replace("(","").replace(")","");
        clientPage.inputPhoneNumber(phoneNumber);
        String street = faker.address().streetAddress();
        clientPage.inputAddress(street);
        String city = faker.address().city();
        clientPage.inputCitySelector(city);
        String zipCode = faker.address().zipCode();
        clientPage.inputZipCode(zipCode);
        clientPage.clickOnInputStateSelector();
        String state = faker.address().stateAbbr();
        System.out.println("Statul nostru este :" + state);
        clientPage.inputSearchState(state);
        clientPage.clickOnEditClient();
        Assert.assertEquals(clientPage.getNotificationMessage(),"Lawn Customer updated.");
    }
}
