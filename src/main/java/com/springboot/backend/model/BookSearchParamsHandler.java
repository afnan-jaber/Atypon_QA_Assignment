package com.springboot.backend.model;

import com.springboot.backend.enums.Params;

import java.util.HashMap;
import java.util.Map;

/**
 *
* BookSearchParamsHandler class handel search API related params.
* */
public class BookSearchParamsHandler {

    private String searchId ;


    public void setSearchId(String searchId) {
        this.searchId = searchId;
    }

    public String getSearchId() {
        return searchId;
    }

    /**
     * Method to get search API parameters as a map.
     *
     * @return search API parameters.
     * */
    public Map<String,String> getParams() {
        Map <String,String> params = new HashMap<String, String>();

        params.put(Params.SEARCH_ID.getValue(), getSearchId());
        return params;
    }
}
