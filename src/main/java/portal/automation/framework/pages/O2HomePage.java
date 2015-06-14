package portal.automation.framework.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import portal.automation.framework.core.BasePage;

public class O2HomePage extends BasePage {

	WebDriver driver;
	@FindBy(id="pn1")
	WebElement shopLink;
	@FindBy(linkText="Coming soon")
	WebElement lnkComingSoon;
	@FindBy(id="o2-page-wrapper")
	WebElement entireHomePage;
	
	
	
	//WebElement lnkComingSoon1= driver.findElement(By.cssSelector(selector));
	
	public O2HomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		
		// TODO Auto-generated constructor stub
	}
	
	public void moveToShopLink() {
		Actions action = new Actions(driver);
		action.moveToElement(shopLink).build().perform();
		lnkComingSoon.click();		
	}
	
	public void printAllLinksInHomePage(){
		//List<WebElement> entirepageelement = driver.findElements(By.cssSelector("div#o2-page-wrapper a"));
		List<WebElement> entirepageelement = driver.findElements(By.cssSelector("div#wrapper a"));
		
		for(WebElement pagelinks : entirepageelement){
			if(pagelinks.getText() != null)
			System.out.println(pagelinks.getText());
		}
	}
	
}
