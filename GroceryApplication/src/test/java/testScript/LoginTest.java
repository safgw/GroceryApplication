package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import automationCore.Base;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base {

	@Test(priority = 1, description = "Successful User Login with valid credentials")
	public void verifyUserLoginWithValidCredential() throws IOException {
		String username = ExcelUtility.getStringData(1, 0, "Login"); // Reading userName from Excel
		String password = ExcelUtility.getStringData(1, 1, "Login"); // Reading password from Excel

		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameOnUserNameField(username);
		loginPage.enterPasswordOnPasswordField(password);
		loginPage.clickOnLoginButton();
		
		boolean dashboardDisplay = loginPage.isDashboardDisplayed();
		Assert.assertTrue(dashboardDisplay,"User couldn't login with valid credential");

	}

	@Test(priority = 2, description = "User Login fails with Invalid Username and Valid Password")
	public void verifyUserLoginWithInvalidUserNameAndValidPassword() throws IOException {

		String username = ExcelUtility.getStringData(2, 0, "Login");
		String password = ExcelUtility.getStringData(2, 1, "Login");

		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameOnUserNameField(username);
		loginPage.enterPasswordOnPasswordField(password);
		loginPage.clickOnLoginButton();
		
		String expected = "7rmart supermarket";
		String actual = loginPage.getTitleText();
		Assert.assertEquals(actual, expected, "User is able to login with Invalid username");

	}

	@Test(priority = 3, description = "User Login fails  with Valid Username and Invalid Password")
	public void verifyUserLoginWithValidUserNameAndInvalidPassword() throws IOException {

		String username = ExcelUtility.getStringData(3, 0, "Login"); // Reading userName from Excel
		String password = ExcelUtility.getStringData(3, 1, "Login"); // Reading password from Excel

		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameOnUserNameField(username);
		loginPage.enterPasswordOnPasswordField(password);
		loginPage.clickOnLoginButton();

	}

	@Test(priority = 4, description = "User Login fails with Invalid credentials")
	public void verifyUserLoginWithInvalidCredential() throws IOException {

		String username = ExcelUtility.getStringData(4, 0, "Login"); // Reading userName from Excel
		String password = ExcelUtility.getStringData(4, 1, "Login"); // Reading password from Excel

		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameOnUserNameField(username);
		loginPage.enterPasswordOnPasswordField(password);
		loginPage.clickOnLoginButton();

	}

}
