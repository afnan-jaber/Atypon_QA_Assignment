package com.springboot.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class BasePageModel {

    protected WebDriver driver ;

    public BasePageModel(WebDriver driver) {
        this.driver =driver;
    }
}
