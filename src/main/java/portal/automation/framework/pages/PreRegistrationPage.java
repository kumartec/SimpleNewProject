package portal.automation.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class PreRegistrationPage {

	WebDriver driver;
	@FindBy(id="first_name")
	WebElement txtFirstName;
	@FindBy(id="last_name")
	WebElement txtLastName;
	@FindBy(id="emailAddr")
	WebElement txtEmailAddress;
	@FindBy(id="mobnum")
	WebElement txtMobileNumber;
	@FindBy(id="existingO2Customer")
	WebElement chkExistingO2Customer;
	@FindBy(id="customerTypeMonthly")
	WebElement radiocustomerTypeMonthly;
	@FindBy(css="input[value='mot']")
	WebElement chkMotoManufacture;
	@FindBy(css="input[value='and']")
	WebElement chkAndroidOperatingSystem;
	@FindBy(css="label.error")
	WebElement validationError;
	int noOfValidationErrorFields = 0;
	
	public PreRegistrationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void submitPreRegRequest(String firstName, String lastName, String email, String mobile) {
		setTxtFirstName(firstName);
		setTxtLastName(lastName);
		setTxtEmailAddress(email);
		setTxtMobileNumber(mobile);
		deselectExistingO2Customer();
		selectcustomerTypeMonthly();
		selectMoto();
		selectAndroid();
		submitPreRegForm();		
	}
	
	public int validationErrorCount() {
		noOfValidationErrorFields = driver.findElements(By.cssSelector("label.error")).size();
		System.out.println("Total number of validation error: "+ noOfValidationErrorFields);		
		return noOfValidationErrorFields;				
	}
	
	public void selectcustomerTypeMonthly() {
		radiocustomerTypeMonthly.click();
	}
	
	public void selectExistingO2Customer() {
		if(!chkExistingO2Customer.isSelected())
			chkExistingO2Customer.click();
	}
	
	public void submitPreRegForm() {
		txtFirstName.submit();
	}
	
	public void deselectExistingO2Customer() { 
		if(chkExistingO2Customer.isSelected())
			chkExistingO2Customer.click();
	}
	
	public void selectMoto() {
		chkMotoManufacture.click();
	}
	
	public void selectAndroid() {
		chkAndroidOperatingSystem.click();
	}
	
	public String getTxtFirstName() {
		return txtFirstName.getText();
	}
	
	public void setTxtFirstName(String firstName) {
		this.txtFirstName.sendKeys(firstName);
	}

	public String getTxtLastName() {
		return txtLastName.getText();
	}

	public void setTxtLastName(String lastName) {
		this.txtLastName.sendKeys(lastName);
	}

	public String getTxtEmailAddress() {
		return txtEmailAddress.getText();
	}

	public void setTxtEmailAddress(String txtEmailAddress) {
		this.txtEmailAddress.sendKeys(txtEmailAddress);
	}

	public String getTxtMobileNumber() {
		return txtMobileNumber.getText();
	}

	public void setTxtMobileNumber(String txtMobileNumber) {
		this.txtMobileNumber.sendKeys(txtMobileNumber);
	}
	
	public void validateFormSubmissionSuccessful(){
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.o2.co.uk/getupdates/thankyou");
		if(driver.getCurrentUrl().contains("thankyou"))
			 System.out.println("PreReg order placed successfully");
	}
	
	public void validateErrorsDisplayed(){
		Assert.assertNotEquals(validationErrorCount(), 0);
		System.out.println("All the Error Message displayed properly");
	}
	
}
