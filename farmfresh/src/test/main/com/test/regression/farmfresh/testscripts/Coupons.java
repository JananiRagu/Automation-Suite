

/********************************************************COUPONS TESTING*********************************************************************************************************************************
 * 
 * ================================================================================================================================================================================================
 *                                  Test Cases Covered as part of Coupons Functionality
 * ================================================================================================================================================================================================
 * 
 * TC 1. 'addCouponForAuthorizedUser'                       =>   Add a Single Coupon for the Authorized User                                                                                      *
 * 
 * TC 2. 'addCouponForWantOneNewUser'                       =>   Adds a list of Coupons for a newly Signed Up User who has selected 'I don't Have a card, But want one' option during sign up     *
 * 
 * TC 3. 'addCouponForNoCardNewUser'                        =>   Adds a list of Coupons for a newly Signed Up User who has selected 'I don't want a card' option during sign up                   *
 * 
 * TC 4. 'couponPageFullLoad'                               =>   Validates if the User is able to load the complete coupon page                                                                   *
 * 
 * TC 5. 'addCouponForNoCardNotNowCardlessIdNewUser'        =>   Adds a list of Coupons for a new user by selecting 'Not Now' in CardlessId pop up                                                *
 * 
 * TC 6. 'chkCouponSort'                                    =>   Validates Sorting Functionality on Alphabetical Order & Expiration Date                                                          *
 * 
 * TC 7. 'addCouponFromCouponDetailsPageForAuthorizedUser'  =>   Add a Single Coupon for the Authorized User from Coupon Details page                                                             *
 * 
 * TC 8. 'categoryTestInCoupons'                            =>   Validates Filter Functionality on Coupons                                                                                        *
 * 
 * TC 9. 'searchTestInCoupons'                              =>   Validates Search Functionality on Coupons                                                                                        *
 * 
 * ================================================================================================================================================================================================
 */


package com.test.regression.farmfresh.testscripts;

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

import com.test.regression.farmfresh.pages.CouponPage;
import com.test.regression.farmfresh.pages.FFHome;
import com.test.regression.farmfresh.pages.MyAccountPage;
import com.test.regression.farmfresh.pages.MyeCouponsPage;
import com.test.regression.farmfresh.pages.ShoppingListPage;
import com.test.regression.farmfresh.pages.SignUpPage;
import com.test.regression.farmfresh.utils.Logg;
import com.test.regression.farmfresh.utils.ReadXML;
import com.test.regression.farmfresh.utils.SuiteBase;

public class Coupons extends SuiteBase {

	FFHome cubHome;
	CouponPage cp;
	SignUpPage signUpPage;
	MyeCouponsPage ecp;
	MyAccountPage map;
	ShoppingListPage slpage;
	Logger log = Logg.createLogger();
	ReadXML readxml = new ReadXML();
	
	/* Add a Single Coupon for the Authorized User  */

	@Test(priority = 11, enabled = true)
	public void addCouponForAuthorizedUser() {
		try {

			SoftAssert sa = new SoftAssert();
			
			Map<String, String> newSL = readxml.getUserData("TestData.xml", "authorized-user-2");
			
			String userId = newSL.get("UserName");
			String password = newSL.get("password");
			String wantedCouponNumber = newSL.get("CouponToAdd");

			cubHome = new FFHome(_driver);

			cubHome.completeSignIn(userId, password);
			log.info("Signed In Successfully");

			Thread.sleep(5000);
			cp = new CouponPage(_driver);

			cp.clickOnCouponsInMyToolsHomePage(_driver);

			cp.loadCompleteCouponsPage(_driver);
			log.info("Coupons Page is loaded fully");

			String addedCouponName = cp.addSingleCoupon(_driver, wantedCouponNumber);

			String couponNameInSl = cp.getCouponName(_driver, wantedCouponNumber);

			Thread.sleep(5000);
			ecp = new MyeCouponsPage(_driver);

			ecp.clickOnMyeCouponsInMyToolsHomePage(_driver);

			Thread.sleep(5000);
			boolean result = ecp.isCouponPresent(addedCouponName);

			log.info("Is Coupon present in My eCoupons Page" + result);
			
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
		} catch (UnhandledAlertException al) {
			_driver.switchTo().alert().accept();
		} catch (Exception e) {
			log.info(e.getMessage());
			Assert.fail(e.getLocalizedMessage());
		}

	}
	
