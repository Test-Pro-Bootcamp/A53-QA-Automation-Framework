Feature: Login Feature

  Scenario: Login Success
    Given I open login page
    When I enter email "demo@class.com"
    And I enter password "te$t$tudent"
    And I submit
    Then I am logged in

