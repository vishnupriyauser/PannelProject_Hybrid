package com.urbanladder.uistore;

import org.openqa.selenium.By;

public class LoginUI {

	
	  public static By popup=By.cssSelector("a[data-gaaction='popup.auth.close']");//close popup
	  
	  public static By movetologin=By.cssSelector(".header__topBarIconList_profile-icon");//move cursor to login icon
	  
	  public static By clicklogin=By.cssSelector(".login-link.authentication_popup");//click
	 
	  public static By username=By.xpath("//input[@class='email required input_authentication']");//enter username
	  
	  public static By pass=By.xpath("//input[@placeholder='Password']");//enter password
	  
	  public static By log_in=By.xpath("//a[@data-gaaction='show_login']");
	 
	  public static By submit=By.id("ul_site_login");
	  
	  
}
