package com.example.steps;

import com.example.SetupAndTearDown;
import com.example.pages.VisitorHomePage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;

public class HomeSteps {
    private VisitorHomePage visitorHomePage;

    public HomeSteps() {
        visitorHomePage = PageFactory.initElements(SetupAndTearDown.driver, VisitorHomePage.class);
    }

    @Given("^I am a visitor user$")
    public void iAmAVisitorUser() {
        //Nothing to do here
    }

    @When("^I navigate to visitor home page$")
    public void iNavigateToVisitorHomePage() {
        visitorHomePage.goToPage();
    }

    @Then("^I should see sign in link on the top of the page$")
    public void iShouldSeeSignInLinkOnTheTopOfThePage() {
        Assert.assertTrue("Sign In link not present", visitorHomePage.header.isSignInLinkPresent());
    }

    @And("^Sign in link should be clickable$")
    public void signInLinkShouldBeClickable() {
        Assert.assertTrue("Sign In link is not clickable", visitorHomePage.header.isSignInLinkClickable());
    }
}
