package com.springboot.tests.ui;

import com.springboot.common.BaseTest;
import com.springboot.pagemodels.BooksPage;
import com.springboot.pagemodels.NavBarHeaderPage;
import org.testng.annotations.Test;

public class BooksPageTest extends BaseTest {

    @Test(description = "Verify books page components.")
    public void testClickingOnBooksLink() {
        NavBarHeaderPage navBarHeaderPage = new NavBarHeaderPage(driver);
        navBarHeaderPage.clickOnBooksLink();

        BooksPage booksPage = new BooksPage(driver);
        booksPage.verifyCurrentPage();
    }
}
