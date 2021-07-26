package com.ZeroBank.pages;

import com.ZeroBank.utilities.BrowserUtils;
import com.ZeroBank.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class login_pages {

    WebDriver driver = Driver.getDriver();

    public login_pages() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "user_login")
    public WebElement login_textBox;

    @FindBy(id = "user_password")
    public WebElement password_textBox;

    @FindBy(xpath = "//input[@type='submit']")
    public WebElement signIn_button;

    @FindBy(id = "user_remember_me")
    public WebElement keepMeSignInChecked;

    @FindBy(id = "details-button")
    public WebElement advanced_button;

    @FindBy(id = "proceed-link")
    public WebElement proceedLink_button;

    @FindBy(xpath = "//div[@class='alert alert-error']")
    public WebElement errorMsg;

    @FindBy(xpath = "//a[.='Forgot your password ?']")
    public WebElement forgotPasswordLink;

    @FindBy(id = "user_email")
    public WebElement forgot_EmailTextBox;


    @FindBy(xpath = "//div[1]/div[2]/div/div/div")
    public WebElement forgot_approved;

    public void login_method(String username, String password, boolean isKeepMeSignInChecked){
        login_textBox.sendKeys(username);
        password_textBox.sendKeys(password);
        BrowserUtils.sleep(1);
        if(isKeepMeSignInChecked)
            keepMeSignInChecked.click();
        BrowserUtils.sleep(1);
        signIn_button.click();

        advanced_button.click();
        BrowserUtils.sleep(1);
        proceedLink_button.click();
    }


}
