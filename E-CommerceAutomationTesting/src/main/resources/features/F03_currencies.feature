@smoke
  Feature: F03_Currencies | Change currency to euro and check items price
    Scenario: Change currency to euro and check items price
      Given click on the currency drop menu
      And choose euro
      Then check that items price updated to euro