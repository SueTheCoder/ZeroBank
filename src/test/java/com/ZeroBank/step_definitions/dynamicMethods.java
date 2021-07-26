package com.ZeroBank.step_definitions;

import com.ZeroBank.pages.login_pages;
import com.ZeroBank.utilities.BrowserUtils;
import com.ZeroBank.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;


public class dynamicMethods {

    WebDriver driver = Driver.getDriver();
    login_pages login_pages = new login_pages();

    public void assertTitle(String expectedTitle){
        String actualTitle = driver.getTitle();
        Assert.assertTrue("Title is not correct", actualTitle.contains(expectedTitle));
    }


    public void clickTabs(String tabName){
        WebElement tabs = driver.findElement(By.xpath("//a[.='" + tabName + "']"));
        tabs.click();
    }

    public void accountSummaryLinks_click(String accountName){
        WebElement accounts = driver.findElement(By.xpath("//a[.='" + accountName + "']"));
        accounts.click();
    }

    public void assertText(String expectedText, String actualText){
        Assert.assertTrue("Text is not correct", actualText.contains(expectedText));
    }


}
