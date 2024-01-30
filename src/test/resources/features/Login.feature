Feature: Login feature

  Scenario: Login Success
    Given  I open Login page
    When I enter email "william.chang@testpro.io"
    And I enter password "te$tStudent"
    And I submit
    Then I am logged in