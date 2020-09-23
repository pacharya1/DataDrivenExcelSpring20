package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class AddCustomerPage extends BasePage {
	
	WebDriver driver;

	public AddCustomerPage(WebDriver driver) {
		this.driver = driver;
	}

	// Element Library
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"side-menu\"]/li[3]/a")
	WebElement CUSTOMERS_BUTTON_LOCATOR;
	@FindBy(how = How.XPATH, using = "//*[@id=\"side-menu\"]/li[3]/ul/li[1]/a")
	WebElement ADD_CUSTOMER_BUTTON_LOCATOR;
	@FindBy(how = How.XPATH, using = "//*[@id=\"account\"]")
	WebElement FULLNAME_FIELD_LOCATOR;
	@FindBy(how = How.XPATH, using = "//*[@id=\"cid\"]")
	WebElement COMPANY_DROPDOWN_LOCATOR;
	@FindBy(how = How.XPATH, using = "//*[@id=\"email\"]")
	WebElement EMAIL_FIELD_LOCATOR;
	@FindBy(how = How.XPATH, using = "//*[@id=\"phone\"]")
	WebElement PHONE_FIELD_LOCATOR;
	@FindBy(how = How.XPATH, using = "//*[@id=\"address\"]")
	WebElement ADDRESS_FIELD_LOCATOR;
	@FindBy(how = How.XPATH, using = "//*[@id=\"city\"]")
	WebElement CITY_FIELD_LOCATOR;
	@FindBy(how = How.XPATH, using = "//*[@id=\"state\"]")
	WebElement STATE_FIELD_LOCATOR;
	@FindBy(how = How.XPATH, using = "//*[@id=\"zip\"]")	
	WebElement ZIP_FIELD_LOCATOR;	
	@FindBy(how = How.XPATH, using = "//*[@id=\"group\"]")	
	WebElement GROUP_DROPDOWN_LOCATOR;
	@FindBy(how = How.XPATH, using = "//*[@id=\"submit\"]")
	WebElement SAVE_BUTTON_LOCATOR;
	@FindBy(how = How.XPATH, using = "//*[@id=\"summary\"]")
	WebElement SUMMARY_BUTTON_LOCATOR;	
	@FindBy(how = How.XPATH, using = "//*[@id=\"side-menu\"]/li[3]/ul/li[2]/a")
	WebElement LIST_CUSTOMERS_BUTTON_LOCATOR;	
	
	
	
// Methods to interact with the elements
	public void clickCustomersButton() throws InterruptedException {
		CUSTOMERS_BUTTON_LOCATOR.click();
		Thread.sleep(3000);
		
	}
	public void clickAddCustomerButton() throws InterruptedException {
		ADD_CUSTOMER_BUTTON_LOCATOR.click();
		Thread.sleep(2000);
	}
	String enteredName;
	public void insertFullname( String fullName){
	        enteredName = fullName + BasePage.randomNumGenerator();
			FULLNAME_FIELD_LOCATOR.sendKeys(enteredName);
	}
	
	public void insertCompanyName(String company) {
		BasePage.dropDown(COMPANY_DROPDOWN_LOCATOR, company);
		
	}
	public void insertEmail(String email) {
		String enteredEmail = BasePage.randomNumGenerator() + email;
		EMAIL_FIELD_LOCATOR.sendKeys(enteredEmail);
	}
	public void insertPhoneNumber(String phoneNum) {
		PHONE_FIELD_LOCATOR.sendKeys(phoneNum);
	}
	public void insertAddress(String address) {
		ADDRESS_FIELD_LOCATOR.sendKeys(address);
	}
	public void insertCity(String city) {
		CITY_FIELD_LOCATOR.sendKeys(city);
	}
	public void insertState(String state) {
		STATE_FIELD_LOCATOR.sendKeys(state);
	}
	public void insertZip(String zip) {
		ZIP_FIELD_LOCATOR.sendKeys(zip);
	}
	public void insertGroup(String group) {
		BasePage.dropDown(GROUP_DROPDOWN_LOCATOR, group);
	}
	public void clickOnSaveButton() {
		SAVE_BUTTON_LOCATOR.click();
		BasePage.waitforElement(driver, 3, By.xpath("//*[@id=\"summary\"]"));
	}
	public void clickOnListCustomersButton() {
		LIST_CUSTOMERS_BUTTON_LOCATOR.click();
	}
	
	String before_xpath = "//tbody/tr[";
	String after_xpath = "]/td[3]";
	
	@SuppressWarnings("deprecation")
	public void verifyEnteredCustomerAndDelete() {
		
		for (int i = 1; i<= 5; i++) {
			String name = driver.findElement(By.xpath(before_xpath + i + after_xpath)).getText();
			System.out.println(name);
			//Assert.assertEquals("Name does not match!!!", enteredName, name);
			
			if(name.contains(enteredName)) {
				System.out.println("Entered name exists");
				driver.findElement(By.xpath("//tbody/tr["+ i +"]/td[3]/following-sibling::td[4]/a[2]")).click();
				BasePage.waitforElement(driver, 2, By.xpath("/html/body/div[1]/div/div/div[2]/button[2]"));
				driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/button[2]")).click();
				
				
			}
		}
			
		
	
	}
	
	
	
	
	
	
	
}
