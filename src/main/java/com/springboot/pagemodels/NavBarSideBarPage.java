package com.springboot.pagemodels;

import com.springboot.common.BasePageModels;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * NavBarSideBarPage Page - Page Model.
 * Contains all locators for nav side bar page.
 */
public class NavBarSideBarPage extends BasePageModels {

    @FindBy(xpath = "//ul[@class='nav nav-sidebar']//a[contains(text(),'Home')]")
    private WebElement homeLink;
    private String homeLinkLocatorName = "Home link ";

    @FindBy(xpath = "//ul[@class='nav nav-sidebar']//a[contains(text(),'Books')]")
    private WebElement booksLink;
    private String homeLinkBooksLocatorName = "books link";

    @FindBy(xpath = "//ul[@class='nav nav-sidebar']//a[contains(text(),'Authors')]")
    private WebElement authorsLink;
    private String authorsLinkBooksLocatorName = "Authors link";

    /**
     * Constructor with driver instance.
     *
     * @param driver the WebDriver instance.
     */
    public NavBarSideBarPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    /**
     * Method to verify the existence of all elements on the page.
     */
    public void verifyCurrentPage() {
        verifyHomeLinkIsDisplayed();
        verifyBooksLinkIsDisplayed();
        verifyAuthorsLinkIsDisplayed();
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
