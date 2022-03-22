package com.springboot.pagemodels;

import com.springboot.common.BasePageModels;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePageModels {

    // All page components should be added here once they are available
    @FindBy(xpath = "//title")
    private WebElement searchPageTitle;
    private String searchPageTitleLocatorName = "Search Page Title";

    public SearchPage(WebDriver driver) {
        super(driver);
    }

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
