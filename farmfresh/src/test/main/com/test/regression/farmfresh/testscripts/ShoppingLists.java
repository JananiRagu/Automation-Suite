package com.test.regression.farmfresh.testscripts;

import java.io.IOException;
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


public class ShoppingLists extends SuiteBase{
	
	FFHome ffHome;
	ShoppingListPage sl;
	CouponPage cp;
	SignUpPage signUpPage;
	MyeCouponsPage ecp;
	MyAccountPage map ;
	
	Logger log = Logg.createLogger();
	ReadXML readxml = new ReadXML();
	/*
	@Test(enabled=true, priority=6)
	public void createShoppingList(){
		
		try{
		Map<String, String> newSL = readxml.getUserData("TestData.xml", "authorized-user-1");
		String userId = newSL.get("UserName");
		String password = newSL.get("password");
		String SLName = newSL.get("SLName");

		ffHome = new ffHome(_driver);
			log.info("Test Data Used >>>>>>>");
			log.info("User Name : " + userId);
			log.info("Password : " + password);
			
		
		ffHome.clickSignInLink();
			
		ffHome.enterLoginDetails(userId, password);
			
		ffHome.clickSignInButton();
			
			
		sl=new ShoppingListPage(_driver);
		
		sl.clickOnMyListInMyToolsHomePage(_driver);
			
		sl.addNewShoppingList(SLName);
			
		
		boolean result = sl.verifyNewAddedShoppingListName(SLName);
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
	
	@Test(enabled=true, priority=7)
	public void Add3Items2ShoppingList(){
		
		try{
		Map<String, String> AddItems2newSL = readxml.getUserData("TestData.xml", "authorized-user-1");
		String userId = AddItems2newSL.get("UserName");
		String password = AddItems2newSL.get("password");
		String SLName = AddItems2newSL.get("SLName");
		String item1 = AddItems2newSL.get("item1");
		String quantity1 = AddItems2newSL.get("quantity1");
		String item2 = AddItems2newSL.get("item2");
		String quantity2 = AddItems2newSL.get("quantity2");
		String item3 = AddItems2newSL.get("item3");
		String quantity3 = AddItems2newSL.get("quantity3");

		ffHome = new ffHome(_driver);
		
			log.info("Test Data Used >>>>>>>");
			log.info("User Name : " + userId);
			log.info("Password : " + password);
			
		ffHome.clickSignInLink();
			
		ffHome.enterLoginDetails(userId, password);
			
		ffHome.clickSignInButton();
			
			
		sl=new ShoppingListPage(_driver);
		
		sl.clickOnMyListInMyToolsHomePage(_driver);
			
		sl.addNewShoppingList(SLName);
			
		sl.addItems2SL(item1, quantity1);
			
		sl.addItems2SL(item2, quantity2);
			
		sl.addItems2SL(item3, quantity3);
			
		Thread.sleep(3000);
		int slSize = sl.SLSize();
		
		Assert.assertTrue(slSize==3);
		
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
			
	}*/
	
