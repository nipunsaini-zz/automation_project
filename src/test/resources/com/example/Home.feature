@home
Feature: To verify authenticated and unauthenticated Home page functionality

  @TCS-101
  Scenario: Verify the presence of Sign in link on header
    Given I am a visitor user
    When I navigate to visitor home page
    Then I should see sign in link on the top of the page
    And Sign in link should be clickable