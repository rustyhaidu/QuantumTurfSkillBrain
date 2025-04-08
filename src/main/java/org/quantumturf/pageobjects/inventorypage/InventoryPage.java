package org.quantumturf.pageobjects.inventorypage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.quantumturf.pageobjects.mainpage.MainPage;

import java.util.List;

public class InventoryPage extends MainPage {

    private final By searchInput = By.xpath("//input[@placeholder='Search']");
    private final By productName = By.cssSelector("td[style='min-width: 50px;']");
    private final By productExpandImgs = By.cssSelector("td img");
    private final By productsExtraInfo = By.cssSelector("div.green-header");

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

    public int expandAndCountEachProduct() {
        List<WebElement> products = identifyList(productExpandImgs);
        Actions actions = new Actions(driver);
        int i = 0;
        for ( i = 0; i < products.size(); i++) {
            WebElement crtElement = products.get(i);
            actions.moveToElement(crtElement).perform();
            crtElement.click();
        }
        return i;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
    }

    public int getNumberOfProductExtraInfo() {
        return identifyList(productsExtraInfo).size();
    }
}
