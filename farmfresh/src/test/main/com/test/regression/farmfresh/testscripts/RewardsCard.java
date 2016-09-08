package com.test.regression.farmfresh.testscripts;

import java.io.IOException;
import java.rmi.server.SocketSecurityException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.apache.log4j.Logger;
import org.apache.poi.ddf.EscherColorRef.SysIndexSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.xml.sax.SAXException;

import com.test.regression.farmfresh.pages.CommuPrefPage;
import com.test.regression.farmfresh.pages.FFHome;
import com.test.regression.farmfresh.pages.FindAStorePage;
import com.test.regression.farmfresh.pages.MyAccountPage;
import com.test.regression.farmfresh.pages.RewardsCardPage;
import com.test.regression.farmfresh.pages.SignUpPage;
import com.test.regression.farmfresh.utils.Logg;
import com.test.regression.farmfresh.utils.ReadXML;
import com.test.regression.farmfresh.utils.SuiteBase;

public class RewardsCard extends SuiteBase 
{
	FFHome cubHome;
	MyAccountPage myAccount;
	SignUpPage signUpPage;
	CommuPrefPage cp;
	RewardsCardPage rc;
	FindAStorePage findastore;

	Logger log = Logg.createLogger();
	ReadXML readxml = new ReadXML();
	
