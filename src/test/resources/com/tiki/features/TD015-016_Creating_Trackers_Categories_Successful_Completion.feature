
Feature: Create Categories

  Background: 
    Given a user logs into Tiki Application, HomePage is displayed
@create_categories 
  Scenario: 
    And a user creates tracker
    And under General a user fills up the Name "Typing Dead Tracker"
    And a user clicks on the Categories and clicks on Categories link
    When a user in Parent selects "Week 1" and in Name enters "Features"
    And a user fills up the Description with "Features are created by Typing Dead"
    And a user click the save in the  tracking categories

@verify_categories
  Scenario: 
    When a user click on Categories then clicks Features and verifies "Category:Features" is displayed
    Then a user verifies "Features are created by TypingDead." is displayed
    And a user goes to Admin Categories, deletes it and verifies "Features" is not displayed 
