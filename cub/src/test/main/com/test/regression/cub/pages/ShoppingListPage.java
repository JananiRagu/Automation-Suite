package com.test.regression.cub.pages;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.regression.cub.utils.Logg;
import com.test.regression.cub.utils.ReadPropertiesFile;
import com.test.regression.cub.utils.SuiteBase;

public class ShoppingListPage extends SuiteBase{
	
	Logger log = Logg.createLogger();
	
	ReadPropertiesFile properties = new ReadPropertiesFile();
	
	public ShoppingListPage(WebDriver driver) {
		super();
		_driver=driver;
		PageFactory.initElements(_driver, this);
	}
	
	@FindBy(xpath = "//a[text()='Shopping List']")
	private WebElement _shoppingListButton;
	
	@FindBy(xpath = "//button[text()='Create a new list']")
	private WebElement _createNewListButton;
	
	@FindBy(xpath = "//button[text()='Create a List']")
	private WebElement _createAListButtonSLWidget;
	
	@FindBy(id ="listName")
	private WebElement _nameShoppingList;
	
	@FindBy(id = "toolsMenu")
	private WebElement _MyToolsLink;
	
	@FindBy(xpath = "//a[text()='My List']")
	private WebElement _MyList;
	
	@FindBy(xpath = "//*[@id='frm_listname-widget']/fieldset/p/input[2]")
	private WebElement _SaveSLButton;
	
	@FindAll({@FindBy(xpath = "//*[@class ='user-lists fancy']/li/a")})
	private List<WebElement> _selectList;
	
	@FindBy(id = "custom-item-name")
	private WebElement _itemNameField;
	
	@FindBy(id = "item-quantity")
	private WebElement _itemQuantityField;
	
	@FindBy(xpath = "//a[text()='Cancel']")
	private WebElement _cancelLink;
	
	@FindBy(xpath = "//input[@value='Add to list']")
	private WebElement _add2ListButton;
	
	@FindAll({@FindBy(xpath = "//table[@id='shoppinglist-full']/tbody[@id='fullList']/tr[@class='sli sli-type_user']")})
	private List<WebElement> _slList;
	
	@FindBy(xpath = "//button[@id='clear-list-top']")
	private WebElement _clearListLink;
	
	@FindBy(xpath = "//div[@class='widget-icon-inner']/div/p[2]/a[text()='Sign In']")
	private WebElement _signInLinkInSLWidget;
	
	@FindBy(xpath = "//div[@class='widget-icon-inner']/div/p[2]/a[text()='Sign Up']")
	private WebElement _signUpLinkInSLWidget;
	
	@FindBy(xpath = "//a[text()='View All Lists']")
	private WebElement _viewAllListsLink;
	
	@FindBy(xpath = "//table[@class='saved-lists']/tbody/tr[1]/td[3]/a")
	private WebElement _recentSavedList;
	
	@FindAll({@FindBy(xpath = "//table[@class='saved-lists']/tbody/tr")})
	private List<WebElement> _allSavedLists;
	
	@FindBy(xpath = "//a[text()='Back to Shopping List']")
	private WebElement _backToShoppingListLink;
	
	@FindBy(xpath = "//input[@id='custom-item-name']")
	private WebElement _itemNameSLWidget;
	
	@FindBy(xpath = "//button[@id='addListItemBtn']")
	private WebElement _addItemSLWidget;
	
	@FindBy(xpath = "//button[text()='View Full List']")
	private WebElement _viewFullListSLWidget;
	
	@FindBy(xpath = "//table[@id='shopping-list-sidebar-items']/tbody/tr/td[2]/a")
	private WebElement _deleteLinkFor1ItemInSLWidget;
	
	public void clickSignInInSLWidget() throws InterruptedException{
		Thread.sleep(2000);
		waitFor(_signInLinkInSLWidget);
		_signInLinkInSLWidget.click();
	}
	
	public void clickSignUpInSLWidget(){
		
		waitFor(_signUpLinkInSLWidget);
		_signUpLinkInSLWidget.click();
	}
	
	public void clickOnShoppingListButtonHomePage(){
		waitFor(_shoppingListButton);
		_shoppingListButton.click();
		
		log.info("Clicked on Shopping List button in Home Page");
	}
	
	public void addNewShoppingList(String shoppingListName) throws InterruptedException{
		waitFor(_createNewListButton);
		_createNewListButton.click();
		_nameShoppingList.clear();
		_nameShoppingList.sendKeys(shoppingListName);
		
		waitFor(_SaveSLButton);
		_SaveSLButton.click();
		
		log.info("Created New Shopping List");
		Thread.sleep(5000);
	}
	
