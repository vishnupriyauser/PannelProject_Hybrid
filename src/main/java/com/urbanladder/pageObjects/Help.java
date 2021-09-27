package com.urbanladder.pageObjects;

import org.openqa.selenium.WebDriver;

import com.urbanladder.reusableComponents.ReusableMethods;
import com.urbanladder.uistore.HelpUI;

public class Help extends HelpUI{

	public String help(WebDriver driver)
	{
		ReusableMethods.click(help, driver);
		String res=ReusableMethods.getText(verify, driver);
		return res;
		
	}
}
