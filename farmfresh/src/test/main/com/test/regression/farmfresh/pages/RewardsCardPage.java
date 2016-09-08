package com.test.regression.farmfresh.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.regression.farmfresh.utils.Logg;
import com.test.regression.farmfresh.utils.SuiteBase;

public class RewardsCardPage extends SuiteBase
{
	WebDriver _driver;

	Logger log = Logg.createLogger();
	
	public RewardsCardPage(WebDriver driver) 
	{
		super();
		_driver=driver;
		PageFactory.initElements(_driver, this);
	}
	
  // Links under Card Information Section
	
	@FindBy(xpath = "//a[text()='Request a new card']")
	private WebElement _requstNewCard;
	
	@FindBy(xpath = "//a[text()='Add my existing card number']")
	private WebElement _addExistinCard;
	
	@FindBy(xpath = "//a[text()='Remove this card']")
	private WebElement _removeCard;
	
	@FindBy(xpath = "//a[text()='Replace lost card']")
	private WebElement _replaceCard;

	@FindBy(xpath = "//a[text()='Print temporary card']")
	private WebElement _printCard;
	
	@FindBy(xpath = "//a[text()='Back to my account.']")
	private WebElement _backToAcc;
		
	@FindBy(xpath = "//a[text()='Add Card-less ID']")
	private WebElement _addCardleddId;
	
	@FindBy(xpath = "//a[text()='Update Card-less ID']")
	private WebElement _updateCardlessId;
	
// Buttons and link while updating cardless id
	
	@FindBy(xpath = "//button[text()='Continue']")
	private WebElement 	_continueButton;
	
	@FindBy(xpath = "//a[text()='Not now']")
	private WebElement 	_notNowLink;

	
	// Buttons and link while Removing Card
	@FindBy(xpath = "//button[text()='Remove']")
		private WebElement 	_removeButton;
		
		@FindBy(xpath = "//a[text()='Cancel']")
		private WebElement 	_cancelLink;
		

		// Buttons and link while Replacing  Card
		
		@FindBy(id = "saveAndContinue")
		private WebElement 	_save;
		
		
	@FindBy(id = "firstName")
	private WebElement _firstName;
	
	@FindBy(id = "lastName")
	private WebElement _lastName;
	
	@FindBy(id = "address1")
	private WebElement _address1;
	
	@FindBy(id = "address2")
	private WebElement _address2;
	
	@FindBy(id = "city")
	private WebElement _city;
	
	@FindBy(id = "state")
	private WebElement _state;
	
	@FindBy(id = "zip")
	private WebElement _zip;
	
	@FindBy(xpath = "//*[@id='content-primary']/div/div[2]/div[2]/div/div[1]/p[1]")
	private WebElement _success;
	

	public boolean isSuccessPresent()
	{
		  waitFor(_success);
            return _success.isDisplayed();
		
	}
	
	
		

// Methods to click links under Card Info section	
		
	public void clickRequstNewCard() 
	{
		waitFor(_requstNewCard);
		_requstNewCard.click();
		log.info("Clicked on Request New card link under Card Information Section in My account Page..");
    }
	
	public void clickAddExistingCard() 
	{
			waitFor(_addExistinCard);
		_addExistinCard.click();
		log.info("Clicked on Add Existing card link under Card Information Section in My account Page..");
} 

	
	public void clickReplaceCard() 
	{
		waitFor(_replaceCard);
		_replaceCard.click();
		log.info("Clicked on Replace card link under Card Information Section in My account Page..");
    }
	
	public void clickRemoveCard() 
	{
		waitFor(_removeCard);
		_removeCard.click();
		log.info("Clicked on Remove card link under Card Information Section in My account Page..");
    }
	
	public void clickPrintCard() 
	{
		waitFor(_printCard);
		_printCard.click();
		log.info("Clicked on Print Temporary  card link under Card Information Section in My account Page..");
    }
	
	public void clickBackToAcc() 
	{
		waitFor(_backToAcc);
		_backToAcc.click();
		log.info("Clicked on  Back to My Account link in Print Temporary  card page in My account Page..");
    }
	
	public void clickAddCardlessId() 
	{
		waitFor(_addCardleddId);
		_addCardleddId.click();
		log.info("Clicked on Add Cardless Id link under Card Information Section in My account Page..");
    }
	
		
	public void clickUpdateCardlessId() 
	{
		waitFor(_updateCardlessId);
		_updateCardlessId.click();
		log.info("Clicked on Update Cardless Id link under Card Information Section in My account Page..");
    }

	
	
	// Methods used while Updating cardless id
	
	public void clickContinue() throws InterruptedException 
	{
		waitFor(_continueButton);
		_continueButton.click();
		log.info("Clicked on Continue button..");
		Thread.sleep(10000);
    }

	public void clickNotNow() 
	{
		waitFor(_notNowLink);
		_notNowLink.click();
		log.info("Clicked on Not Now link..");
    }

