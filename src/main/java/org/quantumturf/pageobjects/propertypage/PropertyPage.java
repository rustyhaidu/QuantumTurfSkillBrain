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
            if (!addressElement.getText().contains(address)) {
                return false;
            }
        }
        return true;
    }

}
