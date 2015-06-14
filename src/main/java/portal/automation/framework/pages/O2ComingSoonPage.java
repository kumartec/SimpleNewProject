package portal.automation.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import portal.automation.framework.core.BasePage;

public class O2ComingSoonPage extends BasePage {
	
	WebDriver driver;
	@FindBy(css="p.product-cta")
	WebElement lnkGetUpdates;

	public O2ComingSoonPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void clickGetUpdates() {		
		WebElement linkElement = (new WebDriverWait(driver,10)
			.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("p.product-cta"))));
		linkElement.click();
		//lnkGetUpdates.click();		
	}

}
