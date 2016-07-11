package com.test.regression.cub.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.regression.cub.utils.SuiteBase;

public class MyeCouponsPage extends SuiteBase{
	
	WebDriver _driver;
	
	public MyeCouponsPage(WebDriver driver) {
		super();
		_driver=driver;
		PageFactory.initElements(_driver, this);
	}

	@FindBy(id = "toolsMenu")
	private WebElement _MyToolsLink;
	
	@FindBy(xpath = "//*[@id='login-options-sub']/li[4]/a")
	private WebElement _MyECoupons;
	
	@FindAll({@FindBy(xpath = "//div[@id='coupons-outer']/div/div/div/p/strong")})
	private List<WebElement> _myECoupons;
	
	public void clickOnMyeCouponsInMyToolsHomePage() throws InterruptedException{
		Thread.sleep(5000);
		waitFor(_MyToolsLink);
		_MyToolsLink.click();
		_MyECoupons.click();
	    
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
	
	
}
