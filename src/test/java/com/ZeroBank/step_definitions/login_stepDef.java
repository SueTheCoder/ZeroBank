package com.ZeroBank.step_definitions;

import com.ZeroBank.pages.login_pages;
import com.ZeroBank.utilities.ConfigurationReader;
import com.ZeroBank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;

public class login_stepDef extends dynamicMethods{

    WebDriver driver = Driver.getDriver();
    login_pages login_pages = new login_pages();
    //dynamicMethods dynamicMethods = new dynamicMethods();

    @Given("the user fills {string} and {string} text boxes and clicks to Keep me signed in checkbox")
    public void theUserFillsAndTextBoxesAndClicksToKeepMeSignedInCheckbox(String username, String password) {
        driver.get(ConfigurationReader.getProperty("URL"));
        login_pages.login_textBox.sendKeys(username);
        login_pages.password_textBox.sendKeys(password);
        login_pages.keepMeSignInChecked.click();
    }

    @Given("the user clicks to sign in button")
    public void the_user_clicks_to_sign_in_button() {
        login_pages.signIn_button.click();
        login_pages.advanced_button.click();
        login_pages.proceedLink_button.click();
    }

    @Then("Account summary page should be	displayed")
    public void account_summary_page_should_be_displayed() {
        assertTitle("Zero - Account Summary");
    }



}
