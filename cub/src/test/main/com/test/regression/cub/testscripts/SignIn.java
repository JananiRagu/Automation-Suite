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
import com.test.regression.cub.pages.MyAccountPage;
import com.test.regression.cub.utils.Logg;
import com.test.regression.cub.utils.ReadXML;
import com.test.regression.cub.utils.SuiteBase;

public class SignIn extends SuiteBase {

	CubHome cubHome;
	
	MyAccountPage map;
	Logger log = Logg.createLogger();
	ReadXML readxml = new ReadXML();

	@Test(priority=1, enabled=true)
	
	public void validLogin() {
		try {
			
		// Retrieving test data for valid login
		Map<String, String> validLogin = readxml.getUserData("TestData.xml", "authorized-user-1");
		String userId = validLogin.get("UserName");
		String password = validLogin.get("password");

		cubHome = new CubHome(_driver);
			log.info("Test Data Used >>>>>>>");
			log.info("User Name : " + userId);
			log.info("Password : " + password);
		
		cubHome.clickSignInLink();
		
		cubHome.enterLoginDetails(userId, password);

		cubHome.clickSignInButton();
		
		map = new MyAccountPage(_driver);
		
		map.clickOnMyAccountUnderMyTools(_driver);
		
		String username = map.getSignedInUsername();
		
		boolean result = username.equalsIgnoreCase(userId);
		System.out.println("Result is " + result);
		Assert.assertTrue(result);
		
		} catch (InterruptedException ie) {
			log.info(ie.getMessage());
			Assert.fail("Caught Interrupted Exception");
		} catch (IOException ioe) {
			log.info(ioe.getMessage());	
			Assert.fail("Caught IOException Exception");
		} catch (XPathExpressionException xee) {
			log.info(xee.getMessage());	
			Assert.fail("Caught XPathExpressionException Exception");
		} catch (ParserConfigurationException pce) {
			log.info(pce.getMessage());
			Assert.fail("Caught ParserConfigurationException Exception");
		} catch (SAXException saxe) {
			log.info(saxe.getMessage());
			Assert.fail("Caught SAXException Exception");
		} catch (Exception e) {
			log.info(e.getMessage());
			Assert.fail(e.getLocalizedMessage());
		}
	}
	
	@Test(priority=2,enabled=false) 
	  public void inValidLogin(){
		
		try {
		// Retrieving test data for valid login
		Map<String, String> invalidLogin = readxml.getUserData("TestData.xml", "invalid-user-1");
		String userId = invalidLogin.get("UserName");
		String password = invalidLogin.get("password");

		cubHome = new CubHome(_driver);
		
			log.info("Test Data Used >>>>>>>");
			log.info("User Name" + userId);
			log.info("Password" + password);
			
		cubHome.clickSignInLink();
			
		cubHome.enterLoginDetails(userId, password);
			
		cubHome.clickSignInButton();
		
		Assert.assertTrue(cubHome.isPasswordIncorrectTextPresent());
	
		} catch (InterruptedException ie) {
			log.info(ie.getMessage());
			Assert.fail("Caught Interrupted Exception");
		} catch (IOException ioe) {
			log.info(ioe.getMessage());	
			Assert.fail("Caught IOException Exception");
		} catch (XPathExpressionException xee) {
			log.info(xee.getMessage());	
			Assert.fail("Caught XPathExpressionException Exception");
		} catch (ParserConfigurationException pce) {
			log.info(pce.getMessage());
			Assert.fail("Caught ParserConfigurationException Exception");
		} catch (SAXException saxe) {
			log.info(saxe.getMessage());
			Assert.fail("Caught SAXException Exception");
		} catch (Exception e) {
			log.info(e.getMessage());
			Assert.fail(e.getLocalizedMessage());
		}
	 
	}
	
}
