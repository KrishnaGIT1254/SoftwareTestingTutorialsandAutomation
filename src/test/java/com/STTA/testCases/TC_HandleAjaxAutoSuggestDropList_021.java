package com.STTA.testCases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class TC_HandleAjaxAutoSuggestDropList_021 extends BaseClass{

	
	@Test(dataProvider="search-data")
	 public void Search_Test(String Search){ 
		
		 driver.get("http://www.google.com");
	   driver.findElement(By.xpath("//input[@id='fakebox-input']")).clear();
	   driver.findElement(By.xpath("//input[@id='fakebox-input']")).sendKeys(Search);
	   int i=1;
	   int j=i+1;
	   try{
	    //for loop will run till the NoSuchElementException exception.
	    for(i=1; i<j;i++)
	      { 
	     //Value of variable i Is used for creating xpath of drop list's different elements.
	     String suggestion = driver.findElement(By.xpath("//*[@id='gsr']/table/tbody/tr[1]/td[2]/table/tbody/tr["+i+"]/td/div/table/tbody/tr/td[1]/span")).getText();
	     System.out.println(suggestion);
	     j++;     
	      } 
	    }catch(Exception e){//Catch block will catch and handle the exception.
	     System.out.println("***Please search for another word***"); 
	     System.out.println();
	    }  
	  }
}
