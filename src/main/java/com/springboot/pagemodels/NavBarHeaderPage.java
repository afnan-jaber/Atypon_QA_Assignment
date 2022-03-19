package com.springboot.pagemodels;

import com.springboot.common.BasePageModel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * NavBarHeaderPage Page - Page Model.
 * Contains all locators for nav bar header page.
 */
public class NavBarHeaderPage extends BasePageModel {

    @FindBy(css = "a.navbar-brand")
    private WebElement navBarHeader;
    private String navBarHeaderLocatorName = "Navigation bar header";

    @FindBy(id = "searchID")
    private WebElement searchInputField;
    private String searchInputFiledLocatorName = "Search input field";

    @FindBy(css = "#searchForm button")
    private WebElement searchButton;
    private String searchButtonLocatorName = "Search button";

    @FindBy(xpath = "//div[@id='navbar']//a[contains(text(),'Home')]")
    private WebElement homeLink;
    private String homeLinkLocatorName = "Home link";

    @FindBy(xpath = "//div[@id='navbar']//a[contains(@href,'books')]")
    private WebElement booksLink;
    private String homeLinkBooksLocatorName = "books link";

    @FindBy(xpath = "//div[@id='navbar']//a[contains(@href,'authors')]")
    private WebElement authorsLink;
    private String authorsLinkBooksLocatorName = "Authors link";

    public NavBarHeaderPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void verifyCurrentPage() {
        verifyNavBarElementIsDisplayed();
        verifySearchInputField();
        verifySearchButtonIsDisplayed();
        verifyHomeLinkIsDisplayed();
        verifyBooksLinkIsDisplayed();
        verifyAuthorsLinkIsDisplayed();
    }

    public void verifyNavBarElementIsDisplayed() {
        verifyElementExist(navBarHeader, navBarHeaderLocatorName);
    }

    public void verifySearchInputField() {
        verifyElementExist(searchInputField, searchInputFiledLocatorName);
    }

    public void verifySearchButtonIsDisplayed() {
        verifyElementExist(searchButton, searchButtonLocatorName);
    }

    public void verifyHomeLinkIsDisplayed() {
        verifyElementExist(homeLink, homeLinkLocatorName);
    }

    public void verifyBooksLinkIsDisplayed() {
        verifyElementExist(booksLink, homeLinkBooksLocatorName);
    }

    public void verifyAuthorsLinkIsDisplayed() {
        verifyElementExist(authorsLink, authorsLinkBooksLocatorName);
    }


    public String getNavBarHeaderLocatorName() {
        waitVisibilityOfElement(navBarHeader);
        return getElementText(navBarHeader, navBarHeaderLocatorName);
    }

    public void typeInSearchTextField(String searchValue) {
        sendKeysToElement(searchInputField, searchValue, searchInputFiledLocatorName);
    }

    public void clickOnSearchButton() {
        clickOnElement(searchButton, searchButtonLocatorName);
    }

    public void searchForText(String searchValue) {
        typeInSearchTextField(searchValue);
        clickOnSearchButton();
    }

    public void clickOnHomeLink() {
        clickOnElement(homeLink, homeLinkLocatorName);
    }

    public void clickOnBooksLink() {
        clickOnElement(booksLink, homeLinkBooksLocatorName);
    }

    public void clickOnAuthorsLink() {
        clickOnElement(authorsLink, authorsLinkBooksLocatorName);
    }
}