	public void clickOnMyListInMyToolsHomePage(WebDriver driver) throws InterruptedException, IOException{
		
		log.info("...Inside clickOnMyListInMyToolsHomePage method...");
		
		Thread.sleep(5000);
		
		driver.navigate().to(properties.getPropValue("testURL")+"shopping-list.html");
		log.info("Launched My Shopping List Page");
	    
	}
	
	public boolean verifyNewAddedShoppingListName(String shoppingListName){
		
		System.out.println("Inside verifyNewAddedSLName method");
		
		int listSize = _selectList.size();
		WebElement lastListWE = _selectList.get(listSize-2);
		String lastListName = lastListWE.getText();
		System.out.println("Last SL name : " + lastListName);
		boolean listAdded = lastListName.equals(shoppingListName);
		return listAdded;
	}
	
	public boolean isListPresentInViewAllListsPage(WebDriver driver, String shoppingListName){
		
		System.out.println("Inside isListPresentInViewAllListsPage method");
		//int listSize = _allSavedLists.size();
		
		String temp1 = "//*[@id='saved-list-manager-content']/div/div/table/tbody/tr[";
		String temp2 = "]/td[1]/h2";
		
		int tempResult = 0;
		int count = 1;
		
		for(WebElement aList : _allSavedLists){
		//for(int count=1; count<=listSize; count++){
			
			
			String listNo = Integer.toString(count);
			String wantedXpath = temp1+listNo+temp2;
			
			String listName = (driver.findElement(By.xpath(wantedXpath))).getText();
			System.out.println("List Name : " + listName);
			boolean result = shoppingListName.equalsIgnoreCase(listName);
			if(result){
			tempResult++;
			System.out.println(shoppingListName+" is Present!!!!");
			}
			count++;
		}
		
		if(tempResult>0)
			return true;
		else
			return false;
	}
	
	public void deleteSLFromViewAllListsPage(WebDriver driver, String shoppingListName){
		
		System.out.println("Inside deleteSLFromViewAllListsPage method");
		//int listSize = _allSavedLists.size();
		
		String temp1 = "//*[@id='saved-list-manager-content']/div/div/table/tbody/tr[";
		String temp2 = "]/td[1]/h2";
		String temp3 = "]/td[3]/a";

		int count=1;
		
		for(WebElement aList : _allSavedLists){
		//for(int count=1; count<=listSize; count++){
			if(count<=_allSavedLists.size()){
			String listNo = Integer.toString(count);
			String wantedXpath = temp1+listNo+temp2;
			
			String listName = (driver.findElement(By.xpath(wantedXpath))).getText();
			
			boolean result = shoppingListName.equalsIgnoreCase(listName);
			if(result){
				String want2DeleteXpath = temp1+listNo+temp3;
				(driver.findElement(By.xpath(want2DeleteXpath))).click();
				System.out.println("Deleting list - " + shoppingListName);
				log.info("Deleted "+shoppingListName+" from View All Lists page");
			}
			
			count++;
			}
		}
	}
	
	public void addItems2SL(String item, String quantity) throws InterruptedException{
		
		waitFor(_itemNameField);
		_itemNameField.clear();
		Thread.sleep(1000);
		_itemNameField.sendKeys(item);
		
		waitFor(_itemQuantityField);
		_itemQuantityField.clear();
		Thread.sleep(1000);
		_itemQuantityField.sendKeys(quantity);

		waitFor(_add2ListButton);
		_add2ListButton.click();
		
		log.info("Added an item to Shopping list");
	}
	
	public void addItems2SLFromWidget(String item) throws InterruptedException{
		
		waitFor(_itemNameSLWidget);
		_itemNameSLWidget.clear();
		Thread.sleep(1000);
		_itemNameSLWidget.sendKeys(item);
		

		waitFor(_addItemSLWidget);
		_addItemSLWidget.click();
		
		log.info("Added an item to Shopping list from SL Widget");
	}
	
	public void clickViewFullListInSLWidget(){
		
		waitFor(_viewFullListSLWidget);
		_viewFullListSLWidget.click();
	}
	
	public void deleteItemFromSLWidget() throws InterruptedException{
		
		waitFor(_deleteLinkFor1ItemInSLWidget);
		_deleteLinkFor1ItemInSLWidget.click();
		
		Thread.sleep(5000);
	}
	
	public boolean isItemPresentInSL(WebDriver driver, String itemName){
		
		int resultCount = 0;
		
		String temp1 = "//table[@id='shoppinglist-full']/tbody/tr[";
		String temp2 = "]/td[3]/label";
		
		int size = _slList.size();
		
		for(int count=1; count<=size; count++){
			
			String countS= Integer.toString(count);
			String wantedXpath = temp1+countS+temp2;
			
			String actualItemName = driver.findElement(By.xpath(wantedXpath)).getText();
			
			if(actualItemName.equalsIgnoreCase(itemName))
				resultCount++;
			
		}
		if(resultCount>0)
			return true;
		else
			return false;
	}
	
