package com.test.regression.farmfresh.pages;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.google.common.collect.Ordering;
import com.test.regression.farmfresh.utils.Constant;
import com.test.regression.farmfresh.utils.Logg;
import com.test.regression.farmfresh.utils.ReadPropertiesFile;
import com.test.regression.farmfresh.utils.SuiteBase;

public class CouponPage extends SuiteBase{
	
	WebDriver _driver;
	
	Logger log = Logg.createLogger();
	
	ReadPropertiesFile properties = new ReadPropertiesFile();
	
	public CouponPage(WebDriver driver) {
		super();
		_driver=driver;
		PageFactory.initElements(_driver, this);
	}



	
	@FindAll({@FindBy(xpath = "//button[text()='+ Add Item']")})
	private List<WebElement> _addItemButton;
	
	@FindBy(xpath = "//button[text()='+ Add Item']")
	private WebElement _addItemButtonCouponDetail;
	
	@FindAll({@FindBy(xpath = "//div[@class='coupon-list']/div")})
	private List<WebElement> _allCoupons;
	
	@FindBy(xpath = "//button[@class='button tiny more-coupons-button']")
	private WebElement _moreCouponsButton;
	
	@FindBy(xpath = "//p[@class='availability']")
	private WebElement _noOfCouponsMsgInCouponsPage;
	
	@FindBy(id = "toolsMenu")
	private WebElement _MyToolsLink;
	
	@FindBy(xpath = "//a[text()='Coupons']")
	private WebElement _Coupons;
	
	@FindBy(xpath = "//input[@class='ss-cardless1-input ss-combined-input']")
	private WebElement _first7DigitsCardlessId;

	@FindBy(xpath = "//input[@class='ss-combined-input ss-cardless2-input']")
	private WebElement _last4DigitsCardlessId;
	
	
	@FindBy(xpath = "//div[@class='ss-popup-anchor']/input")
	private WebElement _rewardsNumber;
	
	@FindBy(xpath = "//button[text()='Continue']")
	private WebElement _continueButtonInCardlessIdPopUp;
	
	@FindBy(xpath = "//button[text()='Continue']")
	private WebElement _continueAfterAddingCardlessId;
	
	@FindBy(xpath = "//*[@id='ss-create-rewards-form']/a")
	private WebElement _notNowInAddCardlessIdPopup;
	
	@FindBy(id = "coupon-sort")
	private WebElement _couponSortChkBox;
	
	@FindBy(xpath = "//div[@class = 'coupon-expiration-container']/h5")
	private WebElement _expirationDate;

	@FindBy(xpath = "//*[@id='panel2-1']/a")
	private WebElement _topButton;
	
	@FindBy(xpath = "//a[text()='Coupon Details']")
	private WebElement _couponDetailsLink;
	
	@FindBy(xpath = "//div[@class='coupon-details-tab-container']/ul/li[1]/div")
	private WebElement _couponDetailsLinkTriangle;
	
	@FindBy(xpath = "//a[text()='Terms & Conditions']")
	private WebElement _tNcLink;
	
	@FindBy(xpath = "//div[@class='coupon-details-tab-container']/ul/li[2]/div")
	private WebElement _tNcLinkTriangle;
	
	@FindBy(xpath = "//*[@id='content-primary']/div/div/div/div[1]/div[2]/div/div[2]/p[3]")
	private WebElement _couponNameFromCouponDetailsPage;
	
	@FindBy(xpath = "//*[@id='coupon-category']")
	private WebElement _categoryDropdownInCouponsPage;
	
	@FindBy(xpath = "//input[@class='coupon-search']")
	private WebElement _searchBoxInCouponsPage;
	
	public void clickOnCouponsInMyToolsHomePage(WebDriver driver) throws InterruptedException, IOException{
		
		log.info("...Inside clickOnCouponsInMyToolsHomePage method...");
		
		driver.navigate().to(properties.getPropValue("testURL")+"savings/coupons.html");
		log.info("Clicked on Coupons in Home page");
	    
	}
	
