package com.urbanladder.pageObjects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.urbanladder.reusableComponents.ReusableMethods;
import com.urbanladder.uistore.ProductsCountUI;

public class ProductsCount extends ProductsCountUI{
	
	public void products(WebDriver driver) throws IOException
	{
		
		ReusableMethods.action(item, driver);
		
		ReusableMethods.click(clickproduct, driver);
	
		ReusableMethods.count(driver);
		
	}
}
