package com.STTA.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_HandlingDoubleClickAction_029 extends BaseClass{
	
	@Test
	public void testHandlingDoubleClickAction() throws IOException, Exception {

		
		  //Application Launch 
		   String url =
		  "http://api.jquery.com/dblclick/";
		  driver.get(url); 
		  logger.info("Application URL is Launched");
		  
		  //Title of the Webpage 
		  String Title = driver.getTitle();
		  System.out.println("The Title of the page is " +Title);
		  logger.info("The title of the page is stored");
		  
		  // Storing Title length in the Int variable 
		  int titleLength =
		  driver.getTitle().length(); 
		  System.out.println("The title length is " +titleLength);
		  logger.info("The title length is stored");
		  
		  //current URL of the page 
		  String curl = driver.getCurrentUrl();
		  System.out.println("This is the Page Current URL: "+curl);
		  logger.info("we got Current page URL");
		  
		  //Get domain name using java script executor 
		  JavascriptExecutor javascript =
		  (JavascriptExecutor) driver; String
		  CurrentURLUsingJS=(String)javascript.executeScript("return document.domain");
		  System.out.println("My Current URL domain name is: "+CurrentURLUsingJS);
		  logger.info("Stored the Domain name of the current url");
		  
		//From Here Actual test Start
		  
		  Actions act = new Actions(driver);

		  driver.switchTo().frame(0);

		  WebElement ele = driver.findElement(By.xpath("/html/body/div"));

		  // ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();",
		  // ele);// scroll down for the element

		  String color = ele.getCssValue("color").toString();
		  System.out.println("color before double click:" + color); // blue

		  Thread.sleep(5000);
		  act.doubleClick(ele).build().perform();

		  Thread.sleep(2000);
		  color = ele.getCssValue("color").toString();
		  System.out.println("color after double click:" + color); // yellow
		  
		  
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
	        
	        if(driver.getTitle().equals(".dblclick() | jQuery API Documentation"))
			{
				Assert.assertTrue(true);
				logger.info("testHandlingDoubleClickAction Test Passed");
			}
			else
			{
				captureScreen(driver,"testHandlingDoubleClickAction");
				Assert.assertTrue(false);
				logger.info("testHandlingDoubleClickAction Test failed");
			} 
	        


		  
		 }

		  

}
	

