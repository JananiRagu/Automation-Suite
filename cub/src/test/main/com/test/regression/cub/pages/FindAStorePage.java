package com.test.regression.cub.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.regression.cub.utils.SuiteBase;

public class FindAStorePage extends SuiteBase{
	
	WebDriver _driver;
	
	public FindAStorePage(WebDriver driver) {
		
		_driver=driver;
		PageFactory.initElements(_driver, this);
	}
	
	@FindBy(xpath = "//a[text()='Find a Store']")
	private WebElement _FindAStore;

	
	@FindBy(id = "find-zip")
	private WebElement _enterzipcode;
	
	@FindBy(id = "find-city")
	private WebElement _city;
	
	@FindBy(id = "find-state")
	private WebElement _state;
	
	@FindBy(id = "find-radius")
	private WebElement _radius;
	
	@FindBy(xpath = "//input[@value='Search']")
	private WebElement _searchbutton;
	
	@FindBy(xpath = "//*[@id='store-filter-results-info']/li[1]")
	private WebElement _Resultstab;
	
	@FindBy(xpath = "//*[@id='store-search-result']/tbody/tr[1]/td[4]/div/a")
	private WebElement _Makethismystore;
	
	//Header
	@FindBy(xpath = "//a[text()='Savings']")
	private WebElement _Savings;
	
	@FindBy(xpath = "//a[text()='Departments']")
	private WebElement _Departments;
	
	//Change store in different pages
	@FindBy(xpath = "//*[@id='store-name']/span/a")
	private WebElement _clickchange;
	
	@FindBy(xpath = "//*[@id='layout']/div[2]/div[2]/div[1]/form/div/input")
	private WebElement _zipcodebox;
	
	@FindBy(xpath = "//*[@id='layout']/div[2]/div[2]/div[1]/form/button")
	private WebElement _clicksearch;
	
	@FindBy(xpath = "//*[@id='layout']/div[2]/div[2]/section/ul/a[2]")
	private WebElement _selectclickstore;
	
	@FindBy(xpath = "//*[@id='layout']/div[2]/div[2]/section/ul/a[2]/ul/li[1]")
	private WebElement _AddressLine;
	
	
	@FindBy(xpath = "//*[@id='layout']/div[2]/div[2]/section/button")
	private WebElement _clickusestore;
	
	@FindBy(xpath = "//*[@id='store-name']/a")
	private WebElement _checkstorename;
	
	//Clicking on View Stores by State
	
	@FindBy(xpath = "//*[@id='find-view-states']/ul/li[1]/a")
	private WebElement _clickstate1;
	
	@FindBy(xpath = "//*[@id='find-view-states']/ul/li[2]/a")
	private WebElement _clickstate2;
	
	@FindBy(xpath = "//*[@id='store-search-result']/tbody/tr[2]/td[4]/div/a")
	private WebElement _MakeStore;
	
	@FindBy(xpath="//*[@id='store-search-result']/tbody/tr[1]/td[4]/div/a")
	private WebElement _setstore1;

	@FindBy(xpath="//*[@id='store-search-result']/tbody/tr[2]/td[4]/div/a")
	private WebElement _setstore2;
	
	@FindBy(xpath = "//*[@id='nav-acct-findastore']/a")
	private WebElement _FAS;
	
	
	public void clickFindAStore() {
		_FindAStore.click();
	}
	public void clicksearchbutton(){
		_searchbutton.click();
	}
	
	public void enterZipCode(String zip){
		_enterzipcode.sendKeys(zip);
	}
	public void clickMakemyStore(){
		_Makethismystore.click();
	}
	public void entercity(String city){
		_city.sendKeys(city);
	}
	public void selectstate(String state){
		_state.sendKeys(state);
	}
	public int results(int result){
		String result1=_Resultstab.getText();
		String lastWord = result1.substring(result1.lastIndexOf(" ")+1);
		result=Integer.parseInt(lastWord);
		return result;
	}

	//Method
	public void clickOnSavings()
	{
	waitFor(_Savings);
	_Savings.click();
	} 
	public void clickOnDepartments()
	{
	waitFor(_Departments);
	_Departments.click();
	}
	

	
	//Method
	public void clickOnChange()
	{
	_clickchange.click();
	}
	public void clickOnSearch()
	{
	_clicksearch.click();
	}
	public void clickOnStore()
	{
	_selectclickstore.click();
	String Add=_selectclickstore.getText();
	System.out.println(Add);
	}
	public void clickOnusestore()
	{
	_clickusestore.click();
	}
	public void enterzip(String zip1){
		_zipcodebox.sendKeys(zip1);
	}
	public String AddressSavings(String Add){
		Add=_selectclickstore.getText();
		return Add;
	}
	public String Address2Departments(String Add2){
		Add2=_checkstorename.getText();
		return Add2;
	}
	
	
	//Method
	public void ClickState1()
	{
	_clickstate1.click();
	}
	
	public void ClickState2()
	{
		_clickstate2.click();
	}
	public void ClickStore()
	{
		_MakeStore.click();
	}
	
	public void ClickStore1()
	{
	_setstore1.click();
	}
	public void ClickStore2()
	{
	_setstore2.click();
	}
	
	public void clickFAS() {
		_FAS.click();
		}
}

