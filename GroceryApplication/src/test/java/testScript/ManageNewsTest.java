package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import constants.Constant;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;
import utilities.RandomDataUtility;

public class ManageNewsTest extends Base {

	@Test(priority = 8, description = "Successful creation of a new News")
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
		
		Boolean newNewsCreateSuccess = manageNewsPage.newsCreationSuccess();
		Assert.assertTrue(newNewsCreateSuccess, Constant.NEWSCREATIONFAILED);

	}

	@Test(priority = 9, description = "Successful Search of a News",retryAnalyzer=retryAnalyzer.Retry.class)
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
		
		String newsSearchResult = manageNewsPage.newsSearchResults();
		Assert.assertEquals(newsSearchResult, newsContent, Constant.NEWSNOTFOUND);

	}

	@Test(priority = 10, description = "Successful Reset of NewsPage")
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
		
		Boolean resetSuccess = manageNewsPage.newsResetSuccess();
		Assert.assertFalse(resetSuccess,Constant.NEWSRESETFAILED);

	}

	// Write a test to Edit and Delete button

}
