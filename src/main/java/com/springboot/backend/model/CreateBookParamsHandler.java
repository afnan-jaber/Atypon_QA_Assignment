package com.springboot.backend.model;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * CreateBookParamsHandler class handel create API related params.
 * */
public class CreateBookParamsHandler {

    private String title;
    private String year;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public String getYear() {
        return year;
    }

    /**
     * Method to get create API parameters as a map.
     *
     * @return Create API parameters.
     * */
    public Map<String,String> getParams() {
        Map <String,String> params = new HashMap<String, String>();
        params.put("title",getTitle());
        params.put("year",getYear());
        return params;
    }
}
