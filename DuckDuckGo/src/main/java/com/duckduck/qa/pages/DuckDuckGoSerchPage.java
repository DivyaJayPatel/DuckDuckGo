package com.duckduck.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.duckduck.qa.base.TestBase;

public class DuckDuckGoSerchPage extends TestBase
{
	@FindBy(name = "q")
	WebElement searchBox;

	@FindBy(xpath =  "//button[@type='submit']")
	WebElement searchButton;

	public DuckDuckGoSerchPage() 
	{
		PageFactory.initElements(driver, this);
	}

	public void search(String query) 
	{
		searchBox.sendKeys(query);
		searchButton.click();
	}


}
