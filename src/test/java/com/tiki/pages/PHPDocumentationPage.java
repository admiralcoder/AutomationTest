package com.tiki.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tiki.utilities.Driver;

public class PHPDocumentationPage {

	public PHPDocumentationPage() {
		PageFactory.initElements(Driver.getInstance(), this);
	}

	@FindBy(xpath = "(//img[@alt='add a note'])/../small")
	public WebElement addNote;

	public void scrollDown() {
		Actions actions = new Actions(Driver.getInstance());
		actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
	}

}
