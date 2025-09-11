package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	public WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(partialLinkText = "Admin")
	private WebElement logoutMenu;
	@FindBy(partialLinkText = "Logout")
	private WebElement logout;
	@FindBy(xpath = "//button[text()='Sign In']")
	private WebElement loginButton;

	public void clickOnAdminMenu() {
		logoutMenu.click();

	}

	public void clickLogout() {
		logout.click();

	}
	
	
	public boolean userLoggedOut()
	{
		return loginButton.isDisplayed();
	}

}
