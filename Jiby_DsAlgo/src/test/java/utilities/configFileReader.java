package utilities;

import java.io.FileInputStream;
//import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

public class configFileReader {
	
	public static Properties properties;
	
	public static final String propertyFilePath = "./src/test/resources/config/config.properties";
	public static WebDriver driver;
	public static String browserType = null;
	
	public static void readConfig() throws Throwable {
		
		FileInputStream fis;
		fis = new FileInputStream(propertyFilePath);
		properties = new Properties();
		properties.load(fis);
		fis.close();
		
	}
	
	public static void setBrowserType(String browser) {
		browserType = browser;
	}
	
	public static String getBrowserType() {
		String browser = properties.getProperty("browser");
		if(browser != null) {
			return browser;
		}
		else {
			throw new RuntimeException("browser not specified in config.properties file");
		}
	}
	
	public static String getUrl() {
		String url = properties.getProperty("url");
		if(url != null) {
			return url;
		}else {
			throw new RuntimeException("url not specified in the Configuration.properties file.");
		}
	}
	
	public static String getHomePage() {
		String homeurl = properties.getProperty("HomeUrl");
				
		if (homeurl != null)
			return homeurl;
		else
			throw new RuntimeException("Homeurl not specified in the Configuration.properties file.");
	}
	public static String getRegisterPage() {
		String registerurl = properties.getProperty("Registerurl");
				
		if (registerurl != null)
			return registerurl;
		else
			throw new RuntimeException("Registerurl not specified in the Configuration.properties file.");
	}
	public static String getSigninPage() {
		String signinurl = properties.getProperty("Login");
				
		if (signinurl != null)
			return signinurl;
		else
			throw new RuntimeException("Login not specified in the Configuration.properties file.");
	
	}
	
	public static String getExcelPath() {
		String excelPath = properties.getProperty("excelpath");
				
		if (excelPath != null)
			return excelPath;
		else
			throw new RuntimeException("Excel Path is not specified in the Configuration.properties file.");
	}
	public static String DataStructuresIntroduction() {
		String DataStructuresIntroduction = properties.getProperty("DataStructuresIntroduction");
		
		if (DataStructuresIntroduction != null)
			return DataStructuresIntroduction;
		else
			throw new RuntimeException("DataStructuresIntroduction not specified in the Configuration.properties file.");
	}
	public static String TimeComplexity() {
		String TimeComplexity = properties.getProperty("TimeComplexity");
		
		if (TimeComplexity != null)
			return TimeComplexity;
		else
			throw new RuntimeException("TimeComplexity url not specified in the Configuration.properties file.");
	}

	public static String tryEditorURL() {
		String tryeditorurl = properties.getProperty("Tryeditorurl");
		if (tryeditorurl != null)
			return tryeditorurl;
		else
			throw new RuntimeException("tryeditorurl not specified in the Configuration.properties file.");
	}

}


