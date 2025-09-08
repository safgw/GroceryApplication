package testScript;

import java.io.IOException;

import org.testng.annotations.Test;

import automationCore.Base;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;
import utilities.RandomDataUtility;

public class ManageNewsTest extends Base {

	@Test
	public void verifyNewNewsCreationInManageNewsPage() throws IOException {
		String username = ExcelUtility.getStringData(1, 0, "Login");
		String password = ExcelUtility.getStringData(1, 1, "Login");

		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameOnUserNameField(username);
		loginPage.enterPasswordOnPasswordField(password);
		loginPage.clickOnLoginButton();

		ManageNewsPage manageNewsPage = new ManageNewsPage(driver);
		manageNewsPage.goToManageNewsPage();
		manageNewsPage.clickOnNewNewsButton();

		RandomDataUtility random = new RandomDataUtility();
		String randomNews = random.createRandomNews();

		manageNewsPage.enterTheNewsContent(randomNews);
		manageNewsPage.saveNewNewsContent();

	}

	@Test
	public void verifyNewsSearchInManageNewsPage() throws IOException {
		String username = ExcelUtility.getStringData(1, 0, "Login");
		String password = ExcelUtility.getStringData(1, 1, "Login");

		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameOnUserNameField(username);
		loginPage.enterPasswordOnPasswordField(password);
		loginPage.clickOnLoginButton();

		ManageNewsPage manageNewsPage = new ManageNewsPage(driver);
		manageNewsPage.goToManageNewsPage();
		manageNewsPage.clickOnSearchNewsButton();

		String newsContent = ExcelUtility.getStringData(2, 0, "NewsSearch");
		manageNewsPage.enterTheSearchNewsContent(newsContent);
		manageNewsPage.clickOnSearchButton();

	}

	@Test
	public void verifyResetButtonInManageNewsPage() throws IOException

	{
		String username = ExcelUtility.getStringData(1, 0, "Login");
		String password = ExcelUtility.getStringData(1, 1, "Login");

		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameOnUserNameField(username);
		loginPage.enterPasswordOnPasswordField(password);
		loginPage.clickOnLoginButton();

		ManageNewsPage manageNewsPage = new ManageNewsPage(driver);
		manageNewsPage.goToManageNewsPage();
		manageNewsPage.clickOnSearchNewsButton();
		manageNewsPage.clickOnResetNewsButton();

	}

	// Write a test to Edit and Delete button

}
