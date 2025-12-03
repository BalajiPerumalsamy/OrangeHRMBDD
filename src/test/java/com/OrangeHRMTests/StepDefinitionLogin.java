package com.OrangeHRMTests;

import com.OrangeHRMPages.Base_Page;
import com.OrangeHRMPages.Login_Page;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.testng.Assert.*;

public class StepDefinitionLogin
{
    Base_Page basePage=new Base_Page();
    Login_Page loginPage;
    @Given("User is on login page")
    public void user_is_login_page()
    {
        basePage.navigateTOApplication();
    }
    @When("User enters valid credentials")
    public void enter_valid_credentials()
    {
        loginPage=new Login_Page();
        loginPage.enterUserInput();
    }
    @And("Clicks the login button")
    public void click_the_login_button()
    {
        loginPage.login();
    }
    @Then("User should be redirected to home page")
    public void redirected_to_home_page()
    {
        boolean actual= loginPage.verifyLogin();
        assertTrue(actual,"The logo is Not visible");
        basePage.quitToApplications();
    }
}