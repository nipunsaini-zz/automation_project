@login
Feature: To verify Sign In page functionality

  @TCS-201
  Scenario: Verify the presence of login form
    When I am on the sign in page
    Then I should see username input field
    And I should see password input field
    And I should see sign in button