	public int SLSize(){
		
		System.out.println("Inside SLSize method");
		for(WebElement slItem : _slList){
			System.out.println(slItem.getText());
		}
		int slSize = _slList.size();
		System.out.println(slSize);
		return slSize;
	}
	
	public boolean edit1stAddedSLItem(WebDriver driver, String updatedItem, String updatedQuantity){
		
		System.out.println("Inside editSLItem method");
		
		String temp = "//table[@id='shoppinglist-full']/tbody[@id='fullList']/tr[3]/td[@class='";
		
		WebElement editLinkOfFirstAddedItem = driver.findElement(By.xpath(temp+"col_sli-modify']/a"));
		editLinkOfFirstAddedItem.click();
		
		WebElement editTextBoxOfFirstAddedItem = driver.findElement(By.xpath(temp+"col_sli-details']/input[@name='itemTxt']"));
		editTextBoxOfFirstAddedItem.clear();
		editTextBoxOfFirstAddedItem.sendKeys(updatedItem);
		
		WebElement editTextBoxOfFirstAddedQuantity = driver.findElement(By.xpath(temp+"col_sli-quantity']/input[@name='quantityText']"));
		editTextBoxOfFirstAddedQuantity.clear();
		editTextBoxOfFirstAddedQuantity.sendKeys(updatedQuantity);
		
		WebElement saveButton = driver.findElement(By.xpath(temp+"col_sli-modify']/button[@name='saveButton']"));
		saveButton.click();
		
		WebElement updatedItem1 = driver.findElement(By.xpath(temp+"col_sli-details']/label"));
		String updatedItemName = updatedItem1.getText();
		System.out.println(updatedItemName);
		
		WebElement updatedQuantity1 = driver.findElement(By.xpath(temp+"col_sli-quantity']/label"));
		String updatedItemQuantity = updatedQuantity1.getText();
		System.out.println(updatedItemQuantity);
		
		if(updatedItemName.equals(updatedItem)){
			log.info("Updated Shopping list item name and quantity");
			return true;
		}
		else
			return false;
	}
	
	public boolean cancelWhileEditingSLItem(WebDriver driver, String updatedItem){
		
		System.out.println("Inside cancelWhileEditingSLItem method");
		
		String temp = "//table[@id='shoppinglist-full']/tbody[@id='fullList']/tr[1]/td[@class='";
		
		WebElement Item1b4Update = driver.findElement(By.xpath(temp+"col_sli-details']/label"));
		String ItemNameb4Update = Item1b4Update.getText();
		System.out.println(ItemNameb4Update);
		
		WebElement editLinkOfFirstAddedItem = driver.findElement(By.xpath(temp+"col_sli-modify']/a"));
		editLinkOfFirstAddedItem.click();
		
		WebElement editTextBoxOfFirstAddedItem = driver.findElement(By.xpath(temp+"col_sli-details']/input[@name='itemTxt']"));
		editTextBoxOfFirstAddedItem.clear();
		editTextBoxOfFirstAddedItem.sendKeys(updatedItem);
		
		_cancelLink.click();
		
		WebElement updatedItem1 = driver.findElement(By.xpath(temp+"col_sli-details']/label"));
		String updatedItemName = updatedItem1.getText();
		System.out.println(updatedItemName);
		
		if(updatedItemName.equals(ItemNameb4Update)){
			return true;
		}
		else
			return false;
	}
	
	public void deleteLastSLItem(WebDriver driver){
		System.out.println("Inside deleteSLItem method");
		
		String temp = "//table[@id='shoppinglist-full']/tbody[@id='fullList']/tr[1]/td[@class='";
		
		WebElement deleteButton = driver.findElement(By.xpath(temp+"col_sli-modify']/button[@name='remove']"));
		deleteButton.click();
		log.info("Deleted the last item from Shopping list");
	}

	public void clearList() {
		
		waitFor(_clearListLink);
		_clearListLink.click();
		
		log.info("Cleared Shopping list...");
	}
	
	public void clickOnViewAllShoppingLists() throws InterruptedException{
		
		waitFor(_viewAllListsLink);
		Thread.sleep(5000);
		_viewAllListsLink.click();
		
	}
	
	public int noOfListsInViewAllListsPage() throws InterruptedException{
		
		Thread.sleep(5000);
		int noOfLists = _allSavedLists.size();
		
		return noOfLists;
	}
	
	public void deleteRecentlyAddedList(){
		
		waitFor(_recentSavedList);
		_recentSavedList.click();
	}
	
	public void clickOnCreateListButton() throws InterruptedException{
		
		Thread.sleep(5000);
		waitFor(_createAListButtonSLWidget);
		_createAListButtonSLWidget.click();
	}
	
	public void back2ShoppingList(){
		
		waitFor(_backToShoppingListLink);
		_backToShoppingListLink.click();
	}
	
}
