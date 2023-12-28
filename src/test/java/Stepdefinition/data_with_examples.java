package Stepdefinition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class data_with_examples {
	
	WebDriver driver;
	@Given("Launch the application")
	public void launch_the_application() {
	
			 WebDriverManager.chromedriver().setup();
		    	ChromeOptions options = new ChromeOptions();
		    	options.addArguments("--remote-allow-origins=*");
		    	 driver = new ChromeDriver(options);
		    	 
		        driver.manage().window().maximize();
		        
		        
			driver.get("https://test.digri.ai/");
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	@When("user enters {string} in the username field")
	public void user_enters_in_the_username_field(String string) {
		driver.findElement(By.id("email")).sendKeys(string);

	}
	@When("user enters {string} in the password field and click login button")
	public void user_enters_in_the_password_field_and_click_login_button(String string) {
		driver.findElement(By.id("password")).sendKeys(string);
		driver.findElement(By.xpath("//*[text()='Login']")).click();
	

	}
	@When("user navigates to the settings page and uploads the students data")
	public void user_navigates_to_the_settings_page_and_uploads_the_students_data() throws InterruptedException {
		Thread.sleep(10000);
		WebElement element = driver.findElement(By.xpath("//*[text()='Settings']"));
		Actions ac = new Actions(driver);
		ac.moveToElement(element).perform();
		element.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("fileInput"))
		.sendKeys("/Users/gmx/Downloads/VISHNU PRIYA CV (2).docx");
		

	}
	@Then("user clicks on submit botton to upload the students data")
	public void user_clicks_on_submit_botton_to_upload_the_students_data() {
		driver.findElement(By.xpath("(//*[text()='Upload File'])[2]")).click();
	    
	}

}
