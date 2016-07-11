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
	
	@Test(enabled=true, priority=4)
	public void createShoppingList() throws InterruptedException, IOException, XPathExpressionException, ParserConfigurationException, SAXException{
		
		Map<String, String> newSL = readxml.getUserData("TestData.xml", "carded-user");
		String userId = newSL.get("UserName");
		String password = newSL.get("password");
		String SLName = newSL.get("SLName");

		cubHome = new CubHome(_driver);
			log.info("cubHome obj instantiated");
		cubHome.clickSignInLink();
			log.info("SignIn Link Clicked");
		cubHome.enterLoginDetails(userId, password);
			log.info("Entered login Details");
		cubHome.clickSignInButton();
			log.info("SignInButton Clicked");
			
		sl=new ShoppingListPage(_driver);
		
		sl.clickOnMyListInMyToolsHomePage();
			log.info("Clicked on Shopping list link in Home page");
		sl.addNewShoppingList(SLName);
			log.info("Added a new shopping list");
		
		boolean result = sl.verifyNewAddedShoppingListName(SLName);
		Assert.assertTrue(result);
	
		
	}
	
	@Test(enabled=true, priority=5)
	public void AddItems2ShoppingList() throws InterruptedException, IOException, XPathExpressionException, ParserConfigurationException, SAXException{
		
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
			log.info("cubHome obj instantiated");
		cubHome.clickSignInLink();
			log.info("SignIn Link Clicked");
		cubHome.enterLoginDetails(userId, password);
			log.info("Entered login Details");
		cubHome.clickSignInButton();
			log.info("SignInButton Clicked");
			
		sl=new ShoppingListPage(_driver);
		
		sl.clickOnMyListInMyToolsHomePage();
			log.info("Clicked on Shopping list link in Home page");
		sl.addNewShoppingList(SLName);
			log.info("Added a new shopping list");
		sl.addItems2SL(item1, quantity1);
			log.info("Item added to shopping list");
		sl.addItems2SL(item2, quantity2);
			log.info("Item added to shopping list");
		sl.addItems2SL(item3, quantity3);
			log.info("Item added to shopping list");
			
		Thread.sleep(3000);
		int slSize = sl.SLSize();
		
		Assert.assertTrue(slSize==3);
		
			
	}
	
	@Test(enabled=true, priority=6)
	public void AddnEditItemsInShoppingList() throws InterruptedException, IOException, XPathExpressionException, ParserConfigurationException, SAXException{
		
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
			log.info("cubHome obj instantiated");
		cubHome.clickSignInLink();
			log.info("SignIn Link Clicked");
		cubHome.enterLoginDetails(userId, password);
			log.info("Entered login Details");
		cubHome.clickSignInButton();
			log.info("SignInButton Clicked");
			
		sl=new ShoppingListPage(_driver);
		
		sl.clickOnMyListInMyToolsHomePage();
			log.info("Clicked on Shopping list link in Home page");
		sl.addNewShoppingList(SLName);
			log.info("Added a new shopping list");
		sl.addItems2SL(item1, quantity1);
			log.info("Item added to shopping list");
		sl.addItems2SL(item2, quantity2);
			log.info("Item added to shopping list");
		sl.addItems2SL(item3, quantity3);
			log.info("Item added to shopping list");
			
		Thread.sleep(3000);
		boolean result = sl.edit1stAddedSLItem(_driver, item1upd, quantity1upd);
		
		Assert.assertTrue(result);
		
				
	}
	
	@Test(enabled=true, priority=4)
	public void deleteItemFromSL() throws InterruptedException, IOException, XPathExpressionException, ParserConfigurationException, SAXException{
		
		Map<String, String> AddItems2newSL = readxml.getUserData("TestData.xml", "carded-user");
		String userId = AddItems2newSL.get("UserName");
		String password = AddItems2newSL.get("password");
		String SLName = AddItems2newSL.get("SLName");
		String item1 = AddItems2newSL.get("item1");
		String quantity1 = AddItems2newSL.get("quantity1");
		

		cubHome = new CubHome(_driver);
			log.info("cubHome obj instantiated");
		cubHome.clickSignInLink();
			log.info("SignIn Link Clicked");
		cubHome.enterLoginDetails(userId, password);
			log.info("Entered login Details");
		cubHome.clickSignInButton();
			log.info("SignInButton Clicked");
			
		sl=new ShoppingListPage(_driver);
		
		sl.clickOnMyListInMyToolsHomePage();
			log.info("Clicked on Shopping list link in Home page");
		sl.addNewShoppingList(SLName);
			log.info("Added a new shopping list");
		sl.addItems2SL(item1, quantity1);
			log.info("Item added to shopping list");
		
		sl.deleteLastSLItem(_driver);
			
		Thread.sleep(3000);
		int slSize = sl.SLSize();
		
		Assert.assertTrue(slSize==0);
		
		
	}
	
	@Test(enabled=true, priority=4)
	public void testClearList() throws InterruptedException, IOException, XPathExpressionException, ParserConfigurationException, SAXException{
		
		Map<String, String> AddItems2newSL = readxml.getUserData("TestData.xml", "carded-user");
		String userId = AddItems2newSL.get("UserName");
		String password = AddItems2newSL.get("password");
		String SLName = AddItems2newSL.get("SLName");
		String item1 = AddItems2newSL.get("item1");
		String quantity1 = AddItems2newSL.get("quantity1");
		

		cubHome = new CubHome(_driver);
			log.info("cubHome obj instantiated");
		cubHome.clickSignInLink();
			log.info("SignIn Link Clicked");
		cubHome.enterLoginDetails(userId, password);
			log.info("Entered login Details");
		cubHome.clickSignInButton();
			log.info("SignInButton Clicked");
			
		sl=new ShoppingListPage(_driver);
		
		sl.clickOnMyListInMyToolsHomePage();
			log.info("Clicked on Shopping list link in Home page");
		sl.addNewShoppingList(SLName);
			log.info("Added a new shopping list");
		sl.addItems2SL(item1, quantity1);
			log.info("Item added to shopping list");
		
		sl.clearList();
			
		Thread.sleep(3000);
		int slSize = sl.SLSize();
		
		Assert.assertTrue(slSize==0);
		
		
		
	}
}
