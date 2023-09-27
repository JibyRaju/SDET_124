package StepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.Datastructures;
import utilities.loggerLoad;
import utilities.configFileReader;

//import org.openqa.selenium.WebDriver;
import utilities.ElementsUtils;
import static org.testng.Assert.assertEquals;

public class E_Datastructures {
		
	String ExcelPath = configFileReader.getExcelPath();
	ElementsUtils elementUtil = new ElementsUtils();
//	static String pythoncode;
//	static String result;
	static String expectedResult;
	static String actualResult;
	Boolean isRequired ;


	Datastructures datastr = new Datastructures();
	
	@Given("The user is on the home page after logged in")
	public void the_user_is_on_the_home_page_after_logged_in() {
		loggerLoad.info("he user is on the home page after logged in");
		
	    
	}

	@When("The user clicks the {string} button in Data Structure Page introduction Panel")
	public void the_user_clicks_the_button_in_data_structure_page_introduction_panel(String string) {
		loggerLoad.info("The user clicked getstarted btn in Datastructure");
		datastr.getStarted_DS();
		
	    
	}

	@Then("The user should be redirected to data_structure_introduction page with some topics")
	public void the_user_should_be_redirected_to_data_structure_introduction_page_with_some_topics() {
		loggerLoad.info("The user redirected to topics in DS");
	    
	}
	
	@When("The user clicks Time Complexity link")
	public void the_user_clicks_time_complexity_link() {
		datastr.clickTimeComplexity();
	    
	}

	@Then("The user should be redirected to Time Complexity page")
	public void the_user_should_be_redirected_to_time_complexity_page() {
		
		loggerLoad.info("The user redirected to Time Complexity page");
	}
	
	@When("The user clicks {string} button on Time Complexity page")
	public void the_user_clicks_button_on_time_complexity_page(String string) {
		loggerLoad.info("The user clicked tryHere button");
		datastr.ClickTryHere();
	   
	}

	@Then("The user redirected to the assignment page with a run button")
	public void the_user_redirected_to_the_assignment_page_with_a_run_button() {
		
		loggerLoad.info("The user redirected to the assignment page");
	}
	
	@When("The user enter valid python code in tryEditor from sheet {string} and {int}")
	public void the_user_enter_valid_python_code_in_try_editor_from_sheet_and(String Sheetname, Integer Rownumber) throws Exception {
		loggerLoad.info("User enters valid python code in tryEditor from sheetname :" + Sheetname + " and row number : " + Rownumber);
		datastr.pythonCode(Sheetname, Rownumber);
		expectedResult = datastr.getExpectedResult(Sheetname, Rownumber);
		
	    
	}

	@Then("The user clicked runbutton to disply the result")
	public void the_user_clicked_runbutton_to_disply_the_result() {
		loggerLoad.info("The user waiting for the python output");
		datastr.ClickRunBtn();
		actualResult = datastr.getActualResult();
		assertEquals(actualResult, expectedResult, "Results didn't match");
		
		
	}
	@Given("The user is on try edidor page")
	public void the_user_is_on_try_edidor_page() {
		datastr.tryeditorPage();
	}
	
	@When("The user enter invalid python code in tryEditor from sheet {string} and {int}")
	public void the_user_enter_invalid_python_code_in_try_editor_from_sheet_and(String Sheetname, Integer Rownumber) throws Exception {
		loggerLoad.info("User enters invalid python code in tryEditor from sheetname :" + Sheetname + " and row number : " + Rownumber);
		//datastr.clear();
		datastr.pythonCode(Sheetname, Rownumber);
		expectedResult = datastr.getExpectedResult(Sheetname, Rownumber);
		
	    
	}

	@When("User click on run button")
	public void user_click_on_run_button() {		
		datastr.ClickRunBtn();
	    
	}

	@Then("User should get alert message")
	public void user_should_get_alert_message() {
		loggerLoad.info("The user will get an alert message");
		loggerLoad.info("User should be presented with error message");
		loggerLoad.info("Expected result : " + expectedResult);
	    String actualAlertMsg = datastr.getAlertErrorText();
	    loggerLoad.info("Actual Error Message : " + actualAlertMsg);
	    assertEquals(actualAlertMsg, expectedResult, "Result do not match");
		
	}
	




}
