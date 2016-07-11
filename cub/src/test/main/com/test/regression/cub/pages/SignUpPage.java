package com.test.regression.cub.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.regression.cub.utils.SuiteBase;

public class SignUpPage extends SuiteBase{
	
	WebDriver _driver;
	
	public SignUpPage(WebDriver driver) {
		super();
		_driver=driver;
		PageFactory.initElements(_driver, this);
	}

	@FindBy(xpath = "//a[text()='Sign Up']")
	private WebElement _signUpLink;
	
	@FindBy(id = "ss-email-input")
	private WebElement _userName;
	
	@FindBy(id = "ss-password-login")
	private WebElement _password;
	
	@FindBy(xpath = "//button[text()='Continue']") 
	private WebElement _continueButton;
	
	@FindBy(id = "confirm-rewards-no-no")
	private WebElement _dontWantCardRadio;
	
	@FindBy(id = "confirm-rewards-yes")
	private WebElement _yesHaveCardRadio;
	
	@FindBy(id = "confirm-rewards-no-yes")
	private WebElement _noButWantCardRadio;
	
	@FindBy(xpath = "//a[text()='Log Out']")
	private WebElement _logOut;
	
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
	
	@FindBy(id = "ss-signup-cardlessid-1")
	private WebElement _cardless1;
	
	@FindBy(id = "ss-signup-cardlessid-2")
	private WebElement _cardless2;
	
	@FindBy(id = "QAS_AcceptOriginal")
	private WebElement _useThisAddress;
	
	@FindBy(id = "ss-add-rewards-lastname-input")
	private WebElement _lastNameInAddRewardsPopup;
	
	@FindBy(id = "ss-add-rewards-card-number-input")
	private WebElement _rewardsNumInAddRewardsPopup;
	
	@FindBy(id = "ss-add-rewards-cardlessid-input-7")
	private WebElement _cardlessId1InAddRewardsPopup;
	
	@FindBy(id = "ss-add-rewards-cardlessid-input-4")
	private WebElement _cardlessId2InAddRewardsPopup;
	
	@FindBy(xpath = "//div[@class='ss-cardconfirm-container ss-inner-container']/a")
	private WebElement _closeButtonInRewardsCardPopup;
	
	public void clickSignUpLink() throws InterruptedException{
		
		waitFor(_signUpLink);
		
		_signUpLink.click();
		
	}
	
	public void enterSignUpDetails(String UserName, String Password){
		waitFor(_userName);
		_userName.sendKeys(UserName);
		waitFor(_password);
		_password.sendKeys(Password);
		_password.sendKeys(Keys.ENTER);
		
	}
	
	public void clickContinueButtonNoCheck() throws InterruptedException{
		
		waitFor(_continueButton);
		_continueButton.click();
		
	}
	
	public void clickContinueButton() throws InterruptedException{
		
		waitFor(_continueButton);
		
		System.out.println("Continue Button presence flag :" + _continueButton.isEnabled());
		if(_continueButton.isEnabled())
		_continueButton.click();
		
	}
	
	public void closeRewardsCardPopup(){
		
		waitFor(_closeButtonInRewardsCardPopup);
		_closeButtonInRewardsCardPopup.click();
	}
	
	public void clickDontWantCardRadio() throws InterruptedException{
		
		waitFor(_dontWantCardRadio);
		
		_dontWantCardRadio.click();
		
	}
	
	public void clickNoButWantCardRadio() throws InterruptedException{
		
		waitFor(_noButWantCardRadio);
		
		_noButWantCardRadio.click();
		
	}
	public void clickYesHaveCardRadio() throws InterruptedException{
		
		waitFor(_yesHaveCardRadio);
		
		_yesHaveCardRadio.click();
		
	}
	
	public void enterContactInformationInSignUp(String firstName, String lastName, String address1, String address2, String city, String  state, String zip, String homePhone, String mobilePhone, String cardlessId ){
		
		//Logger log = Logger.getLogger(SignUp_Tests.class);
		String homephone1, homephone2, homephone3;
		String mobilephone1, mobilephone2, mobilephone3;
		String cardlessId1, cardlessId2;
		homephone1 = homePhone.substring(0, 3);
		homephone2 = homePhone.substring(3, 6);
		homephone3 = homePhone.substring(6, 10);
		mobilephone1 = mobilePhone.substring(0, 3);
		mobilephone2 = mobilePhone.substring(3, 6);
		mobilephone3 = mobilePhone.substring(6, 10);
		cardlessId1 = cardlessId.substring(0, 7);
		cardlessId2 = cardlessId.substring(7, 11);
		
		waitFor(_firstName);
		_firstName.sendKeys(firstName);
		waitFor(_lastName);
		_lastName.sendKeys(lastName);
		waitFor(_address1);
		_address1.sendKeys(address1);
		waitFor(_address2);
		_address2.sendKeys(address2);
		waitFor(_city);
		_city.sendKeys(city);
		waitFor(_state);
		_state.sendKeys(state);
		waitFor(_zip);
		_zip.sendKeys(zip);
		waitFor(_homephone1);
		_homephone1.sendKeys(homephone1);
		waitFor(_homephone2);
		_homephone2.sendKeys(homephone2);
		waitFor(_homephone3);
		_homephone3.sendKeys(homephone3);
		waitFor(_mobilephone1);
		_mobilephone1.sendKeys(mobilephone1);
		waitFor(_mobilephone2);
		_mobilephone2.sendKeys(mobilephone2);
		waitFor(_mobilephone3);
		_mobilephone3.sendKeys(mobilephone3);
		waitFor(_cardless1);
		_cardless1.sendKeys(cardlessId1);
		waitFor(_cardless2);
		_cardless2.sendKeys(cardlessId2);
		_cardless2.sendKeys(Keys.ENTER);
			
	}
	
	public void clickUseThisAddressButton(){
	
		waitFor(_useThisAddress);
		_useThisAddress.click();
	}
	
	public void addRewardsCard_EnterDetails(String lastname, String rewardsNum){
		
		waitFor(_lastNameInAddRewardsPopup);
		_lastNameInAddRewardsPopup.sendKeys(lastname);
		waitFor(_rewardsNumInAddRewardsPopup);
		_rewardsNumInAddRewardsPopup.sendKeys(rewardsNum);
		_rewardsNumInAddRewardsPopup.sendKeys(Keys.ENTER);
	}
	
	public boolean isLogOutButtonPresent(){
		waitFor(_logOut);
		return(_logOut.isDisplayed());
		
	}
	
}
