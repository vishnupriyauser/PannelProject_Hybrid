package com.urbanladder.pageObjects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.urbanladder.reusableComponents.ReusableMethods;
import com.urbanladder.uistore.Verify_EMI_PageUI;

public class Verify_EMI_Page extends Verify_EMI_PageUI{

	public static boolean verification(WebDriver driver) throws IOException
	{	
		ReusableMethods.click(clickproducts, driver);
		ReusableMethods.click(product, driver);
		ReusableMethods.tabswitch(driver);
		ReusableMethods.click(knowmore, driver);
		boolean res=ReusableMethods.display(verify, driver);
		return res;
	}
}
