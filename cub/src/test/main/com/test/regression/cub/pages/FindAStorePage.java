package com.test.regression.cub.pages;


import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.regression.cub.utils.Constant;
import com.test.regression.cub.utils.ReadPropertiesFile;
import com.test.regression.cub.utils.SuiteBase;

public class FindAStorePage extends SuiteBase{
	
	WebDriver _driver;
	
	ReadPropertiesFile properties = new ReadPropertiesFile();
	
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
	
	@FindBy(id="find-address")
	private WebElement _StreetAddress;
	
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
	
	@FindBy(xpath = "//*[@id='layout']/div[2]/div[2]/section/ul/a[2]/ul/li[1]")
	private WebElement _AddressLineinMyAccount;
	
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
	
	@FindBy(xpath = "//*[@id='store-details']/p[2]/a[1]")
	private WebElement _maps;
	
	@FindBy(xpath = "//*[@id='store-details']/p[2]/a[2]")
	private WebElement _drivingdirection;
	
	@FindBy(xpath = "//*[@id='from']")
	private WebElement _fromlocation;
	
	@FindBy(xpath = "//*[@id='form-drivingdirections']/button")
	private WebElement _searchdirection;
	
	@FindBy(xpath = "//*[@id='error-message-container']")
	private WebElement _errormessage;
	
	@FindBy(xpath = "//*[@id='content-primary']/div/div/li")
	private WebElement _errormessage1;
	
	@FindBy(xpath = "//*[@id='content-primary']/div/div[2]/div[3]/ul/li[2]/ol/li[1]")
	private WebElement _pagenumber;
	
	@FindBy(xpath = "//*[@id='content-primary']/div/div/div[4]/ul/li[1]")
	private WebElement _Previous;
	
	@FindBy(xpath = "//*[@id='content-primary']/div/div[2]/div[3]/ul/li[3]/a")
	private WebElement _Next;
	
	@FindBy(xpath = "//*[@id='toolsMenu']")
	private WebElement _MyToolsLink1;
	
	@FindBy(xpath = "//a[text()='My Store']")
	private WebElement _MyStore;
	
	@FindBy(xpath = "//*[@id='store-filter-results-info']/li[3]/a")
	private WebElement _show25;
	
	@FindBy(xpath = "//*[@id='store-filter-results-info']/li[4]/a")
	private WebElement _show50;
	
	
	@FindBy(xpath = "//*[@id='store-button-makemystore']/div/a")
	private WebElement _changemystore;//Change store from view store page
	
	@FindBy(xpath = "//*[@id='util-print']/button")
	private WebElement _printlink;
	
	//Pharmacy
	@FindBy(xpath = "//*[@id='ZIP']")
	private WebElement _enterzippharma;
	
	@FindBy(xpath = "//*[@id='City']")
	private WebElement _entercitypharma;
	
	@FindBy(xpath = "//*[@id='State']")
	private WebElement _selectstatepharma;
	
	@FindBy(xpath = "//*[@id='find-store']/div[3]/div/button")
	private WebElement _clicksearchpharma;
	
	@FindBy(xpath = "//*[@id='store-search-result']/tbody/tr[1]/td[4]/a[1]")
	private WebElement _seestoredetails;
	
	@FindBy(xpath = "//*[@id='store-button-makemystore']/div/a")
	private WebElement _MakemystoreAtSeestore;
	
	public void clickFindAStore() {
		_FindAStore.click();
	}
	public void clicksearchbutton(){
		_searchbutton.click();
	}
	
	public void enterZipCode(String zip){
		_enterzipcode.sendKeys(zip);//entering in FAS page
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
	public void enterstreetname(String street){
		_StreetAddress.sendKeys(street);
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
	waitFor(_selectclickstore);
	_selectclickstore.click();
	String Add=_selectclickstore.getText();
	System.out.println(Add);
	}
	public void clickOnusestore()
	{
	waitFor(_clickusestore);
	_clickusestore.click();
	}
	public void enterzip(String zip1){
		_zipcodebox.sendKeys(zip1);//entering in popup
	}
	public String SelectAddressSavings(String Add){
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
	
	public void clickmap(){
		waitFor(_maps);
		_maps.click();
	}
	public void clickdriving(){
		waitFor(_drivingdirection);
		_drivingdirection.click();
	}
	public void enterlocation(String start){
		_fromlocation.sendKeys(start);
	}
	public void clicksearchlocation(){
		_searchdirection.click();
	}
	
	public boolean isIncorrectZipcode(){
		waitFor(_errormessage);
		boolean IncorrectZipCode = _errormessage.isDisplayed();
		//log.info("ZipCode Incorrect Text Status : "+IncorrectZipCode);
		return(IncorrectZipCode);
	}
	
	public boolean isIncorrectCityStreet(){
		waitFor(_errormessage1);
		boolean IncorrectZipCode = _errormessage1.isDisplayed();
		//log.info("ZipCode Incorrect Text Status : "+IncorrectZipCode);
		return(IncorrectZipCode);
	}
	public int page(int p){
		String a=_pagenumber.getText();
		p=Integer.parseInt(a);
		return p;
	}
	public void clickprevious(){
		_Previous.click();
	}
	public void clicknext(){
		_Next.click();
	}
	public void clickOnMyStoreUnderMyTools() throws InterruptedException, IOException
	{
			Thread.sleep(10000);
			_driver.navigate().to(properties.getPropValue("testURL")+"stores/view-store.html");
		  
	}
	public void clickshow25(){
		waitFor(_show25);
		_show25.click();
	}
	public void clickshow50(){
		waitFor(_show50);
		_show50.click();
	}
	
	public void clickchangemystore(){
		waitFor(_changemystore);
		_changemystore.click();
	}
	public void clickprint(){
		waitFor(_printlink);
		_printlink.click();
	}
	
	public void enterZippharma(String zip1){
		_enterzippharma.sendKeys(zip1);//entering in pharmacy page
	}
	
	public void enterCitypharma(String city1){
		_entercitypharma.sendKeys(city1);
	}
	public void selectStatepharma(String state1){
		_selectstatepharma.sendKeys(state1);
	}
	public void clicksearchpharmacy(){
		waitFor(_clicksearchpharma);
		_clicksearchpharma.click();
	}
	
	public void clickseestoredetails(){
		waitFor(_seestoredetails);
		_seestoredetails.click();
	}
	public void clickmakemystoreAtseestore(){
		waitFor(_MakemystoreAtSeestore);
		_MakemystoreAtSeestore.click();
	}
}

