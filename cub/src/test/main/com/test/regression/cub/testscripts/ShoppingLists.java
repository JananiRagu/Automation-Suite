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
import com.test.regression.cub.pages.ShoppingListPage;
import com.test.regression.cub.utils.Logg;
import com.test.regression.cub.utils.ReadXML;
import com.test.regression.cub.utils.SuiteBase;


public class ShoppingLists extends SuiteBase{
	
	CubHome cubHome;
	ShoppingListPage sl;
	Logger log = Logg.createLogger();
	ReadXML readxml = new ReadXML();
	
	@Test(enabled=true, priority=6)
	public void createShoppingList(){
		
		try{
		Map<String, String> newSL = readxml.getUserData("TestData.xml", "carded-user");
		String userId = newSL.get("UserName");
		String password = newSL.get("password");
		String SLName = newSL.get("SLName");

		cubHome = new CubHome(_driver);
			log.info("Test Data Used >>>>>>>");
			log.info("User Name : " + userId);
			log.info("Password : " + password);
			
		
		cubHome.clickSignInLink();
			
		cubHome.enterLoginDetails(userId, password);
			
		cubHome.clickSignInButton();
			
			
		sl=new ShoppingListPage(_driver);
		
		sl.clickOnMyListInMyToolsHomePage();
			
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
		Map<String, String> AddItems2newSL = readxml.getUserData("TestData.xml", "carded-user");
		String userId = AddItems2newSL.get("UserName");
		String password = AddItems2newSL.get("password");
		String SLName = AddItems2newSL.get("SLName");
		String item1 = AddItems2newSL.get("item1");
		String quantity1 = AddItems2newSL.get("quantity1");
		String item2 = AddItems2newSL.get("item2");
		String quantity2 = AddItems2newSL.get("quantity2");
		String item3 = AddItems2newSL.get("item3");
		String quantity3 = AddItems2newSL.get("quantity3");

		cubHome = new CubHome(_driver);
		
			log.info("Test Data Used >>>>>>>");
			log.info("User Name : " + userId);
			log.info("Password : " + password);
			
		cubHome.clickSignInLink();
			
		cubHome.enterLoginDetails(userId, password);
			
		cubHome.clickSignInButton();
			
			
		sl=new ShoppingListPage(_driver);
		
		sl.clickOnMyListInMyToolsHomePage();
			
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
			
	}
	
	@Test(enabled=true, priority=8)
	public void AddnEditItemsInShoppingList(){
		
		try{
		Map<String, String> AddnEditItems2newSL = readxml.getUserData("TestData.xml", "carded-user");
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

		cubHome = new CubHome(_driver);
			
			log.info("Test Data Used >>>>>>>");
			log.info("User Name : " + userId);
			log.info("Password : " + password);
			
		cubHome.clickSignInLink();
			
		cubHome.enterLoginDetails(userId, password);
			
		cubHome.clickSignInButton();
			
		sl=new ShoppingListPage(_driver);
		
		sl.clickOnMyListInMyToolsHomePage();
			
		sl.addNewShoppingList(SLName);
			
		sl.addItems2SL(item1, quantity1);
			
		sl.addItems2SL(item2, quantity2);
			
		sl.addItems2SL(item3, quantity3);
			
		Thread.sleep(3000);
		boolean result = sl.edit1stAddedSLItem(_driver, item1upd, quantity1upd);
		
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
	
	@Test(enabled=true, priority=9)
	public void deleteItemFromSL(){
		
		try {
		Map<String, String> AddItems2newSL = readxml.getUserData("TestData.xml", "carded-user");
		String userId = AddItems2newSL.get("UserName");
		String password = AddItems2newSL.get("password");
		String SLName = AddItems2newSL.get("SLName");
		String item1 = AddItems2newSL.get("item1");
		String quantity1 = AddItems2newSL.get("quantity1");
		

		cubHome = new CubHome(_driver);
			log.info("Test Data Used >>>>>>>");
			log.info("User Name : " + userId);
			log.info("Password : " + password);
			
		cubHome.clickSignInLink();
			
		cubHome.enterLoginDetails(userId, password);
			
		cubHome.clickSignInButton();
			
		sl=new ShoppingListPage(_driver);
		
		sl.clickOnMyListInMyToolsHomePage();
			
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
	}
	
	@Test(enabled=true, priority=10)
	public void testClearList() {
		try{
		
		Map<String, String> AddItems2newSL = readxml.getUserData("TestData.xml", "carded-user");
		String userId = AddItems2newSL.get("UserName");
		String password = AddItems2newSL.get("password");
		String SLName = AddItems2newSL.get("SLName");
		String item1 = AddItems2newSL.get("item1");
		String quantity1 = AddItems2newSL.get("quantity1");
		

		cubHome = new CubHome(_driver);
			log.info("Test Data Used >>>>>>>");
			log.info("User Name : " + userId);
			log.info("Password : " + password);
			
		cubHome.clickSignInLink();
			
		cubHome.enterLoginDetails(userId, password);
			
		cubHome.clickSignInButton();
			
		sl=new ShoppingListPage(_driver);
		
		sl.clickOnMyListInMyToolsHomePage();
			
		sl.addNewShoppingList(SLName);
			
		sl.addItems2SL(item1, quantity1);
		
		sl.clearList();
			
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
		
	}
}
