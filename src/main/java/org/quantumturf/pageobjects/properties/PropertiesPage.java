package org.quantumturf.pageobjects.properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.quantumturf.pageobjects.HomePage;
import org.quantumturf.pageobjects.mainpage.MainPage;

import java.util.ArrayList;
import java.util.List;

public class PropertiesPage extends MainPage {
    private final By searchTab = By.cssSelector("input[placeholder ='Search']");
    private final By propertyCard = By.cssSelector(".card");

    public PropertiesPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void insertSearchTab(String address) {
        identify(searchTab).sendKeys(address);
    }

    public boolean isPropertyFound(String address) {
        List<WebElement> properties = identifyList(propertyCard);
        for (int i = 0; i < properties.size(); i++) {
            WebElement addressElement = properties.get(i).findElement(By.cssSelector(".text-small"));
        if (!addressElement.getText().equals(address)) {
                return false;
            }
        }
        return true;
    }
}
