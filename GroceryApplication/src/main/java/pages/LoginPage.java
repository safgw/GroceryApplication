package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	public WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(name = "username")
	private WebElement userNameField;
	@FindBy(name = "password")
	private WebElement passwordField;
	@FindBy(xpath = "//button[text()='Sign In']")
	private WebElement loginButton;
	@FindBy(xpath = "//p[text()='Dashboard']")
	private WebElement dashboard;
	@FindBy(xpath = "//b[text()='7rmart supermarket']")
	private WebElement loginTitle;
	@FindBy(xpath = "//div[contains(@class,'alert-danger')]")
	private WebElement loginFailAlert;

	public void enterUserNameOnUserNameField(String userName) {
		userNameField.sendKeys(userName);
	}

	public void enterPasswordOnPasswordField(String password) {
		passwordField.sendKeys(password);
	}

	public void clickOnLoginButton() {
		loginButton.click();

	}

	public boolean isDashboardDisplayed() {
		return dashboard.isDisplayed();
	}
	
	public String getTitleText()
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(loginFailAlert));
		return loginTitle.getText();
	}

}
