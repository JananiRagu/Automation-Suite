package com.test.regression.farmfresh.testscripts;

import java.io.IOException;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.apache.log4j.Logger;
import org.openqa.selenium.UnhandledAlertException;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.xml.sax.SAXException;

import com.test.regression.farmfresh.pages.CouponPage;
import com.test.regression.farmfresh.pages.FFHome;
import com.test.regression.farmfresh.pages.FindAStorePage;
import com.test.regression.farmfresh.pages.MyAccountPage;
import com.test.regression.farmfresh.pages.RewardsCardPage;
import com.test.regression.farmfresh.pages.ShoppingListPage;
import com.test.regression.farmfresh.pages.SignUpPage;
import com.test.regression.farmfresh.pages.WeeklyAdsPage;
import com.test.regression.farmfresh.utils.Logg;
import com.test.regression.farmfresh.utils.ReadXML;
import com.test.regression.farmfresh.utils.SuiteBase;


public class SignUp extends SuiteBase{
	
	Logger log = Logg.createLogger();
	ReadXML readxml = new ReadXML();
	FFHome ffHome;
	SignUpPage signUpPage;
	FindAStorePage findastore;
	WeeklyAdsPage waObj;
	ShoppingListPage slObj;
	MyAccountPage map;
	CouponPage cp;
	RewardsCardPage rc;

