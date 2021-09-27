package com.urbanladder.uistore;

import org.openqa.selenium.By;

public class AddToCartUI {

	public static By bookshelf=By.xpath("//h4[contains(text(),'Bookshelves')]");
	
	public static By booksclick= By.xpath("//span[contains(text(),'Alberto Bookshelf/Display Unit')]");  
	
	public static By addtocart=By.xpath("//button[contains(text(),'Add to Cart')]");
	
	public static By verify=By.id("checkout-link");
}
