package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
/**
 * 
 * @author aswani.kumar.avilala
 *
 */
public class DemoWebShopHomePage {
	WebDriver driver;
	@FindBy(how = How.LINK_TEXT,using = "Register")
	WebElement registerLink;
	@FindBy(how = How.LINK_TEXT,using = "Log in")
	WebElement loginLink;
	
	
	public DemoWebShopHomePage(WebDriver driver) {
		super();
		this.driver = driver;
	}


	public String clickRegisterLink()
	{
		registerLink.click();
		return driver.getTitle();
	}
	/**
	 * This method returns the URL of the page
	 * @return String - The Current URL of the page
	 */
	public String clickLoginLink()
	{
		loginLink.click();
		return driver.getCurrentUrl();
	}

}
