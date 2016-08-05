package com.test.regression.cub.testscripts;

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

import com.test.regression.cub.pages.CouponPage;
import com.test.regression.cub.pages.CubHome;
import com.test.regression.cub.pages.MyAccountPage;
import com.test.regression.cub.pages.ShoppingListPage;
import com.test.regression.cub.pages.SignUpPage;
import com.test.regression.cub.pages.WeeklyAdPage;
import com.test.regression.cub.utils.Logg;
import com.test.regression.cub.utils.ReadXML;
import com.test.regression.cub.utils.SuiteBase;

public class SignIn extends SuiteBase {

	CubHome cubHome;
	
	MyAccountPage map;
	WeeklyAdPage waObj;
	ShoppingListPage slObj;
	CouponPage cp;
	Logger log = Logg.createLogger();
	ReadXML readxml = new ReadXML();

	@Test(priority=1, enabled=false)
	
	public void validLogin() {
		try {
			
		// Retrieving test data for valid login
		Map<String, String> validLogin = readxml.getUserData("TestData.xml", "authorized-user-1");
		String userId = validLogin.get("UserName");
		String password = validLogin.get("password");

		cubHome = new CubHome(_driver);
			log.info("Test Data Used >>>>>>>");
			log.info("User Name : " + userId);
			log.info("Password : " + password);
		
		cubHome.clickSignInLink();
		
		cubHome.enterLoginDetails(userId, password);

		cubHome.clickSignInButton();
		
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
	
	@Test(priority=2,enabled=false) 
	  public void inValidLogin(){
		
		try {
		// Retrieving test data for valid login
		Map<String, String> invalidLogin = readxml.getUserData("TestData.xml", "invalid-user-1");
		String userId = invalidLogin.get("UserName");
		String password = invalidLogin.get("password");

		cubHome = new CubHome(_driver);
		
			log.info("Test Data Used >>>>>>>");
			log.info("User Name" + userId);
			log.info("Password" + password);
			
		cubHome.clickSignInLink();
			
		cubHome.enterLoginDetails(userId, password);
			
		cubHome.clickSignInButton();
		
		Assert.assertTrue(cubHome.isPasswordIncorrectTextPresent());
	
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
	
	@Test(priority=3,enabled=false) 
	  public void userNameNPasswordFieldValidation(){
		
		try {
			SoftAssert sa = new SoftAssert();
		
		String userIdWithSpace ="test test"; 
		String passwordLessThan6 = "12345";

		cubHome = new CubHome(_driver);
		
			log.info("Test Data Used >>>>>>>");
			log.info("User Name" + userIdWithSpace);
			log.info("Password" + passwordLessThan6);
			
		cubHome.clickSignInLink();
			
		cubHome.enterLoginDetails(userIdWithSpace, passwordLessThan6);
			
		cubHome.clickSignInButton();
		
		sa.assertTrue(cubHome.isPasswordIncorrectTextPresent(), "User Name and Password field validation for userIdWithSpace and passwordLessThan6 failed..");
		
		String userIdWithNumbers ="7894632"; 
		String password = "12345";

		//cubHome = new CubHome(_driver);
		
			log.info("Test Data Used >>>>>>>");
			log.info("User Name" + userIdWithNumbers);
			log.info("Password" + password);
			
		//cubHome.clickSignInLink();
			
		cubHome.enterLoginDetails(userIdWithNumbers, password);
			
		cubHome.clickSignInButton();
		
		sa.assertTrue(cubHome.isPasswordIncorrectTextPresent(), "User Name and Password field validation for userIdWithNumbers failed..");
		
		cubHome.clickOnClosePopUp();
		
		cubHome.clickSignInLink();
		
		sa.assertTrue(cubHome.isSignInPopupPresent(), "Unable to close SignIn popup..");
	
		sa.assertAll();
		} catch (InterruptedException ie) {
			log.info(ie.getMessage());
			Assert.fail("Caught Interrupted Exception");
		} catch (Exception e) {
			log.info(e.getMessage());
			Assert.fail(e.getLocalizedMessage());
		}
	 
	}
	
@Test(priority=4, enabled=false)
	
	public void validLoginFromShoppingListPage() {
		try {
			
		// Retrieving test data for valid login
		Map<String, String> validLogin = readxml.getUserData("TestData.xml", "authorized-user-1");
		String userId = validLogin.get("UserName");
		String password = validLogin.get("password");

		cubHome = new CubHome(_driver);
			log.info("Test Data Used >>>>>>>");
			log.info("User Name : " + userId);
			log.info("Password : " + password);
		
		cubHome.clickWeeklyAdTile();
		waObj = new WeeklyAdPage(_driver);
		waObj.clickOnCreateListButton();
		
		slObj = new ShoppingListPage(_driver);
		slObj.clickSignInInSLWidget();
		
		cubHome.enterLoginDetails(userId, password);

		cubHome.clickSignInButton();
		
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



@Test(priority=5, enabled=false)

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
			//cubHome.clickCouponTile(_driver);	
			cp.clickOnCouponsInMyToolsHomePage(_driver);

			//cp.loadCompleteCouponsPage(_driver);
				//log.info("Coupons Page is loaded fully");
		}catch(UnhandledAlertException al){
			_driver.switchTo().alert().accept();
		}
		
		cp.addSingleCoupon(_driver, "1");
	
		cubHome = new CubHome(_driver);
	cubHome.enterLoginDetails(userId, password);

	cubHome.clickSignInButton();
	
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

@Test(priority=5, enabled=false)
public void validateSignUpLinkInSignInPopup(){
	
	try {
		SoftAssert sa = new SoftAssert();
	
	cubHome = new CubHome(_driver);
	cubHome.clickSignInLink();
	
	sa.assertTrue(cubHome.signInPopupPresence(),"Sign In popup is not displayed on clicking SignIn in home page header");
	
	cubHome.clickSignUpLinkInSignInPopup();
	
	sa.assertTrue(cubHome.signInPopupPresence(),"Sign Up popup is not displayed on clicking SignUp in Sign In popup");
	
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
	String invalidUserId = "hjdjfg@cub.com";

	cubHome = new CubHome(_driver);
		log.info("Test Data Used >>>>>>>");
		log.info("User Name Valid: " + validUserId);
		log.info("User Name In-Valid: " + invalidUserId);
	
	cubHome.clickSignInLink();
	
	cubHome.clickOnForgotPassword();
	
	boolean resultTemp1 = cubHome.enterEmailInForgotPasswordPopupNValidate(invalidUserId);
	
	sa.assertFalse(resultTemp1, "Error message is not displayed on entering invaid email id in Forgot Password popup");
	
	
	boolean resultTemp2 = cubHome.enterEmailInForgotPasswordPopupNValidate(validUserId);
	
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
