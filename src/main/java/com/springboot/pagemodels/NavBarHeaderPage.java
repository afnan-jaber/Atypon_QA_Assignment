package com.springboot.pagemodels;

import com.springboot.common.BasePageModel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NavBarHeaderPage extends BasePageModel {

    @FindBy(css = ".navbar-brand")
    private WebElement navBarHeader;

    @FindBy(id = "searchID")
    private WebElement searchTextField;

    @FindBy(css ="#searchForm button")
    private WebElement searchButton;

    @FindBy(xpath = "//div[@id='navbar'] //a[contains(.,'Home')]")
    private WebElement homeLink;

    @FindBy(xpath = "//div[@id='navbar'] //a[contains(@href,'books')]")
    private WebElement booksLink;

    @FindBy(xpath = "//div[@id='navbar'] //a[contains(@href,'authors')]")
    private WebElement authorsLink;

    public NavBarHeaderPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getNavBarHeaderText(){
        return navBarHeader.getText();
    }

    public void typeInSearchTextField(String searchValue) {
        searchTextField.sendKeys(searchValue);
    }

    public void clickOnSearchButton(){
        searchButton.click();
    }

    public void searchForText(String searchValue) {
        typeInSearchTextField(searchValue);
        clickOnSearchButton();
    }
}
