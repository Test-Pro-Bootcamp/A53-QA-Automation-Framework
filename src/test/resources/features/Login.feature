Feature: Login Feature

  Scenario: Login success
    Given I open login Page
    When I enter email "utku.aktas94@testpro.io"
    And I enter password "ekga9uf6"
    And I submit
    Then I am logged in