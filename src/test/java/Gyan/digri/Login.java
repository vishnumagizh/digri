package Gyan.digri;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import java.awt.Toolkit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Login {
	
	
	public static void positive_testcase() {
		
		WebDriverManager.chromedriver().setup();
    	ChromeOptions options = new ChromeOptions();
    	options.addArguments("--remote-allow-origins=*");
    	 WebDriver driver = new ChromeDriver(options);
    	 
    	 driver.get("https://test.digri.ai/");
    	 System.out.println(driver.manage().window().getSize());

    	 Dimension d = new Dimension(1600,849);

    	 driver.manage().window().setSize(d);

    	 System.out.println(driver.manage().window().getSize());
    	 driver.findElement(By.xpath("//a[text()='Forgot Password?']")).click();
    	 driver.findElement(By.id("email")).sendKeys("mentor@digri.in");
    	 driver.findElement(By.xpath("/html/body/main/div/div/div[2]/div/div[1]/div/div[1]/div/div/div[1]/form/button")).click();
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    positive_testcase();
	}

}
