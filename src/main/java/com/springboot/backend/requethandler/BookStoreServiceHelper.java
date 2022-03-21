package com.springboot.backend.requethandler;

import com.springboot.backend.enums.ApiPath;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.Map;

import static com.springboot.utils.PropertiesReader.ReadData;
import static io.restassured.config.EncoderConfig.encoderConfig;

/**
 * BookStoreServiceHelper class will include all book store project APIS.
 * */
public class BookStoreServiceHelper {

    static {
        try {
            RestAssured.baseURI = ReadData("BASE_URL", "properties/config.properties");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This method will get a page.
     *
     * @param path is a ApiPath enum to select the page user need to get.
     *
     * @return getPage Api response.
     * */
    public static Response getPage(ApiPath path)
    {
        Response response = RestAssured.given().contentType(ContentType.HTML).when().get(path.getValue());
        return response;
    }

    /** This method is used to create or edit a book.
     *
     * @param params - should contain "title" and "year" for create book API.
     *
     * @param params - should contain "title", "year" and "id" for edit book API.
     *
     * @return create/edit Api response.
    * */
    public static Response bookAction(Map params){
        Response response = RestAssured.
        given().config(RestAssured.config().encoderConfig(encoderConfig().
                encodeContentTypeAs("*/*", ContentType.TEXT))).when().
                params(params).
                post(ApiPath.CREATE_BOOK.getValue());
        return response;
    }

    /**
     * This method will search for a book.
     *
     * @param params is a map that should contain searchId param.
     *
     * @return search Api response.
     * */
    public static Response searchForBook(Map params){
        Response response = RestAssured.
                given().config(RestAssured.config().encoderConfig(encoderConfig().
                encodeContentTypeAs("*/*", ContentType.TEXT))).
                when().params(params).get(ApiPath.SEARCH.getValue());
        return response;
    }

    /**
     * Method will delete a book.
     *
     * @param bookId is the book to be deleted.
     *
     * @return delete Api response.
     * */
    public static Response deleteBook(int bookId){
        String deleteLink = ApiPath.BOOKS.getValue() + "/" + String.valueOf(bookId) + ApiPath.DELETE.getValue();
        Response response = RestAssured.given().contentType(ContentType.HTML).when().get(deleteLink);
        return response;
    }
}
