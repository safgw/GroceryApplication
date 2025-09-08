package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AdminUsersPage {

	public WebDriver driver;

	public AdminUsersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// @FindBy(xpath =
	// "//section[@class='content']//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin']")
	@FindBy(xpath = "//p[text()='Admin Users']/ancestor::div/a")
	private WebElement adminUserPage;
	@FindBy(xpath = "//section[@class='content']//a[contains(text(),'New')]")
	private WebElement newButton;
	@FindBy(id = "username")
	private WebElement admin1UserName;
	@FindBy(id = "password")
	private WebElement admin1Password;
	@FindBy(id = "user_type")
	private WebElement userType;
	@FindBy(xpath = "//select[@id='user_type']//option[text()='Admin']")
	private WebElement adminType;
	@FindBy(name = "Create")
	private WebElement saveUser;
	@FindBy(xpath = "//div[contains(@class,'alert-success')]")
	private WebElement successMessage;
	@FindBy(linkText = "Search")
	private WebElement search;
	@FindBy(id = "un")
	private WebElement searchUserNameField;
	@FindBy(name = "Search")
	private WebElement searchUser;
	@FindBy(xpath = "//table[contains(@class,'table-bordered')]/tbody/tr[1]/td[1]")
	private WebElement searchUserResult;

	public void goToAdminUserPage() {
		adminUserPage.click();
	}

	public void clickNewButton() {
		newButton.click();
	}

	public void enterNewAdminUserName(String adminUserName) {
		admin1UserName.sendKeys(adminUserName);
	}

	public void enterNewAdminUserPassword(String adminUserPassword) {
		admin1Password.sendKeys(adminUserPassword);
	}

	public void viewUserTypeDropdown() {
		userType.click();
	}

	public void selectAdminValueFromDropdown() {

		Select select = new Select(userType);
		// WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		// wait.until(ExpectedConditions.elementToBeSelected(adminType));
		select.selectByValue("admin");
	}

	public void saveNewAdminUser() {
		saveUser.click();
	}

	public void clickSearchUserButton() {
		search.click();

	}

	public void enterTheUserNameToSearch(String adminUserName) {
		searchUserNameField.sendKeys(adminUserName);
	}

	public void clickSearchButton() {
		searchUser.click();
	}

}
