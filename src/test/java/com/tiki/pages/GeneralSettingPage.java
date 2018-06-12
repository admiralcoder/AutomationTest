package com.tiki.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tiki.utilities.Driver;



public class GeneralSettingPage {
	public GeneralSettingPage() {
		PageFactory.initElements(Driver.getInstance(), this);
	}
	
	public String pageTitle = "HomePage | General";
	
	@FindBy(linkText = "Home")
	public WebElement titlePage;
	
	@FindBy(linkText="Settings")
	public WebElement Settings;
	
	@FindBy(linkText="Control Panels")
	public WebElement controlPanel;
	
	@FindBy(linkText="General")
	public WebElement generalIcon;
		
	@FindBy(id="pref-4")
	public WebElement eachDay;
	
	@FindBy(id="pref-6")
	public WebElement browserTitle;
	
	@FindBy(xpath="//ul[@class='nav nav-tabs']/li[3]/a")
	public WebElement Navigation;
	
	@FindBy(xpath="(//div[@class='basic-selector'])[2]/select/option[2]")
	public WebElement wikiHome;
	
	@FindBy(linkText="Home")
	public WebElement homeLink;
	
	@FindBy(linkText="HomePage")
	public WebElement homePage;
	
	@FindBy(linkText="Apply")
	public WebElement apply;
	
	@FindBy(css = "button[class='btn btn-link dropdown-toggle']")
	public WebElement loginMenu;
	
	@FindBy(xpath="'(//div[@class='text-center'])[2]/input[1]'")
	public WebElement saveApply;
}
