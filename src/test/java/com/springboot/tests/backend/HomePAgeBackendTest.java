package com.springboot.tests.backend;

import com.springboot.backend.enums.ApiPath;
import com.springboot.backend.requethandler.BookStoreServiceHelper;
import com.springboot.backend.responsehandler.ResponseAssertions;
import com.springboot.common.BaseBackendTest;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class HomePAgeBackendTest extends BaseBackendTest {

    @Test(description = "Verify get home API.")
    public void getHomePageTest(){
       Response response = BookStoreServiceHelper.getPage(ApiPath.HOME);

        ResponseAssertions.checkStatusCode(response,200);
        ResponseAssertions.checkContentType(response,"text/html;charset=UTF-8");
    }
}
