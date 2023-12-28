package Stepdefinition;

import java.time.Duration;
import java.util.List;
import java.util.Map;

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

public class data_with_header {

	WebDriver driver;

	@Given("Launch the application in your browser")
	public void launch_the_application_in_your_browser() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);

		driver.manage().window().maximize();

		driver.get("https://test.digri.ai/");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@When("user enter the username and password and clicks login button")
	public void user_enter_the_username_and_password_and_clicks_login_button(
			io.cucumber.datatable.DataTable dataTable) {
		List<Map<String, String>> keyvaluepair = dataTable.asMaps(String.class, String.class);
		String username = keyvaluepair.get(0).get("username");
		driver.findElement(By.id("email")).sendKeys(username);
		String password = keyvaluepair.get(0).get("password");
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.xpath("//*[text()='Login']")).click();
	}

	@When("user navigate to the settings section")
	public void user_navigate_to_the_settings_section() throws InterruptedException {
		Thread.sleep(10000);
		WebElement element = driver.findElement(By.xpath("//*[text()='Settings']"));
		Actions ac = new Actions(driver);
		ac.moveToElement(element).perform();
		element.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

	}

	@When("user uploads the students data in excel")
	public void user_uploads_the_students_data_in_excel() {
		driver.findElement(By.id("fileInput")).sendKeys("C:\\Users\\vishnupriya\\Downloads\\vishnu_digri.xlsx");

	}

	@Then("user clicks on submit botton to upload the file")
	public void user_clicks_on_submit_botton_to_upload_the_file() {
		driver.findElement(By.xpath("(//*[text()='Upload File'])[2]")).click();

	}

}
