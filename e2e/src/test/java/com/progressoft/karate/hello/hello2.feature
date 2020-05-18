Feature: Hello Again

  Background:
    Given url baseUrl
    Given path '/computers'

  Scenario: Hello Peter

    Given param p = '0'
    When method GET
    Then status 200
    And match $ != ""