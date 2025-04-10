package org.quantumturf.pageobjects.propertypage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.quantumturf.pageobjects.mainpage.MainPage;

import java.util.List;

public class PropertyPage extends MainPage {
    private final By search = By.cssSelector(".search-input-custom");
    private final By propertyCard = By.cssSelector(".card");
    private final By programSubTab = By.xpath("//div[.='Program']");
    private final By selectProgram = By.xpath("//div[.='Select Program']/following-sibling::div//img");
    private final By generateRounds = By.xpath("//div[.='Generate Rounds']");
    private final By calendarSelect = By.cssSelector("img[src*= 'calendar']");
    private final By buttonLeft = By.cssSelector("button.rmdp-left");
    public PropertyPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void searchProperty(String address) {
        identify(search).sendKeys(address);
    }

    public boolean isPropertyFound(String address) {
        List<WebElement>  properties = identifyList(propertyCard);
        for (int i = 0; i < properties.size(); i++) {
            WebElement addressElement = properties.get(i).findElement(By.cssSelector(".text-small"));
            String textElement = addressElement.getText();
            System.out.println("Adresa cardului este :" + textElement);
            if (addressElement.getText().contains(address)) {
                return true;
            }
        }
        return false;
    }

    public void clickOnPropertyFound(String address) {
        List<WebElement> properties = identifyList(propertyCard);
        for (int i = 0; i < properties.size(); i++) {
            WebElement addressElement = properties.get(i).findElement(By.cssSelector(".text-small"));
            if (addressElement.getText().contains(address)) {
                properties.get(i).click();
            }
        }
    }
    public void clickOnProgram(){
        identify(programSubTab).click();
    }
    public void clickOnSelectProgramDropDown(){
        identify(selectProgram).click();
    }
    public void clickOnGenerate(){
        identify(generateRounds).click();
    }
    public void clickOnCalendar(){
        identify(calendarSelect).click();
    }
    public void clickOnLeftArrow(){
        identify(buttonLeft).click();
    }
}
