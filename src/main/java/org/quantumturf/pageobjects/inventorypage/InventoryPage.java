package org.quantumturf.pageobjects.inventorypage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.quantumturf.pageobjects.mainpage.MainPage;

import java.util.List;

public class InventoryPage extends MainPage {

    private final By searchInput = By.xpath("//input[@placeholder='Search']");
    private final By productName = By.cssSelector("td[style='min-width: 50px;']");

    public InventoryPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void searchProduct(String product) {
        identify(searchInput).sendKeys(product);
    }

    public Boolean isProductPresent(String product) {
        List<WebElement> productList = identifyList(productName);
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getText().equals(product)) {
                return true;
            }
        }
        return false;
    }

}
