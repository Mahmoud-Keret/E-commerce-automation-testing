@smoke
Feature: Check home slider feature
  Scenario: Click on the first slider and check the URL
    Given click on the first slider
    Then wait until the first slider url contains the expected result
    And check if the first slider expected url is the same as actual url

  Scenario: Click on the second slider and check the URL
    Given click on the second slider
    Then wait until the second slider url contains the expected result
    And check if the second slider expected url is the same as actual url