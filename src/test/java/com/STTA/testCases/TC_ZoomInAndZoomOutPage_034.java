package com.STTA.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_ZoomInAndZoomOutPage_034 extends BaseClass{
	
	@Test
	public void testZoomInAndZoomOutPage() throws IOException, Exception {

		
		  //Application Launch 
		   String url = "http://google.com/";
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
		  
		//Call zooming functions to zoom in and out page.
			 zoomIn();
			 zoomOut();
			 zoomOut();
			 set100();
			 
		 }
		 public void zoomIn() throws InterruptedException {
			 for(int i = 0; i<4; i++) {
				 driver.findElement(By.tagName("html")).sendKeys(Keys.chord(Keys.CONTROL, Keys.ADD));
			 }
			 Thread.sleep(5000);
		 }
			 
		 
		 public void zoomOut() throws InterruptedException {
			 driver.findElement(By.tagName("html")).sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT)); 
			 Thread.sleep(5000);
		 }
		 
		 
		 public void set100() throws IOException {
			 driver.findElement(By.tagName("html")).sendKeys(Keys.chord(Keys.CONTROL, "0")); 
		
		 
		 
		 
		 
		 
		//below code for Title Verification once action Completed if it is wrong we Captured the Screen shot
	        
	        if(driver.getTitle().equals("Google"))
			{
				Assert.assertTrue(true);
				logger.info("testZoomInAndZoomOutPage Test Passed");
			}
			else
			{
				captureScreen(driver,"testZoomInAndZoomOutPage");
				Assert.assertTrue(false);
				logger.info("testZoomInAndZoomOutPage Test failed");
			} 
	        
	  

		  

}

}
		  
	
	




