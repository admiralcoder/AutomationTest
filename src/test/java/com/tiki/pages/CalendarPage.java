package com.tiki.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tiki.utilities.Driver;

public class CalendarPage {
	public CalendarPage() {
		PageFactory.initElements(Driver.getInstance(), this);
	}
//=====================Background=========================\\
	@FindBy(linkText="Add Event")
	public WebElement AddEven;
	
	@FindBy(linkText="Admin Calendars")
	public WebElement AdminCalendar;
	
	
	@FindBy(linkText="Create Calendar")
	public WebElement CreateCalendar;
	
//========================	  Scenario: Create a new calendar======================\\
	@FindBy(id="calendarName")
	public WebElement CreateCalendarName;
	
	@FindBy(id="calendarDescription")
	public WebElement CreateCalendarDescription;
	
	@FindBy(xpath="//div[@class='col-sm-2']//select[@class='form-control date']")
	public WebElement startDay;
	
	@FindBy(xpath="//select[@name='endday_Hour']")
	public WebElement EndtDay;
	
	
	@FindBy(xpath="//select[@name='options[customcolors]']")
	public WebElement standardColor;
	
	@FindBy(xpath="//input[@name='save']")
	public WebElement save;
	
	
	@FindBy(linkText="Typing Dead Event")
	public WebElement tablename;
	
//=========================== Scenario: Create a new event=====================\\	
	
	@FindBy(id="calid")
	public WebElement Calendar;
	
	@FindBy(name="save[name]")
	public WebElement Title;
	
	@FindBy(id="id_recurrent")
	public WebElement RecurrenceButton;
	
	@FindBy(id="id_recurrenceTypeW")
	public WebElement WeeklyBasis;
	
	@FindBy(name="weekday")
	public WebElement weekDays;
	
	
	@FindBy(id="startPeriod_dptxt")
	public WebElement StartDayAddEvet;
	
	
	@FindBy(id="endPeriod_dptxt")
	public WebElement EndDayAddEvent;
	
	@FindBy(id="editwiki")
	public WebElement DescriptionOfEvet;
	
	@FindBy(name="act")
	public WebElement SaveEvent;
	
	@FindBy(xpath="//button[@class='ui-datepicker-close ui-state-default ui-priority-primary ui-corner-all']")
	public WebElement Done;
	
	@FindBy(xpath="//div[@id='configlinks']/a")
	public WebElement DefaultOptionInCalendar;
	
	@FindBy(name="refresh")
	public WebElement refresh;
	
	@FindBy(linkText="Our Scrum meeting Starts now")
	public WebElement mondayEvent;
	
	//=========================  Scenario: Delete the event user created================\\
	
	@FindBy(xpath="(//td[@class='action']//a/span[@class='icon icon-wrench glyphicon glyphicon-wrench '])[5]")
	public WebElement fixButton;
	
	@FindBy(xpath="(//div[@class='iconmenu'])[4]")
	public WebElement DeleteButton;
	
	
	@FindBy(linkText="Confirm action")
	public WebElement confirmAction;
	
	
	@FindBy(linkText="Typing Dead Event")
	public WebElement tableNames;
	
}
