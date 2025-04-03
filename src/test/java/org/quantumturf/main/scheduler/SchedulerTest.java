package org.quantumturf.main.scheduler;

import org.quantumturf.BaseTest;
import org.quantumturf.pageobjects.authorization.LoginPage;
import org.quantumturf.pageobjects.mainpage.MainPage;
import org.quantumturf.pageobjects.scheduler.SchedulerPage;
import org.quantumturf.utils.DevTools;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SchedulerTest extends BaseTest {
    LoginPage loginPage;
    MainPage mainPage;
    SchedulerPage schedulerPage;
    DevTools devTools;


    @BeforeMethod
    public void setUpPages() {
        loginPage = new LoginPage(driver, wait);
        mainPage = new MainPage(driver, wait);
        schedulerPage = new SchedulerPage(driver, wait);
        devTools = new DevTools(driver);
    }

    @Test
    public void mapControlsTest() throws InterruptedException {
        loginPage.performLogin();
        mainPage.clickOnSchedulerTab();
        schedulerPage.clickOnCameraControls();
        devTools.startInterception("maps.googleapis.com");
        schedulerPage.clickOnMapDownControl();
        Thread.sleep(2000);
        Assert.assertTrue(devTools.isRequestFound().get());
    }
}
