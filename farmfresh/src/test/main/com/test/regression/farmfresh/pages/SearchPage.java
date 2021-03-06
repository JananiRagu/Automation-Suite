package com.test.regression.farmfresh.pages;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.regression.farmfresh.utils.SuiteBase;

public class SearchPage extends SuiteBase{
	
	WebDriver _driver;
	
	public SearchPage (WebDriver driver) {
		super();
		_driver=driver;
		PageFactory.initElements(_driver, this);
		
	}
	
	// Search text box in home page
	
	@FindBy(xpath = "//*[@id='frm-search']/*[@id='inp-search']")
	private WebElement _SearchTextField;
	
		// Inside search page  ---- Search text box 
		@FindBy(xpath = "//*[@id='frm-searchrefine']/input[1]")
		private WebElement _SearchTextBox;
	
	@FindBy(xpath = "//*[@id='frm-search']/*[@type='submit']")
	private WebElement _ArrowButton;
	
		// Inside search page  ---- Search button 
		@FindBy(xpath = "//*[@id='btn-searchrefine']")
		private WebElement SearchButton;
	
	// Inside Recipes page 
	
	@FindBy(xpath = "//*[@id='content-primary']/div/div/div/h4/strong")
	private WebElement _BlankSearchMessage;

	@FindBy(xpath = "//*[@id='content-primary']/div/div/div[1]/ul[2]")
	private List<WebElement> _SearchNodeList;
	
	@FindBy(xpath = "//*[@id='filter-results-info']/li[3]/a")
	private WebElement _SearchResultsNumberlink_25;

	@FindBy(xpath = "//*[@id='filter-results-info']/li[4]/a")
	private WebElement _SearchResultsNumberlink_50;

	@FindBy(xpath = "//*[@id='content-primary']/div/div/div[2]/div/ul/li[2]/ol/li[8]/a")
	public WebElement _LastPaginationLink;
	
	@FindBy(xpath = "//*[@id='content-primary']/div/div/div[2]/div/ul/li[2]/ol/li[4]/a")
	public WebElement _PaginationLinkNumber_3;
	
	//Previous and Next link properties after clicking on Last pagination link
	
	//@FindBy(xpath = "//*[@id='content-primary']/div/div/div[2]/div/ul/li[1]/a")
	@FindBy(xpath = "//*[@class='previous']")
	public WebElement _LinkSearch_Previous;
	
	@FindBy(xpath = "//*[@class='next']")
	public WebElement _LinkSearch_Next;
	
	
	//------------------------------ *Methods to operate on elements *----------------------------------------
	
	
	public void enterSearchDetails(String SearchText)
	{
		waitFor(_SearchTextField);
		_SearchTextField.sendKeys(SearchText);
	}
	
	public void enterSearchText(String SearchText)
	{
		waitFor(_SearchTextBox);
		_SearchTextBox.sendKeys(SearchText);
	}
	
	public void clickSearchArrow()
	{
		waitFor(_ArrowButton);
		_ArrowButton.sendKeys(Keys.ENTER);
	}
	
	public void clickSearchButon()
	{
		waitFor(SearchButton);
		SearchButton.sendKeys(Keys.ENTER);
	}
	
	/* ------------Inside search page ----------*/ 

	
	public String GetSearchMessage()
	{
		waitFor(_BlankSearchMessage);
		String TextMessage =_BlankSearchMessage.getText();
		return TextMessage ;
	}
	
	public int NodeListNumber(){
		
		System.out.println("Inside NodeListNUmber method");
		
		int NodelistSize = _SearchNodeList.size();
		System.out.println("Node list count: " + NodelistSize);
		return NodelistSize;
	}
	
	public void clickOnLinkNumber_25()
	{
		waitFor(_SearchResultsNumberlink_25);
		_SearchResultsNumberlink_25.click();
	}	
	
	public void clickOnLinkNumber_50()
	{
		waitFor(_SearchResultsNumberlink_50);
		_SearchResultsNumberlink_50.click();
	}	
	
	public void clickOnSearchLink_Next()
	{
		waitFor(_LinkSearch_Next);
		_LinkSearch_Next.click();
	}
	
	public String Link_Next()
	{
		waitFor(_LinkSearch_Next);
		String Next_Status = _LinkSearch_Next.getAttribute("disabled");
		return Next_Status;
	}

	public void clickOnSearchLink_Primary()
	{
		waitFor(_LinkSearch_Previous);
		_LinkSearch_Previous.click();
	}
	
	public String Link_Previous()
	{
		waitFor(_LinkSearch_Previous);
		String Previous_Status = _LinkSearch_Previous.getAttribute("disabled");
		return Previous_Status;
	}
	
	public void clickOn_PaginationLinkNumber_3()
	{
		waitFor(_PaginationLinkNumber_3);
		_PaginationLinkNumber_3.click();
	}

	public void clickOn_LastPaginationLink()
	{
		waitFor(_LastPaginationLink);
		_LastPaginationLink.click();
	}

	public String GetCurrentURL()
	{
		String DisplayedURL = _driver.getCurrentUrl();
		return DisplayedURL;
	}
	
}

