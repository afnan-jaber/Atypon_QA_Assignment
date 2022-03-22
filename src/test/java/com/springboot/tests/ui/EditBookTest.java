package com.springboot.tests.ui;

import com.springboot.common.BaseTest;
import com.springboot.pagemodels.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.springboot.utils.PropertiesReader.ReadData;

public class EditBookTest extends BaseTest {

    @Test(description = "Verify edit book page components.")
    public void testEditBookPageComponents() {
        NavBarHeaderPage navBarHeaderPage = new NavBarHeaderPage(driver);
        navBarHeaderPage.clickOnBooksLink();

        BooksPage booksPage = new BooksPage(driver);
        booksPage.clickOnCreateBookLink();

        CreateBookPage createBookPage = new CreateBookPage(driver);
        createBookPage.verifyCurrentPage();
    }

    @Test(description = "Verify that user is able to edit a book.")
    public void testEditBook() throws Exception {
        NavBarHeaderPage navBarHeaderPage = new NavBarHeaderPage(driver);
        navBarHeaderPage.clickOnBooksLink();

        BooksPage booksPage = new BooksPage(driver);
        booksPage.clickOnCreateBookLink();

        String bookTitle = ReadData("BOOK_TITLE", testDataPath);
        String bookYear = ReadData("BOOK_YEAR", testDataPath);
        CreateBookPage createBookPage = new CreateBookPage(driver);
        createBookPage.createNewBook(bookTitle, bookYear);
        testHelper.verifyCurrentUrl(driver,ReadData("BOOKS_PAGE_LINK", testDataPath));

        BooksTablePage booksTablePage = new BooksTablePage(driver);
        booksTablePage.clickOnEditBookLink(bookTitle);
        testHelper.verifyCurrentUrl(driver,ReadData("EDIT_PAGE_LINK", testDataPath));

        String editBookTitle = ReadData("BOOK_EDITED_TITLE", testDataPath);
        String editBookYear = ReadData("BOOK_EDITED_YEAR", testDataPath);
        EditBookPage editBookPage = new EditBookPage(driver);
        editBookPage.editBook(editBookTitle, editBookYear);
        testHelper.verifyCurrentUrl(driver,ReadData("BOOKS_PAGE_LINK", testDataPath));

        Assert.assertTrue(booksTablePage.isBookTitleExists(editBookTitle), editBookYear + " Verify that the added book " +
                "exist on the books table.");
    }

    @Test(description = "Verify clear button functionality.")
    public void testClearButtonFunctionality() throws Exception {
        NavBarHeaderPage navBarHeaderPage = new NavBarHeaderPage(driver);
        navBarHeaderPage.clickOnBooksLink();

        BooksPage booksPage = new BooksPage(driver);
        booksPage.clickOnCreateBookLink();

        String bookTitle = ReadData("BOOK_TITLE", testDataPath);
        String bookYear = ReadData("BOOK_YEAR", testDataPath);
        CreateBookPage createBookPage = new CreateBookPage(driver);
        createBookPage.createNewBook(bookTitle, bookYear);
        testHelper.verifyCurrentUrl(driver,ReadData("BOOKS_PAGE_LINK", testDataPath));

        BooksTablePage booksTablePage = new BooksTablePage(driver);
        booksTablePage.clickOnEditBookLink(bookTitle);

        EditBookPage editBookPage = new EditBookPage(driver);
        editBookPage.clickOnClearButton();

        Assert.assertTrue(createBookPage.getTitleInputField().getAttribute("value").isEmpty());
        Assert.assertTrue(createBookPage.getYearInputField().getAttribute("value").isEmpty());
    }
}
