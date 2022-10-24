package SeleniumTest.SeleniumTest1;

import org.testng.annotations.Test;

public class VerifyFooterElements extends Setup  {
	@Test
	public void newtest() {
		CommonMethods c= new CommonMethods(launchApp());
		c.openAdvtandSwitchtab();
		c.printElementsUsingXpath();
		Teardown();
	}
}
