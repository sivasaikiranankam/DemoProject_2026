package com.example.steps;

import com.example.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class LoginSteps {
    private LoginPage loginPage;

    @Given("I open the SauceDemo login page")
    public void openLoginPage() {
        // The @Before hook has started WebDriver before the first step runs.
        loginPage = new LoginPage();
        loginPage.open();
    }

    @When("I log in with username {string} and password {string}")
    public void loginWithCredentials(String username, String password) {
        loginPage.login(username, password);
    }

    @Then("I should see the products page")
    public void verifyProductsPage() {
        Assert.assertTrue(loginPage.isProductsPageDisplayed(),
                "Expected the Products page to be displayed after a valid login.");
    }

    @Then("I should see a login error message")
    public void verifyLoginError() {
        String message = loginPage.getErrorMessage();
        Assert.assertTrue(message.toLowerCase().contains("do not match"),
                "Expected an invalid-credentials error, but got: " + message);
    }
}
