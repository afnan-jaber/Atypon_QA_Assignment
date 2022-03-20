package com.springboot.tests.backend;

import com.springboot.backend.helpers.BookStoreServiceHelper;
import com.springboot.backend.model.CreateBookParamsHandler;
import com.springboot.backend.responsehandler.ResponseAssertions;
import com.springboot.backend.responsehandler.ResponseHandlerHelper;
import com.springboot.common.BaseBackendTest;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;


public class CreateBookBackendTest extends BaseBackendTest {

    @Test(description = "Verify create book API.")
    public void createBookTest(){
        CreateBookParamsHandler createBookParamsHandler = new CreateBookParamsHandler();
        createBookParamsHandler.setTitle("Create Book from automation FW");
        createBookParamsHandler.setYear("2005");

        Response response = BookStoreServiceHelper.bookAction(createBookParamsHandler.getParams());

        assertTrue(ResponseHandlerHelper.isBookTitleExist(createBookParamsHandler.getTitle()), "Book title was not edited !");
        ResponseAssertions.checkStatusCode(response,302);
    }
}
