

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;
public class demo8 {

	//add product to wish list--->click wishlist--->verify
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		  System.setProperty("webdriver.chrome.driver","c:\\chromedriver.exe");
	        WebDriver driver=new ChromeDriver();
		    driver.get("https://www.urbanladder.com/");
	        driver.manage().window().maximize();
	        
	        WebDriverWait d=new WebDriverWait(driver,10000);
			  
	        d.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[data-gaaction='popup.auth.close']"))).click();
	        
	        Actions action=new Actions(driver);
	        Thread.sleep(1000);
	        ///////////
	        WebElement move=driver.findElement(By.cssSelector(".topnav_item.studyunit"));//move to study
	        
	        action.moveToElement(move).build().perform();
	        Thread.sleep(1000);
	        WebElement move1=driver.findElement(By.xpath("//a[span='Office Chairs']")); //click products
	        action.moveToElement(move1).click().build().perform();
	        Thread.sleep(1000);
	
	        driver.findElement(By.xpath("//a[@data-url='/product-previews/venturi-study-chair?sku=FNSTCH51BK30048&src=subcat']")).click();
	        Thread.sleep(1000);
	        Set<String> b=driver.getWindowHandles();//moving to next tab
			Iterator<String> c=b.iterator();
			String parent =c.next();
			String Child =c.next();
			driver.switchTo().window(Child);
			Thread.sleep(1000);
			
	        driver.findElement(By.cssSelector(".add-to-wishlist.text-center.wishproduct.wishblock")).click();
	        
	       //login click
	        
	        driver.findElement(By.id("shortlist-badge")).click();//click wishlist
	        
	       System.out.println(driver.findElements(By.tagName("img")));     //verify
	}

}
