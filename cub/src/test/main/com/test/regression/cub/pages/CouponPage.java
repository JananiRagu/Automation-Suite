package com.test.regression.cub.pages;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.collect.Ordering;
import com.test.regression.cub.utils.Constant;
import com.test.regression.cub.utils.Logg;
import com.test.regression.cub.utils.SuiteBase;

public class CouponPage extends SuiteBase{
	
	WebDriver _driver;
	
	Logger log = Logg.createLogger();
	
	public CouponPage(WebDriver driver) {
		super();
		_driver=driver;
		PageFactory.initElements(_driver, this);
	}



	
	@FindAll({@FindBy(xpath = "//button[text()='+ Add Item']")})
	private List<WebElement> _addItemButton;
	
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
	
	public void clickOnCouponsInMyToolsHomePage(WebDriver driver) throws InterruptedException{
		
		/*Thread.sleep(6000);
		_MyToolsLink.click();
		
		Thread.sleep(5000);
		_Coupons.click();*/
		
		driver.navigate().to(Constant.URL+"savings/coupons.html");
		log.info("Clicked on Coupons in Home page");
	    
	}
	
	public boolean chkIfFlipp(WebDriver driver, String wantedCouponNo){
		System.out.println("Inside chkIfFlipp method");
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
		
		System.out.println("Inside addNthFlippCoupon method");
		
		System.out.println("Inside addNthFlippCoupon method");
		String temp1 = "//div[@class='coupon-list']/div[";
		String temp2 = "]/div/div/div[3]/button[text()='+ Add Item']";
		
		String wantedAddItemButton = temp1+couponNo+temp2;
		log.info("Trying to Add this coupon" + wantedAddItemButton);
		Thread.sleep(5000);
		driver.findElement(By.xpath(wantedAddItemButton)).click();
		log.info("Added this coupon successfully : " + wantedAddItemButton);	
	}
	
	public void addNthInmarCoupon(WebDriver driver, String couponNo) throws InterruptedException{
		System.out.println("Inside addNthInmarCoupon method");
		String temp1 = "//div[@class='coupon-list']/div[";
		String temp2 = "]/div/div/div[2]/button[text()='+ Add Item']";
		
		String wantedAddItemButton = temp1+couponNo+temp2;
		System.out.println("Trying to Add this coupon" + wantedAddItemButton);
		Thread.sleep(5000);
		driver.findElement(By.xpath(wantedAddItemButton)).click();
		log.info("Added this coupon successfully : " + wantedAddItemButton);		
	}

	public String getNthFlippCouponName(WebDriver driver, String couponNo){
		
		System.out.println("Inside getNthFlippCouponName method");
		String temp1 = "//div[@class='coupon-list']/div[";
		String temp2 = "]/div/div/div[2]/div[2]/h3/a";
		
		String wantedCouponNameXpath = temp1+couponNo+temp2;
		
		WebElement wantedCouponNameElement = driver.findElement(By.xpath(wantedCouponNameXpath));
		
		String wantedCouponName = wantedCouponNameElement.getText();
		log.info("Coupon name in Coupons page : " + wantedCouponName);
		return wantedCouponName;
		
	}
	
	public String getNthInmarCouponName(WebDriver driver, String couponNo){
		
		System.out.println("Inside getNthInmarCouponName method");
		String temp1 = "//div[@class='coupon-list']/div[";
		String temp2 = "]/div/div/div[1]/div[2]/h3/a";
		
		String wantedCouponNameXpath = temp1+couponNo+temp2;
		
		WebElement wantedCouponNameElement = driver.findElement(By.xpath(wantedCouponNameXpath));
		
		String wantedCouponName = wantedCouponNameElement.getText();
		log.info("Coupon name in Coupons page : " + wantedCouponName);
		return wantedCouponName;
		
	}
	
