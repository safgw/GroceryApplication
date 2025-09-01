package testScript;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.AdminUsersPage;

public class AdminUsersTest extends LoginTest {

	@Test
	public void verifyNewUserCreationInAdminUsers() throws IOException {
		verifyUserLoginWithValidCredential();
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

	@Test
	public void verifySearchingNewlyCreatedUser() throws IOException {
		verifyUserLoginWithValidCredential();
		AdminUsersPage adminUsersPage = new AdminUsersPage(driver);
		adminUsersPage.goToAdminUserPage();
		adminUsersPage.clickSearchUserButton();
		adminUsersPage.enterTheUserNameToSearch();
		adminUsersPage.clickSearchButton();
		adminUsersPage.verifySearchUserResults();
	}

}
