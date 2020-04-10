package com.STTA.testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_AssertEqualsTestNG_023 extends BaseClass{
	
	String Actualtext;
	
	@Test
	public void testAssertEqualsTestNG()
	{
		//Application Launch
		String url = "http://only-testing-blog.blogspot.in/2014/01/textbox.html";
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
	    
	  
		
	}

	
	//Method Example For Assertion
    @Test
     public void assertion_method_1() {
     Actualtext = driver.findElement(By.xpath("//h2/span")).getText();
     Assert.assertEquals(Actualtext, "Tuesday, 28 January 2014");
     //Assert.assertNotEquals(Actualtext, "Tuesday, 28 January 2014", "Expected and actual match in assertion_method_1");
     System.out.print("\n assertion_method_1() -> Part executed");
    } 
    
  //Method Example For Assertion
    @Test
    public void assertion_method_2() {  
     Assert.assertEquals(Actualtext, "Tuesday, 28 January 2014");
     // Assert.assertNotEquals(Actualtext, "Tuesday, 29 January 2014", "Expected and actual match in assertion_method_2");
     System.out.print("\n assertion_method_2() -> Part executed");
    }
    
  //Method Example For Verification
    @Test
    public void verification_method() {
     
     String time = driver.findElement(By.xpath("//div[@id='timeLeft']")).getText();
     
     if (time == "Tuesday, 28 January 2014")
     {
      System.out.print("\nText Match");
     }
     else
     {
      System.out.print("\nText does Match");
     }
    }


    
  
    
    }
    
    
