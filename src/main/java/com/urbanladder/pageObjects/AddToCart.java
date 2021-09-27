package com.urbanladder.pageObjects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.urbanladder.reusableComponents.ReusableMethods;
import com.urbanladder.uistore.AddToCartUI;

public class AddToCart extends AddToCartUI{

	public static String addbooks(WebDriver driver) throws IOException
	{
		ReusableMethods.click(bookshelf,driver);
		ReusableMethods.click(booksclick,driver);
		ReusableMethods.tabswitch(driver);
		ReusableMethods.click(addtocart, driver);
		String res=ReusableMethods.getText(verify,driver);
		return res;
	}
}
