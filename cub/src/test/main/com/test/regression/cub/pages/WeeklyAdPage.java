package com.test.regression.cub.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.regression.cub.utils.Logg;
import com.test.regression.cub.utils.SuiteBase;

public class WeeklyAdPage extends SuiteBase{

	WebDriver _driver;
	Logger log = Logg.createLogger();

	
	public WeeklyAdPage(WebDriver driver) {
		super();
		_driver=driver;
		PageFactory.initElements(_driver, this);
	}
	
	@FindBy(xpath = "//button[text()='Create a List']")
	private WebElement _createAList;
	
	public void clickOnCreateListButton(){
		
		waitFor(_createAList);
		_createAList.click();
	}
}
