package StepDefinition;
import static org.testng.Assert.assertEquals;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.loggerLoad;
import pageObjects.HomePage;

public class B_HomePage_SD {
	
		HomePage homepage =new HomePage();
		
	@Given("The user opens Home page")
	public void the_user_opens_home_page() {
		loggerLoad.info("User is on DSAlgo portal hoem page.");
		homepage.dsalgoHome();
	    
	}

	@When("The user clicks on dropdown {string} without login")
	public void the_user_clicks_on_dropdown_without_login(String string) {
		homepage.dropDown(string);
	}
	    
	

	@Then("The user get warning message {string}")
	public void the_user_get_warning_message(String string) {
		String alert = homepage.alert();
		loggerLoad.info("Alert Message: " + alert);
		assertEquals(alert, string, "Title do not match");
	    
	}
	
	@When("The user clicks {string}")
	public void the_user_clicks(String string) {
		loggerLoad.info("User clicks on Sign in ");
		homepage.homeSignin();
		
	    
	}

	@Then("The user should be redirected to Sign in page")
	public void the_user_should_be_redirected_to_sign_in_page() {
		loggerLoad.info("User redirected to signin page ");
		String Title = homepage.loginTitle();
		loggerLoad.info("Title of current page is : " + Title);
		assertEquals(Title, "Login", "Title do not match");
	    
	}
	
	@When("The user clicking {string}")
	public void the_user_clicking(String string) {
		loggerLoad.info("User clicks on register");
		homepage.homeregister();
	    
	}

	@Then("The user should be redirected to Register form")
	public void the_user_should_be_redirected_to_register_form() {
		loggerLoad.info("User redirected to Register page ");
		String Title = homepage.registertitle();
		loggerLoad.info("Title of current page is : " + Title);
		assertEquals(Title, "Registration", "Title do not match");
	    
	}


}
