package org.quantumturf.pageobjects.propertypage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.quantumturf.pageobjects.mainpage.MainPage;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

public class PropertyPage extends MainPage {
    private final By search = By.cssSelector(".search-input-custom");
    private final By propertyCard = By.cssSelector(".card");
    private final By programSubTab = By.xpath("//div[.='Program']");
    private final By selectProgram = By.xpath("//div[.='Select Program']/following-sibling::div//img");
    private final By generateRounds = By.xpath("//div[.='Generate Rounds']");
    private final By calendarSelect = By.cssSelector("img[src*= 'calendar']");
    private final By buttonLeft = By.cssSelector("button.rmdp-left");
    private final By currentMonthAndYear = By.cssSelector("div.rmdp-header-values");
    private final By currentDay = By.cssSelector("div.rmdp-today[aria-label*='Choose']");
    private final By saveButton = By.xpath("//button[.='Save']");
    private final By clientName = By.cssSelector("div.text-larger");


    public PropertyPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void searchProperty(String address) {
        identify(search).sendKeys(address);
    }

    public boolean isPropertyFound(String address) {
        List<WebElement> properties = identifyList(propertyCard);
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
                break;
            }
        }
    }

    public void clickOnProgram() {
        identify(programSubTab).click();
    }

    public void clickOnSelectProgramDropDown() {
        identify(selectProgram).click();
    }

    public void clickOnGenerate() {
        identify(generateRounds).click();
    }

    public void clickOnCalendar() {
        identify(calendarSelect).click();
    }

    public void clickOnLeftArrow() {
        identify(buttonLeft).click();
    }

    public void selectCurrentDate() {
        LocalDate today = LocalDate.now();
        String month = today.format(DateTimeFormatter.ofPattern("MMMM", Locale.ENGLISH));
        //  int dayOfMonth = today.getDayOfMonth();
        int i = 12;
        while (i > 0) {
            WebElement monthAndYearElement = identify(currentMonthAndYear);
            String monthAndYearText = monthAndYearElement.getText();
            if (monthAndYearText.contains(month)) {
                identify(currentDay).click();
                return;
            } else {
                identify(buttonLeft).click();
            }
            i--;
        }
    }

    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        // String month = today.getMonth().toString();
//        System.out.println("Luna curenta este :" + month);
        //   String monthFormatted = month.substring(0, 1) + month.substring(1).toLowerCase();
        String month = today.format(DateTimeFormatter.ofPattern("MMMM", Locale.ENGLISH));
        System.out.println("Luna curenta este :" + month);
    }
    public void clickOnSave(){
        identify(saveButton).click();
    }
    public String getClientName(){
        return identify(clientName).getText();
    }
}
