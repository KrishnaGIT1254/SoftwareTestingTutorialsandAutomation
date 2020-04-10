package com.STTA.testCases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_ObjectRepositoryUsingPropertiesFile_016 extends BaseClass {
	
	@Test
	public void testObjectRepositoryUsingPropertiesFile() throws IOException
	{
		//Application Launch
				
		String url = "http://only-testing-blog.blogspot.in/2014/04/calc.html";
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
			    
			    
			    //From here test is started
			    
			    //create Object of Properties class
			    Properties obj = new Properties();
			    
			    //Create Object of FileInputStream Class. Pass file path.
			    FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\com\\STTA\\ObjectRepo\\objects.properties");
			   
			    //Pass object reference objfile to load method of Properties object.
			    obj.load(fis);
			    
			    //Sum operation on calculator.
			    //Accessing element locators of all web elements using obj.getProperty(key)
			    driver.findElement(By.id(obj.getProperty("eight"))).click();
			    driver.findElement(By.id(obj.getProperty("plus"))).click();
			    driver.findElement(By.id(obj.getProperty("four"))).click();
			    driver.findElement(By.id(obj.getProperty("equalsto"))).click();
			    
			    String i = driver.findElement(By.id(obj.getProperty("result"))).getAttribute("value");
			    System.out.println(obj.getProperty("eight")+" + "+obj.getProperty("four")+" = "+i); 
			    
			    driver.findElement(By.id(obj.getProperty("result"))).clear();
			    
			    //Subtraction operation on calculator.
			    //Accessing element locators of all web elements using obj.getProperty(key)
			    driver.findElement(By.id(obj.getProperty("nine"))).click();
			    driver.findElement(By.id(obj.getProperty("minus"))).click();
			    driver.findElement(By.xpath(obj.getProperty("three"))).click();
			    
			    driver.findElement(By.id(obj.getProperty("equalsto"))).click();
			    String j = driver.findElement(By.id(obj.getProperty("result"))).getAttribute("value");
			    System.out.println(obj.getProperty("nine")+" - "+obj.getProperty("three")+" = "+j);
			    
			    
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
		        
		        if(driver.getTitle().equals("Only Testing: Calc"))
				{
					Assert.assertTrue(true);
					logger.info("testObjectRepositoryUsingPropertiesFile Test Passed");
				}
				else
				{
					captureScreen(driver,"testObjectRepositoryUsingPropertiesFile");
					Assert.assertTrue(false);
					logger.info("testObjectRepositoryUsingPropertiesFile Test failed");
				} 
		        
	}

}
