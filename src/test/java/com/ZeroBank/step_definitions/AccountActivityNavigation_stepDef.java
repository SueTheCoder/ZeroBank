package com.ZeroBank.step_definitions;

import com.ZeroBank.pages.login_pages;
import com.ZeroBank.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountActivityNavigation_stepDef extends dynamicMethods {

    WebDriver driver = Driver.getDriver();
    login_pages login_pages = new login_pages();


    @When("the user clicks on {string} link on the {string} page")
    public void the_user_clicks_on_link_on_the_page(String accountName, String tabName) {
        clickTabs(tabName);
        accountSummaryLinks_click(accountName);
    }

    @Then("the {string} page should be displayed")
    public void thePageShouldBeDisplayed(String tabName) {
        assertTitle(tabName);
    }

    @Then("Account drop down should have {string} selected")
    public void account_drop_down_should_have_selected(String accountName) {
        WebElement accounts = driver.findElement(By.xpath("//select[@id='aa_accountId']/option[.='" + accountName + "']"));
        Assert.assertTrue(accounts.isDisplayed());
    }



}
