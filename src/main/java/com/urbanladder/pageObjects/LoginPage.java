package com.urbanladder.pageObjects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.urbanladder.reusableComponents.ReusableDrivers;
import com.urbanladder.reusableComponents.ReusableMethods;
import com.urbanladder.uistore.LoginUI;

public class LoginPage extends LoginUI{
	
	
	public static void loginpage(WebDriver driver,String name,String password) throws IOException
	{
	
		
		ReusableMethods.click(log_in, driver);
		//ReusableMethods.click(username, driver);
	    ReusableMethods.login(username, driver,name);
		ReusableMethods.click(pass, driver);
		ReusableMethods.login(pass, driver,password);
		ReusableMethods.click(submit,driver);
		
	}
	
}
