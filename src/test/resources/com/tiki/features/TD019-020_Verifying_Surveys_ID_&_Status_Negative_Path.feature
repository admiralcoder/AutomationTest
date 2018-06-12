@Survey_create @Regression
Feature:
    
  Scenario: Survey status is not closed
  
  Given a user logs into Tiki Application, HomePage is displayed
  And a user opens Surveys 
	And a user creates new survey, enters "TypingDead" in Name box and changes Status to closed
	And a user saves it survey
	And a user verifies the name and status is closed
	When a user Edits "TypingDead" survey and changes the status to open
	And a user saves it survey
	And a user verifies the name and status is open
	
	
	Scenario: Survey ID is not used twice
	Given a user logs into Tiki Application, HomePage is displayed
  And a user opens Surveys 
	And a user saves the ID of "TypingDead" survey and removes it
	And a user creates new survey, enters "TypingDead" in Name box and changes Status to closed
	And a user saves it survey
	And verifies that ID is not as it was before removing it
