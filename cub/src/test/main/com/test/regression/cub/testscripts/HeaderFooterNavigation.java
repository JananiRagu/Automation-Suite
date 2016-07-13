package com.test.regression.cub.testscripts;

import java.io.IOException;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
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
	
	@Test(priority=22,enabled=true)
	public void aboutUs()
	{
		cubHome = new CubHome(_driver);
		cubHome.clickOnAboutUs();
		String title=_driver.getTitle();
		System.out.println(title);
		Assert.assertEquals("Cub Foods - About | MN & IL Grocery Store | Cub Foods", title);
		log.info("AboutUs Navigation - Success " );
	}
	
	@Test(priority=23,enabled=true)
	public void Careers()
	{
		cubHome = new CubHome(_driver);
		cubHome.clickCareers();
		String title=_driver.getTitle();
		System.out.println(title);
		Assert.assertEquals("Cub Foods - Careers", title);
		log.info("Careers Navigation - Success " );
	}
	
	@Test(priority=24,enabled=true)
	public void Recalls()
	{
		cubHome = new CubHome(_driver);
		cubHome.clickRecalls();
		String title=_driver.getTitle();
		System.out.println(title);
		Assert.assertEquals("Cub Foods - Product Recalls", title);
		log.info("Product Recalls Navigation - Success " );
	}
	
	@Test(priority=25,enabled=true)
	public void PrivacyPolicy()
	{
		cubHome = new CubHome(_driver);
		cubHome.clickPrivacyPolicy();
		String title=_driver.getTitle();
		System.out.println(title);
		Assert.assertEquals("Cub Foods - Security Privacy", title);
		log.info("PrivacyPolicy Navigation - Success " );
	}
	
	@Test(priority=26,enabled=true)
	public void TermsAndConditions()
	{
		cubHome = new CubHome(_driver);
		cubHome.clickTermsOfUse();
		String title=_driver.getTitle();
		System.out.println(title);
		Assert.assertEquals("Cub Foods - Terms and Conditions", title);
		log.info("Terms And Conditions Navigation - Success " );
	}
	
	@Test(priority=27,enabled=true)
	public void CustomerService()
	{
		cubHome = new CubHome(_driver);
		cubHome.clickCustomerService();
		String title=_driver.getTitle();
		System.out.println(title);
		Assert.assertEquals("Cub Foods - Customer Service", title);
		log.info("Customer Service Navigation- Success " );
	}

	
	// Footer link navigations for Logged in Users
		
		@Test(priority=28,enabled=true)
		public void aboutUsSignedInUser(){
			
			try{
			// Retrieving test data for valid login
			Map<String, String> validLogin = readxml.getUserData("TestData.xml", "carded-user");
			String userId = validLogin.get("UserName");
			String password = validLogin.get("password");
			
			cubHome = new CubHome(_driver);
			
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
		Assert.assertEquals("Cub Foods - About | MN & IL Grocery Store | Cub Foods", title);
			log.info("AboutUs Navigation - Success " );
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
		
		@Test(priority=29,enabled=true)
		public void CareersSignedInUser() {
			try {
			// Retrieving test data for valid login
			Map<String, String> validLogin = readxml.getUserData("TestData.xml", "carded-user");
			String userId = validLogin.get("UserName");
			String password = validLogin.get("password");
			
			cubHome = new CubHome(_driver);
			
			log.info("User Name : " + userId);
			log.info("Password : " + password);
			log.info("Cub Home page is launched");
		cubHome.clickSignInLink();
			
		cubHome.enterLoginDetails(userId, password);
			
		cubHome.clickSignInButton();

			log.info("User Signed In");
			
			Thread.sleep(5000);
		cubHome.clickCareers();
			String title=_driver.getTitle();
			System.out.println(title);
		Assert.assertEquals("Cub Foods - Careers", title);
			log.info("Careers Navigation - Success " );
			
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
		
		@Test(priority=30,enabled=true)
		public void RecallsSignedInUser() {
			try{
			// Retrieving test data for valid login
			Map<String, String> validLogin = readxml.getUserData("TestData.xml", "carded-user");
			String userId = validLogin.get("UserName");
			String password = validLogin.get("password");
			
			cubHome = new CubHome(_driver);
			
			log.info("User Name : " + userId);
			log.info("Password : " + password);
			log.info("Cub Home page is launched");
		cubHome.clickSignInLink();
			log.info("SignIn Link Clicked");
		cubHome.enterLoginDetails(userId, password);
			log.info("Entered login Details");
		cubHome.clickSignInButton();
			log.info("SignInButton Clicked");
			log.info("Entered all details and clicked on Sign In Button");
			log.info("User Signed In");
			
			Thread.sleep(10000);
			cubHome.clickRecalls();
			String title=_driver.getTitle();
			System.out.println(title);
			Assert.assertEquals("Cub Foods - Product Recalls", title);
			log.info("Product Recalls Navigation - Success " );
			
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
		
		@Test(priority=31,enabled=true)
		public void PrivacyPolicySignedInUser() {
			try{
			// Retrieving test data for valid login
			Map<String, String> validLogin = readxml.getUserData("TestData.xml", "carded-user");
			String userId = validLogin.get("UserName");
			String password = validLogin.get("password");
			
			cubHome = new CubHome(_driver);
			
			log.info("User Name : " + userId);
			log.info("Password : " + password);
			log.info("Cub Home page is launched");
		cubHome.clickSignInLink();
			log.info("SignIn Link Clicked");
		cubHome.enterLoginDetails(userId, password);
			log.info("Entered login Details");
		cubHome.clickSignInButton();
			log.info("SignInButton Clicked");
			log.info("Entered all details and clicked on Sign In Button");
			log.info("User Signed In");
			
			Thread.sleep(10000);
			cubHome.clickPrivacyPolicy();
			String title=_driver.getTitle();
			System.out.println(title);
			Assert.assertEquals("Cub Foods - Security Privacy", title);
			log.info("PrivacyPolicy Navigation - Success " );
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
		
		@Test(priority=32,enabled=true)
		public void TermsAndConditionsSignedInUser() {
			try{
			// Retrieving test data for valid login
			Map<String, String> validLogin = readxml.getUserData("TestData.xml", "carded-user");
			String userId = validLogin.get("UserName");
			String password = validLogin.get("password");
			
			cubHome = new CubHome(_driver);
			
			log.info("User Name : " + userId);
			log.info("Password : " + password);
			log.info("Cub Home page is launched");
		cubHome.clickSignInLink();
			log.info("SignIn Link Clicked");
		cubHome.enterLoginDetails(userId, password);
			log.info("Entered login Details");
		cubHome.clickSignInButton();
			log.info("SignInButton Clicked");
			log.info("Entered all details and clicked on Sign In Button");
			log.info("User Signed In");
						
			Thread.sleep(10000);
			cubHome.clickTermsOfUse();
			String title=_driver.getTitle();
			System.out.println(title);
			Assert.assertEquals("Cub Foods - Terms and Conditions", title);
			log.info("Terms And Conditions Navigation - Success " );
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
		
		@Test(priority=33,enabled=true)
		public void CustomerServiceSignedInUser() {
			try{
			// Retrieving test data for valid login
			Map<String, String> validLogin = readxml.getUserData("TestData.xml", "carded-user");
			String userId = validLogin.get("UserName");
			String password = validLogin.get("password");
			
			cubHome = new CubHome(_driver);
			
			log.info("User Name : " + userId);
			log.info("Password : " + password);
			log.info("Cub Home page is launched");
		cubHome.clickSignInLink();
			log.info("SignIn Link Clicked");
		cubHome.enterLoginDetails(userId, password);
			log.info("Entered login Details");
		cubHome.clickSignInButton();
			log.info("SignInButton Clicked");
			log.info("Entered all details and clicked on Sign In Button");
			log.info("User Signed In");
						
			Thread.sleep(10000);
			cubHome.clickCustomerService();
			String title=_driver.getTitle();
			System.out.println(title);
			Assert.assertEquals("Cub Foods - Customer Service", title);
			log.info("Customer Service Navigation- Success " );
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
	
	@Test(priority=34,enabled=true)
	public void WeeklyAdTile()
	{
		cubHome = new CubHome(_driver);
		cubHome.clickWeeklyAdTile();
		String title=_driver.getTitle();
		System.out.println(title);
		Assert.assertEquals("Cub Foods - View Ads", title);
		log.info("Navigation of WeeklyAd Tile in Home page - Success " );
	}
	
	@Test(priority=35,enabled=true)
	public void CouponTile()
	{
		cubHome = new CubHome(_driver);
		cubHome.clickCouponTile(_driver);
		String title=_driver.getTitle();
		System.out.println(title);
		Assert.assertEquals("Cub Foods - View Coupons | MN & IL Grocery Store | Cub Foods", title);
		log.info("Navigation of Coupon Tile in Home page - Success " );
	}
	
	@Test(priority=36,enabled=true)
	public void CakesandPartyTile()
	{
		cubHome = new CubHome(_driver);
		cubHome.clickCakesandPartyTile();
	    String title=_driver.getCurrentUrl();
	    System.out.println(title);
	    Assert.assertEquals("http://cuborders.mywebgrocer.com/SelectStore", title);
	    log.info("Navigation of Cakes and Party Tile in Home page - Success " );
	}
	
	@Test(priority=37,enabled=true)
	public void CubRewardsTile()
	{
		cubHome = new CubHome(_driver);
		cubHome.clickCubRewardsTile();
		String title=_driver.getTitle();
		System.out.println(title);
		Assert.assertEquals("Cub Foods - My Cub Rewards | MN & IL Grocery Store | Cub Foods", title);
		log.info("Navigation of Cub Rewards Tile  in Home page - Success " );
	}
	
	
	// Home Page Tiles navigations for Logged In user
		
		@Test(priority=38,enabled=true)
		public void WeeklyAdTileSignedInUser() {
			try{
			// Retrieving test data for valid login
			Map<String, String> validLogin = readxml.getUserData("TestData.xml", "carded-user");
			String userId = validLogin.get("UserName");
			String password = validLogin.get("password");
			
			cubHome = new CubHome(_driver);
			
			log.info("User Name : " + userId);
			log.info("Password : " + password);
			log.info("Cub Home page is launched");
		cubHome.clickSignInLink();
			log.info("SignIn Link Clicked");
		cubHome.enterLoginDetails(userId, password);
			log.info("Entered login Details");
		cubHome.clickSignInButton();
			log.info("SignInButton Clicked");
			log.info("Entered all details and clicked on Sign In Button");
			log.info("User Signed In");
						
			Thread.sleep(10000);
			cubHome.clickWeeklyAdTile();
			String title=_driver.getTitle();
			System.out.println(title);
			Assert.assertEquals("Cub Foods - View Ads", title);
			log.info("Navigation of WeeklyAd Tile in Home page - Success " );
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
		
		@Test(priority=39,enabled=true)
		public void CouponTileSignedInUser(){
			try{
			// Retrieving test data for valid login
			Map<String, String> validLogin = readxml.getUserData("TestData.xml", "carded-user");
			String userId = validLogin.get("UserName");
			String password = validLogin.get("password");
			
			cubHome = new CubHome(_driver);
			
			log.info("User Name : " + userId);
			log.info("Password : " + password);
			log.info("Cub Home page is launched");
		cubHome.clickSignInLink();
			log.info("SignIn Link Clicked");
		cubHome.enterLoginDetails(userId, password);
			log.info("Entered login Details");
		cubHome.clickSignInButton();
			log.info("SignInButton Clicked");
			log.info("Entered all details and clicked on Sign In Button");
			log.info("User Signed In");
						
			Thread.sleep(10000);
			
			cubHome.clickCouponTile(_driver);
			String title=_driver.getTitle();
			System.out.println(title);
			Assert.assertEquals("Cub Foods - View Coupons | MN & IL Grocery Store | Cub Foods", title);
			log.info("Navigation of Coupon Tile in Home page - Success " );
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
		
		@Test(priority=40,enabled=true)
		public void CakesandPartyTileSignedInUser() {
			try{
			// Retrieving test data for valid login
			Map<String, String> validLogin = readxml.getUserData("TestData.xml", "carded-user");
			String userId = validLogin.get("UserName");
			String password = validLogin.get("password");
			
			cubHome = new CubHome(_driver);
			
			log.info("User Name : " + userId);
			log.info("Password : " + password);
			log.info("Cub Home page is launched");
		cubHome.clickSignInLink();
			log.info("SignIn Link Clicked");
		cubHome.enterLoginDetails(userId, password);
			log.info("Entered login Details");
		cubHome.clickSignInButton();
			log.info("SignInButton Clicked");
			log.info("Entered all details and clicked on Sign In Button");
			log.info("User Signed In");
						
			Thread.sleep(10000);
			cubHome.clickCakesandPartyTile();
		    String title=_driver.getCurrentUrl();
		    System.out.println(title);
		    Assert.assertEquals("http://cuborders.mywebgrocer.com/SelectStore", title);
		    log.info("Navigation of Cakes and Party Tile in Home page - Success " );
		    
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
		
		@Test(priority=41,enabled=true)
		public void CubRewardsTileSignedInUser() {
			try{
			// Retrieving test data for valid login
			Map<String, String> validLogin = readxml.getUserData("TestData.xml", "carded-user");
			String userId = validLogin.get("UserName");
			String password = validLogin.get("password");
			
			cubHome = new CubHome(_driver);
			
			log.info("User Name : " + userId);
			log.info("Password : " + password);
			log.info("Cub Home page is launched");
		cubHome.clickSignInLink();
			log.info("SignIn Link Clicked");
		cubHome.enterLoginDetails(userId, password);
			log.info("Entered login Details");
		cubHome.clickSignInButton();
			log.info("SignInButton Clicked");
			log.info("Entered all details and clicked on Sign In Button");
			log.info("User Signed In");
						
			Thread.sleep(10000);
			cubHome.clickCubRewardsTile();
			String title=_driver.getTitle();
			System.out.println(title);
			Assert.assertEquals("Cub Foods - My Cub Rewards | MN & IL Grocery Store | Cub Foods", title);
			log.info("Navigation of Cub Rewards Tile  in Home page - Success " );
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





