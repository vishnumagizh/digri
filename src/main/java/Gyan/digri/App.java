package Gyan.digri;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class App 
{
    public static void main( String[] args )
    {
    	 
	        WebDriverManager.chromedriver().setup();
	    	ChromeOptions options = new ChromeOptions();
	    	options.addArguments("--remote-allow-origins=*");
	    	WebDriver driver = new ChromeDriver(options);
	    	 
	        driver.manage().window().maximize();
	        
	        
		driver.get("https://test.digri.ai/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
	
		driver.findElement(By.id("email")).sendKeys("testadmin1@digri.in");
		
			
	
		driver.findElement(By.id("password")).sendKeys("Abcd@1234");
		driver.findElement(By.xpath("//*[text()='Login']")).click();
	

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebElement element = driver.findElement(By.xpath("//*[text()='Settings']"));
		Actions ac = new Actions(driver);
		ac.moveToElement(element).perform();
		element.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		driver.findElement(By.id("fileInput"))
		.sendKeys("C:\\Users\\vishnupriya\\Downloads\\vishnu_digri.xlsx");
		
	
		driver.findElement(By.xpath("(//*[text()='Upload File'])[2]")).click();
    }
}






