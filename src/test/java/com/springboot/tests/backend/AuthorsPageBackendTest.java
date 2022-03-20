package com.springboot.tests.backend;

import com.springboot.backend.enums.ApiPath;
import com.springboot.backend.helpers.BookStoreServiceHelper;
import com.springboot.backend.responsehandler.ResponseAssertions;
import com.springboot.common.BaseBackendTest;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class AuthorsPageBackendTest extends BaseBackendTest {

    @Test(description = "Verify the get authors API.")
    public void getAuthorsPageTest(){
        Response response = BookStoreServiceHelper.getPage(ApiPath.AUTHORS);

        ResponseAssertions.checkStatusCode(response,200);
        ResponseAssertions.checkContentType(response,"text/html;charset=UTF-8");
    }
}
