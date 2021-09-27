package com.urbanladder.pageObjects;

import org.openqa.selenium.WebDriver;

import com.urbanladder.reusableComponents.ReusableMethods;
import com.urbanladder.uistore.SearchProductUI;


public class SearchProduct {

	/*public void searchproducts(WebDriver driver)
	{
	
		ReusableMethods.click(click, driver);
		
	}
	public void search(WebDriver driver,String name)
	{
		ReusableMethods.login(click, driver, name);
	}
	
	public void go(WebDriver driver)
	{
		ReusableMethods.click(search, driver);
	}
	*/
	public static void search(WebDriver driver,String name) {
		//import from search
		ReusableMethods.click(SearchProductUI.search, driver);
		ReusableMethods.login(SearchProductUI.search, driver,name);
		ReusableMethods.click(SearchProductUI.click, driver);
    	
    }
}
