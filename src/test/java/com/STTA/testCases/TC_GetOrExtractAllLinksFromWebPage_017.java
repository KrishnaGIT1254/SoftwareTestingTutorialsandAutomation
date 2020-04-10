package com.STTA.testCases;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_GetOrExtractAllLinksFromWebPage_017 extends BaseClass{

	@Test
	public void testGetOrExtractAllLinksFromWebPage() throws Exception
	{
		
		
		//Application Launch
				String url = "http://only-testing-blog.blogspot.in/2014/01/textbox.html";
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
			    
			    
			  //From Here Actual Test start
			    
			  //create Object of Properties class
			    Properties obj = new Properties();
			    
			    //Create Object of FileInputStream Class. Pass file path.
			    FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\com\\STTA\\ObjectRepo\\objects.properties");
			   
			    //Pass object reference objfile to load method of Properties object.
			    obj.load(fis);
			    
			    
			    try {
			    	
			    	//List<WebElement> no = driver.findElements(By.tagName("a"));
			    	List<WebElement> no = driver.findElements(By.tagName(obj.getProperty("alllinks")));
			        int noofLinks = no.size();
			        logger.info("No of Links are captured");
			        System.out.println(noofLinks);
			        for(WebElement pageLink:no)
			        {
			        	String linkText = pageLink.getText();
			        	String link = pageLink.getAttribute("href");
			        	System.out.println(linkText+" ->");
			        	System.out.println(link);
			        	logger.info("all links names are Captured");
			        	logger.info("all links attributes are Captured");
			        	
			        }
			    	
			    }
			    catch(Exception e)
			    {
			    	System.out.println("error "+e);
			    }
			    
			    logger.info("Required Action completed Successfully");
			    
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
					logger.info("testGetOrExtractAllLinksFromWebPage Test Passed");
				}
				else
				{
					captureScreen(driver,"testGetOrExtractAllLinksFromWebPage");
					Assert.assertTrue(false);
					logger.info("testGetOrExtractAllLinksFromWebPage Test failed");
				} 
		        
			    
	}
}
