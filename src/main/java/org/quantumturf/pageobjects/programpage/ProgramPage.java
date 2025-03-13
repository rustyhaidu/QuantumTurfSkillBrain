package org.quantumturf.pageobjects.programpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.quantumturf.pageobjects.HomePage;

public class ProgramPage extends HomePage {
    public final By programNameInputSelector = By.xpath("//div[.='Program Name']/../following-sibling::div/input");
    public final By zipCodeInputSelector = By.xpath("//div[.='Zip Code']/../following-sibling::div/input");
    public final By turfTypeInputSelector = By.cssSelector(".dwn-toggle");
    public final By warmSeasonSelector = By.cssSelector(".chip-warm");
    public final By nextCreateProgramButton = By.cssSelector(".green-button");

    public ProgramPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }


    public void fillProgramNameField(String programName) {
        identify(programNameInputSelector).sendKeys(programName);
    }

    public void fillZipCodeField(String zipCode) {
        driver.findElement(zipCodeInputSelector).sendKeys(zipCode);
    }

    public void clickOnTurfTypeMenu() {
        driver.findElement(turfTypeInputSelector).click();
    }

    public void clickOnWarmSeason() {
        driver.findElement(warmSeasonSelector).click();
    }

    public void clickOnNextCreateProgram() {
        driver.findElement(nextCreateProgramButton).click();
    }
}
