package com.springboot.backend.enums;

public enum ApiPath {
    HOME("/") ,
    BOOKS("/books"),
    AUTHORS ("/authors"),
    SEARCH ("/search"),
    CREATE_BOOK ("books"),
    CREATE_BOOK_LINK ("/create"),
    EDIT_BOOK_LINK ("/edit"),
    DELETE("/delete"),
    BASE_URL("http://localhost:8080/");

    /*value*/
    private final String value;

    /**
     * Instantiates a new {@link ApiPath}.
     *
     * @param value - the value of the Type.
     */
    ApiPath(final String value) {
        this.value = value;
    }

    /**
     * Returns the ApiPath Result value.
     *
     * @return the value.
     */
    public String getValue() {
        return value;
    }
}
