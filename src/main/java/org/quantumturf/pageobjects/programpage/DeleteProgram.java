package org.quantumturf.pageobjects.programpage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.quantumturf.pageobjects.HomePage;

import java.time.Duration;

public class DeleteProgram extends HomePage {
    public final By programNameInputSelector = By.xpath("//div[.='Program Name']/../following-sibling::div/input");
    public final By zipCodeInputSelector = By.xpath("//div[.='Zip Code']/../following-sibling::div/input");
    public final By buttonSelect = By.xpath("//div[.='Select']");
    public final By warmSeasonSelector = By.cssSelector("button.dwn-toggle");
    public final By turfTypeInputSelector = By.cssSelector(".dwn-toggle");
    public final By nextCreateProgramButton = By.cssSelector(".btn");
    public final By weedControl = By.xpath("//div[.='Weed Control']");
    public final By selectMonths = By.cssSelector(".clickable.months.month-active");
    public final By pestControl = By.xpath("//div[.='Pest Control']");
    public final By selectMonthsPC = By.cssSelector(".clickable.months.month-active");
    public final By buttonNext = By.cssSelector(".btn");
    public final By buttonDelete = By.cssSelector("img[src*='assets/img/trash.svg']");


    public DeleteProgram(WebDriver driver, WebDriverWait wait) {
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

    public void clickOnButtonSelect() {
        driver.findElement(buttonSelect).click();
    }

    public void clickOnWarmSeason() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(warmSeasonSelector));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();
    }


    public void clickOnNextCreateProgram() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".btn")));
        element.click();
    }

    public void clickOnWeedControl() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(weedControl)).click();
    }

    public void clickOnSelectMonths() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(selectMonths)).click();
    }

    public void clickOnPestControl() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(pestControl)).click();
    }
    public void clickOnSelectMonthsPC() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(selectMonthsPC)).click();
    }
    public void clickOnButtonNext(){
        driver.findElement(buttonNext).click();
    }
    public void clickOnTrash() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement button = wait.until(ExpectedConditions.visibilityOfElementLocated(buttonDelete));
        button.click();
    }
}
