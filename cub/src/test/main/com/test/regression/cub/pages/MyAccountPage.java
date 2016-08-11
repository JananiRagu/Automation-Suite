package com.test.regression.cub.pages;

import java.rmi.server.SocketSecurityException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.sun.jna.StringArray;
import com.test.regression.cub.utils.Constant;
import com.test.regression.cub.utils.Logg;
import com.test.regression.cub.utils.SuiteBase;

public class MyAccountPage extends SuiteBase{
	
	WebDriver _driver;

	Logger log = Logg.createLogger();
	
	public MyAccountPage(WebDriver driver) {
		super();
		_driver=driver;
		PageFactory.initElements(_driver, this);
	}

//My Tools and My Account links
	
	@FindBy(id = "toolsMenu")
	private WebElement _MyToolsLink;
	
	@FindBy(xpath = "//a[text()='My Account']")
	private WebElement _MyAccount;
	

//Method to click on My Account link under My Tools
	
public void clickOnMyAccountUnderMyTools(WebDriver driver) throws InterruptedException
{
		/* waitFor(_MyToolsLink);
		 _MyToolsLink.click();
		  waitFor(_MyAccount);
		_MyAccount.click(); */
	
		Thread.sleep(10000);
		driver.navigate().to(Constant.URL+"tools/view-account.html");
		log.info("Clicked on My Account link under My Tools tab");
}

// Links in My account Page

	@FindBy(xpath = "//a[text()='Change Password']")
	private WebElement _changePwd;

// Elements in CHANGE PASSWORD pop up My Account page
	
	@FindBy(id = "ss-old-password")
	private WebElement _oldPwdTextBox;
	
	@FindBy(id = "ss-password-login")
	private WebElement _newPwdTextBox;
	
	@FindBy(id = "ss-resetpassword-input2")
	private WebElement _reEnterNewPwdTextBox;
	
	@FindBy(xpath = "//button[text()='Save']")
	private WebElement _saveButtonInChangePwdPopUp;
	
	@FindBy(xpath = "//*[@id='layout']/div[2]/div[2]/a")
	private WebElement _XInChangePwdPopUp;
	

// Xpath for Change pwd Pop up
		
		@FindBy(xpath = "//*[@id='layout']/div[2]/div[2]")
		private WebElement _changePwdPopUp;

//Method to check if Change Pwd pop up is present
		
		public boolean isChangePwdPopUpPresent()
		{
			  waitFor(_changePwdPopUp);
	            return _changePwdPopUp.isDisplayed();
	          
		}
		
		
	// Close POP UP
			
			@FindBy(xpath = "//*[@id='layout']/div[2]/div[2]/a")
			private WebElement _closePopUp;
			
			public void clickOnClosePopUp()
			{
				waitFor(_closePopUp);
				_closePopUp.click();
				log.info("Pop up closed successfully..");
		     }
			
// Methods in CHANGE PASSWORD pop up My Account page

		public void clickOnChangePwdLink()
		{
			waitFor(_changePwd);
			_changePwd.click();
			log.info("Clicked on Change Password link in My Account page..");
		}
		
		public void enterPwdDetails(String OldPwd, String NewPwd)
		{
			log.info("Entering Password details in Change Password in My Account page..");
			waitFor(_oldPwdTextBox);
			_oldPwdTextBox.sendKeys(OldPwd);
			_newPwdTextBox.sendKeys(NewPwd);
			_reEnterNewPwdTextBox.sendKeys(NewPwd);	

		}
		
		public void enterDiffPwdDetails(String OldPwd, String NewPwd1, String NewPwd2)
		{
			log.info("Entering Password details in Change Password in My Account page..");
			waitFor(_oldPwdTextBox);
			_oldPwdTextBox.sendKeys(OldPwd);
			_newPwdTextBox.sendKeys(NewPwd1);
			_reEnterNewPwdTextBox.sendKeys(NewPwd2);	

		}
		
		
		public void clickSaveButtonInChangePwdPopUp()
	    {
			waitFor(_saveButtonInChangePwdPopUp);
			_saveButtonInChangePwdPopUp.click();
			log.info("Clicked Save Button In Change Pwd PopUp in My Account page..");
		}
		
		
		public void clickXInChangePwdPopUp()
	    {
			waitFor(_XInChangePwdPopUp);
			_XInChangePwdPopUp.click();
			log.info("Clicked X Button In Change Pwd PopUp in My Account page..");
		}
		
 //Method to check if SAVE Button is enabled or disabled in Change Password Popup 
		
		public boolean isSaveButtonInChangePwdPopUpDisabled()
		{
		String disabled="ss-submit-button ss-submit-button-disabled";
		String actual=_saveButtonInChangePwdPopUp.getAttribute("class");
		
		if(actual.equalsIgnoreCase(disabled))
			return true;
		else
			return false;
		
		}
		
	
// EDIT link for updating contact information.
		
		@FindBy(xpath = "//*[@id='_content_svubanners_master_en_tools_view-account_jcr_content_centerpar_start_101a']/div[2]/div[3]/div/div/a")
		private WebElement _editUpdateContactInfo;
	
//Elements in "Update your contact information" pop up My Account page	
		
		
	@FindBy(id = "ss-signup-firstname")
	private WebElement _firstName;
	
	@FindBy(id = "ss-signup-lastname")
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
	
	@FindBy(id = "ss-signup-homephone-1")
	private WebElement _homephone1;
	
	@FindBy(id = "ss-signup-homephone-2")
	private WebElement _homephone2;
	
	@FindBy(id = "ss-signup-homephone-3")
	private WebElement _homephone3;
	
	@FindBy(id = "ss-signup-mobilephone-1")
	private WebElement _mobilephone1;
	
