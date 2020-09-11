package com.STTA.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_WebElementsDemo_031 extends BaseClass{
	
	@Test
	public void testWebElementsDemo() throws IOException, Exception {

		
		  //Application Launch 
		   String url =
		  "http://book.theautomatedtester.co.uk/";
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
		  
		//Type text
			driver.findElement(By.id("q")).sendKeys("Selenium");
			//Click on Chapter1
			driver.findElement(By.linkText("Chapter1")).click();
			//Radio button
			WebElement radio=driver.findElement(By.id("radiobutton"));
			if(radio.isSelected())
			{
				System.out.println("Radio button is already selected");
			}
			else
			{
				radio.click();
			}
			//Check box
			WebElement checkbox=driver.findElement(By.name("selected(1234)"));
			if(checkbox.isSelected())
			{
				System.out.println("Check box is already selected");
			}
			else
			{
				checkbox.click();
			}
			//DD
			Select dd=new Select(driver.findElement(By.id("selecttype")));
			dd.selectByIndex(2);
			//dd.getFirstSelectedOption().getText();
			WebElement e=dd.getFirstSelectedOption();
			//System.out.println("Selected options is:"+e.getText());
			//Text Area
			driver.findElement(By.id("html5div")).clear();
			driver.findElement(By.id("html5div")).sendKeys("Selenium\nAppium");
			//Pause 4sec
			Thread.sleep(4000);
			
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
	        
	        if(driver.getTitle().equals("Selenium: Beginners Guide"))
	    	{
	    		Assert.assertTrue(true);
	    		logger.info("testWebElementsDemo Test Passed");
	    	}
	    	else
	    	{
	    		captureScreen(driver,"testWebElementsDemo");
	    		Assert.assertTrue(false);
	    		logger.info("testWebElementsDemoTest failed");
	    	} 
		  

}
}
