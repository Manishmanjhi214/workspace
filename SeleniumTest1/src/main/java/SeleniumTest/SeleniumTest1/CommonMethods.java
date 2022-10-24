package SeleniumTest.SeleniumTest1;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonMethods {
	WebDriver driver;

	public CommonMethods(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void waitForElementToVisible(String loc,String locator) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(300));
		String locatorType = locator;
		switch (locator){
		case "id":
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(loc)));
		case "xpath":
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc)));
		}
		
	}
	public void openAdvtandSwitchtab() {
		waitForElementToVisible("rt-maintop", "id");
		driver.switchTo().frame("a077aa5e");
		driver.findElement(By.tagName("a")).click();
		String parentWindow = driver.getWindowHandle();
		Set<String> windows= driver.getWindowHandles();
		String childWindow=null;
		Iterator<String> it = windows.iterator();
		while(it.hasNext()) {
			childWindow= it.next();
			driver.switchTo().window(childWindow);
		}
	}
	
	public void printElementsUsingXpath() {
		waitForElementToVisible("//h5[@class='kt-blocks-info-box-title']", "xpath");
		List<WebElement> el = driver.findElements(By.xpath("//h5[@class='kt-blocks-info-box-title']"));
		for(int i=0;i<el.size();i++) {
			System.out.println(el.get(i).getText());
		}
	}
}
