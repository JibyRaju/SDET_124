package StepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import utilities.loggerLoad;
import pageObjects.RegisterPage;
	

public class C_RegisterPage_SD {
	RegisterPage registerpage = new RegisterPage();
	
	@Given("The user opens Register Page")
	public void the_user_opens_register_page() {
		loggerLoad.info("The user opens Register page");
		registerpage.openRegisterurl();
	    
	}

	@When("The user clicks {string} button with all fields empty")
	public void the_user_clicks_button_with_all_fields_empty(String string) {
		registerpage.clickRegisterBtn();
	    
	}

	@Then("It should display an error {string} below Username textbox")
	public void it_should_display_an_error_below_username_textbox(String string) {
		loggerLoad.info("Error message is displayed " + registerpage.getEmptyfieldErrormsgUser()+ " an error below Username textbox");
		assertTrue(registerpage.getEmptyRequiredUser(), "Please fill out this field");
		assertEquals(registerpage.getEmptyfieldErrormsgUser(), string);
	    
	}
	
	@When("The user clicks Register button after entering {string} with other fields empty")
	public void the_user_clicks_register_button_after_entering_with_other_fields_empty(String string,  io.cucumber.datatable.DataTable dataTable) {
	
	loggerLoad.info("The user enter valid username with other fields empty");
	registerpage.entervalidUsername(dataTable);
	registerpage.clickRegisterBtn();
	
	}
	
	@Then("It should display an error message {string} below Password textbox")
	public void it_should_display_an_error_message_below_password_textbox(String string) {
		loggerLoad.info("Error message is displayed " + registerpage.getEmptyfieldErrormsgPswd()+ " an error below Password textbox");
		assertTrue(registerpage.getEmptyRequiredPswd(), "Please fill out this field");
		assertEquals(registerpage.getEmptyfieldErrormsgPswd(), string);
	   
	}
	
	@When("The user clicks Register button after entering {string} and {string} with Password Confirmation field empty")
	public void the_user_clicks_register_button_after_entering_and_with_password_confirmation_field_empty(String string, String string2, io.cucumber.datatable.DataTable dataTable) {
		loggerLoad.info("The user enter username and password with password confirmation field empty");
		registerpage.entervalidUsername(dataTable);
		registerpage.entervalidPassword(dataTable);
		registerpage.clickRegisterBtn();

	}
	
	@Then("It should display an error {string} below Password Confirmation textbox")
	public void it_should_display_an_error_below_password_confirmation_textbox(String string) {
		loggerLoad.info("Error message is displayed " + registerpage.getEmptyfieldErrormsgCofmPswd()+ " an error below Password textbox");
		assertTrue(registerpage.getEmptyRequiredCofmPswd(), "Please fill out this field");
		assertEquals(registerpage.getEmptyfieldErrormsgCofmPswd(), string);
	    
	}
		
	
	@When("The user enters a {string} {string} and {string} with characters other than Letters, digits and @\\/.\\/+\\/-\\/_")
	public void the_user_enters_a_and_with_characters_other_than_letters_digits_and(String string, String string2, String string3, io.cucumber.datatable.DataTable dataTable) {
		loggerLoad.info(" The user enter invalid username");
		registerpage.entervalidUsername(dataTable);
		registerpage.entervalidPassword(dataTable);
		registerpage.entervalidConfmPassword(dataTable);
		registerpage.clickRegisterBtn();
	
	}
	
	@Then("It should display an error message {string}")
	public void it_should_display_an_error_message(String string) {
		
	loggerLoad.info("Error message is displayed as : " + registerpage.getErrormsg());
	loggerLoad.info("Invalid username - The user enters a username with characters other than Letters, digits and \"@/./+/-/_\"\n");
		
	}
	
	@When("The user enters a valid {string} and {string} with characters less than eight and {string}")
	public void the_user_enters_a_valid_and_with_characters_less_than_eight_and(String string, String string2, String string3, io.cucumber.datatable.DataTable dataTable) {
	 
		loggerLoad.info(" The user enter password with less than 8 characters");
		registerpage.entervalidUsername(dataTable);
		registerpage.entervalidPassword(dataTable);
		registerpage.entervalidConfmPassword(dataTable);
		registerpage.clickRegisterBtn();
	}
	
	@Then("display an error message {string}")
	public void display_an_error_message(String string) {
		loggerLoad.info(string);	
		
	}
	
	@When("The user enters a valid {string} and commonly used password {string} and {string}")
	public void the_user_enters_a_valid_and_commonly_used_password_and(String string, String string2, String string3, io.cucumber.datatable.DataTable dataTable) {
	    
		loggerLoad.info("The user entered commonly used password");		
		registerpage.entervalidUsername(dataTable);
		registerpage.entervalidPassword(dataTable);
		registerpage.entervalidConfmPassword(dataTable);
		registerpage.clickRegisterBtn();
	}
	
	@Then("The error message is {string}")
	public void the_error_message_is(String string) {
		loggerLoad.info(string);
		
	}
	
	
	@When("The user enters a valid {string} and {string} and {string}")
	public void the_user_enters_a_valid_and_and(String string, String string2, String string3, io.cucumber.datatable.DataTable dataTable) {
	    
		loggerLoad.info(" The user enter valid credentials");
		registerpage.entervalidUsername(dataTable);
		registerpage.entervalidPassword(dataTable);
		registerpage.entervalidConfmPassword(dataTable);
		registerpage.clickRegisterBtn();
	}
	
	@Then("The user should be redirected to Homepage with the message {string}")
	public void the_user_should_be_redirected_to_homepage_with_the_message(String string) {
		
		loggerLoad.info(string);
		
	}
	@When("The user enters a valid existing {string} with {string} and {string}")
	public void the_user_enters_a_valid_existing_with_and(String string, String string2, String string3, io.cucumber.datatable.DataTable dataTable) {
	 
		loggerLoad.info(" The user enter given credentials");
		registerpage.entervalidUsername(dataTable);
		registerpage.entervalidPassword(dataTable);
		registerpage.entervalidConfmPassword(dataTable);
		registerpage.clickRegisterBtn();
	}
	
	@Then("It need to display an error message {string}")
	public void it_need_to_display_an_error_message(String string) {
		loggerLoad.info("User already exists");
		
	}

}