	public void scrollPageDown(WebDriver driver) throws InterruptedException{
		
		/*//JavascriptExecutor jsx = (JavascriptExecutor)driver;
		//jsx.executeScript("window.scrollBy(0,450)", "");
		System.out.println("Inside scrollPageDown method..");
		
		Actions action = new Actions(driver);
		
		for(int count=0;count<4;count++){
			Thread.sleep(5000);
			action.sendKeys(Keys.PAGE_DOWN);
		}
		Thread.sleep(5000);*/
		
			JavascriptExecutor js = (JavascriptExecutor)driver;
		   boolean reachedbottom = Boolean.parseBoolean(js.executeScript("return $(document).height() == ($(window).height() + $(window).scrollTop());").toString());

		    while (!reachedbottom) {
		        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,800)", "");
		        try {
		            reachedbottom=Boolean.parseBoolean(js.executeScript("return $(document).height() == ($(window).height() + $(window).scrollTop());").toString());
		            //WebElement element = driver.findElement(By.xpath("//*[@id='http://static3.jassets.com/p/The-Indian-Garage-Co.-Checks-Red-Casual-Shirt-2889-679124-1-catalog.jpg']/img"));
		            Wait<WebDriver> wait_element = new WebDriverWait(driver, 5);
		            wait_element.until(ExpectedConditions.elementToBeClickable(_moreCouponsButton));
		            _moreCouponsButton.click();
		            System.out.println("!!!!!!!!!!!!!!At Last Get Success!!!!!!!!!!!!!!!!");
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
		System.out.println("Inside loadCompleteCouponsPage method");
		//boolean moreCouponsButtonPresence = _moreCouponsButton.isDisplayed();
		
		scrollPageDown(driver);
		
		scrollPageDown(driver);
		
		scrollPageDown(driver);
		do{
			
			clickMoreCouponsButton();
			Thread.sleep(9000);
			System.out.println("more coupons presence : " + _moreCouponsButton.isDisplayed());
		}while(_moreCouponsButton.isDisplayed());
		
		int totalNoOfCoupons = _allCoupons.size();
		return totalNoOfCoupons;
		
		
	}
	
	public int noOfAddItemButtons() throws InterruptedException{
		Thread.sleep(5000);
		int totalNoOfCoupons = _addItemButton.size();
		return totalNoOfCoupons;
	}
	
	public void enterCardlessId(String cardlessIdFirst7, String cardlessIdLast4) throws InterruptedException{
		System.out.println("Inside enterCardlessId method");
		
		waitFor(_first7DigitsCardlessId);
		_first7DigitsCardlessId.clear();
		_first7DigitsCardlessId.sendKeys(cardlessIdFirst7);
		
		waitFor(_last4DigitsCardlessId);
		_last4DigitsCardlessId.clear();
		_last4DigitsCardlessId.sendKeys(cardlessIdLast4);
		
		/*Thread.sleep(5000);
		waitFor(_continueButtonInCardlessIdPopUp);
		_continueButtonInCardlessIdPopUp.click();*/
		
		log.info("Entered Cardless id");
		Thread.sleep(5000);
	}
	
	public void clickContinueInAddCardlessIdPopup() throws InterruptedException{
		
		System.out.println("Inside clickContinueInAddCardlessIdPopup method");
		//waitFor(_continueAfterAddingCardlessId);
		Thread.sleep(5000);
		_continueButtonInCardlessIdPopUp.click();
		Thread.sleep(5000);
		log.info("Clicked on Continue in Add Cardless id popup");
	}
	
	public void clickContinueAfterAddingCardlessIdCongratsPopup() throws InterruptedException{
		
		System.out.println("Inside clickContinueAfterAddingCardlessIdCongratsPopup method");
		//waitFor(_continueAfterAddingCardlessId);
		Thread.sleep(5000);
		_continueAfterAddingCardlessId.click();
		
		log.info("Clicked on Continue in Congrats popup");
	}
	
	public void clickNotNowInCardlessIdPopup() throws InterruptedException{
		
		System.out.println("Inside clickNotNowInCardlessIdPopup method");
		Thread.sleep(5000);
		_notNowInAddCardlessIdPopup.click();
		
		log.info("Clicked on Not Now in Add Cardless id popup");
	}
	
	public int totalNoOfCoupons(){
		
		System.out.println("Inside totalNoOfCoupons method");
		String couponCountMsg = _noOfCouponsMsgInCouponsPage.getText();
		
		List<String> temp = Arrays.asList(couponCountMsg.split("\\s"));
		
		String countTemp = temp.get(0);
		int count = Integer.parseInt(countTemp);
		
		System.out.println("Coupon Count : "+ count);
		return count;	
		
	}
	
	public void addListOfCoupons(List<String> otherWantedCoupons) throws InterruptedException{
		
		for(String wantedCouponNumber : otherWantedCoupons){
			
			// Check if wantedCouponNumber is Flipp or Inmar
				
			boolean isCouponFlipp = chkIfFlipp(_driver, wantedCouponNumber);
			System.out.println("isCouponFlipp value is "+ isCouponFlipp);
				
			
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
		
		boolean isFirstCouponFlipp = chkIfFlipp(_driver, firstWantedCoupon);
		System.out.println("isCouponFlipp value is "+ isFirstCouponFlipp);
		
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

	public void addSingleCouponWithNotNowInCardlessIdPopup(String firstWantedCoupon, String cardlessId7,
			String cardlessId4) throws InterruptedException {
		// TODO Auto-generated method stub
		boolean isFirstCouponFlipp = chkIfFlipp(_driver, firstWantedCoupon);
		System.out.println("isCouponFlipp value is "+ isFirstCouponFlipp);
		
		String firstAddedCouponName;
		
		if(isFirstCouponFlipp){
				log.info("Trying to add Flipp Coupon");
			addNthFlippCoupon(_driver, firstWantedCoupon);
				log.info("Added wanted Flipp coupon");
			enterCardlessId(cardlessId7, cardlessId4);
				log.info("Entered Cardless Id Details");
			clickNotNowInCardlessIdPopup();
	
			firstAddedCouponName = getNthFlippCouponName(_driver, firstWantedCoupon);
				log.info("Added Coupon Name : " + firstAddedCouponName);
		}
		else{
				log.info("Trying to add Inmar Coupon");
			addNthInmarCoupon(_driver, firstWantedCoupon);
				log.info("Added wanted Inmar Coupon");
			enterCardlessId(cardlessId7, cardlessId4);
				log.info("Entered Cardless Id Details");
			clickNotNowInCardlessIdPopup();
		
			firstAddedCouponName = getNthInmarCouponName(_driver, firstWantedCoupon);
				log.info("Added Coupon Name : " + firstAddedCouponName);
		}
		
	}
	
	public String addSingleCoupon(WebDriver driver, String wantedCouponNumber) throws InterruptedException{
	
		boolean isCouponFlipp = chkIfFlipp(driver, wantedCouponNumber);
		
		System.out.println("isCouponFlipp value : "+ isCouponFlipp);
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

	public List<String> getCouponNamesOnDisplayOrder(WebDriver driver) throws InterruptedException {
		
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
			/*WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(wantedCoupon)));*/
			
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOf(wantedCouponName));
			
			String displayName = wantedCouponName.getText();
			System.out.println(displayName);
			couponDisplayOrder.add(displayName);
			
		}
		
		System.out.println("Size of the list Now : "+ couponDisplayOrder.size());
		
		return couponDisplayOrder;
	}

	public boolean chkAlphabeticalOrder(List<String> couponDisplayOrder) {
		
		System.out.println("Inside chkAlphabeticalOrder method...");
		/*String previousFirstLetter = "";
		String currentFirstLetter;
		
		for (final String current : couponDisplayOrder){
			currentFirstLetter = String.valueOf(current.charAt(0));
			if(currentFirstLetter.compareTo(previousFirstLetter) < 0 )
		
				return false;
			previousFirstLetter = currentFirstLetter;
		}
		return true;*/
		
		List<String> couponExpiryDateOrderFirstLetters = new LinkedList<String>();
		String currentFirstLetter;
		for (final String current : couponDisplayOrder){
			currentFirstLetter = String.valueOf(current.charAt(0));
			System.out.println(currentFirstLetter);
			couponExpiryDateOrderFirstLetters.add(currentFirstLetter);
			System.out.println("Added");
		}
		for (final String cur : couponDisplayOrder){
			System.out.println(cur);
		}
		
	boolean sorted=Ordering.natural().isOrdered(couponExpiryDateOrderFirstLetters);
	System.out.println("Final Return Value of chkAlphabeticalOrder method :: "+ sorted);
	return sorted;
	}
	
	public void selectValueFromCouponSortChkBox(String value) throws InterruptedException{
		Select couponSortValues = new Select(_couponSortChkBox);
		couponSortValues.selectByVisibleText(value);
		System.out.println("Coupons are now sorted with " + value + " ............................................................");
		Thread.sleep(5000);
	}

	public List<String> getEndDatesOnExpiryDate(WebDriver driver) throws InterruptedException {
		String temp1 = "//div[@class='coupon-list']/div[";
		String temp2 = "]/div/div/div[2]/div[2]/h3/a";
		
		int couponSize = totalNoOfCoupons();
		Thread.sleep(5000);
		
		List<String> couponDisplayOrderByExpirationDate = new LinkedList<String>();
		
		for(int couponNum=1; couponNum<couponSize ; couponNum=+10){
		String wantedCouponNameXpath = temp1+couponNum+temp2;
		Thread.sleep(5000);
		WebElement wantedCouponNameElement = driver.findElement(By.xpath(wantedCouponNameXpath));
		
		String wantedCouponName = wantedCouponNameElement.getText();
		wantedCouponNameElement.click();
		
		String fullExpirationText = _expirationDate.getText();
		
		List<String> splitedExpirationDates = Arrays.asList(fullExpirationText.split("\\s"));
		String endDate = splitedExpirationDates.get(3);
		
		couponDisplayOrderByExpirationDate.add(endDate);
		driver.navigate().back();
		}
		
		System.out.println("Size of the list Now : "+ couponDisplayOrderByExpirationDate.size());
		
		return couponDisplayOrderByExpirationDate;
		
	}

	public boolean chkExpiryDateOrder(List<String> couponExpiryDateOrder) {
		String previous = "";
		
		for (final String current : couponExpiryDateOrder){
			
			if(current.compareTo(previous) < 0 )
				return false;
			previous = current;
		}
		return true;
	}

	public boolean compare2lists(List<String> couponItemDisplayOrder, List<String> couponExpiryDateOrder) {
	
		boolean result = couponItemDisplayOrder.equals(couponExpiryDateOrder);
		return result;
	}
	
	public void clcikOnTopButton(){
		waitFor(_topButton);
		_topButton.click();
	}
	
	public int couponCount() throws InterruptedException{
		Thread.sleep(5000);
		int returnValue = _allCoupons.size();
		
		return returnValue;
		
	}
	
	
	
	
}