	@Test(priority=3, enabled=false)
	public void validSignUp(){
		try{
		// Retrieving test data for valid sign up no card
				Map<String, String> validSignUpNoCard = readxml.getUserData("TestData.xml", "new-user-1");
				String userId = validSignUpNoCard.get("UserName");
				String password = validSignUpNoCard.get("password");
				String zip = validSignUpNoCard.get("zip");

		
		signUpPage = new SignUpPage(_driver);
		
		log.info("Test Data Used >>>>>>>");
		log.info("User Name : " + userId);
		log.info("Password : " + password);
		
		signUpPage.clickSignUpLink();
		signUpPage.enterSignUpDetails(userId,password);
		
		
		FindAStorePage findastore = new FindAStorePage(_driver);
		findastore.enterzip(zip);
		
		findastore.clickOnSearch();
		
		Thread.sleep(5000);
		findastore.clickOnStore();
				
		
		findastore.clickOnusestore();
	
		
		findastore.clickOnContinue();
		
		map = new MyAccountPage(_driver);
		
		map.clickOnMyAccountUnderMyTools(_driver);
		
		String username = map.getSignedInUsername();
		
		boolean result = username.equalsIgnoreCase(userId);
		
		Assert.assertTrue(result);	
		
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

	
	
	
	
	@Test(priority=6, enabled=false)
	public void userNameNPasswordFieldValidationSignUp(){
		try{
			
			SoftAssert sa = new SoftAssert();
			
			String userIdWithSpace ="test test"; 
			String password6 = "123456";

		
		signUpPage = new SignUpPage(_driver);
		
		log.info("Test Data Used >>>>>>>");
		log.info("User Name : " + userIdWithSpace);
		log.info("Password : " + password6);
		
		signUpPage.clickSignUpLink();
		
		//signUpPage.enterSignUpDetailsWithoutclickingContinue(userIdWithSpace,password6);
		
		signUpPage.enterUserNameInSignUpPopup(userIdWithSpace);
			
		sa.assertTrue(signUpPage.isInvalidEmailTextPresent(), "Error Message is not displayed while using UserId with spaces..");
		
		String userIdWithoutAt = "test.com";
		
		log.info("Test Data Used >>>>>>>");
		log.info("User Name : " + userIdWithoutAt);
		log.info("Password : " + password6);
				
		signUpPage.enterUserNameInSignUpPopup(userIdWithoutAt);
			
		sa.assertTrue(signUpPage.isInvalidEmailTextPresent(), "Error Message is not displayed while using UserId without @ symbol..");
		
		String userId = "test@ff.com";
		String passwordLess6 = "abcde";
		
		log.info("Test Data Used >>>>>>>");
		log.info("User Name : " + userId);
		log.info("Password : " + passwordLess6);

		signUpPage.enterPasswordInSignUpPopup(passwordLess6);
			
		sa.assertTrue(signUpPage.isInvalidPasswordTextPresent(), "Error Message is not displayed while using password with less than 6 characters..");
		
		
		String passwordWithSpace = "abcde f";
		
		log.info("Test Data Used >>>>>>>");
		log.info("User Name : " + userId);
		log.info("Password : " + passwordWithSpace);
				
		signUpPage.enterPasswordInSignUpPopup(passwordWithSpace);
			
		sa.assertTrue(signUpPage.isInvalidPasswordTextPresent(), "Error Message is not displayed while using password with space..");

		signUpPage.clickOnClosePopUp();
		
		signUpPage.clickSignUpLink();
		
		sa.assertTrue(signUpPage.isSignUpPopupPresent(), "Unable to close SignIn popup..");
		
		sa.assertAll();
		
		} catch (InterruptedException ie) {
			log.info(ie.getMessage());
			Assert.fail("Caught Interrupted Exception");
		} catch (Exception e) {
			log.info(e.getMessage());
			Assert.fail(e.getLocalizedMessage());
		}
		
	}
	
	@Test(priority=5, enabled=false)
	public void validateSignInLinkInSignUpPopup(){
		
		try {
			SoftAssert sa = new SoftAssert();
			
		signUpPage = new SignUpPage(_driver);
		
		signUpPage.clickSignUpLink();
		
		ffHome = new FFHome(_driver);
		
		sa.assertTrue(ffHome.signUpPopupPresence(),"Sign Up popup is not displayed on clicking SignUp in home page header");
		
		signUpPage.clickSignInLinkInSignUpPopup();
		
		sa.assertTrue(ffHome.signInPopupPresence(),"Sign In popup is not displayed on clicking SignIn in Sign Up popup");
		
		sa.assertAll();
		
		} catch (InterruptedException ie) {
			log.info(ie.getMessage());
			Assert.fail("Caught Interrupted Exception");
		} catch (Exception e) {
			log.info(e.getMessage());
			Assert.fail(e.getLocalizedMessage());
		}
	}
	
	@Test(priority=3, enabled=true)
	public void validSignUp4mSL(){
		try{
		// Retrieving test data for valid sign up no card
				Map<String, String> validSignUpNoCard = readxml.getUserData("TestData.xml", "new-user-8");
				String userId = validSignUpNoCard.get("UserName");
				String password = validSignUpNoCard.get("password");
				String zip = validSignUpNoCard.get("zip");
		
		ffHome = new FFHome(_driver);
		
		log.info("Test Data Used >>>>>>>");
		log.info("User Name : " + userId);
		log.info("Password : " + password);
		
		ffHome.clickWeeklyAdTile();
		waObj = new WeeklyAdsPage(_driver);
		waObj.clickOnCreateListButton();
		
		slObj = new ShoppingListPage(_driver);
		slObj.clickSignUpInSLWidget();
		
		signUpPage = new SignUpPage(_driver);
		signUpPage.enterSignUpDetails(userId,password);
			
		Thread.sleep(5000);
		
		FindAStorePage findastore = new FindAStorePage(_driver);
		findastore.enterzip(zip);
		
		findastore.clickOnSearch();
		
		Thread.sleep(5000);
		findastore.clickOnStore();
				
		
		findastore.clickOnusestore();
	
		
		findastore.clickOnContinue();
		
		map = new MyAccountPage(_driver);
		
		map.clickOnMyAccountUnderMyTools(_driver);
		
		String username = map.getSignedInUsername();
		
		boolean result = username.equalsIgnoreCase(userId);
		
		Assert.assertTrue(result);	
		
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
	
	@Test(priority=3, enabled=false)
	public void validSignUp4mCouponsPage() throws InterruptedException{
		try{
		// Retrieving test data for valid sign up no card
				Map<String, String> validSignUpNoCard = readxml.getUserData("TestData.xml", "new-user-9");
				String userId = validSignUpNoCard.get("UserName");
				String password = validSignUpNoCard.get("password");
				String zip = validSignUpNoCard.get("zip");
				
				cp = new CouponPage(_driver);
				
				
					//ffHome.clickCouponTile(_driver);	
					cp.clickOnCouponsInMyToolsHomePage(_driver);

					//cp.loadCompleteCouponsPage(_driver);
						//log.info("Coupons Page is loaded fully");
				
				
				cp.addSingleCoupon(_driver, "1");
				
		ffHome = new FFHome(_driver);
		
		ffHome.clickSignUpLinkInSignInPopup();
		
		signUpPage = new SignUpPage(_driver);
		
		Thread.sleep(5000);
		
		signUpPage.enterSignUpDetails(userId,password);
		Thread.sleep(5000);
		FindAStorePage findastore = new FindAStorePage(_driver);
		findastore.enterzip(zip);
		
		findastore.clickOnSearch();
		
		Thread.sleep(5000);
		findastore.clickOnStore();
				
		
		findastore.clickOnusestore();
	
		
		findastore.clickOnContinue();
		
		map = new MyAccountPage(_driver);
		
		map.clickOnMyAccountUnderMyTools(_driver);
		
		String username = map.getSignedInUsername();
		
		boolean result = username.equalsIgnoreCase(userId);
		
		Assert.assertTrue(result);	
		
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
		} catch(UnhandledAlertException al){
			_driver.switchTo().alert().accept();
			Thread.sleep(5000);
		}	catch (Exception e) {
			log.info(e.getMessage());
			Assert.fail(e.getLocalizedMessage());
		}
		
	}
	
	
	
}
