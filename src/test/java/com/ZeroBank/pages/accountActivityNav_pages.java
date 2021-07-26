package com.ZeroBank.pages;

import com.ZeroBank.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class accountActivityNav_pages {

    WebDriver driver = Driver.getDriver();

    public accountActivityNav_pages() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "aa_description")
    public WebElement description;

    @FindBy(id = "aa_fromDate")
    public WebElement dates_from;

    @FindBy(id = "aa_toDate")
    public WebElement dates_to;

    @FindBy(id = "aa_fromAmount")
    public WebElement amounts_from;

    @FindBy(id = "aa_toAmount")
    public WebElement amounts_to;

    @FindBy(id = "aa_type")
    public WebElement typeDropdown;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement findButton;

    @FindBy(xpath = "//div[@class='well']")
    public WebElement noResultText;

}
