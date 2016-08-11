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


import com.test.regression.cub.pages.CubHome;
import com.test.regression.cub.pages.MyAccountPage;

import com.test.regression.cub.utils.Logg;
import com.test.regression.cub.utils.ReadXML;
import com.test.regression.cub.utils.SuiteBase;

public class MyAccount extends SuiteBase
{
	CubHome cubHome;
	MyAccountPage myAccount;
	
	Logger log = Logg.createLogger();
	ReadXML readxml = new ReadXML();
	
// Change password successfully
	
	@Test(priority=42,enabled=true)
	public void ChngPwdValid() {
		try{
		// Retrieving test data for valid login
		Map<String, String> Data = readxml.getUserData("TestData.xml", "user-to-change-pwd");
		String userId = Data.get("UserName");
		String oldPwd = Data.get("oldpassword");
		String newPwd = Data.get("newpassword");
		
		cubHome = new CubHome(_driver);
		
		
	cubHome.clickSignInLink();
	cubHome.enterLoginDetails(userId, oldPwd);
	cubHome.clickSignInButton();
	myAccount = new MyAccountPage(_driver);
		
	 
	myAccount.clickOnMyAccountUnderMyTools(_driver);
	myAccount.clickOnChangePwdLink();
	myAccount.enterPwdDetails(oldPwd, newPwd);
	
	myAccount.clickSaveButtonInChangePwdPopUp();	
	Thread.sleep(5000);	
	cubHome.clickOnLogOutLink();

//Login with new password and Change back  to old password 
	
	log.info("Cub Home page is launched");
	cubHome.clickSignInLink();
	cubHome.enterLoginDetails(userId, newPwd);
	cubHome.clickSignInButton();
				
	Thread.sleep(5000);
	
	boolean result = cubHome.isLogOutButtonPresent();
	System.out.println("Password Changed successfully");
	log.info("Password Changed successfully");
	
	myAccount.clickOnMyAccountUnderMyTools(_driver);
	myAccount.clickOnChangePwdLink();
	myAccount.clickOnClosePopUp();
	myAccount.clickOnChangePwdLink();
	myAccount.enterPwdDetails(newPwd, oldPwd);
	myAccount.clickSaveButtonInChangePwdPopUp();
	Thread.sleep(5000);	
	cubHome.clickOnLogOutLink();
	
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


//  Validating if Error is displayed when user wrong Old Password
	
	@Test(priority=43,enabled=true)
	public void ChngPwdWrongOldPwd() {
		try{
		// Retrieving test data for valid login
		Map<String, String> Data = readxml.getUserData("TestData.xml", "user-to-change-pwd");
		String userId = Data.get("UserName");
		String oldPwd1 = Data.get("oldpassword");
		String oldPwd2 = Data.get("wrongoldpassword");
		String newPwd = Data.get("newpassword");
		
		cubHome = new CubHome(_driver);
		
		cubHome.clickSignInLink();
	cubHome.enterLoginDetails(userId, oldPwd1);
	cubHome.clickSignInButton();

	myAccount = new MyAccountPage(_driver);
	myAccount.clickOnMyAccountUnderMyTools(_driver);

		myAccount.clickOnChangePwdLink();
		myAccount.enterPwdDetails(oldPwd2, newPwd);
		Thread.sleep(5000);
		
		myAccount.clickSaveButtonInChangePwdPopUp();
			
		boolean result = myAccount.isChangePwdPopUpPresent();
		
		Assert.assertTrue(result, "\n Failed: No error displayed when user enters wrong old password \n");
		    
		System.out.println("Error is displayed when user wrong Old Password");
		log.info("Error is displayed when user wrong Old Password");
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
	
//  Validating if Error is displayed when user uses space in new password field
	
	@Test(priority=44,enabled=true)
	public void ChngPwdSpace() {
		try{
		// Retrieving test data for valid login
		Map<String, String> Data = readxml.getUserData("TestData.xml", "user-to-change-pwd");
		String userId = Data.get("UserName");
		String oldPwd = Data.get("oldpassword");
		String newPwd = Data.get("spacepassword");
		
		cubHome = new CubHome(_driver);
		
		log.info("Cub Home page is launched");
	cubHome.clickSignInLink();
		
	cubHome.enterLoginDetails(userId, oldPwd);
     cubHome.clickSignInButton();	

	myAccount = new MyAccountPage(_driver);
	
	 
		myAccount.clickOnMyAccountUnderMyTools(_driver);

		myAccount.clickOnChangePwdLink();
		myAccount.enterPwdDetails(oldPwd, newPwd);
		Thread.sleep(5000);
		
		boolean result = myAccount.isSaveButtonInChangePwdPopUpDisabled();
	    Assert.assertTrue(result, "\n Failed: New password feild is accepting spaces \n");
			
		System.out.println("Error is displayed when user uses space in new password field");
		log.info("Error is displayed when user uses space in new password field");
				
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

//  Validating if system is not accepting lengthy password in new password field
	
	@Test(priority=45,enabled=true)
	public void ChngPwdLengthyPwd() {
		try{
		// Retrieving test data for valid login
		Map<String, String> Data = readxml.getUserData("TestData.xml", "user-to-change-pwd");
		String userId = Data.get("UserName");
		String oldPwd = Data.get("oldpassword");
		String newPwd = Data.get("lengthypassword");
		String resetPwd = Data.get("lengthypasswordreset");
		
		cubHome = new CubHome(_driver);
		
		log.info("Cub Home page is launched");
	cubHome.clickSignInLink();
	
	cubHome.enterLoginDetails(userId, oldPwd);
		
	cubHome.clickSignInButton();

	myAccount = new MyAccountPage(_driver);
	
	 
		myAccount.clickOnMyAccountUnderMyTools(_driver);

		myAccount.clickOnChangePwdLink();
		myAccount.enterPwdDetails(oldPwd, newPwd);
		Thread.sleep(5000);
			
		myAccount.clickSaveButtonInChangePwdPopUp();
		
		Thread.sleep(5000);	
	cubHome.clickOnLogOutLink();

//Login with new password and Change back  to old password 
	
	log.info("Cub Home page is launched");
	cubHome.clickSignInLink();
	
	cubHome.enterLoginDetails(userId, resetPwd);
		
	cubHome.clickSignInButton();
		
		
	Thread.sleep(10000);
	
	boolean result = cubHome.isLogOutButtonPresent();
	System.out.println("Password field is accepting only 18 digits ");
	log.info("Password field is accepting only 18 digits");
	
	myAccount.clickOnMyAccountUnderMyTools(_driver);
	myAccount.clickOnChangePwdLink();
	myAccount.enterPwdDetails(resetPwd, oldPwd);
	myAccount.clickSaveButtonInChangePwdPopUp();
	Thread.sleep(5000);	
	cubHome.clickOnLogOutLink();
	
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
	

//  Validating if Error is displayed when user uses short password in new password field
	
	@Test(priority=46,enabled=true)
	public void ChngPwdShortPwd(){
		try{
		// Retrieving test data for valid login
		Map<String, String> Data = readxml.getUserData("TestData.xml", "user-to-change-pwd");
		String userId = Data.get("UserName");
		String oldPwd = Data.get("oldpassword");
		String newPwd = Data.get("shortpassword");
		
		cubHome = new CubHome(_driver);
		
		log.info("Cub Home page is launched");
	cubHome.clickSignInLink();
	cubHome.enterLoginDetails(userId, oldPwd);
	
	cubHome.clickSignInButton();

	myAccount = new MyAccountPage(_driver);
	
	 
		myAccount.clickOnMyAccountUnderMyTools(_driver);
		myAccount.clickOnChangePwdLink();
		myAccount.enterPwdDetails(oldPwd, newPwd);
		Thread.sleep(5000);
			
			boolean result = myAccount.isSaveButtonInChangePwdPopUpDisabled();
			Assert.assertTrue(result, "\n Failed: SAVE button is enabled even if Password length is lesser than 6 \n");
		System.out.println("Error is displayed when user uses short password in new password field");
		log.info("Error is displayed when user uses short password in new password field");
		
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
	


//  Validating if Error is displayed when user uses different passwords in new password fields
	
	@Test(priority=47,enabled=true)
	public void ChngPwdDifferentNewPwds() {
		try{
		// Retrieving test data for valid login
		Map<String, String> Data = readxml.getUserData("TestData.xml", "user-to-change-pwd");
		String userId = Data.get("UserName");
		String oldPwd = Data.get("oldpassword");
		String newPwd1 = Data.get("newpassword");
		String newPwd2 =  Data.get("diffnewpassword");
		
		cubHome = new CubHome(_driver);
		
		log.info("Cub Home page is launched");
	cubHome.clickSignInLink();
	cubHome.enterLoginDetails(userId, oldPwd);
	cubHome.clickSignInButton();

	myAccount = new MyAccountPage(_driver);
		 
		myAccount.clickOnMyAccountUnderMyTools(_driver);
		myAccount.clickOnChangePwdLink();
		myAccount.enterDiffPwdDetails(oldPwd, newPwd1, newPwd2);
		Thread.sleep(5000);
			
		myAccount.clickSaveButtonInChangePwdPopUp();
		
		boolean result = myAccount.isChangePwdPopUpPresent();
		Assert.assertTrue(result, "\n Failed: No error displayed even if user enters 2 different passwords in new password fields \n");
		
			System.out.println("Error is displayed when user uses different passwords in new password fields");
		log.info("Error is displayed when user uses different passwords in new password fields");
				
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

	

//  Updating Contact Info successfully
	

	@Test(priority=48,enabled=true)
	public void ChngContInfoSuccessfully() {
		
		try{
		// Retrieving test data for valid login
		Map<String, String> Data = readxml.getUserData("TestData.xml", "user-to-update-contact-info");
		String userId = Data.get("UserName");
		String Pwd = Data.get("password");
		String firstName = Data.get("firstname");
		String lastName = Data.get("lastname");
		String address1 = Data.get("address1");
		String address2 = Data.get("address2");
		String city = Data.get("city");
		String state = Data.get("state1");
		String zip = Data.get("zipcode");
		String homePhone = Data.get("homephone");
		String mobilePhone = Data.get("mobilephone");
							
		cubHome = new CubHome(_driver);
			
		log.info("Cub Home page is launched");
		cubHome.clickSignInLink();
		cubHome.enterLoginDetails(userId, Pwd);
		cubHome.clickSignInButton();
		
		myAccount = new MyAccountPage(_driver);
				 
		myAccount.clickOnMyAccountUnderMyTools(_driver);
	    myAccount.clickEditLinkToUpdateContactInfo();
	    myAccount.clickOnClosePopUp();
	    myAccount.clickEditLinkToUpdateContactInfo();
		Thread.sleep(5000);
		myAccount.enterContactInformation(firstName, lastName, address1, address2, city, state, zip, homePhone, mobilePhone);
		myAccount.clickContinueButtonInUpdateContactInfoPopUp();
		Thread.sleep(5000);
		myAccount.clickUseThisAddressButton();
		Thread.sleep(5000);
		String userData=myAccount.getUserData();
		
		List<String> completeUserData = Arrays.asList(userData.split("\n"));
		String temp = completeUserData.get(0);
		List<String> nameData = Arrays.asList(temp.split("\\s"));
		
		boolean result= firstName.equalsIgnoreCase(nameData.get(0));
		System.out.println(result);
		Assert.assertTrue(result);
				
		System.out.println("Contact Info updated successfully");
		log.info("Contact Info updated successfully");
				
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
	
	

//  Updating Contact Info successfully
	

	@Test(priority=53,enabled=true)
	public void ChngContInfoUsingEditLinkInPopUp() {
		
		try{
		// Retrieving test data for valid login
		Map<String, String> Data = readxml.getUserData("TestData.xml", "user-to-update-contact-info");
		String userId = Data.get("UserName");
		String Pwd = Data.get("password");
		String firstName = Data.get("firstname");
		String firstNameAgain = Data.get("firstnameagain");
		String lastName = Data.get("lastname");
		String address1 = Data.get("address1");
		String address2 = Data.get("address2");
		String city = Data.get("city");
		String state = Data.get("state");
		String zip = Data.get("zipcode");
		String homePhone = Data.get("homephone");
		String mobilePhone = Data.get("mobilephone");
							
		cubHome = new CubHome(_driver);
			
		log.info("Cub Home page is launched");
		cubHome.clickSignInLink();
		cubHome.enterLoginDetails(userId, Pwd);
		cubHome.clickSignInButton();
		myAccount = new MyAccountPage(_driver);
		
		 
		myAccount.clickOnMyAccountUnderMyTools(_driver);
	    myAccount.clickEditLinkToUpdateContactInfo();
		Thread.sleep(5000);
		myAccount.enterContactInformation(firstName, lastName, address1, address2, city, state, zip, homePhone, mobilePhone);
		myAccount.clickContinueButtonInUpdateContactInfoPopUp();
				
		myAccount.clickEditLinkInQAS();
		myAccount.enterContactInformation(firstNameAgain, lastName, address1, address2, city, state, zip, homePhone, mobilePhone);
		Thread.sleep(5000);
		myAccount.clickContinueButtonInUpdateContactInfoPopUp();
		Thread.sleep(5000);
		myAccount.clickUseThisAddressButton();
		Thread.sleep(5000);
		
		String userData=myAccount.getUserData();
		
		List<String> completeUserData = Arrays.asList(userData.split("\n"));
		String temp = completeUserData.get(0);
		List<String> nameData = Arrays.asList(temp.split("\\s"));
		
		boolean result= firstNameAgain.equalsIgnoreCase(nameData.get(0));
		System.out.println(result);
		Assert.assertTrue(result);
		
		
		System.out.println("Contact Info updated successfully using EDIT link in QAS valiadtion Pop Up");
		log.info("Contact Info updated successfully using EDIT link in QAS valiadtion Pop Up");
				
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
	
//  Updating Contact Info with Invalid First Name
	

	@Test(priority=49,enabled=true)
	public void ChngContInfoInvalidFirstName() {
		
		try{
		// Retrieving test data for valid login
		Map<String, String> Data = readxml.getUserData("TestData.xml", "user-to-update-contact-info");
		String userId = Data.get("UserName");
		String Pwd = Data.get("password");
		String firstNameNumber = Data.get("firstnamenumbers");
		String firstNameSpecialCharacters = Data.get("firstnamespecialCharacters");
		String lastName = Data.get("lastname");
		String address1 = Data.get("address1");
		String address2 = Data.get("address2");
		String city = Data.get("city");
		String state = Data.get("state");
		String zip = Data.get("zipcode");
		String homePhone = Data.get("homephone");
		String mobilePhone = Data.get("mobilephone");
		String nullVariable = "";
		
		SoftAssert sa = new SoftAssert();
		
		cubHome = new CubHome(_driver);
			
		log.info("Cub Home page is launched");
		cubHome.clickSignInLink();
		cubHome.enterLoginDetails(userId, Pwd);
		cubHome.clickSignInButton();
		myAccount = new MyAccountPage(_driver);
		
		 
		myAccount.clickOnMyAccountUnderMyTools(_driver);
	    myAccount.clickEditLinkToUpdateContactInfo();
		Thread.sleep(5000);
		
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
	
	
//  Updating Contact Info with Invalid Last Name
	

	@Test(priority=50,enabled=true)
	public void ChngContInfoInvalidLastName() {
		
		try{
		// Retrieving test data for valid login
		Map<String, String> Data = readxml.getUserData("TestData.xml", "user-to-update-contact-info");
		String userId = Data.get("UserName");
		String Pwd = Data.get("password");
		String lastNameNumber = Data.get("lastnamenumbers");
		String lastNameSpecialCharacters = Data.get("lastnamespecialCharacters");
		String firstName = Data.get("firstname");
		String address1 = Data.get("address1");
		String address2 = Data.get("address2");
		String city = Data.get("city");
		String state = Data.get("state");
		String zip = Data.get("zipcode");
		String homePhone = Data.get("homephone");
		String mobilePhone = Data.get("mobilephone");
		String nullVariable = "";
		
		cubHome = new CubHome(_driver);
		SoftAssert sa = new SoftAssert();
		
		log.info("Cub Home page is launched");
		cubHome.clickSignInLink();
		cubHome.enterLoginDetails(userId, Pwd);
		cubHome.clickSignInButton();

		myAccount = new MyAccountPage(_driver);
		
		 
		myAccount.clickOnMyAccountUnderMyTools(_driver);
	    myAccount.clickEditLinkToUpdateContactInfo();
		Thread.sleep(5000);
		

		log.info("Checking for Error is displayed when user enters LastName with Special Characters");
		myAccount.enterContactInformation(firstName, lastNameSpecialCharacters, address1, address2, city, state, zip, homePhone, mobilePhone);
		  boolean result2 = myAccount.isContinueBtnInUpdateContactInfoDisabled();
	    sa.assertTrue(result2, "\n Failed for LastName with Special Characters");
	    
	    
		log.info("Checking for Error is displayed when user enters LastName with Numbers");
		myAccount.enterContactInformation(firstName, lastNameNumber, address1, address2, city, state, zip, homePhone, mobilePhone);
		  boolean result1 = myAccount.isContinueBtnInUpdateContactInfoDisabled();
         sa.assertTrue(result1, "\n Failed for LastName with Numbers");
			

		log.info("Checking for Error is displayed when user doesnot enter LastName");
		myAccount.enterContactInformation(firstName, nullVariable, address1, address2, city, state, zip, homePhone, mobilePhone);
		boolean result3 = myAccount.isContinueBtnInUpdateContactInfoDisabled();
        sa.assertTrue(result3, "\n Failed for No LastName Entered");
	    
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
	
	
//  Updating Contact Info with Invalid ZIP
	

	@Test(priority=51,enabled=true)
	public void ChngContInfoInvalidZIP() {
		
		try{
		// Retrieving test data for valid login
		Map<String, String> Data = readxml.getUserData("TestData.xml", "user-to-update-contact-info");
		String userId = Data.get("UserName");
		String Pwd = Data.get("password");
		String lastName = Data.get("lastname");
		String firstName = Data.get("firstname");
		String address1 = Data.get("address1");
		String address2 = Data.get("address2");
		String city = Data.get("city");
		String state = Data.get("state");
		String zipcodespace = Data.get("zipcodespace");
		String zipcodealphabets = Data.get("zipcodealphabets");
		String zipcodespecialchar = Data.get("zipcodespecialchar");
		String zipcodelessdigits = Data.get("zipcodelessdigits");
		String homePhone = Data.get("homephone");
		String mobilePhone = Data.get("mobilephone");
		String nullVariable = "";
		
		cubHome = new CubHome(_driver);
		SoftAssert sa = new SoftAssert();
		
		log.info("Cub Home page is launched");
		cubHome.clickSignInLink();
		cubHome.enterLoginDetails(userId, Pwd);
		cubHome.clickSignInButton();
		
		
		myAccount = new MyAccountPage(_driver);
	
		myAccount.clickOnMyAccountUnderMyTools(_driver);
	    myAccount.clickEditLinkToUpdateContactInfo();
		Thread.sleep(5000);
		

		log.info("Checking for Error is displayed when user enters ZIP with Special Characters");
		myAccount.enterContactInformation(firstName, lastName, address1, address2, city, state, zipcodespecialchar, homePhone, mobilePhone);
	 boolean result2 =myAccount.isContinueBtnInUpdateContactInfoDisabled();
	    sa.assertTrue(result2, "\n Failed for ZIP with Special Characters");
	    
	    
		log.info("Checking for Error is displayed when user enters ZIP with alphabets");
		myAccount.enterContactInformation(firstName, lastName, address1, address2, city, state, zipcodealphabets, homePhone, mobilePhone);
	boolean result1 =myAccount.isContinueBtnInUpdateContactInfoDisabled();
	    sa.assertTrue(result1, "\n Failed for ZIP with alphabets");
				
	    
	  	log.info("Checking for Error is displayed when user enters ZIP with space");
	  	myAccount.enterContactInformation(firstName, lastName, address1, address2, city, state, zipcodespace, homePhone, mobilePhone);
	 boolean result3 =myAccount.isContinueBtnInUpdateContactInfoDisabled();
	  	sa.assertTrue(result3, "\n Failed for ZIP with Space");
	  	  

		log.info("Checking for Error is displayed when user doesnot enter ZIP");
		myAccount.enterContactInformation(firstName, lastName, address1, address2, city, state, nullVariable, homePhone, mobilePhone);
	  boolean result4 =myAccount.isContinueBtnInUpdateContactInfoDisabled();
	    sa.assertTrue(result4, "Failed for No ZIP Entered");
	  	
		
	    log.info("Checking for Error is displayed when user enters less than 5 digits in  ZIP code feild");
		myAccount.enterContactInformation(firstName, lastName, address1, address2, city, state, zipcodelessdigits, homePhone, mobilePhone);
	boolean result5 =myAccount.isContinueBtnInUpdateContactInfoDisabled();
	    sa.assertTrue(result5, "Failed when user enters less than 5 digits in  ZIP code feild");
	  	
	    
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
	
	
//  Updating Contact Info with Invalid City Name
	

	@Test(priority=52,enabled=true)
	public void ChngContInfoInvalidCity() {
		
		try{
		// Retrieving test data for valid login
		Map<String, String> Data = readxml.getUserData("TestData.xml", "user-to-update-contact-info");
		String userId = Data.get("UserName");
		String Pwd = Data.get("password");
		String lastName = Data.get("lastname");
		String firstName = Data.get("firstname");
		String address1 = Data.get("address1");
		String address2 = Data.get("address2");
		String citynumber = Data.get("citynumber");
		String cityspecialchar = Data.get("cityspecialchar");		
		String state = Data.get("state");
		String zip = Data.get("zipcode");
		String homePhone = Data.get("homephone");
		String mobilePhone = Data.get("mobilephone");
		String nullVariable = "";
		
		cubHome = new CubHome(_driver);
		SoftAssert sa = new SoftAssert();
		
		log.info("Cub Home page is launched");
		cubHome.clickSignInLink();
		cubHome.enterLoginDetails(userId, Pwd);
		cubHome.clickSignInButton();
		
		Thread.sleep(5000);
		myAccount = new MyAccountPage(_driver);
	
		myAccount.clickOnMyAccountUnderMyTools(_driver);
	    myAccount.clickEditLinkToUpdateContactInfo();
		Thread.sleep(5000);
		

		log.info("Checking for Error is displayed when user enters CITY with Special Characters");
		myAccount.enterContactInformation(firstName, lastName, address1, address2, cityspecialchar, state, zip, homePhone, mobilePhone);
	 boolean result2 =myAccount.isContinueBtnInUpdateContactInfoDisabled();
	    sa.assertTrue(result2, "\n Failed for CITY with Special Characters");
	    
	  
	    log.info("Checking for Error is displayed when user enters CITY with numbers");
	  	myAccount.enterContactInformation(firstName, lastName, address1, address2, citynumber, state, zip, homePhone, mobilePhone);
  boolean result3 =myAccount.isContinueBtnInUpdateContactInfoDisabled();
	  	sa.assertTrue(result3, "\n Failed for  CITY with numbers");
	  	    

		log.info("Checking for Error is displayed when user doesnot enter City");
		myAccount.enterContactInformation(firstName, lastName, address1, address2, nullVariable, state, zip, homePhone, mobilePhone);
	 boolean result4 =myAccount.isContinueBtnInUpdateContactInfoDisabled();
	    sa.assertTrue(result4, "\n Failed for No City Entered");
	  	
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
	
	
//  Updating Contact Info with Invalid Mobile Number
	

	@Test(priority=53,enabled=true)
	public void ChngContInfoInvalidMobileNumber() {
		
		try{
		// Retrieving test data for valid login
		Map<String, String> Data = readxml.getUserData("TestData.xml", "user-to-update-contact-info");
		String userId = Data.get("UserName");
		String Pwd = Data.get("password");
		String lastName = Data.get("lastname");
		String firstName = Data.get("firstname");
		String address1 = Data.get("address1");
		String address2 = Data.get("address2");
		String city = Data.get("city");
		String state = Data.get("state");
		String zip = Data.get("zipcode");
		String homePhone = Data.get("homephone");
		String mobileAlphabets = Data.get("mobilephonealphabets");
		String mobileSpace = Data.get("mobilephonespace");
		String mobileSplChar = Data.get("mobilephonespecialchar");
			
							
		cubHome = new CubHome(_driver);
		SoftAssert sa = new SoftAssert();
		
		log.info("Cub Home page is launched");
		cubHome.clickSignInLink();
		cubHome.enterLoginDetails(userId, Pwd);
		cubHome.clickSignInButton();
			
		Thread.sleep(5000);
		myAccount = new MyAccountPage(_driver);
	
		myAccount.clickOnMyAccountUnderMyTools(_driver);
	    myAccount.clickEditLinkToUpdateContactInfo();
		Thread.sleep(5000);
		

	    log.info("Checking for Error is displayed when user enters Mobile Number with Space");
	  	myAccount.enterContactInformation(firstName, lastName, address1, address2, city, state, zip, homePhone, mobileSpace);
	 myAccount.clickContinueButtonInUpdateContactInfoPopUp();
	  	  boolean result1 =myAccount.isUpdateContactInfoPopUpPresent();
	  	sa.assertTrue(result1, "\n Failed for Mobile Number with Space");
		

		log.info("Checking for Error is displayed when user enters Mobile Number with Special Characters");
		myAccount.enterContactInformation(firstName, lastName, address1, address2, city, state, zip, homePhone, mobileSplChar);
		 myAccount.clickContinueButtonInUpdateContactInfoPopUp();
		 boolean result2 =myAccount.isUpdateContactInfoPopUpPresent();
	    sa.assertTrue(result2, "\n Failed for Mobile Number with Special Characters");
	    
	  
	    log.info("Checking for Error is displayed when user enters Mobile Number with Alphabets");
	  	myAccount.enterContactInformation(firstName, lastName, address1, address2, city, state, zip, homePhone, mobileAlphabets);
		 myAccount.clickContinueButtonInUpdateContactInfoPopUp();
	  	 boolean result3 =myAccount.isUpdateContactInfoPopUpPresent();
	  	sa.assertTrue(result3, "\n Failed for Mobile Number with Alphabets");
	  		  	
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
		
	
	
//  Updating Contact Info with Invalid Mobile Number
	

	@Test(priority=53,enabled=true)
	public void ChngContInfoInvalidHomeNumber() {
		
		try{
		// Retrieving test data for valid login
		Map<String, String> Data = readxml.getUserData("TestData.xml", "user-to-update-contact-info");
		String userId = Data.get("UserName");
		String Pwd = Data.get("password");
		String lastName = Data.get("lastname");
		String firstName = Data.get("firstname");
		String address1 = Data.get("address1");
		String address2 = Data.get("address2");
		String city = Data.get("city");
		String state = Data.get("state");
		String zip = Data.get("zipcode");
		String mobilePhone = Data.get("mobilephone");
		String homePhoneAlphabets = Data.get("homephonealphabets");
		String homePhoneSpace = Data.get("homephonespace");
		String homePhoneSpecialChar = Data.get("homephonespecialchar");
		
							
		cubHome = new CubHome(_driver);
		SoftAssert sa = new SoftAssert();
		
		log.info("Cub Home page is launched");
		cubHome.clickSignInLink();
		cubHome.enterLoginDetails(userId, Pwd);
		cubHome.clickSignInButton();
			
		Thread.sleep(5000);
		myAccount = new MyAccountPage(_driver);
			myAccount.clickOnMyAccountUnderMyTools(_driver);
	    myAccount.clickEditLinkToUpdateContactInfo();
		Thread.sleep(5000);
		

	    log.info("Checking for Error is displayed when user enters Home Phone Number with Space");
	  	myAccount.enterContactInformation(firstName, lastName, address1, address2, city, state, zip, homePhoneSpace, mobilePhone);
		 myAccount.clickContinueButtonInUpdateContactInfoPopUp();
	  	 boolean result1 =myAccount.isUpdateContactInfoPopUpPresent();
	  	sa.assertTrue(result1, "\n Failed for Home Phone  Number with Space");
		

		log.info("Checking for Error is displayed when user enters  Home Phone Number with Special Characters");
		myAccount.enterContactInformation(firstName, lastName, address1, address2, city, state, zip, homePhoneSpecialChar, mobilePhone);
		 myAccount.clickContinueButtonInUpdateContactInfoPopUp();
		 boolean result2 =myAccount.isUpdateContactInfoPopUpPresent();
	    sa.assertTrue(result2, "\n Failed for Home Phone  Number with Special Characters");
	    
	  
	    log.info("Checking for Error is displayed when user enters Home Phone  Number with Alphabets");
	  	myAccount.enterContactInformation(firstName, lastName, address1, address2, city, state, zip, homePhoneAlphabets, mobilePhone);
	  	 myAccount.clickContinueButtonInUpdateContactInfoPopUp();
	  	  boolean result3 =myAccount.isUpdateContactInfoPopUpPresent();
	  	sa.assertTrue(result3, "\n Failed for Home Phone  Number with Alphabets");
	  	
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
		
	
	
	
//  Updating Contact Info with No Address

	@Test(priority=53,enabled=true)
	public void ChngContInfoNullAddress() {
		
		try{
		// Retrieving test data for valid login
		Map<String, String> Data = readxml.getUserData("TestData.xml", "user-to-update-contact-info");
		String userId = Data.get("UserName");
		String Pwd = Data.get("password");
		String lastName = Data.get("lastname");
		String firstName = Data.get("firstname");
		String address2 = Data.get("address2");
		String city = Data.get("city");
		String state = Data.get("state");
		String zip = Data.get("zipcode");
		String mobilePhone = Data.get("mobilephone");
		String homePhone = Data.get("homephone");
		String nullVariable = "";
		
											
		cubHome = new CubHome(_driver);
		SoftAssert sa = new SoftAssert();
		
		log.info("Cub Home page is launched");
		cubHome.clickSignInLink();
		cubHome.enterLoginDetails(userId, Pwd);
		cubHome.clickSignInButton();
		Thread.sleep(5000);		
		myAccount = new MyAccountPage(_driver);
				myAccount.clickOnMyAccountUnderMyTools(_driver);
	    myAccount.clickEditLinkToUpdateContactInfo();
		Thread.sleep(5000);


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
	
	
	
//  Clicking on Privacy Policy link in Update Contact information pop up in My Account page

	@Test(priority=54,enabled=true)
	public void PPLinkInUpdateContactInfoPopUp() {
		
		try{
		// Retrieving test data for valid login
		Map<String, String> Data = readxml.getUserData("TestData.xml", "user-to-update-contact-info");
		String userId = Data.get("UserName");
		String Pwd = Data.get("password");
												
		cubHome = new CubHome(_driver);
				
		log.info("Cub Home page is launched");
		cubHome.clickSignInLink();
		cubHome.enterLoginDetails(userId, Pwd);
		cubHome.clickSignInButton();
		Thread.sleep(5000);		
		myAccount = new MyAccountPage(_driver);
			myAccount.clickOnMyAccountUnderMyTools(_driver);
	    myAccount.clickEditLinkToUpdateContactInfo();
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
	
	
	
	
}

