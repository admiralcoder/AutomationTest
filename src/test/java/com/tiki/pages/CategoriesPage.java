package com.tiki.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.tiki.utilities.Driver;

public class CategoriesPage {
	public CategoriesPage() {
		PageFactory.initElements(Driver.getInstance(), this);
	}

	@FindBy(xpath = "(//a[@class='accordion-toggle'])[8]")
	public WebElement categories;

	@FindBy(xpath = "(//a[@class='btn btn-link'])[3]")
	public WebElement categorieswithgear;

	public WebElement parentId;

	@FindBy(xpath = "//select[@id='parentId']/option[2]")
	public WebElement week1;

	public WebElement name;

	public WebElement description;

	@FindBy(xpath = "(//input[@class='btn btn-primary'])[1]")
	public WebElement save;

	@FindBy(xpath = "(//a[@class='catname'])[1]")
	public WebElement clickFeaures;

	@FindBy(css = "span[style='float: left; margin-top: 0.2em; cursor: pointer;']")
	public WebElement rightarrow;
	
	@FindBy(xpath ="(//a[@class='catname'])[2]")
	public WebElement features;
}
