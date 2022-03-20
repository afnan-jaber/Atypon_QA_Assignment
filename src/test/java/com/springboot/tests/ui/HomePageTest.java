package com.springboot.tests.ui;

import com.springboot.common.BaseTest;
import com.springboot.pagemodels.HomePage;
import com.springboot.pagemodels.NavBarHeaderPage;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {

    @Test(description = "Verify Home page components.")
    public void testClickingOnHomeLink() {
        NavBarHeaderPage navBarHeaderPage = new NavBarHeaderPage(driver);
        navBarHeaderPage.clickOnHomeLink();

        HomePage homePage = new HomePage(driver);
        homePage.verifyCurrentPage();}
}
