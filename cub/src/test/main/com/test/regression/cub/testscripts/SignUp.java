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

	@Test(priority=3)
	public void validSignUp_noCard() throws InterruptedException, IOException, XPathExpressionException, ParserConfigurationException, SAXException{
		// Retrieving test data for valid sign up no card
				Map<String, String> validSignUpNoCard = readxml.getUserData("TestData.xml", "new-user-1");
				String userId = validSignUpNoCard.get("UserName");
				String password = validSignUpNoCard.get("password");
				
				log.info("Launched Cub Website");
		
		signUpPage = new SignUpPage(_driver);	
		signUpPage.clickSignUpLink();
		signUpPage.enterSignUpDetails(userId,password);
			log.info("Entered Sign Up Data");
		signUpPage.clickDontWantCardRadio();
			log.info("Clicked on No Card Option");
		signUpPage.clickContinueButton();
		
		Assert.assertTrue(signUpPage.isLogOutButtonPresent());		
		
	}

	@Test(priority=4)
	public void validSignUp_yesIHaveOne() throws InterruptedException, XPathExpressionException, ParserConfigurationException, SAXException, IOException{
		
		Map<String, String> validSignUpYesIHave = readxml.getUserData("TestData.xml", "new-user-3");
		String userId = validSignUpYesIHave.get("UserName");
		String password = validSignUpYesIHave.get("password");
		String lastName = validSignUpYesIHave.get("lastname");
		String rewardsNum = validSignUpYesIHave.get("rewardsnumber");
		
		signUpPage = new SignUpPage(_driver);
		
		signUpPage.clickSignUpLink();
		log.info("SignUp Popup Launched");
		signUpPage.enterSignUpDetails(userId,password);
		
		signUpPage.clickYesHaveCardRadio();
		signUpPage.clickContinueButton();
		signUpPage.addRewardsCard_EnterDetails(lastName, rewardsNum);
		log.info("Entered existing reward card details");
		Assert.assertTrue(signUpPage.isLogOutButtonPresent());
		
	
		
	}
	
	@Test(priority=5)
	public void validSignUp_noCardButWantOne() throws InterruptedException, XPathExpressionException, ParserConfigurationException, SAXException, IOException{
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
		
		signUpPage.clickSignUpLink();
			log.info("SignUp popup is displayed");
		signUpPage.enterSignUpDetails(userId,password);
			log.info("Entered Username and password");
		signUpPage.clickNoButWantCardRadio();
			log.info("Selected No but Want One Option");
		signUpPage.clickContinueButton();
		signUpPage.enterContactInformationInSignUp(firstName, lastName, address1, address2, city, state, zip, homePhone, mobilePhone, cardlessId);		
			log.info("Entered all contact details");
		signUpPage.clickUseThisAddressButton();
			log.info("Entered all the necessary information for the new card");
		
		Assert.assertTrue(signUpPage.isLogOutButtonPresent());
		
	}
	
	
}
