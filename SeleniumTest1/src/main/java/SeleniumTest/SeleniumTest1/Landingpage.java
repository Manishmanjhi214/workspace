package SeleniumTest.SeleniumTest1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Landingpage extends CommonMethods {
WebDriver driver;
	
	public Landingpage(WebDriver driver)
	{
		super(driver);
		//initialization
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	public void goTo()
	{
		driver.get("https://demo.guru99.com/test/guru99home/");
	}
}
