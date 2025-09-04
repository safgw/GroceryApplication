package testScript;

import java.io.IOException;

import org.testng.annotations.Test;

import automationCore.Base;
import pages.AdminUsersPage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class AdminUsersTest extends Base {

	@Test(priority=5,description="Successful creation of a new Admin user")
	public void verifyNewUserCreationInAdminUsers() throws IOException  {
		String username = ExcelUtility.getStringData(1, 0, "Login"); 
		String password = ExcelUtility.getStringData(1, 1, "Login"); 

		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameOnUserNameField(username);
		loginPage.enterPasswordOnPasswordField(password);
		loginPage.clickOnLoginButton();
		
		AdminUsersPage adminUsersPage = new AdminUsersPage(driver);
		adminUsersPage.goToAdminUserPage();
		adminUsersPage.clickNewButton();
		adminUsersPage.enterNewAdminUserName();
		adminUsersPage.enterNewAdminUserPassword();
		adminUsersPage.viewUserTypeDropdown();
		adminUsersPage.selectAdminValueFromDropdown();
		adminUsersPage.saveNewAdminUser();
		adminUsersPage.successMessageAfterUserCreation();

	}

	@Test(priority=6,description="Successful Search of an Admin user")
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
		adminUsersPage.enterTheUserNameToSearch();
		adminUsersPage.clickSearchButton();
	}

}
