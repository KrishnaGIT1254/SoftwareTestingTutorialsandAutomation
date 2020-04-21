package com.STTA.testCases;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_AlertPopUpHandleNaveen_027 extends BaseClass {
	
	@Test
	public void testAlertPopUpHandleNaveen() throws IOException, Exception {

		
		  //Application Launch 
		   String url =
		  "https://mail.rediff.com/cgi-bin/login.cgi";
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
		  
		  driver.findElement(By.name("proceed")).click(); //click on Go btn
			
			Thread.sleep(5000);
			
			Alert alert = driver.switchTo().alert();
			
			System.out.println(alert.getText());
			
			String text = alert.getText();
			
			if(text.equals("Please enter a valid user name")){
				System.out.println("correct alert messg");
			}
			else{
				System.out.println("in-correct alert messg");
			}
			
			alert.accept(); //click on OK btn
			
			//alert.dismiss(); //click on cancel btn
			
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
	        
	        if(driver.getTitle().equals("Rediffmail"))
			{
				Assert.assertTrue(true);
				logger.info("testAlertPopUpHandleNaveen Test Passed");
			}
			else
			{
				captureScreen(driver,"testAlertPopUpHandleNaveen");
				Assert.assertTrue(false);
				logger.info("testAlertPopUpHandleNaveen Test failed");
			} 
	        
		  

}

}