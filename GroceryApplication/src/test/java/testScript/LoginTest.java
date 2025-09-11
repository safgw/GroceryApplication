package testScript;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import automationCore.Base;
import constants.Constant;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base {

	@Test(priority = 1, description = "Successful User Login with valid credentials",groups={"smoke"},retryAnalyzer=retryAnalyzer.Retry.class)//package Name.methodName.class extension
	public void verifyUserLoginWithValidCredential() throws IOException {
		String username = ExcelUtility.getStringData(1, 0, "Login"); // Reading userName from Excel
		String password = ExcelUtility.getStringData(1, 1, "Login"); // Reading password from Excel

		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameOnUserNameField(username);
		loginPage.enterPasswordOnPasswordField(password);
		loginPage.clickOnLoginButton();
		
		boolean dashboardDisplay = loginPage.isDashboardDisplayed();
		Assert.assertTrue(dashboardDisplay,Constant.VALIDCREDENTIALERROR);

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
		Assert.assertEquals(actual, expected, Constant.INVALIDNAMEERROR);

	}

	@Test(priority = 3, description = "User Login fails  with Valid Username and Invalid Password")
	public void verifyUserLoginWithValidUserNameAndInvalidPassword() throws IOException {

		String username = ExcelUtility.getStringData(3, 0, "Login"); // Reading userName from Excel
		String password = ExcelUtility.getStringData(3, 1, "Login"); // Reading password from Excel

		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameOnUserNameField(username);
		loginPage.enterPasswordOnPasswordField(password);
		loginPage.clickOnLoginButton();
		
		String expected = "7rmart supermarket";
		String actual = loginPage.getTitleText();
		Assert.assertEquals(actual, expected, Constant.INVALIDPASSWORDERROR);

	}

	@Test(priority = 4, description = "User Login fails with Invalid credentials",groups={"smoke"})
	public void verifyUserLoginWithInvalidCredential() throws IOException {

		String username = ExcelUtility.getStringData(4, 0, "Login"); // Reading userName from Excel
		String password = ExcelUtility.getStringData(4, 1, "Login"); // Reading password from Excel

		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameOnUserNameField(username);
		loginPage.enterPasswordOnPasswordField(password);
		loginPage.clickOnLoginButton();
		
		String expected = "7rmart supermarket";
		String actual = loginPage.getTitleText();
		Assert.assertEquals(actual, expected, Constant.INVALIDCREDENTIALERROR);

	}

}
