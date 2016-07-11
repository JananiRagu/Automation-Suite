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
import com.test.regression.cub.utils.Logg;
import com.test.regression.cub.utils.ReadXML;
import com.test.regression.cub.utils.SuiteBase;

public class SignIn extends SuiteBase {

	CubHome cubHome;
	Logger log = Logg.createLogger();
	ReadXML readxml = new ReadXML();

	@Test(priority = 1)
	
	public void validLogin() throws InterruptedException, IOException, XPathExpressionException, ParserConfigurationException, SAXException {
		
		// Retrieving test data for valid login
		Map<String, String> validLogin = readxml.getUserData("TestData.xml", "carded-user");
		String userId = validLogin.get("UserName");
		String password = validLogin.get("password");

		cubHome = new CubHome(_driver);
		
			log.info("User Name : " + userId);
			log.info("Password : " + password);
			log.info("Cub Home page is launched");
		cubHome.clickSignInLink();
			log.info("SignIn Link Clicked");
		cubHome.enterLoginDetails(userId, password);
			log.info("Entered login Details");
		cubHome.clickSignInButton();
			log.info("SignInButton Clicked");
			log.info("Entered all details and clicked on Sign In Button");
		
		boolean result = cubHome.isLogOutButtonPresent();
		System.out.println("Result is " + result);
		Assert.assertTrue(result);
		
	}
	
	@Test(priority=2,enabled=true) 
	  public void inValidLogin() throws InterruptedException, IOException, XPathExpressionException, ParserConfigurationException, SAXException{
		
		
		// Retrieving test data for valid login
		Map<String, String> invalidLogin = readxml.getUserData("TestData.xml", "invalid-user");
		String userId = invalidLogin.get("UserName");
		String password = invalidLogin.get("password");

		cubHome = new CubHome(_driver);
		
			log.info("User Name" + userId);
			log.info("Password" + password);
			log.info("Cub Home page is launched");
		cubHome.clickSignInLink();
			log.info("SignIn Link Clicked");
		cubHome.enterLoginDetails(userId, password);
			log.info("Entered login Details");
		cubHome.clickSignInButton();
			log.info("SignInButton Clicked");
			log.info("Entered all details and clicked on Sign In Button");
		
		Assert.assertTrue(cubHome.isPasswordIncorrectTextPresent());
	
	  }
	 

}
