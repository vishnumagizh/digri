package Gyan.digri;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

import com.mailslurp.apis.*;
import com.mailslurp.models.*;
import com.mailslurp.clients.ApiClient;
import com.mailslurp.clients.ApiException;
import com.mailslurp.clients.Configuration;

import com.mailslurp.apis.InboxControllerApi;
import com.mailslurp.apis.WaitForControllerApi;

import com.mailslurp.models.Email;
import com.mailslurp.models.InboxDto;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class MailSlurp {

	// set a timeout as fetching emails might take time
	private static final Long TIMEOUT_MILLIS = 30000L;

	public static ApiClient mailslurpClient;
	public static WebDriver driver;
	public static InboxDto inbox;
	public static Email mail;
	public static String Confirmationcode;

	public static void beforeAll() {
		// setup mailslurp
		mailslurpClient = Configuration.getDefaultApiClient();
		mailslurpClient.setApiKey("f2c45b9d4a6b9e72939aefeb849b095e607127fa8e61e864db832d773c97a7af");
		mailslurpClient.setConnectTimeout(TIMEOUT_MILLIS.intValue());

		// setup webdriver
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://playground.mailslurp.com");
		assertEquals(driver.getTitle(), "React App");
	}

	public static void test2_canClickSignUpButton() {
		driver.findElement(By.cssSelector("[data-test=sign-in-create-account-link]")).click();
	}

	public static void test3_canCreateEmailAddressAndSignUp() throws ApiException {
		// create a real, randomized email address with MailSlurp to represent a user
		InboxControllerApi inboxControllerApi = new InboxControllerApi(mailslurpClient);
		inbox = inboxControllerApi.createInboxWithDefaults();
		// fill the playground app's sign-up form with the MailSlurp
		// email address and a random password
		driver.findElement(By.name("email")).sendKeys(inbox.getEmailAddress());
		System.out.println(inbox.getEmailAddress());
		driver.findElement(By.name("password")).sendKeys("passwordvishnupriya");
		// submit the form to trigger the playground's email confirmation process
		// we will need to receive the confirmation email and extract a code
		driver.findElement(By.cssSelector("[data-test=sign-up-create-account-button]")).click();
	}

	public static void test4_canReceiveConfirmationEmail() throws ApiException {
		// receive a verification email from playground using mailslurp
		WaitForControllerApi waitForControllerApi = new WaitForControllerApi(mailslurpClient);
		mail = waitForControllerApi.waitForLatestEmail(inbox.getId(), TIMEOUT_MILLIS.longValue(), true, null, null,
				null, null);

		// verify the contents
		// assertEquals(mail.getSubject(), "Hello inbox2");
		// assertEquals(mail.getBody().contains("Your code is:"), true);
		// assertTrue(mail.getSubject().contains("Please confirm your email address"));

	}

	public static void test5_canExtractConfirmationCodeFromEmail() {
		// create a regex for matching the code we expect in the email body
		Pattern p = Pattern.compile(".*verification code is (\\d+).*");
		Matcher matcher = p.matcher(mail.getBody());
		
		System.out.println(mail.getBody());
	

		// find first occurrence and extract
		assertTrue(matcher.find());
		Confirmationcode = matcher.group(1);
		

		System.out.println(Confirmationcode);

		assertTrue(Confirmationcode.length() == 6);
	}

	public static void test6_canSubmitVerificationCodeToPlayground() {
		driver.findElement(By.name("code")).sendKeys(Confirmationcode);
		driver.findElement(By.cssSelector("[data-test=confirm-sign-up-confirm-button]")).click();
	}

	public static void test7_canLoginWithConfirmedUser() throws InterruptedException {

		// login with now confirmed email address
		Thread.sleep(5000);
		driver.findElement(By.name("username")).sendKeys(inbox.getEmailAddress());
		driver.findElement(By.name("password")).sendKeys("passwordvishnupriya");
		System.out.println(inbox.getEmailAddress());
		driver.findElement(By.cssSelector("[data-test=sign-in-sign-in-button]")).click();

		// verify that user can see authenticated content
		assertTrue(driver.findElement(By.tagName("h1")).getText().contains("Welcome"));
	}

	public static void main(String args[]) throws ApiException, InterruptedException

	{

		beforeAll();
		test2_canClickSignUpButton();
		test3_canCreateEmailAddressAndSignUp();
		test4_canReceiveConfirmationEmail();
		test5_canExtractConfirmationCodeFromEmail();
		test6_canSubmitVerificationCodeToPlayground();
		test7_canLoginWithConfirmedUser();

	}

}
