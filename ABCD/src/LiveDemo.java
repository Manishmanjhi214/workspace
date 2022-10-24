

public class LiveDemo {
	public static void main(String[] args) {

		// TODO Auto-generated method stub



			System.setProperty("webdriver.chrome.driver", "F:/ECLIPSE/workspace/SeleniumProject1/chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("http://google.com");

		driver.navigate().to("https://rahulshettyacademy.com");

		driver.navigate().back();

		driver.navigate().forward();

		}
}
