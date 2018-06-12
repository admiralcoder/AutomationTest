package com.tiki.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tiki.utilities.Driver;

public class SurveyPage {
	public SurveyPage() {
		PageFactory.initElements(Driver.getInstance(), this);
	}
	
	
	
	//=====================Scenario: Survey status is not closed=========================\\	
	@FindBy(linkText="Create New Survey")
	public WebElement CreateNewSurvey;
	
	@FindBy(id="name")
	public WebElement nameBox;
	
	
	@FindBy(name="status")
	public WebElement status;
	
	
	@FindBy(xpath="//div[@class='col-sm-10 col-sm-offset-2']/input")
	public WebElement saveBotton;
	
	
	@FindBy(xpath="//*[.='TypingDead']")
	public WebElement surveyName;
	
	
	@FindBy(xpath="(//*[.='TypingDead']/../../td)[3]/a")
	public WebElement statusCheck;
	
	
	@FindBy(xpath="//*[@class='popover fade right in']")
	public WebElement clsoedText;
	
	
	@FindBy(xpath="(//*[.='TypingDead']/../../td)[5]/a")
	public WebElement UpdateButton;
	
	
	@FindBy(xpath="(//span[@class='iconmenutext'])[3]")
	public WebElement EditButton;
	
	
	
	//============================Scenario: Survey ID is not used twice===========\\
	
	@FindBy(linkText="Admin Surveys")
	public WebElement adminSurvey;
	
	@FindBy(xpath="(//*[.='TypingDead']/../../td)[1]")
	public WebElement SurveyId;
	
	
	@FindBy(xpath="(//span[@class='iconmenutext'])[4]")
	public WebElement RemoveButton;
	
	
	@FindBy(linkText="Confirm action")
    public WebElement ConfirmAction;
	
	
	@FindBy(linkText="Create/Edit Surveys")
	public WebElement CreateEdit;
	
	
	
}
