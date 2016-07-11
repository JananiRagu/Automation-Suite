package com.test.regression.cub.testscripts;

import java.io.IOException;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;

import com.test.regression.cub.pages.CouponPage;
import com.test.regression.cub.pages.CubHome;
import com.test.regression.cub.pages.MyeCouponsPage;
import com.test.regression.cub.pages.SignUpPage;
import com.test.regression.cub.utils.Logg;
import com.test.regression.cub.utils.ReadXML;
import com.test.regression.cub.utils.SuiteBase;

public class Coupons extends SuiteBase{

	CubHome cubHome;
	CouponPage cp;
	SignUpPage signUpPage;
	MyeCouponsPage ecp;
	Logger log = Logg.createLogger();
	ReadXML readxml = new ReadXML();
	
	@Test(enabled=false)
	public void addCouponForAuthorizedUser() throws XPathExpressionException, ParserConfigurationException, SAXException, IOException, InterruptedException{
		
		Map<String, String> newSL = readxml.getUserData("TestData.xml", "carded-user1");
		String userId = newSL.get("UserName");
		String password = newSL.get("password");
		String wantedCouponNumber = newSL.get("wantedCoupon");
		
		cubHome = new CubHome(_driver);
			log.info("cubHome obj instantiated");
		cubHome.clickSignInLink();
			log.info("SignIn Link Clicked");
		cubHome.enterLoginDetails(userId, password);
			log.info("Entered login Details");
		cubHome.clickSignInButton();
			log.info("SignInButton Clicked");
		
		cp = new CouponPage(_driver);
		
		cp.clickOnCouponsInMyToolsHomePage();
		
		cp.loadCompleteCouponsPage();
			log.info("Coupons Page is loaded fully");
		
		cp.addNthCoupon(_driver, wantedCouponNumber);
			log.info("Added nth coupon");

			
		String addedCouponName = cp.getNthCouponName(_driver, wantedCouponNumber);
		
		ecp = new MyeCouponsPage(_driver);
		
		ecp.clickOnMyeCouponsInMyToolsHomePage();
		
		boolean result = ecp.isCouponPresent(addedCouponName);
		
		System.out.println("Result is " + result);
		Assert.assertTrue(result);
		
	}
	
	
	
	@Test(enabled=false)
	public void addCouponForWantOneNewUser() throws XPathExpressionException, ParserConfigurationException, SAXException, IOException, InterruptedException{
		
		Map<String, String> addCouponForWantOneNewUserData = readxml.getUserData("TestData.xml", "new-user-2");
		String userId = addCouponForWantOneNewUserData.get("UserName");
		String password = addCouponForWantOneNewUserData.get("password");
		String firstName = addCouponForWantOneNewUserData.get("firstname");
		String lastName = addCouponForWantOneNewUserData.get("lastname");
		String address1 = addCouponForWantOneNewUserData.get("address1");
		String address2 = addCouponForWantOneNewUserData.get("address2");
		String city = addCouponForWantOneNewUserData.get("city");
		String state = addCouponForWantOneNewUserData.get("state");
		String zip = addCouponForWantOneNewUserData.get("zipcode");
		String homePhone = addCouponForWantOneNewUserData.get("homephone");
		String mobilePhone = addCouponForWantOneNewUserData.get("mobilephone");
		String cardlessId = addCouponForWantOneNewUserData.get("cardlessid");
		String wantedCouponNumber = addCouponForWantOneNewUserData.get("wantedCoupon");
		
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
			
		cp = new CouponPage(_driver);
		
		cp.clickOnCouponsInMyToolsHomePage();
		
		cp.loadCompleteCouponsPage();
			log.info("Coupons Page is loaded fully");
		
		cp.addNthCoupon(_driver, wantedCouponNumber);
			log.info("Added nth coupon");

			
		String addedCouponName = cp.getNthCouponName(_driver, wantedCouponNumber);
		
		ecp = new MyeCouponsPage(_driver);
		
		ecp.clickOnMyeCouponsInMyToolsHomePage();
		
		boolean result = ecp.isCouponPresent(addedCouponName);
		
		System.out.println("Result is " + result);
		Assert.assertTrue(result);
		
	}
	/*		
	@Test(enabled=false)
	public void addCouponForNoCardNewUser() throws XPathExpressionException, ParserConfigurationException, SAXException, IOException, InterruptedException{
		
		Map<String, String> addCouponForNoCardNewUserData = readxml.getUserData("TestData.xml", "new-user-2");
		String userId = addCouponForNoCardNewUserData.get("UserName");
		String password = addCouponForNoCardNewUserData.get("password");
	String firstName = addCouponForNoCardNewUserData.get("firstname");
		String lastName = addCouponForNoCardNewUserData.get("lastname");
		String address1 = addCouponForNoCardNewUserData.get("address1");
		String address2 = addCouponForNoCardNewUserData.get("address2");
		String city = addCouponForNoCardNewUserData.get("city");
		String state = addCouponForNoCardNewUserData.get("state");
		String zip = addCouponForNoCardNewUserData.get("zipcode");
		String homePhone = addCouponForNoCardNewUserData.get("homephone");
		String mobilePhone = addCouponForNoCardNewUserData.get("mobilephone");
		String cardlessId = addCouponForNoCardNewUserData.get("cardlessid");
		String wantedCouponNumber = addCouponForNoCardNewUserData.get("wantedCoupon");
		
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
			
		cp = new CouponPage(_driver);
		
		cp.clickOnCouponsInMyToolsHomePage();
		
		cp.loadCompleteCouponsPage();
			log.info("Coupons Page is loaded fully");
		
		cp.addNthCoupon(_driver, wantedCouponNumber);
			log.info("Added nth coupon");

			
		String addedCouponName = cp.getNthCouponName(_driver, wantedCouponNumber);
		
		ecp = new MyeCouponsPage(_driver);
		
		ecp.clickOnMyeCouponsInMyToolsHomePage();
		
		boolean result = ecp.isCouponPresent(addedCouponName);
		
		System.out.println("Result is " + result);
		Assert.assertTrue(result);
		
	} */
}

