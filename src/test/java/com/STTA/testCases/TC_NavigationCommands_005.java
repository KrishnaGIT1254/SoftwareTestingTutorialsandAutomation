package com.STTA.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_NavigationCommands_005 extends BaseClass{
	
	
	@Test
	public void testBrowsercmds() throws IOException
	{
	// Open ToolsQA web site
	 String appUrl = "https://www.google.com/";
	 driver.get(appUrl);
	 logger.info("Application URL is opend");
	 
	//title of the Webpage
	String Title = driver.getTitle();
	System.out.println("The Title of the page is " +Title);
	logger.info("The title of the page is stored");
	
	// Storing Title length in the Int variable 
	int titleLength = driver.getTitle().length();
	System.out.println("The title length is " +titleLength);
	logger.info("The title length is stored");
	
	//current URL of the page
	String curl = driver.getCurrentUrl();
    System.out.println("This is the Page Current URL: "+curl);
    logger.info("we got Current page URL");
	 
	 // Click on Registration link
	 driver.findElement(By.linkText("Gmail")).click();
	 logger.info("Clicked on Gmail link in Google page");
    
	 logger.info("Gmail page is opend");
	 
	 // Go back to Home Page
	 driver.navigate().back();
	 logger.info("Navigate back to Google page ");
	 
	 // Go forward to Registration page
	 driver.navigate().forward();
	 logger.info("Navigate forward to gmail page");
	 
	 // Go back to Home page
	 driver.navigate().to(appUrl);
	 logger.info("Navigate to Google page");
	 
	 // Refresh browser
	 driver.navigate().refresh();
	 logger.info("Google page is refreshed");
	 
	 
	 if(driver.getTitle().equals("Google"))
		{
			Assert.assertTrue(true);
			logger.info("testBrowsercmds Test Passed");
		}
		else
		{
			captureScreen(driver,"testBrowsercmds");
			Assert.assertTrue(false);
			logger.info("testBrowsercmds Test failed");
		} 
     
	}
	
}