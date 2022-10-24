package test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TESTNG {
	@BeforeTest
	public void Demo() {
		System.out.println("Hello");
	}
	
	@AfterMethod
	public void Demo1() {
		System.out.println("Hello1");
	}
	
	@BeforeMethod
	public void Demo2() {
		System.out.println("Hello2");
	}
	
	@AfterTest
	public void Demo3() {
		System.out.println("Hello3");
	}
	
	@Test(groups={"OnlyMe"})
	public void Demo4() {
		System.out.println("Hello4");
	}
	@Test
	public void Demo11() {
		System.out.println("Hello11");
	}
	
}
