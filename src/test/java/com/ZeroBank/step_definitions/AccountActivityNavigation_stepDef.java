package com.ZeroBank.step_definitions;

import com.ZeroBank.pages.accountActivityNav_pages;
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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class AccountActivityNavigation_stepDef extends dynamicMethods {

    WebDriver driver = Driver.getDriver();
    login_pages login_pages = new login_pages();
    accountActivityNav_pages accountActivityNav_pages = new accountActivityNav_pages();

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
        clickTabs(accountName);
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



/**
 Feature: Find Transactions in Account Activity
 */

    @When("the user enters description {string}")
    public void the_user_enters_description(String text) {
        accountActivityNav_pages.description.sendKeys(text);
    }

    @When("clicks find button")
    public void clicks_find_button() {
        accountActivityNav_pages.findButton.click();
    }

    @Then("results table should only show descriptions containing {string}")
    public void results_table_should_only_show_descriptions_containing(String text) {
        List<WebElement> descriptionList = driver.findElements(By.xpath("//*[@id='filtered_transactions_for_account']/table/tbody/tr/td[2]"));
        List<String> actualList = new ArrayList<>();
        for(WebElement each : descriptionList){
            System.out.println("each = " + each.getText());
            actualList.add(each.getText());
        }
        Assert.assertTrue(actualList.toString().contains(text));
        accountActivityNav_pages.description.clear();
    }

    @Then("results table should only show No result.")
    public void results_table_should_only_show_no_result() {
        String actualText = accountActivityNav_pages.noResultText.getText();
        String expectedText = "No results.";
        Assert.assertTrue(actualText.contains(expectedText));
        accountActivityNav_pages.description.clear();
    }


    // Scenario: Search date range

    @When("the user enters date range from {string} to {string}")
    public void the_user_enters_date_range_from_to(String from, String to) {
        accountActivityNav_pages.dates_from.sendKeys(from);
        accountActivityNav_pages.dates_to.sendKeys(to);
    }


    @Then("results table should only show transactions dates between {string} to {string} and the results should be sorted by most recent date")
    public void resultsTableShouldOnlyShowTransactionsDatesBetweenToAndTheResultsShouldBeSortedByMostRecentDate(String from, String to) {
        List<WebElement> descriptionList = driver.findElements(By.xpath("//*[@id='filtered_transactions_for_account']/table/tbody/tr/td[1]"));
        List<String> actualList = new ArrayList<>();
        for(WebElement each : descriptionList){
            System.out.println("each = " + each.getText());
            actualList.add(each.getText());
        }

        Assert.assertTrue(actualList.contains(from) && actualList.contains(to));
        Assert.assertEquals(actualList.get(0), to);
    }


    // Scenario: Search amounts range

    @When("the user enters amounts range from {string} to {string}")
    public void theUserEntersAmountsRangeFromTo(String from, String to) {
        accountActivityNav_pages.amounts_from.sendKeys(from);
        accountActivityNav_pages.amounts_to.sendKeys(to);
    }

    @Then("results table should only show transactions amounts between {int} to {int} and the results table should be sorted by deposit amount")
    public void resultsTableShouldOnlyShowTransactionsAmountsBetweenToAndTheResultsTableShouldBeSortedByDepositAmount(double from, double to) {
        List<WebElement> descriptionList = driver.findElements(By.xpath("//*[@id='filtered_transactions_for_account']/table/tbody/tr/td[3]"));
        List<Double> actualList = new ArrayList<>();
        for(WebElement each : descriptionList){
            System.out.println("each = " + each.getText());
            actualList.add(Double.parseDouble(each.getText()));
        }

        for (Double aDouble : actualList) {
            if (aDouble <= to && aDouble >= from) {
                Assert.assertTrue(true);
            } else {
                Assert.fail();
            }
        }
    }

    //   Scenario: Type

    @When("user selects dropdown Type {string}")
    public void user_selects_dropdown_type(String type) {
        Select select = new Select(accountActivityNav_pages.typeDropdown);
        select.selectByVisibleText(type);
        BrowserUtils.sleep(1);
    }

    @Then("results table should show at least one result under {string}")
    public void results_table_should_show_at_least_one_result_under(String deposit) {
        List<WebElement> depositResults = driver.findElements(By.xpath("//*[@id='filtered_transactions_for_account']/table/tbody/tr['+i+']/td[3]"));
        List<String> actualList = new ArrayList<>();
        for(WebElement each : depositResults){
            System.out.println("each.getText() = " + each.getText());
            actualList.add(each.getText());
        }
        BrowserUtils.sleep(1);
        Assert.assertFalse(actualList.isEmpty());
    }

    @Then("results table should show no result under {string}")
    public void results_table_should_show_no_result_under(String withdrawal) {
        List<WebElement> depositResults = driver.findElements(By.xpath("//*[@id='filtered_transactions_for_account']/table/tbody/tr['+i+']/td[4]"));
        List<String> actualList = new ArrayList<>();
        for(WebElement each : depositResults){
            System.out.println("each.getText() = " + each.getText());
            actualList.add(each.getText());
        }
        BrowserUtils.sleep(1);
        Assert.assertFalse(actualList.isEmpty());
    }




}
