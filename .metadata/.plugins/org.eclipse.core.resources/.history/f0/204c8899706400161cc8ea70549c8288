package com.test.regression.cub.testscripts;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.swing.text.html.parser.DocumentParser;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import com.test.regression.cub.pages.RecipesPage;
import com.test.regression.cub.pages.SiteMapPage;
import com.test.regression.cub.pages.CubHome;
import com.test.regression.cub.utils.Logg;
import com.test.regression.cub.utils.ReadXML;
import com.test.regression.cub.utils.SuiteBase;


public class Recipes extends SuiteBase{
	RecipesPage RecipesPage;
	CubHome cubHome;
	Logger log = Logg.createLogger();
	ReadXML readxml = new ReadXML();
	SoftAssert softAssert = new SoftAssert();

	/* ---------------------------- Guest User ------------------------*/
	// Search functionality without any search criteria

	@Test(priority=1,enabled=true)
	public void Guest_Recipes_Pagination() throws InterruptedException
	
	{	
		RecipesPage = new RecipesPage(_driver);
		System.out.println("At Cub home page");
		Thread.sleep(5000);
		RecipesPage.ClickOnSearch();
		Thread.sleep(2000);
		RecipesPage.ClickOnSearchRecipes();
		Thread.sleep(2000);
		
		//Enter the search criteria
		RecipesPage.EnterSearchText("chicken");
		Thread.sleep(5000);
		RecipesPage.clickSearchArrow();
		System.out.println("Inside search page");
		Thread.sleep(5000);
		String CurrentURL = RecipesPage.GetCurrentURL();
		System.out.println("URL displayed is  : " +CurrentURL);
		String[] arrCurrentURL = CurrentURL.split("=");
		softAssert.assertEquals(arrCurrentURL[1].trim(),"chicken", "Text 'chicken' displayed is not matching with expected");	
		System.out.println("Searched criteria is " + arrCurrentURL[1]);
		
		//----- Click on pagination link 3 ---------
		
		RecipesPage.clickOnPaginationLinkNumber_3();
		System.out.println("After clicking on pagination link 3");
		Thread.sleep(5000);
		String CurrentPaginationURL = RecipesPage.GetCurrentURL();
		String[] arrCurrentPaginationURL = CurrentPaginationURL.split("=");
		
		//Items display count
		String[] arrItemsCount = arrCurrentPaginationURL[1].split("&");
		softAssert.assertEquals(arrItemsCount[0].trim(),"10", "Count displayed " + arrItemsCount[0] + " is not matching with expected count '10'");
		
		//Item Name
		String[] arrItemName = arrCurrentPaginationURL[2].split("&");
		softAssert.assertEquals(arrItemName[0].trim(),"chicken", "Item name " + arrItemName[0] + " is not matching with expected text 'chicken'");
		
		//Page count
		//String[] arrPageCount = arrCurrentPaginationURL[5].split("&");
		softAssert.assertEquals(arrCurrentPaginationURL[5].trim(),"3", "Page count displayed " + arrCurrentPaginationURL[5] + " is not matching with expected count '3'");
		
		//------- Click on last pagination link ------------
		
		RecipesPage.clickOnLastPaginationLink();
		Thread.sleep(5000);
		System.out.println("After clicking on last pagination link");
		String LastPaginationURL = RecipesPage.GetCurrentURL();
		String[] arrLastPaginationURL = LastPaginationURL.split("=");
		
		//Items display count
		String[] arrLastItemsCount = arrLastPaginationURL[1].split("&");
		softAssert.assertEquals(arrLastItemsCount[0].trim(),"10", "Count displayed " + arrLastItemsCount[0] + " is not matching with expected count '10'");
		
		//Item Name
		String[] arrLastItemName = arrLastPaginationURL[2].split("&");
		softAssert.assertEquals(arrLastItemName[0].trim(),"chicken", "Item name " + arrLastItemName[0] + " is not matching with expected text 'chicken'");
		
		//Page count
		//String[] arrPageCount = arrCurrentPaginationURL[5].split("&");
		softAssert.assertEquals(arrLastPaginationURL[5].trim(),"34", "Page count displayed " + arrLastPaginationURL[5] + " is not matching with expected count '34'");
		softAssert.assertAll();
	}

