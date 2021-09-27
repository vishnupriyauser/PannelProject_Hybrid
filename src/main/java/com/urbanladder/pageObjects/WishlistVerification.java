package com.urbanladder.pageObjects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.urbanladder.reusableComponents.ReusableMethods;
import com.urbanladder.uistore.WishlistVerificationUI;

public class WishlistVerification extends WishlistVerificationUI{

	public static Boolean wishlist(WebDriver driver) throws IOException, InterruptedException
	{
		ReusableMethods.action(move, driver);
		ReusableMethods.actionclick(click, driver);
		ReusableMethods.click(clickproduct, driver);
		ReusableMethods.tabswitch(driver);
		
		ReusableMethods.click(clickwishlist, driver);
		ReusableMethods.click(verify, driver);
		return ReusableMethods.display(tag, driver);
		
	}	
}
