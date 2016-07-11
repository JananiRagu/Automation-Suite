package com.test.regression.cub.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.regression.cub.utils.SuiteBase;

public class CouponPage extends SuiteBase{
	
	WebDriver _driver;
	
	public CouponPage(WebDriver driver) {
		super();
		_driver=driver;
		PageFactory.initElements(_driver, this);
	}


	@FindBy(xpath = "//div[@class='coupon-list']/div[1]/div/div/div[2]/button[text()='+ Add Item']")
	private WebElement _addItemButton1;
	
	@FindBy(xpath = "//button[@class='button tiny more-coupons-button']")
	private WebElement _moreCouponsButton;
	
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
	
	public void clickOnCouponsInMyToolsHomePage() throws InterruptedException{
		
		Thread.sleep(5000);
		_MyToolsLink.click();
		
		Thread.sleep(5000);
		_Coupons.click();
	    
	}
	
	public boolean chkIfFlipp(WebDriver driver, String wantedCouponNo){
		
		String temp1 = "//div[@class='coupon-list']/div[";
		String temp2 = "]/div/div/div[1]";
		
		String wantedAddItemButton = temp1+wantedCouponNo+temp2;
		
		String couponClassName = driver.findElement(By.xpath(wantedAddItemButton)).getAttribute("class");
		if(couponClassName.equalsIgnoreCase("coupon-badge")){
			System.out.println("Coupon is Flippp!");
			return true;
		}
		else{
			System.out.println("Coupon is Inmar!");
			return false;
		}
	}
	
	public void addNthFlippCoupon(WebDriver driver, String couponNo){
		
		System.out.println("Inside addNthFlippCoupon method");
		String temp1 = "//div[@class='coupon-list']/div[";
		String temp2 = "]/div/div/div[3]/button[text()='+ Add Item']";
		
		String wantedAddItemButton = temp1+couponNo+temp2;
		System.out.println("Trying to Add this coupon" + wantedAddItemButton);
		driver.findElement(By.xpath(wantedAddItemButton)).click();
				
	}
	
	public void addNthInmarCoupon(WebDriver driver, String couponNo) throws InterruptedException{
		System.out.println("Inside addNthInmarCoupon method");
		String temp1 = "//div[@class='coupon-list']/div[";
		String temp2 = "]/div/div/div[2]/button[text()='+ Add Item']";
		
		String wantedAddItemButton = temp1+couponNo+temp2;
		System.out.println("Trying to Add this coupon" + wantedAddItemButton);
		Thread.sleep(5000);
		driver.findElement(By.xpath(wantedAddItemButton)).click();
				
	}

	public String getNthFlippCouponName(WebDriver driver, String couponNo){
		
		System.out.println("Inside getNthFlippCouponName method");
		String temp1 = "//div[@class='coupon-list']/div[";
		String temp2 = "]/div/div/div[2]/div[2]/h3/a";
		
		String wantedCouponNameXpath = temp1+couponNo+temp2;
		
		WebElement wantedCouponNameElement = driver.findElement(By.xpath(wantedCouponNameXpath));
		
		String wantedCouponName = wantedCouponNameElement.getText();
		System.out.println("Coupon name in Coupons page : " + wantedCouponName);
		return wantedCouponName;
		
	}
	
	public String getNthInmarCouponName(WebDriver driver, String couponNo){
		
		System.out.println("Inside getNthInmarCouponName method");
		String temp1 = "//div[@class='coupon-list']/div[";
		String temp2 = "]/div/div/div[1]/div[2]/h3/a";
		
		String wantedCouponNameXpath = temp1+couponNo+temp2;
		
		WebElement wantedCouponNameElement = driver.findElement(By.xpath(wantedCouponNameXpath));
		
		String wantedCouponName = wantedCouponNameElement.getText();
		System.out.println("Coupon name in Coupons page : " + wantedCouponName);
		return wantedCouponName;
		
	}
	
	public void scrollPageDown(WebDriver driver){
		
		JavascriptExecutor jsx = (JavascriptExecutor)driver;
		jsx.executeScript("window.scrollBy(0,450)", "");
		
	}
	
	public void clickMoreCouponsButton(){
		
		waitFor(_moreCouponsButton);
		_moreCouponsButton.click();
	}
	
	public void loadCompleteCouponsPage(){
		
		boolean moreCouponsButtonPresence = _moreCouponsButton.isDisplayed();
		
		while(moreCouponsButtonPresence)
			clickMoreCouponsButton();
		
	}
	
	public void enterCardlessId(String cardlessIdFirst7, String cardlessIdLast4) throws InterruptedException{
		
		waitFor(_first7DigitsCardlessId);
		_first7DigitsCardlessId.clear();
		_first7DigitsCardlessId.sendKeys(cardlessIdFirst7);
		
		waitFor(_last4DigitsCardlessId);
		_last4DigitsCardlessId.clear();
		_last4DigitsCardlessId.sendKeys(cardlessIdLast4);
		
		Thread.sleep(5000);
		waitFor(_continueButtonInCardlessIdPopUp);
		_continueButtonInCardlessIdPopUp.click();
	}
	
	public void clickContinueAfterAddingCardlessIdCongratsPopup() throws InterruptedException{
		waitFor(_continueAfterAddingCardlessId);
		Thread.sleep(5000);
		_continueAfterAddingCardlessId.click();
	}
}