package com.ZeroBank.pages;

import com.ZeroBank.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class payBill_pages {

    WebDriver driver = Driver.getDriver();

    public payBill_pages() {
        PageFactory.initElements(driver, this);
    }


    @FindBy(id = "sp_payee")
    public WebElement payee_dropdown;

    @FindBy(id = "sp_account")
    public WebElement account_dropdown;

    @FindBy(id = "alert_content")
    public WebElement alert_success;

    @FindBy(id = "pay_saved_payees")
    public WebElement pay_button;

    @FindBy(xpath = "//a[.='Add New Payee']")
    public WebElement addNewPayee;

    @FindBy(id = "add_new_payee")
    public WebElement addNewPayee_button;

    @FindBy(xpath = "//select[@id='pc_currency']")
    public WebElement currency_dropdown;

    @FindBy(id = "pc_calculate_costs")
    public WebElement calculate_costs_button;


    @FindBy(id = "pc_inDollars_true")
    public WebElement dollars_radio;
}
