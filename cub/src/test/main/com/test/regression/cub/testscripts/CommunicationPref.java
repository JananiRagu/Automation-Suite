package com.test.regression.cub.testscripts;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.xml.sax.SAXException;

import com.test.regression.cub.pages.CommuPrefPage;
import com.test.regression.cub.pages.CubHome;
import com.test.regression.cub.pages.MyAccountPage;

import com.test.regression.cub.utils.Logg;
import com.test.regression.cub.utils.ReadXML;
import com.test.regression.cub.utils.SuiteBase;

public class CommunicationPref  extends SuiteBase
{
	CubHome cubHome;
	MyAccountPage myAccount;
	CommuPrefPage cp;
	
	Logger log = Logg.createLogger();
	ReadXML readxml = new ReadXML();
	
	@Test(priority=55,enabled=true)
	public void ChngCommPrefEmailSuccess() {
		
		try{
		// Retrieving test data for valid login
		Map<String, String> Data = readxml.getUserData("TestData.xml", "user-to-update-comm-pref");
		String userId = Data.get("UserName");
		String Pwd = Data.get("password");
		String emailid = Data.get("validemail");
												
		cubHome = new CubHome(_driver);
				
		log.info("Cub Home page is launched");
		cubHome.clickSignInLink();
		cubHome.enterLoginDetails(userId, Pwd);
		cubHome.clickSignInButton();
		Thread.sleep(5000);		
		cp = new CommuPrefPage(_driver);
		cp.clickOnMyAccountUnderMyTools(_driver);
		 cp.clickEditCommunicationPref();
		 cp.clickOnClosePopUp();
		 cp.clickEditCommunicationPref();
	    
	    cp.cpEnterEmail(emailid);
	    cp.cpClickSaveButtonInEditAddress();
	      
        String Email=cp.cpGetEmail();
		
        Assert.assertEquals(Email,emailid);	
				
		System.out.println("Email Info updated successfully in Communication Pref");
		log.info("Email Info updated  successfully in Communication Pref");
	       	     	
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
	

	@Test(priority=56,enabled=true)
	public void ChngCommPrefMobileSuccess() {
		
		try{
		// Retrieving test data for valid login
		Map<String, String> Data = readxml.getUserData("TestData.xml", "user-to-update-comm-pref");
		String userId = Data.get("UserName");
		String Pwd = Data.get("password");
		String SMS = Data.get("mobilephone");
												
		cubHome = new CubHome(_driver);
		
		SoftAssert sa = new SoftAssert();
				
		log.info("Cub Home page is launched");
		cubHome.clickSignInLink();
		cubHome.enterLoginDetails(userId, Pwd);
		cubHome.clickSignInButton();
		Thread.sleep(5000);		
	
		cp = new CommuPrefPage(_driver);
		cp.clickOnMyAccountUnderMyTools(_driver);
		cp.clickEditCommunicationPref();
	    
		cp.cpEnterSMS(SMS);
		cp.cpClickSaveButtonInEditAddress();
	
	     String SMS1 = cp.cpGetSMS();
	    sa.assertEquals(SMS1, SMS, "\n Mobile number not updated in Communication Pref section");
	   
	    String SMS2 = cp.cpGetMobileNo();
	    sa.assertEquals(SMS2, SMS, "\n Mobile number not updated in Contact Info Section");
	    	    
	    sa.assertEquals(SMS1, SMS2, "\n Mobile number in Communication Pref section is not matching with Mobile number in Cont Info Section");
		
	    sa.assertAll();
            			
		System.out.println("Mobile Number Info updated successfully in Communication Pref and Contact information Sections");
		log.info("Mobile Number Info updated  successfully in Communication Pref and Contact information Sections");
	       	     	
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
	
	@Test(priority=57,enabled=true)
	public void ChngCommPrefAddressSuccess() {
		
		try{
		// Retrieving test data for valid login
		Map<String, String> Data = readxml.getUserData("TestData.xml", "user-to-update-comm-pref");
		String userId = Data.get("UserName");
		String Pwd = Data.get("password");
		String firstName = Data.get("firstname");
		String lastName = Data.get("lastname");
		String address1 = Data.get("address1");
		String address2 = Data.get("address2");
		String city = Data.get("city");
		String state = Data.get("state");
		String zip = Data.get("zipcode");
												
		cubHome = new CubHome(_driver);
		
		SoftAssert sa = new SoftAssert();
		
		log.info("Cub Home page is launched");
		cubHome.clickSignInLink();
		cubHome.enterLoginDetails(userId, Pwd);
		cubHome.clickSignInButton();
		Thread.sleep(5000);		
		cp = new CommuPrefPage(_driver);
		cp.clickOnMyAccountUnderMyTools(_driver);
		cp.clickEditCommunicationPref();
		cp.cpCheckDirectMail(_driver);
		cp.cpClickLinkToUpdateMailingAddress();
	    
		cp.cpEnterAddress(firstName, lastName, address1, address2, city, state, zip);
		cp.cpClickSaveButtonInEditAddress();
		cp.clickUseThisAddressButton();
		cp.cpClickSaveButtonInEditAddress();
       
       String FN=cp.cpGetFirstName();
       
       Thread.sleep(20000);
       String userData=cp.getUserData();
		List<String> completeUserData = Arrays.asList(userData.split("\n"));
		String temp = completeUserData.get(0);
		List<String> nameData = Arrays.asList(temp.split("\\s"));
		String FirstNameData = nameData.get(0);
		
		System.out.println("Fetching First Name information from Communication Pref section\n FirstName:" + FirstNameData);

		sa.assertEquals(FN, firstName, "\n Address not updated in Communication Pref section");
		sa.assertEquals(FirstNameData, firstName, "\n Address not updated in Contact Info Section");
		sa.assertEquals(FN, FirstNameData, "\n Address in Communication Pref section is not matching with address in Cont Info Section");
				    
		    sa.assertAll();
		
	   	System.out.println("Address updated successfully in Communication Pref and Contact information Sections");
		log.info("Address updated  successfully in Communication Pref and Contact information Sections");
	       	     	
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
	

	@Test(priority=58,enabled=true)
	public void CommPrefUncheckAll()
	 {
		
		try{
		// Retrieving test data for valid login
		Map<String, String> Data = readxml.getUserData("TestData.xml", "user-to-update-comm-pref");
		String userId = Data.get("UserName");
		String Pwd = Data.get("password");
												
		cubHome = new CubHome(_driver);
		SoftAssert sa = new SoftAssert();
						
		log.info("Cub Home page is launched");
		cubHome.clickSignInLink();
		cubHome.enterLoginDetails(userId, Pwd);
		cubHome.clickSignInButton();
			
		cp = new CommuPrefPage(_driver);
		cp.clickOnMyAccountUnderMyTools(_driver);
		cp.clickEditCommunicationPref();
		cp.cpUncheckAll();
		cp.cpClickSaveButtonInEditAddress();
	       
	       Thread.sleep(20000);
	    
	  boolean result = cp.cpIsEmailNotPresent();
	    sa.assertTrue(result, "\n Failed: Email is displayed even if User Unchecks Email feild in Communication Pref Pop Up");
	    
	    boolean result1 = cp.cpIsSMSUncheck();
	    sa.assertTrue(result1, "\n Failed: Mobile Number is displayed even if User Unchecks SMS feild in Communication Pref Pop Up");
	   
	    boolean result2 = cp.cpIsDirectMailUncheck();
	    sa.assertTrue(result2, "\n Failed: Address is displayed even if User Unchecks Direct Mail feild in Communication Pref Pop Up");
        
	    sa.assertAll();
	    
		System.out.println("Unchecked all feilds successfully in Communication Pref");
		log.info("Unchecked all feilds  successfully in Communication Pref");
	       	     	
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
	

	@Test(priority=59,enabled=true)
	public void CommPrefEmailInvalid()
	 {
		
		try{
			// Retrieving test data for valid login
			Map<String, String> Data = readxml.getUserData("TestData.xml", "user-to-update-comm-pref");
			String userId = Data.get("UserName");
			String Pwd = Data.get("password");
			String email = Data.get("invalidemail");
													
			cubHome = new CubHome(_driver);
				
			log.info("Cub Home page is launched");
			cubHome.clickSignInLink();
			cubHome.enterLoginDetails(userId, Pwd);
			cubHome.clickSignInButton();
			Thread.sleep(5000);		
			cp = new CommuPrefPage(_driver);
			cp.clickOnMyAccountUnderMyTools(_driver);
			cp.clickEditCommunicationPref();
		    
			cp.cpEnterEmail(email);
		  
		    Thread.sleep(5000);
		   
		    boolean result = cp.cpIsSaveButtonInPopUpDisabled();
		    
		    Assert.assertTrue(result, " \n Failed: SAVE button is enabled  even if user enters Invalid Email \n");
		
			System.out.println("SAVE button is disabled when user enters Invalid Email Address  in Communication Pref pop up");
			log.info("SAVE button is disabled when user enters Invalid Email Address  in Communication Pref pop up");
		    	     	
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
	
	@Test(priority=60,enabled=true)
	public void CommPrefSMSInvalid()
	 {
		
	try{
			// Retrieving test data for valid login
			Map<String, String> Data = readxml.getUserData("TestData.xml", "user-to-update-comm-pref");
			String userId = Data.get("UserName");
			String Pwd = Data.get("password");
			String SMS1 = Data.get("mobilephonealphabets");
			String SMS2 = Data.get("mobilephonespace");
			String SMS3 = Data.get("mobilephonespecialchar");
															
			cubHome = new CubHome(_driver);
			
			SoftAssert sa = new SoftAssert();
					
			log.info("Cub Home page is launched");
			cubHome.clickSignInLink();
			cubHome.enterLoginDetails(userId, Pwd);
			cubHome.clickSignInButton();
			Thread.sleep(5000);		
		
			cp = new CommuPrefPage(_driver);
			cp.clickOnMyAccountUnderMyTools(_driver);
			cp.clickEditCommunicationPref();
		    
			cp.cpEnterSMS(SMS1);
			boolean result = cp.cpIsSaveButtonInPopUpDisabled();
		    sa.assertTrue(result, "\n Failed: SAVE button is enabled  even if user enters Alphabets in Mobile Number feild \n");

		    cp.cpEnterSMS(SMS2);
			boolean result1 = cp.cpIsSaveButtonInPopUpDisabled();
		    sa.assertTrue(result1, "\n Failed: SAVE button is enabled  even if user enters Mobile Number with space \n");
		    
		    cp.cpEnterSMS(SMS3);
			boolean result2 = cp.cpIsSaveButtonInPopUpDisabled();
		    sa.assertTrue(result2, "\n Failed: SAVE button is enabled  even if user enters Special Characters in Mobile Number feild \n");
		    
		    sa.assertAll();
	            			
			System.out.println("SAVE button is disabled when user enters Invalid Mobile number  in Communication Pref pop up");
			log.info("SAVE button is disabled when user enters Invalid Mobile number  in Communication Pref pop up");
	     	     	
			} 
		catch (InterruptedException ie) {
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
	
	@Test(priority=60,enabled=true)
	public void CommPrefDirectMailInvalidFN()
	 {
		
	try{

		// Retrieving test data for valid login
		Map<String, String> Data = readxml.getUserData("TestData.xml", "user-to-update-comm-pref");
		String userId = Data.get("UserName");
		String Pwd = Data.get("password");
		String fn1 = Data.get("firstnamenumbers");
		String fn2 = Data.get("firstnamespecialCharacters");
		String fn3 = "";
		String lastName = Data.get("lastname");
		String address1 = Data.get("address1");
		String address2 = Data.get("address2");
		String city = Data.get("city");
		String state = Data.get("state");
		String zip = Data.get("zipcode");
												
		cubHome = new CubHome(_driver);
		
		SoftAssert sa = new SoftAssert();
		
		log.info("Cub Home page is launched");
		cubHome.clickSignInLink();
		cubHome.enterLoginDetails(userId, Pwd);
		cubHome.clickSignInButton();
		Thread.sleep(5000);		
		cp = new CommuPrefPage(_driver);
		cp.clickOnMyAccountUnderMyTools(_driver);
		cp.clickEditCommunicationPref();
		cp.cpCheckDirectMail(_driver);
		cp.cpClickLinkToUpdateMailingAddress();
	    
		cp.cpEnterAddress(fn1, lastName, address1, address2, city, state, zip);
		boolean result1 = cp.cpIsSaveButtonInPopUpDirectMailDisabled();
		sa.assertTrue(result1, "\n Failed: SAVE button is enabled  even if user enters FirstName with digits \n");
		    
		cp.cpEnterAddress(fn2, lastName, address1, address2, city, state, zip);
		boolean result2 = cp.cpIsSaveButtonInPopUpDirectMailDisabled();
		sa.assertTrue(result2, "\n Failed: SAVE button is enabled  even if user enters Special Characters in FirstName feild \n");
		 
		cp.cpEnterAddress(fn3, lastName, address1, address2, city, state, zip);
		boolean result3 = cp.cpIsSaveButtonInPopUpDirectMailDisabled();
		sa.assertTrue(result3, "\n Failed: SAVE button is enabled  even if user enters Nothing in FirstName feild \n");
		    
		     sa.assertAll();
	            			
			System.out.println("SAVE button is disabled when user enters Invalid FirstName in Communication Pref pop up");
			log.info("SAVE button is disabled when user enters Invalid FirstName in Communication Pref pop up");
	     	     	
			} 
		catch (InterruptedException ie) {
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
	
	@Test(priority=62,enabled=true)
	public void CommPrefDirectMailInvalidLN()
	 {
		
	try{

		// Retrieving test data for valid login
		Map<String, String> Data = readxml.getUserData("TestData.xml", "user-to-update-comm-pref");
		String userId = Data.get("UserName");
		String Pwd = Data.get("password");
		String firstName = Data.get("firstname");
		String ln1 = Data.get("lastname");
		String ln2 = Data.get("lastnamespecialCharacters");
		String ln3 = "";
		String address1 = Data.get("address1");
		String address2 = Data.get("address2");
		String city = Data.get("city");
		String state = Data.get("state");
		String zip = Data.get("zipcode");
												
		cubHome = new CubHome(_driver);
		
		SoftAssert sa = new SoftAssert();
		
		log.info("Cub Home page is launched");
		cubHome.clickSignInLink();
		cubHome.enterLoginDetails(userId, Pwd);
		cubHome.clickSignInButton();
		Thread.sleep(5000);		
		cp = new CommuPrefPage(_driver);
		cp.clickOnMyAccountUnderMyTools(_driver);
		cp.clickEditCommunicationPref();
		cp.cpCheckDirectMail(_driver);
		cp.cpClickLinkToUpdateMailingAddress();
	    
		cp.cpEnterAddress(firstName, ln1, address1, address2, city, state, zip);
		boolean result1 = cp.cpIsSaveButtonInPopUpDirectMailDisabled();
		sa.assertTrue(result1, "\n Failed: SAVE button is enabled  even if user enters LastName with digits \n");
		    
		cp.cpEnterAddress(firstName, ln2, address1, address2, city, state, zip);
		boolean result2 = cp.cpIsSaveButtonInPopUpDirectMailDisabled();
		sa.assertTrue(result2, "\n Failed: SAVE button is enabled  even if user enters Special Characters in LastName feild \n");
		  
		cp.cpEnterAddress(firstName, ln3, address1, address2, city, state, zip);
		boolean result3 = cp.cpIsSaveButtonInPopUpDirectMailDisabled();
		sa.assertTrue(result3, "\n Failed: SAVE button is enabled  even if user enters Nothing in LastName feild \n");
		  
		    sa.assertAll();
	            			
			System.out.println("SAVE button is disabled when user enters Invalid LastName in Communication Pref pop up");
			log.info("SAVE button is disabled when user enters Invalid LastName in Communication Pref pop up");
	     	     	
			} 
		catch (InterruptedException ie) {
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
	
	@Test(priority=63,enabled=true)
	public void CommPrefDirectMailInvalidCity()
	 {
		
	try{

		// Retrieving test data for valid login
		Map<String, String> Data = readxml.getUserData("TestData.xml", "user-to-update-comm-pref");
		String userId = Data.get("UserName");
		String Pwd = Data.get("password");
		String firstName = Data.get("firstname");
		String lastName = Data.get("lastname");
		String address1 = Data.get("address1");
		String address2 = Data.get("address2");
		String city1 = Data.get("citynumber");
		String city2 = Data.get("cityspecialchar");
		String city3 = "";
		String state = Data.get("state");
		String zip = Data.get("zipcode");
												
		cubHome = new CubHome(_driver);
		
		SoftAssert sa = new SoftAssert();
		
		log.info("Cub Home page is launched");
		cubHome.clickSignInLink();
		cubHome.enterLoginDetails(userId, Pwd);
		cubHome.clickSignInButton();
		Thread.sleep(5000);		
		cp = new CommuPrefPage(_driver);
		cp.clickOnMyAccountUnderMyTools(_driver);
		cp.clickEditCommunicationPref();
		cp.cpCheckDirectMail(_driver);
		cp.cpClickLinkToUpdateMailingAddress();
	    
		cp.cpEnterAddress(firstName, lastName, address1, address2, city1, state, zip);
		boolean result1 = cp.cpIsSaveButtonInPopUpDirectMailDisabled();
		sa.assertTrue(result1, "\n Failed: SAVE button is enabled  even if user enters City name with digits \n");
		    
		cp.cpEnterAddress(firstName, lastName, address1, address2, city2, state, zip);
		boolean result2 = cp.cpIsSaveButtonInPopUpDirectMailDisabled();
		sa.assertTrue(result2, "\n Failed: SAVE button is enabled  even if user enters Special Characters in City feild \n");
		
		cp.cpEnterAddress(firstName, lastName, address1, address2, city3, state, zip);
		boolean result3 = cp.cpIsSaveButtonInPopUpDirectMailDisabled();
		sa.assertTrue(result3, "\n Failed: SAVE button is enabled  even if user enters Nothing in City feild \n");
		  
		  sa.assertAll();
	            			
			System.out.println("SAVE button is disabled when user enters Invalid City name in Communication Pref pop up");
			log.info("SAVE button is disabled when user enters Invalid City name in Communication Pref pop up");
	     	     	
			} 
		catch (InterruptedException ie) {
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
	
	@Test(priority=64,enabled=true)
	public void CommPrefDirectMailInvalidZIP()
	 {
		
	try{

		// Retrieving test data for valid login
		Map<String, String> Data = readxml.getUserData("TestData.xml", "user-to-update-comm-pref");
		String userId = Data.get("UserName");
		String Pwd = Data.get("password");
		String firstName = Data.get("firstname");
		String lastName = Data.get("lastname");
		String address1 = Data.get("address1");
		String address2 = Data.get("address2");
		String city = Data.get("city");
		String state = Data.get("state");
		String zip1 = Data.get("zipcodespace");
		String zip2 = Data.get("zipcodealphabets");
		String zip3 = Data.get("zipcodespecialchar");
		String zip4 = Data.get("zipcodelessdigits");
		String zip5 = "";
		
		cubHome = new CubHome(_driver);
		
		SoftAssert sa = new SoftAssert();
		
		log.info("Cub Home page is launched");
		cubHome.clickSignInLink();
		cubHome.enterLoginDetails(userId, Pwd);
		cubHome.clickSignInButton();
		Thread.sleep(5000);		
		cp = new CommuPrefPage(_driver);
		cp.clickOnMyAccountUnderMyTools(_driver);
		cp.clickEditCommunicationPref();
		cp.cpCheckDirectMail(_driver);
		cp.cpClickLinkToUpdateMailingAddress();
		
		cp.cpEnterAddress(firstName, lastName, address1, address2, city, state, zip1);
		boolean result = cp.cpIsSaveButtonInPopUpDirectMailDisabled();
		sa.assertTrue(result, "\n Failed: SAVE button is enabled  even if user uses SPACE in ZIP code feild\n");
		 	    
		cp.cpEnterAddress(firstName, lastName, address1, address2, city, state, zip2);
		boolean result1 = cp.cpIsSaveButtonInPopUpDirectMailDisabled();
		sa.assertTrue(result1, "\n Failed: SAVE button is enabled  even if user enters alphabets in ZIP code feild\n");
		    
		cp.cpEnterAddress(firstName, lastName, address1, address2, city, state, zip3);
		boolean result2 = cp.cpIsSaveButtonInPopUpDirectMailDisabled();
		sa.assertTrue(result2, "\n Failed: SAVE button is enabled  even if user enters Special Characters in ZIP code feild \n");
		 
		cp.cpEnterAddress(firstName, lastName, address1, address2, city, state, zip4);
		boolean result4 = cp.cpIsSaveButtonInPopUpDirectMailDisabled();
		sa.assertTrue(result4, "\n Failed: SAVE button is enabled  even if user enters less than 5 digits in  ZIP code feild \n");
		
		cp.cpEnterAddress(firstName, lastName, address1, address2, city, state, zip5);
		boolean result3 = cp.cpIsSaveButtonInPopUpDirectMailDisabled();
		sa.assertTrue(result3, "\n Failed: SAVE button is enabled  even if user enters Nothing in ZIP feild \n");
		 
		  sa.assertAll();
	            			
			System.out.println("SAVE button is disabled when user enters Invalid ZIP in Communication Pref pop up");
			log.info("SAVE button is disabled when user enters Invalid ZIP in Communication Pref pop up");
	     	     	
			} 
		catch (InterruptedException ie) {
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
	

	@Test(priority=65,enabled=true)
	public void CommPrefNullAddress()
	 {

		try{

			// Retrieving test data for valid login
			Map<String, String> Data = readxml.getUserData("TestData.xml", "user-to-update-comm-pref");
			String userId = Data.get("UserName");
			String Pwd = Data.get("password");
			String firstName = Data.get("firstname");
			String lastName = Data.get("lastname");
			String address1 ="";
			String address2 = Data.get("address2");
			String city = Data.get("city");
			String state = Data.get("state");
			String zip = Data.get("zipcode");
													
			cubHome = new CubHome(_driver);
			
			SoftAssert sa = new SoftAssert();
			
			log.info("Cub Home page is launched");
			cubHome.clickSignInLink();
			cubHome.enterLoginDetails(userId, Pwd);
			cubHome.clickSignInButton();
			Thread.sleep(5000);		
			cp = new CommuPrefPage(_driver);
			cp.clickOnMyAccountUnderMyTools(_driver);
			cp.clickEditCommunicationPref();
			cp.cpCheckDirectMail(_driver);
			cp.cpClickLinkToUpdateMailingAddress();
		  
			cp.cpEnterAddress(firstName, lastName, address1, address2, city, state, zip);
			boolean result = cp.cpIsSaveButtonInPopUpDirectMailDisabled();
			sa.assertTrue(result, "\n Failed: SAVE button is enabled  even if user enters Nothing in Address feild \n");
			    
			     sa.assertAll();
		            			
				System.out.println("SAVE button is disabled when user enters Invalid FirstName in Communication Pref pop up");
				log.info("SAVE button is disabled when user enters Invalid FirstName in Communication Pref pop up");
		     	     	
				} 
			catch (InterruptedException ie) {
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
	
	@Test(priority=66,enabled=true)
	public void ChngCommPrefAddressEditSuccess() {
		
		try{
		// Retrieving test data for valid login
		Map<String, String> Data = readxml.getUserData("TestData.xml", "user-to-update-comm-pref");
		String userId = Data.get("UserName");
		String Pwd = Data.get("password");
		String firstName1 = Data.get("firstname");
		String firstName2 = Data.get("firstnameagain");
		String lastName = Data.get("lastname");
		String address1 = Data.get("address1");
		String address2 = Data.get("address2");
		String city = Data.get("city");
		String state = Data.get("state");
		String zip = Data.get("zipcode");
												
		cubHome = new CubHome(_driver);
		
		SoftAssert sa = new SoftAssert();
		
		log.info("Cub Home page is launched");
		cubHome.clickSignInLink();
		cubHome.enterLoginDetails(userId, Pwd);
		cubHome.clickSignInButton();
		Thread.sleep(5000);		
		cp = new CommuPrefPage(_driver);
		cp.clickOnMyAccountUnderMyTools(_driver);
		cp.clickEditCommunicationPref();
		cp.cpCheckDirectMail(_driver);
		cp.cpClickLinkToUpdateMailingAddress();
	    
		cp.cpEnterAddress(firstName1, lastName, address1, address2, city, state, zip);
		cp.cpClickSaveButtonInEditAddress();
		cp.clickEditLinkInQAS();
		
		cp.cpEnterAddress(firstName2, lastName, address1, address2, city, state, zip);
		cp.cpClickSaveButtonInEditAddress();
		cp.clickUseThisAddressButton();
		cp.cpClickSaveButtonInEditAddress();
		
       String FN=cp.cpGetFirstName();
       
       Thread.sleep(20000);
       String userData=cp.getUserData();
		List<String> completeUserData = Arrays.asList(userData.split("\n"));
		String temp = completeUserData.get(0);
		List<String> nameData = Arrays.asList(temp.split("\\s"));
		String FirstNameData = nameData.get(0);
		
		System.out.println("Fetching First Name information from Communication Pref section\n FirstName:" + FirstNameData);

		sa.assertEquals(FN, firstName2, "\n Address not updated in Communication Pref section");
		sa.assertEquals(FirstNameData, firstName2, "\n Address not updated in Contact Info Section");
		sa.assertEquals(FN, FirstNameData, "\n Address in Communication Pref section is not matching with address in Cont Info Section");
				    
		    sa.assertAll();
		
	   	System.out.println("Address updated successfully in Communication Pref and Contact information Sections");
		log.info("Address updated  successfully in Communication Pref and Contact information Sections");
	       	     	
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
