package org.quantumturf;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.quantumturf.utils.Constants;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CitireParagraf extends org.quantumturf.BaseTest {

    @Test
    public void extragereparagraf() {
        /*WebElement makesButton = driver.findElement(By.cssSelector("#hs_cos_wrapper_widget_1739158895626 > " +
                "section > details:nth-child(1) > summary"));*/
        // WebElement makesButton = driver.findElement(By.cssSelector("details:nth-child(1)"));

        //WebElement makesButton = driver.findElement(By.xpath("//*[.='What makes Quantum Turf different from other lawn care software?']"));
        WebElement makesButton = driver.findElement(By.xpath("//*[.='What makes Quantum Turf different from other lawn care software?']"));

        makesButton.click();

/*        WebElement citireText = driver.findElement(By.cssSelector("#hs_cos_wrapper_widget_1739158895626 >" +
                " section > details:nth-child(1) > div > div > p > span"));  */
        //WebElement citireText = driver.findElement(By.cssSelector("details[open] span"));
        // WebElement citireText = driver.findElement(By.xpath("//details[@open]//span"));

        WebElement citireText = driver.findElement(By.xpath("//details[@open]//span"));
        Actions actions = new Actions(driver);
        actions.moveToElement(citireText).click().perform();

        String expectedText = Constants.FIRST_PARAGRAPH_FAQ;
        String textExtras = citireText.getText();
        System.out.println("Textul este :" + textExtras);

        Assert.assertEquals(textExtras, expectedText, "Verificam ca textele coincid");
    }
}
