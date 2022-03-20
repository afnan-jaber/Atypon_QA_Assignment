package com.springboot.tests.backend;

import com.springboot.backend.helpers.BookStoreServiceHelper;
import com.springboot.backend.model.EditBookParamsHandler;
import com.springboot.backend.responsehandler.ResponseAssertions;
import com.springboot.backend.responsehandler.ResponseHandlerHelper;
import com.springboot.common.BaseBackendTest;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class EditBookBackendTest extends BaseBackendTest {

    @Test(description = "Verify edit an existing book.")
    public void editBookTest(){
        EditBookParamsHandler editBookParams = new EditBookParamsHandler();
        editBookParams.setTitle("Edit Book from automation FW test");
        editBookParams.setYear("2005");
        editBookParams.setId(ResponseHandlerHelper.getBookId());

        Response response = BookStoreServiceHelper.bookAction(editBookParams.getParams());

        assertTrue(ResponseHandlerHelper.isBookTitleExist(editBookParams.getTitle()), "Book title was not edited !");

        ResponseAssertions.checkStatusCode(response,302);
    }

    @Test(description = "Verify edit a not existing book.")
    public void editNotExistingBookTest(){
        EditBookParamsHandler editBookParams = new EditBookParamsHandler();
        editBookParams.setTitle("Edit Book from automation FW test");
        editBookParams.setYear("2005");
        editBookParams.setId(-1);

        Response response = BookStoreServiceHelper.bookAction(editBookParams.getParams());

        ResponseAssertions.checkStatusCode(response,500);
    }
}
