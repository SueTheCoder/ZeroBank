package com.ZeroBank.step_definitions;

import com.ZeroBank.pages.accountActivityNav_pages;
import com.ZeroBank.pages.login_pages;
import com.ZeroBank.pages.payBill_pages;
import com.ZeroBank.utilities.BrowserUtils;
import com.ZeroBank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class PurchaseForeignCurrency_stepDef extends dynamicMethods{

    WebDriver driver = Driver.getDriver();
    login_pages login_pages = new login_pages();
    payBill_pages payBill_pages = new payBill_pages();


    @Then("following currencies should be available")
    public void following_currencies_should_be_available(List<String> expectedList) {
        Select select = new Select(payBill_pages.currency_dropdown);
        List<WebElement> options = select.getOptions();
        Assert.assertEquals(expectedList, BrowserUtils.getElementsText(options));
    }

    @When("user tries to calculate cost without selecting a currency")
    public void user_tries_to_calculate_cost_without_selecting_a_currency() {
        payBill_pages.calculate_costs_button.click();
    }


    @Then("error alert should be displayed")
    public void errorAlertShouldBeDisplayed() {
        Alert alert = driver.switchTo().alert();
        Assert.assertTrue(alert.getText().contains("Please, ensure that you have filled all the required fields with valid values."));
    }

    @When("user tries to calculate cost without entering a value")
    public void userTriesToCalculateCostWithoutEnteringAValue() {
        Select select = new Select(payBill_pages.currency_dropdown);
        select.selectByVisibleText("Eurozone (euro)");
        payBill_pages.dollars_radio.click();
        payBill_pages.calculate_costs_button.click();
        BrowserUtils.sleep(1);
        Alert alert = driver.switchTo().alert();
        Assert.assertTrue(alert.getText().contains("Please, ensure that you have filled all the required fields with valid values."));
    }
}
