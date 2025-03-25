package org.quantumturf.pageobjects.authorization;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.quantumturf.pageobjects.mainpage.MainPage;

public class RegistrationPage extends MainPage {
    public final By invalidFirstNameErrorMessage = By.xpath("//div[.='Invalid first name format.']");
    public final By invalidLastNameErrorMessage = By.xpath("//div[.='Invalid last name format.']");
    public final By lastNameFieldSelector = By.xpath("//div[.='Last Name']/../following-sibling::div/input");

    public RegistrationPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public String getInvalidFirstNameFormatErrorMessage() {
        return identify(invalidFirstNameErrorMessage).getText();
    }

    public String getInvalidLastNameFormatErrorMessage() {
        return identify(invalidLastNameErrorMessage).getText();
    }

    public void fillLastNameField(String lastName) {
        identify(lastNameFieldSelector).sendKeys(lastName);
    }


}
