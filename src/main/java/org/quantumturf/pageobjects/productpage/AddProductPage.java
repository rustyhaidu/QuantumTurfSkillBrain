package org.quantumturf.pageobjects.productpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.quantumturf.pageobjects.mainpage.MainPage;

public class AddProductPage extends MainPage {
    private final By addProductButton = By.xpath("//div[.='Add Product']");
    private final By inputProductName = By.cssSelector("input[placeholder='Product name']");
//    private final By categoryselector = By.xpath(".dwn-item");
//    private final By type = By.xpath(".dwn-item");
    private final By registrationNumber = By.cssSelector("input[placeholder = 'EPA Registration Number']");
    private final By priceProduct = By.cssSelector("input[placeholder*='00.00']");
    private final By quantityLbs = By.cssSelector("input[placeholder ='Quantity']");
    private final By attributesN = By.cssSelector("input[placeholder ='N']");
    private final By attributesP = By.cssSelector("input[placeholder ='P']");
    private final By attributesK = By.cssSelector("input[placeholder ='K']");
    private final By attributesCa = By.cssSelector("input[placeholder ='Ca']");
    private final By attributesMg = By.cssSelector("input[placeholder ='Mg']");
    private final By attributesS = By.cssSelector("input[placeholder ='S']");
    private final By attributesFe = By.cssSelector("input[placeholder ='Fe']");
    private final By attributesMn = By.cssSelector("input[placeholder ='Mn']");
    private final By saveTheForm = By.xpath("//div[.='Add Product']/../following-sibling::div/button");


    public AddProductPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void clickOnAddProduct() {
        identify(addProductButton).click();
    }

    public void nameProductField(String product) {
        driver.findElement(inputProductName).sendKeys(product);
    }

//    public void selectCategory() {
//        WebElement category = wait.until(ExpectedConditions.elementToBeClickable(categoryselector));
//        category.click();
//    }
//
//    public void selectorType() {
//        WebElement typeSelected = wait.until(ExpectedConditions.elementToBeClickable(type));
//        typeSelected.click();
//    }

    public void inputNumberRegistration(String number) {
        identify(registrationNumber).sendKeys(number);
    }

    public void insertPrice(String number) {
        identify(priceProduct).sendKeys(number);
    }

    public void insertQuantity(String number) {
        identify(quantityLbs).sendKeys(number);
    }

    public void attributesNField(String number) {
        identify(attributesN).sendKeys(number);
    }

    public void attributesPField(String number) {
        identify(attributesP).sendKeys(number);
    }

    public void attributesValueK(String number) {
        identify(attributesK).sendKeys(number);
    }

    public void attributesValueCa(String number) {
        identify(attributesCa).sendKeys(number);
    }

    public void attributesValueMg(String number) {
        identify(attributesMg).sendKeys(number);
    }

    public void attributesValueS(String number) {
        identify(attributesS).sendKeys(number);
    }

    public void attributesValueFe(String number) {
        identify(attributesFe).sendKeys(number);
    }

    public void attributesValueMn(String number) {
        identify(attributesMn).sendKeys(number);
    }

    public void clickOnAdd() {
        identify(saveTheForm).click();
    }
}
