package com.urbanladder.reusableComponents;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import com.urbanladder.utilities.PropertyFileReader;

public class ReusableMethods {
	
	public static void loadURL(WebDriver driver) throws IOException {
		
		 driver.get(PropertyFileReader.loadFile().getProperty("url"));
		
		 driver.manage().window().maximize();
	     
	}

   public static void time(WebDriver driver) throws IOException {
		
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(PropertyFileReader.loadFile().getProperty("wait")), TimeUnit.SECONDS);     
	}
		
	public static boolean action(By selector, WebDriver driver)
	   {
		   Actions act=new Actions(driver);
		   try
		   {
		   act.moveToElement(driver.findElement(selector)).build().perform();
		   return true;
		   }
		   catch(Exception e)
		   {
			   System.out.println(String.format("Element %s doesnt exist", selector));
			   return false;
		   }    
	   }
	
	 public static boolean actionclick(By selector, WebDriver driver)
	   {
		   Actions act=new Actions(driver);
		   try
		   {
		   act.moveToElement(driver.findElement(selector)).click().build().perform();
		   return true;
		   }
		   catch(Exception e)
		   {
			   System.out.println(String.format("Element %s doesnt exist", selector));
			   return false;
		   }    
	   }
	
	
	public static void click(By selector,WebDriver driver)
    {
		try
		{
    	    driver.findElement(selector).click();
		}
		catch(Exception e)
		{
			System.out.println(String.format("Element %s doesnt exist", selector));
			
		}		
    }
	
	public static void login(By selector,WebDriver driver,String keys)
	{
		try
		{  
    	    driver.findElement(selector).sendKeys(keys);
    	    
		}
		catch(Exception e)
		{
			 System.out.println(String.format("Element %s doesnt exist", selector));
		}	
	}
	
	public static void count(WebDriver driver)
	{
		try
		{ 	
			System.out.println(driver.findElements(By.tagName("img")).size());//use log here by , tagname use selector
		}
		catch(Exception e)
		{
			 System.out.println("cannot count products");
		}	
	}
	
	public static void tabswitch(WebDriver driver)
	{
		try
		{ 	
			   // time(driver);
			    Set<String> b=driver.getWindowHandles();
				Iterator<String> c=b.iterator();
				String parent =c.next();
				String Child =c.next();
				driver.switchTo().window(Child);		
				
		}
		catch(Exception e)
		{
			 System.out.println("cannot switch ");
		}
	}
	

	public static String getText(By selector,WebDriver driver)
	{
		try
		{ 	
			 String result=driver.findElement(selector).getText();
		     return result;	
				
		}
		catch(Exception e)
		{
			 System.out.println(String.format("Element %s doesnt exist", selector));
		}
		return null;
	}
	
	public static boolean display(By selector,WebDriver driver)
	{
		try
		{ 	
			driver.findElement(selector).isDisplayed();
			return true;
		}
		catch(Exception e)
		{
			 System.out.println(String.format("Element %s doesnt exist", selector));
			 return false;
		}
	}
	
	public static void clear(By selector,WebDriver driver)
    {
   	   try
   	    { 
   		 driver.findElement(selector).clear();
   	     }
    	
    	catch(Exception e)
		 { 		
    		 System.out.println(String.format("Element %s doesnt exist", selector));	
		 }
    }
	
}
