package test;
import org.junit.runners.Suite.SuiteClasses;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.Parameters;

public class TESTNG2 {
	
	@BeforeTest
	public void Demo5() {
		System.out.println("Hello5");
		
	}
	
	@Test(enabled = false)
	public void Demo6() {
		System.out.println("Hello6");
	}
	
	@Parameters({"URL"})
	@Test(dependsOnMethods = {"Demo8","Demo9"})//This method Demo7 will run only after Demo8 and Demo9
	public void Demo7(String UrlName) {
		System.out.println("Hello7");
		System.out.println(UrlName);
	}
	
	@Test(timeOut = 4000)
	public void Demo8() {
		System.out.println("Hello8");
	}
	
	@Test
	public void Demo9() {
		System.out.println("Hello9");
	}
}
