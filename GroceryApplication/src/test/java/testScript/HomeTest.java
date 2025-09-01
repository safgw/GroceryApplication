package testScript;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.IOException;
import org.testng.annotations.Test;
import pages.HomePage;

public class HomeTest extends LoginTest {

	@Test
	public void verifyHomeScreenLogout() throws IOException, AWTException {
		verifyUserLoginWithValidCredential();

		HomePage homePage = new HomePage(driver);
		homePage.clickLogoutMenu();
		homePage.clickLogout();
		homePage.verifyLogoutConfirmMessage();

	}

}
