package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class DemoWebShopRegisterPage {
	WebDriver driver;
	@FindBy(how = How.ID,using = "gender-male")
	WebElement gender;
	@FindBy(how = How.ID,using = "FirstName")
	WebElement firstName;
	@FindBy(how = How.ID,using = "LastName")
	WebElement lastName;
	@FindBy(how = How.ID,using = "Email")
	WebElement email;
	@FindBy(how = How.ID,using = "Password")
	WebElement password;
	@FindBy(how = How.ID,using = "ConfirmPassword")
	WebElement confirmPassword;
	@FindBy(how = How.ID,using = "register-button")
	WebElement registerButton;
	public DemoWebShopRegisterPage(WebDriver driver) {
		super();
		this.driver = driver;
	}
	public void clickRgeisterButton()
	{
		gender.click();
		firstName.sendKeys("ABC");
		lastName.sendKeys("XYZ");
		email.sendKeys("abc@xyz.com");
		password.sendKeys("abc123");
		confirmPassword.sendKeys("abc123");
		registerButton.click();
	}
	
}
