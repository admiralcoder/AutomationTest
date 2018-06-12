package com.tiki.step_definitions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.tiki.pages.HomePage;
import com.tiki.pages.LoginPage;
import com.tiki.pages.PHPDocumentationPage;
import com.tiki.pages.TrackerPage;
import com.tiki.utilities.BrowserUtils;
import com.tiki.utilities.ConfigurationReader;
import com.tiki.utilities.Driver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CreatingTrackerStepDefs {

	LoginPage loginPage = new LoginPage();
	HomePage homePage = new HomePage();
	TrackerPage trackerPage = new TrackerPage();
	PHPDocumentationPage docPage = new PHPDocumentationPage();

	@Given("^a user logs into Tiki Application, HomePage is displayed$")
	public void a_user_logges_into_Tiki_Application_HomePage_is_displayed() throws InterruptedException {
		Driver.getInstance().get(ConfigurationReader.getProperty("url"));
		loginPage.login(ConfigurationReader.getProperty("username"), ConfigurationReader.getProperty("password"));
		 loginPage.openMenuPage();
		assertEquals(Driver.getInstance().getTitle(), homePage.homePageTitle);
	}

	@Given("^a user creates tracker$")
	public void a_user_creates_tracker() {
		homePage.openTrackerList();
		trackerPage.createTracker.click();

	}

	@Given("^under General a user fills up the Name \"([^\"]*)\"$")
	public void under_General_a_user_fills_up_the_Name(String name) throws Exception {
		trackerPage.name.sendKeys(name);
	}

	@Given("^a user fills up Description \"([^\"]*)\"$")
	public void a_user_fills_up_Description(String description) {
		trackerPage.description.sendKeys(description);
	}

	@Given("^a user clicks Features$")
	public void a_user_clicks_Features() {
		trackerPage.features.click();
	}

	@Given("^a user selects Allow Ratings & changes Rating options \"([^\"]*)\"$")
	public void a_user_selects_Allow_Ratings_changes_Rating_options(String ratings) {
		BrowserUtils.clickElementWithJS(trackerPage.allowRatings);
		trackerPage.ratingOptions.sendKeys(ratings);
	}

	@Given("^a user selects Allow Attachments and verifies Creation date, Views, File size are selected$")
	public void a_user_selects_Allow_Attachments_and_verifies_Creation_date_Views_File_size_are_selected() {
		BrowserUtils.clickElementWithJS(trackerPage.allowAttachments);
		assertTrue(trackerPage.creationDateCheckBox.isSelected());
		assertTrue(trackerPage.viewsCheckBox.isSelected());
		assertTrue(trackerPage.fileSizeCheckBox.isSelected());
	}

	@Then("^a user saves it and verifies the Name is \"([^\"]*)\"$")
	public void a_user_saves_it_and_verifies_the_Name_is(String name) {
		trackerPage.save();
		assertEquals(trackerPage.trackerName.getText(), name);
	}

	@Then("^a user verifies the Description is \"([^\"]*)\"$")
	public void a_user_verifies_the_Description_is(String description) {
		assertEquals(trackerPage.trackerDescription.getText(), description);
	}

	@Given("^a user clicks Display$")
	public void a_user_clicks_Display() {
		trackerPage.display.click();
	}

	@Given("^a user enters in Logo \"([^\"]*)\"$")
	public void a_user_enters_in_Logo(String logo) {
		trackerPage.logo.sendKeys(logo);
	}

	@Given("^a user selects Show Status and verifies \"([^\"]*)\" is diplayed$")
	public void a_user_selects_Show_Status_and_verifies_is_diplayed(String showStatusAdminOnly) {
		BrowserUtils.clickElementWithJS(trackerPage.showStatusCheckBox);
		assertEquals(trackerPage.showStatusAdminOnly.getText(), showStatusAdminOnly);
	}

	@Given("^in Default sort order a user selects \"([^\"]*)\"$")
	public void in_Default_sort_order_a_user_selects(String creationDate) {
		trackerPage.selectDefaultOrderKey(creationDate);
	}

	@Given("^a user clicks Permissions and under Creation date constraint selects the date$")
	public void a_user_clicks_Permissions_and_under_Creation_date_constraint_selects_the_date() {
		trackerPage.permissions.click();
		// sending today`s date to Date box
		LocalDate date = LocalDate.now();
		DateTimeFormatter formatters = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		String todaysDate = date.format(formatters);
		trackerPage.startDate.sendKeys(todaysDate);

	}

	@Given("^a user enters \"([^\"]*)\", \"([^\"]*)\" in Time box$")
	public void a_user_enters_in_Time_box(String hours, String am) {
		trackerPage.startTime.sendKeys(hours + " " + am);
	}

	@Given("^a user clicks on the Display and selects Show creation date when listing items$")
	public void a_user_clicks_on_the_Display_and_selects_Show_creation_date_when_listing_items() {
		trackerPage.display.click();
		BrowserUtils.clickElementWithJS(trackerPage.showCreatedWhenListingBox);
	}

	@Given("^a user clicks Date and Time Format Help and verifies the title is \"([^\"]*)\"$")
	public void a_user_clicks_Date_and_Time_Format_Help_and_verifies_the_title_is(String title) {
		BrowserUtils.clickElementWithJS(trackerPage.dateAndTimeFormatHelp);
		BrowserUtils.switchToWindow(title);
		System.out.println(Driver.getInstance().getTitle());
		assertEquals(Driver.getInstance().getTitle(), title);
	}

	@Then("^a user scrolls down and clicks add a note and verifies the title is \"([^\"]*)\"$")
	public void a_user_scrolls_down_and_clicks_add_a_note_and_verifies_the_title_is(String title) {
		docPage.scrollDown();
		BrowserUtils.clickElementWithJS(docPage.addNote);

		BrowserUtils.switchToWindow(title);
		System.out.println(Driver.getInstance().getTitle());
		assertEquals(Driver.getInstance().getTitle(), title);
	}

	@Given("^tracker list is open$")
	public void tracker_list_is_open() {
		homePage.openTrackerList();
	}

	@When("^a user clicks on the first tracker and verifies the list of Properties is displayed:$")
	public void a_user_clicks_on_the_first_tracker_and_verifies_the_list_of_Properties_is_displayed(
			List<String> properties) {
		trackerPage.anyTrackerLink.click();
		trackerPage.properties.click();
		List<String> propertiesOption = new ArrayList<>();
		List<WebElement> propertiesOptionElement = Driver.getInstance().findElements(By.className("accordion-toggle"));
		for (WebElement webElement : propertiesOptionElement) {
			propertiesOption.add(webElement.getText());
		}

		for (int i = 0; i < properties.size(); i++) {
			assertEquals(propertiesOption.get(i), properties.get(i));
		}

	}

	@When("^a user opens Categories and select all$")
	public void a_user_opens_Categories_and_select_all() {
		BrowserUtils.clickElementWithJS(trackerPage.categories);
		BrowserUtils.clickElementWithJS(trackerPage.selectAllCategories);
	}

	@When("^a user verifies all Categories are selected$")
	public void a_user_verifies_all_Categories_are_selected() {
		for (int i = 1; i < 6; i++) {
			if (i != 4) {
				assertTrue(Driver.getInstance().findElement(By.id("categ-" + i)).isSelected());
			}
		}
	}

	@When("^a user saves it tracker$")
	public void a_user_saves_it_tracker() {
		trackerPage.save();
	}

	@Given("^a user finds trackers with the same name & leaves unique tracker$")
	public void a_user_finds_trackers_with_the_same_name_leaves_unique_tracker() {

		trackerPage.removeDuplicateTracker();

	}

	@Given("^a user verifies all trackers have unique name$")
	public void a_user_verifies_all_trackers_have_unique_name() {
		assertFalse(trackerPage.hasDuplicates());
	}
}