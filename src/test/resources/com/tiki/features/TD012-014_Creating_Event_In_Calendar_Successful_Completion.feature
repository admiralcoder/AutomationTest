@Regression
Feature: Creating a new calendar

  Background: 
    Given a user logs into Tiki Application, HomePage is displayed
    And a user opens Calendar
    When a user selects the Add Event

  @Creating_Event
  Scenario: Create a new calendar
    And a user selects Admin Calendars, clicks the Create Calendar link
    And in the name box a user enters "Typing Dead Event"and in the Description a user enters "This event starts now"
    Then a user selects Start of day "07" and End of Day "23" and selects Standard color "Purple"
    And a user clicks Save
    Then a user verifies the name of the event "Typing Dead Event"
    
 @Creating_NewEvent
  Scenario: Create a new event									
    And a user chooses in Calendar "Typing Dead Event"and a user enters the Title "Our Scrum meeting Starts now"
    And a user selects Recurrence box and verifies On a weekly basis is selected, and sets "Monday"
    And a user chooses in Start period todays date and in End Before add five days 
    Then a user enters in Description "Finally this event is happening." and saves it
    And a user verifies the event on calendar they created "Our Scrum meeting Starts now"
    
 @Delete_Event
   Scenario: Delete the event user created
    And a user selects Admin Calendars
    When a user hovers over Action for "Typing Dead Event" and Deletes it
    And a user verifies that calendar "Typing Dead Event" is not visible
