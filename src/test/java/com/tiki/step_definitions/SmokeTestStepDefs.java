package com.tiki.step_definitions;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;

import com.tiki.pages.HomePage;
import com.tiki.pages.LoginPage;
import com.tiki.utilities.Driver;

import cucumber.api.java.en.Given;

public class SmokeTestStepDefs {

	HomePage homePage = new HomePage();
	LoginPage loginPage = new LoginPage();

	@Given("^a user verifies following menu options are displayed$")
	public void a_user_verifies_are_displayed(List<String> menuOptions) {
		List<String> menu = new ArrayList<>();
		for (String menuOpt : menuOptions) {
			menu.add(Driver.getInstance().findElement(By.partialLinkText(menuOpt)).getText());
		}

		for (int i = 0; i < menu.size(); i++) {
			assertEquals(menu.get(i), menuOptions.get(i));
		}

	}

	@Given("^a user logs out$")
	public void a_user_logs_out() {
		homePage.logout();
	}
}