	/*   Adds a list of Coupons for a newly Signed Up User who has selected 'I don't Have a card, But want one' option during sign up  */

	@Test(priority = 12, enabled = true)
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
			signUpPage = new SignUpPage(_driver);
			try {
				signUpPage.clickSignUpLink();
				log.info("Test Data Used >>>>>>>");
				log.info("User Name : " + userId);
				log.info("Password : " + password);
				signUpPage.enterSignUpDetails(userId, password);

				signUpPage.clickNoButWantCardRadio();

				signUpPage.clickContinueButton();
				signUpPage.enterContactInformationInSignUp(firstName, lastName, address1, address2, city, state, zip,
						homePhone, mobilePhone, cardlessId);

				signUpPage.clickUseThisAddressButton();
				Thread.sleep(5000);

				cp = new CouponPage(_driver);

				cp.clickOnCouponsInMyToolsHomePage(_driver);

			} catch (UnhandledAlertException al) {
				_driver.switchTo().alert().accept();
			}

			Thread.sleep(5000);

			// Delimiting the wanted coupon numbers' data

			List<String> allWantedCouponNumbers = Arrays.asList(allWantedCouponNumbersInString.split(","));
			int size = allWantedCouponNumbers.size();

			cp.addListOfCoupons(allWantedCouponNumbers);


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

