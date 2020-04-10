package com.STTA.testCases;

import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_ExtractingAllTextFieldsFromWebPage_018 extends BaseClass{
	
	@Test
	public void testExtractingAllTextFieldsFromWebPage() throws Exception
	{
		//Application Launch 
				String url ="http://only-testing-blog.blogspot.in/2014/05/login.html";
				 
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
				  
				  
				  //From Here Actual Test start
				  
				//create Object of Properties class
				    Properties obj = new Properties();
				    
				    //Create Object of FileInputStream Class. Pass file path.
				    FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\com\\STTA\\ObjectRepo\\objects.properties");
				   
				    //Pass object reference objfile to load method of Properties object.
				    obj.load(fis);
				    
				//find all input fields where type = text or password and store them In array list txtfields
				  List <WebElement> td = driver.findElements(By.xpath(obj.getProperty("alltxtboxes")));
				  
				  //for to send text in all textboxes one by one
				  for(int i=0; i<td.size(); i++)
				  {
					  td.get(i).sendKeys("Text"+(i+1));
				  }
				  
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
			        
			        if(driver.getTitle().equals("Only Testing: LogIn"))
					{
						Assert.assertTrue(true);
						logger.info("testExtractingAllTextFieldsFromWebPage Test Passed");
					}
					else
					{
						captureScreen(driver,"testExtractingAllTextFieldsFromWebPage");
						Assert.assertTrue(false);
						logger.info("testExtractingAllTextFieldsFromWebPage Test failed");
					} 
			        
	}



@Test
public void testMethod()
{
	System.out.println("This is second Method Test in same Class ");
}

}
