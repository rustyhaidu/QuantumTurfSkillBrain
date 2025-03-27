package org.quantumturf.pageobjects.programpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.quantumturf.pageobjects.mainpage.MainPage;

import java.util.List;

public class EditProgramPage extends MainPage {
    private boolean isProductFound = true;

    private final By editButtons = By.cssSelector("table button");
    private final By addButton = By.xpath("//div[.= 'Add Product']");
    private final By selectProduct = By.cssSelector("button.dwn-toggle");
    private final By selectProductList = By.tagName("li");
    private final By rateLbs = By.cssSelector("input[placeholder]");
    private final By save = By.xpath("//div[.='Save']");
    //private final By edit = By.xpath("//table/tbody/tr[1]/td[8]/button");


    public EditProgramPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void clickOnEditButton(int index) {
        identifyList(editButtons).get(index).click();
    }

    public void clickOnAdd() {
        identify(addButton).click();
    }

    public void clickOnSelectProduct() {
        identify(selectProduct).click();
    }

    public void clickOnSelectedProductFromList(String productName) {
        List<WebElement> products = identifyList(selectProductList);
        for (WebElement webElement : products) {
            if (webElement.getText().equals(productName)) {
                webElement.click();
                break;
            }
        }
    }

    public void clickOnSelectedProduct(String productName) {
        identify(By.xpath("//li[.='" + productName + "']")).click();
    }

    public void insertRate(String number) {
        identify(rateLbs).clear();
        identify(rateLbs).sendKeys(number);
    }

    public void clickOnSave() {
        identify(save).click();
    }
//    public void clickOnEditAgain(){
//        identify(edit).click();
//    }

    public void clickOnTrashByProductName(String productName) {
        try {
            identify(By.xpath("//td[.='" + productName + "']/preceding-sibling::td//img[contains(@src,'trash')]")).click();
        } catch (Exception e) {
            isProductFound = false;
        }
    }

    public boolean isProductFound(){
        return isProductFound;
    }

}

