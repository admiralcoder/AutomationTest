package com.tiki.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tiki.utilities.Driver;

public class BlogPage {
	public BlogPage() {
		PageFactory.initElements(Driver.getInstance(), this);
	}
	@FindBy(id="blog-title")
	public WebElement blogTitle;
	
	@FindBy(xpath="//*[@id=\'contenttabs_editblog-1\']/div[3]/div/select/option[9]")
	public WebElement blogCategory;
	
	public WebElement name;
	
	@FindBy(xpath="//*[@id=\"blog-edit-form\"]/div[3]/input")
	public WebElement save;
	
	@FindBy(xpath="//*[@id='col1']/div[4]/table/tbody/tr[2]/td[1]/a")
	public WebElement blogDescription;
	
	
	public void save() {
		if(save.isDisplayed()) {
			save.click();
		}}
}
