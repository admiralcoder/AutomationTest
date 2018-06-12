package com.tiki.step_definitions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.tiki.pages.HomePage;
import com.tiki.pages.SurveyPage;
import com.tiki.utilities.BrowserUtils;
import com.tiki.utilities.Driver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class CreatingSurveyStepDefinitions {
	
	HomePage homepage = new HomePage();
	SurveyPage surpage = new SurveyPage();
	
	
//=====================Scenario: Survey status is not closed=========================\\	
		
	
	@Given("^a user opens Surveys$")
	public void a_user_opens_Surveys() {
	  homepage.Survey.click();
	  homepage.listSurvey.click();
	  surpage.CreateNewSurvey.click();
	}
		

	@Given("^a user creates new survey, enters \"([^\"]*)\" in Name box and changes Status to closed$")
	public void a_user_creates_new_survey_enters_in_Name_box_and_changes_Status_to_closed(String name) {
	  surpage.nameBox.sendKeys(name);
	  Select select = new Select(surpage.status);
	  select.selectByVisibleText("Closed");	  
	}

	@Given("^a user saves it survey$")
	public void a_user_saves_it_survey() {
		BrowserUtils.clickElementWithJS(surpage.saveBotton);
		
	}

	@Given("^a user verifies the name and status is closed$")
	public void a_user_verifies_the_name_and_status_is_closed() {
		BrowserUtils.scrollDownPageWithJS(surpage.surveyName);
		assertEquals(surpage.surveyName.getText(), "TypingDead", 
				"The Survey Name is not maching");
		BrowserUtils.hoverOver(surpage.statusCheck);
		assertEquals(surpage.clsoedText.getText(), "Closed",
				"The status is not Close");
		
	}

	@When("^a user Edits \"([^\"]*)\" survey and changes the status to open$")
	public void a_user_Edits_survey_and_changes_the_status_to_open(String Name) {
		assertEquals(surpage.surveyName.getText(), Name, 
				"The Survey Name is not maching");
		BrowserUtils.hoverOver(surpage.UpdateButton);
		surpage.EditButton.click();
		
		Select select = new Select(surpage.status);
		  select.selectByVisibleText("Open");
	}


	static int preId;

	@When("^a user verifies the name and status is open$")
	public void a_user_verifies_the_name_and_status_is_open() {
	  BrowserUtils.hoverOver(surpage.statusCheck);
	  assertEquals(surpage.clsoedText.getText(), "Open",
				"The status is not Open");
	  preId=Integer.parseInt(surpage.SurveyId.getText());
	
	}
	
//============================Scenario: Survey ID is not used twice===========\\
	
	
	
	 
	@Given("^a user saves the ID of \"([^\"]*)\" survey and removes it$")
	public void a_user_saves_the_ID_of_survey_and_removes_it(String Name) {
		assertEquals(surpage.surveyName.getText(), Name, 
				"The Survey Name is not maching");
		BrowserUtils.hoverOver(surpage.UpdateButton);
		surpage.RemoveButton.click();
		surpage.ConfirmAction.click();
		surpage.CreateEdit.click();
		
	}
	static int newId;
	@Given("^verifies that ID is not as it was before removing it$")
	public void verifies_that_ID_is_not_as_it_was_before_removing_it() {
		newId=Integer.parseInt(surpage.SurveyId.getText());
		assertTrue(preId !=newId);
	}

	
	
}
