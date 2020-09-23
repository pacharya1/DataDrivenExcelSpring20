package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class DashBoardPage {
	
	WebDriver driver;

	public DashBoardPage(WebDriver driver) {
		this.driver = driver;

	}

	// Element Library

	@FindBy(how = How.XPATH, using = "//*[@id=\"page-wrapper\"]/div[2]/div/h2")
	WebElement DASHBOARD_ELEMENT_FIELD;
	
	//Methods to interact with the elements
	
	public void verifyDashBoardElement() {
		Assert.assertEquals("Wrong Page!!!", "Dashboard", DASHBOARD_ELEMENT_FIELD.getText());
	
		

	
		
		
		
	}

} 