	@Test(priority = 13, enabled = true)
	public void addCouponForNoCardNewUser() {

		try {
			Map<String, String> addCouponForNoCardNewUserData = readxml.getUserData("TestData.xml", "new-user-4");
			String userId = addCouponForNoCardNewUserData.get("UserName");
			String password = addCouponForNoCardNewUserData.get("password");
			String allWantedCouponNumbersInString = addCouponForNoCardNewUserData.get("wantedCoupons");
			String cardlessId = addCouponForNoCardNewUserData.get("cardlessid");
			String cardlessId7 = cardlessId.substring(0, 7);
			String cardlessId4 = cardlessId.substring(7, 11);

			signUpPage = new SignUpPage(_driver);
			log.info("Test Data Used >>>>>>>");
			log.info("User Name : " + userId);
			log.info("Password : " + password);
			try {
				signUpPage.clickSignUpLink();

				signUpPage.enterSignUpDetails(userId, password);

				Thread.sleep(5000);
				signUpPage.closeRewardsCardPopup();

				cp = new CouponPage(_driver);

				cp.clickOnCouponsInMyToolsHomePage(_driver);

			} catch (UnhandledAlertException al) {
				_driver.switchTo().alert().accept();
			}

			Thread.sleep(5000);
			// Delimiting the wanted coupon numbers' data

			List<String> allWantedCouponNumbers = Arrays.asList(allWantedCouponNumbersInString.split(","));
			int size = allWantedCouponNumbers.size();
			String firstWantedCoupon = allWantedCouponNumbers.get(0);
			List<String> otherWantedCoupons = allWantedCouponNumbers.subList(1, size);

			// Adding First Coupon

			cp.addSingleCouponWithCardlessId(firstWantedCoupon, cardlessId7, cardlessId4);

			if (size > 1) {

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
		} catch (UnhandledAlertException al) {
			_driver.switchTo().alert().accept();
		} catch (Exception e) {
			log.info(e.getMessage());
			Assert.fail(e.getLocalizedMessage());
		}
	}
	
	/* Validate Coupons Page is loaded fully */

	@Test(priority = 11, enabled = true)
	public void couponPageFullLoad()  {

		cp = new CouponPage(_driver);
		int couponCountFromAddItemButton = 0;

		try {
			cp.clickOnCouponsInMyToolsHomePage(_driver);

			cp.loadCompleteCouponsPage(_driver);
			log.info("Coupons Page is loaded fully");
		

		cp.clcikOnTopButton();

		couponCountFromAddItemButton = cp.couponCount();

		log.info("Coupons Page is loaded fully with " + couponCountFromAddItemButton + " Coupons...");

		Thread.sleep(5000);
		int couponCountFromMsg = cp.totalNoOfCoupons();
		log.info("Coupon Count is " + couponCountFromMsg);

		Thread.sleep(5000);
		Assert.assertEquals(couponCountFromAddItemButton, couponCountFromMsg);
		
		} catch (UnhandledAlertException al) {
			_driver.switchTo().alert().accept();
		} catch (InterruptedException ie) {
			log.info(ie.getMessage());
			Assert.fail("Caught Interrupted Exception");
		}catch (IOException ioe) {
			log.info(ioe.getMessage());
			Assert.fail("Caught IOException Exception");
		}

	}

	/* Adds a list of Coupons for a new user by selecting 'Not Now' in CardlessId pop up  */
	
	@Test(priority = 13, enabled = true)
	public void addCouponForNoCardNotNowCardlessIdNewUser() {

		try {
			Map<String, String> addCouponForNoCardNewUserData = readxml.getUserData("TestData.xml", "new-user-6");

			String userId = addCouponForNoCardNewUserData.get("UserName");
			String password = addCouponForNoCardNewUserData.get("password");
			String allWantedCouponNumbersInString = addCouponForNoCardNewUserData.get("wantedCoupons");
			String cardlessId = addCouponForNoCardNewUserData.get("cardlessid");
			String cardlessId7 = cardlessId.substring(0, 7);
			String cardlessId4 = cardlessId.substring(7, 11);


			SoftAssert sa = new SoftAssert();

			signUpPage = new SignUpPage(_driver);
			log.info("Test Data Used >>>>>>>");
			log.info("User Name : " + userId);
			log.info("Password : " + password);
			
				signUpPage.clickSignUpLink();

				signUpPage.enterSignUpDetails(userId, password);

				Thread.sleep(5000);
				signUpPage.closeRewardsCardPopup();

				cp = new CouponPage(_driver);

				cp.clickOnCouponsInMyToolsHomePage(_driver);

			

			Thread.sleep(5000);
			// Delimiting the wanted coupon numbers' data

			List<String> allWantedCouponNumbers = Arrays.asList(allWantedCouponNumbersInString.split(","));
			int size = allWantedCouponNumbers.size();
			String firstWantedCoupon = allWantedCouponNumbers.get(0);
			List<String> otherWantedCoupons = allWantedCouponNumbers.subList(1, size);

			// Adding First Coupon

			cp.addSingleCouponWithNotNowInCardlessIdPopup(firstWantedCoupon, cardlessId7, cardlessId4);

			if (size > 1) {

				cp.addListOfCoupons(otherWantedCoupons);

				Thread.sleep(5000);

				ecp = new MyeCouponsPage(_driver);

				ecp.clickOnMyeCouponsInMyToolsHomePage(_driver);
				log.info("Validating whether the added coupon is in My eCoupons page");

			}

			int eCouponsNumber = ecp.noOfECoupons();

			sa.assertTrue(size == eCouponsNumber,
					"No. of wanted coupons does not match with the count of eCoupons in eCoupons page");

			map = new MyAccountPage(_driver);

			map.clickOnMyAccountUnderMyTools(_driver);
			boolean result = map.chkCardlessIdPresent();

			log.info("Is Cardless id displayed in My Account Page : " + result);

			sa.assertTrue(result,
					"Oops! Cardless Id is present in My Account page even when the user has not entered..");

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
		} catch (UnhandledAlertException al) {
			_driver.switchTo().alert().accept();
		} catch (Exception e) {
			log.info(e.getMessage());
			Assert.fail(e.getLocalizedMessage());
		}
	}

	/* Validates Sorting Functionality on Alphabetical Order & Expiration Date */
	
	@Test(priority = 14, enabled = true)
	public void chkCouponSort() throws InterruptedException {

		try{
			
		SoftAssert sa = new SoftAssert();

		cp = new CouponPage(_driver);

			cp.clickOnCouponsInMyToolsHomePage(_driver);

			int noOfAddItemButtons = cp.loadCompleteCouponsPage(_driver);
			log.info("Coupons Page is loaded fully with " + noOfAddItemButtons + " Coupons");

		
		cp.clcikOnTopButton();

		cp.selectValueFromCouponSortChkBox("Item");

		List<String> couponItemDisplayOrder = new LinkedList<String>();

		couponItemDisplayOrder = cp.getCouponNamesOnDisplayOrder(_driver);

		boolean chkSortOrder = cp.chkAlphabeticalOrder(couponItemDisplayOrder);

		log.info("Result of item sort is :" + chkSortOrder);

		sa.assertTrue(chkSortOrder, "Oops! The Coupons are not sorted properly on Item Name");

		/* **************************** */

		cp.selectValueFromCouponSortChkBox("Expiration");



			int noOfAddItemButtons1 = cp.loadCompleteCouponsPage(_driver);
			log.info("Coupons Page is loaded fully with " + noOfAddItemButtons1 + " Coupons after Expiration sort");


		List<String> couponExpiryDateOrder = new LinkedList<String>();

		couponExpiryDateOrder = cp.getCouponNamesOnDisplayOrder(_driver);

		boolean chkSortExpiryDate = cp.compare2lists(couponItemDisplayOrder, couponExpiryDateOrder);

		log.info("Result of Sort By Expiry Date is :" + chkSortExpiryDate);

		sa.assertFalse(chkSortExpiryDate, "Oops! The Coupons are not sorted properly on Expiry Date");

		sa.assertAll();
		
		} catch (UnhandledAlertException al) {
			_driver.switchTo().alert().accept();
		}catch (IOException ioe) {
			log.info(ioe.getMessage());
			Assert.fail("Caught IOException Exception");
		}

	}
	
	/* Add a Single Coupon for the Authorized User from Coupon Details page    */

	@Test(priority = 11, enabled = true)
	public void addCouponFromCouponDetailsPageForAuthorizedUser() {
		
		try {
			Map<String, String> newSL = readxml.getUserData("TestData.xml", "authorized-user-3");
			String userId = newSL.get("UserName");
			String password = newSL.get("password");
			String wantedCouponNumber = newSL.get("CouponToAdd");

			SoftAssert sa = new SoftAssert();

			cubHome = new FFHome(_driver);

			
				cubHome.completeSignIn(userId, password);
				log.info("Signed In Successfully");

				Thread.sleep(5000);
				cp = new CouponPage(_driver);

				cp.clickOnCouponsInMyToolsHomePage(_driver);

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

				log.info("isCouponPresent in eCoupons Page " + result);

				sa.assertTrue(result, "Unable to add coupon from Coupon Details Page");

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
		} catch (UnhandledAlertException al) {
			_driver.switchTo().alert().accept();
		} catch (Exception e) {
			log.info(e.getMessage());
			Assert.fail(e.getLocalizedMessage());
		}

	}
	
	/* Validates Filter Functionality on Coupons  */

	@Test(priority = 12, enabled = true)
	public void categoryTestInCoupons() {

		try {
			cp = new CouponPage(_driver);

			
				cp.clickOnCouponsInMyToolsHomePage(_driver);

			String wantedCategory = "General";

			cp.selectCatergory(wantedCategory);

			boolean result = cp.getSelectedCategory(wantedCategory);

			Assert.assertTrue(result);
		} catch (InterruptedException e) {
			log.info(e.getMessage());
			e.printStackTrace();
		} catch (UnhandledAlertException al) {
			_driver.switchTo().alert().accept();
		}catch (IOException ioe) {
			log.info(ioe.getMessage());
			Assert.fail("Caught IOException Exception");
		}
	}
	
	/*       Validates Search Functionality on Coupons   */    

	@Test(priority = 11, enabled = true)
	public void searchTestInCoupons() {

		try {
			cp = new CouponPage(_driver);

			cp.clickOnCouponsInMyToolsHomePage(_driver);

			String wantedSearchText = "save";

			cp.searchForAnItemInCoupons(wantedSearchText);

			boolean result = cp.getSelectedCategory(wantedSearchText);

			Assert.assertTrue(result);
			
		} catch (UnhandledAlertException al) {
			_driver.switchTo().alert().accept();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}catch (IOException ioe) {
			log.info(ioe.getMessage());
			Assert.fail("Caught IOException Exception");
		}
	}

}
