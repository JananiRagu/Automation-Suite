package com.test.regression.cub.pages;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.regression.cub.utils.Logg;
import com.test.regression.cub.utils.SuiteBase;

public class ShoppingListPage extends SuiteBase{
	
	Logger log = Logg.createLogger();
	
	public ShoppingListPage(WebDriver driver) {
		super();
		_driver=driver;
		PageFactory.initElements(_driver, this);
	}
	
	@FindBy(xpath = "//a[text()='Shopping List']")
	private WebElement _shoppingListButton;
	
	@FindBy(xpath = "//button[text()='Create a new list']")
	private WebElement _createNewListButton;
	
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
	
	@FindBy(xpath = "//input[@value='Add to list']")
	private WebElement _add2ListButton;
	
	@FindAll({@FindBy(xpath = "//table[@id='shoppinglist-full']/tbody[@id='fullList']/tr[@class='sli sli-type_user']")})
	private List<WebElement> _slList;
	
	@FindBy(xpath = "//button[@id='clear-list-top']")
	private WebElement _clearListLink;
	
	
	public void clickOnShoppingListButtonHomePage(){
		waitFor(_shoppingListButton);
		_shoppingListButton.click();
		
		log.info("Clicked on Shopping List button in Home Page");
	}
	
	public void addNewShoppingList(String shoppingListName){
		waitFor(_createNewListButton);
		_createNewListButton.click();
		_nameShoppingList.clear();
		_nameShoppingList.sendKeys(shoppingListName);
		
		waitFor(_SaveSLButton);
		_SaveSLButton.click();
		
		log.info("Created New Shopping List");
	}
	
	public void clickOnMyListInMyToolsHomePage(){
		
		waitFor(_MyToolsLink);
		_MyToolsLink.click();
		waitFor(_MyList);
		_MyList.click();
		
		log.info("Selected My List in My Tools dropdown");
	    
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
	
	public void addItems2SL(String item, String quantity){
		
		waitFor(_itemNameField);
		_itemNameField.clear();
		_itemNameField.sendKeys(item);
		
		waitFor(_itemQuantityField);
		_itemQuantityField.clear();
		_itemQuantityField.sendKeys(quantity);

		waitFor(_add2ListButton);
		_add2ListButton.click();
		
		log.info("Added 2 items to Shopping list");
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
	
}
