//For dropdowns, scroll down up, javascript click, right click- All action classes
// All page related actions - declared in Action class
//Declare here  dropdown- Select by Value,Javascript click, right Click etc
// declare 5-6 methods - whichever you have done in the project

package utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	
	//Select Class Methods
	public void selectDropdownWithValue(WebElement element, String value) //In Admin pages
	{
		Select object = new Select(element);
		object.selectByValue(value);
	}
	
	public void selectDropdownWithIndex(WebElement element, int value)
	{
		Select object = new Select(element);
		object.selectByIndex(value);
	}
	
	
	
	//JavaScript Class Methods	
	public void javaScriptClickAction(WebDriver driver, String showMessageButton)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;  // creating reference for the Interface
		js.executeScript("arguments[0].click();", showMessageButton);
	}
	
	
	public void javaScriptScrollUpOrDown(WebDriver driver, int xAxis, int yAxis)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(xAxis,yAxis)", "");
	}

	
	
	//Action Class Methods	
	public void rightClickonElement(WebDriver driver, WebElement element)
	{	
		Actions action = new Actions(driver);
		action.contextClick(element).build().perform();
	}	
	
	public void mouseHoverOnElement(WebDriver driver, WebElement element)
	{
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
	}
	
	public void dragAndDropAnElement(WebDriver driver, WebElement dragMe, WebElement dropMe)
	{
		Actions action = new Actions(driver);
		action.dragAndDrop(dragMe, dropMe).build().perform();
	}
	
	
	
	//Robot Class Methods	
	public void keyBoardTabAction() throws AWTException
	{	
		//Create object for Robot class
		
		Robot robot = new Robot();
		
		//To press a key - keyPress() . Keys are inside Key event class
		//VK = Virtual Key
		
		
		robot.keyPress(KeyEvent.VK_CONTROL); //_Control = Cntrl is pressed. 
		robot.keyPress(KeyEvent.VK_T);  //_T = T is pressed
		
		//Now Keys need to be released
		
		robot.keyRelease(KeyEvent.VK_CONTROL); //_Control = Cntrl is released
		robot.keyRelease(KeyEvent.VK_T);  //_T = T is released
		
		
	}
}
