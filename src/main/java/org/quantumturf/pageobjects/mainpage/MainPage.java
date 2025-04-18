package org.quantumturf.pageobjects.mainpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.quantumturf.pageobjects.HomePage;

import java.util.List;


public class MainPage extends HomePage {

    public final By logoSelector = By.cssSelector("img[src*='quantum-turf'");
    public final By profileDropDownMenu = By.cssSelector("img[src*='down_icon']");
    public final By programsTab = By.xpath("//div[.='Programs']");
    public final By clientTab = By.xpath("//div[.= 'Clients']");
    public final By schedulerTab = By.xpath("//div[.= 'Scheduler']");
    public final By propertyTab = By.xpath("//div[.= 'Properties']");
    public final By inventoryTab = By.xpath("//div[.= 'Inventory']");
    public final By myTeamOptionMenu = By.xpath("//div[.='My Team'][@class='dwn-navbar-option']");
    public final By logOutOptionMenu = By.xpath("//div[.='Logout']");
    public final By createProgramSelector = By.cssSelector(".green-button");
    public final By searchBar = By.cssSelector(".search-input-custom");
    //public final By itemsFoundListSelector = By.cssSelector("td[scope]");
    public final By itemsFoundListSelector = By.cssSelector("td[style*='50px']:nth-child(1)");
    public final By firstItemEditButton = By.cssSelector("tr:nth-child(1) img[src*='dots']");
    public final By secondItemEditButton = By.cssSelector("tr:nth-child(2) img[src*='dots']");
    public final By genericBackButton = By.cssSelector("div.open img[src*= 'back']");
    public final By itemSelector = By.cssSelector(".dwn-item");
    private final By searchInput = By.xpath("//input[@placeholder='Search']");



    public MainPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public boolean isLogoDisplayed() {

        return wait.until(ExpectedConditions.visibilityOfElementLocated(logoSelector)).isDisplayed();
    }

    public void clickOnInventoryTab() {
        identify(inventoryTab).click();
    }

    public void clickOnPropertyTab() {
        identify(propertyTab).click();
    }

    public void clickOnSchedulerTab() {
        identify(schedulerTab).click();
    }

    public void clickOnProfileDropDownMenu() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(profileDropDownMenu)).click();
    }

    public void clickOnLogOutOptionMenu() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(logOutOptionMenu)).click();
    }

    public void clickOnMyTeamOptionMenu() {
        driver.findElement(myTeamOptionMenu).click();
    }

    public void clickOnProgramsTab() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(programsTab)).click();
//        driver.findElement(programsTab).click();
    }

    public void clickOnCreateProgram() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(createProgramSelector)).click();
//        driver.findElement(createProgramSelector).click();
    }

    public void clickOnClientTab() {
        identify(clientTab).click();
    }

    public boolean isItemFound(String textToBeFound) {
        List<WebElement> elements = identifyList(itemsFoundListSelector);
        if (elements.isEmpty()) {
            return false;
        } else {
            for (WebElement webElement : elements) {
                if (webElement.getText().equals(textToBeFound)) {
                    return true;
                }
            }
        }

        return false;
    }

    public void searchItem(String textToBeFound) {
        identify(searchBar).sendKeys(textToBeFound);
    }

    public void clickOnFirstThreeDotsButton() {
        identify(firstItemEditButton).click();
    }
    public void clickOnSecondThreeDotsButton() {
        identify(secondItemEditButton).click();
    }
    public void clickOnGenericBackButton(){
        identify(genericBackButton).click();
    }
    public void selectFirstFoundItemFromDropDown() {
        identifyList(itemSelector).getFirst().click();
    }
    public void searchItemFromDropDown(String product) {
        identify(searchInput).sendKeys(product);
    }
    public void searchAndSelectItem(String item){
        searchItemFromDropDown(item);
        selectFirstFoundItemFromDropDown();
    }
}
