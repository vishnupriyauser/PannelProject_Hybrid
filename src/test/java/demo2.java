import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class demo2 {

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
            
	        WebElement move=driver.findElement(By.cssSelector(".topnav_item.saleunit"));	       
	        actions.moveToElement(move).build().perform();	
	        Thread.sleep(1000);
	        WebElement move1=driver.findElement(By.xpath("//a[@href='/products-at-40-off-dow?src=g_topnav_sale_promotions_products-at-40-off']"));
	        actions.moveToElement(move1).click().build().perform();
	        
	        //driver.findElement(By.xpath("//a[@href='/products-at-40-off-dow?src=g_topnav_sale_promotions_products-at-40-off']")).click();
	        System.out.println("No Of products Present in the url: "+driver.findElements(By.tagName("img")).size());//NoOfproducts
	
	       
	        
	       
	}
}
