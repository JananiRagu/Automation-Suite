package com.test.regression.cub.testscripts;

import java.io.IOException;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.xml.sax.SAXException;

import com.test.regression.cub.pages.AboutUsPage;
import com.test.regression.cub.pages.CubHome;
import com.test.regression.cub.utils.Logg;
import com.test.regression.cub.utils.ReadXML;
import com.test.regression.cub.utils.SuiteBase;

public class HeaderFooterNavigation extends SuiteBase{
	CubHome cubHome;
	Logger log = Logg.createLogger();
	ReadXML readxml = new ReadXML();

	
// Footer link navigations
		
	@Test(priority=1,enabled=true)
	public void FooterLinksGuestUser()
	{
		cubHome = new CubHome(_driver);
		SoftAssert sa = new SoftAssert();
		
		cubHome.clickOnAboutUs();
		String title=_driver.getTitle();
		System.out.println(title);
		sa.assertEquals(title, "Cub Foods - About | MN & IL Grocery Store | Cub Foods", "\n Footer Link - AboutUs Navigation  - Failed ");
			
		_driver.navigate().back();
		cubHome.clickCareers();
		String title1=_driver.getTitle();
		System.out.println(title1);
		sa.assertEquals(title1, "Cub Foods - Careers", "\n Footer Link - Careers Navigation  - Failed ");
		
		_driver.navigate().back();
			cubHome.clickRecalls();
		String title2=_driver.getTitle();
		System.out.println(title2);
		sa.assertEquals(title2, "Cub Foods - Product Recalls", "\n Footer Link - Product Recalls  Navigation  - Failed ");
		
		_driver.navigate().back();
		cubHome.clickPrivacyPolicy();
		String title3=_driver.getTitle();
		System.out.println(title3);
		sa.assertEquals(title3, "Cub Foods - Security Privacy", "\n Footer Link - PrivacyPolicy Navigation  - Failed ");
		
		_driver.navigate().back();
		cubHome.clickTermsOfUse();
		String title4=_driver.getTitle();
		System.out.println(title4);
		sa.assertEquals(title4, "Cub Foods - Terms and Conditions", "\n Footer Link - Terms And Conditions  Navigation  - Failed ");
			
		cubHome = new CubHome(_driver);
		cubHome.clickCustomerService();
		String title5=_driver.getTitle();
		System.out.println(title5);
		sa.assertEquals(title5, "Cub Foods - Customer Service", "\n Footer Link - Customer Service Navigation  - Failed ");
		
		sa.assertAll();
		
	}

	
	// Footer link navigations for Logged in Users
		
	@Test(priority=1,enabled=true)
	public void FooterLinksSignedInUser()
	{
		
		try{
			// Retrieving test data for valid login
			Map<String, String> validLogin = readxml.getUserData("TestData.xml", "carded-user");
			String userId = validLogin.get("UserName");
			String password = validLogin.get("password");
			
			cubHome = new CubHome(_driver);
			SoftAssert sa = new SoftAssert();
			
			log.info("User Name : " + userId);
			log.info("Password : " + password);
			log.info("Cub Home page is launched");
		cubHome.clickSignInLink();
		cubHome.enterLoginDetails(userId, password);
		cubHome.clickSignInButton();
		log.info("User Signed In");
		Thread.sleep(5000);
		
		cubHome.clickOnAboutUs();
		String title=_driver.getTitle();
		System.out.println(title);
		sa.assertEquals(title, "Cub Foods - About | MN & IL Grocery Store | Cub Foods", "\n Footer Link - AboutUs Navigation  for SIGNED IN User - Failed ");
			
		_driver.navigate().back();
		cubHome.clickCareers();
		String title1=_driver.getTitle();
		System.out.println(title1);
		sa.assertEquals(title1, "Cub Foods - Careers", "\n Footer Link - Careers Navigation  for SIGNED IN User - Failed ");
		
		_driver.navigate().back();
			cubHome.clickRecalls();
		String title2=_driver.getTitle();
		System.out.println(title2);
		sa.assertEquals(title2, "Cub Foods - Product Recalls", "\n Footer Link - Product Recalls  Navigation  for SIGNED IN User - Failed ");
		
		_driver.navigate().back();
		cubHome.clickPrivacyPolicy();
		String title3=_driver.getTitle();
		System.out.println(title3);
		sa.assertEquals(title3, "Cub Foods - Security Privacy", "\n Footer Link - PrivacyPolicy Navigation  for SIGNED IN User - Failed ");
		
		_driver.navigate().back();
		cubHome.clickTermsOfUse();
		String title4=_driver.getTitle();
		System.out.println(title4);
		sa.assertEquals(title4, "Cub Foods - Terms and Conditions", "\n Footer Link - Terms And Conditions  Navigation  for SIGNED IN User - Failed ");
			
		cubHome = new CubHome(_driver);
		cubHome.clickCustomerService();
		String title5=_driver.getTitle();
		System.out.println(title5);
		sa.assertEquals(title5, "Cub Foods - Customer Service", "\n Footer Link - Customer Service Navigation  for SIGNED IN User - Failed ");
		
		 sa.assertAll();
				
	} catch (InterruptedException ie) {
		log.info(ie.getMessage());
		Assert.fail("Caught Interrupted Exception");
	} catch (IOException ioe) {
		log.info(ioe.getMessage());	
		Assert.fail("Caught IOException Exception");
	} catch (XPathExpressionException xee) {
		log.info(xee.getMessage());	
		Assert.fail("Caught XPathExpressionException Exception");
	} catch (ParserConfigurationException pce) {
		log.info(pce.getMessage());
		Assert.fail("Caught ParserConfigurationException Exception");
	} catch (SAXException saxe) {
		log.info(saxe.getMessage());
		Assert.fail("Caught SAXException Exception");
	} catch (Exception e) {
		log.info(e.getMessage());
		Assert.fail(e.getLocalizedMessage());
	}
}
		
	
// Home Page Tiles navigations
	