	// Search functionality with proper search data
	@Test(priority=2,enabled=true)
	public void Guest_Search_ResultContent() throws InterruptedException
	
	{	
		RecipesPage = new RecipesPage(_driver);
		System.out.println("At Cub home page");
		Thread.sleep(5000);
		RecipesPage.ClickOnSearch();
		Thread.sleep(2000);
		RecipesPage.ClickOnSearchRecipes();
		Thread.sleep(2000);
		
		//Enter the search criteria
		RecipesPage.EnterSearchText("Chicken");
		Thread.sleep(2000);
		RecipesPage.clickSearchArrow();
		Thread.sleep(5000);
		System.out.println("Inside search page");
		
		int ItemsNumber = RecipesPage.NodeListNumber();
		
		for (int i = 1; i <= ItemsNumber; i++)
		{
			String SearchLinks = _driver.findElement(By.xpath("//*[@id='my-recipe-filter-results']/tbody/tr["+i+"]/td[2]/div/a") ).getText();
			if (SearchLinks.trim().toLowerCase().contains("chicken"))
			{
				log.info("Link Name is : " +SearchLinks);
			}
			else
			{
				_driver.findElement(By.xpath("//*[@id='my-recipe-filter-results']/tbody/tr["+i+"]/td[2]/div/a") ).click();
				Thread.sleep(5000);
				String SearchContent = _driver.findElement(By.xpath("//*[@id='ingredients']")).getText();
				if (SearchContent.contains("chicken"))
				{
					log.info("Link Name which does not contain searched string is : " + SearchLinks);
					log.info("Inside the search Link : " + SearchLinks + " contains 'chicken' as an ingredient");
					_driver.navigate().back();
				}

			}

		}
		
		for (int j = 1; j <= ItemsNumber; j++)
		{
			// Clicking on the results links randomly
			if (j == 3)
			{
				String SearchLink_3 = _driver.findElement(By.xpath("//*[@id='my-recipe-filter-results']/tbody/tr["+j+"]/td[2]/div/a") ).getText();
				log.info("Inside search link : " +SearchLink_3);
				_driver.findElement(By.xpath("//*[@id='my-recipe-filter-results']/tbody/tr[3]/td[2]/div/a") ).click();
				Thread.sleep(5000);
				
				//Select the fourth check box   (You can change this sequence number)
				String Checkbox1 = _driver.findElement(By.xpath("//*[@id='ingredients']/li[5]/label")).getText();  
				_driver.findElement(By.xpath("//*[@id='ingredient-listing-4']")).click();
				log.info("Checked : " + Checkbox1 + " checkbox");
				Thread.sleep(2000);
				
				//Click on ADD TO LIST button
				//_driver.findElement(By.xpath("//*[@id='add-all-button']")).click();
				//log.info("Clicked on 'ADD TO LIST' button");
				_driver.navigate().back();
			}
			
			//	********************************************************
			
			if (j == 5)
			{
				String SearchLink_5 = _driver.findElement(By.xpath("//*[@id='my-recipe-filter-results']/tbody/tr["+j+"]/td[2]/div/a") ).getText();
				log.info("Inside search link : " +SearchLink_5);
				Thread.sleep(5000);
				_driver.findElement(By.xpath("//*[@id='my-recipe-filter-results']/tbody/tr[5]/td[2]/div/a") ).click();
				Thread.sleep(5000);
				
				//Select the fifth check box
				String Checkbox2 = _driver.findElement(By.xpath("//*[@id='ingredients']/li[6]/label")).getText();
				_driver.findElement(By.xpath("//*[@id='ingredient-listing-5']")).click();
				log.info("Checked : " + Checkbox2 + " checkbox");
				Thread.sleep(2000);
				
				//Click on ADD TO LIST button
				//_driver.findElement(By.xpath("//*[@id='add-all-button']")).click();
				//log.info("Clicked on 'ADD TO LIST' button");
				_driver.navigate().back();
			}
			
			//	********************************************************
			if (j == 8)
			{
				String SearchLink_8 = _driver.findElement(By.xpath("//*[@id='my-recipe-filter-results']/tbody/tr["+j+"]/td[2]/div/a") ).getText();
				log.info("Inside search link : " +SearchLink_8);
				Thread.sleep(5000);
				_driver.findElement(By.xpath("//*[@id='my-recipe-filter-results']/tbody/tr[8]/td[2]/div/a") ).click();
				Thread.sleep(5000);
				
				//Select the second check box
				String Checkbox3 = _driver.findElement(By.xpath("//*[@id='ingredients']/li[3]/label")).getText();
				_driver.findElement(By.xpath("//*[@id='ingredient-listing-2']")).click();
				log.info("Checked : " + Checkbox3 + " checkbox");
				Thread.sleep(2000);
				//Click on ADD TO LIST button
				//_driver.findElement(By.xpath("//*[@id='add-all-button']")).click();
				//log.info("Clicked on 'ADD TO LIST' button");
				_driver.navigate().back();
			}
			
		}
		
		
	}
	
