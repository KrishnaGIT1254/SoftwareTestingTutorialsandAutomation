package com.STTA.testCases;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_DiifBetweenSubmitAndClick_007 extends BaseClass{
	
	@Test
	public void testDiffBetClickAndSubmit() throws Exception
	{
		//Application Launch
		String url = "http://only-testing-blog.blogspot.com/2014/05/form.html";
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
			    
			    //Perform actual Test 
			    
			  //create Object of Properties class
			    Properties obj = new Properties();
			    
			    //Create Object of FileInputStream Class. Pass file path.
			    FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\com\\STTA\\ObjectRepo\\objects.properties");
			   
			    //Pass object reference objfile to load method of Properties object.
			    obj.load(fis);
			    
			    //Enter data in respective feilds
			    driver.findElement(By.xpath(obj.getProperty("myfname"))).sendKeys("MyFName");
			    logger.info("First name entered");
			    driver.findElement(By.xpath(obj.getProperty("mylname"))).sendKeys("MyLName");
			    logger.info("Second name entered");
			    driver.findElement(By.xpath("//input[@name='EmailID']")).sendKeys("My Email ID");
			    logger.info("Email entered");
			    driver.findElement(By.xpath("//input[@name='MobNo']")).sendKeys("My Mob No.");
			    logger.info("Mobile number entered");
			    driver.findElement(By.xpath("//input[@name='Company']")).sendKeys("My Comp Name");
			    logger.info("Company name entered");
			    
			    
			    //To submit form.
			    //You can use any other Input field's(First Name, Last Name etc.) xpath too In bellow given syntax.
			    WebElement sb = driver.findElement(By.xpath("//input[@type='submit']"));
			    sb.submit();
			    logger.info("Clicked on Submit button");
			    Alert al  = driver.switchTo().alert();
			    String alText = al.getText();
			    logger.info("Captured the alert Text");
			    System.out.println("Alert Text is "+alText);
			    al.accept();
			    logger.info("Alert handled");
			    logger.info("Required Action Completed Successfully");
			    
			    //below code for URL verification
			    
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
		        
		        if(driver.getTitle().equals("Only Testing: Form"))
				{
					Assert.assertTrue(true);
					logger.info("testDiffBetClickAndSubmit Test Passed");
				}
				else
				{
					captureScreen(driver,"testDiffBetClickAndSubmit");
					Assert.assertTrue(false);
					logger.info("testDiffBetClickAndSubmit Test failed");
				} 
		        
			    
			    
			    
			    
			    
	}
	

}
