package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ElementsUtils;
import utilities.configFileReader;
import utilities.driverFactory;
import utilities.loggerLoad;

public class Datastructures {
	
	public static WebDriver driver = driverFactory.getdriver();
	
	
	String DsIntroPage = configFileReader.DataStructuresIntroduction();
	String TimeComplexityPage =configFileReader.TimeComplexity();
	String tryEditorPage = configFileReader.tryEditorURL();
	//String HomeURL = configFileReader.getHomePage();
	ElementsUtils elementUtil = new ElementsUtils();
	Actions action = new Actions(driver);
	
	@FindBy (xpath="//a[@href='data-structures-introduction']")WebElement dataStrucIntroLink;
	@FindBy (xpath="//a[@href='time-complexity']")WebElement timeComplexitylink;
	@FindBy(xpath="//a[@href ='/tryEditor']")WebElement TryhereBtn;
	@FindBy(xpath ="//button[text()='Run']")WebElement runBtn;
	
	@FindBy(xpath="//pre [@ class = ' CodeMirror-line ']")WebElement tryEditor;
	
	//@FindBy(xpath="/html/body/div[1]/div/form/div/div/div[6]")WebElement tryEditor;
	
	@FindBy(xpath = "//pre[@id='output']")WebElement outputText;
	@FindBy(xpath = "//*[@id=\"content\"]/a") WebElement practiesQuestions;

	public Datastructures() {

		PageFactory.initElements(driver, this);
	}

	public void getStarted_DS() {

		loggerLoad.info("click " + dataStrucIntroLink.getText() + " link on home page");
		dataStrucIntroLink.click();
	}
	
	public void clickTimeComplexity() {
		timeComplexitylink.click();
		
	}
	public void ClickTryHere() {
		TryhereBtn.click();
		
	}
	
	public void pythonCode(String sheetName, Integer rowNumber) throws Exception {	
		
		String code = elementUtil.getCodeFromExcel(sheetName, rowNumber);
		elementUtil.enterCode(code, tryEditor);
				}


//    public void clear() {
//				
//    	tryEditor.clear();
//	}

//	public void pythonCode() {
//		tryEditor.sendKeys("print('Hello')");
//		//action.sendKeys(tryEditor,code).perform();
//
//	}
	public void ClickRunBtn() {
		runBtn.click();
		
	}
	//Expected result from excel
	
	public String getExpectedResult(String sheetName, Integer rowNumber) throws Exception {
		 String expectedResult = elementUtil.getResultfromExcel(sheetName, rowNumber);
		 return expectedResult;
	}
	//Actual result from website output
	
	public String getActualResult() {
		elementUtil.WaitForElement(outputText);
		return outputText.getText();
	}
	
	public void tryeditorPage() {
		
		driver.navigate().to(tryEditorPage);
		
	}
	
	//Alert message from website while wrong code entered in texteditor(Non python code / wrong syntax python code)
	
	public String getAlertErrorText() {
		String errorMsg = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		return errorMsg;
	}

}
