package com.springboot.pagemodels;

import com.springboot.common.BasePageModels;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * BooksPage Page - Page Model.
 * Contains all locators for books pages.
 */
public class BooksPage extends BasePageModels {

    @FindBy(xpath = "//h1[contains(.,'Books')]")
    private WebElement booksHeader;
    private String booksHeaderLocatorName = "Books header";

    @FindBy(xpath = "//table[@class='table table-striped']//th[contains(.,'Title')]")
    private WebElement titleHeader;
    private String titleHeaderLocatorName = "Title header";

    @FindBy(xpath = "//table[@class='table table-striped']//th[contains(.,'Year')]")
    private WebElement yearHeader;
    private String yearHeaderLocatorName = "Year header";

    @FindBy(xpath = "//a[contains(@href,'/books/create')]")
    private WebElement createBookLink;
    private String createBookLinkLocatorName = "Year header";

    /**
     * Constructor with driver instance.
     *
     * @param driver the WebDriver instance.
     */
    public BooksPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    /**
     * Method to verify the existence of all elements on the page.
     */
    public void verifyCurrentPage() {
        verifyBooksHeaderIsDisplayed();
        verifyTitleHeaderIsDisplayed();
        verifyYearHeaderIsDisplayed();
        verifyCreateBookLinkIsDisplayed();
    }

    public void verifyBooksHeaderIsDisplayed() {
        verifyElementExist(booksHeader, booksHeaderLocatorName);
    }

    public void verifyTitleHeaderIsDisplayed() {
        verifyElementExist(titleHeader, titleHeaderLocatorName);
    }

    public void verifyYearHeaderIsDisplayed() {
        verifyElementExist(yearHeader, yearHeaderLocatorName);
    }

    public void verifyCreateBookLinkIsDisplayed() {
        verifyElementExist(createBookLink, createBookLinkLocatorName);
    }

    public void clickOnCreateBookLink() {
        verifyCreateBookLinkIsDisplayed();
        clickOnElement(createBookLink, createBookLinkLocatorName);
    }


}
