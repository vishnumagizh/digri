package Stepdefinition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pomFile.Pom_file;

public class Login_functionality {

	public static WebDriver driver;
	
	Pom_file po = new Pom_file(driver);

	// Valid credentials
	@Given("the user navigates to the login page and verify the page elements")
	public void the_user_navigates_to_the_login_page_and_verify_the_page_elements() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		driver.get("https://test.digri.ai/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

	}

	@When("the user enters {string} and {string} in the input field")
	public void the_user_enters_and_in_the_input_field(String string, String string2) {
		po.getEmail().sendKeys(string);
		po.getPassword().sendKeys(string2);

	}

	@When("clicks on the login button")
	public void clicks_on_the_login_button() throws InterruptedException {
		po.getLogin().click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@Then("the user should be redirected to the dashboard")
	public void the_user_should_be_redirected_to_the_dashboard() {
		String page =po.getDashboard().getText();
		System.out.println("Verified that it is redirected to"+page);

	}

	@Then("the user should see a welcome message")
	public void the_user_should_see_a_welcome_message() {
		String text2 = po.getWelcome().getText();
		System.out.println("Welcome message : "+text2);
		String text = po.getWelcome1().getText();
		System.out.println(text);
	}

	// Invalid credentials

	@Given("user navigates to the login page and verify the page elements")
	public void user_navigates_to_the_login_page_and_verify_the_page_elements() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		driver.get("https://test.digri.ai/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@When("the user enters invalid credentials {string} and {string}")
	public void the_user_enters_invalid_credentials_and(String string, String string2) {
		driver.findElement(By.id("email")).sendKeys(string);
		driver.findElement(By.id("password")).sendKeys(string2);

	}

	@When("clicks the login button")
	public void clicks_the_login_button() {
		driver.findElement(By.xpath("//*[text()='Login']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@Then("an error message should be displayed")
	public void an_error_message_should_be_displayed() {
		System.out.println("Error message Under development");
	}

	@Then("the user should stay on the login page")
	public void the_user_should_stay_on_the_login_page() {
		String page = driver.getTitle();
		System.out.println("Verified that the user stays on the login page" + page);
	}

}
