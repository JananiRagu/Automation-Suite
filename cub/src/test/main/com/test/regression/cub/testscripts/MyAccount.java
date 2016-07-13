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
import com.test.regression.cub.pages.MyAccountPage;
import com.test.regression.cub.pages.ShoppingListPage;
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
	
	@Test(priority=1,enabled=true)
	public void ChangePwdValid()throws InterruptedException, IOException, XPathExpressionException, ParserConfigurationException, SAXException {
		
		// Retrieving test data for valid login
		Map<String, String> ChangePwdValidData = readxml.getUserData("TestData.xml", "user-to-change-pwd");
		String userId = ChangePwdValidData.get("UserName");
		String oldPwd = ChangePwdValidData.get("oldpassword");
		String newPwd = ChangePwdValidData.get("newpassword");
		
		cubHome = new CubHome(_driver);
		
		log.info("Cub Home page is launched");
	cubHome.clickSignInLink();
		log.info("SignIn Link Clicked");
	cubHome.enterLoginDetails(userId, oldPwd);
		log.info("Entered login Details");
	cubHome.clickSignInButton();
		log.info("SignInButton Clicked");
		log.info("Entered all details and clicked on Sign In Button");
		log.info("User Signed In");
		Thread.sleep(5000);	
	myAccount = new MyAccountPage(_driver);
	Thread.sleep(5000);
	myAccount.clickOnMyAccountUnderMyTools();
	myAccount.clickOnChangePwdLink();
	myAccount.enterPwdDetails(oldPwd, newPwd);
	
	myAccount.clickSaveButtonInChangePwdPopUp();	
	Thread.sleep(5000);	
	cubHome.clickOnLogOutLink();

//Login with new password and Change back  to old password 
	
	log.info("Cub Home page is launched");
	cubHome.clickSignInLink();
		log.info("SignIn Link Clicked");
	cubHome.enterLoginDetails(userId, newPwd);
		log.info("Entered login Details");
	cubHome.clickSignInButton();
		log.info("SignInButton Clicked");
		log.info("Entered all details and clicked on Sign In Button");
		log.info("User Signed In");
		
	Thread.sleep(5000);
	
	boolean result = cubHome.isLogOutButtonPresent();
	System.out.println("Password Changed successfully");
	log.info("Password Changed successfully");
	
	myAccount.clickOnMyAccountUnderMyTools();
	myAccount.clickOnChangePwdLink();
	myAccount.enterPwdDetails(newPwd, oldPwd);
	myAccount.clickSaveButtonInChangePwdPopUp();
	Thread.sleep(5000);	
	cubHome.clickOnLogOutLink();
	
	Assert.assertTrue(result);
	}	


//  Validating if Error is displayed when user wrong Old Password
	
	@Test(priority=2,enabled=true)
	public void ChangePwdWrongOldPwd()throws InterruptedException, IOException, XPathExpressionException, ParserConfigurationException, SAXException {
		
		// Retrieving test data for valid login
		Map<String, String> ChangePwdValidData = readxml.getUserData("TestData.xml", "user-to-change-pwd");
		String userId = ChangePwdValidData.get("UserName");
		String oldPwd1 = ChangePwdValidData.get("oldpassword");
		String oldPwd2 = ChangePwdValidData.get("wrongoldpassword");
		String newPwd = ChangePwdValidData.get("newpassword");
		
		cubHome = new CubHome(_driver);
		
		log.info("Cub Home page is launched");
	cubHome.clickSignInLink();
		log.info("SignIn Link Clicked");
	cubHome.enterLoginDetails(userId, oldPwd1);
		log.info("Entered login Details");
	cubHome.clickSignInButton();
		log.info("SignInButton Clicked");
		log.info("Entered all details and clicked on Sign In Button");
		log.info("User Signed In");
		Thread.sleep(5000);	
		myAccount = new MyAccountPage(_driver);
		Thread.sleep(5000);
		myAccount.clickOnMyAccountUnderMyTools();
		myAccount.clickOnChangePwdLink();
		myAccount.enterPwdDetails(oldPwd2, newPwd);
		Thread.sleep(5000);
			
		myAccount.clickSaveButtonInChangePwdPopUp();
		
		boolean result = myAccount.isChangePwdPopUpPresent();
	    
		Assert.assertTrue(result);
		System.out.println("Error is displayed when user wrong Old Password");
		log.info("Error is displayed when user wrong Old Passwordy");
						
	}
	