	@Test(priority=70,enabled=true)
	public void RequestNewCardnRemove() 
	{
		try{
		// Retrieving test data for valid sign up no card
			Map<String, String> EnterDetails = readxml.getUserData("TestData.xml", "new-user-12");
			
				String userId = EnterDetails.get("UserName");
				String password = EnterDetails.get("password");
				String firstName = EnterDetails.get("firstname");
				String lastName = EnterDetails.get("lastname");
				String address1 = EnterDetails.get("address1");
				String address2 = EnterDetails.get("address2");
				String city = EnterDetails.get("city");
				String state = EnterDetails.get("state");
				String zip = EnterDetails.get("zipcode");
				String homePhone = EnterDetails.get("homephone");
				String mobilePhone = EnterDetails.get("mobilephone");
		
		signUpPage = new SignUpPage(_driver);
		log.info("User Name : " + userId);
		log.info("Password : " + password);
		
		signUpPage.clickSignUpLink();
		signUpPage.enterSignUpDetails(userId,password);
		signUpPage.clickDontWantCardRadio();
		signUpPage.clickContinueButton();
		
	   cp = new CommuPrefPage(_driver);
		cp.clickOnMyAccountUnderMyTools(_driver);
		
		rc = new RewardsCardPage(_driver);			
		rc.clickRequstNewCard();
		
		myAccount = new MyAccountPage(_driver);
		myAccount.enterContactInformation(firstName, lastName, address1, address2, city, state, zip, homePhone, mobilePhone);
		myAccount.clickContinueButtonInUpdateContactInfoPopUp();
		Thread.sleep(5000);
		myAccount.clickUseThisAddressButton();
		Thread.sleep(5000);
		myAccount.clickOnClosePopUp();
		Thread.sleep(5000);
		myAccount.clickeditonmystore();
 
		    findastore = new FindAStorePage(_driver);
		  
		    findastore.enterzip(zip);
		    findastore.clickOnSearch();
		    Thread.sleep(5000);
		    findastore.clickOnStore();
		    Thread.sleep(5000);
		    findastore.clickOnusestore();
		
	   String cardNumber=rc.getCardNo();
	   System.out.println("CardNumber added to user :" +cardNumber);
	   
	   rc.clickRemoveCard();
	   rc.clickCancel();
	   Thread.sleep(5000);
	   rc.clickRemoveCard();
	   rc.clickRemove();
	   
	   rc.clickRequstNewCard();
	   myAccount.clickOnClosePopUp();
	   System.out.println("Card Removed successfully from user account " );
		
	   
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
	
	@Test(priority=71,enabled=true)
	public void AddCardlessIdnUpdate() 
	{
		try{
		// Retrieving test data for valid sign up no card
			
				Map<String, String> CardlessId = readxml.getUserData("TestData.xml", "new-user-14");
				String userId = CardlessId.get("UserName");
				String password = CardlessId.get("password");
				String cardlessNum = CardlessId.get("cardlessid");
				String cardlessNum1 = CardlessId.get("cardlessid1");
				String zip = CardlessId.get("zipcode");

				SoftAssert sa = new SoftAssert();
				
		signUpPage = new SignUpPage(_driver);
		log.info("User Name : " + userId);
		log.info("Password : " + password);
		
		signUpPage.clickSignUpLink();
		signUpPage.enterSignUpDetails(userId,password);
		signUpPage.clickDontWantCardRadio();
		signUpPage.clickContinueButton();
		
		myAccount = new MyAccountPage(_driver);
	    myAccount.clickOnMyAccountUnderMyTools(_driver);
		myAccount.clickeditonmystore();
		
		
		findastore = new FindAStorePage(_driver);
	    findastore.enterzip(zip);
	    findastore.clickOnSearch();
	    findastore.clickOnStore();
	    findastore.clickOnusestore();
	    Thread.sleep(10000);
		rc = new RewardsCardPage(_driver);	
		
		rc.clickAddCardlessId();	
		cp.clickOnClosePopUp();
		rc.clickAddCardlessId();
		rc.enterCardless(cardlessNum);
		rc.clickContinue();
		Thread.sleep(10000);
		
	   String result1=rc.getCardlessId();
	   
	   sa.assertEquals(result1, cardlessNum, "\n Failed: Cardless id info not added to User in My account Page..");
	   System.out.println("Cardless Id added to user :" +result1);
	   
	   rc.clickUpdateCardlessId();
	   rc.clickNotNow();
	   Thread.sleep(5000);
	   rc.clickUpdateCardlessId();
	   rc.enterCardless(cardlessNum1);
	   rc.clickContinue();
		Thread.sleep(10000);
		
	   String result2=rc.getCardlessId();
	   
	   sa.assertEquals(result2, cardlessNum1, "\n Failed: Cardless id info not updated in My account Page..");
	   System.out.println("Cardless Id Updated to :" +result2);
	   
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
	

	@Test(priority=72,enabled=true)
	public void AddExistingCard() 
	{
		try{
		// Retrieving test data for valid sign up no card
			
				Map<String, String> Card = readxml.getUserData("TestData.xml", "new-user-13");
				String userId = Card.get("UserName");
				String password = Card.get("password");
				String cardlessNum = Card.get("cardlessid");
				String CardNum = Card.get("rewardsnumber");
				String lastName = Card.get("lastname");
				String zip = Card.get("zipcode");

				SoftAssert sa = new SoftAssert();
				
		signUpPage = new SignUpPage(_driver);
		log.info("User Name : " + userId);
		log.info("Password : " + password);
		
		signUpPage.clickSignUpLink();
		signUpPage.enterSignUpDetails(userId,password);
		signUpPage.clickDontWantCardRadio();
		signUpPage.clickContinueButton();
		
		myAccount = new MyAccountPage(_driver);
	    myAccount.clickOnMyAccountUnderMyTools(_driver);
		myAccount.clickeditonmystore();
		
		findastore = new FindAStorePage(_driver);
	    findastore.enterzip(zip);
	    findastore.clickOnSearch();
	    Thread.sleep(5000);
	    findastore.clickOnStore();
	    Thread.sleep(5000);
	    findastore.clickOnusestore();
	    Thread.sleep(10000);
	    
		rc = new RewardsCardPage(_driver);	
		
		rc.clickAddExistingCard();
		signUpPage.addRewardsCard_EnterDetails(lastName, CardNum);
		rc.clickContinue();
		Thread.sleep(5000);
		rc.clickContinue();
		signUpPage.clickUseThisAddressButton();
		rc.clickContinue();
		   Thread.sleep(5000);
	    
	   String result2=rc.getCardNo();
	   
	   sa.assertEquals(result2, CardNum, "\n  Failed: Card not added in My account Page when user uses Card number and Last name to fetch user  data..");
	   System.out.println("Rewards Card added to user :" +result2); 
	   
	   rc.clickRemoveCard();
	   rc.clickRemove();
	   Thread.sleep(5000);
	   
		rc.clickAddExistingCard();
		signUpPage.addRewardsCard_CardlessIdLastname(lastName, cardlessNum);
		rc.clickContinue();
		Thread.sleep(5000);
		rc.clickContinue();
		signUpPage.clickUseThisAddressButton();
		rc.clickContinue();
		
	    Thread.sleep(5000);
	    		
	   String result=rc.getCardNo();
	   
	   sa.assertEquals(result, CardNum, "\n \n Failed: Card not added in My account Page when user uses Cardless Id and Last name to fetch user  data..");
	   System.out.println("Rewards Card added to user :" +result); 
	   
	   rc.clickRemoveCard();
	   rc.clickRemove();
	   Thread.sleep(5000);
	   
		rc.clickAddExistingCard();
		signUpPage.addRewardsCard_CardNumCardlesId(CardNum, cardlessNum);
		rc.clickContinue();
		Thread.sleep(10000);
		rc.clickContinue();
		signUpPage.clickUseThisAddressButton();
		rc.clickContinue();
		
	    Thread.sleep(5000);
	    		
	   String result1=rc.getCardNo();
	   
	   sa.assertEquals(result1, CardNum, "\n \n Failed: Card not added in My account Page when user uses Card number and CardlessId to fetch user  data..");
	   System.out.println("Rewards Card added to user:" +result1); 
	   
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
	

	@Test(priority=73,enabled=true)
	public void PrintTempCard() 
	{
		try{
		// Retrieving test data for valid sign up no card
			
			Map<String, String> Data = readxml.getUserData("TestData.xml", "user-to-update-contact-info");
			String userId = Data.get("UserName");
			String Pwd = Data.get("password");
			String zip = Data.get("zipcode");

			SoftAssert sa = new SoftAssert();
			
			cubHome = new FFHome(_driver);
				
			log.info("Cub Home page is launched");
			cubHome.clickSignInLink();
			cubHome.enterLoginDetails(userId, Pwd);
			cubHome.clickSignInButton();
			
			myAccount = new MyAccountPage(_driver);
					 
			myAccount.clickOnMyAccountUnderMyTools(_driver);
		myAccount.clickeditonmystore();
		
		
		findastore = new FindAStorePage(_driver);
	    findastore.enterzip(zip);
	    findastore.clickOnSearch();
	    findastore.clickOnStore();
	    findastore.clickOnusestore();
	    Thread.sleep(10000);
		rc = new RewardsCardPage(_driver);	
		 Thread.sleep(5000);
		rc.clickPrintCard();
				
		 String title=_driver.getCurrentUrl();
		    System.out.println(title);
		    sa.assertEquals(title, "https://www.cub.com/tools/temporary-card.html", "\n Failed: Print Temporary card page is not displayed");
			
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
	

	@Test(priority=73,enabled=true)
	public void  ReplaceLostCard() 
	{
		try{
		// Retrieving test data for valid sign up no card
			
			Map<String, String> Data = readxml.getUserData("TestData.xml", "user-to-update-contact-info");
			String userId = Data.get("UserName");
			String Pwd = Data.get("password");
			String firstName = Data.get("firstname");
			String lastName = Data.get("lastname");
			String address1 = Data.get("address1");
			String address2 = Data.get("address2");
			String city = Data.get("city");
			String state = Data.get("state");
			String zip = Data.get("zipcode");
			
			cubHome = new FFHome(_driver);
				
			log.info("Cub Home page is launched");
			cubHome.clickSignInLink();
			cubHome.enterLoginDetails(userId, Pwd);
			cubHome.clickSignInButton();
			
			myAccount = new MyAccountPage(_driver);
					 
			myAccount.clickOnMyAccountUnderMyTools(_driver);
		myAccount.clickeditonmystore();
		
		findastore = new FindAStorePage(_driver);
	    findastore.enterzip(zip);
	    findastore.clickOnSearch();
	    findastore.clickOnStore();
	    findastore.clickOnusestore();
	    Thread.sleep(10000);
		rc = new RewardsCardPage(_driver);	
	
		rc.clickReplaceCard();
		rc.enterDataReplaceLostCard(firstName, lastName, address1, address2, city, state, zip);
		rc.clickCancel();
  	    rc.clickReplaceCard();
		rc.enterDataReplaceLostCard(firstName, lastName, address1, address2, city, state, zip);
		rc.clickSave();
		
		boolean result = rc.isSuccessPresent();
		Assert.assertTrue(result, "\n Failed: No Success message displayed when user request for REPLACE lost card \n");
			
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
	

	@Test(priority=74,enabled=true)
	public void AddInvalidCardlessId() 
	{
		try{
		// Retrieving test data for valid sign up no card
			
				Map<String, String> CardlessId = readxml.getUserData("TestData.xml", "user-to-update-contact-info");
				String userId = CardlessId.get("UserName");
				String password = CardlessId.get("password");
				String cardlessNumAlph = CardlessId.get("cardlessidalphabets");
				String cardlessNumSplChar = CardlessId.get("cardlessidsplchar");
				String cardlessNumSpace = CardlessId.get("cardlessidspace");
				String zip = CardlessId.get("zipcode");

				SoftAssert sa = new SoftAssert();
				
				cubHome = new FFHome(_driver);
				
				log.info("Cub Home page is launched");
				cubHome.clickSignInLink();
				cubHome.enterLoginDetails(userId, password);
				cubHome.clickSignInButton();
				
		
		myAccount = new MyAccountPage(_driver);
	    myAccount.clickOnMyAccountUnderMyTools(_driver);
		myAccount.clickeditonmystore();
		
		
		findastore = new FindAStorePage(_driver);
	    findastore.enterzip(zip);
	    findastore.clickOnSearch();
	    findastore.clickOnStore();
	    findastore.clickOnusestore();
	    Thread.sleep(10000);
		rc = new RewardsCardPage(_driver);	
	    rc.clickUpdateCardlessId();
	    
	    rc.enterCardless(cardlessNumAlph);
	    boolean result1=rc.isContinueBtnDisabled();
	    sa.assertTrue(result1,  "\n Failed: Continue button is enabled even when user enters alphabets in cardless Id feild...");
		
	  rc.enterCardless(cardlessNumSplChar);
	  boolean result2=rc.isContinueBtnDisabled();
	  sa.assertTrue(result2,  "\n Failed: Continue button is enabled even when user enters Special Characters in cardless Id feild...");
	
	  rc.enterCardless(cardlessNumSpace);
	  boolean result3=rc.isContinueBtnDisabled();
	  sa.assertTrue(result3,  "\n Failed: Continue button is enabled even when user enters cardless Id with spaces...");
	
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
	
	@Test(priority=75,enabled=true)
	public void RequestNewCardInvalid() 
	{
		try{
			Map<String, String> Data = readxml.getUserData("TestData.xml", "user-to-update-contact-info");
			String userId = Data.get("UserName");
			String Pwd = Data.get("password");
			String firstName = Data.get("firstname");
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
			String mobilePhone = Data.get("mobilephone");
			String mobileAlphabets = Data.get("mobilephonealphabets");
			String mobileSpace = Data.get("mobilephonespace");
			String mobileSplChar = Data.get("mobilephonespecialchar");
			String homePhoneAlphabets = Data.get("homephonealphabets");
			String homePhoneSpace = Data.get("homephonespace");
			String homePhoneSpecialChar = Data.get("homephonespecialchar");
			
			String nullVariable = "";
		
			SoftAssert sa = new SoftAssert();
			
			cubHome = new FFHome(_driver);
			
			log.info("Cub Home page is launched");
			cubHome.clickSignInLink();
			cubHome.enterLoginDetails(userId, Pwd);
			cubHome.clickSignInButton();
			
		
	   cp = new CommuPrefPage(_driver);
		cp.clickOnMyAccountUnderMyTools(_driver);
		
			rc = new RewardsCardPage(_driver);			
			rc.clickRequstNewCard();
			
			myAccount = new MyAccountPage(_driver);	
			
		log.info("Checking for Error is displayed when user enters FirstName with Numbers");
			myAccount.enterContactInformation(firstNameNumber, lastName, address1, address2, city, state, zip, homePhone, mobilePhone);
		     boolean result1 =myAccount.isContinueBtnInUpdateContactInfoDisabled();
		    sa.assertTrue(result1, "\n Failed for FirstName with Numbers");
			
		    log.info("Checking for Error is displayed when user enters FirstName with Special Characters");
			myAccount.enterContactInformation(firstNameSpecialCharacters, lastName, address1, address2, city, state, zip, homePhone, mobilePhone);
			boolean result2 =myAccount.isContinueBtnInUpdateContactInfoDisabled();
		    sa.assertTrue(result2, "\n Failed for FirstName with Special Characters");
			

			log.info("Checking for Error is displayed when user doesnot enter FirstName");
			myAccount.enterContactInformation(nullVariable, lastName, address1, address2, city, state, zip, homePhone, mobilePhone);
		   boolean result3 =myAccount.isContinueBtnInUpdateContactInfoDisabled();
		    sa.assertTrue(result3, "\n Failed for No FirstName Entered");
		
		    
		    log.info("Checking for Error is displayed when user enters LastName with Special Characters");
			myAccount.enterContactInformation(firstName, lastNameSpecialCharacters, address1, address2, city, state, zip, homePhone, mobilePhone);
		 boolean result4 = myAccount.isContinueBtnInUpdateContactInfoDisabled();
		    sa.assertTrue(result4, "\n Failed for LastName with Special Characters");
		    
		    
			log.info("Checking for Error is displayed when user enters LastName with Numbers");
			myAccount.enterContactInformation(firstName, lastNameNumber, address1, address2, city, state, zip, homePhone, mobilePhone);
			boolean result5 = myAccount.isContinueBtnInUpdateContactInfoDisabled();
	         sa.assertTrue(result5, "\n Failed for LastName with Numbers");
				

			log.info("Checking for Error is displayed when user doesnot enter LastName");
			myAccount.enterContactInformation(firstName, nullVariable, address1, address2, city, state, zip, homePhone, mobilePhone);
			boolean result6 = myAccount.isContinueBtnInUpdateContactInfoDisabled();
	        sa.assertTrue(result6, "\n Failed for No LastName Entered");
		    
		   
			log.info("Checking for Error is displayed when user enters ZIP with Special Characters");
			myAccount.enterContactInformation(firstName, lastName, address1, address2, city, state, zipcodespecialchar, homePhone, mobilePhone);
			boolean result7 =myAccount.isContinueBtnInUpdateContactInfoDisabled();
		    sa.assertTrue(result7, "\n Failed for ZIP with Special Characters");
		    
		    
			log.info("Checking for Error is displayed when user enters ZIP with alphabets");
			myAccount.enterContactInformation(firstName, lastName, address1, address2, city, state, zipcodealphabets, homePhone, mobilePhone);
			boolean result8 =myAccount.isContinueBtnInUpdateContactInfoDisabled();
		    sa.assertTrue(result8, "\n Failed for ZIP with alphabets");
					
		    
		  	log.info("Checking for Error is displayed when user enters ZIP with space");
		  	myAccount.enterContactInformation(firstName, lastName, address1, address2, city, state, zipcodespace, homePhone, mobilePhone);
		  	boolean result9 =myAccount.isContinueBtnInUpdateContactInfoDisabled();
		  	sa.assertTrue(result9, "\n Failed for ZIP with Space");
		  	  

			log.info("Checking for Error is displayed when user doesnot enter ZIP");
			myAccount.enterContactInformation(firstName, lastName, address1, address2, city, state, nullVariable, homePhone, mobilePhone);
		   boolean result10 =myAccount.isContinueBtnInUpdateContactInfoDisabled();
		    sa.assertTrue(result10, "Failed for No ZIP Entered");
		  	
			
		    log.info("Checking for Error is displayed when user enters less than 5 digits in  ZIP code feild");
			myAccount.enterContactInformation(firstName, lastName, address1, address2, city, state, zipcodelessdigits, homePhone, mobilePhone);
			boolean result11 =myAccount.isContinueBtnInUpdateContactInfoDisabled();
		    sa.assertTrue(result11, "Failed when user enters less than 5 digits in  ZIP code feild");
			
			log.info("Checking for Error is displayed when user enters CITY with Special Characters");
			myAccount.enterContactInformation(firstName, lastName, address1, address2, cityspecialchar, state, zip, homePhone, mobilePhone);
			boolean result12 =myAccount.isContinueBtnInUpdateContactInfoDisabled();
		    sa.assertTrue(result12, "\n Failed for CITY with Special Characters");
		    
		  
		    log.info("Checking for Error is displayed when user enters CITY with numbers");
		  	myAccount.enterContactInformation(firstName, lastName, address1, address2, citynumber, state, zip, homePhone, mobilePhone);
		  	boolean result13 =myAccount.isContinueBtnInUpdateContactInfoDisabled();
		  	sa.assertTrue(result13, "\n Failed for  CITY with numbers");
		  	    

			log.info("Checking for Error is displayed when user doesnot enter City");
			myAccount.enterContactInformation(firstName, lastName, address1, address2, nullVariable, state, zip, homePhone, mobilePhone);
			boolean result14 =myAccount.isContinueBtnInUpdateContactInfoDisabled();
		    sa.assertTrue(result14, "\n Failed for No City Entered");

		    log.info("Checking for Error is displayed when user enters Mobile Number with Space");
		  	myAccount.enterContactInformation(firstName, lastName, address1, address2, city, state, zip, homePhone, mobileSpace);
		 	 myAccount.clickContinueButtonInUpdateContactInfoPopUp();
		 	 boolean result15 =myAccount.isUpdateContactInfoPopUpPresent();
		  	sa.assertTrue(result15, "\n Failed for Mobile Number with Space");
			
		  	log.info("Checking for Error is displayed when user enters Mobile Number with Special Characters");
			myAccount.enterContactInformation(firstName, lastName, address1, address2, city, state, zip, homePhone, mobileSplChar);
		 	 myAccount.clickContinueButtonInUpdateContactInfoPopUp();
		 	 boolean result16 =myAccount.isUpdateContactInfoPopUpPresent();
		    sa.assertTrue(result16, "\n Failed for Mobile Number with Special Characters");
		    
		  
		    log.info("Checking for Error is displayed when user enters Mobile Number with Alphabets");
		  	myAccount.enterContactInformation(firstName, lastName, address1, address2, city, state, zip, homePhone, mobileAlphabets);
		 	 myAccount.clickContinueButtonInUpdateContactInfoPopUp();
		 	 boolean result17 =myAccount.isUpdateContactInfoPopUpPresent();
		  	sa.assertTrue(result17, "\n Failed for Mobile Number with Alphabets");
		  		  	

		    log.info("Checking for Error is displayed when user enters Home Phone Number with Space");
		  	myAccount.enterContactInformation(firstName, lastName, address1, address2, city, state, zip, homePhoneSpace, mobilePhone);
		 	 myAccount.clickContinueButtonInUpdateContactInfoPopUp();
		 	 boolean result18 =myAccount.isUpdateContactInfoPopUpPresent();
		  	sa.assertTrue(result18, "\n Failed for Home Phone  Number with Space");
			

			log.info("Checking for Error is displayed when user enters Home Phone Number with Special Characters");
			myAccount.enterContactInformation(firstName, lastName, address1, address2, city, state, zip, homePhoneSpecialChar, mobilePhone);
		 	 myAccount.clickContinueButtonInUpdateContactInfoPopUp();
		 	 boolean result19 =myAccount.isUpdateContactInfoPopUpPresent();
		    sa.assertTrue(result19, "\n Failed for Home Phone  Number with Special Characters");
		    
		  
		    log.info("Checking for Error is displayed when user enters Home Phone  Number with Alphabets");
		  	myAccount.enterContactInformation(firstName, lastName, address1, address2, city, state, zip, homePhoneAlphabets, mobilePhone);
		 	 myAccount.clickContinueButtonInUpdateContactInfoPopUp();
		  	boolean result20 =myAccount.isUpdateContactInfoPopUpPresent();
		  	sa.assertTrue(result20, "\n Failed for Home Phone  Number with Alphabets");
		    
		  	log.info("Checking for Error is displayed when user doesnot enter Home Address");
			myAccount.enterContactInformation(firstName, lastName, nullVariable, address2, city, state, zip, homePhone, mobilePhone);
			boolean result =myAccount.isContinueBtnInUpdateContactInfoDisabled();
		    sa.assertTrue(result, "\n Failed for No Address Entered");
	   
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
	

	@Test(priority=76,enabled=true)
	public void  ReplaceLostCardInvalid() 
	{
		try{
		 Map<String, String> Data = readxml.getUserData("TestData.xml", "user-to-update-contact-info");
			String userId = Data.get("UserName");
			String Pwd = Data.get("password");
			String firstName = Data.get("firstname");
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
			String nullstate = Data.get("nostate");
			String nullVariable = "";
		
			SoftAssert sa = new SoftAssert();
			
			cubHome = new FFHome(_driver);
				
			log.info("Cub Home page is launched");
			cubHome.clickSignInLink();
			cubHome.enterLoginDetails(userId, Pwd);
			cubHome.clickSignInButton();
			
			myAccount = new MyAccountPage(_driver);
					 
			myAccount.clickOnMyAccountUnderMyTools(_driver);
		myAccount.clickeditonmystore();
		
		findastore = new FindAStorePage(_driver);
	    findastore.enterzip(zip);
	    findastore.clickOnSearch();
	    findastore.clickOnStore();
	    findastore.clickOnusestore();
	    Thread.sleep(10000);
		rc = new RewardsCardPage(_driver);	
	
		rc.clickReplaceCard();
		
		log.info("Checking for Error is displayed when user enters FirstName with Numbers");
		 rc.enterDataReplaceLostCard(firstNameNumber, lastName, address1, address2, city, state, zip);
			rc.clickSave();
			boolean result1 = rc.isErrorPresent();
			sa.assertTrue(result1, "\n Failed for FirstName with Numbers");
			
		    log.info("Checking for Error is displayed when user enters FirstName with Special Characters");
		    rc.enterDataReplaceLostCard(firstNameSpecialCharacters, lastName, address1, address2, city, state, zip);
			rc.clickSave();
			boolean result2 = rc.isErrorPresent();
			sa.assertTrue(result2, "\n Failed for FirstName with Special Characters");
			

			log.info("Checking for Error is displayed when user doesnot enter FirstName");
			rc.enterDataReplaceLostCard(nullVariable, lastName, address1, address2, city, state, zip);
			rc.clickSave();
			boolean result3 = rc.isErrorPresent();
			sa.assertTrue(result3, "\n Failed for No FirstName Entered");
		
		    
		    log.info("Checking for Error is displayed when user enters LastName with Special Characters");
			rc.enterDataReplaceLostCard(firstName, lastNameSpecialCharacters, address1, address2, city, state, zip);
			rc.clickSave();
			boolean result4 = rc.isErrorPresent();
		    sa.assertTrue(result4, "\n Failed for LastName with Special Characters");
		    
		    
			log.info("Checking for Error is displayed when user enters LastName with Numbers");
			rc.enterDataReplaceLostCard(firstName, lastNameNumber, address1, address2, city, state, zip);
			rc.clickSave();
			boolean result5 = rc.isErrorPresent();
	         sa.assertTrue(result5, "\n Failed for LastName with Numbers");
				

			log.info("Checking for Error is displayed when user doesnot enter LastName");
			rc.enterDataReplaceLostCard(firstName, nullVariable, address1, address2, city, state, zip);
			rc.clickSave();
			boolean result6 = rc.isErrorPresent();
	        sa.assertTrue(result6, "\n Failed for No LastName Entered");
		    
		   
			log.info("Checking for Error is displayed when user enters ZIP with Special Characters");
		   rc.enterDataReplaceLostCard(firstName, lastName, address1, address2, city, state, zipcodespecialchar);
		   rc.clickSave();
		   boolean result7 = rc.isErrorPresent();
		    sa.assertTrue(result7, "\n Failed for ZIP with Special Characters");
		    
		    
			log.info("Checking for Error is displayed when user enters ZIP with alphabets");
			rc.enterDataReplaceLostCard(firstName, lastName, address1, address2, city, state, zipcodealphabets);
			rc.clickSave();
			boolean result8 = rc.isErrorPresent();
		    sa.assertTrue(result8, "\n Failed for ZIP with alphabets");
					
		    
		  	log.info("Checking for Error is displayed when user enters ZIP with space");
		  	rc.enterDataReplaceLostCard(firstName, lastName, address1, address2, city, state, zipcodespace);
		  	rc.clickSave();
		  	boolean result9 = rc.isErrorPresent();
		  	sa.assertTrue(result9, "\n Failed for ZIP with Space");
		  	  

			log.info("Checking for Error is displayed when user doesnot enter ZIP");
			rc.enterDataReplaceLostCard(firstName, lastName, address1, address2, city, state, nullVariable);
			rc.clickSave();
			boolean result10 = rc.isErrorPresent();
		    sa.assertTrue(result10, "Failed for No ZIP Entered");
		  	
			
		    log.info("Checking for Error is displayed when user enters less than 5 digits in  ZIP code feild");
			rc.enterDataReplaceLostCard(firstName, lastName, address1, address2, city, state, zipcodelessdigits);
			rc.clickSave();
			boolean result11 = rc.isErrorPresent();
		    sa.assertTrue(result11, "Failed when user enters less than 5 digits in  ZIP code feild");
		  	

	log.info("Checking for Error is displayed when user enters CITY with Special Characters");
			rc.enterDataReplaceLostCard(firstName, lastName, address1, address2, cityspecialchar, state, zip);
			rc.clickSave();
			boolean result12 = rc.isErrorPresent();
		    sa.assertTrue(result12, "\n Failed for CITY with Special Characters");
		    
		  
		  log.info("Checking for Error is displayed when user enters CITY with numbers");
		  	rc.enterDataReplaceLostCard(firstName, lastName, address1, address2, citynumber, state, zip);
		  	rc.clickSave();
		  	boolean result13 = rc.isErrorPresent();
		  	sa.assertTrue(result13, "\n Failed for  CITY with numbers");
		  	    

			log.info("Checking for Error is displayed when user doesnot enter City");
			rc.enterDataReplaceLostCard(firstName, lastName, address1, address2, nullVariable, state, zip);
			rc.clickSave();
			boolean result14 = rc.isErrorPresent();
		    sa.assertTrue(result14, "\n Failed for No City Entered"); 
		
		    
			log.info("Checking for Error is displayed when user doesnot enter Home Address");
			rc.enterDataReplaceLostCard(firstName, lastName, nullVariable, address2, city, state, zip);
			rc.clickSave();
			boolean result15 = rc.isErrorPresent();
		    sa.assertTrue(result15, "\n Failed for No Address Entered");
		    

			log.info("Checking for Error is displayed when user doesnot enter Home Address");
			rc.enterDataReplaceLostCard(firstName, lastName, address1, address2, city, nullstate, zip);
			rc.clickSave();
			boolean result16 = rc.isErrorPresent();
		    sa.assertTrue(result16, "\n Failed for No Address Entered");
		    
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
	
	@Test(priority=77,enabled=true)
	public void PPLinkWhileRequestingNewCard() {
		
		try{
		// Retrieving test data for valid login
		Map<String, String> Data = readxml.getUserData("TestData.xml", "user-to-update-contact-info");
		String userId = Data.get("UserName");
		String Pwd = Data.get("password");
												
		cubHome = new FFHome(_driver);
				
		log.info("Cub Home page is launched");
		cubHome.clickSignInLink();
		cubHome.enterLoginDetails(userId, Pwd);
		cubHome.clickSignInButton();
		Thread.sleep(5000);		
		myAccount = new MyAccountPage(_driver);
			myAccount.clickOnMyAccountUnderMyTools(_driver);
		
			rc = new RewardsCardPage(_driver);	
			 Thread.sleep(5000);
			 rc.clickRequstNewCard();
	
	      myAccount.clickPrivacyPolicy();
	    Thread.sleep(5000);
	    
	    //switch to new tab
	    List<String> browserTabs = new ArrayList<String> (_driver.getWindowHandles());
	     _driver.switchTo().window(browserTabs .get(1));
	    
	    //check is it correct page opened or not (check page's title)
		String title=_driver.getTitle();
		System.out.println(title);
		Assert.assertEquals("Cub Foods - Security Privacy", title);
		log.info("Privacy Policy link in Update Contact information pop up in My Account page Navigation - Success " );
		
	    //then close tab and get back
	    _driver.close();
	    _driver.switchTo().window(browserTabs.get(0));
	    
		     	
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
	    
	@Test(priority=78,enabled=true)
	public void AddExistingCardInvalid() 
	{
		try{
		// Retrieving test data for valid sign up no card
			
				Map<String, String> Card = readxml.getUserData("TestData.xml", "user-to-update-contact-info");
				String userId = Card.get("UserName");
				String password = Card.get("password");
				String cardlessNum = Card.get("cardlessId");
				String invalidLastName = Card.get("invalidLN");
				String invalidCardNum = Card.get("invalidCN");
				String invalidCardlesId = Card.get("invalidCI");
				String CardNum = Card.get("cardNum");
				String lastName = Card.get("lastname");
				String lastNameNumber = Card.get("lastnamenumbers");
				String lastNameSpecialCharacters = Card.get("lastnamespecialCharacters");
				String CardNumAlphabets = Card.get("cardnoalphabets");
				String CardNumSpace = Card.get("cardnospace");
				String CardNumSplChar = Card.get("cardnosplchar");
				String cardlessNumlphabets = Card.get("cardlessidalphabets");
				String cardlessNumSpace = Card.get("cardlessidspace");
				String cardlessNumSplChar = Card.get("cardlessidsplchar");
				
				String zip = Card.get("zipcode");
				String nullVariable = "";

				SoftAssert sa = new SoftAssert();
				
				cubHome = new FFHome(_driver);
					
				log.info("Cub Home page is launched");
				cubHome.clickSignInLink();
				cubHome.enterLoginDetails(userId, password);
				cubHome.clickSignInButton();
				
				myAccount = new MyAccountPage(_driver);
	    myAccount.clickOnMyAccountUnderMyTools(_driver);
		myAccount.clickeditonmystore();
		
		findastore = new FindAStorePage(_driver);
	    findastore.enterzip(zip);
	    findastore.clickOnSearch();
	    Thread.sleep(5000);
	    findastore.clickOnStore();
	    Thread.sleep(5000);
	    findastore.clickOnusestore();
	    Thread.sleep(10000);
	    
		rc = new RewardsCardPage(_driver);	
		
		rc.clickAddExistingCard();
		
		signUpPage = new SignUpPage(_driver);
		
		signUpPage.addRewardsCard_EnterDetails(lastName, nullVariable);
		boolean result2=rc.isContinueBtnInAddExistngCardDisabled();
	     sa.assertTrue(result2, "\n  Failed: Continue button is enabled  when user enters only Last name while adding existing card..");
	
		signUpPage.addRewardsCard_EnterDetails(nullVariable, CardNum);
		boolean result1=rc.isContinueBtnInAddExistngCardDisabled();
		sa.assertTrue(result1, "\n  Failed: Continue button is enabled  when user enters only Card Number while adding existing card..");
		
	    signUpPage.addRewardsCard_CardlessIdLastname(nullVariable, cardlessNum);
	    boolean result=rc.isContinueBtnInAddExistngCardDisabled();
		sa.assertTrue(result, "\n  Failed: Continue button is enabled  when user enters only CardLess id while adding existing card..");
		   
		signUpPage.addRewardsCard_EnterDetails(lastName, invalidCardNum);
		rc.clickContinue();
		boolean result12=rc.isErrorPresentAddExistnCard();
	     sa.assertTrue(result12, "\n  Failed: No error displayed when user enters invalid card number and valid lastname..");
	
	     signUpPage.addRewardsCard_CardlessIdLastname(lastName, invalidCardlesId);
	     rc.clickContinue();
	       boolean result3=rc.isErrorPresentAddExistnCard();
			sa.assertTrue(result3, "\n  Failed: No error displayed when user enters invalid cardless id and valid lastname..");
			 
	     signUpPage.addRewardsCard_EnterDetails(invalidLastName, CardNum);
	     rc.clickContinue();
	    boolean result22=rc.isErrorPresentAddExistnCard();
		sa.assertTrue(result22, "\n  Failed: No error displayed when user enters invalid last name and valid  card number..");
		
		signUpPage.addRewardsCard_CardNumCardlesId(CardNum, invalidCardlesId);
		rc.clickContinue();
		boolean result6=rc.isErrorPresentAddExistnCard();
		sa.assertTrue(result6, "\n  Failed: No error displayed when user enters invalid Cardles id and valid  card number..");
		
		signUpPage.addRewardsCard_CardNumCardlesId(invalidCardNum, cardlessNum);
		rc.clickContinue();
		boolean result16=rc.isErrorPresentAddExistnCard();
		sa.assertTrue(result16, "\n  Failed: No error displayed when user enters valid Cardles id and invalid card number..");
		
		 signUpPage.addRewardsCard_CardlessIdLastname(invalidLastName, cardlessNum);
		 rc.clickContinue();
	       boolean result13=rc.isErrorPresentAddExistnCard();
			sa.assertTrue(result13, "\n  Failed: No error displayed when user enters valid cardless id and invalid lastname..");
		
			signUpPage.addRewardsCard_EnterDetails(lastNameNumber, CardNum);
			boolean result14=rc.isContinueBtnInAddExistngCardDisabled();
		     sa.assertTrue(result14, "\n  Failed: Continue button is enabled  when user enters digits in Last name feild while adding existing card..");
		    
		    signUpPage.addRewardsCard_EnterDetails(lastNameSpecialCharacters, CardNum);
			boolean result15=rc.isContinueBtnInAddExistngCardDisabled();
			 sa.assertTrue(result15, "\n  Failed: Continue button is enabled  when user enters Special characters in Last name feild while adding existing card..");
			
			 signUpPage.addRewardsCard_EnterDetails(lastName, CardNumAlphabets);
			boolean result17=rc.isContinueBtnInAddExistngCardDisabled();
			sa.assertTrue(result17, "\n  Failed: Continue button is enabled  when user enters alphabets in Card number feild while adding existing card..");
			    
			   signUpPage.addRewardsCard_EnterDetails(lastName, CardNumSplChar);
			boolean result18=rc.isContinueBtnInAddExistngCardDisabled();
			sa.assertTrue(result18, "\n  Failed: Continue button is enabled  when user enters Special characters in Card number feild while adding existing card..");
				
			signUpPage.addRewardsCard_EnterDetails(lastName, CardNumSpace);
			boolean result8=rc.isContinueBtnInAddExistngCardDisabled();
			 sa.assertTrue(result8, "\n  Failed: Continue button is enabled  when user enters Spaces in Card number feild while adding existing card..");
			
			 signUpPage.addRewardsCard_CardlessIdLastname(lastName, cardlessNumlphabets);
		       boolean result9=rc.isErrorPresentAddExistnCard();
				sa.assertTrue(result9, "\n  Failed: Continue button is enabled  when user enters alphabets in Cardles id feild while adding existing card..");
			    
		signUpPage.addRewardsCard_CardlessIdLastname(lastName, cardlessNumSplChar);
	  boolean result19=rc.isErrorPresentAddExistnCard();
		sa.assertTrue(result19, "\n  Failed: Continue button is enabled  when user enters Special Characters in Cardles id feild while adding existing card..");
				
			signUpPage.addRewardsCard_CardlessIdLastname(lastName, cardlessNumSpace);
			boolean result10=rc.isErrorPresentAddExistnCard();
			sa.assertTrue(result10, "\n  Failed: Continue button is enabled  when user enters Space in Cardles id feild while adding existing card..");
					   		 
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
	
	
	@Test(priority=80,enabled=true)
	public void MultipleUsersSingleCard() 
	{
		try{
		// Retrieving test data for valid sign up no card
			
				Map<String, String> Card = readxml.getUserData("TestData.xml", "new-user-15");
				String userId = Card.get("UserName");
				String password = Card.get("password");
				String CardNum = Card.get("rewardsnumber");
				String lastName = Card.get("lastname");
				String zip = Card.get("zipcode");
				
				Map<String, String> Data = readxml.getUserData("TestData.xml", "user-to-update-contact-info");
				String userId1 = Data.get("UserName");
				String Pwd = Data.get("password");
			
				String zip1 = Data.get("zipcode");
			
				String firstName1 = Data.get("firstname1");
				String lastName1 = Data.get("lastname");
				String address11 = Data.get("address11");
				String address21 = Data.get("address21");
				String city1 = Data.get("city1");
				String state1 = Data.get("state1");
				String homePhone1 = Data.get("homephone1");
				String mobilePhone1 = Data.get("mobilephone1");
				
				String firstName = Data.get("firstname");
				String address1 = Data.get("address1");
				String address2 = Data.get("address2");
				String city = Data.get("city");
				String state = Data.get("state1");
				String homePhone = Data.get("homephone");
				String mobilePhone = Data.get("mobilephone");

				SoftAssert sa = new SoftAssert();
				
		signUpPage = new SignUpPage(_driver);
		log.info("User Name : " + userId);
		log.info("Password : " + password);
		
		signUpPage.clickSignUpLink();
		signUpPage.enterSignUpDetails(userId,password);
		signUpPage.clickDontWantCardRadio();
		signUpPage.clickContinueButton();
		
		myAccount = new MyAccountPage(_driver);
	    myAccount.clickOnMyAccountUnderMyTools(_driver);
		myAccount.clickeditonmystore();
		
		findastore = new FindAStorePage(_driver);
	    findastore.enterzip(zip);
	    findastore.clickOnSearch();
	    Thread.sleep(5000);
	    findastore.clickOnStore();
	    Thread.sleep(5000);
	    findastore.clickOnusestore();
	    Thread.sleep(10000);
	    
		rc = new RewardsCardPage(_driver);	
		
		rc.clickAddExistingCard();
		signUpPage.addRewardsCard_EnterDetails(lastName, CardNum);
		rc.clickContinue();
		Thread.sleep(5000);
		rc.clickContinue();
		signUpPage.clickUseThisAddressButton();
		Thread.sleep(5000);
		rc.clickContinue();
		   Thread.sleep(5000);
	    
	   String result2=rc.getCardNo();
	   
	   sa.assertEquals(result2, CardNum, "\n  Failed: Card not added in My account Page when user uses Card number and Last name to fetch user  data..");
	   System.out.println("Rewards Card added to user :" +result2); 
	  
	   cubHome = new FFHome(_driver);
		cubHome.clickOnLogOutLink();
		
		cubHome.clickSignInLink();
		cubHome.enterLoginDetails(userId1, Pwd);
		cubHome.clickSignInButton();
				 
		myAccount.clickOnMyAccountUnderMyTools(_driver);
	myAccount.clickeditonmystore();
	
    findastore.enterzip(zip);
    findastore.clickOnSearch();
    findastore.clickOnStore();
    findastore.clickOnusestore();
    Thread.sleep(10000);

    rc.clickAddExistingCard();
    signUpPage.addRewardsCard_EnterDetails(lastName, CardNum);
	rc.clickContinue();
	Thread.sleep(5000);
	myAccount.enterContactInformation(firstName1, lastName1, address11, address21, city1, state1, zip1, homePhone1, mobilePhone1);
	rc.clickContinue();
	Thread.sleep(5000);
	signUpPage.clickUseThisAddressButton();
	Thread.sleep(5000);
	rc.clickContinue();
	 Thread.sleep(5000);
    
	 String result12=rc.getCardNo();
	   
	   sa.assertEquals(result12, CardNum, "\n  Failed: Card not added in My account Page when user uses Card number and Last name to fetch user  data..");
	   System.out.println("Rewards Card added to user :" +result2); 
	   
	   String userData=myAccount.getUserData();
		
		List<String> completeUserData = Arrays.asList(userData.split("\n"));
		String temp = completeUserData.get(0);
		List<String> nameData = Arrays.asList(temp.split("\\s"));
		
		boolean result= firstName1.equalsIgnoreCase(nameData.get(0));
		System.out.println(result);
		sa.assertTrue(result, "\n Failed: contact information not updated ");
		
		cubHome.clickOnLogOutLink();
		
		cubHome.clickSignInLink();
		cubHome.enterLoginDetails(userId, password);
		cubHome.clickSignInButton();		 
		myAccount.clickOnMyAccountUnderMyTools(_driver);
		 String userData1=myAccount.getUserData();
			
			List<String> completeUserData1 = Arrays.asList(userData1.split("\n"));
			String temp1 = completeUserData1.get(0);
			List<String> nameData1 = Arrays.asList(temp1.split("\\s"));
			
			boolean result1= firstName1.equalsIgnoreCase(nameData1.get(0));
			System.out.println(result1);
			sa.assertTrue(result1, "\n Failed: contact information not updated  ");
			
			 myAccount.clickEditLinkToUpdateContactInfo();
				Thread.sleep(5000);
				myAccount.enterContactInformation(firstName, lastName, address1, address2, city, state, zip, homePhone, mobilePhone);
				myAccount.clickContinueButtonInUpdateContactInfoPopUp();
				Thread.sleep(5000);
				myAccount.clickUseThisAddressButton();
				Thread.sleep(5000);
				String userData2=myAccount.getUserData();
				
				List<String> completeUserData2 = Arrays.asList(userData2.split("\n"));
				String temp2 = completeUserData2.get(0);
				List<String> nameData2 = Arrays.asList(temp2.split("\\s"));
				
				boolean result3= firstName.equalsIgnoreCase(nameData2.get(0));
				System.out.println(result3);
				sa.assertTrue(result3, "\n Failed: contact information not updated  ");
				
			cubHome.clickOnLogOutLink();
			
			cubHome.clickSignInLink();
			cubHome.enterLoginDetails(userId1, Pwd); 
			cubHome.clickSignInButton();		 
			myAccount.clickOnMyAccountUnderMyTools(_driver);
			 String userData11=myAccount.getUserData();
				
				List<String> completeUserData11 = Arrays.asList(userData11.split("\n"));
				String temp11 = completeUserData11.get(0);
				List<String> nameData11 = Arrays.asList(temp11.split("\\s"));
				
				boolean result11= firstName.equalsIgnoreCase(nameData11.get(0));
				System.out.println(result11);
				sa.assertTrue(result11, "\n Failed: contact information not updated  ");
				
				rc.clickRemoveCard();
				   rc.clickRemove();
				   cubHome.clickOnLogOutLink(); 
				   
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

