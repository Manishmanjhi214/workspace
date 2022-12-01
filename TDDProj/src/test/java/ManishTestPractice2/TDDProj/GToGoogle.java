package ManishTestPractice2.TDDProj;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GToGoogle {
public static void main(String[] args) throws IOException {
	System.setProperty("webdriver.chrome.driver", "E:/ECLIPSE/workspace/SeleniumProject1/chromedriver.exe");
	
	WebDriver driver = new ChromeDriver();
	FileInputStream fis = new FileInputStream("E:\\ECLIPSE\\workspace\\TDDProj\\AccountDetails.xlsx");
	XSSFWorkbook workbook = new XSSFWorkbook(fis);
	ArrayList<String> names= DataDriven.getAllRowsValueInAColumn(workbook);
	driver.get("https://www.google.com");
	driver.findElement(By.className("gLFyf")).click();
	driver.findElement(By.className("gLFyf")).sendKeys(names.get(1));
}
}
