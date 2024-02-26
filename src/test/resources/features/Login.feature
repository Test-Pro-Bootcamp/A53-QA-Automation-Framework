Feature: Login feature
  Scenario: Login Success
    Given I open Login Page
    When I enter email "andrew.simmons@testpro.io"
    And I enter password "Andrew.Simmons24"
    And I click Submit
    Then I am logged in