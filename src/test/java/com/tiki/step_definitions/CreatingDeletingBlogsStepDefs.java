package com.tiki.step_definitions;

import static org.testng.Assert.assertEquals;

import com.tiki.pages.BlogPage;
import com.tiki.pages.HomePage;
import com.tiki.pages.LoginPage;

import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CreatingDeletingBlogsStepDefs {

	LoginPage loginPage = new LoginPage();
	HomePage homePage = new HomePage();
	BlogPage blogPage=new BlogPage();
	
	
	@When("^a user goes to Blog and clicks on Create Blog$")
	public void a_user_goes_to_Blog_and_clicks_on_Create_Blog() throws Exception {
	 homePage.blogs.click();
	 Thread.sleep(5000);
	 homePage.createBlog.click();
	}

	@When("^a user enters Title \"([^\"]*)\" and selects in Creator \"([^\"]*)\", a user saves it$")
	public void a_user_enters_Title_and_selects_in_Creator_a_user_saves_it(String title, String category) throws Exception {
	  blogPage.blogTitle.sendKeys(title);
	  blogPage.blogCategory.click();
	  Thread.sleep(5000);
	  blogPage.save();
	}

	@Then("^a user verifies blog \"([^\"]*)\" is displayed$")
	public void a_user_verifies_blog_is_displayed(String title) {
		assertEquals(blogPage.blogDescription.getText(), title);
	}
}
