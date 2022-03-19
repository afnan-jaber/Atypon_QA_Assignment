package com.springboot.pagemodels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * CreateBookPage Page - Page Model.
 * Contains all locators for create book page.
 */
public class CreateBookPage extends BooksActionsPage {

    @FindBy(xpath = "//h1[@class='page-header'][contains(text(),'Create')]")
    private WebElement createBookPageHeader;
    private String createBookLocatorName = "create book header";

    public CreateBookPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void verifyCurrentPage() {
        super.verifyCurrentPage();
        verifyCreateBookPageHeaderIsDisplayed();
    }

    public void verifyCreateBookPageHeaderIsDisplayed() {
        verifyElementExist(createBookPageHeader, createBookLocatorName);
    }

    public void createNewBook(String title, String year) {
        verifyTitleInputFieldIsDisplayed();
        sendKeysToTitleInputField(title);
        verifyYearInputFieldIsDisplayed();
        sendKeysToYearInputField(year);
        clickOnSaveButton();
    }
}
