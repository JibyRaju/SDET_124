package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.configFileReader;
import utilities.driverFactory;

public class SignInPage {
	
	public  static WebDriver driver=driverFactory.getdriver();;
	String loginURL=configFileReader.getSigninPage();
	boolean isRequired = false;
	
	@FindBy (xpath="//*[@id='id_username']")static WebElement sUsername;
	@FindBy (xpath="//*[@id='id_password']")static WebElement sPassword;
	@FindBy (xpath="//*[@value='Login']")WebElement login_button;
	//@FindBy (xpath="//div[@class='alert alert-primary']")WebElement alert;
	@FindBy(xpath="//div[@role='alert']")WebElement alertmsg;
	@FindBy (xpath="//a[@href='/register']")WebElement registerbtn;
	@FindBy (xpath="//a[@href='/logout']")WebElement signout;
	
	public SignInPage() {

		PageFactory.initElements(driver, this);
	}

	public void login_page() {

		driver.get(loginURL);

	}

	public Boolean doLogin(String username, String password) {

		sUsername.clear();
		sUsername.sendKeys(username);
		sPassword.clear();
		sPassword.sendKeys(password);

		// To check empty fields , we need to check "required" field is on an attribute
		if (username.isBlank()) {
			JavascriptExecutor js_user = (JavascriptExecutor) driver;
			isRequired = (Boolean) js_user.executeScript("return arguments[0].required;", sUsername);
			return isRequired;
		} else if (password.isBlank()) {
			JavascriptExecutor js_password = (JavascriptExecutor) driver;
			isRequired = (Boolean) js_password.executeScript("return arguments[0].required;", sPassword);
			return isRequired;

		}
		return isRequired;
	}

	// input fields empty -click login
	public void login_button() {

		login_button.click();

	}

	// login for excel sheet data
	public String click_login() {

		login_button.click();
		String msg = alertmsg.getText();
		return msg;
	}

	public void register_link() {

		registerbtn.click();
	}

	public String register_page() {

		String Title = driver.getTitle();
		return Title;
	}

	public void signout() {
		signout.click();
	}
	
	public String actualerrormsg() {
		
		return sUsername.getAttribute("validationMessage");

		}

}



//public void openRegisterurl() {
//	
//	driver.navigate().to(registerUrl);		
//}









