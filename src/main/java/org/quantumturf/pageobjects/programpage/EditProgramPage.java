package org.quantumturf.pageobjects.programpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.quantumturf.pageobjects.mainpage.MainPage;

public class EditProgramPage extends MainPage {
    private final By threePoints = By.xpath("//table/tbody/tr[1]/td[6]//div/div[1]");
    private final By buttonEdit = By.xpath("//table/tbody/tr[1]/td[8]/button");
    private final By addButton = By.xpath("//div[.= 'Add Product']");
    private final By select = By.cssSelector("button.dwn-toggle");
    private final By plantSelect = By.xpath("//div[contains(@class, 'dwn')]//li[2]");
    private final By rateLbs = By.cssSelector("input[placeholder]");
    private final By save = By.xpath("//div[.='Save']");
    //private final By edit = By.xpath("//table/tbody/tr[1]/td[8]/button");

    public EditProgramPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void clickOnPoints() {
        identify(threePoints).click();
    }

    public void clickOnButton() {
        identify(buttonEdit).click();
    }

    public void clickOnAdd() {
        identify(addButton).click();
    }

    public void clickOnSelect() {
        identify(select).click();
    }

    public void clickOnPlant() {
        identify(plantSelect).click();
    }

    public void insertbRate(String number) {
        identify(rateLbs).sendKeys(number);
    }

    public void clickOnSave(){
        identify(save).click();
    }
//    public void clickOnEditAgain(){
//        identify(edit).click();
//    }
}
