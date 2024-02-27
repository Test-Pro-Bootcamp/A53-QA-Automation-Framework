Feature: Login feature
  Scenario: Login Success
    Given I open Login Page
    When I enter email "dmitry.lobachev@testpro.io"
    And I enter password "Chebyreki5!"
    And I click Submit
    Then I am logged in