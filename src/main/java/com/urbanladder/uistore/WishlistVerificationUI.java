package com.urbanladder.uistore;

import org.openqa.selenium.By;

public class WishlistVerificationUI {

	public static By move=By.cssSelector(".topnav_item.studyunit");//move tp study
	
	public static By click=By.xpath("//span[contains(text(),'Office Chairs')]"); //click product
	
	public static By clickproduct=By.xpath("//a[@data-url='/product-previews/venturi-study-chair?sku=FNSTCH51BK30048&src=subcat']");//click single product
	
	public static By clickwishlist=By.xpath("//span[contains(text(),'Add to Wishlist')]");//click wishlist
	
	public static By verify=By.id("shortlist-badge");//verify product added
	
	public static By tag=By.tagName("img");
	
}
