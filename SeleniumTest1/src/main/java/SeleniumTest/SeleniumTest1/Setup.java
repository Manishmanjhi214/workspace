package SeleniumTest.SeleniumTest1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;


public class Setup {
	public WebDriver driver;
	public Landingpage landingpage;
	
	public WebDriver initialize() {
		System.setProperty("webdriver.chrome.driver", "F:/ECLIPSE/workspace/SeleniumProject1/chromedriver.exe");
		driver = new ChromeDriver();
		return driver;
	}
	
	@BeforeTest
	public WebDriver launchApp() {

		 driver = initialize();
		 landingpage = new Landingpage(driver);
		 landingpage.goTo();
		return driver;
		
	}
	@AfterClass
	public void Teardown() {
		driver.quit();
	}
}