	@Test(priority=3,enabled=true)
	public void TilesNavigationGuestUser()
	{
		cubHome = new CubHome(_driver);
		SoftAssert sa = new SoftAssert();
		
		cubHome.clickWeeklyAdTile();
		String title=_driver.getTitle();
		System.out.println(title);
		sa.assertEquals(title, "Cub Foods - View Ads", "\n Navigation of WeeklyAd Tile in Home page - Failed ");
		
		_driver.navigate().back();
		cubHome.clickCouponTile(_driver);
		String title1=_driver.getTitle();
		System.out.println(title1);
		sa.assertEquals(title1, "Cub Foods - View Coupons | MN & IL Grocery Store | Cub Foods", "\n Navigation of Coupon Tile in Home page - Failed ");
		
		_driver.navigate().back();
		cubHome.clickCakesandPartyTile();
	    String title2=_driver.getCurrentUrl();
	    System.out.println(title2);
	    sa.assertEquals(title2, "http://cuborders.mywebgrocer.com/SelectStore", "\n Navigation of Cakes and Party Tile in Home page  - Failed ");
		
	    _driver.navigate().back();
	    cubHome = new CubHome(_driver);
		cubHome.clickCubRewardsTile();
		String title3=_driver.getTitle();
		System.out.println(title3);
		 sa.assertEquals(title3, "Cub Foods - My Cub Rewards | MN & IL Grocery Store | Cub Foods", "\n Navigation of Cub Rewards Tile  Failed ");
		
		 sa.assertAll();
	}
	
	
	// Home Page Tiles navigations for Logged In user
		

	@Test(priority=4,enabled=true)
	public void TilesNavigationSignedInUser()
	{
				try{
			// Retrieving test data for valid login
			Map<String, String> validLogin = readxml.getUserData("TestData.xml", "carded-user");
			String userId = validLogin.get("UserName");
			String password = validLogin.get("password");
			
			cubHome = new CubHome(_driver);
			SoftAssert sa = new SoftAssert();
			
	   cubHome.clickSignInLink();
		cubHome.enterLoginDetails(userId, password);
		cubHome.clickSignInButton();
		log.info("User Signed In");
		Thread.sleep(5000);
		
		cubHome.clickWeeklyAdTile();
		String title=_driver.getTitle();
		System.out.println(title);
		sa.assertEquals(title, "Cub Foods - View Ads", "\n Navigation of WeeklyAd Tile in Home page - Failed ");
		
		_driver.navigate().back();
		cubHome.clickCouponTile(_driver);
		String title1=_driver.getTitle();
		System.out.println(title1);
		sa.assertEquals(title1, "Cub Foods - View Coupons | MN & IL Grocery Store | Cub Foods", "\n Navigation of Coupon Tile in Home page - Failed ");
		
		_driver.navigate().back();
		cubHome.clickCakesandPartyTile();
	    String title2=_driver.getCurrentUrl();
	    System.out.println(title2);
	    sa.assertEquals(title2, "http://cuborders.mywebgrocer.com/SelectStore", "\n Navigation of Cakes and Party Tile in Home page  - Failed ");
		
	    _driver.navigate().back();
	    cubHome = new CubHome(_driver);
		cubHome.clickCubRewardsTile();
		String title3=_driver.getTitle();
		System.out.println(title3);
		 sa.assertEquals(title3, "Cub Foods - My Cub Rewards | MN & IL Grocery Store | Cub Foods", "\n Navigation of Cub Rewards Tile  Failed ");
		
		 sa.assertAll();
			
		} catch (InterruptedException ie) {
			log.info(ie.getMessage());
			Assert.fail("Caught Interrupted Exception");
		} catch (IOException ioe) {
			log.info(ioe.getMessage());	
			Assert.fail("Caught IOException Exception");
		} catch (XPathExpressionException xee) {
			log.info(xee.getMessage());	
			Assert.fail("Caught XPathExpressionException Exception");
		} catch (ParserConfigurationException pce) {
			log.info(pce.getMessage());
			Assert.fail("Caught ParserConfigurationException Exception");
		} catch (SAXException saxe) {
			log.info(saxe.getMessage());
			Assert.fail("Caught SAXException Exception");
		} catch (Exception e) {
			log.info(e.getMessage());
			Assert.fail(e.getLocalizedMessage());
		}
 }
}