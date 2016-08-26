package com.test.regression.cub.pages;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.regression.cub.utils.Logg;
import com.test.regression.cub.utils.ReadPropertiesFile;
import com.test.regression.cub.utils.SuiteBase;

public class MyeCouponsPage extends SuiteBase{
	
	WebDriver _driver;
	Logger log = Logg.createLogger();
	
	ReadPropertiesFile properties = new ReadPropertiesFile();
	
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
	
	public void clickOnMyeCouponsInMyToolsHomePage(WebDriver driver) throws InterruptedException, IOException{
		/*Thread.sleep(5000);
		_MyToolsLink.click();
		waitFor(_MyECoupons);
		Thread.sleep(5000);
		_MyECoupons.click();*/
		
		driver.navigate().to(properties.getPropValue("testURL")+"savings/view-coupon-status.html");
		log.info("Clicked on My eCoupons in Home page");
	    
	}
	
	public boolean isCouponPresent(String couponName) throws InterruptedException{
		Thread.sleep(5000);
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
	
	public int noOfECoupons() throws InterruptedException{
		Thread.sleep(7000);
		int size = _myECoupons.size();
		log.info("No. of coupons in eCoupons page is : "+ size);
		return size;
	}
	
}
