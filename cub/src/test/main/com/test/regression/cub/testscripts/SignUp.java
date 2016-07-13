package com.test.regression.cub.testscripts;

import java.io.IOException;
import java.util.Map;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;
import com.test.regression.cub.pages.CubHome;
import com.test.regression.cub.pages.SignUpPage;
import com.test.regression.cub.utils.*;


public class SignUp extends SuiteBase{
	
	Logger log = Logg.createLogger();
	ReadXML readxml = new ReadXML();
	CubHome cubHome;
	SignUpPage signUpPage;

	@Test(priority=3, enabled=true)
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
		
		Assert.assertTrue(signUpPage.isLogOutButtonPresent());	
		
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

	@Test(priority=4, enabled=true)
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
		
		Assert.assertTrue(signUpPage.isLogOutButtonPresent());
		
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
		
		Assert.assertTrue(signUpPage.isLogOutButtonPresent());
		
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
