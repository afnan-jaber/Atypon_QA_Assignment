package com.springboot.tests.backend;

import com.springboot.backend.helpers.BookStoreServiceHelper;
import com.springboot.backend.responsehandler.ResponseAssertions;
import com.springboot.backend.responsehandler.ResponseHandlerHelper;
import com.springboot.common.BaseBackendTest;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class DeleteBookBackendTest extends BaseBackendTest {

    @Test(description = "Verify delete an existing book.")
    public void deleteBookTest(){
        Response response = BookStoreServiceHelper.deleteBook(ResponseHandlerHelper.getBookId());

        ResponseAssertions.checkContentType(response,"text/html;charset=UTF-8");
        ResponseAssertions.checkStatusCode(response,200);

    }

    @Test(description = "Verify delete a not existing book.")
    public void deleteNotExistingBookBookTest(){
        Response response = BookStoreServiceHelper.deleteBook(-1);

        ResponseAssertions.checkStatusCode(response,500);
    }
}
