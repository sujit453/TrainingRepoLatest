package tests;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class NewTest {
	WebDriver driver;

	@BeforeTest
	//@Parameters({"browser","node"})
	@Parameters("browser")
	public void beforeTest(String browservalue,String nodevalue) throws MalformedURLException
	{
		/*
		 * DesiredCapabilities ds=new DesiredCapabilities();
		 * ds.setBrowserName(browservalue); ds.setPlatform(Platform.ANY);
		 * 
		 * driver=new RemoteWebDriver(new URL(nodevalue), ds);
		 */
		//System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");

		if(browservalue.contentEquals("chrome")) { driver=new ChromeDriver(); } else
			if(browservalue.contentEquals("firefox")) {
				System.setProperty("webdriver.gecko.driver",
						"src/test/resources/drivers/geckodriver.exe"); driver=new FirefoxDriver(); }
			else if(browservalue.contentEquals("ie")) {
				System.setProperty("webdriver.ie.driver",
						"src/test/resources/drivers/IEDriverServer.exe"); driver=new
						InternetExplorerDriver(); } else { driver=null; }

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("http://demowebshop.tricentis.com/login");
	}
	@AfterTest
	public void afterTest()
	{
		driver.close();
	}

	@Test(enabled = false,dataProvider = "dp1",dataProviderClass = MyDP.class,groups = "dry")
	public void testDDT(String s1,String s2)
	{
		System.out.println(s1+"\t"+s2);
	}

	@Test(dataProvider = "dp2",dataProviderClass = MyDP.class)
	public void testLoginDemoWebShop(String username,String password,String usertype) throws InterruptedException
	{
		driver.findElement(By.id("Email")).sendKeys(username);
		driver.findElement(By.id("Password")).sendKeys(password);
		driver.findElement(By.cssSelector("input[value='Log in']")).click();
		Assert.assertTrue(driver.findElement(By.linkText("Log out")).isDisplayed());
		driver.findElement(By.partialLinkText("Log out")).click();
		//Assert.assertTrue(driver.findElement(By.linkText("Log in")).isDisplayed());
		Thread.sleep(2000);
		driver.findElement(By.linkText("Log in")).click();
	}
}
