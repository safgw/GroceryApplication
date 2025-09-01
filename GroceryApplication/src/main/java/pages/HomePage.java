package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
	@FindBy(className = "login-box-msg")
	private WebElement logoutConfirmMessage;

	public void clickLogoutMenu() {
		logoutMenu.click();

	}

	public void clickLogout() {
		logout.click();

	}

	public void verifyLogoutConfirmMessage() {

		System.out.println(logoutConfirmMessage.getText());
		if (logoutConfirmMessage.getText().contains("start your session")) {
			System.out.println("User logged out successfully");
		}
	}

}
