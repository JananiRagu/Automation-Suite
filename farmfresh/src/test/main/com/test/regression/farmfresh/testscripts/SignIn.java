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
import com.test.regression.farmfresh.pages.MyAccountPage;
import com.test.regression.farmfresh.pages.ShoppingListPage;
import com.test.regression.farmfresh.pages.WeeklyAdsPage;
import com.test.regression.farmfresh.utils.Logg;
import com.test.regression.farmfresh.utils.ReadXML;
import com.test.regression.farmfresh.utils.SuiteBase;

public class SignIn extends SuiteBase {

	FFHome ffHome;
	
	MyAccountPage map;
	WeeklyAdsPage waObj;
	ShoppingListPage slObj;
	CouponPage cp;
	Logger log = Logg.createLogger();
	ReadXML readxml = new ReadXML();

	@Test(priority=1, enabled=true)
	
	public void validLogin() {
		try {
			
		// Retrieving test data for valid login
		Map<String, String> validLogin = readxml.getUserData("TestData.xml", "authorized-user-1");
		String userId = validLogin.get("UserName");
		String password = validLogin.get("password");

		ffHome = new FFHome(_driver);
			log.info("Test Data Used >>>>>>>");
			log.info("User Name : " + userId);
			log.info("Password : " + password);
		
		ffHome.clickSignInLink();
		
		ffHome.enterLoginDetails(userId, password);

		ffHome.clickSignInButton();
		
		map = new MyAccountPage(_driver);
		
		map.clickOnMyAccountUnderMyTools(_driver);
		
		String username = map.getSignedInUsername();
		
		boolean result = username.equalsIgnoreCase(userId);
		System.out.println("Result is " + result);
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
	
	@Test(priority=2,enabled=true) 
	  public void inValidLogin(){
		
		try {
		// Retrieving test data for valid login
		Map<String, String> invalidLogin = readxml.getUserData("TestData.xml", "invalid-user-1");
		String userId = invalidLogin.get("UserName");
		String password = invalidLogin.get("password");

		ffHome = new FFHome(_driver);
		
			log.info("Test Data Used >>>>>>>");
			log.info("User Name" + userId);
			log.info("Password" + password);
			
		ffHome.clickSignInLink();
			
		ffHome.enterLoginDetails(userId, password);
			
		ffHome.clickSignInButton();
		
		Assert.assertTrue(ffHome.isPasswordIncorrectTextPresent());
	
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
	
	@Test(priority=3,enabled=true) 
	  public void userNameNPasswordFieldValidation(){
		
		try {
			SoftAssert sa = new SoftAssert();
		
		String userIdWithSpace ="test test"; 
		String passwordLessThan6 = "12345";

		ffHome = new FFHome(_driver);
		
			log.info("Test Data Used >>>>>>>");
			log.info("User Name" + userIdWithSpace);
			log.info("Password" + passwordLessThan6);
			
		ffHome.clickSignInLink();
			
		ffHome.enterLoginDetails(userIdWithSpace, passwordLessThan6);
			
		ffHome.clickSignInButton();
		
		sa.assertTrue(ffHome.isPasswordIncorrectTextPresent(), "User Name and Password field validation for userIdWithSpace and passwordLessThan6 failed..");
		
		String userIdWithNumbers ="7894632"; 
		String password = "12345";

		//ffHome = new ffHome(_driver);
		
			log.info("Test Data Used >>>>>>>");
			log.info("User Name" + userIdWithNumbers);
			log.info("Password" + password);
			
		//ffHome.clickSignInLink();
			
		ffHome.enterLoginDetails(userIdWithNumbers, password);
			
		ffHome.clickSignInButton();
		
		sa.assertTrue(ffHome.isPasswordIncorrectTextPresent(), "User Name and Password field validation for userIdWithNumbers failed..");
		
		ffHome.clickOnClosePopUp();
		
		ffHome.clickSignInLink();
		
		sa.assertTrue(ffHome.isSignInPopupPresent(), "Unable to close SignIn popup..");
	
		sa.assertAll();
		} catch (InterruptedException ie) {
			log.info(ie.getMessage());
			Assert.fail("Caught Interrupted Exception");
		} catch (Exception e) {
			log.info(e.getMessage());
			Assert.fail(e.getLocalizedMessage());
		}
	 
	}
	
@Test(priority=4, enabled=true)
	
	public void validLoginFromShoppingListPage() {
		try {
			
		// Retrieving test data for valid login
		Map<String, String> validLogin = readxml.getUserData("TestData.xml", "authorized-user-1");
		String userId = validLogin.get("UserName");
		String password = validLogin.get("password");

		ffHome = new FFHome(_driver);
			log.info("Test Data Used >>>>>>>");
			log.info("User Name : " + userId);
			log.info("Password : " + password);
		
		ffHome.clickWeeklyAdTile();
		waObj = new WeeklyAdsPage(_driver);
		waObj.clickOnCreateListButton();
		
		slObj = new ShoppingListPage(_driver);
		slObj.clickSignInInSLWidget();
		
		ffHome.enterLoginDetails(userId, password);

		ffHome.clickSignInButton();
		
		map = new MyAccountPage(_driver);
		
		map.clickOnMyAccountUnderMyTools(_driver);
		
		String username = map.getSignedInUsername();
		
		boolean result = username.equalsIgnoreCase(userId);
		System.out.println("Result is " + result);
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



@Test(priority=5, enabled=true)

public void validLoginFromCouponsPage() {
	try {
		
	// Retrieving test data for valid login
	Map<String, String> validLogin = readxml.getUserData("TestData.xml", "authorized-user-1");
	String userId = validLogin.get("UserName");
	String password = validLogin.get("password");

	
		log.info("Test Data Used >>>>>>>");
		log.info("User Name : " + userId);
		log.info("Password : " + password);
	
		cp = new CouponPage(_driver);
		
		try{
			//ffHome.clickCouponTile(_driver);	
			cp.clickOnCouponsInMyToolsHomePage(_driver);

			//cp.loadCompleteCouponsPage(_driver);
				//log.info("Coupons Page is loaded fully");
		}catch(UnhandledAlertException al){
			_driver.switchTo().alert().accept();
		}
		
		cp.addSingleCoupon(_driver, "1");
	
		ffHome = new FFHome(_driver);
		
	ffHome.enterLoginDetails(userId, password);

	ffHome.clickSignInButton();
	
	map = new MyAccountPage(_driver);
	
	map.clickOnMyAccountUnderMyTools(_driver);
	
	String username = map.getSignedInUsername();
	
	boolean result = username.equalsIgnoreCase(userId);
	System.out.println("Result is " + result);
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

@Test(priority=5, enabled=true)
public void validateSignUpLinkInSignInPopup(){
	
	try {
		SoftAssert sa = new SoftAssert();
	
	ffHome = new FFHome(_driver);
	ffHome.clickSignInLink();
	
	sa.assertTrue(ffHome.signInPopupPresence(),"Sign In popup is not displayed on clicking SignIn in home page header");
	
	ffHome.clickSignUpLinkInSignInPopup();
	
	sa.assertTrue(ffHome.signUpPopupPresence(),"Sign Up popup is not displayed on clicking SignUp in Sign In popup");
	
	sa.assertAll();
	
	} catch (InterruptedException ie) {
		log.info(ie.getMessage());
		Assert.fail("Caught Interrupted Exception");
	} catch (Exception e) {
		log.info(e.getMessage());
		Assert.fail(e.getLocalizedMessage());
	}
}

@Test(priority=1, enabled=true)

public void forgotPassword() {
	try {
		
	SoftAssert sa = new SoftAssert();
		
	// Retrieving test data for valid login
	Map<String, String> validLogin = readxml.getUserData("TestData.xml", "authorized-user-1");
	String validUserId = validLogin.get("UserName");
	String invalidUserId = "hjdjfg@ff.com";

	ffHome = new FFHome(_driver);
		log.info("Test Data Used >>>>>>>");
		log.info("User Name Valid: " + validUserId);
		log.info("User Name In-Valid: " + invalidUserId);
	
	ffHome.clickSignInLink();
	
	ffHome.clickOnForgotPassword();
	
	boolean resultTemp1 = ffHome.enterEmailInForgotPasswordPopupNValidate(invalidUserId);
	
	sa.assertFalse(resultTemp1, "Error message is not displayed on entering invaid email id in Forgot Password popup");
	
	
	boolean resultTemp2 = ffHome.enterEmailInForgotPasswordPopupNValidate(validUserId);
	
	sa.assertFalse(resultTemp2, "Something went wrong while getting Password from Forgot password popup");
	
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