	@Test(enabled=true, priority=8)
	public void AddnEditItemsInShoppingList(){
		
		try{
			
			SoftAssert sa = new SoftAssert();
			
		Map<String, String> AddnEditItems2newSL = readxml.getUserData("TestData.xml", "authorized-user-1");
		String userId = AddnEditItems2newSL.get("UserName");
		String password = AddnEditItems2newSL.get("password");
		String SLName = AddnEditItems2newSL.get("SLName");
		String item1 = AddnEditItems2newSL.get("item1");
		String quantity1 = AddnEditItems2newSL.get("quantity1");
		String item1upd = AddnEditItems2newSL.get("item1update");
		String quantity1upd = AddnEditItems2newSL.get("quantity1update");
		String item2 = AddnEditItems2newSL.get("item2");
		String quantity2 = AddnEditItems2newSL.get("quantity2");
		String item3 = AddnEditItems2newSL.get("item3");
		String quantity3 = AddnEditItems2newSL.get("quantity3");

		ffHome = new FFHome(_driver);
			
			log.info("Test Data Used >>>>>>>");
			log.info("User Name : " + userId);
			log.info("Password : " + password);
			
		ffHome.clickSignInLink();
			
		ffHome.enterLoginDetails(userId, password);
			
		ffHome.clickSignInButton();
			
		sl=new ShoppingListPage(_driver);
		
		sl.clickOnMyListInMyToolsHomePage(_driver);
			
		sl.addNewShoppingList(SLName);
		Thread.sleep(5000);
		
		sl.clickOnViewAllShoppingLists();
		
		boolean result = sl.isListPresentInViewAllListsPage(_driver, SLName);
		
		//boolean result = sl.verifyNewAddedShoppingListName(SLName);
		sa.assertTrue(result, "New Shopping list is not created");
		_driver.navigate().back();
		Thread.sleep(5000);
			
		sl.addItems2SL(item1, quantity1);
			
		sl.addItems2SL(item2, quantity2);
			
		sl.addItems2SL(item3, quantity3);
		
		Thread.sleep(3000);
		int slSize = sl.SLSize();
		
		sa.assertTrue(slSize==3, "Oops! Not all items are added to Shopping List");
			
		Thread.sleep(3000);
		boolean result1 = sl.edit1stAddedSLItem(_driver, item1upd, quantity1upd);
		
		sa.assertTrue(result1, "Not able to edit the added Shopping list item..");
		
		sl.deleteLastSLItem(_driver);
		
		Thread.sleep(3000);
		int slSizeUpd = sl.SLSize();
		
		sa.assertTrue(slSizeUpd==2, "Unable to delete Shopping List item..");
		
		sl.clearList();
		
		Thread.sleep(3000);
		int slSizeAfterDelete = sl.SLSize();
		
		sa.assertTrue(slSizeAfterDelete==0, "Clear List is not working as expected..");
		
		sl.addItems2SL(item1, quantity1);
		
		boolean result1a = sl.cancelWhileEditingSLItem(_driver, "qwerty");
		
		sa.assertTrue(result1a, "Cancel while updating shopping list item is not working....");
		
		sl.clickOnViewAllShoppingLists();
		int size = sl.noOfListsInViewAllListsPage();
		
		sl.deleteRecentlyAddedList();
		int sizeUpd =  sl.noOfListsInViewAllListsPage();
		
		sa.assertTrue(sizeUpd==(size-1), "Oops! Not able to delete the shopping list from saved lists..");
		
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
	/*
	@Test(enabled=true, priority=9)
	public void deleteItemFromSL(){
		
		try {
		Map<String, String> AddItems2newSL = readxml.getUserData("TestData.xml", "authorized-user-1");
		String userId = AddItems2newSL.get("UserName");
		String password = AddItems2newSL.get("password");
		String SLName = AddItems2newSL.get("SLName");
		String item1 = AddItems2newSL.get("item1");
		String quantity1 = AddItems2newSL.get("quantity1");
		

		ffHome = new ffHome(_driver);
			log.info("Test Data Used >>>>>>>");
			log.info("User Name : " + userId);
			log.info("Password : " + password);
			
		ffHome.clickSignInLink();
			
		ffHome.enterLoginDetails(userId, password);
			
		ffHome.clickSignInButton();
			
		sl=new ShoppingListPage(_driver);
		
		sl.clickOnMyListInMyToolsHomePage(_driver);
			
		sl.addNewShoppingList(SLName);
			
		sl.addItems2SL(item1, quantity1);
		
		sl.deleteLastSLItem(_driver);
			
		Thread.sleep(3000);
		int slSize = sl.SLSize();
		
		Assert.assertTrue(slSize==0);
		
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
	}*/
	
	@Test(enabled=true, priority=10)
	public void addMoreThan1SL() {
		
			try{
				
				SoftAssert sa = new SoftAssert();
				
				Map<String, String> newSL = readxml.getUserData("TestData.xml", "authorized-user-1");
				String userId = newSL.get("UserName");
				String password = newSL.get("password");
				String SLName = newSL.get("SLName");
				String SLName1 = newSL.get("SLName1");

				ffHome = new FFHome(_driver);
					log.info("Test Data Used >>>>>>>");
					log.info("User Name : " + userId);
					log.info("Password : " + password);
					
				
				ffHome.clickSignInLink();
					
				ffHome.enterLoginDetails(userId, password);
					
				ffHome.clickSignInButton();
					
					
				sl=new ShoppingListPage(_driver);
				
				sl.clickOnMyListInMyToolsHomePage(_driver);
					
				sl.addNewShoppingList(SLName);
				
				sl.addNewShoppingList(SLName1);
				
				sl.clickOnViewAllShoppingLists();
				
				boolean result = sl.isListPresentInViewAllListsPage(_driver, SLName);
				System.out.println("result : " + result);
				sa.assertTrue(result, "First Shopping list is not created successfuly..");
				
				
				
				boolean result1 = sl.isListPresentInViewAllListsPage(_driver, SLName1);
				System.out.println("result1 : " + result1);
				sa.assertTrue(result1, "Second Shopping list is not created successfuly..");
				
				sl.deleteSLFromViewAllListsPage(_driver, SLName);
				sl.deleteSLFromViewAllListsPage(_driver, SLName1);
				
				boolean result3 = sl.isListPresentInViewAllListsPage(_driver, SLName1);
				System.out.println("result3 : " + result3);
				sa.assertFalse(result3,SLName1+" List is not deleted successfully..");
				
				sa.assertAll();
				
				} catch(UnhandledAlertException al){
					_driver.switchTo().alert().accept();
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
	
	@Test(enabled=true, priority=7)
	public void slOtherPagesWidget(){
		
		try{
			
		SoftAssert sa = new SoftAssert();
		
		Map<String, String> AddItems2newSL = readxml.getUserData("TestData.xml", "authorized-user-4");
		String userId = AddItems2newSL.get("UserName");
		String password = AddItems2newSL.get("password");
		String item1 = AddItems2newSL.get("item1");
		String quantity1 = AddItems2newSL.get("quantity1");
		String item2 = AddItems2newSL.get("item2");
		

		ffHome = new FFHome(_driver);
		
			log.info("Test Data Used >>>>>>>");
			log.info("User Name : " + userId);
			log.info("Password : " + password);
			
		cp = new CouponPage(_driver);
		
		cp.clickOnCouponsInMyToolsHomePage(_driver);
		
		sl = new ShoppingListPage(_driver);
		
		sl.clickOnCreateListButton();
			
		Thread.sleep(5000);
		
		sl.addItems2SL(item1, quantity1);
		
		cp.clickOnCouponsInMyToolsHomePage(_driver);
		
		sl.addItems2SLFromWidget(item2);
		Thread.sleep(5000);
		sl.clickViewFullListInSLWidget();
		
		boolean result = sl.isItemPresentInSL(_driver, item2);
		
		sa.assertTrue(result, "Oops! Item is not added properly from Shopping list Widget in Coupons Page");
		Thread.sleep(5000);
		sl.deleteLastSLItem(_driver);
		Thread.sleep(5000);
		cp.clickOnCouponsInMyToolsHomePage(_driver);
		Thread.sleep(5000);
		sl.deleteItemFromSLWidget();
		Thread.sleep(5000);
		sl.clickOnMyListInMyToolsHomePage(_driver);
		
		
		int slSizeAfterDeleteFromSLWidget = sl.SLSize();
		
		sa.assertTrue(slSizeAfterDeleteFromSLWidget==0, "Delete from Shopping list Widget is working as expected..");
		
		
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
