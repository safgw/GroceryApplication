package testScript;

import java.io.IOException;
import org.testng.annotations.Test;
import automationCore.Base;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base {

	@Test
	public void verifyUserLoginWithValidCredential() throws IOException {
		String username = ExcelUtility.getStringData(1, 0, "Login"); // Reading userName from Excel
		String password = ExcelUtility.getStringData(1, 1, "Login"); // Reading password from Excel

		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameOnUserNameField(username);
		loginPage.enterPasswordOnPasswordField(password);
		loginPage.clickOnLoginButton();

	}

	@Test
	public void verifyUserLoginWithInvalidUserNameAndValidPassword() throws IOException {

		String username = ExcelUtility.getStringData(2, 0, "Login"); // Reading userName from Excel
		String password = ExcelUtility.getStringData(2, 1, "Login"); // Reading password from Excel

		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameOnUserNameField(username);
		loginPage.enterPasswordOnPasswordField(password);
		loginPage.clickOnLoginButton();

	}

	@Test
	public void verifyUserLoginWithValidUserNameAndInvalidPassword() throws IOException {

		String username = ExcelUtility.getStringData(3, 0, "Login"); // Reading userName from Excel
		String password = ExcelUtility.getStringData(3, 1, "Login"); // Reading password from Excel

		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameOnUserNameField(username);
		loginPage.enterPasswordOnPasswordField(password);
		loginPage.clickOnLoginButton();

	}

	@Test
	public void verifyUserLoginWithInvalidCredential() throws IOException {

		String username = ExcelUtility.getStringData(4, 0, "Login"); // Reading userName from Excel
		String password = ExcelUtility.getStringData(4, 1, "Login"); // Reading password from Excel

		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameOnUserNameField(username);
		loginPage.enterPasswordOnPasswordField(password);
		loginPage.clickOnLoginButton();

	}

}
