package com.springboot.backend.enums;

public enum Params {
    TITLE("title"),
    YEAR("year"),
    ID("id"),
    SEARCH_ID("searchID");

    /*value*/
    private final String value;

    /**
     * Instantiates a new {@link Params}.
     *
     * @param value - the value of the param.
     */
    Params(final String value) {
        this.value = value;
    }

    /**
     * Returns the Params Result value.
     *
     * @return the value.
     */
    public String getValue() {
        return value;
    }
}
