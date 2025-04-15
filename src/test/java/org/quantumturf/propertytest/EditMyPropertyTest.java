package org.quantumturf.propertytest;

import net.datafaker.Faker;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.quantumturf.BaseTest;
import org.quantumturf.pageobjects.authorization.LoginPage;
import org.quantumturf.pageobjects.mainpage.MainPage;
import org.quantumturf.pageobjects.propertypage.MyProperties;
import org.quantumturf.pageobjects.propertypage.PropertyPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class EditMyPropertyTest extends BaseTest {
    Faker faker;
    LoginPage loginPage;
    MainPage mainPage;
    PropertyPage propertyPage;
    MyProperties myProperties;

    @BeforeMethod
    public void setupPropertyPages() {
        faker = new Faker();
        loginPage = new LoginPage(driver, wait);
        mainPage = new MainPage(driver, wait);
        propertyPage = new PropertyPage(driver, wait);
        myProperties = new MyProperties(driver, wait);
    }

    @Test
    public void editMyProperties() throws InterruptedException {
        loginPage.performLogin();
        mainPage.clickOnPropertyTab();
        propertyPage.searchProperty("Adresa12");
        Thread.sleep(2000);
        propertyPage.clickOnPropertyFound("Adresa12");
        Thread.sleep(2000);
        myProperties.clickOnAddNotesButton();
        String fakerWord = faker.lorem().word();
        myProperties.typeInNotes(fakerWord);
        Thread.sleep(2000);
        myProperties.clickOnSaveNoteButton();
        wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(myProperties.noteTextSelector),fakerWord));
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String currentDate = localDate.format(formatter);
        Assert.assertEquals(myProperties.getNoteDate(), currentDate);
        Assert.assertEquals(myProperties.getNoteText(), fakerWord);
    }
}
