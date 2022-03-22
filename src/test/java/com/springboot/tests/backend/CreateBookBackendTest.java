package com.springboot.tests.backend;

import com.springboot.backend.requethandler.BookStoreServiceHelper;
import com.springboot.backend.model.CreateBookParamsHandler;
import com.springboot.backend.responsehandler.ResponseAssertions;
import com.springboot.backend.responsehandler.ResponseHandlerHelper;
import com.springboot.common.BaseBackendTest;
import com.springboot.common.TestHelper;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static com.springboot.utils.PropertiesReader.ReadData;
import static org.testng.Assert.assertTrue;


public class CreateBookBackendTest extends BaseBackendTest {

    @Test(description = "Verify create book API.")
    public void createBookTest() throws Exception {
        CreateBookParamsHandler createBookParamsHandler = new CreateBookParamsHandler();
        createBookParamsHandler.setTitle(ReadData("BOOK_TITLE", testDataPath)
                + TestHelper.getRandomNumberInRange(1,1000));
        createBookParamsHandler.setYear(ReadData("BOOK_YEAR", testDataPath));

        Response response = BookStoreServiceHelper.bookAction(createBookParamsHandler.getParams());

        assertTrue(ResponseHandlerHelper.isBookTitleExist(createBookParamsHandler.getTitle()), "Book title was not edited !");
        ResponseAssertions.checkStatusCode(response,302);
    }
}
