package com.example.steps;

import com.example.SetupAndTearDown;
import com.example.pages.SignInPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;

public class LoginSteps {

    public SignInPage signInPage;

    public LoginSteps() {
        signInPage = PageFactory.initElements(SetupAndTearDown.driver, SignInPage.class);
    }

    @When("^I am on the sign in page$")
    public void iAmOnTheSignInPage() {
        signInPage.goToPage();
    }

    @Then("^I should see username input field$")
    public void iShouldSeeUsernameInputField() {
        Assert.assertTrue("Username input is not visible", signInPage.isUsernameFieldVisible());
    }

    @And("^I should see password input field$")
    public void iShouldSeePasswordInputField() {
        Assert.assertTrue("Password input is not visible", signInPage.isPasswordFieldVisible());
    }

    @And("^I should see sign in button$")
    public void iShouldSeeSignInButton() {
        Assert.assertTrue("Sign in button is not visible", signInPage.isSignInButtonVisible());
    }
}
