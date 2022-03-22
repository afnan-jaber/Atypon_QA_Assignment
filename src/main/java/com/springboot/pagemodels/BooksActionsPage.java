package com.springboot.pagemodels;

import com.springboot.common.BasePageModels;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * BooksActionsPage Page - Page Model.
 * Contains all common locators and actions for create book and edit book pages.
 * A string value should be added for each locator to be used for logging purposes.
 */
public class BooksActionsPage extends BasePageModels {

    @FindBy(xpath = "//label[@for='productCode']")
    private WebElement titleHeaderLabel;
    private String titleHeaderLabelLocatorName = "Title Label";

    @FindBy(xpath = "//input[@id='title']")
    private WebElement titleInputField;
    private String titleInputFieldLocatorName = "Title input field";

    @FindBy(xpath = "//label[@for='productName']")
    private WebElement yearHeaderLabel;
    private String yearHeaderLabelLocatorName = "year label";

    @FindBy(xpath = "//input[@id='year']")
    private WebElement yearInputField;
    private String yearInputFieldLocatorName = "Year input field";

    @FindBy(xpath = "//label[@for='productCode']//following-sibling::b")
    private WebElement titleLengthErrorMessage;
    private String titleLengthErrorMessageLocatorName = "Title Length error message";

    @FindBy(xpath = "//button[contains(text(),'Save')]")
    private WebElement saveButton;
    private String saveButtonLocatorName = "save button";

    @FindBy(xpath = "//button[contains(text(),'Clear')]")
    private WebElement clearButton;
    private String clearButtonLocatorName = "clear button";

    /**
     * Constructor with driver instance.
     *
     * @param driver the WebDriver instance.
     */
    public BooksActionsPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Method to verify the existence of all elements on the page.
     */
    public void verifyCurrentPage() {
        verifyTitleHeaderLabelIsDisplayed();
        verifyTitleInputFieldIsDisplayed();
        verifyYearHeaderLabelIsDisplayed();
        verifyYearInputFieldIsDisplayed();
        verifySaveButtonLocatorName();
        verifyClearButtonLocatorName();
    }

    public void verifyTitleHeaderLabelIsDisplayed() {
        verifyElementExist(titleHeaderLabel, titleHeaderLabelLocatorName);
    }

    public void verifyTitleInputFieldIsDisplayed() {
        verifyElementExist(titleInputField, titleInputFieldLocatorName);
    }

    public void verifyYearHeaderLabelIsDisplayed() {
        verifyElementExist(yearHeaderLabel, yearHeaderLabelLocatorName);
    }

    public void verifyYearInputFieldIsDisplayed() {
        verifyElementExist(yearInputField, yearInputFieldLocatorName);
    }

    public void verifyTitleLengthErrorMessageLocatorName() {
        verifyElementExist(titleLengthErrorMessage, titleLengthErrorMessageLocatorName);
    }

    public void verifySaveButtonLocatorName() {
        verifyElementExist(saveButton, saveButtonLocatorName);
    }

    public void verifyClearButtonLocatorName() {
        verifyElementExist(clearButton, clearButtonLocatorName);
    }

    public void sendKeysToTitleInputField(String title) {
        sendKeysToElement(titleInputField, title, titleInputFieldLocatorName);
    }

    public void sendKeysToYearInputField(String year) {
        sendKeysToElement(yearInputField, year, yearInputFieldLocatorName);
    }

    public void clickOnSaveButton() {
        clickOnElement(saveButton, saveButtonLocatorName);
    }

    public void clickOnClearButton() {
        clickOnElement(clearButton, clearButtonLocatorName);
    }

    public void clearTitleInputField() {
        clearElement(titleInputField, titleInputFieldLocatorName);
    }

    public void clearYearInputField() {
        clearElement(yearInputField, yearInputFieldLocatorName);
    }
}
