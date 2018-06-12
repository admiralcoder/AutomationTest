package com.tiki.step_definitions;

import org.openqa.selenium.JavascriptExecutor;

import com.tiki.pages.CategoriesPage;
import com.tiki.pages.HomePage;
import com.tiki.pages.LoginPage;
import com.tiki.utilities.BrowserUtils;
import com.tiki.utilities.Driver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CreatingCategoriesStepDefinitions {
	CategoriesPage cp = new CategoriesPage();
	HomePage hp = new HomePage();
	LoginPage lp = new LoginPage();

	@Given("^a user clicks on the Categories and clicks on Categories link$")
	public void a_user_clicks_on_the_Categories_and_clicks_on_Categories_link() {
		JavascriptExecutor jse = (JavascriptExecutor) Driver.getInstance();
		cp.categories.click();
		jse.executeScript("arguments[0].click();", cp.categorieswithgear);
	}

	@When("^a user in Parent selects \"([^\"]*)\" and in Name enters \"([^\"]*)\"$")
	public void a_user_in_Parent_selects_and_in_Name_enters(String arg1, String name) {
		cp.parentId.click();
		cp.week1.click();
		cp.name.sendKeys(name);

	}

	@When("^a user fills up the Description with \"([^\"]*)\"$")
	public void a_user_fills_up_the_Description_with(String description) {
		cp.description.sendKeys(description);
	}

	@When("^a user click the save in the  tracking categories$")
	public void a_user_click_the_save_in_the_tracking_categories() {
		cp.save.click();
	}

	@When("^a user click on Categories then clicks Features and verifies \"([^\"]*)\" is displayed$")
	public void a_user_click_on_Categories_then_clicks_Features_and_verifies_is_displayed(String arg1) {
		 hp.categories.click();
		// cp.rightarrow.click();
		// cp.features.click();
		BrowserUtils.clickElementWithJS(cp.rightarrow);
	    BrowserUtils.clickElementWithJS(cp.features);

	}

	@Then("^a user verifies \"([^\"]*)\" is displayed$")
	public void a_user_verifies_is_displayed(String arg1) {

	}

	@Then("^a user goes to Admin Categories, deletes it and verifies \"([^\"]*)\" is not displayed$")
	public void a_user_goes_to_Admin_Categories_deletes_it_and_verifies_is_not_displayed(String arg1) {

	}
}
