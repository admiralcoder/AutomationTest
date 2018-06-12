package com.tiki.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Factory;

import com.tiki.utilities.Driver;

public class HomePage {

	public String homePageTitle = "Home Page | HomePage";

	public HomePage() {
		PageFactory.initElements(Driver.getInstance(), this);
	}

	@FindBy(linkText = "Home")
	public WebElement home;

	@FindBy(linkText = "Search")
	public WebElement search;

	@FindBy(linkText = "Categories")
	public WebElement categories;

	@FindBy(linkText = "Tags")
	public WebElement tags;

	@FindBy(linkText = "Calendar")
	public WebElement calendar;

	@FindBy(linkText = "Trackers")
	public WebElement trackers;

	@FindBy(css = "a[href='tiki-list_trackers.php']")
	public WebElement listTrackers;
	
	@FindBy(partialLinkText="Blogs")
	public WebElement blogs;
	
	@FindBy(xpath="//*[@id=\"menu_option266\"]/li[2]/a")
	public WebElement createBlog;
	
	@FindBy(linkText="Surveys")
	public WebElement Survey;
	
	@FindBy(linkText="List Surveys")
	public WebElement listSurvey;
	
	@FindBy(css= "button[class='dropdown-toggle login_link btn btn-link']")
	public WebElement logoutMenu;
	
	@FindBy(linkText="Log out")
	public WebElement logout;
	
	public void openTrackerList() {
		trackers.click();
		listTrackers.click();
	}
	
	public void logout() {
		JavascriptExecutor js = (JavascriptExecutor) Driver.getInstance();
		js.executeScript("arguments[0].click();", logoutMenu);
		logout.click();
	}
}