	@FindBy(id = "ss-signup-mobilephone-2")
	private WebElement _mobilephone2;
	
	@FindBy(id = "ss-signup-mobilephone-3")
	private WebElement _mobilephone3;
	
	
// Continue button in Update contact Info method

	@FindBy(xpath = "//button[text()='Continue']")
	private WebElement _continueButtonInUpdateContactInfoPopUp;

// Use this address in QAS Validation
	
	@FindBy(id = "QAS_AcceptOriginal")
	private WebElement _useThisAddress;
	
// EDIT link in QAS VAlidation
	@FindBy(id = "QAS_Edit")
	private WebElement _editQAS;
	
	
//Xpath for  "Update your contact information"  Pop up
	
	@FindBy(xpath = "//*[@id='layout']/div[2]/div[2]")
	private WebElement _updateContactInfoPopUp;

//Method to click EDIT link for updating contact information in My Account page
	
	public void clickContinueButtonInUpdateContactInfoPopUp() throws InterruptedException
    {
		Thread.sleep(5000);
		waitFor(_continueButtonInUpdateContactInfoPopUp);
		_continueButtonInUpdateContactInfoPopUp.click();
		log.info("Clicked Continue Button In Update Contact Info PopUp in My Account Page..");
    }
	
//Method to click EDIT link for updating contact information in My Account page
	
	public void clickEditLinkToUpdateContactInfo()
    {
		waitFor(_editUpdateContactInfo);
		_editUpdateContactInfo.click();
		log.info("Clicked EDIT link to Update Contact Info in My Account Page..");
    }
	
	
public void enterContactInformation(String firstName, String lastName, String address1, String address2, String city, String  state, String zip, String homePhone, String mobilePhone)
{
	log.info("Entering contact details in UPDATE CONTACT INFO PopUp in My Account page..");
		
	String homephone1, homephone2, homephone3;
		String mobilephone1, mobilephone2, mobilephone3;
		
		homephone1 = homePhone.substring(0, 3);
		homephone2 = homePhone.substring(3, 6);
		homephone3 = homePhone.substring(6, 10);
		mobilephone1 = mobilePhone.substring(0, 3);
		mobilephone2 = mobilePhone.substring(3, 6);
		mobilephone3 = mobilePhone.substring(6, 10);
			
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
		
		waitFor(_homephone1);
		_homephone1.clear();
		_homephone1.sendKeys(homephone1);
		waitFor(_homephone2);
		_homephone2.clear();
		_homephone2.sendKeys(homephone2);
		waitFor(_homephone3);
		_homephone3.clear();
		_homephone3.sendKeys(homephone3);
		
		waitFor(_mobilephone1);
		_mobilephone1.clear();
		_mobilephone1.sendKeys(mobilephone1);
		waitFor(_mobilephone2);
		_mobilephone2.clear();
		_mobilephone2.sendKeys(mobilephone2);
		waitFor(_mobilephone3);
		_mobilephone3.clear();
		_mobilephone3.sendKeys(mobilephone3);
				
		log.info("Entered the Contact Information details..");
			
	}



//Method to check if  "Update your contact information"  pop up is present
	
	public boolean isUpdateContactInfoPopUpPresent() throws InterruptedException
	{
		Thread.sleep(5000);
		  waitFor(_updateContactInfoPopUp);
            return _updateContactInfoPopUp.isDisplayed();
		
	}

	
	// Click EDIT link in QAS Validation
	
		public void clickEditLinkInQAS() throws InterruptedException{
			
			waitFor(_editQAS);
			_editQAS.click();
			
			log.info("Clicked on EDIT link in QAS Verification");
			Thread.sleep(5000);
		}

// Click use this address in QAS Validation
	
	public void clickUseThisAddressButton() throws InterruptedException{
		
		waitFor(_useThisAddress);
		_useThisAddress.click();
		
		log.info("Clicked on Use this address button on Address Verification");
		Thread.sleep(5000);
	}

	
	
// GET text of user data
	
	@FindBy(xpath="//*[@id='_content_svubanners_master_en_tools_view-account_jcr_content_centerpar_start_101a']/div[2]/div[3]/div/div/div/div[1]/div[2]")
    private WebElement _getUserData;
    
	public String getUserData()
    {
		waitFor(_getUserData);
		
		System.out.println("Fetching contact information from My Account page");
		String userData=_getUserData.getText();
		System.out.println(userData);
		return userData;
		
    }
	
// Privacy Policy link in Update Contact Info Pop up
	
	@FindBy(xpath = "//a[text()='Privacy policy']")
	private WebElement _privacyPolicyLink;
	
//Method to click Privacy Policy link in Update Contact Info Pop up	
 
	public void clickPrivacyPolicy()
    {
		log.info("Clicking on Privacy Policy link in Update Contact information pop up in My Account page");
		waitFor(_privacyPolicyLink);
		_privacyPolicyLink.click();
		log.info("Clicked Privacy Policy link in Update Contact Info Pop up in My account page");
			
    }
	
	//Method to check if CONTINUE Button is enabled or disabled in Update Contact Info Popup 
	
	public boolean isContinueBtnInUpdateContactInfoDisabled() throws InterruptedException
	{
		Thread.sleep(5000);
	String disabled="ss-submit-button ss-signup-btn ss-submit-button-disabled";
    String actual=_continueButtonInUpdateContactInfoPopUp.getAttribute("class");
	
	if(actual.equalsIgnoreCase(disabled))
		return true;
	else
		return false;
	
	}
	
//FAS 
	 @FindBy(xpath = "//*[@class='edit ss-update-store-myaccount']")
	 private WebElement _editlinkformystore;

	 public void clickeditonmystore(){
	 waitFor(_editlinkformystore);
	 _editlinkformystore.click();
	 } 

	
}


