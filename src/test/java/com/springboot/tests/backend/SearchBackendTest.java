package com.springboot.tests.backend;

import com.springboot.backend.requethandler.BookStoreServiceHelper;
import com.springboot.backend.model.BookSearchParamsHandler;
import com.springboot.backend.responsehandler.ResponseAssertions;
import com.springboot.common.BaseBackendTest;
import io.restassured.response.Response;
import org.testng.annotations.Test;


public class SearchBackendTest extends BaseBackendTest {

    @Test(description = "Verify search for a book API.")
    public void searchForBookTest(){
        BookSearchParamsHandler bookSearchParamsHandler = new BookSearchParamsHandler();
        bookSearchParamsHandler.setSearchId("test test");

        Response response = BookStoreServiceHelper.searchForBook(bookSearchParamsHandler.getParams());

        ResponseAssertions.checkStatusCode(response,200);
        ResponseAssertions.checkContentType(response,"text/html;charset=UTF-8");
    }
}
