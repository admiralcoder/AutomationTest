@Dima @Regression
Feature: Create new Article

  Background: 
    Given a user logs into Tiki Application, HomePage is displayed
    Then a user creates New Article

  
  Scenario: Create new Article with content
    Then a user fills the Title field "Typing Dead Forever"
    And a user fills the Heading field "It's the best team" and Body field "Never give up"
    And a user selects Allow full HTML checkbox
    And a user saves it
    And a user verifies article Title, Heading and Body text is displayed

  
  Scenario: Create new Article with Publication
    Then a user selects the Content and fills the Title field "Typing Dead TEST"
    Then a user verifies Published checkbox is selected
    Then a user selects the Publication and enters in Author name "Jimmy Johns" and enters UserName"Mark Smith"
    Then a user selects in Publish Date "June", "11", "2016"
    And a user selects in Expiration Date "May", "30", "2018"
    And a user saves it
    Then a user verifies "Typing Dead TEST" and "Jimmy Johns" and "2016-06-11" is displayed

 
  Scenario Outline: Delete Articles 
    Then a user opens List Articles and saves the number of articles
    And a user finds "<ArticlesTitle>" and hovers over Actions link, removes the article
    Then a user verifies "<Article Title>" and "Jimmy Johns" and "2017-06-11" is displayed
    

  Scenario Outline: Delete Articles #number should be changed 
    Then a user opens List Articles and saves the number of articles 
    And a user finds "Typing Dead Forever" and hovers over Actions link, removes the article
    And a user verifies the number of articles is less by one

    Examples: 
      | ArticlesTitle       |
      | Tiping Dead Forever |
      | Typing Dead TEST    |
