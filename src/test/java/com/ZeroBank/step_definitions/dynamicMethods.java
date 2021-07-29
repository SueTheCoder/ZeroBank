package com.ZeroBank.step_definitions;

import com.ZeroBank.pages.login_pages;
import com.ZeroBank.utilities.BrowserUtils;
import com.ZeroBank.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;


public class dynamicMethods extends login_pages{

    WebDriver driver = Driver.getDriver();
    login_pages login_pages = new login_pages();


    public void login_method(String username, String password, boolean isKeepMeSignInChecked){
        login_textBox.sendKeys(username);
        password_textBox.sendKeys(password);
        if(isKeepMeSignInChecked)
            keepMeSignInChecked.click();
        signIn_button.click();
        BrowserUtils.sleep(1);
        advanced_button.click();
        BrowserUtils.sleep(1);
        proceedLink_button.click();
    }


    public void assertTitle(String expectedTitle){
        String actualTitle = driver.getTitle();
        Assert.assertTrue("Title is not correct", actualTitle.contains(expectedTitle));
    }


    public void clickTabs(String tabName){
        WebElement tabs = driver.findElement(By.xpath("//a[.='" + tabName + "']"));
        tabs.click();
    }

    public void assertText(String expectedText, String actualText){
        Assert.assertTrue("Text is not correct", actualText.contains(expectedText));
    }

    public void addNewPayee(String textBoxName, String value){
        WebElement textBox = driver.findElement(By.xpath("//input[@name='" + textBoxName + "']"));
        textBox.sendKeys(value);
    }


}
