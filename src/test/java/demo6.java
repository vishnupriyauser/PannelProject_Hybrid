import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class demo6 {

	//compare
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver","c:\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
	    driver.get("https://www.urbanladder.com/");
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver,30);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-gaaction='popup.auth.close']")));
		driver.findElement(By.cssSelector("[data-gaaction='popup.auth.close']")).click();
		
		driver.findElement(By.xpath("//input[@id='search']")).sendKeys("sofa");//
		driver.findElement(By.xpath("//input[@id='search']")).sendKeys(Keys.ENTER);
		
		Actions act=new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//span[contains(text(),'Recom')]"))).build().perform();
		act.moveToElement(driver.findElement(By.cssSelector("[data-key='price_desc']"))).click().build().perform();
		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-id='98114']")));//
		WebElement frstproduct=driver.findElement(By.cssSelector("[data-id='98114']"));//
		
		act.moveToElement(frstproduct).build().perform();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Add')]")));

		act.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'Add')]"))).click().build().perform();
			
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-id='30865']")));//
		WebElement secondproduct=driver.findElement(By.cssSelector("[data-id='30865']"));//
		act.moveToElement(secondproduct).build().perform();
		
		act.moveToElement(driver.findElement(By.xpath("//*[@id=\"search-results\"]/div[3]/ul/li[2]/div/div[5]/a[1]"))).click().build().perform();

		driver.findElement(By.id("compare-cta")).click();
		
		System.out.println(driver.findElement(By.cssSelector("[class='title content']")).getText());
		
		if(driver.findElement(By.cssSelector("[class='title content']")).getText().contains("Compare L Shaped Sofa Sets"))
		{
			System.out.println("Verified");
		}
		else {
			System.out.println("Not Verified");
		}
		
		
	}

}
