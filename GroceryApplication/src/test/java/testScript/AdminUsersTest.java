package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import constants.Constant;
import pages.AdminUsersPage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.RandomDataUtility;

public class AdminUsersTest extends Base {

	@Test(priority = 5, description = "Successful creation of a new Admin user")
	public void verifyNewUserCreationInAdminUsersPage() throws IOException {
		String username = ExcelUtility.getStringData(1, 0, "Login");
		String password = ExcelUtility.getStringData(1, 1, "Login");

		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameOnUserNameField(username);
		loginPage.enterPasswordOnPasswordField(password);
		loginPage.clickOnLoginButton();

		AdminUsersPage adminUsersPage = new AdminUsersPage(driver);
		adminUsersPage.goToAdminUserPage();
		adminUsersPage.clickNewButton();

		RandomDataUtility random = new RandomDataUtility();
		String adminUserName = random.createRandomUserName();
		String adminUserPassword = random.createRandomPassword();

		adminUsersPage.enterNewAdminUserName(adminUserName);
		adminUsersPage.enterNewAdminUserPassword(adminUserPassword);
		adminUsersPage.viewUserTypeDropdown();
		adminUsersPage.selectAdminValueFromDropdown();
		adminUsersPage.saveNewAdminUser();
		
		boolean userCreatoinSuccess = adminUsersPage.successfulUserCreation();
		Assert.assertTrue(userCreatoinSuccess,Constant.USERCREATIONFAILED);

	}

	@Test(priority = 6, description = "Successful Search of an Admin user",retryAnalyzer=retryAnalyzer.Retry.class)
	public void verifySearchingNewlyCreatedUser() throws IOException {
		String username = ExcelUtility.getStringData(1, 0, "Login");
		String password = ExcelUtility.getStringData(1, 1, "Login");

		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameOnUserNameField(username);
		loginPage.enterPasswordOnPasswordField(password);
		loginPage.clickOnLoginButton();

		AdminUsersPage adminUsersPage = new AdminUsersPage(driver);
		adminUsersPage.goToAdminUserPage();
		adminUsersPage.clickSearchUserButton();

		String username1 = ExcelUtility.getStringData(1, 0, "AdminCredentials");
		adminUsersPage.enterTheUserNameToSearch(username1);
		adminUsersPage.clickSearchButton();
		
		String userSearchResult = adminUsersPage.userSearchResults();
		Assert.assertEquals(userSearchResult,username1,Constant.USERNOTFOUND);
		
		
	}

}
