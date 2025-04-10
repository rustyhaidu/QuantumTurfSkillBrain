package org.quantumturf.pageobjects.programpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.quantumturf.pageobjects.mainpage.MainPage;

import java.util.List;

public class ProgramPage extends MainPage {
    public final By programNameInputSelector = By.xpath("//div[.='Program Name']/../following-sibling::div/input");
    public final By zipCodeInputSelector = By.xpath("//div[.='Zip Code']/../following-sibling::div/input");
    public final By turfTypeInputSelector = By.cssSelector(".dwn-toggle");
    public final By warmSeasonSelector = By.cssSelector(".chip-warm");
    public final By coolSeasonSelector = By.cssSelector(".chip-cool");
    public final By nextCreateProgramButton = By.cssSelector(".green-button:not([disabled])");
    public final By weedControl = By.xpath("//div[.='Weed Control']");
    public final By pestControl = By.xpath("//div[.='Pest Control']");
    public final By monthListSelector = By.cssSelector(".months");
    public final By buttonsDelete = By.cssSelector("img[src*='assets/img/trash.svg']");


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

    public void clickOnCoolSeason() {
        driver.findElement(coolSeasonSelector).click();
    }

    public void clickOnNextCreateProgram() {
        wait.until(ExpectedConditions.elementToBeClickable(nextCreateProgramButton)).click();
    }

    public void clickOnWeedControl() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(weedControl)).click();
    }

    public void clickOnPestControl() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(pestControl)).click();
    }

    public void selectMonths(String... months) {
        List<WebElement> monthList = driver.findElements(monthListSelector);

        for (WebElement actualMonth : monthList) {
            for (String expMonth : months) {
                if (actualMonth.getText().equals(expMonth)) {
                    actualMonth.click();
                }
            }
        }
    }

    public void clickOnFirstTrashIcon() {
        List<WebElement> buttons = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(buttonsDelete));
        buttons.getFirst().click();
    }
}
