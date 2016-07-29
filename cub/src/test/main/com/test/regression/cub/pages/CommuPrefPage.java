package com.test.regression.cub.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.test.regression.cub.utils.Constant;
import com.test.regression.cub.utils.Logg;
import com.test.regression.cub.utils.SuiteBase;

public class CommuPrefPage extends SuiteBase{
	
	WebDriver _driver;

	Logger log = Logg.createLogger();
	
	public CommuPrefPage(WebDriver driver) 
	{
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

	
	// Use this address in QAS Validation
	
		@FindBy(id = "QAS_AcceptOriginal")
		private WebElement _useThisAddress;
		
	// EDIT link in QAS VAlidation
		@FindBy(id = "QAS_Edit")
		private WebElement _editQAS;
	
	// EDIT link for updating Communication Preferences in My account Page
				
		@FindBy(xpath = "//*[@id='_content_svubanners_master_en_tools_view-account_jcr_content_centerpar_start_101a']/div[2]/div[4]/div/div/a")
		private WebElement _editCommunicationPref;
			
	//Elements in "Communication Preferences" pop up My Account page	
		
		//check boxes
				
			@FindBy(id = "checkIfEmail")
			private WebElement _cpCheckIfEmail;
				
			@FindBy(id = "checkIfSMS")
			private WebElement _cpCheckIfSMS;
				
			@FindBy(id = "checkIfMail")
			private WebElement _cpCheckIfDirectMail;
		
		//Text boxes
			
			/* Text box to enter Email address */
			@FindBy(xpath = "//*[@id='currentCommEmail']/input")
			private WebElement _cpEnterEmail;
			
			@FindBy(xpath = "//*[@id='currentCommPref-email']")
			private WebElement _cpEnterEmailPage;
			
			
			@FindBy(id = "phoneAreaCode")
			private WebElement _cpMobNo1;
			
			@FindBy(id = "currentCommPref-phone-areaCode")
			private WebElement _cpMobNo1Page;
			
				
			@FindBy(id = "phone3")
			private WebElement _cpMobNo2;
			
			@FindBy(id = "currentCommPref-phone-3")
			private WebElement _cpMobNo2Page;
			
				
			@FindBy(id = "phone4")
			private WebElement _cpMobNo3;
			
			@FindBy(id = "currentCommPref-phone-4")
			private WebElement _cpMobNo3Page;
			
			
			//* Xpath for fetching Mobile number in Contact info section
			
			@FindBy(xpath = "//*[@id='_content_svubanners_master_en_tools_view-account_jcr_content_centerpar_start_101a']/div[2]/div[3]/div/div/div/div[2]/div[4]")
			private WebElement _cpMobileNoContInfoSec;
			
		//Link to ENTER and EDIT Mailing address
			
			@FindBy(xpath = "//*[@id='currentCommMail']/div[2]/a")
			private WebElement _cpLinkToEnterMailingAddress;
			
			@FindBy(xpath = "//*//*[@id='editAddress']/a")
			private WebElement _cpLinkToEditMailingAddress;
			
		
		// SAVE and GO BACK options in EDIT Address pop up while updating communication Preferences
			
			@FindBy(xpath = "//button[text()='Save']")
			private WebElement _cpSaveButtonInEditAddress;
			
			@FindBy(xpath = "//button[text()='	Go Back']")
			private WebElement _cpGoBackLinkInEditAddress;
		
			// Close POP UP
			
						@FindBy(xpath = "//*[@id='layout']/div[2]/div[2]/a")
						private WebElement _closePopUp;
						
						public void clickOnClosePopUp() throws InterruptedException
						{
							waitFor(_closePopUp);
							_closePopUp.click();
							log.info("Pop up closed successfully..");
							Thread.sleep(5000);
					     }
				
				
			
		// Method to Uncheck all check boxes in Communication Pref Pop Up
			
			public void cpUncheckAll() throws InterruptedException
			{
				Thread.sleep(5000);	
				boolean isCheckedEmail = _cpCheckIfEmail.isSelected();
				 
				   if (isCheckedEmail == true)
				   {
					     _cpCheckIfEmail.click();
					     log.info("UnChecked Email Check box in  Communication Preferences Pop up in My Account Page..");
					 }
				   else 
				   { }	
				   
				   boolean isCheckedSMS = _cpCheckIfSMS.isSelected();
					 
				   if (isCheckedSMS == true)
				   {
					     _cpCheckIfSMS.click();
					     log.info("UnChecked SMS Check box in  Communication Preferences Pop up in My Account Page..");
					 }
				   else 
				   { }	
				    
				   
				   boolean isCheckedMail = _cpCheckIfDirectMail.isSelected();
					 
				   if (isCheckedMail == true)
				   {
					     _cpCheckIfDirectMail.click();
					     log.info("UnChecked Direct Mail Check box in  Communication Preferences Pop up in My Account Page..");
					 }
				   else 
				   { }	
			}


			//Methods to check if Communication Pref field has no data when user Unchecks all check boxes
					
					public boolean cpIsEmailNotPresent()
					{
							String hidden="currentCommPrefValue hidden";
							String actual=_cpEnterEmailPage.getAttribute("class");
							
							if(actual.equalsIgnoreCase(hidden))
								return true;
							else
								return false;
					}
				
					@FindBy(id = "userPrefSMStext")
					private WebElement _cpSmsComponent;
					
					@FindBy(id = "userPrefDirectMail")
					private WebElement _cpAddressComponent;
					
					
					public boolean cpIsSMSUncheck()
					{								
						if (_cpSmsComponent.isSelected())
						return false;
						else
						return true;
					}
					
					
					public boolean cpIsDirectMailUncheck()
					{
						if (_cpAddressComponent.isSelected())
							return false;
							else
							return true;
						}
			
		
		
	//Method to click EDIT link for updating contact information in My Account page
		
			public void clickEditCommunicationPref()
		    {
				log.info("Clicking EDIT link to Update Communication Preferences in My Account Page..");
			   waitFor(_editCommunicationPref);
				_editCommunicationPref.click();
				log.info("Clicked EDIT link to update Communication Preferences in My Account Page..");
		    }
			
			
			
			public void cpEnterEmail(String Email) throws InterruptedException
			{
	            
				boolean isChecked = _cpCheckIfEmail.isSelected();
				 
				   if (isChecked == false)
				   {
					   Thread.sleep(5000);
					     _cpCheckIfEmail.click();
					     log.info("Checked Email Check box in  Communication Preferences Pop up in My Account Page..");
						    
					   	waitFor(_cpEnterEmail);
						 _cpEnterEmail.clear();
						 _cpEnterEmail.sendKeys(Email);
						 log.info("Entered Email Address in Communication Preferences Pop up in My Account Page..");
				    }
				   else 
				   {
					   waitFor(_cpEnterEmail);
					   _cpEnterEmail.clear();
					   _cpEnterEmail.sendKeys(Email);
					   log.info("Entered Email Address in Communication Preferences Pop up in My Account Page..");
	   
				   }

			}
			
			public String cpGetEmail() throws InterruptedException
		    {
				  Thread.sleep(10000);
				waitFor(_cpEnterEmailPage);
				System.out.println("Fetching Email information in Communication Pref from My Account page");
				String userData=_cpEnterEmailPage.getText();
				System.out.println(userData);
				return userData;
				
		    }
			
			
	//Method to check if SAVE Button is enabled or disabled in Communication Pref Popup 
					
		public boolean cpIsSaveButtonInPopUpDisabled() throws InterruptedException
					{
			         Thread.sleep(5000);
					String disabled="ss-submit-button ss-update-communication-preferences ss-submit-button-disabled";
					String actual=_cpSaveButtonInEditAddress.getAttribute("class");
					
					if(actual.equalsIgnoreCase(disabled))
						return true;
					else
						return false;
					}
		
		public boolean cpIsSaveButtonInPopUpDirectMailDisabled() throws InterruptedException
		{
         Thread.sleep(5000);
		String disabled="ss-submit-button ss-communication-preferences-address-btn ss-submit-button-disabled";
		String actual=_cpSaveButtonInEditAddress.getAttribute("class");
		
		if(actual.equalsIgnoreCase(disabled))
			return true;
		else
			return false;
		}
		
					
			
			public void cpEnterSMS(String mobilePhone) throws InterruptedException
			{
					
				boolean isChecked = _cpCheckIfSMS.isSelected();
				 				
				   if (isChecked == false)
				   {
					   Thread.sleep(5000);
					   _cpCheckIfSMS.click();
					     log.info("Checked SMS Check box in Communication Preferences Pop up in My Account Page..");
						    
					     String mb1, mb2, mb3;
						
					     mb1 = mobilePhone.substring(0, 3);
					     mb2 = mobilePhone.substring(3, 6);
					     mb3 = mobilePhone.substring(6, 10);
								
					   	waitFor(_cpCheckIfSMS);
					   	_cpMobNo1.clear();
					   	_cpMobNo1.sendKeys(mb1);
						_cpMobNo2.clear();
					   	_cpMobNo2.sendKeys(mb2);	
					   	_cpMobNo3.clear();
					   	_cpMobNo3.sendKeys(mb3);
					   	
						 log.info("Entered Mobile number in Communication Preferences Pop up in My Account Page..");
				    }
				   else 
				   {
					   String mb1, mb2, mb3;
						
					     mb1 = mobilePhone.substring(0, 3);
					     mb2 = mobilePhone.substring(3, 6);
					     mb3 = mobilePhone.substring(6, 10);
								
					   	waitFor(_cpCheckIfSMS);
					   	_cpMobNo1.clear();
					   	_cpMobNo1.sendKeys(mb1);
						_cpMobNo2.clear();
					   	_cpMobNo2.sendKeys(mb2);	
					   	_cpMobNo3.clear();
					   	_cpMobNo3.sendKeys(mb3);
					   	
					   log.info("Entered Mobile number in Communication Preferences Pop up in My Account Page..");
	   			   }
			}
			
			public String cpGetSMS() throws InterruptedException
		    {
				
				System.out.println("Fetching Mobile number  information in Communication Pref from My Account page");
				 Thread.sleep(20000);
				 
				String SMS1=_cpMobNo1Page.getText();
				String SMS2=_cpMobNo2Page.getText();
			    String SMS3=_cpMobNo3Page.getText();
			
				String SMS = (SMS1+SMS2+SMS3);
				System.out.println(SMS); 
				return SMS;
			  }
			
			public String cpGetMobileNo() throws InterruptedException
		    {
				
				System.out.println("Fetching Mobile number information Under Contact Info section  from My Account page");
				 Thread.sleep(5000);
				 
				String Mob=_cpMobileNoContInfoSec.getText();
			
				System.out.println(Mob); 
				return Mob;
			  }
			
			public void cpEnterAddress(String firstName, String lastName, String address1, String address2, String city, String  state, String zip)
			{
					
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
				Select Object = new Select(_state);
				Object.selectByVisibleText("CO");
				Object.selectByVisibleText("LA");
				
				waitFor(_zip);
				_zip.clear();
				_zip.sendKeys(zip);
					
				log.info("Entered the Contact Information details in Communication Pref pop up..");
					
			}
	

			// Click use this address in QAS Validation
				
				public void clickUseThisAddressButton() throws InterruptedException{
					
					waitFor(_useThisAddress);
					_useThisAddress.click();
					
					log.info("Clicked on Use this address button on Address Verification");
					Thread.sleep(5000);
				}
				
				// Click EDIT link in QAS Validation
				
				public void clickEditLinkInQAS() throws InterruptedException{
					
					waitFor(_editQAS);
					_editQAS.click();
					
					log.info("Clicked on EDIT link in QAS Verification");
					Thread.sleep(5000);
				}

			
			@FindBy(id = "currentFirstName")
			private WebElement _cpCurrentFirstName;
			
			public String cpGetFirstName() throws InterruptedException
		    {
				waitFor(_cpCurrentFirstName);
				Thread.sleep(10000);
				System.out.println("Fetching First Name information from Communication Pref section");
				String FN=_cpCurrentFirstName.getText();
				System.out.println("First Name:" +FN);
				return FN;
				
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
			
			public void cpCheckDirectMail(WebDriver _driver) throws InterruptedException
			{
	            
				boolean isChecked = _cpCheckIfDirectMail.isSelected();
				 
				if (isChecked == false)
				   {
					   Thread.sleep(5000);
					   _cpCheckIfDirectMail.click();
					     log.info("Checked Direct Mail Check box in  Communication Preferences Pop up in My Account Page..");
				 }
				  
			}
			
			
			public void cpClickSaveButtonInEditAddress()
		    {
				 waitFor(_cpSaveButtonInEditAddress);
				 _cpSaveButtonInEditAddress.click();
				log.info("Clicked SAVE button to Update Mailing address in Edit address., Communication Preferences Pop up in My Account Page..");
		    }
			
			public void cpClickGoBackLinkInEditAddress()
		    {
				 waitFor(_cpGoBackLinkInEditAddress);
				 _cpGoBackLinkInEditAddress.click();
				log.info("Clicked GO BACK link to while Updating Mailing address in Edit address., Communication Preferences Pop up in My Account Page..");
		    }
			
			public void cpClickLinkToUpdateMailingAddress()
		    {
					boolean result = _cpLinkToEnterMailingAddress.isDisplayed();
			
				if(result)
					{
			     	 _cpLinkToEnterMailingAddress.click();
					}			
				else
				{
					 _cpLinkToEditMailingAddress.click();
				}
					
				log.info("Clicked link to Update Mailing address in Communication Preferences Pop up in My Account Page..");
		    }
				
}