	// Search functionality without any search criteria

	@Test(priority=3,enabled=true)
	public void Guest_Recipes_Category() throws InterruptedException
	
	{	
		RecipesPage = new RecipesPage(_driver);
		System.out.println("At Cub home page");
		Thread.sleep(5000);
		RecipesPage.ClickOnSearch();
		Thread.sleep(2000);
		
		//-------------- Click on Cuisine link ---------------------
		RecipesPage.ClickOnCuisineLink();
		Thread.sleep(2000);
		String ShownCatrgory = RecipesPage.GetClickedCategory();
		softAssert.assertEquals(ShownCatrgory.trim(),"Cuisine", "Text 'Cuisine' displayed is not matching with expected");
		
		//Clicking on cuisine category links (Southern) -----  This is just a random click,you can change it.Just change number "15" in below xpath and Id by inspecting element
		 _driver.findElement(By.xpath("//*[@id='my-recipe-main-ingredient']/div[2]/ul/li[15]/a") ).click();
		log.info("Clicked on 'Southern' link");
		Thread.sleep(5000);
		String CurrentPaginationURL = RecipesPage.GetCurrentURL();
		String[] arrCurrentPaginationURL = CurrentPaginationURL.split("=");
		String Category_1 = arrCurrentPaginationURL[2];
		softAssert.assertEquals(Category_1.trim(),"203", "Correct page is not displayed after clicking on 'Southern' link and category Id is " +Category_1);
		//_driver.navigate().back();

		//Clicking on cuisine category links (Russian)
		 _driver.findElement(By.xpath("//*[@id='my-recipe-main-ingredient']/div[2]/ul/li[3]/a") ).click();
		log.info("Clicked on 'Russian' link");
		Thread.sleep(5000);
		String CurrentRussianURL = RecipesPage.GetCurrentURL();
		String[] arrCurrentRussianURL = CurrentRussianURL.split("=");
		String Category_2 = arrCurrentRussianURL[2];
		softAssert.assertEquals(Category_2.trim(),"241", "Correct page is not displayed after clicking on 'Russain' link and category Id is" +Category_2);
		//_driver.navigate().back();
		//Thread.sleep(2000);
		//_driver.navigate().back();
		//
		//-------------- Click on Category link ---------------------
		RecipesPage.ClickOnCategoryLink();
		Thread.sleep(2000);
		String StrCategory = RecipesPage.GetClickedCategory();
		softAssert.assertEquals(StrCategory.trim(),"Category", "Text 'Category' displayed is not matching with expected");
		
		//Clicking on category category links (Breakfast, Brunch & Eggs) -----  This is just a random click,you can change it.Just change number "12" in below xpath and Id by inspecting element
		 _driver.findElement(By.xpath("//*[@id='my-recipe-main-ingredient']/div[2]/ul/li[12]/a") ).click();
		log.info("Clicked on 'Breakfast, Brunch & Eggs' link");
		Thread.sleep(5000);
		String strBBEUrl = RecipesPage.GetCurrentURL();
		String[] arrBBEURL = strBBEUrl.split("=");
		String Category_3 = arrBBEURL[2];
		softAssert.assertEquals(Category_3.trim(),"45", "Correct page is not displayed after clicking on 'Breakfast, Brunch & Eggs' link and category Id is " +Category_3);
		//_driver.navigate().back();

		//Clicking on "category" category links (Snacks)
		 _driver.findElement(By.xpath("//*[@id='my-recipe-main-ingredient']/div[2]/ul/li[20]/a") ).click();
		log.info("Clicked on 'Snacks' link");
		Thread.sleep(5000);
		String strSnacksURL = RecipesPage.GetCurrentURL();
		String[] arrSnacksURL = strSnacksURL.split("=");
		String Category_4 = arrSnacksURL[2];
		softAssert.assertEquals(Category_4.trim(),"60", "Correct page is not displayed after clicking on 'Snacks' link and category Id is" +Category_4);
		//_driver.navigate().back();
		Thread.sleep(2000);
		//_driver.navigate().back();

		//-------------- Click on Meal link ---------------------
		RecipesPage.ClickOnMealLink();
		Thread.sleep(2000);
		String StrMeal = RecipesPage.GetClickedCategory();
		softAssert.assertEquals(StrMeal.trim(),"Meal", "Text 'Meal' displayed is not matching with expected");
		
		//Clicking on Meal category links (Appetizer) -----  This is just a random click,you can change it.Just change number "2" in below xpath and Id by inspecting element
		 _driver.findElement(By.xpath("//*[@id='my-recipe-main-ingredient']/div[2]/ul/li[2]/a") ).click();
		log.info("Clicked on 'Appetizer");
		Thread.sleep(5000);
		String strAptzrUrl = RecipesPage.GetCurrentURL();
		String[] arrAptzrUrl = strAptzrUrl.split("=");
		String Category_5 = arrAptzrUrl[2];
		softAssert.assertEquals(Category_5.trim(),"84", "Correct page is not displayed after clicking on 'Appetizer' link and category Id is " +Category_5);
		//_driver.navigate().back();

		//Clicking on Meal category links (Deserts)
		 _driver.findElement(By.xpath("//*[@id='my-recipe-main-ingredient']/div[2]/ul/li[5]/a") ).click();
		log.info("Clicked on 'Deserts' link");
		Thread.sleep(5000);
		String strDesertsURL = RecipesPage.GetCurrentURL();
		String[] arrDesertsURL = strDesertsURL.split("=");
		String Category_6 = arrDesertsURL[2];
		softAssert.assertEquals(Category_6.trim(),"83", "Correct page is not displayed after clicking on 'Deserts' link and category Id is" +Category_6);
		//_driver.navigate().back();
		Thread.sleep(2000);
		//_driver.navigate().back();

		//-------------- Click on Occasion link ---------------------
		RecipesPage.ClickOnOccasionLink();
		Thread.sleep(2000);
		String StrOccasion = RecipesPage.GetClickedCategory();
		softAssert.assertEquals(StrOccasion.trim(),"Occassion", "Text 'Occasion' displayed is not matching with expected");
		//_driver.navigate().back();

		//-------------- Click on Technique link ---------------------
		RecipesPage.ClickOnTechniqueLink();
		Thread.sleep(5000);
		String strTecq = RecipesPage.GetClickedCategory();
		softAssert.assertEquals(strTecq.trim().toLowerCase(),"Technique".trim().toLowerCase(), "Text 'Technique' displayed is not matching with expected");
		
		//Clicking on Technique category links (Slow cooking) -----  This is just a random click,you can change it.Just change number "1" in below xpath and Id by inspecting element
		 _driver.findElement(By.xpath("//*[@id='my-recipe-main-ingredient']/div[2]/ul/li[1]/a") ).click();
		log.info("Clicked on 'Slow cooking");
		Thread.sleep(5000);
		String strSlowCookingURL = RecipesPage.GetCurrentURL();
		String[] arrSlowCookingURL = strSlowCookingURL.split("=");
		String Category_7 = arrSlowCookingURL[2];
		softAssert.assertEquals(Category_7.trim(),"126", "Correct page is not displayed after clicking on 'Slow cooking' link and category Id is " +Category_7);
		//_driver.navigate().back();+

		//Clicking on Technique category links (Pan searing)
		 _driver.findElement(By.xpath("//*[@id='my-recipe-main-ingredient']/div[2]/ul/li[11]/a") ).click();
		log.info("Clicked on 'Pan searing' link");
		Thread.sleep(5000);
		String strPanSearingURL = RecipesPage.GetCurrentURL();
		String[] arrPanSearingURL = strPanSearingURL.split("=");
		String Category_8 = arrPanSearingURL[2];
		softAssert.assertEquals(Category_8.trim(),"137", "Correct page is not displayed after clicking on 'Deserts' link and category Id is" +Category_8);
		//_driver.navigate().back();
		//Thread.sleep(2000);
		//_driver.navigate().back();

		//-------------- Click on Main Ingredient link ---------------------
		RecipesPage.ClickOnMainIngredienteLink();
		Thread.sleep(2000);
		String StrMainIngredient = RecipesPage.GetClickedCategory();
		softAssert.assertEquals(StrMainIngredient.trim(),"Main Ingredient", "Text 'Main Ingredient' displayed is not matching with expected");
		
		//Clicking on Technique category links (Potatoes) -----  This is just a random click,you can change it.Just change number "4" in below xpath and Id by inspecting element
		 _driver.findElement(By.xpath("//*[@id='my-recipe-main-ingredient']/div[2]/ul/li[4]/a") ).click();
		log.info("Clicked on 'Potatoes' link");
		Thread.sleep(5000);
		String strPotatoesURL = RecipesPage.GetCurrentURL();
		String[] arrPotatoesURL = strPotatoesURL.split("=");
		String Category_9 = arrPotatoesURL[2];
		softAssert.assertEquals(Category_9.trim(),"161", "Correct page is not displayed after clicking on 'Potatoes' link and category Id is " +Category_9);
		//_driver.navigate().back();

		//Clicking on Technique category links (Turkey)
		 _driver.findElement(By.xpath("//*[@id='my-recipe-main-ingredient']/div[2]/ul/li[11]/a") ).click();
		log.info("Clicked on 'Turkey' link");
		Thread.sleep(5000);
		String strTurkeyURL = RecipesPage.GetCurrentURL();
		String[] arrTurkeyURL = strTurkeyURL.split("=");
		String Category_10 = arrTurkeyURL[2];
		softAssert.assertEquals(Category_10.trim(),"66", "Correct page is not displayed after clicking on 'Deserts' link and category Id is" +Category_10);
		//_driver.navigate().back();
		Thread.sleep(2000);
		//_driver.navigate().back();
	
		softAssert.assertAll();
		
	}
	
