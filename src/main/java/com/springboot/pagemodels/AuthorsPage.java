package com.springboot.pagemodels;

import com.springboot.common.BasePageModels;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AuthorsPage extends BasePageModels {

    // All page components should be added here once they are available
    @FindBy(xpath = "//title")
    private WebElement authorsPageTitle;
    private String authorsPageTitleLocatorName = "Authors Page Title";

    public AuthorsPage(WebDriver driver) {
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
        verifyElementExist(authorsPageTitle, authorsPageTitleLocatorName);
    }

    public String  getTitleValue() {
        return getElementText(authorsPageTitle, authorsPageTitleLocatorName);
    }
}
