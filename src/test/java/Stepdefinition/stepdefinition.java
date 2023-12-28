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

public class stepdefinition {
	
	 WebDriver driver;

	@Given("Launch the application on your browser")
	public void launchTheApplicationOnYourBrowser() {

        WebDriverManager.chromedriver().setup();
    	ChromeOptions options = new ChromeOptions();
    	options.addArguments("--remote-allow-origins=*");
    	 driver = new ChromeDriver(options);
    	 
        driver.manage().window().maximize();
        
        
	driver.get("https://test.digri.ai/");
	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	@When("user enters the {string} in the username field")
	public void userEntersTheInTheUsernameField(String string) {
		driver.findElement(By.id("email")).sendKeys("testadmin1@digri.in");
		
		
		
		  
	}
	@When("user enters the {string} in the password field and clicks on the login button")
	public void userEntersTheInThePasswordFieldAndClicksOnTheLoginButton(String string) {
		driver.findElement(By.id("password")).sendKeys("Abcd@1234");
		driver.findElement(By.xpath("//*[text()='Login']")).click();
	

		   
	}
	@When("user navigates to the settings page")
	public void userNavigatesToTheSettingsPage() throws InterruptedException {
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Thread.sleep(10000);
		WebElement element = driver.findElement(By.xpath("//*[text()='Settings']"));
		Actions ac = new Actions(driver);
		ac.moveToElement(element).perform();
		element.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		
	}
	@When("user uploads the students data in excel format")
	public void userUploadsTheStudentsDataInExcelFormat() {
		driver.findElement(By.id("fileInput"))
		.sendKeys("/Users/gmx/Downloads/mailslurp.xlsx");
		
	
		 
	}
	@Then("user clicks on submit botton to upload the file successfully")
	public void userClicksOnSubmitBottonToUploadTheFileSuccessfully() {
		driver.findElement(By.xpath("(//*[text()='Upload File'])[2]")).click();
	}




}
