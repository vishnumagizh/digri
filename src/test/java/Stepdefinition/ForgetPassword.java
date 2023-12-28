package Stepdefinition;

import java.awt.Toolkit;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.mailslurp.apis.InboxControllerApi;
import com.mailslurp.apis.WaitForControllerApi;
import com.mailslurp.clients.ApiClient;
import com.mailslurp.clients.ApiException;
import com.mailslurp.clients.Configuration;
import com.mailslurp.models.Email;
import com.mailslurp.models.InboxDto;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient;
import java.util.concurrent.TimeUnit;

public class ForgetPassword {
	public static WebDriver driver;
	public static Long TIMEOUT_MILLIS = 80000L;
	public static ApiClient mailslurpClient;
	public static InboxDto inbox;
	public static Email mail;
	
	//@Before
	public void browserlauncher() throws ApiException  {
		
		// setup mailslurp
		
		mailslurpClient = Configuration.getDefaultApiClient();
		mailslurpClient.setApiKey("a70d793d8d91771222f5f6233a927d66f58f0e0eaa6a2861f8f62f74679cc08d");
		mailslurpClient.setConnectTimeout(TIMEOUT_MILLIS.intValue());
		
		
		
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		driver.get("https://test.digri.ai/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Dimension d = new Dimension(1600,849);

   	    driver.manage().window().setSize(d);
   	 InboxControllerApi inboxControllerApi = new InboxControllerApi(mailslurpClient);
		inbox = inboxControllerApi.createInboxWithDefaults();
		mailslurpClient.setConnectTimeout(TIMEOUT_MILLIS.intValue());
		mailslurpClient.setWriteTimeout(TIMEOUT_MILLIS.intValue());
		mailslurpClient.setReadTimeout(TIMEOUT_MILLIS.intValue());
		
	 
	}

	@Given("the user is on the login page")
	public void the_user_is_on_the_login_page() {
      
	  System.out.println(driver.findElement(By.xpath("/html/body/main/div/div/div[2]/div/div[1]/div/div[1]/h1")).getText());
	  System.out.println("Verified that the user is in the login page");
	}
	@When("the user clicks on the Forgot Password? link")
	public void the_user_clicks_on_the_forgot_password_link() {
		
		driver.findElement(By.xpath("//a[text()='Forgot Password?']")).click();
		

	}
	@Then("the user should be redirected to the password recovery page")
	public void the_user_should_be_redirected_to_the_password_recovery_page() {
		
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
	 String resetpage = driver.findElement(By.xpath("/html/body/main/div/div/div[2]/div/div[1]/div/div[1]/div/div/h1")).getText();
	 System.out.println("Verified that the user is redirected to reset password page: "  +resetpage);
	}
	
	@When("the user enters their registered email")
	public void the_user_enters_their_registered_email() {
		
	   driver.findElement(By.id("email")).sendKeys("");
	}
	@Then("clicks on the Continue button")
	public void clicks_on_the_continue_button() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	    driver.findElement(By.xpath("/html/body/main/div/div/div[2]/div/div[1]/div/div[1]/div/div/div[1]/form/button")).click();
	    
	}
	@Then("the user should see a confirmation message with OTP")
	public void the_user_should_see_a_confirmation_message_with_otp() throws ApiException {
		
		
		
		        WaitForControllerApi waitForControllerApi = new WaitForControllerApi(mailslurpClient);
		   
				mail = waitForControllerApi.waitForLatestEmail(inbox.getId(), TIMEOUT_MILLIS.longValue(), true, null, null,
						null, null);
				System.out.println(mail.getBody());

	}






	@Given("the user has requested a password reset")
	public void the_user_has_requested_a_password_reset() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@Given("an OTP has been sent to their registered email")
	public void an_otp_has_been_sent_to_their_registered_email() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@When("the user enters the correct OTP in the verification code field")
	public void the_user_enters_the_correct_otp_in_the_verification_code_field() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@When("clicks the {string} button")
	public void clicks_the_button(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@Then("the user should be redirected to the password reset page")
	public void the_user_should_be_redirected_to_the_password_reset_page() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}




	@Given("the user is on password recovery page")
	public void the_user_is_on_password_recovery_page() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@When("the user enters an unregistered email")
	public void the_user_enters_an_unregistered_email() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@When("clicks on  {string} button")
	public void clicks_on_button(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@Then("the user should see an error message")
	public void the_user_should_see_an_error_message() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@Then("no OTP should be sent")
	public void no_otp_should_be_sent() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}




	@Given("the user has requested for password reset")
	public void the_user_has_requested_for_password_reset() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@Given("an OTP was sent to their registered email")
	public void an_otp_was_sent_to_their_registered_email() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@When("the user enters an incorrect OTP in the verification code field")
	public void the_user_enters_an_incorrect_otp_in_the_verification_code_field() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@When("click on  {string} button")
	public void click_on_button(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@Then("the user should see error message")
	public void the_user_should_see_error_message() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@Then("the user should not be redirected to the password reset page")
	public void the_user_should_not_be_redirected_to_the_password_reset_page() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}



	
	@Given("the user is on the password reset page")
	public void the_user_is_on_the_password_reset_page() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@When("the user clicks on {string} button")
	public void the_user_clicks_on_button(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@Then("the user should be redirected to the login page")
	public void the_user_should_be_redirected_to_the_login_page() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}










}
