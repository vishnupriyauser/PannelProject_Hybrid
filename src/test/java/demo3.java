import java.util.Iterator;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class demo3 {

	//add to cart
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		    System.setProperty("webdriver.chrome.driver","c:\\chromedriver.exe");
	        WebDriver driver=new ChromeDriver();
		    driver.get("https://www.urbanladder.com/");
	        driver.manage().window().maximize();
	        
	        Thread.sleep(10000);
	        driver.findElement(By.cssSelector("a[data-gaaction='popup.auth.close']")).click();
	        Thread.sleep(10000);
	        //
            Actions actions = new Actions(driver);     	
	        
            driver.findElement(By.cssSelector("a[href='/bookshelf?src=explore_categories']")).click();
	        driver.findElement(By.xpath("//a[@data-url='/product-previews/alberto-bookshelf?sku=FNSGBR11TK30086&src=subcat']")).click();  
	        
	        Set<String> b=driver.getWindowHandles();
			Iterator<String> c=b.iterator();
			String parent =c.next();
			String Child =c.next();
			driver.switchTo().window(Child);
			
	        driver.findElement(By.cssSelector("button[data-event='add_to_cart']")).click();
	        
	        String result=driver.findElement(By.id("checkout-link")).getText();
	        
	        // Assert.assertArrayEquals(expecteds, actuals);
	        
	       if(result.equalsIgnoreCase("checkout"))
	        {
	        	System.out.println("verfied");
	        }
	        else
	        {
	        	System.out.println("product not in cart");
	        }
	}

}
