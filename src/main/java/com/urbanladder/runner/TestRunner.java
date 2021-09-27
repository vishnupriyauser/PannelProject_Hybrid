package com.urbanladder.runner;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.urbanladder.pageObjects.AddToCart;
import com.urbanladder.pageObjects.Authorverification;
import com.urbanladder.pageObjects.CompareProducts;
import com.urbanladder.pageObjects.Googleplay_verification;
import com.urbanladder.pageObjects.Help;
import com.urbanladder.pageObjects.LoginPage;
import com.urbanladder.pageObjects.ProductsCount;
import com.urbanladder.pageObjects.SearchProduct;
import com.urbanladder.pageObjects.Store_Verification;
import com.urbanladder.pageObjects.Verify_EMI_Page;
import com.urbanladder.pageObjects.WishlistVerification;
import com.urbanladder.reusableComponents.ReusableDrivers;
import com.urbanladder.utilities.DataDriven;
import com.urbanladder.utilities.PropertyFileReader;
public class TestRunner extends ReusableDrivers{
	
	private static Logger log=LogManager.getLogger(TestRunner.class.getName()); 
	
	@BeforeMethod
	public void openbrowser() throws IOException
	{
		try
		{
		ReusableDrivers.initializedriver();
		driver.get(PropertyFileReader.loadFile().getProperty("url"));
		
    	LoginPage.loginpage(driver,PropertyFileReader.loadFile().getProperty("username"), PropertyFileReader.loadFile().getProperty("password")); 
    	log.info("successfull logged in");
		}
    	catch(Exception e)
    	{
    		ReusableDrivers.captureScreen("cannot able to open browser");
    	}
	}

@Test(priority=0)
	public void count() throws IOException
	{	
		
    	try
    	{
    	ProductsCount p=new ProductsCount();
    	p.products(driver);	
    	log.info("number of products in a page passed");
    	}
    	catch(Exception e)
    	{
    		ReusableDrivers.captureScreen("failure to count products");
    	}
	}	
	
	 @Test(priority=1)
	  	public void addcart() throws IOException
   	{	
	
    	 try
    	 {
    	         String result=AddToCart.addbooks(driver);
    		    	
    	    	 if(result.equalsIgnoreCase(PropertyFileReader.loadFile().getProperty("cart")))
    			        {
    	
    	    		        log.info("product added successfull");
    			        }
    			        else
    			        {
    			        	//System.out.println("product not in cart");
    			        	log.error("error while adding cart");
    			        	ReusableDrivers.captureScreen("failure to add cart");
    			        }
    	    	
    	 }
     	catch(Exception e)
     	{
     		ReusableDrivers.captureScreen("failure to add products");
     	}
   	} 	 
	 
	@Test(priority=2)
	public void EMIverification() throws IOException
	{	

		//driver.manage().timeouts().implicitlyWait(Integer.parseInt(PropertyFileReader.loadFile().getProperty("wait")), TimeUnit.SECONDS);
		try {
    	//Verify_EMI_Page EMI=new Verify_EMI_Page();
    	boolean result=Verify_EMI_Page.verification(driver);	
    	Assert.assertTrue(result);//to verify displayed or not
    	 log.info("EMI verified successfull");
	}	
		catch(Exception e)
     	{
     		ReusableDrivers.captureScreen("EMIverification");
     	}
	}
	
	@Test(priority=3)
	public void StoreVerification() throws IOException
	{	
		 //Store_Verification store=new Store_Verification();
		//driver.manage().timeouts().implicitlyWait(Integer.parseInt(PropertyFileReader.loadFile().getProperty("wait")), TimeUnit.SECONDS);
		  try
		  {
	     String result= Store_Verification.store_verification(driver);
	     Assert.assertEquals(result,PropertyFileReader.loadFile().getProperty("store"));
	     log.info("store verified successfull");
		  }
	     catch(Exception e)
	     	{
	     		ReusableDrivers.captureScreen("StoreVerification");
	     	}
	}		
	
	@Test(dataProvider="getdata",priority=4)
	public void Search_products(String data) throws IOException
	{	
		//SearchProduct searching=new SearchProduct();	  
	    // searching.searchproducts(driver);
	    // searching.search(driver,data);
	    // searching.go(driver);
		//driver.manage().timeouts().implicitlyWait(Integer.parseInt(PropertyFileReader.loadFile().getProperty("wait")), TimeUnit.SECONDS);
		try
		{
		 SearchProduct.search(driver, data);
		 log.info("product searched successfull");
		}
		catch(Exception e)
     	{
     		ReusableDrivers.captureScreen("Search_products");
     	}
	}	
	
	@DataProvider
	public Object[][] getdata()
	{
		//array size from 0 but we have to give like below only while declaring array is size is 1
		Object[][] data=null;
		try
		{
			data=DataDriven.readExcel();
		}
		catch(Exception e)
		{
			System.out.println("cannot reach excel");
		}
		return data;
	}
	
	@Test(priority=5)
	public void GoogleVerification() throws IOException
	{	
		//driver.manage().timeouts().implicitlyWait(Integer.parseInt(PropertyFileReader.loadFile().getProperty("wait")), TimeUnit.SECONDS);
		//Googleplay_verification play=new Googleplay_verification();
		try
		{
	     Boolean result=Googleplay_verification.verification(driver);
	     Assert.assertTrue(result);//to verify displayed or not
	     log.info("playstore verified successfull");
		}
		catch(Exception e)
     	{
     		ReusableDrivers.captureScreen("GoogleVerification");
     	}
	}	
		
	@Test(priority=6)
	public void wishlistVerification() throws IOException, InterruptedException
	{	
		//driver.manage().timeouts().implicitlyWait(Integer.parseInt(PropertyFileReader.loadFile().getProperty("wait")), TimeUnit.SECONDS);
		//WishlistVerification wish=new WishlistVerification();
		//add to wishlist not clicking
		try
		{
	     Boolean result=WishlistVerification.wishlist(driver);
	     Assert.assertTrue(result);//to verify displayed or not
	     log.info("wishlist verified successfull");
		}
		catch(Exception e)
     	{
     		ReusableDrivers.captureScreen("wishlistVerification");
     	}
	}
	
	@Test(priority=7)
	public void helpverification() throws IOException, InterruptedException
	{	
		
		try
		{
		 Help h=new Help();
	     String result= h.help(driver);
	     Assert.assertEquals(result,PropertyFileReader.loadFile().getProperty("help") );
	     log.info("help verified successfull");
		}
	     catch(Exception e)
	     	{
	     		ReusableDrivers.captureScreen("helpverification");
	     	}
	}
	
	
	@Test(priority=8)
	public void compareproducts() throws IOException
	{
		
		//CompareProducts com=new CompareProducts();
		try
		{
		CompareProducts.search(driver,PropertyFileReader.loadFile().getProperty("product") );
		CompareProducts.compare(driver);
		CompareProducts.verify(driver);
		 log.info("products compared done");
		}
		
		catch(Exception e)
     	{
     		ReusableDrivers.captureScreen("compareproducts");
     	}
		
	}
	
	@Test(priority=9)
	public void author() throws IOException
	{
		
		//Authorverification a=new Authorverification();
		try
		{
		Authorverification.stories(driver);
		Authorverification.verification(driver,PropertyFileReader.loadFile().getProperty("author"));
		 log.info("author verified successfull");
		}
		catch(Exception e)
     	{
     		ReusableDrivers.captureScreen("author");
     	}
	}

	
	@AfterMethod
	public void closebrowser()
	{
		driver.quit();
		driver=null; //to avoid increase of memory while running
	}	
	

}

