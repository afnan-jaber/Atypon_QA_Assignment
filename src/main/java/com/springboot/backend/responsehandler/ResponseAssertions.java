package com.springboot.backend.responsehandler;

import io.restassured.response.Response;
import org.testng.Assert;

/**
 * ResponseAssertions class include methods to Assert API response.
 * */
public class ResponseAssertions {

    /**
     * Method to assert the status code value.
     * @param response Api response.
     * @param statusCode Expected status code.
     * */
    public static void checkStatusCode(Response response , int statusCode) {
        Assert.assertEquals(response.getStatusCode(), statusCode, "Status Check Failed!");
    }

    /**
     * Method to assert the content type value.
     * @param response Api response.
     * @param contentType Expected content type.
     * */
    public static void checkContentType(Response response, String contentType){
        Assert.assertEquals(response.getContentType() , contentType);
    }
}
