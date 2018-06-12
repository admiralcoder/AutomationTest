
Feature: Genearl Settings & Preferences Changes

  Background: 
    Given a user logs into Tiki Application, HomePage is displayed
    And a user chooses Control Panels and General link is selected

  Scenario: Preference changes under General Control Panel Settings
    When a user selects the Check for updates automatically & changes the Check frequency to "Each day"
    And a user clears the Browser title and enters "HomePage"
    And a user clicks Apply1
    And a user verifies "The following changes have been applied" and the page title contains "HomePage | General"

  Scenario: HomePage page in Wiki homepage
    Then a user goes to Navigation link and selects in Wiki homepage "HomePage"
    And a user clicks Apply
    And a user goes to Home link under Menu and verifies the page title contains "HomePage", the "Message" is displayed
    