	@Test(priority=4,enabled=true)
	public void Guest_Recipes_Sorting() throws InterruptedException
	
	{
		RecipesPage = new RecipesPage(_driver);
		System.out.println("At Cub home page");
		Thread.sleep(5000);
		RecipesPage.ClickOnSearch();
		Thread.sleep(2000);
		
		//Before sorting
		String strFirstElementWithoutSorting = RecipesPage.GetSortedFirstElement();
		log.info("First element name displayed without sorting is " +strFirstElementWithoutSorting);
		RecipesPage.clickOnPaginationLinkNumber_3();
		Thread.sleep(2000);
		RecipesPage.clickOnLastPaginationLink();
		Thread.sleep(2000);
		String strLastElementWithoutSorting = RecipesPage.GetSortedLastElement();
		log.info("Last element name displayed without sorting is " +strLastElementWithoutSorting);
		
		//After sorting
		RecipesPage.ClickOnSeacrhRecipes_Title_SortingBar();
		Thread.sleep(2000);
		String strFirstElementWithSorting = RecipesPage.GetSortedFirstElement();
		log.info("First element name displayed with sorting is " +strFirstElementWithSorting);
		RecipesPage.clickOnPaginationLinkNumber_3();
		Thread.sleep(2000);
		RecipesPage.clickOnLastPaginationLink();
		Thread.sleep(2000);
		String strLastElementWithSorting = RecipesPage.GetSortedLastElement();
		log.info("Last element name displayed with sorting is " +strLastElementWithSorting);
		
		//Comparing first (unsorted) and last (sorted) elements for confirmation of sorting
		softAssert.assertEquals(strFirstElementWithoutSorting.trim(),strLastElementWithSorting.trim(), "Sorting not done,dispalyed values " + strFirstElementWithoutSorting +" and " + strLastElementWithSorting +" are not matching");
		
		//Comparing last (unsorted) and first (sorted) elements for confirmation of sorting
		softAssert.assertEquals(strLastElementWithoutSorting.trim(),strFirstElementWithSorting.trim(), "Sorting not done,dispalyed values " + strLastElementWithoutSorting +" and " + strFirstElementWithSorting +" are not matching");
		
	}
	
