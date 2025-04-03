package org.quantumturf.pageobjects.scheduler;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.quantumturf.pageobjects.mainpage.MainPage;

public class SchedulerPage extends MainPage {
    private final By mapCameraControls = By.cssSelector("button[aria-label='Map camera controls']");
    private final By mapControlDown = By.cssSelector("button[aria-label='Move down']");


    public SchedulerPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void clickOnCameraControls() {
        identify(mapCameraControls).click();
    }

    public void clickOnMapDownControl() {
        identify(mapControlDown).click();
    }
}
