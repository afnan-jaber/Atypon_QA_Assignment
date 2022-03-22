package com.springboot.tests.backend;

import com.springboot.backend.requethandler.BookStoreServiceHelper;
import com.springboot.backend.model.EditBookParamsHandler;
import com.springboot.backend.responsehandler.ResponseAssertions;
import com.springboot.backend.responsehandler.ResponseHandlerHelper;
import com.springboot.common.BaseBackendTest;
import com.springboot.common.TestHelper;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static com.springboot.utils.PropertiesReader.ReadData;
import static org.testng.Assert.assertTrue;

public class EditBookBackendTest extends BaseBackendTest {

    @Test(description = "Verify edit an existing book.")
    public void editBookTest() throws Exception {
        EditBookParamsHandler editBookParams = new EditBookParamsHandler();
        editBookParams.setTitle(ReadData("BOOK_TITLE", testDataPath)
                + TestHelper.getRandomNumberInRange(1,1000));
        editBookParams.setYear(ReadData("BOOK_YEAR", testDataPath));
        editBookParams.setId(ResponseHandlerHelper.getBookId());

        Response response = BookStoreServiceHelper.bookAction(editBookParams.getParams());

        assertTrue(ResponseHandlerHelper.isBookTitleExist(editBookParams.getTitle()), "Book title was not edited !");

        ResponseAssertions.checkStatusCode(response,302);
    }

    @Test(description = "Verify that edit Api will return 500 upon editing a not existing book.")
    public void editNotExistingBookTest() throws Exception {
        EditBookParamsHandler editBookParams = new EditBookParamsHandler();
        editBookParams.setTitle(ReadData("BOOK_TITLE", testDataPath)
                + TestHelper.getRandomNumberInRange(1,1000));
        editBookParams.setYear(ReadData("BOOK_YEAR", testDataPath));
        editBookParams.setId(-1);

        Response response = BookStoreServiceHelper.bookAction(editBookParams.getParams());

        ResponseAssertions.checkStatusCode(response,500);
    }
}
