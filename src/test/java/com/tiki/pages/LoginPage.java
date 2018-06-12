package com.tiki.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tiki.utilities.Driver;

public class LoginPage {

	public LoginPage() {
		PageFactory.initElements(Driver.getInstance(), this);
	}

	@FindBy(css = "button[class='btn btn-link dropdown-toggle']")
	public WebElement loginMenu;

	@FindBy(id = "login-user_1")
	public WebElement userName;

	@FindBy(id = "login-pass_1")
	public WebElement password;

	@FindBy(css = "button[type='submit']")
	public WebElement login;

	@FindBy(linkText = "start using it right away")
	public WebElement start;

	@FindBy(linkText = "Enable specific Tiki features")
	public WebElement enableFeatures;

	public void login(String username, String pwd) {
		JavascriptExecutor js = (JavascriptExecutor) Driver.getInstance();
		js.executeScript("arguments[0].click();", loginMenu);
		userName.sendKeys(username);
		password.sendKeys(pwd);
		login.click();
	}

	public void openMenuPage() {
		try {
			if (start.isDisplayed()) {
				start.click();
			} else
				enableFeatures.click();
		} catch (NoSuchElementException e) {
		}
	}
}
