package com.springboot.pagemodels;

import com.springboot.common.BasePageModels;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


/**
 * SearchPage Page - Page Model.
 * Contains all common locators and actions for search page.
 * A string value should be added for each locator to be used for logging purposes.
 */
public class SearchPage extends BasePageModels {

    // All page components should be added here once they are available
    @FindBy(xpath = "//title")
    private WebElement searchPageTitle;
    private String searchPageTitleLocatorName = "Search Page Title";

    /**
     * Constructor with driver instance.
     *
     * @param driver the WebDriver instance.
     */
    public SearchPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    /**
     * Method to verify the existence of all elements on the page.
     */
    public void verifyCurrentPage() {
        verifyAuthorsPageTitleIsDisplayed();
    }

    public void verifyAuthorsPageTitleIsDisplayed() {
        verifyElementExist(searchPageTitle, searchPageTitleLocatorName);
    }

    public String  getTitleValue() {
        return getElementText(searchPageTitle, searchPageTitleLocatorName);
    }
}
