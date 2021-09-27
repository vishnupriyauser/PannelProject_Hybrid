import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class demo4 {

	
    //verfify emi is displayed or not
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		    System.setProperty("webdriver.chrome.driver","c:\\chromedriver.exe");
	        WebDriver driver=new ChromeDriver();
		    driver.get("https://www.urbanladder.com/");
	        driver.manage().window().maximize();
	        
	        Thread.sleep(10000);
	        driver.findElement(By.cssSelector("a[data-gaaction='popup.auth.close']")).click();
	        Thread.sleep(10000);
	        
	        Actions actions = new Actions(driver);     	
	        
            driver.findElement(By.cssSelector("a[href='https://www.urbanladder.com/cupboards?src=explore_categories\']")).click();
            driver.findElement(By.xpath("//img[@src='https://www.ulcdn.net/images/products/314045/product/Baltoro_Wardrobe_White_LP.jpg?1612598408']")).click();
          
	      
	        Set<String> b=driver.getWindowHandles();
			Iterator<String> c=b.iterator();
			String parent =c.next();
			String Child =c.next();
			driver.switchTo().window(Child);
		
	        driver.findElement(By.className("applicable-emis-cta")).click();      
	        Assert.assertTrue( driver.findElement(By.cssSelector(".reveal-content")).isDisplayed());//true means no error will occur in console	        
	}

}
