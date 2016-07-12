package com.test.regression.cub.pages;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.regression.cub.utils.Logg;
import com.test.regression.cub.utils.SuiteBase;

public class MyeCouponsPage extends SuiteBase{
	
	WebDriver _driver;
	Logger log = Logg.createLogger();
	
	public MyeCouponsPage(WebDriver driver) {
		super();
		_driver=driver;
		PageFactory.initElements(_driver, this);
	}

	@FindBy(id = "toolsMenu")
	private WebElement _MyToolsLink;
	
	@FindBy(xpath = "//a[text()='My eCoupons']")
	private WebElement _MyECoupons;
	
	@FindAll({@FindBy(xpath = "//div[@id='coupons-outer']/div/div/div/p/strong")})
	private List<WebElement> _myECoupons;
	
	public void clickOnMyeCouponsInMyToolsHomePage() throws InterruptedException{
		Thread.sleep(5000);
		_MyToolsLink.click();
		
		Thread.sleep(5000);
		_MyECoupons.click();
		
		log.info("Clicked on My eCoupons in Home page");
	    
	}
	
	public boolean isCouponPresent(String couponName){
		System.out.println("Inside isCouponPresent method");
		System.out.println(_myECoupons.size());
		int count = 0;
		for(WebElement coupon : _myECoupons){
			System.out.println("Inside isCouponPresent method's for loop");
			String actualCouponAdded = coupon.getText();
			System.out.println("eCoupons page Coupons" + actualCouponAdded);
			if(actualCouponAdded.equalsIgnoreCase(couponName))
				count++;
		}	
		
		System.out.println("Count is " + count);
		if(count>0)
			return true;
		else
			return false;
	}
	
	public int noOfECoupons(){
		int size = _myECoupons.size();
		return size;
	}
	
}
