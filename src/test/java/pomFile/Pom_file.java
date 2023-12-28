package pomFile;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Pom_file {
	
	@FindBy(id = "email")private WebElement email;
	
	@FindBy( id= "password")private WebElement password;
	
	@FindBy(xpath = "/*[text()='Login']") WebElement login;
	
    @FindBy(id = "//div[text()='Dashboard']")private WebElement dashboard;
	
	@FindBy( id= "//span[1]")private WebElement welcome;
	
	@FindBy(xpath = "/span[text()='Let’s learn something new today!']") WebElement welcome1;
	
	public Pom_file(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getEmail() {
		return email;
	}

	public void setEmail(WebElement email) {
		this.email = email;
	}

	public WebElement getPassword() {
		return password;
	}

	public void setPassword(WebElement password) {
		this.password = password;
	}

	public WebElement getLogin() {
		return login;
	}

	public void setLogin(WebElement login) {
		this.login = login;
	}

	public WebElement getDashboard() {
		return dashboard;
	}

	public void setDashboard(WebElement dashboard) {
		this.dashboard = dashboard;
	}

	public WebElement getWelcome() {
		return welcome;
	}

	public void setWelcome(WebElement welcome) {
		this.welcome = welcome;
	}

	public WebElement getWelcome1() {
		return welcome1;
	}

	public void setWelcome1(WebElement welcome1) {
		this.welcome1 = welcome1;
	}

	




}
