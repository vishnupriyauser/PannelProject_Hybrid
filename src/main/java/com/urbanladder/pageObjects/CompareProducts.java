package com.urbanladder.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.urbanladder.reusableComponents.ReusableMethods;
import com.urbanladder.uistore.CompareProductsUI;
import com.urbanladder.uistore.SearchProductUI;

public class CompareProducts extends CompareProductsUI{

	public static void search(WebDriver driver,String product) {
		
		ReusableMethods.click(SearchProductUI.search, driver);
		ReusableMethods.login(SearchProductUI.search, driver,product);
		ReusableMethods.click(SearchProductUI.click, driver);
    	
    }

public static void compare(WebDriver driver)
{
	ReusableMethods.action(recom_mouseover, driver);
	ReusableMethods.actionclick(low_to_high, driver);
	WebDriverWait wait = new WebDriverWait(driver,30);
	wait.until(ExpectedConditions.visibilityOfElementLocated(firstproduct));
	ReusableMethods.action(firstproduct, driver);
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(firstproduct));
	ReusableMethods.click(frstcompare, driver);
	wait.until(ExpectedConditions.visibilityOfElementLocated(secondproduct));
	ReusableMethods.action(secondproduct, driver);
	ReusableMethods.actionclick(secondcompare, driver);
	
	ReusableMethods.click(compare_button, driver);
	
}

public static boolean verify(WebDriver driver) {
	Boolean text=ReusableMethods.display(title, driver);
	return text;
	
}
}
