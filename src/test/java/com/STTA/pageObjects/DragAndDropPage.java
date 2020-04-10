package com.STTA.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DragAndDropPage {
	
	//First we will inilization the driver objct 
	WebDriver ldriver;
	Actions builder = new Actions(ldriver);
	
	//second we will create the constructor
	
	public DragAndDropPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	//Find objects/Elements in the Page by using Find by method
	
	
	@FindBy(xpath="//div[@id='dragdiv']")
	@CacheLookup
	WebElement draggableElement;
	
	@FindBy(xpath="//div[@id='dropdiv']")
	@CacheLookup
	WebElement droppableElement;
	
	//Create the Action Methods for above elements
	public void dragElement()
	{
		
		builder.clickAndHold(draggableElement);
	}	
	
	public void dropElement()
	{
	   builder.moveToElement(droppableElement).release(droppableElement).build();
	   builder.perform();
	   
	}
	
	
	

}