	public boolean chkIfFlipp(WebDriver driver, String wantedCouponNo){
		
		log.info("...Inside chkIfFlipp method...");
		
		String temp1 = "//div[@class='coupon-list']/div[";
		String temp2 = "]/div/div/div[1]";
		
		String wantedAddItemButton = temp1+wantedCouponNo+temp2;
		
		String couponClassName = driver.findElement(By.xpath(wantedAddItemButton)).getAttribute("class");
		
		if(couponClassName.equalsIgnoreCase("coupon-badge")){
			log.info("Coupon is Flippp!");
			return true;
		}
		else{
			log.info("Coupon is Inmar!");
			return false;
		}
	}
	
	public void addNthFlippCoupon(WebDriver driver, String couponNo) throws InterruptedException{
		
				
		log.info("...Inside addNthFlippCoupon method...");
		
		String temp1 = "//div[@class='coupon-list']/div[";
		String temp2 = "]/div/div/div[3]/button[text()='+ Add Item']";
		
		String wantedAddItemButton = temp1+couponNo+temp2;
		log.info("Trying to Add this coupon" + wantedAddItemButton);
		
		Thread.sleep(5000);
		
		driver.findElement(By.xpath(wantedAddItemButton)).click();
		log.info("Added this coupon successfully : " + wantedAddItemButton);	
	}
	
	public void addNthInmarCoupon(WebDriver driver, String couponNo) throws InterruptedException{
		
		log.info("...Inside addNthInmarCoupon method...");
		
		String temp1 = "//div[@class='coupon-list']/div[";
		String temp2 = "]/div/div/div[2]/button[text()='+ Add Item']";
		
		String wantedAddItemButton = temp1+couponNo+temp2;
		log.info("Trying to Add this coupon" + wantedAddItemButton);
		
		Thread.sleep(5000);
		
		driver.findElement(By.xpath(wantedAddItemButton)).click();
		log.info("Added this coupon successfully : " + wantedAddItemButton);		
	}

	public String getNthFlippCouponName(WebDriver driver, String couponNo){
		
		log.info("...Inside getNthFlippCouponName method...");
		
		String temp1 = "//div[@class='coupon-list']/div[";
		String temp2 = "]/div/div/div[2]/div[2]/h3/a";
		
		String wantedCouponNameXpath = temp1+couponNo+temp2;
		
		WebElement wantedCouponNameElement = driver.findElement(By.xpath(wantedCouponNameXpath));
		
		String wantedCouponName = wantedCouponNameElement.getText();
		log.info("Coupon name in Coupons page which i am trying to add: " + wantedCouponName);
		
		return wantedCouponName;
		
	}
	
	public String getNthInmarCouponName(WebDriver driver, String couponNo){
		
		log.info("...Inside getNthInmarCouponName method...");
		
		String temp1 = "//div[@class='coupon-list']/div[";
		String temp2 = "]/div/div/div[1]/div[2]/h3/a";
		
		String wantedCouponNameXpath = temp1+couponNo+temp2;
		
		WebElement wantedCouponNameElement = driver.findElement(By.xpath(wantedCouponNameXpath));
		
		String wantedCouponName = wantedCouponNameElement.getText();
		log.info("Coupon name in Coupons page which i am trying to add: " + wantedCouponName);
		
		return wantedCouponName;
		
	}
	
