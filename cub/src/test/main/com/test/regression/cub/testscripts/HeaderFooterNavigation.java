package com.test.regression.cub.testscripts;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.test.regression.cub.pages.CubHome;
import com.test.regression.cub.utils.Logg;
import com.test.regression.cub.utils.SuiteBase;

public class HeaderFooterNavigation extends SuiteBase{
	CubHome cubHome;
	Logger log = Logg.createLogger();
	
// Footer link navigations
	
	@Test(priority=1,enabled=true)
	public void aboutUs()
	{
		cubHome = new CubHome(_driver);
		cubHome.clickOnAboutUs();
		String title=_driver.getTitle();
		System.out.println(title);
		Assert.assertEquals("Cub Foods - About | MN & IL Grocery Store | Cub Foods", title);
		log.info("AboutUs Navigation - Success " );
	}
	
	@Test(priority=2,enabled=true)
	public void Careers()
	{
		cubHome = new CubHome(_driver);
		cubHome.clickCareers();
		String title=_driver.getTitle();
		System.out.println(title);
		Assert.assertEquals("Cub Foods - Careers", title);
		log.info("Careers Navigation - Success " );
	}
	
	@Test(priority=3,enabled=true)
	public void Recalls()
	{
		cubHome = new CubHome(_driver);
		cubHome.clickRecalls();
		String title=_driver.getTitle();
		System.out.println(title);
		Assert.assertEquals("Cub Foods - Product Recalls", title);
		log.info("Product Recalls Navigation - Success " );
	}
	
	@Test(priority=4,enabled=true)
	public void PrivacyPolicy()
	{
		cubHome = new CubHome(_driver);
		cubHome.clickPrivacyPolicy();
		String title=_driver.getTitle();
		System.out.println(title);
		Assert.assertEquals("Cub Foods - Security Privacy", title);
		log.info("PrivacyPolicy Navigation - Success " );
	}
	
	@Test(priority=5,enabled=true)
	public void TermsAndConditions()
	{
		cubHome = new CubHome(_driver);
		cubHome.clickTermsOfUse();
		String title=_driver.getTitle();
		System.out.println(title);
		Assert.assertEquals("Cub Foods - Terms and Conditions", title);
		log.info("Terms And Conditions Navigation - Success " );
	}
	
	@Test(priority=6,enabled=true)
	public void CustomerService()
	{
		cubHome = new CubHome(_driver);
		cubHome.clickCustomerService();
		String title=_driver.getTitle();
		System.out.println(title);
		Assert.assertEquals("Cub Foods - Customer Service", title);
		log.info("Customer Service Navigation- Success " );
	}

	
// Home Page Tiles navigations
	
	@Test(priority=7,enabled=true)
	public void WeeklyAdTile()
	{
		cubHome = new CubHome(_driver);
		cubHome.clickWeeklyAdTile();
		String title=_driver.getTitle();
		System.out.println(title);
		Assert.assertEquals("Cub Foods - View Ads", title);
		log.info("Navigation of WeeklyAd Tile in Home page - Success " );
	}
	
	@Test(priority=8,enabled=true)
	public void CouponTile()
	{
		cubHome = new CubHome(_driver);
		cubHome.clickCouponTile(_driver);
		String title=_driver.getTitle();
		System.out.println(title);
		Assert.assertEquals("Cub Foods - View Coupons | MN & IL Grocery Store | Cub Foods", title);
		log.info("Navigation of Coupon Tile in Home page - Success " );
	}
	
	@Test(priority=9,enabled=true)
	public void CakesandPartyTile()
	{
		cubHome = new CubHome(_driver);
		cubHome.clickCakesandPartyTile();
	    String title=_driver.getCurrentUrl();
	    System.out.println(title);
	    Assert.assertEquals("http://cuborders.mywebgrocer.com/SelectStore", title);
	    log.info("Navigation of Cakes and Party Tile in Home page - Success " );
	}
	
	@Test(priority=10,enabled=true)
	public void CubRewardsTile()
	{
		cubHome = new CubHome(_driver);
		cubHome.clickCubRewardsTile();
		String title=_driver.getTitle();
		System.out.println(title);
		Assert.assertEquals("Cub Foods - My Cub Rewards | MN & IL Grocery Store | Cub Foods", title);
		log.info("Navigation of Cub Rewards Tile  in Home page - Success " );
	}
	
}





