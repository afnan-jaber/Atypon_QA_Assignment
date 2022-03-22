package com.springboot.tests.ui;

import com.springboot.common.BaseTest;
import com.springboot.common.TestHelper;
import com.springboot.pagemodels.BooksPage;
import com.springboot.pagemodels.BooksTablePage;
import com.springboot.pagemodels.CreateBookPage;
import com.springboot.pagemodels.NavBarHeaderPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.springboot.utils.PropertiesReader.ReadData;

public class CreateBookTest extends BaseTest {

    @Test(description = "Verify create book page components.")
    public void testCreateBookPageComponents() {
        NavBarHeaderPage navBarHeaderPage = new NavBarHeaderPage(driver);
        navBarHeaderPage.clickOnBooksLink();

        BooksPage booksPage = new BooksPage(driver);
        booksPage.clickOnCreateBookLink();

        CreateBookPage createBookPage = new CreateBookPage(driver);
        createBookPage.verifyCurrentPage();
    }

    @Test(description = "Verify that user is able to create a new book.")
    public void testCreateNewBook() throws Exception {
        NavBarHeaderPage navBarHeaderPage = new NavBarHeaderPage(driver);
        navBarHeaderPage.clickOnBooksLink();

        BooksPage booksPage = new BooksPage(driver);
        booksPage.clickOnCreateBookLink();

        String bookTitle = ReadData("BOOK_TITLE", testDataPath)+TestHelper.getRandomNumberInRange(1,1000);
        String bookYear = ReadData("BOOK_YEAR", testDataPath);
        CreateBookPage createBookPage = new CreateBookPage(driver);
        createBookPage.createNewBook(bookTitle, bookYear);
        testHelper.verifyCurrentUrl(driver,ReadData("BOOKS_PAGE_LINK", testDataPath));

        BooksTablePage booksTablePage = new BooksTablePage(driver);

        Assert.assertTrue(booksTablePage.isBookTitleExists(bookTitle), bookTitle + " Verify that the added book " +
                "exist on the books table.");
    }

    @Test(description = "Verify clear button functionality.")
    public void testClearButtonFunctionality() throws Exception {
        NavBarHeaderPage navBarHeaderPage = new NavBarHeaderPage(driver);
        navBarHeaderPage.clickOnBooksLink();

        BooksPage booksPage = new BooksPage(driver);
        booksPage.clickOnCreateBookLink();

        String bookTitle = ReadData("Short_book_title", testDataPath) +TestHelper.getRandomNumberInRange(1,1000);
        String bookYear = ReadData("BOOK_YEAR", testDataPath);

        CreateBookPage createBookPage = new CreateBookPage(driver);
        createBookPage.sendKeysToTitleInputField(bookTitle);
        createBookPage.sendKeysToYearInputField(bookYear);

        createBookPage.clickOnSaveButton();
        createBookPage.clickOnClearButton();

        Assert.assertTrue(createBookPage.getTitleInputField().getAttribute("value").isEmpty());
        Assert.assertTrue(createBookPage.getYearInputField().getAttribute("value").isEmpty());
    }

    @Test(description = "Verify that title length should be longer that 8 characters")
    public void testTitleMinlengthValidation() throws Exception {
        NavBarHeaderPage navBarHeaderPage = new NavBarHeaderPage(driver);
        navBarHeaderPage.clickOnBooksLink();

        BooksPage booksPage = new BooksPage(driver);
        booksPage.clickOnCreateBookLink();

        String bookTitle = ReadData("Short_book_title", testDataPath) +TestHelper.getRandomNumberInRange(1,1000);
        String bookYear = ReadData("BOOK_YEAR", testDataPath);

        CreateBookPage createBookPage = new CreateBookPage(driver);
        createBookPage.sendKeysToTitleInputField(bookTitle);
        createBookPage.sendKeysToYearInputField(bookYear);

        createBookPage.clickOnSaveButton();
        createBookPage.verifyTitleLengthErrorMessage();
    }
}
