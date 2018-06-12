package com.tiki.step_definitions;


import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.time.LocalDate;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import com.tiki.pages.CalendarPage;
import com.tiki.pages.HomePage;
import com.tiki.pages.LoginPage;
import com.tiki.utilities.BrowserUtils;
import com.tiki.utilities.ConfigurationReader;
import com.tiki.utilities.Driver;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CreatingEventInCalendarStepDefs {
	
	LoginPage loginPage = new LoginPage();
	HomePage homepage = new HomePage();
	CalendarPage calendarpage =new CalendarPage();

//BackGround	
	@Given("^a user opens Calendar$")
	public void a_user_opens_Calendar() {
	   homepage.calendar.click();
	}

	@When("^a user selects the Add Event$")
	public void a_user_selects_the_Add_Event() {
		calendarpage.AddEven.click();
	}
//========================= Scenario: Create a new calendar==============================\\
	@When("^a user selects Admin Calendars, clicks the Create Calendar link$")
	public void a_user_selects_Admin_Calendars_clicks_the_Create_Calendar_link() {
		calendarpage.AdminCalendar.click();
		calendarpage.CreateCalendar.click();
	}

	@When("^in the name box a user enters \"([^\"]*)\"and in the Description a user enters \"([^\"]*)\"$")
	public void in_the_name_box_a_user_enters_and_in_the_Description_a_user_enters(String name, String description) {
		calendarpage.CreateCalendarName.sendKeys(name);
		calendarpage.CreateCalendarDescription.sendKeys(description);
	}

	
	@Then("^a user selects Start of day \"([^\"]*)\" and End of Day \"([^\"]*)\" and selects Standard color \"([^\"]*)\"$")
	public void a_user_selects_Start_of_day_and_End_of_Day_and_selects_Standard_color(String StartDay, String EndDay, String Standarclor) {
		calendarpage.startDay.click();
		Select select = new Select(calendarpage.startDay);
		select.selectByValue(StartDay);
		calendarpage.EndtDay.click();
		Select select2 = new Select(calendarpage.EndtDay);
		select2.selectByValue(EndDay);
		calendarpage.standardColor.click();
		Select select3 = new Select(calendarpage.standardColor);
		select3.selectByVisibleText(Standarclor);
		
	}
	
	@Then("^a user clicks Save$")
	public void a_user_clicks_Save() {
		calendarpage.save.click();
	}

	@Then("^a user verifies the name of the event \"([^\"]*)\"$")
	public void a_user_verifies_the_name_of_the_event(String ExpactedtableName) {
		String Actualtablenames = calendarpage.tablename.getText();
		assertEquals(Actualtablenames,ExpactedtableName);
	}
//======================Scenario: Create a new calendar=============================\\
	@When("^a user chooses in Calendar \"([^\"]*)\"and a user enters the Title \"([^\"]*)\"$")
	public void a_user_chooses_in_Calendar_and_a_user_enters_the_Title(String Calendar, String title) {
		try {
			calendarpage.Calendar.click();
			Select select = new Select(calendarpage.Calendar);	
			BrowserUtils.waitFor(2);
			select.selectByVisibleText(Calendar);
			Alert alear =Driver.getInstance().switchTo().alert();
			alear.dismiss();
		}catch(NoAlertPresentException e) {
			System.out.println("Exception Found");
			Select select = new Select(calendarpage.Calendar);	
			BrowserUtils.waitFor(2);
			select.selectByVisibleText(Calendar);
		}
		calendarpage.Title.sendKeys(title);
	}

	@When("^a user selects Recurrence box and verifies On a weekly basis is selected, and sets \"([^\"]*)\"$")
	public void a_user_selects_Recurrence_box_and_verifies_On_a_weekly_basis_is_selected_and_sets(String weekday) {
		   calendarpage.RecurrenceButton.click();
		   assertTrue(calendarpage.WeeklyBasis.isSelected());
		   calendarpage.weekDays.click();
		   Select select = new Select(calendarpage.weekDays);
		   select.selectByVisibleText(weekday);
	}
	
	
	
@When("^a user chooses in Start period todays date and in End Before add five days$")
public void a_user_chooses_in_Start_period_todays_date_and_in_End_Before_add_five_days() {
	// This is todays date
	LocalDate today = LocalDate.now();
	String todaysdate = String.valueOf(today);
	calendarpage.StartDayAddEvet.sendKeys(todaysdate);
	// This is after five days
	LocalDate afterFiveDays = today.plusDays(5);			
	String newDay  = String.valueOf(afterFiveDays);
	calendarpage.EndDayAddEvent.sendKeys(newDay);
}
	
	
	@Then("^a user enters in Description \"([^\"]*)\" and saves it$")
	public void a_user_enters_in_Description_and_saves_it(String description) {
		calendarpage.DescriptionOfEvet.sendKeys(description);
		BrowserUtils.waitFor(2);
		JavascriptExecutor jse = (JavascriptExecutor)Driver.getInstance();
		jse.executeScript("arguments[0].scrollIntoView();", calendarpage.SaveEvent);
		calendarpage.Done.click();
		jse.executeScript("arguments[0].click();", calendarpage.SaveEvent);
	
	}

	@Then("^a user verifies the event on calendar they created \"([^\"]*)\"$")
	public void a_user_verifies_the_event_on_calendar_they_created(String MondayE) {
		
		try {
			//assertTrue(calendarpage.DefaultOptionInCalendar.getText().equals("Typing Dead Event"));
			SoftAssert softas=new SoftAssert();
			softas.assertTrue(calendarpage.DefaultOptionInCalendar.getText().equals("Typing Dead Event"));
		}catch(NoSuchElementException e) {
			System.out.println("Default Option Is Not Typing Dead Event");
			calendarpage.DefaultOptionInCalendar.click();
			Select select = new Select(calendarpage.DefaultOptionInCalendar);
			select.selectByVisibleText("Typing Dead Event (id #18)");
			calendarpage.refresh.click();
		}
		
		assertEquals(calendarpage.mondayEvent.getText(), MondayE);

	}
//=========================  Scenario: Delete the event user created================\\
	@When("^a user selects Admin Calendars$")
	public void a_user_selects_Admin_Calendars() {
		calendarpage.AdminCalendar.click();
	}

	@When("^a user hovers over Action for \"([^\"]*)\" and Deletes it$")
	public void a_user_hovers_over_Action_for_and_Deletes_it(String arg1) {
		BrowserUtils.hoverOver(calendarpage.fixButton);
		calendarpage.DeleteButton.click();
		calendarpage.confirmAction.click();
	}

	@When("^a user verifies that calendar \"([^\"]*)\" is not visible$")
	public void a_user_verifies_that_calendar_is_not_visible(String arg1) {
	   assertTrue(calendarpage.tableNames.getText().equals(arg1));
	}
	
}
