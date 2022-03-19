package com.springboot.pagemodels;

import com.springboot.utils.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * BooksTablePage Page - Page Model.
 * Contains all locators for books table pages.
 */
public class BooksTablePage extends BooksPage {

    @FindBy(xpath = "//table[@class='table table-striped']//tbody//tr//td[1]")
    private List<WebElement> booksTitlesList;
    private String booksTitlesListLocatorName = "book's titles";

    @FindBy(xpath = "//table[@class='table table-striped']//tbody//tr//td[2]")
    private List<WebElement> booksYearsList;
    private String booksYearsListLocatorName = "book's Years";

    @FindBy(xpath = "//table[@class='table table-striped']//tbody//tr//td[4]//a")
    private List<WebElement> deleteButtonsList;
    private String deleteButtonsListLocatorName = "Delete buttons";

    @FindBy(xpath = "//table[@class='table table-striped']//tbody//tr//td[3]//a")
    private List<WebElement> editButtonsList;
    private String editButtonsListLocatorName = "Edit buttons";

    public BooksTablePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    /*
     * This method will return the index of the book from book titles list.
     * it will return -1 if book title does not exist.
     * */
    public int getBookIndex(String bookTitle) {
        try {
            for (int i = 0; i < booksTitlesList.size(); i++) {
                if (booksTitlesList.get(i).getText().equalsIgnoreCase(bookTitle)) {
                    return i;
                }
            }
        } catch (Exception e) {
            Log.error("Book table is empty.");
        }
        return -1;
    }

    /*
     * This method will return true if the book title exists in the book titles list.
     * it will return false if the book title does not exist.
     * */
    public boolean isBookTitleExists(String bookTitle) {
        if (getBookIndex(bookTitle) >= 0) {
            return true;
        }
        return false;
    }

    /*
     * This method will click on edit button.
     * @param : bookTitle is the the title of the book to be edited.
     * */
    public void clickOnEditBookLink(String bookTitle) {

        int index = getBookIndex(bookTitle);
        if (index > 0) {
            clickOnElement(editButtonsList.get(index), editButtonsListLocatorName);
        }
    }

    /*
     * This method will click on delete button.
     * @param bookTitle is the the title of the book to be edited.
     * */
    public void clickOnDeleteBook(String bookTitle) {

        int index = getBookIndex(bookTitle);
        if (index > 0) {
            clickOnElement(deleteButtonsList.get(index), deleteButtonsListLocatorName);
        }
    }

    /*
     * This method will count the number of books with the same title.
     * @param bookTitle is the the title of the book to be counted.
     * */
    public int numberOfBooksRecords(String bookTitle) {
        int bookCount = 0;
        try {
            for (int i = 0; i < booksTitlesList.size(); i++) {
                if (booksTitlesList.get(i).getText().equalsIgnoreCase(bookTitle)) {
                    bookCount++;
                }
            }
        } catch (Exception e) {
            Log.error("Book table is empty.");
        }
        return bookCount;
    }
}
