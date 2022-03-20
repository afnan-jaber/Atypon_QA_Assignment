package com.springboot.backend.responsehandler;

import com.springboot.backend.enums.ApiPath;
import com.springboot.backend.helpers.BookStoreServiceHelper;
import com.springboot.utils.Log;
import io.restassured.response.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * ResponseHandlerHelper class to include helper response handler methods.
 * */
public class ResponseHandlerHelper {

    /**
     * Get fist book id.
     * */
    public static int getBookId() {
        Response response = BookStoreServiceHelper.getPage(ApiPath.BOOKS);
        String bookEditElement = null;
        String html = response.getBody().asPrettyString();
        Document document = Jsoup.parse(html);
        try {
            bookEditElement = document.select("tbody a[href$='edit']").get(0).attr("href");
        } catch (Exception e){
            Log.info("Books page is empty !!");
        }
        return Integer.parseInt( bookEditElement.replaceAll("[^\\d.]",""));
    }

    /**
     * Method to check if book title exist.
     * */
    public static boolean isBookTitleExist(String bookTitle){

        Response response = BookStoreServiceHelper.getPage(ApiPath.BOOKS);
        String html = response.getBody().asPrettyString();
        Elements book = null;
        Document document = Jsoup.parse(html);

        try {
            book = document.select("tr td:first-child");
        } catch (Exception e){
            Log.info("Books page is empty !!");
        }
          for (Element bookItem : book) {
              if (bookItem.text().equalsIgnoreCase(bookTitle))
              {return true;}
          }
          return false;
    }
}
