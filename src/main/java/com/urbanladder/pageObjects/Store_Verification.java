package com.urbanladder.pageObjects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.urbanladder.reusableComponents.ReusableMethods;
import com.urbanladder.uistore.Store_VerificationUI;

public class Store_Verification extends Store_VerificationUI{

	public static String store_verification(WebDriver driver) throws IOException
	{ 
		ReusableMethods.click(stores, driver);
		ReusableMethods.click(viewproducts, driver);
		
		String res=ReusableMethods.getText(verify, driver);
		return res;
	}
	
}
