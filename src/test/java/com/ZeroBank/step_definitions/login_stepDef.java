package com.ZeroBank.step_definitions;

import com.ZeroBank.pages.login_pages;
import com.ZeroBank.utilities.BrowserUtils;
import com.ZeroBank.utilities.ConfigurationReader;
import com.ZeroBank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class login_stepDef extends dynamicMethods{

    WebDriver driver = Driver.getDriver();
    login_pages login_pages = new login_pages();
    //dynamicMethods dynamicMethods = new dynamicMethods();

    @Given("user is on the login page")
    public void userIsOnTheLoginPage() {
        driver.get(ConfigurationReader.getProperty("URL"));
    }

    @Given("the user fills {string} and {string} text boxes and clicks to Keep me signed in checkbox")
    public void theUserFillsAndTextBoxesAndClicksToKeepMeSignedInCheckbox(String username, String password) {
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

    //====================== NEGATIVE TESTS CASES ============================================
    @Given("the user leave blank username and password text boxes")
    public void theUserLeaveBlankUsernameAndPasswordTextBoxes() {
        login_pages.signIn_button.click();
        BrowserUtils.sleep(1);
    }

    @Then("error message should be displayed")
    public void error_message_should_be_displayed() {
        String expectedError = "Login and/or password are wrong.";
        String actualError = login_pages.errorMsg.getText();
        Assert.assertTrue(actualError.contains(expectedError));
    }


    @Given("the user fills invalid {string} and {string} text boxes")
    public void theUserFillsInvalidAndTextBoxes(String username, String password) {
        login_pages.login_textBox.sendKeys(username);
        login_pages.password_textBox.sendKeys(password);
        login_pages.keepMeSignInChecked.click();
        login_pages.signIn_button.click();
    }

    //========================= FORGOT PASSWORD ==========================================
    @Given("the user clicks Forgot your password ? link")
    public void the_user_clicks_forgot_your_password_link() {
        login_pages.forgotPasswordLink.click();
    }

    @Given("the user fills email text box")
    public void the_user_fills_email_text_box() {
        login_pages.forgot_EmailTextBox.sendKeys("abc@gmail.com");
        login_pages.signIn_button.click();
    }

    @Then("the user should see the Your password will be sent to the following email: text")
    public void the_user_should_see_the_your_password_will_be_sent_to_the_following_email_text() {
        String actualText = login_pages.forgot_approved.getText();
        String expectedText= "Your password will be sent to the following email:";
        Assert.assertTrue(actualText.contains(expectedText));
    }


    @Given("the user is logged in")
    public void theUserIsLoggedIn() {
        userIsOnTheLoginPage();
        login_pages.login_method("username", "password", false);
    }
}
