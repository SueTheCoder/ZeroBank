package com.ZeroBank.step_definitions;

import com.ZeroBank.pages.login_pages;
import com.ZeroBank.pages.payBill_pages;
import com.ZeroBank.utilities.BrowserUtils;
import com.ZeroBank.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Map;

public class PayBills_stepDef extends dynamicMethods {

    WebDriver driver = Driver.getDriver();
    login_pages login_pages = new login_pages();
    payBill_pages payBill_pages = new payBill_pages();


    @Given("Pay Bills page should have the title {string}")
    public void payBillsPageShouldHaveTheTitle(String title) {
        clickTabs("Pay Bills");
        assertTitle(title);
    }


    @When("user selects {string} under the Make payments feature")
    public void user_selects_under_the_make_payments_feature(String value) {
        Select select = new Select(payBill_pages.payee_dropdown);
        select.selectByVisibleText(value);
    }


    @And("user types {string} of {string} under the Make payments feature")
    public void userTypesOfUnderTheMakePaymentsFeature(String makePaymentList, String value) {
        WebElement makePaymentOptions = driver.findElement(By.xpath("//select[@id='sp_" + makePaymentList + "']"));
        makePaymentOptions.sendKeys(value);
    }

    @When("user selects {string} under the Make payments feature for {string}")
    public void userSelectsUnderTheMakePaymentsFeatureFor(String value, String menu) {
        WebElement dropdownMenu = driver.findElement(By.xpath("//select[@id='sp_" + menu + "']"));
        Select select = new Select(dropdownMenu);
        select.selectByVisibleText(value);
        BrowserUtils.sleep(1);
    }

    @And("user types {string} under the Make payments feature for {string}")
    public void userTypesUnderTheMakePaymentsFeatureFor(String value, String menu) {
        WebElement makePaymentOptions = driver.findElement(By.xpath("//input[@id='sp_" + menu + "']"));
        makePaymentOptions.sendKeys(value, Keys.TAB);
        BrowserUtils.sleep(2);
    }

    @And("user clicks to pay button")
    public void userClicksToPayButton() {
        payBill_pages.pay_button.click();
    }

    @When("user completes a successful Pay operation, {string} should be displayed")
    public void userCompletesASuccessfulPayOperationShouldBeDisplayed(String expectedText) {
        Assert.assertEquals(expectedText, payBill_pages.alert_success.getText());
    }


    @Given("Add New Payee tab")
    public void addNewPayeeTab() {
        clickTabs("Pay Bills");
        clickTabs("Add New Payee");
    }


    @Given("user enters {string} in Payee Name text box")
    public void user_enters_in_payee_name_text_box(String text) {
        addNewPayee("name", text);
    }

    @Given("user enters {string} in Payee Address text box")
    public void user_enters_in_payee_address_text_box(String text) {
        driver.findElement(By.xpath("//textarea[@name='address']")).sendKeys(text, Keys.TAB);
    }

    @Given("user enters {string} in Account text box")
    public void user_enters_in_account_text_box(String text) {
        addNewPayee("account", text);
    }

    @Given("user enters {string} in Payee details text box")
    public void user_enters_in_payee_details_text_box(String text) {
        addNewPayee("details", text);
    }

    @And("user clicks to add button")
    public void userClicksToAddButton() {
        payBill_pages.addNewPayee_button.click();BrowserUtils.sleep(1);
    }

    @Then("message {string} should be displayed")
    public void message_should_be_displayed(String expectedText) {
        Assert.assertTrue(payBill_pages.alert_success.getText().contains(expectedText));

    }

}