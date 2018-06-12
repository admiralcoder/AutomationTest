@Properties_&_duplicate_trackers @Regression
Feature: Existing tracker properties

  Background: 
    Given a user logs into Tiki Application, HomePage is displayed
    And tracker list is open

  Scenario: Existing tracker properties
    When a user clicks on the first tracker and verifies the list of Properties is displayed:
      | General        |
      | Features       |
      | Display        |
      | Section Format |
      | Status         |
      | Notifications  |
      | Permissions    |
      | Categories     |
    And a user opens Categories and select all
    And a user verifies all Categories are selected
    And a user saves it tracker

  Scenario: Delete duplicate trackers
    And a user finds trackers with the same name & leaves unique tracker
    And a user verifies all trackers have unique name
