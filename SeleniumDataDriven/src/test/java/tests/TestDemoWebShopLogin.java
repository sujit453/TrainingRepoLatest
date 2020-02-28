package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.DemoWebShopHomePage;
import pages.DemoWebShopLoginPage;

public class TestDemoWebShopLogin {
	WebDriver driver;
	DemoWebShopHomePage homepage;
	DemoWebShopLoginPage loginpage;

	@BeforeTest
	public void beforeTest(){
		System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://demowebshop.tricentis.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		//homepage=new DemoWebShopHomePage(driver);
		homepage=PageFactory.initElements(driver, DemoWebShopHomePage.class);
		loginpage=PageFactory.initElements(driver, DemoWebShopLoginPage.class);

	}
	@AfterTest
	public void afterTest()
	{
		homepage=null;
		loginpage=null;

	}
	@Test
	public void testLoginLink()
	{
			String url=homepage.clickLoginLink();
			Assert.assertTrue(url.contains("login"));
	}
	@Test(dependsOnMethods = "testLoginLink")
	public void testLoginButton()
	{
			loginpage.clickLoginButton();
			
			loginpage.logout();
			Assert.assertTrue(driver.getTitle().contains("Demo Web Shop"));
	}
}

