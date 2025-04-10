package org.quantumturf.main.clienttest;

import net.datafaker.Faker;
import org.quantumturf.BaseTest;
import org.quantumturf.pageobjects.authorization.LoginPage;
import org.quantumturf.pageobjects.clientpage.ClientPage;
import org.quantumturf.pageobjects.mainpage.MainPage;
import org.quantumturf.pageobjects.programpage.ProgramPage;
import org.quantumturf.pageobjects.propertypage.PropertyPage;
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
    PropertyPage propertyPage;

    @BeforeMethod
    public void setUpClientPages() {
        loginPage = new LoginPage(driver, wait);
        mainPage = new MainPage(driver, wait);
        clientPage = new ClientPage(driver, wait);
        programPage = new ProgramPage(driver, wait);
        faker = new Faker();
        propertyPage = new PropertyPage(driver, wait);
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
        clientPage.searchAndSelectState("NY");
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
        clientPage.searchAndSelectState("NY");
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
        String phoneNumber = faker.phoneNumber().phoneNumber().replace("(", "").replace(")", "");
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
        clientPage.searchAndSelectState(state);
        clientPage.clickOnEditClient();
        Assert.assertEquals(clientPage.getNotificationMessage(), "Lawn Customer updated.");
    }

    @Test
    public void addClientPositiveTest() throws InterruptedException {
        loginPage.performLogin();
        mainPage.clickOnClientTab();
        Thread.sleep(1000);
        clientPage.clickOnClientButton();
        String firstNameFaker = faker.name().firstName();
        clientPage.inputFirstName(firstNameFaker);
        String lastNameFaker = faker.name().lastName();
        clientPage.inputLastName(lastNameFaker);
        String emailFaker = faker.internet().emailAddress();
        clientPage.inputEmail(emailFaker);
        String phoneNumberFaker = faker.phoneNumber().phoneNumber().replace("(", "").replace(")", "");
        clientPage.inputPhoneNumber(phoneNumberFaker);
        String addressStreetFaker = faker.address().streetAddress();
        clientPage.inputAddress(addressStreetFaker);
        String cityFaker = faker.address().city();
        clientPage.inputCitySelector(cityFaker);
        String zipCodeFaker = faker.address().zipCode();
        clientPage.inputZipCode(zipCodeFaker);
        String stateSelectorFaker = faker.address().stateAbbr();
        clientPage.clickOnInputStateSelector();
        clientPage.searchAndSelectState(stateSelectorFaker);
        Thread.sleep(1000);
        clientPage.clickOnSaveForm();
        Assert.assertEquals(clientPage.getNotificationMessage(), "New Lawn Manager Customer registration process completed successfully");
        //add property to client
        clientPage.searchItem(firstNameFaker + " " + lastNameFaker);
        clientPage.clickOnFirstThreeDotsButton();
        clientPage.clickOnAddPropertiesButton();
        String propertiesAddressFaker = faker.address().streetAddress();
        clientPage.typeInPropertiesAddress(propertiesAddressFaker);
        String propertiesCityFaker = faker.address().city();
        clientPage.typeInPropertiesCity(propertiesCityFaker);
        String propertiesZipCodeFaker = faker.address().zipCode();
        clientPage.typeInPropertiesZipCode(propertiesZipCodeFaker);
        clientPage.clickOnInputStateSelector();
        String stateFaker = faker.address().stateAbbr();
        System.out.println("Statul abreviat este: " + stateFaker);
        clientPage.searchAndSelectState(stateFaker);
        clientPage.clickOnPropertiesTurfType();
        programPage.clickOnWarmSeason();
        String propertiesAreaFaker = faker.number().digits(2);
        clientPage.typeInPropertiesArea(propertiesAreaFaker);
        Thread.sleep(1000);
        clientPage.clickOnAddPropertyButton();
        Thread.sleep(1000);
        Assert.assertEquals(clientPage.getNotificationMessage(), "Property added.");
        List<String> addressList = clientPage.getPropertiesAddress();
        Assert.assertTrue(addressList.contains(propertiesAddressFaker + ", " + propertiesZipCodeFaker));
        Assert.assertEquals(addressList.getFirst(), propertiesAddressFaker + ", " + propertiesZipCodeFaker);
        mainPage.clickOnGenericBackButton();
        mainPage.clickOnPropertyTab();
        Thread.sleep(2000);
        clientPage.searchItem(propertiesZipCodeFaker);
        Assert.assertTrue(propertyPage.isPropertyFound(propertiesAddressFaker + ", " + propertiesZipCodeFaker));
        Thread.sleep(1000);
        propertyPage.clickOnPropertyFound(propertiesAddressFaker + ", " + propertiesZipCodeFaker);
        propertyPage.clickOnProgram();
        propertyPage.clickOnSelectProgramDropDown();
        mainPage.searchAndSelectItem("Program123");
        propertyPage.clickOnGenerate();
        // Assert.assertEquals(clientPage.getNotificationMessage(),"Zone successfully associated with program.");
        mainPage.clickOnSchedulerTab();
        mainPage.clickOnFirstThreeDotsButton();
        propertyPage.clickOnCalendar();
        propertyPage.selectCurrentDate();

    }

    @Test
    public void editRounds() throws InterruptedException {
        loginPage.performLogin();
        mainPage.clickOnPropertyTab();
        propertyPage.searchProperty("420 Orn Forks");
        Thread.sleep(1000);
        propertyPage.clickOnPropertyFound("420 Orn Forks");
        propertyPage.clickOnProgram();
        propertyPage.clickOnSecondThreeDotsButton();
        Thread.sleep(1000);
        propertyPage.clickOnCalendar();
        propertyPage.selectCurrentDate();
        propertyPage.clickOnSave();
        Thread.sleep(1000);
        propertyPage.clickOnGenericBackButton();
        mainPage.clickOnSchedulerTab();
        Thread.sleep(1000);
        propertyPage.getClientName();
        String nameClient = propertyPage.getClientName();
        System.out.println("Numele clientului este :" +nameClient );
        Assert.assertEquals(nameClient, "Kaycee Labadie");
    }
}

