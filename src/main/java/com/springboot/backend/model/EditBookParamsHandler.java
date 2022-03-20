package com.springboot.backend.model;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * EditBookParamsHandler class handel edit book API related params.
 * */
public class EditBookParamsHandler extends CreateBookParamsHandler {
    private int id;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    /**
     * Method to get edit API parameters as a map.
     *
     * @return edit API parameters.
     * */
    @Override
    public Map<String,String> getParams() {
        Map <String,String> params = new HashMap<>();
        params.put("id", String.valueOf(getId()));
        params.put("title",getTitle());
        params.put("year",getYear());
        return params;
    }
}
