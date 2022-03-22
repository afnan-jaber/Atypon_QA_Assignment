package com.springboot.tests.ui;

import com.springboot.common.BaseTest;
import com.springboot.pagemodels.AuthorsPage;
import com.springboot.pagemodels.NavBarHeaderPage;
import com.springboot.pagemodels.SearchPage;
import org.testng.annotations.Test;

import static com.springboot.utils.PropertiesReader.ReadData;

public class SearchPageTest extends BaseTest {

    @Test(description = "Verify searching page components.")
    public void testSearchForBook() throws Exception {
        String searchValue = ReadData("SEARCH_VALUE", testDataPath);
        NavBarHeaderPage navBarHeaderPage = new NavBarHeaderPage(driver);

        navBarHeaderPage.searchForText(searchValue);
        testHelper.verifyCurrentUrl(driver,"searchID=" + searchValue.replace(' ', '+'));

        SearchPage searchPage = new SearchPage(driver);
        searchPage.verifyCurrentPage();
    }
}
