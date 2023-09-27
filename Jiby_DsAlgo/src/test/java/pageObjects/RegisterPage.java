package pageObjects;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.cucumber.datatable.DataTable;
import utilities.configFileReader;
import utilities.driverFactory;
import utilities.loggerLoad;

public class RegisterPage {
	
	public static WebDriver driver = driverFactory.getdriver();
	//String HomeUrl = configFileReader.getHomePage();
	String registerUrl = configFileReader.getRegisterPage();
	//String loginUrl = configFileReader.getSigninPage();
	@FindBy(name="username") WebElement usernametxt;
	@FindBy(name="password1") WebElement passwordtxt;	
	@FindBy(name="password2") WebElement confirmpasswordtxt;	
	@FindBy(xpath = "//input [@ type = 'submit']") WebElement registerbtn;	
	@FindBy(xpath="//div[@role='alert']") WebElement alertmsg;
	//@FindBy(xpath = "//*[contains(text(),'Login')]") WebElement Loginbtn;
	//@FindBy(xpath="//a[@href='/logout']")WebElement signoutBtn;
	//@FindBy(linkText="Sign out")WebElement signoutBtn;
	
	public RegisterPage() {

		PageFactory.initElements(driver, this);
	}
	public void openRegisterurl() {
		
		driver.get(registerUrl);
	}

	public void clickRegisterBtn() {
		registerbtn.click();
		
	}
	
	public Boolean getEmptyRequiredUser() {
		boolean isRequired = false;
		// To check empty fields , we need to check "required" field is on an attribute
		if (usernametxt.getText().isBlank()) {
			JavascriptExecutor js_user = (JavascriptExecutor) driver;
			isRequired = (Boolean) js_user.executeScript("return arguments[0].required;", usernametxt);
		}
		return isRequired;
	}

	public Boolean getEmptyRequiredPswd() {
		boolean isRequired = false;
		// To check empty fields , we need to check "required" field is on an attribute
		if (passwordtxt.getText().isBlank()) {
			JavascriptExecutor js_user = (JavascriptExecutor) driver;
			isRequired = (Boolean) js_user.executeScript("return arguments[0].required;", passwordtxt);
		}
		return isRequired;
	}

	public Boolean getEmptyRequiredCofmPswd() {
		boolean isRequired = false;
		// To check empty fields , we need to check "required" field is on an attribute
		if (confirmpasswordtxt.getText().isBlank()) {
			JavascriptExecutor js_user = (JavascriptExecutor) driver;
			isRequired = (Boolean) js_user.executeScript("return arguments[0].required;", confirmpasswordtxt);
		}
		return isRequired;
	}

	public String getEmptyfieldErrormsgUser() {
		return usernametxt.getAttribute("validationMessage");
	}

	public String getEmptyfieldErrormsgPswd() {
		return passwordtxt.getAttribute("validationMessage");
	}

	public String getEmptyfieldErrormsgCofmPswd() {
		return confirmpasswordtxt.getAttribute("validationMessage");
	}

	public void enterUsername(String username) {
		usernametxt.clear();
		usernametxt.sendKeys(username);

	}

	public void enterPassword(String password) {
		passwordtxt.clear();
		passwordtxt.sendKeys(password);

	}

	public String getErrormsg() {
		String msg = null;
		try {
			msg = alertmsg.getText();
		} catch (NoSuchElementException e) {
			loggerLoad.info("No such element");
		}
		return msg;

	}

	public void enterCofmPassword(String cpassword) {
		confirmpasswordtxt.clear();
		confirmpasswordtxt.sendKeys(cpassword);

	}

	public String getPageTitle() {
		String title = driver.getTitle();
		return title;
	}

	public void entervalidUsername(DataTable dataTable) {
		List<Map<String, String>> userdetail = dataTable.asMaps(String.class, String.class);
		for (Map<String, String> form : userdetail) {

			String userName = form.get("username");
			loggerLoad.info("The user enter username as : " + userName);
			usernametxt.sendKeys(userName);
		}

	}

	public void entervalidPassword(DataTable dataTable) {
		List<Map<String, String>> userdetail = dataTable.asMaps(String.class, String.class);
		for (Map<String, String> form : userdetail) {

			String passwd = form.get("password");
			loggerLoad.info("The user enter password as : " + passwd);
			passwordtxt.sendKeys(passwd);

		}

	}

	public void entervalidConfmPassword(DataTable dataTable) {
		List<Map<String, String>> userdetail = dataTable.asMaps(String.class, String.class);
		for (Map<String, String> form : userdetail) {

			String cpasswd = form.get("password confirmation");
			loggerLoad.info("The user enter confirm password as : " + cpasswd);
			confirmpasswordtxt.sendKeys(cpasswd);

		}

	}
}