	@Test(priority=5,enabled=true)
	public void Guest_Recipes_Sorting_Time() throws InterruptedException
	
	{
		RecipesPage = new RecipesPage(_driver);
		System.out.println("At Cub home page");
		Thread.sleep(5000);
		RecipesPage.ClickOnSearch();
		Thread.sleep(2000);
		
		RecipesPage.ClickOnSeacrhRecipes_Time_SortingBar();
		
		//Before sorting
		String strFirstTimeWithoutSorting = RecipesPage.GetSortedFirstTime();
		log.info("First element time displayed without sorting is " +strFirstTimeWithoutSorting);
		RecipesPage.clickOnPaginationLinkNumber_3();
		Thread.sleep(2000);
		RecipesPage.clickOnLastPaginationLink();
		Thread.sleep(2000);
		String strLastTimeWithoutSorting = RecipesPage.GetSortedLastTime();
		log.info("Last element time displayed without sorting is " +strLastTimeWithoutSorting);
		
		//After sorting
		RecipesPage.ClickOnSeacrhRecipes_Time_SortingBar();
		Thread.sleep(2000);
		String strFirstTimeWithSorting = RecipesPage.GetSortedFirstTime();
		log.info("First element time displayed with sorting is " +strFirstTimeWithSorting);
		RecipesPage.clickOnPaginationLinkNumber_3();
		Thread.sleep(2000);
		RecipesPage.clickOnLastPaginationLink();
		Thread.sleep(2000);
		String strLastTimeWithSorting = RecipesPage.GetSortedLastTime();
		log.info("Last element time displayed with sorting is " +strLastTimeWithSorting);
		
		//Comparing first (unsorted) and last (sorted) elements for confirmation of sorting
		softAssert.assertEquals(strFirstTimeWithoutSorting.trim(),strLastTimeWithSorting.trim(), "Sorting not done,dispalyed values " + strFirstTimeWithoutSorting +" and " + strLastTimeWithSorting +" are not matching");
		
		//Comparing last (unsorted) and first (sorted) elements for confirmation of sorting
		softAssert.assertEquals(strLastTimeWithoutSorting.trim(),strFirstTimeWithSorting.trim(), "Sorting not done,dispalyed values " + strLastTimeWithoutSorting +" and " + strFirstTimeWithSorting +" are not matching");
		
	}
	
