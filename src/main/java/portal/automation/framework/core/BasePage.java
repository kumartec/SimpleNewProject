package portal.automation.framework.core;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * 
 * @author Senthil G
 * This class will initiate the Webdriver
 *
 */

public class BasePage {
	
	WebDriver driver;
	AppProperties properties;

	public BasePage(WebDriver driver) {		
		this.driver = driver;
		PageFactory.initElements(driver, this);		
		properties = new AppProperties();
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(properties.getValue("TIMEOUT")), TimeUnit.SECONDS);
		driver.get(properties.getValue("URL"));
		
	}
	
	/**
	 * Open the specified URL
	 * 
	 * @param url
	 * Goto the url
	 */
	public void goToUrl(String url) {
		try {
			driver.get(url);
			System.out.println("Executed command" + " goToUrl(" + url + ")");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
