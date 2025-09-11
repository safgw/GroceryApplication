package testScript;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import constants.Constant;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class HomeTest extends Base {

	@Test(priority = 7, description = "Successful log out of the user")
	public void verifyUserCanSuccessfullyLogout() throws IOException, AWTException {

		String username = ExcelUtility.getStringData(1, 0, "Login");
		String password = ExcelUtility.getStringData(1, 1, "Login");

		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameOnUserNameField(username);
		loginPage.enterPasswordOnPasswordField(password);
		loginPage.clickOnLoginButton();

		HomePage homePage = new HomePage(driver);
		homePage.clickOnAdminMenu();
		homePage.clickLogout();
		
		boolean loggedOutPage = homePage.userLoggedOut();
		Assert.assertTrue(loggedOutPage,Constant.USERNOTLOGGEDOUT);

	}

}
