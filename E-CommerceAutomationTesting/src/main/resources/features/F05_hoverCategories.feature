@smoke
Feature: Select sub category from main category
  Scenario: Hover on main category and click on sub category
    Given Hover on main category and click on sub category
    When get text of page title
    Then check the selected category has the same title
    And doing advanced assert using if