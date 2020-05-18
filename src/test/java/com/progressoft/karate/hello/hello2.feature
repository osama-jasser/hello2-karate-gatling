Feature: Hello Again

  Background:
    Given url 'http://computer-database.gatling.io'
    Given path '/computers'

  Scenario: Hello Peter

    Given param p = '0'
    When method GET
    Then status 200
    And match $ != ""