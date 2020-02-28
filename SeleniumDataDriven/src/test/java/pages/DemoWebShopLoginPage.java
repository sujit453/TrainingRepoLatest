package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class DemoWebShopLoginPage {
	WebDriver driver;
	@FindBy(how = How.ID,using = "Email")
	WebElement email;
	@FindBy(how = How.ID,using = "Password")
	WebElement password;
	@FindBy(how = How.CSS,using = "input[value='Log in']")
	WebElement loginButton;
	@FindBy(how = How.LINK_TEXT,using = "Log out")
	WebElement logout;
	
	public DemoWebShopLoginPage(WebDriver driver) {
		super();
		this.driver = driver;
	}
	public void clickLoginButton()
	{
		email.sendKeys("askmail@email.com");
		password.sendKeys("abc123");
		loginButton.click();
	}
	public void logout()
	{
		logout.click();
		//driver.close();
	}
	

}
