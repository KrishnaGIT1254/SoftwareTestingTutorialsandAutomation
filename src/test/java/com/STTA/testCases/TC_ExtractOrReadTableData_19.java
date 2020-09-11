package com.STTA.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_ExtractOrReadTableData_19 extends BaseClass{

	@Test
	public void testExtractOrReadTableData() throws Exception
	{
		 //Application Launch 
		String url =
		  "http://only-testing-blog.blogspot.com/2013/09/test.html";
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
		  
		//Get number of rows In table.
		  int Row_count = driver.findElements(By.xpath("//*[@id='post-body-6522850981930750493']/div[1]/table/tbody/tr")).size();
		  System.out.println("Number Of Rows = "+Row_count);
		  
		//Get number of columns In table.
		  int Col_count = driver.findElements(By.xpath("//*[@id='post-body-6522850981930750493']/div[1]/table/tbody/tr[1]/td")).size();
		  System.out.println("Number Of Columns = "+Col_count);
		  
		//divided xpath In three parts to pass Row_count and Col_count values.
		  String first_part = "//*[@id='post-body-6522850981930750493']/div[1]/table/tbody/tr[";
		  String second_part = "]/td[";
		  String third_part = "]";
		  
		  //Used for loop for number of rows.
		  for (int i=1; i<=Row_count; i++){
		   //Used for loop for number of columns.
		   for(int j=1; j<=Col_count; j++){
			   
			 //Prepared final xpath of specific cell as per values of i and j.
			   String final_xpath = first_part+i+second_part+j+third_part;
			   
			   //Will retrieve value from located cell and print It.
			   String Table_data = driver.findElement(By.xpath(final_xpath)).getText();
			   System.out.print(Table_data +"  ");   
			   
		   }
		   
		   System.out.println("");
		   System.out.println("");
		   
		  }
		  
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
	        
	        if(driver.getTitle().equals("Only Testing: MyTest"))
			{
				Assert.assertTrue(true);
				logger.info("testExtractOrReadTableData Test Passed");
			}
			else
			{
				captureScreen(driver,"testExtractOrReadTableData");
				Assert.assertTrue(false);
				logger.info("testExtractOrReadTableData Test failed");
			} 
	        
	        
		   }
	
	@Test
	  public void testmethodone() {
	  driver.navigate().to("http://only-testing-blog.blogspot.in/2014/01/textbox.html");
	  String title = driver.getTitle();
	  System.out.print("\nCurrent page title is : "+title);
	  String Workdir = System.getProperty("user.dir");
	  String Classpackname = this.getClass().getName();
	  System.out.print("\n'"+Workdir+" -> "+Classpackname+" -> testmethodone' has been executed successfully");
	  }
		  
	}

