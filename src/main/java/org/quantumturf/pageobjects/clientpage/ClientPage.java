package org.quantumturf.pageobjects.clientpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.quantumturf.pageobjects.mainpage.MainPage;

public class ClientPage extends MainPage {
    public final By addClientButton = By.cssSelector(".green-button");
    public final By firstName = By.xpath("//div[.='First Name']/../following-sibling::div/input");
    public final By lastName = By.xpath("//div[.='Last Name']/../following-sibling::div/input");
    public final By emailInput = By.cssSelector("input[placeholder='Email']");
    public final By phoneNumber = By.cssSelector("input[placeholder*='0000000']");
    public final By addressInput = By.cssSelector("input[placeholder *='12345']");
    public final By citySelector = By.xpath("//div[.='City']/../following-sibling::div/input");
    public final By zipCode = By.cssSelector("input[placeholder= '000000']");
    public final By selectState = By.cssSelector(".dwn-toggle");
    public final By searchState = By.cssSelector("//div[.='State']/../following-sibling::div/div/input");

    public ClientPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void clickOnClientButton() {
        driver.findElement(addClientButton).click();
    }

    public void inputFirstName(String firstName) {
        identify(this.firstName).sendKeys(firstName);
    }
}
