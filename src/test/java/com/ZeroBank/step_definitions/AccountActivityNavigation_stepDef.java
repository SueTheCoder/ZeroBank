package com.ZeroBank.step_definitions;

import com.ZeroBank.pages.login_pages;
import com.ZeroBank.utilities.BrowserUtils;
import com.ZeroBank.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class AccountActivityNavigation_stepDef extends dynamicMethods {

    WebDriver driver = Driver.getDriver();
    login_pages login_pages = new login_pages();

    @Given("Account Summary page should have the title {string}")
    public void accountSummaryPageShouldHaveTheTitle(String expectedTitle) {
        assertTitle(expectedTitle);
    }


    @And("Account Summary page should have to following account types:")
    public void accountSummaryPageShouldHaveToFollowingAccountTypes(List<String> tableElements) {
        List<WebElement> tableHeads = driver.findElements(By.xpath("//h2"));
        BrowserUtils.getElementsText(tableHeads);
    }

    @And("Credit Accounts table must have columns:")
    public void creditAccountsTableMustHaveColumns(List<String> expectedTableElements) {
        List<WebElement> tableHeads = driver.findElements(By.xpath("(//table[@class='table'])[3]/thead/tr/th"));
        BrowserUtils.getElementsText(tableHeads);
    }


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
