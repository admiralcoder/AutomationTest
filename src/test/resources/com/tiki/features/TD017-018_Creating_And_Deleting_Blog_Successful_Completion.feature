
Feature: Creating and Deleting a Blog

  Background: 
    Given a user logs into Tiki Application, HomePage is displayed
@Create_Delete_Blog  @Regression
  Scenario: Creating a Blog
    When a user goes to Blog and clicks on Create Blog
    And a user enters Title "TypingDead" and selects in Creator "<creator>", a user saves it
    Then a user verifies blog "TypingDead" is displayed

  Scenario: Deleting a Blog
    When a user goes to Blog and clicks on List Blogs
    And a user verifies the "TypingDead" that is created by "<creator>" is displayed
    And a user hovers over Action and deletes it
    Then a user verifies "TypingDead" Blog is removed
