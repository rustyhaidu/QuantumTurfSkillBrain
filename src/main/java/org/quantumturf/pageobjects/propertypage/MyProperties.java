package org.quantumturf.pageobjects.propertypage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.quantumturf.pageobjects.mainpage.MainPage;

public class MyProperties extends MainPage {

    public final By addNotesButtonSelector = By.xpath("//div[.='Notes']//button");
    public final By inputNewNoteSelector = By.cssSelector("textarea");
    public final By saveNoteButtonSelector = By.xpath("//button[.='Save Note']");
    public final By noteDateSelector = By.cssSelector("td.pt-0 div:nth-child(1)");
    public final By noteTextSelector = By.cssSelector("td.pt-0 div:nth-child(2)");

    public MyProperties(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }


    public void clickOnAddNotesButton() {
        driver.findElement(addNotesButtonSelector).click();
    }

    public void typeInNotes(String note) {
        driver.findElement(inputNewNoteSelector).sendKeys(note);
    }

    public void clickOnSaveNoteButton() {
        driver.findElement(saveNoteButtonSelector).click();
    }

    public String getNoteDate(){
        return driver.findElement(noteDateSelector).getText();

    }
    public String getNoteText(){
        return driver.findElement(noteTextSelector).getText();

    }
}
