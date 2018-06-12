package com.tiki.step_definitions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.tiki.pages.GeneralSettingPage;
import com.tiki.pages.HomePage;
import com.tiki.utilities.BrowserUtils;
import com.tiki.utilities.Driver;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GeneralSettingsStepDefs {
	
	GeneralSettingPage generalSettings = new GeneralSettingPage();

// ----------- BACKGROUND ------------
	@Given("^a user chooses Control Panels and General link is selected$")
	public void a_user_chooses_Control_Panels_and_General_link_is_selected() {
	  generalSettings.Settings.click();
	  generalSettings.controlPanel.click();
	  generalSettings.generalIcon.click();
	  
		
	}
// --- Preference changes under General Control Panel Settings ---
	@When("^a user selects the Check for updates automatically & changes the Check frequency to \"([^\"]*)\"$")
	public void a_user_selects_the_Check_for_updates_automatically_changes_the_Check_frequency_to(String EachDay) {
		generalSettings.eachDay.sendKeys(EachDay);

	}

	@When("^a user clears the Browser title and enters \"([^\"]*)\"$")
	public void a_user_clears_the_Browser_title_and_enters(String typingDead) {
	 generalSettings.browserTitle.clear();
	 generalSettings.browserTitle.sendKeys(typingDead);
		
	}

	@When("^a user clicks Apply1$")
	public void a_user_clicks_Apply1() {
	    generalSettings.browserTitle.sendKeys(Keys.ENTER);
	}

	@When("^a user verifies \"([^\"]*)\" and the page title contains \"([^\"]*)\"$")
	public void a_user_verifies_and_the_page_title_contains(String changes, String title) {
		assertEquals(generalSettings.pageTitle, title);
		
	}
	
// ---- HomePage page in Wiki homepage -------
	@Then("^a user goes to Navigation link and selects in Wiki homepage \"([^\"]*)\"$")
	public void a_user_goes_to_Navigation_link_and_selects_in_Wiki_homepage(String HomePage) {

	   generalSettings.Navigation.click();
	 
	}

	@Then("^a user clicks Apply$")
	public void a_user_clicks_Apply() {

	}

	@Then("^a user goes to Home link under Menu and verifies the page title contains \"([^\"]*)\", the \"([^\"]*)\" is displayed$")
	public void a_user_goes_to_Home_link_under_Menu_and_verifies_the_page_title_contains_the_is_displayed(String homepage, String arg2) {
	    generalSettings.homeLink.click();

	}
}
