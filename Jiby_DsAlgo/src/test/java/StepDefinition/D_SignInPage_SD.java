package StepDefinition;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.SignInPage;
import utilities.loggerLoad;

public class D_SignInPage_SD {
	
	SignInPage signin = new SignInPage();
	boolean result;
	
	@Given("The user is on signin page")
	public void the_user_is_on_signin_page() {
		signin.login_page();
	    
	}
	
	@When("The user clicks on register link on signin page")
	public void the_user_clicks_on_register_link_on_signin_page() {
		loggerLoad.info("User clicks on Register link on signin page");
		signin.register_link();
	    
	}

	@Then("The user redirected to Registration page from signin page")
	public void the_user_redirected_to_registration_page_from_signin_page() {
		loggerLoad.info("User redirected to Registraion page ");
		String Title = signin.register_page();
		loggerLoad.info("Title of the Page : \" " + Title + "\" ");
		assertEquals(Title, "Registration", "Title do not match");
	    
	}

	@When("The user enter invalid {string} and {string}")
	public void the_user_enter_invalid_and(String string, String string2) {
		loggerLoad.info("The user entered" + string + "as username and " + string2 + "as password");
		result = signin.doLogin(string, string2);
		assertTrue(result);
		System.out.println(result);
	    
	}

	@Then("click login button to verify")
	public void click_login_button_to_verify() {
		loggerLoad.info("User clicked login button to verify");
		signin.login_button();
		
	}
	
	@When("The user enters a valid username as {string} and password as {string}")
	public void the_user_enters_a_valid_username_as_and_password_as(String string, String string2) {
		signin.doLogin(string, string2);
		loggerLoad.info("User entered valid credentials");
	}
	
	@Then("click login button to verify the credentials")
	public void click_login_button_to_verify_the_credentials() {
		signin.login_button();
		
	}

}