//  Validating if Error is displayed when user uses space in new password field
	
	@Test(priority=3,enabled=true)
	public void ChangePwdSpace()throws InterruptedException, IOException, XPathExpressionException, ParserConfigurationException, SAXException {
		
		// Retrieving test data for valid login
		Map<String, String> ChangePwdValidData = readxml.getUserData("TestData.xml", "user-to-change-pwd");
		String userId = ChangePwdValidData.get("UserName");
		String oldPwd = ChangePwdValidData.get("oldpassword");
		String newPwd = ChangePwdValidData.get("spacepassword");
		
		cubHome = new CubHome(_driver);
		
		log.info("Cub Home page is launched");
	cubHome.clickSignInLink();
		log.info("SignIn Link Clicked");
	cubHome.enterLoginDetails(userId, oldPwd);
		log.info("Entered login Details");
	cubHome.clickSignInButton();
		log.info("SignInButton Clicked");
		log.info("Entered all details and clicked on Sign In Button");
		log.info("User Signed In");
		Thread.sleep(5000);
		myAccount = new MyAccountPage(_driver);
		Thread.sleep(5000);
		myAccount.clickOnMyAccountUnderMyTools();
		myAccount.clickOnChangePwdLink();
		myAccount.enterPwdDetails(oldPwd, newPwd);
		Thread.sleep(5000);
			
		myAccount.clickSaveButtonInChangePwdPopUp();
		
		boolean result = myAccount.isChangePwdPopUpPresent();
	    
		Assert.assertTrue(result);
		System.out.println("Error is displayed when user uses space in new password field");
		log.info("Error is displayed when user uses space in new password field");
						
	}

//  Validating if system is not accepting lengthy password in new password field
	
	@Test(priority=4,enabled=true)
	public void ChangePwdLengthyPwd()throws InterruptedException, IOException, XPathExpressionException, ParserConfigurationException, SAXException {
		
		// Retrieving test data for valid login
		Map<String, String> ChangePwdValidData = readxml.getUserData("TestData.xml", "user-to-change-pwd");
		String userId = ChangePwdValidData.get("UserName");
		String oldPwd = ChangePwdValidData.get("oldpassword");
		String newPwd = ChangePwdValidData.get("lengthypassword");
		String resetPwd = ChangePwdValidData.get("lengthypasswordreset");
		
		cubHome = new CubHome(_driver);
		
		log.info("Cub Home page is launched");
	cubHome.clickSignInLink();
		log.info("SignIn Link Clicked");
	cubHome.enterLoginDetails(userId, oldPwd);
		log.info("Entered login Details");
	cubHome.clickSignInButton();
		log.info("SignInButton Clicked");
		log.info("Entered all details and clicked on Sign In Button");
		log.info("User Signed In");
		Thread.sleep(5000);
		myAccount = new MyAccountPage(_driver);
		Thread.sleep(5000);
		myAccount.clickOnMyAccountUnderMyTools();
		myAccount.clickOnChangePwdLink();
		myAccount.enterPwdDetails(oldPwd, newPwd);
		Thread.sleep(5000);
			
		myAccount.clickSaveButtonInChangePwdPopUp();
		
		Thread.sleep(5000);	
	cubHome.clickOnLogOutLink();

//Login with new password and Change back  to old password 
	
	log.info("Cub Home page is launched");
	cubHome.clickSignInLink();
		log.info("SignIn Link Clicked");
	cubHome.enterLoginDetails(userId, resetPwd);
		log.info("Entered login Details");
	cubHome.clickSignInButton();
		log.info("SignInButton Clicked");
		log.info("Entered all details and clicked on Sign In Button");
		log.info("User Signed In");
		
	Thread.sleep(5000);
	
	boolean result = cubHome.isLogOutButtonPresent();
	System.out.println("Password field is accepting only 18 digits ");
	log.info("Password field is accepting only 18 digits");
	
	myAccount.clickOnMyAccountUnderMyTools();
	myAccount.clickOnChangePwdLink();
	myAccount.enterPwdDetails(resetPwd, oldPwd);
	myAccount.clickSaveButtonInChangePwdPopUp();
	Thread.sleep(5000);	
	cubHome.clickOnLogOutLink();
	
	Assert.assertTrue(result);
						
	}
	

