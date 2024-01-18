Feature: Login feature

  Scenario: Login Success
    Given I open browser
    And I open Login Page
    When I enter email "demo@class.com"
    And I enter password "Te$t$tudent"
    And I submit
    Then I am logged in