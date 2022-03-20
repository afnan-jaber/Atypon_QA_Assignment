package com.springboot.tests.ui;

import com.springboot.common.BaseTest;
import com.springboot.pagemodels.BooksPage;
import com.springboot.pagemodels.BooksTablePage;
import com.springboot.pagemodels.CreateBookPage;
import com.springboot.pagemodels.NavBarHeaderPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.springboot.utils.PropertiesReader.ReadData;

public class DeleteBookTest extends BaseTest {

    @Test(description = "Verify that user is able to delete a book.")
    public void testDeleteBook() throws Exception {
        NavBarHeaderPage navBarHeaderPage = new NavBarHeaderPage(driver);
        navBarHeaderPage.clickOnBooksLink();

        BooksPage booksPage = new BooksPage(driver);
        booksPage.clickOnCreateBookLink();

        String bookTitle = ReadData("BOOK_TITLE", testDataPath);
        String bookYear = ReadData("BOOK_YEAR", testDataPath);
        CreateBookPage createBookPage = new CreateBookPage(driver);
        createBookPage.createNewBook(bookTitle, bookYear);
        verifyCurrentUrl(ReadData("BOOKS_PAGE_LINK", testDataPath));

        BooksTablePage booksTablePage = new BooksTablePage(driver);
        int countOfBooks = booksTablePage.numberOfBooksRecords(bookTitle);
        booksTablePage.clickOnDeleteBook(bookTitle);

        int countOfBooksAfterDelete = booksTablePage.numberOfBooksRecords(bookTitle);

        Assert.assertEquals(countOfBooks - 1, countOfBooksAfterDelete, " Verify that a book " +
                "was deleted.");
    }
}
