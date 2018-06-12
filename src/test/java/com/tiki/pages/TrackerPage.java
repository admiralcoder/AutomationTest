package com.tiki.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.tiki.utilities.BrowserUtils;
import com.tiki.utilities.Driver;

public class TrackerPage {

	public TrackerPage() {
		PageFactory.initElements(Driver.getInstance(), this);
	}

	@FindBy(css = "a[href='tiki-ajax_services.php?controller=tracker&action=replace&modal=1']")
	public WebElement createTracker;

	public WebElement name;

	public WebElement description;

	@FindBy(css = "button[class='btn btn-primary auto-btn']")
	public WebElement save;

	@FindBy(partialLinkText = "Features")
	public WebElement features;

	@FindBy(name = "useRatings")
	public WebElement allowRatings;

	public WebElement ratingOptions;

	@FindBy(name = "useAttachments")
	public WebElement allowAttachments;

	@FindBy(css = "input[value='created']")
	public WebElement creationDateCheckBox;

	@FindBy(css = "input[value='hits']")
	public WebElement viewsCheckBox;

	@FindBy(css = "input[value='filesize']")
	public WebElement fileSizeCheckBox;

	@FindBy(linkText = "Typing Dead Tracker")
	public WebElement trackerName;

	@FindBy(xpath = "//a[contains(text(),'Typing Dead')]/../div")
	public WebElement trackerDescription;

	@FindBy(partialLinkText = "Display")
	public WebElement display;

	public WebElement logo;

	@FindBy(css = "input[name='showStatus']")
	public WebElement showStatusCheckBox;

	@FindBy(xpath = "//div[@data-on='showStatus']/label")
	public WebElement showStatusAdminOnly;

	public WebElement defaultOrderKey;

	@FindBy(partialLinkText = "Permissions")
	public WebElement permissions;

	public WebElement startDate;

	public WebElement startTime;

	@FindBy(css = "input[name='showCreated']")
	public WebElement showCreatedWhenListingBox;

	@FindBy(linkText = "Date and Time Format Help")
	public WebElement dateAndTimeFormatHelp;

	@FindBy(xpath = "//div[@class='description help-block']/../a")
	public WebElement anyTrackerLink;

	@FindBy(xpath="//span[@class='icon icon-settings glyphicon glyphicon-wrench ']/..")
	public WebElement properties;

	@FindBy(className = "accordion-toggle")
	public WebElement propertiesOption;

	@FindBy(xpath = "(//a[@class='accordion-toggle'])[8]")
	public WebElement categories;

	@FindBy(css = "label[for='clickall']")
	public WebElement selectAllCategories;

	@FindBy(css = "span[class='icon icon-wrench glyphicon glyphicon-wrench '])")
	public WebElement actions;

	@FindBy(css = "button[class='btn btn-default btn-sm auto-btn']")
	public WebElement remove;

	public void save() {
		if (save.isDisplayed()) {
			save.click();
		}
	}

	public void selectDefaultOrderKey(String value) {
		Select select = new Select(defaultOrderKey);
		select.selectByVisibleText(value);
	}

	public void removeDuplicateTracker() {
		int num = 1;
		do {
			List<WebElement> listLinks = Driver.getInstance()
					.findElements(By.xpath("//div[@class='description help-block']/../a"));

			for (int i = 0; i < listLinks.size(); i++) {
				for (int j = i + 1; j < listLinks.size(); j++) {
					if (listLinks.get(i).getText().equalsIgnoreCase(listLinks.get(j).getText())) {						
						BrowserUtils.hoverOver(Driver.getInstance().findElement(By
								.xpath("(//span[@class='icon icon-wrench glyphicon glyphicon-wrench '])[" + j + "]")));
						Driver.getInstance()
								.findElement(By.xpath(
										"(//span[@class='icon icon-remove glyphicon glyphicon-remove '])[1]"))
								.click();
						remove.click();
						Driver.getInstance().navigate().refresh();
						listLinks = Driver.getInstance()
								.findElements(By.xpath("//div[@class='description help-block']/../a"));
					} else
						num = 0;
				}
			}
		} while (num != 0);
	}
	
	public boolean hasDuplicates() {
		List<WebElement> listLinks = Driver.getInstance()
				.findElements(By.xpath("//div[@class='description help-block']/../a"));
		List<String> uniqueTrackers =new ArrayList<>();
		for (WebElement list : listLinks) {
			uniqueTrackers.add(list.getText());
		}
		if (uniqueTrackers.size() <= 1)
			return false;

		for (int i = 0; i < uniqueTrackers.size(); i++) {
			for (int j = i + 1; j < uniqueTrackers.size(); j++) {
				if (uniqueTrackers.get(i) == uniqueTrackers.get(j))
					return true;
			}
		}
		return false;
	}
}