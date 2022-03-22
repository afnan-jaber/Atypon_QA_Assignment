package com.springboot.pagemodels;

import com.springboot.common.BasePageModels;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * HomePage Page - Page Model.
 * Contains all locators for home page.
 */
public class HomePage extends BasePageModels {

    @FindBy(xpath = "//div[@class = 'container-fluid']//div[contains(text(),'Hello Test Automation')]")
    private WebElement homePageHeader;
    private String homePageLocatorName = "Home Page Header";

    /**
     * Constructor with driver instance.
     *
     * @param driver the WebDriver instance.
     */
    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    /**
     * Method to verify the existence of all elements on the page.
     */
    public void verifyCurrentPage() {
        verifyHomePageHeaderIsDisplayed();
    }

    public void verifyHomePageHeaderIsDisplayed() {
        verifyElementExist(homePageHeader, homePageLocatorName);
    }
}
