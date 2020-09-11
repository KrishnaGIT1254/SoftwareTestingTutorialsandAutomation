package com.STTA.testCases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_HandlingJSAlerts_012 extends BaseClass{
	
	@Test
	public void testHandlingJSAlerts() throws Exception
	{
		//Application Launch
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
			    
			    try {
			    	//Here i am using try catch blocks for handling unexcepted Alerts
			    
			    //From Here Actual Test Start
			    
			     //Alert Pop up Handling.
			    driver.findElement(By.xpath("//input[@value='Show Me Alert']")).click();
			    //To locate Alert
			    Alert al1 = driver.switchTo().alert();
			    
			    //To read the text from alert popup.
			    String alText1 = al1.getText();
			    System.out.println("Alert popup Text is:"+alText1);
			    Thread.sleep(3000);
			    //To accept/Click Ok on alert popup.
			    al1.accept();
			    logger.info("Clicked on OK button in Alert popup");
			    
			    //Confirmation Pop up Handling.
			    driver.findElement(By.xpath("//button[contains(text(),'Show Me Confirmation')]")).click();
			    Alert al2 = driver.switchTo().alert();
			  //To read the text from alert popup.
			    String alText2 = al2.getText();
			    System.out.println("Alert popup Text is:"+alText2);
			    Thread.sleep(2000);
			    //To click On cancel button of confirmation box.
			     al2.dismiss();
			     logger.info("clicked on Cancel Button in confirmation box.");
			     
			   //Prompt Pop up Handling.
			     driver.findElement(By.xpath("//button[contains(.,'Show Me Prompt')]")).click();
			     Alert al3 = driver.switchTo().alert();
			     
			   //To read the text from alert popup.
				    String alText3 = al2.getText();
				    System.out.println("Alert popup Text is:"+alText3);
				    Thread.sleep(2000);
				    
				  //To type text In text box of prompt pop up.
				    al3.sendKeys("This is Krishna");
				    Thread.sleep(2000);
				    al3.accept();
				    logger.info("Text is entered in prompt pop up");
				    
			    }catch(Exception e) {
			    	
			    	System.out.println("unexpected alert not present"); 
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
						logger.info("testHandlingJSAlerts Test Passed");
					}
					else
					{
						captureScreen(driver,"testHandlingJSAlerts");
						Assert.assertTrue(false);
						logger.info("testHandlingJSAlerts Test failed");
					} 
			        
			        
			        
			        
				    
			    
			    
			    
			    
			    
			    
	}

}