	@Test(priority=4,enabled=true)
	public void Guest_Recipes_Print_Tweet() throws InterruptedException
	
	{
		RecipesPage = new RecipesPage(_driver);
		System.out.println("At Cub home page");
		Thread.sleep(5000);
		RecipesPage.ClickOnSearch();
		Thread.sleep(2000);
		
		//Clicking on third link (you can change it to any other link number)
		_driver.findElement(By.xpath("//*[@id='my-recipe-filter-results']/tbody/tr[3]/td[2]/div/a") ).click();
		Thread.sleep(2000);
		
		//Click on 'Twitter' button
		RecipesPage.ClickOnTwitterButton();
		Thread.sleep(2000);
		Set<String> windowId = _driver.getWindowHandles(); 
		Iterator<String> itererator = windowId.iterator(); 
		
		String mainWinID = itererator.next();
        String  newAdwinID = itererator.next();
        
        _driver.switchTo().window(newAdwinID);
        System.out.println("Title of page is  " + _driver.getTitle());
        //softAssert.assertEquals(strLastTimeWithoutSorting.trim(),strFirstTimeWithSorting.trim(), "Sorting not done,dispalyed values " + strLastTimeWithoutSorting +" and " + strFirstTimeWithSorting +" are not matching");
        if (_driver.getTitle().contains("Twitter"))
        {
        	System.out.println("Pass: Title of page is  " + _driver.getTitle());
        }
        else
        {
        	System.out.println("Fail: Title of page is  " + _driver.getTitle());
        }
        Thread.sleep(2000);
        _driver.switchTo().window(newAdwinID).close();

 	}
}
	
	
	