	public void scrollPageDown(WebDriver driver) throws InterruptedException{
		
		log.info("...Inside scrollPageDown method...");
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		   boolean reachedbottom = Boolean.parseBoolean(js.executeScript("return $(document).height() == ($(window).height() + $(window).scrollTop());").toString());

		   while (!reachedbottom) {
		        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,800)", "");
		        try {
		            reachedbottom=Boolean.parseBoolean(js.executeScript("return $(document).height() == ($(window).height() + $(window).scrollTop());").toString());
		            
		            Wait<WebDriver> wait_element = new WebDriverWait(driver, 5);
		            
		            wait_element.until(ExpectedConditions.elementToBeClickable(_moreCouponsButton));
		            
		            _moreCouponsButton.click();
		            log.info("!!!!!!!!!!!!!!At Last Get Success!!!!!!!!!!!!!!!!");
		            
		            break;
		        } catch (Exception ex) {
		            
		            log.info(ex.getMessage());
		        }
		    }
		
	}
	
	public void clickMoreCouponsButton(){
		
		waitFor(_moreCouponsButton);
		_moreCouponsButton.click();
	}
	
	public int loadCompleteCouponsPage(WebDriver driver) throws InterruptedException{
		
		log.info("...Inside loadCompleteCouponsPage method...");
		
		
		scrollPageDown(driver);
		
		scrollPageDown(driver);
		
		//scrollPageDown(driver);
		
		do{
			
			clickMoreCouponsButton();
			Thread.sleep(5000);
			
			scrollPageDown(driver);
			
			scrollPageDown(driver);
			
		}while(_allCoupons.size() < totalNoOfCoupons());
		
		Thread.sleep(5000);
		int totalNoOfCoupons = _allCoupons.size();
		return totalNoOfCoupons;
		
		
	}
	
	public int noOfAddItemButtons() throws InterruptedException{
		
		log.info("...Inside noOfAddItemButtons method...");
		
		Thread.sleep(5000);
		int totalNoOfCoupons = _addItemButton.size();
		
		return totalNoOfCoupons;
	}
	
	public void enterCardlessId(String cardlessIdFirst7, String cardlessIdLast4) throws InterruptedException{
		
		log.info("...Inside enterCardlessId method...");
		
		waitFor(_first7DigitsCardlessId);
		_first7DigitsCardlessId.clear();
		_first7DigitsCardlessId.sendKeys(cardlessIdFirst7);
		
		waitFor(_last4DigitsCardlessId);
		_last4DigitsCardlessId.clear();
		_last4DigitsCardlessId.sendKeys(cardlessIdLast4);
		
		
		log.info("Entered Cardless id");
		Thread.sleep(5000);
	}
	
	public void clickContinueInAddCardlessIdPopup() throws InterruptedException{
		
		log.info("...Inside clickContinueInAddCardlessIdPopup method...");
		
		Thread.sleep(5000);
		_continueButtonInCardlessIdPopUp.click();
		
		Thread.sleep(5000);
		log.info("Clicked on Continue in Add Cardless id popup");
	}
	
	public void clickContinueAfterAddingCardlessIdCongratsPopup() throws InterruptedException{
		
		log.info("...Inside clickContinueAfterAddingCardlessIdCongratsPopup method...");
	
		Thread.sleep(5000);
		_continueAfterAddingCardlessId.click();
		
		log.info("Clicked on Continue in Congrats popup");
	}
	
	public void clickNotNowInCardlessIdPopup() throws InterruptedException{
		
		log.info("...Inside clickNotNowInCardlessIdPopup method...");
		Thread.sleep(5000);
		_notNowInAddCardlessIdPopup.click();
		
		log.info("Clicked on Not Now in Add Cardless id popup");
	}
	
	public int totalNoOfCoupons(){
		
		log.info("...Inside totalNoOfCoupons method...");
		String couponCountMsg = _noOfCouponsMsgInCouponsPage.getText();
		
		List<String> temp = Arrays.asList(couponCountMsg.split("\\s"));
		
		String countTemp = temp.get(0);
		int count = Integer.parseInt(countTemp);
		
		log.info("Coupon Count : "+ count);
		return count;	
		
	}
	
		public boolean getSelectedCategory(String SelectedCategory){
		
		log.info("...Inside getSelectedCategory method...");
		String couponCountMsg = _noOfCouponsMsgInCouponsPage.getText();
		
		if(couponCountMsg.contains(SelectedCategory))
			return true;
		else
			return false;
			
		
	}
	
	public void addListOfCoupons(List<String> otherWantedCoupons) throws InterruptedException{
		
		log.info("...Inside addListOfCoupons method...");
		
		for(String wantedCouponNumber : otherWantedCoupons){
			
			// Check if wantedCouponNumber is Flipp or Inmar
				
			boolean isCouponFlipp = chkIfFlipp(_driver, wantedCouponNumber);
			log.info("isCouponFlipp value is "+ isCouponFlipp);
				
			
			String addedCouponName;
			if(isCouponFlipp){
					log.info("Trying to add Flipp Coupon");
				addNthFlippCoupon(_driver, wantedCouponNumber);
					log.info("Added wanted Flipp coupon");
		
				addedCouponName = getNthFlippCouponName(_driver, wantedCouponNumber);
					log.info("Added Coupon Name : " + addedCouponName);
			}
			else{
					log.info("Trying to add Inmar Coupon");
				addNthInmarCoupon(_driver, wantedCouponNumber);
					log.info("Added wanted Inmar Coupon");
			
				addedCouponName = getNthInmarCouponName(_driver, wantedCouponNumber);
					log.info("Added Coupon Name : " + addedCouponName);
			}
		}
	}
	
	public void addSingleCouponWithCardlessId(String firstWantedCoupon, String cardlessId7, String cardlessId4) throws InterruptedException{
		
		log.info("...Inside addSingleCouponWithCardlessId method...");
		
		boolean isFirstCouponFlipp = chkIfFlipp(_driver, firstWantedCoupon);
		log.info("isCouponFlipp value is "+ isFirstCouponFlipp);
		
		String firstAddedCouponName;
		
		if(isFirstCouponFlipp){
				log.info("Trying to add Flipp Coupon");
			addNthFlippCoupon(_driver, firstWantedCoupon);
				log.info("Added wanted Flipp coupon");
			enterCardlessId(cardlessId7, cardlessId4);
				log.info("Entered Cardless Id Details");
			clickContinueInAddCardlessIdPopup();
			clickContinueAfterAddingCardlessIdCongratsPopup();
	
			firstAddedCouponName = getNthFlippCouponName(_driver, firstWantedCoupon);
				log.info("Added Coupon Name : " + firstAddedCouponName);
		}
		else{
				log.info("Trying to add Inmar Coupon");
			addNthInmarCoupon(_driver, firstWantedCoupon);
				log.info("Added wanted Inmar Coupon");
			enterCardlessId(cardlessId7, cardlessId4);
				log.info("Entered Cardless Id Details");
			clickContinueInAddCardlessIdPopup();
			clickContinueAfterAddingCardlessIdCongratsPopup();
		
			firstAddedCouponName = getNthInmarCouponName(_driver, firstWantedCoupon);
				log.info("Added Coupon Name : " + firstAddedCouponName);
		}
	}

	public void addSingleCouponWithNotNowInCardlessIdPopup(String firstWantedCoupon, String rewardsNum) throws InterruptedException {
		
		log.info("...Inside addSingleCouponWithNotNowInCardlessIdPopup method...");
		
		boolean isFirstCouponFlipp = chkIfFlipp(_driver, firstWantedCoupon);
		log.info("isCouponFlipp value is "+ isFirstCouponFlipp);
		
		String firstAddedCouponName;
		
		if(isFirstCouponFlipp){
				log.info("Trying to add Flipp Coupon");
			addNthFlippCoupon(_driver, firstWantedCoupon);
				log.info("Added wanted Flipp coupon");
			enterRewardsNumber(rewardsNum);
				log.info("Entered Cardless Id Details");
			clickNotNowInCardlessIdPopup();
	
			firstAddedCouponName = getNthFlippCouponName(_driver, firstWantedCoupon);
				log.info("Added Coupon Name : " + firstAddedCouponName);
		}
		else{
				log.info("Trying to add Inmar Coupon");
			addNthInmarCoupon(_driver, firstWantedCoupon);
				log.info("Added wanted Inmar Coupon");
				enterRewardsNumber(rewardsNum);
				log.info("Entered Cardless Id Details");
			clickNotNowInCardlessIdPopup();
		
			firstAddedCouponName = getNthInmarCouponName(_driver, firstWantedCoupon);
				log.info("Added Coupon Name : " + firstAddedCouponName);
		}
		
	}
	
	public String addSingleCoupon(WebDriver driver, String wantedCouponNumber) throws InterruptedException{
	
		log.info("...Inside addSingleCoupon method...");
		
		boolean isCouponFlipp = chkIfFlipp(driver, wantedCouponNumber);
		
		log.info("isCouponFlipp value : "+ isCouponFlipp);
		String addedCouponName = null;
		if(isCouponFlipp){
			
			addNthFlippCoupon(driver, wantedCouponNumber);
				log.info("Added nth coupon");

			
			addedCouponName  = getNthFlippCouponName(driver, wantedCouponNumber);
			}
			
			else{
				addNthInmarCoupon(_driver, wantedCouponNumber);
				log.info("Added nth coupon");

			
			addedCouponName = getNthInmarCouponName(driver, wantedCouponNumber);
			}	
		
		return addedCouponName;
	}
	
	public void navigateToCouponDetailPage(WebDriver driver, String  wantedCouponNumber) throws InterruptedException{
		
		log.info("...Inside navigateToCouponDetailPage method...");
		
		Thread.sleep(5000);
		String wantedCn;
		String temp1 = "//div[@class='coupon-list']/div[";
		String temp2 = "]/div/div/div[1]/div[2]/h3/a";
		String temp3 = "]/div/div/div[2]/div[2]/h3/a";
		
		boolean isCouponFlipp = chkIfFlipp(driver, wantedCouponNumber);
		if(isCouponFlipp)
			wantedCn = temp1+wantedCouponNumber+temp3;
		else
			wantedCn = temp1+wantedCouponNumber+temp2;
		WebElement wantedCoupon = driver.findElement(By.xpath(wantedCn));
		waitFor(wantedCoupon);
		wantedCoupon.click();
		log.info("Clicked on "+wantedCoupon+" in Coupons Page");
	}
	
	public void clickOnAddItemInCouponDetailsPage() throws InterruptedException{
		
		log.info("...Inside clickOnAddItemInCouponDetailsPage method...");
		
		Thread.sleep(5000);
		waitFor(_addItemButtonCouponDetail);
		_addItemButtonCouponDetail.click();
		
		log.info("Clicked on Add Item Button in Coupon Details Page");
	}

	public List<String> getCouponNamesOnDisplayOrder(WebDriver driver) throws InterruptedException {
		
		log.info("...Inside getCouponNamesOnDisplayOrder method...");
		
		Thread.sleep(5000);
		String temp1 = "//div[@class='coupon-list']/div[";
		String temp2 = "]/div/div/div[1]/div[2]/p";
		String temp3 = "]/div/div/div[2]/div[2]/p";
		
		
		List<String> couponDisplayOrder = new LinkedList<String>();
		
		int couponSize = totalNoOfCoupons();
		Thread.sleep(5000);
		for(int count=1; count<=couponSize; count++){
			
			String wantedCoupon = temp1+count+temp2;
			String wantedCouponwithExpiryFlag = temp1+count+temp3;
			
			WebElement wantedCouponName = null;
			try{
			wantedCouponName = driver.findElement(By.xpath(wantedCoupon));
			}catch(NoSuchElementException ne)
			{
				log.info("Some coupon is missing");
				wantedCouponName = driver.findElement(By.xpath(wantedCouponwithExpiryFlag));
			}
			
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOf(wantedCouponName));
			
			String displayName = wantedCouponName.getText();
			log.info(displayName);
			couponDisplayOrder.add(displayName);
			
		}
		
		log.info("Size of the list Now : "+ couponDisplayOrder.size());
		
		return couponDisplayOrder;
	}

	public boolean chkAlphabeticalOrder(List<String> couponDisplayOrder) {
		
		log.info("...Inside chkAlphabeticalOrder method...");
		
		List<String> couponExpiryDateOrderFirstLetters = new LinkedList<String>();
		String currentFirstLetter;
		for (final String current : couponDisplayOrder){
			currentFirstLetter = String.valueOf(current.charAt(0));
			log.info(currentFirstLetter);
			couponExpiryDateOrderFirstLetters.add(currentFirstLetter);
			log.info("Added");
		}
		for (final String cur : couponDisplayOrder){
			log.info(cur);
		}
		
		boolean sorted=Ordering.natural().isOrdered(couponExpiryDateOrderFirstLetters);
		log.info("Final Return Value of chkAlphabeticalOrder method :: "+ sorted);
		
	return sorted;
	}
	
	public void selectValueFromCouponSortChkBox(String value) throws InterruptedException{
		
		log.info("...Inside selectValueFromCouponSortChkBox method...");
		
		Select couponSortValues = new Select(_couponSortChkBox);
		couponSortValues.selectByVisibleText(value);
		log.info("Coupons are now sorted with " + value + " ............................................................");
		Thread.sleep(5000);
	}

	public List<String> getEndDatesOnExpiryDate(WebDriver driver) throws InterruptedException {
		
		log.info("...Inside getEndDatesOnExpiryDate method...");
		
		String temp1 = "//div[@class='coupon-list']/div[";
		String temp2 = "]/div/div/div[2]/div[2]/h3/a";
		
		int couponSize = totalNoOfCoupons();
		Thread.sleep(5000);
		
		List<String> couponDisplayOrderByExpirationDate = new LinkedList<String>();
		
		for(int couponNum=1; couponNum<couponSize ; couponNum=+10){
		String wantedCouponNameXpath = temp1+couponNum+temp2;
		Thread.sleep(5000);
		WebElement wantedCouponNameElement = driver.findElement(By.xpath(wantedCouponNameXpath));
		
		wantedCouponNameElement.click();
		
		String fullExpirationText = _expirationDate.getText();
		
		List<String> splitedExpirationDates = Arrays.asList(fullExpirationText.split("\\s"));
		String endDate = splitedExpirationDates.get(3);
		
		couponDisplayOrderByExpirationDate.add(endDate);
		driver.navigate().back();
		}
		
		log.info("Size of the list Now : "+ couponDisplayOrderByExpirationDate.size());
		
		return couponDisplayOrderByExpirationDate;
		
	}

	public boolean chkExpiryDateOrder(List<String> couponExpiryDateOrder) {
		
		log.info("...Inside chkExpiryDateOrder method...");
		
		String previous = "";
		
		for (final String current : couponExpiryDateOrder){
			
			if(current.compareTo(previous) < 0 )
				return false;
			previous = current;
		}
		return true;
	}

	public boolean compare2lists(List<String> couponItemDisplayOrder, List<String> couponExpiryDateOrder) {
		
		log.info("...Inside compare2lists method...");
	
		boolean result = couponItemDisplayOrder.equals(couponExpiryDateOrder);
		return result;
	}
	
	public void clcikOnTopButton(){
		
		log.info("...Inside clcikOnTopButton method...");
		
		waitFor(_topButton);
		_topButton.click();
	}
	
	public int couponCount() throws InterruptedException{
		
		log.info("...Inside couponCount method...");
		
		Thread.sleep(5000);
		int returnValue = _allCoupons.size();
		
		return returnValue;
		
	}
	
	public boolean clickCouponDetailsLink(){
		
		log.info("...Inside clickCouponDetailsLink method...");
		
		waitFor(_couponDetailsLink);
		_couponDetailsLink.click();
		
		String temp = _couponDetailsLinkTriangle.getAttribute("class");
		
		if(temp.equalsIgnoreCase("triangle"))
			return true;
		else
			return false;
	}
	
	public boolean clickTermsNConditionsLink(){
		
		log.info("...Inside clickTermsNConditionsLink method...");
		
		waitFor(_tNcLink);
		_tNcLink.click();
		
		String temp = _tNcLinkTriangle.getAttribute("class");
		
		if(temp.equalsIgnoreCase("triangle"))
			return true;
		else
			return false;
	}
	
	public String getCouponNameFromCouponDetailsPage(){
		
		log.info("...Inside getCouponNameFromCouponDetailsPage method...");
		
		waitFor(_couponNameFromCouponDetailsPage);
		String couponName = _couponNameFromCouponDetailsPage.getText();
		
		return couponName;
	}
	
	public void selectCatergory(String categoryToBeSelected) throws InterruptedException{
		
		log.info("...Inside selectCatergory method...");
		
		waitFor(_categoryDropdownInCouponsPage);
		
		Select categoryDrpDown = new Select(_categoryDropdownInCouponsPage);
		categoryDrpDown.selectByVisibleText(categoryToBeSelected);
		
		Thread.sleep(5000);
	}
	
	public void searchForAnItemInCoupons(String searchItem) throws InterruptedException{
		
		log.info("...Inside searchForAnItemInCoupons method...");
		
		waitFor(_searchBoxInCouponsPage);
		
		_searchBoxInCouponsPage.sendKeys(searchItem);
		_searchBoxInCouponsPage.sendKeys(Keys.ENTER);
		
		Thread.sleep(5000);
		
	}

	public String getCouponName(WebDriver driver, String wantedCouponNumber) throws InterruptedException {
		log.info("...Inside getCouponName method...");
		
		boolean isCouponFlipp = chkIfFlipp(driver, wantedCouponNumber);
		
		log.info("isCouponFlipp value : "+ isCouponFlipp);
		String addedCouponName = null;
		
		String temp1 = "//div[@class='coupon-list']/div[";
		String temp2 = "]/div/div/div[2]/div[2]/p"; //for flipp
		String temp3 = "]/div/div/div[1]/div[2]/p"; //for Inmar
		
		if(isCouponFlipp){
			
			String wantedCoupon = temp1+wantedCouponNumber+temp2;
	
			addedCouponName  = driver.findElement(By.xpath(wantedCoupon)).getText();
			
			log.info("Got Flipp Coupon Name");
			}
			
			else{
				String wantedCoupon = temp1+wantedCouponNumber+temp3;
				
				addedCouponName  = driver.findElement(By.xpath(wantedCoupon)).getText();
				
				log.info("Got Inmar Coupon Name");
			}	
		
		return addedCouponName;
		
	}

	public void addSingleCouponWithRewardsNum(String firstWantedCoupon, String rewardsNum) throws InterruptedException {
		
		log.info("...Inside addSingleCouponWithRewardsNum method...");
		
		boolean isFirstCouponFlipp = chkIfFlipp(_driver, firstWantedCoupon);
		log.info("isCouponFlipp value is "+ isFirstCouponFlipp);
		
		String firstAddedCouponName;
		
		if(isFirstCouponFlipp){
				log.info("Trying to add Flipp Coupon");
			addNthFlippCoupon(_driver, firstWantedCoupon);
				log.info("Added wanted Flipp coupon");
			enterRewardsNumber(rewardsNum);
				log.info("Entered Cardless Id Details");
			clickContinueInAddCardlessIdPopup();
			clickContinueAfterAddingCardlessIdCongratsPopup();
	
			firstAddedCouponName = getNthFlippCouponName(_driver, firstWantedCoupon);
				log.info("Added Coupon Name : " + firstAddedCouponName);
		}
		else{
				log.info("Trying to add Inmar Coupon");
			addNthInmarCoupon(_driver, firstWantedCoupon);
				log.info("Added wanted Inmar Coupon");
			enterRewardsNumber(rewardsNum);
				log.info("Entered Cardless Id Details");
			clickContinueInAddCardlessIdPopup();
			clickContinueAfterAddingCardlessIdCongratsPopup();
		
			firstAddedCouponName = getNthInmarCouponName(_driver, firstWantedCoupon);
				log.info("Added Coupon Name : " + firstAddedCouponName);
		}
	}

	private void enterRewardsNumber(String rewardsNum) {
		waitFor(_rewardsNumber);
		_rewardsNumber.sendKeys(rewardsNum);
		
	}
	
	
	
	
}