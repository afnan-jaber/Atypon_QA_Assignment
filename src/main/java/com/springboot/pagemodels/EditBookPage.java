package com.springboot.pagemodels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * editBookPage Page - Page Model.
 * Contains all locators for edit book page.
 * A string value should be added for each locator to be used for logging purposes.
 */
public class EditBookPage extends BooksActionsPage {

    @FindBy(xpath = "//h1[@class='page-header'][contains(text(),'Edit')]")
    private WebElement editBookPageHeader;
    private String editBookLocatorName = "Edit book header";

    /**
     * Constructor with driver instance.
     *
     * @param driver the WebDriver instance.
     */
    public EditBookPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    /**
     * Method to verify the existence of all elements on the page.
     */
    public void verifyCurrentPage() {
        super.verifyCurrentPage();
        verifyEditBookPageHeaderIsDisplayed();
    }

    public void verifyEditBookPageHeaderIsDisplayed() {
        verifyElementExist(editBookPageHeader, editBookLocatorName);
    }

    /*
     * This method will edit a book.
     * @param title : is the new value for book title.
     * @param year : is the new value of year for the book.
     * */
    public void editBook(String title, String year) {
        verifyTitleInputFieldIsDisplayed();
        clearTitleInputField();
        sendKeysToTitleInputField(title);
        verifyYearInputFieldIsDisplayed();
        clearYearInputField();
        sendKeysToYearInputField(year);
        clickOnSaveButton();
    }
}
