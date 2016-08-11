package com.test.regression.cub.testscripts;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
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
import com.test.regression.cub.pages.MyeCouponsPage;
import com.test.regression.cub.pages.ShoppingListPage;
import com.test.regression.cub.pages.SignUpPage;
import com.test.regression.cub.utils.Logg;
import com.test.regression.cub.utils.ReadXML;
import com.test.regression.cub.utils.SuiteBase;

public class Coupons extends SuiteBase{

	CubHome cubHome;
	CouponPage cp;
	SignUpPage signUpPage;
	MyeCouponsPage ecp;
	MyAccountPage map ;
	ShoppingListPage slpage;
	Logger log = Logg.createLogger();
	ReadXML readxml = new ReadXML();
	
	@Test(priority=11, enabled=true)
	public void addCouponForAuthorizedUser() {
		try{
			
			SoftAssert sa = new SoftAssert();
		Map<String, String> newSL = readxml.getUserData("TestData.xml", "authorized-user-2");
		String userId = newSL.get("UserName");
		String password = newSL.get("password");
		String wantedCouponNumber = newSL.get("CouponToAdd");
		
		cubHome = new CubHome(_driver);
		
		try{
		cubHome.completeSignIn(userId, password);
			log.info("Signed In Successfully");
		
			Thread.sleep(5000);
		cp = new CouponPage(_driver);
		
		
			cp.clickOnCouponsInMyToolsHomePage(_driver);
			
			//cp.loadCompleteCouponsPage(_driver);
			log.info("Coupons Page is loaded fully");
		}catch(UnhandledAlertException al){
			_driver.switchTo().alert().accept();
		}
		
			
		String addedCouponName = cp.addSingleCoupon(_driver, wantedCouponNumber);
		
		String couponNameInSl = cp.getCouponName(_driver, wantedCouponNumber);
		
		Thread.sleep(5000);
		ecp = new MyeCouponsPage(_driver);
		
		ecp.clickOnMyeCouponsInMyToolsHomePage(_driver);
		
		Thread.sleep(5000);
		boolean result = ecp.isCouponPresent(addedCouponName);
		
		System.out.println("Result is " + result);
		sa.assertTrue(result, "Oops! Some problem while adding coupon");
		
		slpage = new ShoppingListPage(_driver);
		
		slpage.clickOnMyListInMyToolsHomePage(_driver);
		
		boolean result2 = slpage.isItemPresentInSL(_driver, couponNameInSl);
		
		sa.assertTrue(result2, "Coupon name is not added in Shopping list..");
		
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
	
	
	
	@Test(priority=12, enabled=false)
	public void addCouponForWantOneNewUser() {
		try {
		Map<String, String> addCouponForWantOneNewUserData = readxml.getUserData("TestData.xml", "new-user-5");
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
		try{
		signUpPage.clickSignUpLink();
			log.info("Test Data Used >>>>>>>");
			log.info("User Name : " + userId);
			log.info("Password : " + password);
		signUpPage.enterSignUpDetails(userId,password);
			
		signUpPage.clickNoButWantCardRadio();
			
		signUpPage.clickContinueButton();
		signUpPage.enterContactInformationInSignUp(firstName, lastName, address1, address2, city, state, zip, homePhone, mobilePhone, cardlessId);		
			
		signUpPage.clickUseThisAddressButton();
		Thread.sleep(5000);
		
		cp = new CouponPage(_driver);
		
		
			//cubHome.clickCouponTile(_driver);	
			cp.clickOnCouponsInMyToolsHomePage(_driver);

			//cp.loadCompleteCouponsPage(_driver);
				//log.info("Coupons Page is loaded fully");
		}catch(UnhandledAlertException al){
			_driver.switchTo().alert().accept();
		}
		
		Thread.sleep(5000);
			
		// Delimiting the wanted coupon numbers' data
			
		List<String> allWantedCouponNumbers = Arrays.asList(allWantedCouponNumbersInString.split(","));
		int size=allWantedCouponNumbers.size();
		
		cp.addListOfCoupons(allWantedCouponNumbers);
		
		/*for(String wantedCouponNumber : allWantedCouponNumbers){
		
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
		
		}*/
		
		Thread.sleep(5000);
		ecp = new MyeCouponsPage(_driver);
		
		ecp.clickOnMyeCouponsInMyToolsHomePage(_driver);
			log.info("Validating whether the added coupon is in My eCoupons page");
					
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
		Map<String, String> addCouponForNoCardNewUserData = readxml.getUserData("TestData.xml", "new-user-4");
		String userId = addCouponForNoCardNewUserData.get("UserName");
		String password = addCouponForNoCardNewUserData.get("password");
		String allWantedCouponNumbersInString = addCouponForNoCardNewUserData.get("wantedCoupons");
		String cardlessId = addCouponForNoCardNewUserData.get("cardlessid");
		//String cardlessId7 = addCouponForNoCardNewUserData.get("cardlessid7");
		//String cardlessId4 = addCouponForNoCardNewUserData.get("cardlessid4");
		
		String cardlessId7 = cardlessId.substring(0, 7);
		String cardlessId4 = cardlessId.substring(7, 11);
		
		String addedCouponName = null;
		
		signUpPage = new SignUpPage(_driver);
			log.info("Test Data Used >>>>>>>");
			log.info("User Name : " + userId);
			log.info("Password : " + password);
			try{
		signUpPage.clickSignUpLink();
			
		signUpPage.enterSignUpDetails(userId,password);

			Thread.sleep(5000);
		signUpPage.closeRewardsCardPopup();
			
		cp = new CouponPage(_driver);
		
		
			cp.clickOnCouponsInMyToolsHomePage(_driver);
			//cp.loadCompleteCouponsPage(_driver);
			//log.info("Coupons Page is loaded fully");
		}catch(UnhandledAlertException al){
			_driver.switchTo().alert().accept();
		}
		
		Thread.sleep(5000);	
		// Delimiting the wanted coupon numbers' data
			
		List<String> allWantedCouponNumbers = Arrays.asList(allWantedCouponNumbersInString.split(","));
		int size=allWantedCouponNumbers.size();
		String firstWantedCoupon = allWantedCouponNumbers.get(0);
		List<String> otherWantedCoupons = allWantedCouponNumbers.subList(1, size);
			
	// Adding First Coupon
		
		cp.addSingleCouponWithCardlessId(firstWantedCoupon, cardlessId7, cardlessId4);
			
	if(size>1){
		
		cp.addListOfCoupons(otherWantedCoupons);
		
		
		Thread.sleep(5000);
		
		ecp = new MyeCouponsPage(_driver);
		
		ecp.clickOnMyeCouponsInMyToolsHomePage(_driver);
			log.info("Validating whether the added coupon is in My eCoupons page");
			
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
	
	
	@Test(priority=11, enabled=false)
	public void couponPageFullLoad() throws XPathExpressionException, ParserConfigurationException, SAXException, IOException, InterruptedException{
		
		
/*		Map<String, String> addCouponForNoCardNewUserData = readxml.getUserData("TestData.xml", "new-user-coupon4");
		String userId = addCouponForNoCardNewUserData.get("UserName");
		String password = addCouponForNoCardNewUserData.get("password");
		
		signUpPage = new SignUpPage(_driver);
			log.info("Test Data Used >>>>>>>");
			log.info("User Name : " + userId);
			log.info("Password : " + password);
		
		signUpPage.clickSignUpLink();
			
		signUpPage.enterSignUpDetails(userId,password);

			Thread.sleep(5000);
		signUpPage.closeRewardsCardPopup();*/
		
		cp = new CouponPage(_driver);
		int couponCountFromAddItemButton = 0;
		
		try{
			cp.clickOnCouponsInMyToolsHomePage(_driver);
			
			cp.loadCompleteCouponsPage(_driver);
			log.info("Coupons Page is loaded fully");
		}catch(UnhandledAlertException al){
			_driver.switchTo().alert().accept();
		}	
		
		cp.clcikOnTopButton();
		
		couponCountFromAddItemButton = cp.couponCount();
		// int couponCountFromAddItemButton = cp.loadCompleteCouponsPage(_driver);
			log.info("Coupons Page is loaded fully with "+couponCountFromAddItemButton+" Coupons...");
		
		Thread.sleep(5000);	
		int couponCountFromMsg = cp.totalNoOfCoupons();
		System.out.println("Coupon Count is " + couponCountFromMsg);
		
		Thread.sleep(5000);
		Assert.assertEquals(couponCountFromAddItemButton,couponCountFromMsg);
		
	}
	
	@Test(priority=13, enabled=false)
	public void addCouponForNoCardNotNowCardlessIdNewUser() {
		
		try {
		Map<String, String> addCouponForNoCardNewUserData = readxml.getUserData("TestData.xml", "new-user-6");
		
		String userId = addCouponForNoCardNewUserData.get("UserName");
		String password = addCouponForNoCardNewUserData.get("password");
		String allWantedCouponNumbersInString = addCouponForNoCardNewUserData.get("wantedCoupons");
		String cardlessId = addCouponForNoCardNewUserData.get("cardlessid");
		//String cardlessId7 = addCouponForNoCardNewUserData.get("cardlessid7");
		//String cardlessId4 = addCouponForNoCardNewUserData.get("cardlessid4");
		
		String cardlessId7 = cardlessId.substring(0, 7);
		String cardlessId4 = cardlessId.substring(7, 11);
		
		//String addedCouponName = null;
		
		SoftAssert sa = new SoftAssert();
		
		signUpPage = new SignUpPage(_driver);
			log.info("Test Data Used >>>>>>>");
			log.info("User Name : " + userId);
			log.info("Password : " + password);
			try{
		signUpPage.clickSignUpLink();
			
		signUpPage.enterSignUpDetails(userId,password);

			Thread.sleep(5000);
		signUpPage.closeRewardsCardPopup();
			
		cp = new CouponPage(_driver);
		
		
			cp.clickOnCouponsInMyToolsHomePage(_driver);
			//cp.loadCompleteCouponsPage(_driver);
			//log.info("Coupons Page is loaded fully");
		}catch(UnhandledAlertException al){
			_driver.switchTo().alert().accept();
		}
		
		Thread.sleep(5000);	
		// Delimiting the wanted coupon numbers' data
			
		List<String> allWantedCouponNumbers = Arrays.asList(allWantedCouponNumbersInString.split(","));
		int size=allWantedCouponNumbers.size();
		String firstWantedCoupon = allWantedCouponNumbers.get(0);
		List<String> otherWantedCoupons = allWantedCouponNumbers.subList(1, size);
			
		// Adding First Coupon		
		
		cp.addSingleCouponWithNotNowInCardlessIdPopup(firstWantedCoupon, cardlessId7, cardlessId4);
		
			/*boolean isFirstCouponFlipp = cp.chkIfFlipp(_driver, firstWantedCoupon);
			System.out.println("isCouponFlipp value is "+ isFirstCouponFlipp);
			
			String firstAddedCouponName;
			
			if(isFirstCouponFlipp){
					log.info("Trying to add Flipp Coupon");
				cp.addNthFlippCoupon(_driver, firstWantedCoupon);
					log.info("Added wanted Flipp coupon");
				cp.enterCardlessId(cardlessId7, cardlessId4);
					log.info("Entered Cardless Id Details");
				cp.clickNotNowInCardlessIdPopup();
		
				firstAddedCouponName = cp.getNthFlippCouponName(_driver, firstWantedCoupon);
					log.info("Added Coupon Name : " + firstAddedCouponName);
			}
			else{
					log.info("Trying to add Inmar Coupon");
				cp.addNthInmarCoupon(_driver, firstWantedCoupon);
					log.info("Added wanted Inmar Coupon");
				cp.enterCardlessId(cardlessId7, cardlessId4);
					log.info("Entered Cardless Id Details");
				cp.clickNotNowInCardlessIdPopup();
			
				firstAddedCouponName = cp.getNthInmarCouponName(_driver, firstWantedCoupon);
					log.info("Added Coupon Name : " + firstAddedCouponName);
			}*/
			
			if(size>1){
				
				cp.addListOfCoupons(otherWantedCoupons);
		
		/*for(String wantedCouponNumber : otherWantedCoupons){
		
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
		}*/
		
		Thread.sleep(5000);
		
		ecp = new MyeCouponsPage(_driver);
		
		ecp.clickOnMyeCouponsInMyToolsHomePage(_driver);
			log.info("Validating whether the added coupon is in My eCoupons page");
			
		}
		
		int eCouponsNumber = ecp.noOfECoupons();
		
		sa.assertTrue(size == eCouponsNumber, "No. of wanted coupons does not match with the count of eCoupons in eCoupons page");
		
		map = new MyAccountPage(_driver);
		
		map.clickOnMyAccountUnderMyTools(_driver);
		boolean result = map.chkCardlessIdPresent();
		
		System.out.println("Result is : " + result);
		
		sa.assertTrue(result, "Oops! Cardless Id is present in My Account page even when the user has not entered..");
		
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
	
	@Test(priority=14, enabled=false)
	public void chkCouponSort() throws InterruptedException{
		
		SoftAssert sa = new SoftAssert();
		
		cp = new CouponPage(_driver);
		
		try{
			cp.clickOnCouponsInMyToolsHomePage(_driver);
			
			
			
			int noOfAddItemButtons = cp.loadCompleteCouponsPage(_driver);
			log.info("Coupons Page is loaded fully with " + noOfAddItemButtons + " Coupons");
		
		}catch(UnhandledAlertException al){
			_driver.switchTo().alert().accept();
		}
		
		/*cp.selectValueFromCouponSortChkBox("Item");
		
		try{
			
			cp.loadCompleteCouponsPage(_driver);
			log.info("Coupons Page is loaded fully");
		}catch(UnhandledAlertException al){
			_driver.switchTo().alert().accept();
		}*/
		
		cp.clcikOnTopButton();
		
		cp.selectValueFromCouponSortChkBox("Item");
	
		
		
		List<String> couponItemDisplayOrder = new LinkedList<String>();
		
		couponItemDisplayOrder = cp.getCouponNamesOnDisplayOrder(_driver);
		
		boolean chkSortOrder = cp.chkAlphabeticalOrder(couponItemDisplayOrder);
		
		System.out.println("Result of item sort is :" + chkSortOrder);
		
		sa.assertTrue(chkSortOrder, "Oops! The Coupons are not sorted properly on Item Name");
		
	/* **************************** */	
	
		cp.selectValueFromCouponSortChkBox("Expiration");
		
		try{
			

			int noOfAddItemButtons1 = cp.loadCompleteCouponsPage(_driver);
			log.info("Coupons Page is loaded fully with " + noOfAddItemButtons1 + " Coupons after Expiration sort");
		
		}catch(UnhandledAlertException al){
			_driver.switchTo().alert().accept();
		}
		List<String> couponExpiryDateOrder = new LinkedList<String>();
		
		couponExpiryDateOrder = cp.getCouponNamesOnDisplayOrder(_driver);
		
		boolean chkSortExpiryDate = cp.compare2lists(couponItemDisplayOrder,couponExpiryDateOrder);
		
		System.out.println("Result is :" + chkSortExpiryDate);
		
		sa.assertFalse(chkSortExpiryDate, "Oops! The Coupons are not sorted properly on Expiry Date");
		
		sa.assertAll();
		
	}
	
	
	
	@Test(priority=11, enabled=false)
	public void addCouponFromCouponDetailsPageForAuthorizedUser() {
		try{
		Map<String, String> newSL = readxml.getUserData("TestData.xml", "authorized-user-3");
		String userId = newSL.get("UserName");
		String password = newSL.get("password");
		String wantedCouponNumber = newSL.get("CouponToAdd");
		
		SoftAssert sa = new SoftAssert();
		
		cubHome = new CubHome(_driver);
		
		try{
		cubHome.completeSignIn(userId, password);
			log.info("Signed In Successfully");
		
			Thread.sleep(5000);
		cp = new CouponPage(_driver);
		
		
			cp.clickOnCouponsInMyToolsHomePage(_driver);
			
			//cp.loadCompleteCouponsPage(_driver);
			//log.info("Coupons Page is loaded fully");
		
			Thread.sleep(5000);
			
		cp.navigateToCouponDetailPage(_driver, wantedCouponNumber);
		
		
		cp.clickOnAddItemInCouponDetailsPage();
		
		String addedCouponName = cp.getCouponNameFromCouponDetailsPage();
		
		boolean result1 = cp.clickCouponDetailsLink();
		
		sa.assertTrue(result1, "Coupon details tab is not high-lighted on Coupon  Details Page");
		
		boolean result2 = cp.clickTermsNConditionsLink();
		
		sa.assertTrue(result2, "Terms and Conditions tab is not high-lighted on Coupon  Details Page");
		
		
		Thread.sleep(5000);
		ecp = new MyeCouponsPage(_driver);
		
		ecp.clickOnMyeCouponsInMyToolsHomePage(_driver);
		
		Thread.sleep(5000);
		boolean result = ecp.isCouponPresent(addedCouponName);
		
		System.out.println("Result is " + result);
		
		sa.assertTrue(result, "Unable to add coupon from Coupon Details Page");
		
		}catch(UnhandledAlertException al){
			_driver.switchTo().alert().accept();
		}
		
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
	
	@Test(priority=12, enabled=false)
	public void categoryTestInCoupons() {
		
		try{
		cp = new CouponPage(_driver);
		
		
		try{
			cp.clickOnCouponsInMyToolsHomePage(_driver);
			
		}catch(UnhandledAlertException al){
			_driver.switchTo().alert().accept();
		} 
		
		String wantedCategory = "General";
		
		cp.selectCatergory(wantedCategory);
		
		boolean result = cp.getSelectedCategory(wantedCategory);
		
		Assert.assertTrue(result);
		}
		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	

	@Test(priority=11, enabled=false)
	public void searchTestInCoupons() {
		
		try{
		cp = new CouponPage(_driver);
		
		
		try{
			cp.clickOnCouponsInMyToolsHomePage(_driver);
			
		}catch(UnhandledAlertException al){
			_driver.switchTo().alert().accept();
		} 
		
		String wantedSearchText = "save";
		
		cp.searchForAnItemInCoupons(wantedSearchText);
		
		boolean result = cp.getSelectedCategory(wantedSearchText);
		
		Assert.assertTrue(result);
		}
		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	}
	


