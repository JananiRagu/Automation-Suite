package com.test.regression.cub.pages;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.regression.cub.utils.SuiteBase;

public class RecipesPage extends SuiteBase
	{
	
	WebDriver _driver;
	
	public RecipesPage (WebDriver driver) 
	{
		super();
		_driver=driver;
		PageFactory.initElements(_driver, this);
		
	}
	
	// Search text box in home page 
	
	@FindBy(xpath = "//*[@id='nav-pri-recipes']/a")
	private WebElement _Recipes;
	
	//Inside search page
	
	@FindBy(xpath = "//*[@id='nav-secondary']/li/a")
	private WebElement _SearchRecipes;
	
	@FindBy(xpath = "//*[@id='inp-recipe-search']")
	private WebElement _SearchTextField;
	
	@FindBy(xpath = "//*[@id='frm-recipe-search-search-n-filter']/fieldset/input[2]")
	private WebElement _ArrowButton;

	@FindBy(xpath = "//*[@id='pagination']/ul/li[2]/ol/li[3]/a")
	private WebElement _PaginationLink_3;
	
	@FindBy(xpath = "//*[@id='pagination']/ul/li[2]/ol/li[7]/a")
	private WebElement _PaginationLink_Last;
	
	@FindAll({@FindBy(xpath = "//*[@id='my-recipe-filter-results']/tbody/tr")})
	private List<WebElement> _SearchNodeList;
	
	@FindBy(xpath = "//*[@id='recipe-sort-bar']/th[1]/strong/a")
	private WebElement _SearchRecipes_Title_SortingBar;
	
	@FindBy(xpath = "//*[@id='recipe-sort-bar']/th[2]/strong/a")
	private WebElement _SearchRecipes_Time_SortingBar;
	
	@FindBy(xpath = "//*[@id='my-recipe-filter-results']/tbody/tr[1]/td[2]/div/a")
	private WebElement _SortedFirstElementName;
	
	@FindBy(xpath = "//*[@id='my-recipe-filter-results']/tbody/tr[2]/td[2]/div/a")
	private WebElement _SortedLastElementName;

	@FindBy(xpath = "//*[@id='my-recipe-filter-results']/tbody/tr[1]/td[3]/div")
	private WebElement _SortedFirstElementTime;
	
	@FindBy(xpath = "//*[@id='my-recipe-filter-results']/tbody/tr[2]/td[3]/div")
	private WebElement _SortedLastElementTime;

	@FindBy(id = "twitter-widget-0")
	private WebElement _TwitterButton;

	@FindBy(xpath = "//*[@id='right']/a")
	private WebElement _PrintButton;

	//Previous and Next link properties after clicking on Last pagination link
	
	@FindBy(xpath = "//*[@id='pagination']/ul/li[3]")
	private WebElement _Link_Next;
	
	@FindBy(xpath = "//*[@id='pagination']/ul/li[1]/a")
	private WebElement _Link_Previous;
	
	//------------------ Search recipes category --------------------------
	@FindBy(xpath = "//*[@id='nav-secondary']/li/ul/li[1]/a")
	private WebElement _Link_Cuisine;
	
	@FindBy(xpath = "//*[@id='nav-secondary']/li/ul/li[2]/a")
	private WebElement _Link_Category;
	
	@FindBy(xpath = "//*[@id='nav-secondary']/li/ul/li[3]/a")
	private WebElement _Link_Meal;
	
	@FindBy(xpath = "//*[@id='nav-secondary']/li/ul/li[4]/a")
	private WebElement _Link_Occasion;
	
	@FindBy(xpath = "//*[@id='nav-secondary']/li/ul/li[5]/a")
	private WebElement _Link_Technique;
	
	@FindBy(xpath = "//*[@id='nav-secondary']/li/ul/li[6]/a")
	private WebElement _Link_MainIngredient;
	
	//----------- Inside each search catregory ------------------------------
	@FindBy(xpath = "//*[@id='my-recipe-main-ingredient']/h1/span")
	private WebElement _Displayed_Category;
	
	
	// -------------------------* Methods to operate on elements *-----------------------------
	
	public void ClickOnSearch()
	{
		waitFor(_Recipes);
		_Recipes.click();
		System.out.println("Clicked on 'search' link");
	}
	
	public void ClickOnSearchRecipes()
	{
		waitFor(_SearchRecipes);
		_SearchRecipes.click();
		System.out.println("Clicked on 'Search Recipes' link");
	}
	
	public void EnterSearchText(String SearchText)
	{
		waitFor(_SearchTextField);
		_SearchTextField.sendKeys(SearchText);
		System.out.println("Entered text in search filed is :"  +SearchText);
	}
	
	public void clickSearchArrow()
	{
		waitFor(_ArrowButton);
		_ArrowButton.sendKeys(Keys.ENTER);
		System.out.println("Clicked on 'Arrow' link");
	}
	
	public void clickOnPaginationLinkNumber_3()
	{
		waitFor(_PaginationLink_3);
		_PaginationLink_3.click();
		System.out.println("Clicked on 'Pagination link 3 ");
	}

	public void clickOnLastPaginationLink()
	{
		waitFor(_PaginationLink_Last);
		_PaginationLink_Last.click();
		System.out.println("Clicked on Last pagination link ");
	}

	public void clickOnPreviousLink()
	{
		waitFor(_Link_Previous);
		_Link_Previous.click();
		System.out.println("Clicked on 'Previous' link ");
	}
	
	public void clickOnNextLink()
	{
		waitFor(_Link_Next);
		_Link_Next.click();
		System.out.println("Clicked on 'Next' link ");
	}
	
	public int NodeListNumber()
	{

		System.out.println("Inside NodeListNUmber method");
		
		int NodelistSize = _SearchNodeList.size();
		System.out.println("Node list count: " + NodelistSize);
		return NodelistSize;
	}
	
	public String Link_Next()
	{
		waitFor(_Link_Next);
		String Next_Status = _Link_Next.getAttribute("disabled");
		return Next_Status;
	}
	
	public String Link_Previous()
	{
		waitFor(_Link_Previous);
		String Previous_Status = _Link_Previous.getAttribute("disabled");
		return Previous_Status;
	}

	public String GetCurrentURL()
	{
		String DisplayedURL = _driver.getCurrentUrl();
		return DisplayedURL;
	}
	
	// Click on recepies category links
	
	public void ClickOnCuisineLink()
	{
		waitFor(_Link_Cuisine);
		_Link_Cuisine.click();
		System.out.println("Clicked on 'cuisine' link ");
	}
	
	public void ClickOnCategoryLink()
	{
		waitFor(_Link_Category);
		_Link_Category.click();
		System.out.println("Clicked on 'Category' link ");
	}
	
	public void ClickOnMealLink()
	{
		waitFor(_Link_Meal);
		_Link_Meal.click();
		System.out.println("Clicked on 'Meal' link ");
	}
	
	public void ClickOnOccasionLink()
	{
		waitFor(_Link_Occasion);
		_Link_Occasion.click();
		System.out.println("Clicked on 'Occasion' link ");
	}
	
	public void ClickOnTechniqueLink()
	{
		waitFor(_Link_Technique);
		_Link_Technique.click();
		System.out.println("Clicked on 'Technique' link ");
	}
	
	public void ClickOnMainIngredienteLink()
	{
		waitFor(_Link_MainIngredient);
		_Link_MainIngredient.click();
		System.out.println("Clicked on 'Main Ingredient' link ");
	}
	
	public String GetClickedCategory()
	{
		waitFor(_Displayed_Category);
		String DisplyedCategory = _Displayed_Category.getText();
		return DisplyedCategory;
	}
	
	public void ClickOnSeacrhRecipes_Title_SortingBar()
	{
		waitFor(_SearchRecipes_Title_SortingBar);
		_SearchRecipes_Title_SortingBar.click();
		System.out.println("Clicked on 'Title Sorting' bar ");
	}
	
	public void ClickOnSeacrhRecipes_Time_SortingBar()
	{
		waitFor(_SearchRecipes_Time_SortingBar);
		_SearchRecipes_Time_SortingBar.click();
		System.out.println("Clicked on 'Time Sorting' bar ");
	}
	
	public String GetSortedFirstElement()
	{
		waitFor(_SortedFirstElementName);
		String DisplayedElement = _SortedFirstElementName.getText();
		return DisplayedElement;
	}
	
	public String GetSortedLastElement()
	{
		waitFor(_SortedLastElementName);
		String DisplayedElement = _SortedLastElementName.getText();
		return DisplayedElement;
	}
	
	public String GetSortedFirstTime()
	{
		waitFor(_SortedFirstElementTime);
		String DisplayedElement = _SortedFirstElementTime.getText();
		return DisplayedElement;
	}
	
	public String GetSortedLastTime()
	{
		waitFor(_SortedLastElementTime);
		String DisplayedElement = _SortedLastElementTime.getText();
		return DisplayedElement;
	}
	
	public void ClickOnTwitterButton()
	{
		waitFor(_TwitterButton);
		_TwitterButton.click();
		System.out.println("Clicked on 'Twitter' button");
	}
	
	public void ClickOnPrintButton()
	{
		waitFor(_PrintButton);
		_PrintButton.click();
		System.out.println("Clicked on 'Print' button");
	}
	
}
