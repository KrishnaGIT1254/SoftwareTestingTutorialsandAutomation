package com.STTA.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_DataproviderDDT_002 extends BaseClass{
	
	//Give data provider method name as data provider.
	 //Passed 2 string parameters as LoginCredentials() returns 2 parameters In object.
	 @Test(dataProvider="LoginCredentials")
	 public void LogIn_Test(String Usedid, String Pass) throws IOException{
	   driver.get("http://only-testing-blog.blogspot.in/2014/05/login.html"); 
	   logger.info("Application URL is launched");
	   
	    String i = driver.getCurrentUrl();
	    System.out.println("This is the Page Current URL: "+i);
	    logger.info("we got Current page URL");
	    
	   driver.findElement(By.xpath("//input[@name='userid']")).clear();
	   logger.info("User id feild is cleared");
	   driver.findElement(By.xpath("//input[@name='pswrd']")).clear();
	   logger.info("Password feild is cleared");
	   driver.findElement(By.xpath("//input[@name='userid']")).sendKeys(Usedid);
	   logger.info("Username is entered");
	   driver.findElement(By.xpath("//input[@name='pswrd']")).sendKeys(Pass);
	   logger.info("Password is entered");
	   driver.findElement(By.xpath("//input[@value='Login']")).click();
	   logger.info("Clicked on login button");
	   String alrt = driver.switchTo().alert().getText();
	   logger.info("Alert text is captured");
	   driver.switchTo().alert().accept();
	   logger.info("Alert is handled");
	   System.out.println(alrt);
	   
	   if(driver.getTitle().equals("Only Testing: LogIn"))
		{
			Assert.assertTrue(true);
			logger.info("LogIn_Test Test Passed");
		}
		else
		{
			captureScreen(driver,"LogIn_Test");
			Assert.assertTrue(false);
			logger.info("LogIn_Test Test failed");
		} 
       
	   
	  }
	 
	 

}