	// Methods used while removing card
	
	public void clickCancel() 
	{
		waitFor(_cancelLink);
		_cancelLink.click();
		log.info("Clicked on Cancel Link..");
    }

	public void clickRemove() 
	{
		waitFor(_removeButton);
		_removeButton.click();
		log.info("Clicked on Remove Button.");
    }
	

	
// Get Information
	
	@FindBy(xpath = "//*[@id='_content_svubanners_master_en_tools_view-account_jcr_content_centerpar_start_101a']/div[2]/div[6]/div/div/div/div[1]/div[2]")
	private WebElement _cardNumber;
		
	public String getCardNo() throws InterruptedException
    {
		  Thread.sleep(10000);
		waitFor(_cardNumber);
		System.out.println("Fetching CardNumber information from My Account page");
		String cardNumber=_cardNumber.getText();
		System.out.println(cardNumber);
		return cardNumber;	
    }
	
	@FindBy(xpath = "//*[@id='_content_svubanners_master_en_tools_view-account_jcr_content_centerpar_start_101a']/div[2]/div[6]/div/div/div/div[2]/div")
	private WebElement _cardlessId;
	
	public String getCardlessId() throws InterruptedException
    {
		  Thread.sleep(10000);
		waitFor(_cardlessId);
		System.out.println("Fetching Cardless Id information in Communication Pref from My Account page");
		String cardlessId=_cardlessId.getText();
		System.out.println(cardlessId);
		return cardlessId;
	}
	
// Add rewards number
	
	@FindBy(xpath = "//*[@id='ss-create-rewards-form']/div[2]/input")
	private WebElement _cardlessId7;
	
	@FindBy(xpath = "//*[@id='ss-create-rewards-form']/div[3]/input")
	private WebElement _cardlessId4;
	
	
	public void enterCardless(String cardless)
	{
		log.info("Entering Cardless Id details in My Account page..");
		
		String cardless7 = cardless.substring(0, 7);
		String cardless4 = cardless.substring(7, 11);
		
		_cardlessId7.clear();
		_cardlessId7.sendKeys(cardless7);
		_cardlessId4.clear();
		_cardlessId4.sendKeys(cardless4);
	
	}
	
	public boolean isContinueBtnDisabled() throws InterruptedException
	{
		Thread.sleep(2000);
	String disabled="ss-submit-button ss-submit-button-disabled";
    String actual=_continueButton.getAttribute("class");
	
	if(actual.equalsIgnoreCase(disabled))
		return true;
	else
		return false;
	
	}
	
	public boolean isContinueBtnInAddExistngCardDisabled() throws InterruptedException
	{
		Thread.sleep(2000);
	String disabled="ss-submit-button ss-add-rewards-btn ss-submit-button-disabled";
    String actual=_continueButton.getAttribute("class");
	
	if(actual.equalsIgnoreCase(disabled))
		return true;
	else
		return false;
	
	}
	
// Error Add existing card 
	
	@FindBy(xpath = "//*[@id='layout']/div[2]/div[2]/div[1]")
	private WebElement 	_errorAddExistnCard;
	
	public boolean isErrorPresentAddExistnCard() throws InterruptedException
	{
		Thread.sleep(10000);
	String present="Whoops! We were unable to find this account, please try again.";
	String actual=_errorAddExistnCard.getText();
	
	if(actual.equalsIgnoreCase(present))
	
		return true;
	else
		return false;
	}
	
	
public void enterDataReplaceLostCard(String firstName, String lastName, String address1, String address2, String city, String  state, String zip) throws InterruptedException
{
log.info("Entering contact details in Replace Lost Card Page in My Account page..");

	waitFor(_firstName);
	_firstName.clear();
	_firstName.sendKeys(firstName);
	
	waitFor(_lastName);
	_lastName.clear();
	_lastName.sendKeys(lastName);
	
	waitFor(_address1);
	_address1.clear();
	_address1.sendKeys(address1);
	
	waitFor(_address2);
	_address2.clear();
	_address2.sendKeys(address2);
	
	waitFor(_city);
	_city.clear();
	_city.sendKeys(city);
	
	waitFor(_state);
	_state.sendKeys(state);
	
	waitFor(_zip);
	_zip.clear();
	_zip.sendKeys(zip);
	
		Thread.sleep(2000);
	log.info("Entered the Contact Information details..");
		
}

// SAVE in Replace lost card page
 

	public void clickSave() 
	{
		waitFor(_save);
		_save.click();
		log.info("Clicked on SAVE Button.");
	}
 

	@FindBy(xpath = "//*[@id='error-message-container']/h2")
	private WebElement 	_errorReplaceCard;
	
	public boolean isErrorPresent() throws InterruptedException
	{
	String present="Please correct the following:";
	String actual=_errorReplaceCard.getText();
	
	if(actual.equalsIgnoreCase(present))
	
		return true;
	else
		return false;
	}


}

