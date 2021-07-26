package com.ZeroBank.step_definitions;

import com.ZeroBank.utilities.BrowserUtils;
import com.ZeroBank.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class dynamicMethods {

    WebDriver driver = Driver.getDriver();

    public void assertTitle(String expectedTitle){
        String actualTitle = driver.getTitle();
        Assert.assertTrue("Title is not correct", actualTitle.contains(expectedTitle));
    }

    public void clickTabs(String tabName){
        WebElement tabs = driver.findElement(By.xpath("//li[@id='" +
                tabName.toLowerCase().substring(0, tabName.indexOf(" ")) + "_" +
                tabName.toLowerCase().substring(tabName.indexOf(" ")) + "_tab" + "']"));
        tabs.click();
    }


}
