package com.STTA.testCases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class TC_ParameterizationOrDataDrivenTesting_022 extends BaseClass{

	
	@Test
	public void testDDTorParameterization() throws BiffException, IOException, InterruptedException
	{
		//Application Launch
				String url = "http://only-testing-blog.blogspot.in/2013/11/new-test.html";
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
					    JavascriptExecutor javascript1 = (JavascriptExecutor) driver;
					    String CurrentURLUsingJS=(String)javascript1.executeScript("return document.domain");
					    System.out.println("My Current URL domain name is: "+CurrentURLUsingJS);
					    logger.info("Stored the Domain name of the current url");
					    
					    
					    
		
		//Open MyDataSheet.xls file from given location. 
		 
		FileInputStream fileinput = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\com\\STTA\\testData\\MyDataSheet.xls");
	
		//Access first data sheet. getSheet(0) describes first sheet.
		  Workbook wbk = Workbook.getWorkbook(fileinput);
		  Sheet sheet = wbk.getSheet(0);
		  
		//Read data from the first data sheet of xls file and store it in array.
		  String TestData[][] = new String[sheet.getRows()][sheet.getColumns()];
		  
		//To enable Last Name text box.
		  JavascriptExecutor javascript = (JavascriptExecutor) driver;
		  String toenable = "document.getElementsByName('lname')[0].removeAttribute('disabled');";
		  javascript.executeScript(toenable);
		  
		//Type data in first name and last name text box from array.
		  for(int i=0;i<sheet.getRows();i++)
		  {
		   for (int j=0;j<sheet.getColumns();j++)
		   {
		    TestData[i][j] = sheet.getCell(j,i).getContents();
		    if(j%2==0)
		    {
		     driver.findElement(By.xpath("//input[@name='fname']")).sendKeys(TestData[i][j]);
		    }
		    else
		    {
		     driver.findElement(By.xpath("//input[@name='lname']")).sendKeys(TestData[i][j]);
		    }
		   }
		   Thread.sleep(1000);
		   driver.findElement(By.xpath("//input[@name='fname']")).clear();
		   driver.findElement(By.xpath("//input[@name='lname']")).clear();
		  }
		  Thread.sleep(1000);
		  
		  String Workdir = System.getProperty("user.dir");
		    String Classpackname = this.getClass().getName();
			
			System.out.print("\n'"+Workdir+" -> "+Classpackname+" -> testDDTorParameterization' has been executed successfully");
		  
		  


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
    
    if(driver.getTitle().equals("Only Testing: New Test"))
	{
		Assert.assertTrue(true);
		logger.info("testDDTorParameterization Test Passed");
	}
	else
	{
		captureScreen(driver,"testDDTorParameterization");
		Assert.assertTrue(false);
		logger.info("testDDTorParameterization Test failed");
	} 
	
	}
	
	
	
	
}


