package com.springboot.tests.ui;

import com.springboot.common.BaseTest;
import com.springboot.pagemodels.BooksPage;
import com.springboot.pagemodels.HomePage;
import com.springboot.pagemodels.NavBarSideBarPage;
import org.testng.annotations.Test;

import static com.springboot.utils.PropertiesReader.ReadData;

public class NavBarSideBarTest extends BaseTest {

    @Test(description = "Verify that user is redirected to Home page upon clicking on Home link.")
    public void testClickingOnHomeLink() {
        NavBarSideBarPage navBarSideBarPage = new NavBarSideBarPage(driver);
        navBarSideBarPage.clickOnHomeLink();

        HomePage homePage = new HomePage(driver);
        homePage.verifyCurrentPage();
    }

    @Test(description = "Verify that user is redirected to Books page upon clicking on books link.")
    public void testClickingOnBooksLink() {
        NavBarSideBarPage navBarSideBarPage = new NavBarSideBarPage(driver);
        navBarSideBarPage.clickOnBooksLink();

        BooksPage booksPage = new BooksPage(driver);
        booksPage.verifyCurrentPage();
    }

    @Test(description = "Verify that user is redirected to Authors page upon clicking on authors link.")
    public void testClickingOnAuthorsLink() throws Exception {
        NavBarSideBarPage navBarSideBarPage = new NavBarSideBarPage(driver);
        navBarSideBarPage.clickOnAuthorsLink();
        testHelper.verifyCurrentUrl(driver,ReadData("AUTHORS_PAGE_LINK", testDataPath));
    }
}
