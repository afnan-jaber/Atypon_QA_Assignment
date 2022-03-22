package com.springboot.tests.ui;

import com.springboot.common.BaseTest;
import com.springboot.pagemodels.AuthorsPage;
import com.springboot.pagemodels.BooksPage;
import com.springboot.pagemodels.NavBarHeaderPage;
import org.testng.annotations.Test;

import java.util.Collections;

import static org.testng.Assert.assertEquals;

public class AuthorsPageTest extends BaseTest {

    @Test(description = "Verify authors page components.")
    public void testAuthorsPageTitle() {
        NavBarHeaderPage navBarHeaderPage = new NavBarHeaderPage(driver);
        navBarHeaderPage.clickOnAuthorsLink();

        AuthorsPage authorsPage = new AuthorsPage(driver);
        authorsPage.verifyCurrentPage();
    }
}
