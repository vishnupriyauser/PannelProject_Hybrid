package com.urbanladder.pageObjects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.urbanladder.reusableComponents.ReusableMethods;
import com.urbanladder.uistore.Googleplay_verificationUI;

public class Googleplay_verification extends Googleplay_verificationUI{

	public static Boolean verification(WebDriver driver) throws IOException
	{
		ReusableMethods.click(click, driver);
		ReusableMethods.tabswitch(driver);
		Boolean res=ReusableMethods.display(verify, driver);
		return res;
		
	}
}
