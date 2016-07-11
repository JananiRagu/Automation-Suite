package com.test.regression.cub.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
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

	
	public void clickOnCouponsInMyToolsHomePage() throws InterruptedException{
		
		Thread.sleep(5000);
		_MyToolsLink.click();
		waitFor(_Coupons);
		_Coupons.click();
	    
	}
	
	public void addNthCoupon(WebDriver driver, String couponNo){
		
		String temp1 = "//div[@class='coupon-list']/div[";
		String temp2 = "]/div/div/div[2]/button[text()='+ Add Item']";
		
		String wantedAddItemButton = temp1+couponNo+temp2;
		
		driver.findElement(By.xpath(wantedAddItemButton)).click();
				
	}
	
	public String getNthCouponName(WebDriver driver, String couponNo){
		
		
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
}