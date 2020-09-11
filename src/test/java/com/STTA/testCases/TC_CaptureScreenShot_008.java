package com.STTA.testCases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_CaptureScreenShot_008 extends BaseClass{
	
	@Test
	public void testCaptureScreenshot() throws IOException
	{
		String url = "http://only-testing-blog.blogspot.com/2014/01/textbox.html";
		driver.get(url);
		logger.info("Application URL is Launched");
		
		//Title of the Webpage
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
	    
	    //Get domain name using java script executor
	    JavascriptExecutor javascript = (JavascriptExecutor) driver;
	    String CurrentURLUsingJS=(String)javascript.executeScript("return document.domain");
	    System.out.println("My Current URL domain name is: "+CurrentURLUsingJS);
	    logger.info("Stored the Domain name of the current url");
	    
	    
	  //Capture entire page screenshot and then store it to destination drive
	    File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    FileUtils.copyFile(screenshot, new File("C:\\Users\\Venkatakrishna\\Desktop\\SoftwareTestingTutorialsandAutomation\\Screenshots.jpg"));
	    System.out.print("Screenshot is captured and stored in your D: Drive");
	    
	    
	    
	    
	  //below code for URL Verification
        if (curl.equals(url)){ 
        	 System.out.println("Verification Successful - The correct Url is opened.");
        	 }
        	 else {
        	 System.out.println("Verification Failed - An incorrect Url is opened."); 
        	 
        	 //In case of Fail, you like to print the actual and expected URL for the record purpose 
        	 System.out.println("Actual URL is : " + curl); 
        	 System.out.println("Expected URL is : " + url);
        	
        	 }
        
      //below code for Title Verification once action Completed if it is wrong we Captured the Screen shot
        
        if(driver.getTitle().equals("Only Testing: TextBox"))
		{
			Assert.assertTrue(true);
			logger.info("testCaptureScreenshot Test Passed");
		}
		else
		{
			captureScreen(driver,"testCaptureScreenshot");
			Assert.assertTrue(false);
			logger.info("testCaptureScreenshot Test failed");
		} 
        
	}

}
