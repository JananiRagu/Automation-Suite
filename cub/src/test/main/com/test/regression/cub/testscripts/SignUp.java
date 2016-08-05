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
import com.test.regression.cub.utils.*;


public class SignUp extends SuiteBase{
	
	Logger log = Logg.createLogger();
	ReadXML readxml = new ReadXML();
	CubHome cubHome;
	SignUpPage signUpPage;
	WeeklyAdPage waObj;
	ShoppingListPage slObj;
	MyAccountPage map;
	CouponPage cp;

	@Test(priority=3, enabled=false)
	public void validSignUp_noCard(){
		try{
		// Retrieving test data for valid sign up no card
				Map<String, String> validSignUpNoCard = readxml.getUserData("TestData.xml", "new-user-1");
				String userId = validSignUpNoCard.get("UserName");
				String password = validSignUpNoCard.get("password");

		
		signUpPage = new SignUpPage(_driver);
		
		log.info("Test Data Used >>>>>>>");
		log.info("User Name : " + userId);
		log.info("Password : " + password);
		
		signUpPage.clickSignUpLink();
		signUpPage.enterSignUpDetails(userId,password);
			
		signUpPage.clickDontWantCardRadio();
			
		signUpPage.clickContinueButton();
		
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

	@Test(priority=4, enabled=false)
	public void validSignUp_yesIHaveOne(){
		
		try {
		Map<String, String> validSignUpYesIHave = readxml.getUserData("TestData.xml", "new-user-3");
		String userId = validSignUpYesIHave.get("UserName");
		String password = validSignUpYesIHave.get("password");
		String lastName = validSignUpYesIHave.get("lastname");
		String rewardsNum = validSignUpYesIHave.get("rewardsnumber");
		
		signUpPage = new SignUpPage(_driver);
		
		log.info("Test Data Used >>>>>>>");
		log.info("User Name : " + userId);
		log.info("Password : " + password);
		log.info("Last Name : " + lastName);
		log.info("Rewards Number : " + rewardsNum);
		
		signUpPage.clickSignUpLink();
		
		signUpPage.enterSignUpDetails(userId,password);
		
		signUpPage.clickYesHaveCardRadio();
		signUpPage.clickContinueButton();
		signUpPage.addRewardsCard_EnterDetails(lastName, rewardsNum);
		
		
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
	
	@Test(priority=5, enabled=false)
	public void validSignUp_noCardButWantOne(){
		
		try {
		Map<String, String> validSignUpYesIHave = readxml.getUserData("TestData.xml", "new-user-2");
		String userId = validSignUpYesIHave.get("UserName");
		String password = validSignUpYesIHave.get("password");
		String firstName = validSignUpYesIHave.get("firstname");
		String lastName = validSignUpYesIHave.get("lastname");
		String address1 = validSignUpYesIHave.get("address1");
		String address2 = validSignUpYesIHave.get("address2");
		String city = validSignUpYesIHave.get("city");
		String state = validSignUpYesIHave.get("state");
		String zip = validSignUpYesIHave.get("zipcode");
		String homePhone = validSignUpYesIHave.get("homephone");
		String mobilePhone = validSignUpYesIHave.get("mobilephone");
		String cardlessId = validSignUpYesIHave.get("cardlessid");
		
		signUpPage = new SignUpPage(_driver);
		
		log.info("Test Data Used >>>>>>>");
		log.info("User Name : " + userId);
		log.info("Password : " + password);
		
		signUpPage.clickSignUpLink();
			
		signUpPage.enterSignUpDetails(userId,password);
			
		signUpPage.clickNoButWantCardRadio();
			
		signUpPage.clickContinueButton();
		signUpPage.enterContactInformationInSignUp(firstName, lastName, address1, address2, city, state, zip, homePhone, mobilePhone, cardlessId);		
			
		signUpPage.clickUseThisAddressButton();
		
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
		
		String userId = "test@cub.com";
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
		
		cubHome = new CubHome(_driver);
		
		sa.assertTrue(cubHome.signUpPopupPresence(),"Sign Up popup is not displayed on clicking SignUp in home page header");
		
		signUpPage.clickSignInLinkInSignUpPopup();
		
		sa.assertTrue(cubHome.signInPopupPresence(),"Sign In popup is not displayed on clicking SignIn in Sign Up popup");
		
		sa.assertAll();
		
		} catch (InterruptedException ie) {
			log.info(ie.getMessage());
			Assert.fail("Caught Interrupted Exception");
		} catch (Exception e) {
			log.info(e.getMessage());
			Assert.fail(e.getLocalizedMessage());
		}
	}
	
	@Test(priority=3, enabled=false)
	public void validSignUp4mSL(){
		try{
		// Retrieving test data for valid sign up no card
				Map<String, String> validSignUpNoCard = readxml.getUserData("TestData.xml", "new-user-8");
				String userId = validSignUpNoCard.get("UserName");
				String password = validSignUpNoCard.get("password");

		
		cubHome = new CubHome(_driver);
		
		log.info("Test Data Used >>>>>>>");
		log.info("User Name : " + userId);
		log.info("Password : " + password);
		
		cubHome.clickWeeklyAdTile();
		waObj = new WeeklyAdPage(_driver);
		waObj.clickOnCreateListButton();
		
		slObj = new ShoppingListPage(_driver);
		slObj.clickSignUpInSLWidget();
		
		signUpPage = new SignUpPage(_driver);
		signUpPage.enterSignUpDetails(userId,password);
			
		signUpPage.clickDontWantCardRadio();
			
		signUpPage.clickContinueButton();
		
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
	
	/*@Test(priority=3, enabled=true)
	public void validSignUp4mCouponsPage(){
		try{
		// Retrieving test data for valid sign up no card
				Map<String, String> validSignUpNoCard = readxml.getUserData("TestData.xml", "new-user-9");
				String userId = validSignUpNoCard.get("UserName");
				String password = validSignUpNoCard.get("password");

				cp = new CouponPage(_driver);
				
				try{
					//cubHome.clickCouponTile(_driver);	
					cp.clickOnCouponsInMyToolsHomePage(_driver);

					//cp.loadCompleteCouponsPage(_driver);
						//log.info("Coupons Page is loaded fully");
				
				
				cp.addSingleCoupon(_driver, "1");
				
		cubHome = new CubHome(_driver);
		
		cubHome.clickSignUpLinkInSignInPopup();
		
		signUpPage = new SignUpPage(_driver);
		
		Thread.sleep(5000);
		
		signUpPage.enterSignUpDetails(userId,password);
		Thread.sleep(5000);
		signUpPage.clickDontWantCardRadio();
			
		signUpPage.clickContinueButton();
		}catch(UnhandledAlertException al){
			_driver.switchTo().alert().accept();
			Thread.sleep(5000);
		}
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
		
	}*/
	
	@Test(priority=5, enabled=false)
	public void signUp_validateContactInfoPopup(){
		
		try {
			Map<String, String> Data = readxml.getUserData("TestData.xml", "user-to-update-contact-info");
			Map<String, String> UserData = readxml.getUserData("TestData.xml", "new-user-10");
			
			String userId = UserData.get("UserName");
			String Pwd = UserData.get("password");
			String firstname = Data.get("firstname");
			String firstNameNumber = Data.get("firstnamenumbers");
			String firstNameSpecialCharacters = Data.get("firstnamespecialCharacters");
			String lastName = Data.get("lastname");
			String lastNameNumber = Data.get("lastnamenumbers");
			String lastNameSpecialCharacters = Data.get("lastnamespecialCharacters");
			String address1 = Data.get("address1");
			
			String address2 = Data.get("address2");
			String city = Data.get("city");
			String citynumber = Data.get("citynumber");
			String cityspecialchar = Data.get("cityspecialchar");	
			String state = Data.get("state");
			String zip = Data.get("zipcode");
			String zipcodespace = Data.get("zipcodespace");
			String zipcodealphabets = Data.get("zipcodealphabets");
			String zipcodespecialchar = Data.get("zipcodespecialchar");
			String zipcodelessdigits = Data.get("zipcodelessdigits");
			String homePhone = Data.get("homephone");
			String homePhoneAlphabets = Data.get("homephonealphabets");
			String homePhoneSpace = Data.get("homephonespace");
			String homePhoneSpecialChar = Data.get("homephonespecialchar");
			String mobilePhone = Data.get("mobilephone");
			String mobileAlphabets = Data.get("mobilephonealphabets");
			String mobileSpace = Data.get("mobilephonespace");
			String mobileSplChar = Data.get("mobilephonespecialchar");
			String nullVariable = "";
			
			signUpPage = new SignUpPage(_driver);
			
			log.info("Test Data Used >>>>>>>");
			log.info("User Name : " + userId);
			log.info("Password : " + Pwd);
			
			signUpPage.clickSignUpLink();
				
			signUpPage.enterSignUpDetails(userId,Pwd);
				
			signUpPage.clickNoButWantCardRadio();
				
			signUpPage.clickContinueButton();
			
			map = new MyAccountPage(_driver);
			
			map.enterContactInformation(firstNameNumber, lastName, address1, address2, city, state, zip, homePhone, mobilePhone);
		
			Thread.sleep(5000);
					
			SoftAssert sa = new SoftAssert();
			
	        boolean result1 =map.isContinueBtnInUpdateContactInfoDisabled();
		    //sa.assertFalse(result1);
		    sa.assertTrue(result1, "\n Failed for FirstName with Numbers");
			
			log.info("Checking for Error is displayed when user enters FirstName with Special Characters");
			map.enterContactInformation(firstNameSpecialCharacters, lastName, address1, address2, city, state, zip, homePhone, mobilePhone);
		
			Thread.sleep(5000);
					
	        boolean result2 =map.isContinueBtnInUpdateContactInfoDisabled();
		    sa.assertTrue(result2, "\n Failed for FirstName with Special Characters");
			

			log.info("Checking for Error is displayed when user doesnot enter FirstName");
			map.enterContactInformation(nullVariable, lastName, address1, address2, city, state, zip, homePhone, mobilePhone);
		
			Thread.sleep(5000);
					
	        boolean result3 =map.isContinueBtnInUpdateContactInfoDisabled();
		    sa.assertTrue(result3, "\n Failed for No FirstName Entered");
		    
		    log.info("Checking for Error is displayed when user enters LastName with Special Characters");
		    map.enterContactInformation(firstname, lastNameSpecialCharacters, address1, address2, city, state, zip, homePhone, mobilePhone);
		    map.isContinueBtnInUpdateContactInfoDisabled();
			Thread.sleep(5000);
					
	        boolean result4 = map.isContinueBtnInUpdateContactInfoDisabled();
		    sa.assertTrue(result4, "\n Failed for LastName with Special Characters");
		    
		    
			log.info("Checking for Error is displayed when user enters LastName with Numbers");
			map.enterContactInformation(firstname, lastNameNumber, address1, address2, city, state, zip, homePhone, mobilePhone);
			map.isContinueBtnInUpdateContactInfoDisabled();
			Thread.sleep(5000);
					
	        boolean result5 = map.isContinueBtnInUpdateContactInfoDisabled();
	         sa.assertTrue(result5, "\n Failed for LastName with Numbers");
				

			log.info("Checking for Error is displayed when user doesnot enter LastName");
			map.enterContactInformation(firstname, nullVariable, address1, address2, city, state, zip, homePhone, mobilePhone);
			map.isContinueBtnInUpdateContactInfoDisabled();
			Thread.sleep(5000);
					
	        boolean result6 = map.isContinueBtnInUpdateContactInfoDisabled();
	        sa.assertTrue(result6, "\n Failed for No LastName Entered");
	        
	        log.info("Checking for Error is displayed when user enters ZIP with Special Characters");
	        map.enterContactInformation(firstname, lastName, address1, address2, city, state, zipcodespecialchar, homePhone, mobilePhone);
		
			Thread.sleep(5000);
					
	        boolean result7 =map.isContinueBtnInUpdateContactInfoDisabled();
		    sa.assertTrue(result7, "\n Failed for ZIP with Special Characters");
		    
		    
			log.info("Checking for Error is displayed when user enters ZIP with alphabets");
			map.enterContactInformation(firstname, lastName, address1, address2, city, state, zipcodealphabets, homePhone, mobilePhone);
		
			Thread.sleep(5000);
					
			
	        boolean result8 =map.isContinueBtnInUpdateContactInfoDisabled();
		    sa.assertTrue(result8, "\n Failed for ZIP with alphabets");
					
		    
		  	log.info("Checking for Error is displayed when user enters ZIP with space");
		  	map.enterContactInformation(firstname, lastName, address1, address2, city, state, zipcodespace, homePhone, mobilePhone);
		
		  	Thread.sleep(5000);
		  				
		   boolean result9 =map.isContinueBtnInUpdateContactInfoDisabled();
		  	sa.assertTrue(result9, "\n Failed for ZIP with Space");
		  	  

			log.info("Checking for Error is displayed when user doesnot enter ZIP");
			map.enterContactInformation(firstname, lastName, address1, address2, city, state, nullVariable, homePhone, mobilePhone);
		
			Thread.sleep(5000);
					
	        boolean result10 =map.isContinueBtnInUpdateContactInfoDisabled();
		    sa.assertTrue(result10, "Failed for No ZIP Entered");
		  	
			
		    log.info("Checking for Error is displayed when user enters less than 5 digits in  ZIP code feild");
		    map.enterContactInformation(firstname, lastName, address1, address2, city, state, zipcodelessdigits, homePhone, mobilePhone);
		
			Thread.sleep(5000);
					
	        boolean result11 =map.isContinueBtnInUpdateContactInfoDisabled();
		    sa.assertTrue(result11, "Failed when user enters less than 5 digits in  ZIP code feild");
		  	
		    log.info("Checking for Error is displayed when user enters CITY with Special Characters");
		    map.enterContactInformation(firstname, lastName, address1, address2, cityspecialchar, state, zip, homePhone, mobilePhone);
		
			Thread.sleep(5000);
					
	        boolean result12 =map.isContinueBtnInUpdateContactInfoDisabled();
		    sa.assertTrue(result12, "\n Failed for CITY with Special Characters");
		    
		  
		    log.info("Checking for Error is displayed when user enters CITY with numbers");
		    map.enterContactInformation(firstname, lastName, address1, address2, citynumber, state, zip, homePhone, mobilePhone);

		  	Thread.sleep(5000);
		  				
		   boolean result13 =map.isContinueBtnInUpdateContactInfoDisabled();
		  	sa.assertTrue(result13, "\n Failed for  CITY with numbers");
		  	    

			log.info("Checking for Error is displayed when user doesnot enter City");
			map.enterContactInformation(firstname, lastName, address1, address2, nullVariable, state, zip, homePhone, mobilePhone);
		
			Thread.sleep(5000);
					
	        boolean result14 =map.isContinueBtnInUpdateContactInfoDisabled();
		    sa.assertTrue(result14, "\n Failed for No LastName Entered");
		    
		    log.info("Checking for Error is displayed when user enters Mobile Number with Space");
		    map.enterContactInformation(firstname, lastName, address1, address2, city, state, zip, homePhone, mobileSpace);
		 
		  	Thread.sleep(5000);
		  				
		   boolean result15 =map.isUpdateContactInfoPopUpPresent();
		  	sa.assertTrue(result15, "\n Failed for Mobile Number with Space");
			

			log.info("Checking for Error is displayed when user enters Mobile Number with Special Characters");
			map.enterContactInformation(firstname, lastName, address1, address2, city, state, zip, homePhone, mobileSplChar);
			
			Thread.sleep(5000);
					
	        boolean result16 =map.isUpdateContactInfoPopUpPresent();
		    sa.assertTrue(result16, "\n Failed for Mobile Number with Special Characters");
		    
		  
		    log.info("Checking for Error is displayed when user enters Mobile Number with Alphabets");
		    map.enterContactInformation(firstname, lastName, address1, address2, city, state, zip, homePhone, mobileAlphabets);
		 
		  	Thread.sleep(5000);
		  				
		   boolean result17 =map.isUpdateContactInfoPopUpPresent();
		  	sa.assertTrue(result17, "\n Failed for Mobile Number with Alphabets");
		  	
		  	 log.info("Checking for Error is displayed when user enters Home Phone Number with Space");
		  	map.enterContactInformation(firstname, lastName, address1, address2, city, state, zip, homePhoneSpace, mobilePhone);
			 
			  	Thread.sleep(5000);
			  				
			   boolean result18 =map.isUpdateContactInfoPopUpPresent();
			  	sa.assertTrue(result18, "\n Failed for Home Phone  Number with Space");
				

				log.info("Checking for Error is displayed when user enters hNumber with Special Characters");
				map.enterContactInformation(firstname, lastName, address1, address2, city, state, zip, homePhoneSpecialChar, mobilePhone);
				
				Thread.sleep(5000);
						
		        boolean result19 =map.isUpdateContactInfoPopUpPresent();
			    sa.assertTrue(result19, "\n Failed for Home Phone  Number with Special Characters");
			    
			  
			    log.info("Checking for Error is displayed when user enters Home Phone  Number with Alphabets");
			    map.enterContactInformation(firstname, lastName, address1, address2, city, state, zip, homePhoneAlphabets, mobilePhone);

			  	Thread.sleep(5000);
			  				
			   boolean result20 =map.isUpdateContactInfoPopUpPresent();
			  	sa.assertTrue(result20, "\n Failed for Home Phone  Number with Alphabets");
			  	
			  	log.info("Checking for Error is displayed when user doesnot enter Home Address");
			  	map.enterContactInformation(firstname, lastName, nullVariable, address2, city, state, zip, homePhone, mobilePhone);

				Thread.sleep(5000);
						
		        boolean result21 =map.isContinueBtnInUpdateContactInfoDisabled();
			    sa.assertTrue(result21, "\n Failed for No Address Entered");
		    
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
