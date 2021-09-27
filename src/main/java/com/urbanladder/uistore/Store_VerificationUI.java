package com.urbanladder.uistore;

import org.openqa.selenium.By;

public class Store_VerificationUI {

	public static By stores=By.xpath("//a[@href='../../furniture-stores?src=header']");
	
	public static By viewproducts=By.xpath("//h3[contains(text(),'Domlur')]");
	
	public static By verify=By.cssSelector(".no-padding.text-left.address-name");
}
