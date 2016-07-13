package com.test.regression.cub.testscripts;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
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
	
	@Test(priority=11, enabled=false)
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
			boolean isCouponFlipp = cp.chkIfFlipp(_driver, wantedCouponNumber);
			
			System.out.println("isCouponFlipp value : "+ isCouponFlipp);
			String addedCouponName = null;
			if(isCouponFlipp = true){
				
				cp.addNthFlippCoupon(_driver, wantedCouponNumber);
					log.info("Added nth coupon");

				
				addedCouponName  = cp.getNthFlippCouponName(_driver, wantedCouponNumber);
				}
				
				else if(isCouponFlipp = false){
					cp.addNthInmarCoupon(_driver, wantedCouponNumber);
					log.info("Added nth coupon");

				
				addedCouponName = cp.getNthInmarCouponName(_driver, wantedCouponNumber);
				}	
		
		ecp = new MyeCouponsPage(_driver);
		
		ecp.clickOnMyeCouponsInMyToolsHomePage(_driver);
		
		boolean result = ecp.isCouponPresent(addedCouponName);
		
		System.out.println("Result is " + result);
		Assert.assertTrue(result);
		
	}
	
	
	
	@Test(priority=12, enabled=false)
	public void addCouponForWantOneNewUser() {
		try {
		Map<String, String> addCouponForWantOneNewUserData = readxml.getUserData("TestData.xml", "new-user-coupon2");
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
		String allWantedCouponNumbersInString = addCouponForWantOneNewUserData.get("wantedCoupons");
		String addedCouponName = null;
		
		signUpPage = new SignUpPage(_driver);
		
		signUpPage.clickSignUpLink();
			log.info("Test Data Used >>>>>>>");
			log.info("User Name : " + userId);
			log.info("Password : " + password);
		signUpPage.enterSignUpDetails(userId,password);
			
		signUpPage.clickNoButWantCardRadio();
			
		signUpPage.clickContinueButton();
		signUpPage.enterContactInformationInSignUp(firstName, lastName, address1, address2, city, state, zip, homePhone, mobilePhone, cardlessId);		
			
		signUpPage.clickUseThisAddressButton();
			
			
		cp = new CouponPage(_driver);
		
		cp.clickOnCouponsInMyToolsHomePage();
			log.info("In Coupons page now..");
		//cp.loadCompleteCouponsPage();
			//log.info("Coupons Page is loaded fully");
			
		// Delimiting the wanted coupon numbers' data
			
		List<String> allWantedCouponNumbers = Arrays.asList(allWantedCouponNumbersInString.split(","));
		int size=allWantedCouponNumbers.size();
		
		for(String wantedCouponNumber : allWantedCouponNumbers){
		
		// Check if wantedCouponNumber is Flipp or Inmar
			
		boolean isCouponFlipp = cp.chkIfFlipp(_driver, wantedCouponNumber);
		System.out.println("isCouponFlipp value is "+ isCouponFlipp);
			
		
		if(isCouponFlipp){
				log.info("Trying to add Flipp Coupon");
			cp.addNthFlippCoupon(_driver, wantedCouponNumber);
				log.info("Added wanted Flipp coupon");
	
			addedCouponName = cp.getNthFlippCouponName(_driver, wantedCouponNumber);
				log.info("Added Coupon Name : " + addedCouponName);
		}
		else{
				log.info("Trying to add Inmar Coupon");
			cp.addNthInmarCoupon(_driver, wantedCouponNumber);
				log.info("Added wanted Inmar Coupon");
		
			addedCouponName = cp.getNthInmarCouponName(_driver, wantedCouponNumber);
				log.info("Added Coupon Name : " + addedCouponName);
		}
		
		}
		ecp = new MyeCouponsPage(_driver);
		
		ecp.clickOnMyeCouponsInMyToolsHomePage(_driver);
			log.info("Validating whether the added coupon is in My eCoupons page");
			
		/*boolean result = ecp.isCouponPresent(addedCouponName);
		if(result)
			log.info(addedCouponName + " is present in My eCoupons Page");
		else
			log.info(addedCouponName + " is NOT present in My eCoupons Page");*/
		
		
		int eCouponsNumber = ecp.noOfECoupons();
		
		Assert.assertTrue(size == eCouponsNumber);
		
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
	

	
	// Sign Up for an account just by closing the Rewards Card pop up
	// So, it will prompt for card-less id while trying to add coupon
			
	@Test(priority=13, enabled=false)
	public void addCouponForNoCardNewUser() {
		
		try {
		Map<String, String> addCouponForNoCardNewUserData = readxml.getUserData("TestData.xml", "new-user-coupon1");
		String userId = addCouponForNoCardNewUserData.get("UserName");
		String password = addCouponForNoCardNewUserData.get("password");
		String allWantedCouponNumbersInString = addCouponForNoCardNewUserData.get("wantedCoupons");
		String cardlessId7 = addCouponForNoCardNewUserData.get("cardlessid7");
		String cardlessId4 = addCouponForNoCardNewUserData.get("cardlessid4");
		String addedCouponName = null;
		
		signUpPage = new SignUpPage(_driver);
			log.info("Test Data Used >>>>>>>");
			log.info("User Name : " + userId);
			log.info("Password : " + password);
		
		signUpPage.clickSignUpLink();
			
		signUpPage.enterSignUpDetails(userId,password);

			Thread.sleep(5000);
		signUpPage.closeRewardsCardPopup();
			
		cp = new CouponPage(_driver);
		
		cp.clickOnCouponsInMyToolsHomePage();
			log.info("In Coupons page now..");
		//cp.loadCompleteCouponsPage();
			//log.info("Coupons Page is loaded fully");
			
		// Delimiting the wanted coupon numbers' data
			
		List<String> allWantedCouponNumbers = Arrays.asList(allWantedCouponNumbersInString.split(","));
		int size=allWantedCouponNumbers.size();
		String firstWantedCoupon = allWantedCouponNumbers.get(0);
		List<String> otherWantedCoupons = allWantedCouponNumbers.subList(1, size);
			
	// Adding First Coupon		
			boolean isFirstCouponFlipp = cp.chkIfFlipp(_driver, firstWantedCoupon);
			System.out.println("isCouponFlipp value is "+ isFirstCouponFlipp);
			
			String firstAddedCouponName;
			
			if(isFirstCouponFlipp){
					log.info("Trying to add Flipp Coupon");
				cp.addNthFlippCoupon(_driver, firstWantedCoupon);
					log.info("Added wanted Flipp coupon");
				cp.enterCardlessId(cardlessId7, cardlessId4);
					log.info("Entered Cardless Id Details");
				cp.clickContinueAfterAddingCardlessIdCongratsPopup();
		
				firstAddedCouponName = cp.getNthFlippCouponName(_driver, firstWantedCoupon);
					log.info("Added Coupon Name : " + firstAddedCouponName);
			}
			else{
					log.info("Trying to add Inmar Coupon");
				cp.addNthInmarCoupon(_driver, firstWantedCoupon);
					log.info("Added wanted Inmar Coupon");
				cp.enterCardlessId(cardlessId7, cardlessId4);
					log.info("Entered Cardless Id Details");
				cp.clickContinueAfterAddingCardlessIdCongratsPopup();
			
				firstAddedCouponName = cp.getNthInmarCouponName(_driver, firstWantedCoupon);
					log.info("Added Coupon Name : " + firstAddedCouponName);
			}
			
	if(size>1){
		
		for(String wantedCouponNumber : otherWantedCoupons){
		
		// Check if wantedCouponNumber is Flipp or Inmar
			
		boolean isCouponFlipp = cp.chkIfFlipp(_driver, wantedCouponNumber);
		System.out.println("isCouponFlipp value is "+ isCouponFlipp);
			
		
		if(isCouponFlipp){
				log.info("Trying to add Flipp Coupon");
			cp.addNthFlippCoupon(_driver, wantedCouponNumber);
				log.info("Added wanted Flipp coupon");
	
			addedCouponName = cp.getNthFlippCouponName(_driver, wantedCouponNumber);
				log.info("Added Coupon Name : " + addedCouponName);
		}
		else{
				log.info("Trying to add Inmar Coupon");
			cp.addNthInmarCoupon(_driver, wantedCouponNumber);
				log.info("Added wanted Inmar Coupon");
		
			addedCouponName = cp.getNthInmarCouponName(_driver, wantedCouponNumber);
				log.info("Added Coupon Name : " + addedCouponName);
		}
		}
		
		ecp = new MyeCouponsPage(_driver);
		
		ecp.clickOnMyeCouponsInMyToolsHomePage(_driver);
			log.info("Validating whether the added coupon is in My eCoupons page");
			
		/*boolean result = ecp.isCouponPresent(addedCouponName);
		if(result)
			log.info(addedCouponName + " is present in My eCoupons Page");
		else
			log.info(addedCouponName + " is NOT present in My eCoupons Page");*/
		}
		
		int eCouponsNumber = ecp.noOfECoupons();
		
		Assert.assertTrue(size == eCouponsNumber);
		
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
	


