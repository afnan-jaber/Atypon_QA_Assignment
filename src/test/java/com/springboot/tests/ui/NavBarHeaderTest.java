package com.springboot.tests.ui;

import com.springboot.common.BaseTest;
import com.springboot.pagemodels.NavBarHeaderPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.springboot.utils.PropertiesReader.ReadData;

public class NavBarHeaderTest extends BaseTest {

    @Test(description = "Verify nav bar header components ")
    public void testNavBarComponents() {
        NavBarHeaderPage navBarHeaderPage = new NavBarHeaderPage(driver);
        navBarHeaderPage.verifyCurrentPage();
    }

    @Test(description = "Verify the nav bar text header.")
    public void testNavBarTextHeader() {
        NavBarHeaderPage navBarHeaderPage = new NavBarHeaderPage(driver);
        Assert.assertEquals(navBarHeaderPage.getNavBarHeaderLocatorName(), "Project name");
    }

    @Test(description = "Verify searching for a book.")
    public void testSearchForBook() throws Exception {
        String searchValue = ReadData("SEARCH_VALUE", testDataPath);
        NavBarHeaderPage navBarHeaderPage = new NavBarHeaderPage(driver);

        navBarHeaderPage.searchForText(searchValue);
        testHelper.verifyCurrentUrl(driver,"searchID=" + searchValue.replace(' ', '+'));
    }

    @Test(description = "Verify that user is redirected to Home page upon clicking on Home link.")
    public void testClickingOnHomeLink() throws Exception {
        NavBarHeaderPage navBarHeaderPage = new NavBarHeaderPage(driver);
        navBarHeaderPage.clickOnHomeLink();

        testHelper.verifyCurrentUrl(driver,ReadData("HOME_PAGE_LINK", testDataPath));
    }

    @Test(description = "Verify that user is redirected to Books page upon clicking on books link.")
    public void testClickingOnBooksLink() throws Exception {
        NavBarHeaderPage navBarHeaderPage = new NavBarHeaderPage(driver);
        navBarHeaderPage.clickOnBooksLink();

        testHelper.verifyCurrentUrl(driver,ReadData("BOOKS_PAGE_LINK", testDataPath));
    }

    @Test(description = "Verify that user is redirected to Authors page upon clicking on authors link.")
    public void testClickingOnAuthorsLink() throws Exception {
        NavBarHeaderPage navBarHeaderPage = new NavBarHeaderPage(driver);
        navBarHeaderPage.clickOnAuthorsLink();

        testHelper.verifyCurrentUrl(driver,ReadData("AUTHORS_PAGE_LINK", testDataPath));
    }
}
