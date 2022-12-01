package ManishTestPractice2.TDDProj;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


/**
 * Hello world!
 *
 */
public class App 
{
	public static Logger logger;
	public static final String Filepath = "E:/ECLIPSE/workspace/ObjectXpath.xlsx";
	public static Map<String, String> PageObjects;
    public static void main( String[] args ) throws IOException
    {
    	System.setProperty("webdriver.chrome.driver", "E:/ECLIPSE/workspace/SeleniumProject1/chromedriver.exe");
    	
    	WebDriver driver = new ChromeDriver();
    	LoadPageObject();
    	
    	driver.get("https://www.google.com");
    	driver.findElement(By.className(getObjectXpath("GoogleInputClassName"))).sendKeys("Alpha");
    	
    }
    
    public static  Map<String,String> loadDataIntoDictionary(String Filepath, String SheetName,int ColumnNumber_Key,int ColumnNumber_Value){
    	Map<String,String> dictionary = new LinkedHashMap<>();
    	String Key,Value;
    	getLogger().info("Loading values into dictionary from"+ Filepath);
    	try {
    		FileInputStream fis = new FileInputStream(Filepath);
        	XSSFWorkbook workbook = new XSSFWorkbook(fis);
        	XSSFSheet sheet = workbook.getSheet(SheetName);
        	for(Row row:sheet) {
        		Key = readExcelCell(row, ColumnNumber_Key);
        		if(!(Key == null)) {
        		Value = readExcelCell(row, ColumnNumber_Value);
        		dictionary.put(Key, Value);
        		getLogger().info("Adding Key"+ Key + "and Value"+ Value);
        		}
        		
        	}
        	getLogger().info("Values loaded into dictionary");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dictionary;
	}
    
    public static Logger getLogger() {
    	if(logger==null) {
    		logger =LogManager.getLogger(App.class);
    	}
    	return logger;
    }
    
    public static String readExcelCell(Row rowObject, int CellNumber) {
    	String cellValue= null;
    	try {
			cellValue = rowObject.getCell(CellNumber).getStringCellValue();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    	return cellValue;
    }
    public static String getObjectXpath(String Key) {
    	try {
		String value= PageObjects.get(Key);	
		return value;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
    }
    public static void LoadPageObject() {
    	PageObjects = loadDataIntoDictionary(Filepath, "Xpaths", 0, 1);
    }
}
