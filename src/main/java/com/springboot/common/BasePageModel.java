package com.springboot.common;

import com.springboot.utils.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/*
 *
 * */
public class BasePageModel {

    private static final int WAIT_TIME = 5;
    public WebDriver driver;
    WebDriverWait wait;

    public BasePageModel(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME));
        //Wait a specific amount of time before proceeding with the next step.
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WAIT_TIME));
    }

    /**
     * Get element text.
     *
     * @param element     : to get text from.
     * @param elementName : locator name to appear in the logs.
     */
    public String getElementText(WebElement element, String elementName) {
        String elementText = null;
        try {
            elementText = element.getText();
            Log.info(elementName + " element text value is : " + element.getText());
        } catch (Exception e) {
            Log.error(elementName + " element text value is : Null");
            throw e;
        }
        return elementText;
    }

    /**
     * Click on element.
     *
     * @param element     : element to be clicked.
     * @param elementName : element locator name to appear in the logs.
     */
    public void clickOnElement(WebElement element, String elementName) {
        try {
            element.click();
            Log.info("Click on element : " + elementName);
        } catch (Exception e) {
            Log.error("Clicking on element : " + elementName + "was FAILED !");
            throw e;
        }
    }

    /**
     * Send keys to element.
     *
     * @param element     : element to type value in.
     * @param elementName : locator name to appear in the logs.
     */
    public void sendKeysToElement(WebElement element, String value, String elementName) {
        try {
            element.sendKeys(value);
            Log.info("Type \"" + value + "\" into element: " + elementName);
        } catch (Exception e) {
            Log.error("Sending keys to : " + elementName + " was FAILED !");
            throw e;
        }
    }

    /**
     * clear element.
     *
     * @param element     : element to clear.
     * @param elementName : locator name to appear in the logs.
     */
    public void clearElement(WebElement element, String elementName) {
        try {
            element.clear();
            Log.info("Clear element : " + elementName);
        } catch (Exception e) {
            Log.error("Clearing element : " + elementName + " was FAILED !");
            throw e;
        }
    }

    public void verifyElementExist(WebElement element, String elementName) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            Log.info(elementName + " : element is visible.");
        } catch (Exception e) {
            Log.error(elementName + " : element is not visible.");
            throw e;
        }
    }

    public void waitVisibilityOfElement(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
