Feature: Login feature
  Scenario: Login Success
    Given I open Login page
    When I enter email "dmitry.lobachev@testpro.io"
    And I enter password "Chebyreki5!"
    And I submit
    Then I am logged in