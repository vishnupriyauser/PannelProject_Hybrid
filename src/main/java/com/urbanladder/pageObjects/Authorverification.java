package com.urbanladder.pageObjects;

import org.openqa.selenium.WebDriver;

import com.urbanladder.reusableComponents.ReusableMethods;
import com.urbanladder.uistore.AuthorverificationUI;

public class Authorverification extends AuthorverificationUI{

	public static void stories(WebDriver driver)
	{
		ReusableMethods.click(customer, driver);
		
	}
	
	public static String verification(WebDriver driver,String name)
	{
		String res=ReusableMethods.getText(verify, driver);	
		return res;
	}
	
}
