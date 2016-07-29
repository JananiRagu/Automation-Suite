package com.test.regression.cub.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
	
	@FindBy(xpath = "//div[@class='account-section-details']/div/div[2]/div[@class='value personal current-cardlessid']")
	private WebElement _cardlessid;
	

//Method to click on My Account link under My Tools
	
public void clickOnMyAccountUnderMyTools(WebDriver driver)
{
		/*waitFor(_MyToolsLink);
		_MyToolsLink.click();
		waitFor(_MyAccount);
		_MyAccount.click();*/
	
	driver.navigate().to(Constant.URL+"tools/view-account.html");
	log.info("Clicked on Coupons in Home page");
	  
}

// Links in My account Page

	@FindBy(xpath = "//a[text()='Change Password']")
	private WebElement _ChangePwd;

// Elements in CHANGE PASSWORD pop up My Account page
	
	@FindBy(id = "ss-old-password")
	private WebElement _OldPwdTextBox;
	
	@FindBy(id = "ss-password-login")
	private WebElement _NewPwdTextBox;
	
	@FindBy(id = "ss-resetpassword-input2")
	private WebElement _ReEnterNewPwdTextBox;
	
	@FindBy(xpath = "//button[text()='Save']")
	private WebElement _SaveButtonInChangePwdPopUp;
	
	@FindBy(xpath = "//*[@id='layout']/div[2]/div[2]/a")
	private WebElement _XInChangePwdPopUp;
	
	@FindBy(xpath = "//div[@class='account-section-details acct-info']/div/div/div[2]")
	private WebElement _signedInAsUserName;
	

// Xpath for Change pwd Pop up
	
	@FindBy(xpath = "//*[@id='layout']/div[2]/div[2]")
	private WebElement _ChangePwdPopUp;

//Method to check if Change Pwd pop up is present
	
	public boolean isChangePwdPopUpPresent()
	{
		  waitFor(_ChangePwdPopUp);
            return _ChangePwdPopUp.isDisplayed();
		
	}
		
// Methods in CHANGE PASSWORD pop up My Account page

	public void clickOnChangePwdLink()
	{
		waitFor(_ChangePwd);
		_ChangePwd.click();
	}
	
	public void enterPwdDetails(String OldPwd, String NewPwd)
	{
		waitFor(_OldPwdTextBox);
		_OldPwdTextBox.sendKeys(OldPwd);
		_NewPwdTextBox.sendKeys(NewPwd);
		_ReEnterNewPwdTextBox.sendKeys(NewPwd);	

	}
	
	public void enterDiffPwdDetails(String OldPwd, String NewPwd1, String NewPwd2)
	{
		waitFor(_OldPwdTextBox);
		_OldPwdTextBox.sendKeys(OldPwd);
		_NewPwdTextBox.sendKeys(NewPwd1);
		_ReEnterNewPwdTextBox.sendKeys(NewPwd2);	

	}
	
	
	public void clickSaveButtonInChangePwdPopUp()
    {
		waitFor(_SaveButtonInChangePwdPopUp);
		_SaveButtonInChangePwdPopUp.click();
	}
	
	
	public void clickXInChangePwdPopUp()
    {
		waitFor(_XInChangePwdPopUp);
		_XInChangePwdPopUp.click();
	}

	public boolean chkCardlessIdPresent() {
		
		String cardlessId = _cardlessid.getText();
		
		
		System.out.println("Cardless Id is : " + cardlessId);
		
		 if(cardlessId.isEmpty())
			 return true;
		else
			return false;
	}
	
	public String getSignedInUsername(){
			String username = _signedInAsUserName.getText();
			
			return username;
		}
	
	
}


