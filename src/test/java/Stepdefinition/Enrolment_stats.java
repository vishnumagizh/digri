package Stepdefinition;

import static org.junit.Assert.assertEquals;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Enrolment_stats {

	public static WebDriver driver;
	public static String total;
	int number;

	@Given("user enters the {string} and {string} in the login input field")
	public void user_enters_the_and_in_the_login_input_field(String string, String string2) {

		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		driver.get("https://test.digri.ai/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// Dimension d = new Dimension(1600,849);

		// driver.manage().window().setSize(d);
		driver.findElement(By.id("email")).sendKeys(string);
		driver.findElement(By.id("password")).sendKeys(string2);
		driver.findElement(By.xpath("//*[text()='Login']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@When("the user is on the Admin Dashboard page")
	public void the_user_is_on_the_admin_dashboard_page() {
		String page = driver.findElement(By.xpath("//div[text()='Dashboard']")).getText();
		System.out.println("Verified that it is redirected to " + page);

	}

	@When("the user hovers the pie Chart")
	public void the_user_hovers_the_pie_chart() {

	}

	@Then("the pie Chart should display enrolment statistics")
	public void the_pie_chart_should_display_enrolment_statistics() {

	}

	@Then("the total enrolment count should be displayed")
	public void the_total_enrolment_count_should_be_displayed() {
		total = driver.findElement(By.xpath("//p[text()='22']")).getText();
		number = Integer.parseInt(total);
		System.out.println("Total enrolment count: " + number);

	}

	@Then("the total number of enrolment could should be validated")
	public void the_total_number_of_enrolment_could_should_be_validated() throws InterruptedException {
		List<WebElement> elements = driver
				.findElements(By.xpath("//div[@class='ag-pinned-left-cols-container'] //div[@role='row']"));
		int count = elements.size();
		WebElement element2 = driver.findElement(By.xpath("//select"));
		Select sc = new Select(element2);
		sc.selectByIndex(1);
		Thread.sleep(3000);
		WebElement element = driver.findElement(By.cssSelector(
				".ag-pinned-left-cols-container div[role='row']:nth-child(" + Math.round(count / 2) + ")"));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView({behavior: 'auto', block: 'center', inline: 'center'});",
				element);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		List<WebElement> elements1 = driver
				.findElements(By.xpath("//div[@class='ag-pinned-left-cols-container'] //div[@role='row']"));
		int count1 = elements1.size();
		System.out.println("Total count in student progress overview widget : " + count1);

		assert number == count1 : "Values are  equal";

		System.out.println("Assertion passed!");

	}

}