//  Validating if Error is displayed when user uses short password in new password field
	
	@Test(priority=5,enabled=true)
	public void ChangePwdShortPwd()throws InterruptedException, IOException, XPathExpressionException, ParserConfigurationException, SAXException {
		
		// Retrieving test data for valid login
		Map<String, String> ChangePwdValidData = readxml.getUserData("TestData.xml", "user-to-change-pwd");
		String userId = ChangePwdValidData.get("UserName");
		String oldPwd = ChangePwdValidData.get("oldpassword");
		String newPwd = ChangePwdValidData.get("shortpassword");
		
		cubHome = new CubHome(_driver);
		
		log.info("Cub Home page is launched");
	cubHome.clickSignInLink();
		log.info("SignIn Link Clicked");
	cubHome.enterLoginDetails(userId, oldPwd);
		log.info("Entered login Details");
	cubHome.clickSignInButton();
		log.info("SignInButton Clicked");
		log.info("Entered all details and clicked on Sign In Button");
		log.info("User Signed In");
		Thread.sleep(5000);	
		myAccount = new MyAccountPage(_driver);
		Thread.sleep(5000);
		myAccount.clickOnMyAccountUnderMyTools();
		myAccount.clickOnChangePwdLink();
		myAccount.enterPwdDetails(oldPwd, newPwd);
		Thread.sleep(5000);
			
		myAccount.clickSaveButtonInChangePwdPopUp();
		
		boolean result = myAccount.isChangePwdPopUpPresent();
	    
		Assert.assertTrue(result);
		System.out.println("Error is displayed when user uses short password in new password field");
		log.info("Error is displayed when user uses short password in new password field");
		
		
	}
	


//  Validating if Error is displayed when user uses different passwords in new password fields
	
	@Test(priority=6,enabled=true)
	public void ChangePwdDifferentNewPwds()throws InterruptedException, IOException, XPathExpressionException, ParserConfigurationException, SAXException {
		
		// Retrieving test data for valid login
		Map<String, String> ChangePwdValidData = readxml.getUserData("TestData.xml", "user-to-change-pwd");
		String userId = ChangePwdValidData.get("UserName");
		String oldPwd = ChangePwdValidData.get("oldpassword");
		String newPwd1 = ChangePwdValidData.get("newpassword");
		String newPwd2 =  ChangePwdValidData.get("diffnewpassword");
		
		cubHome = new CubHome(_driver);
		
		log.info("Cub Home page is launched");
	cubHome.clickSignInLink();
		log.info("SignIn Link Clicked");
	cubHome.enterLoginDetails(userId, oldPwd);
		log.info("Entered login Details");
	cubHome.clickSignInButton();
		log.info("SignInButton Clicked");
		log.info("Entered all details and clicked on Sign In Button");
		log.info("User Signed In");
		Thread.sleep(5000);
		myAccount = new MyAccountPage(_driver);
		Thread.sleep(5000);
		myAccount.clickOnMyAccountUnderMyTools();
		myAccount.clickOnChangePwdLink();
		myAccount.enterDiffPwdDetails(oldPwd, newPwd1, newPwd2);
		Thread.sleep(5000);
			
		myAccount.clickSaveButtonInChangePwdPopUp();
		
		boolean result = myAccount.isChangePwdPopUpPresent();
	    
		Assert.assertTrue(result);
		System.out.println("Error is displayed when user uses different passwords in new password fields");
		log.info("Error is displayed when user uses different passwords in new password fields");
							
	}
		
}
