package pages;

import java.time.Duration;

import javax.xml.xpath.XPath;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ManageNewsPage {

	public WebDriver driver;

	public ManageNewsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news' and text()='More info ']")
	private WebElement manageNewsPage;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/news/add']")
	private WebElement newNews;
	@FindBy(id = "news")
	private WebElement enterNewsContent;
	@FindBy(name = "create")
	private WebElement saveNewsContent;
	@FindBy(partialLinkText = "Search")
	private WebElement searchNews;
	@FindBy(name = "un")
	private WebElement enterSearchNewsContent;
	@FindBy(name = "Search")
	private WebElement searchButton;
	@FindBy(partialLinkText = "Reset")
	private WebElement resetNews;
	@FindBy(xpath = "//div[contains(@class,'alert-success')]")
	private WebElement newsCreateSuccess;
	@FindBy(xpath = "//table//tbody//tr[1]/td[1]")
	private WebElement newsSearchResult;
	@FindBy(xpath = "//h4[(text()='Search Manage News')]")
	private WebElement searchFieldTitle;
	

	public void goToManageNewsPage() {
		manageNewsPage.click();
	}

	public void clickOnNewNewsButton() {
		newNews.click();
	}

	public void enterTheNewsContent(String randomNewsContent) {
		enterNewsContent.sendKeys(randomNewsContent);
	}

	public void saveNewNewsContent() {
		saveNewsContent.click();
	}

	public void clickOnSearchNewsButton() {
		searchNews.click();
	}

	public void enterTheSearchNewsContent(String newsContent) {
		enterSearchNewsContent.sendKeys(newsContent);
	}

	public void clickOnSearchButton() {
		searchButton.click();
	}

	public void clickOnResetNewsButton() {
		resetNews.click();
	}
	
	public boolean newsCreationSuccess() {
		return newsCreateSuccess.isDisplayed();
	}
	
	public String newsSearchResults() {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(3));
		wait.until(ExpectedConditions.visibilityOf(newsSearchResult));
		return newsSearchResult.getText();
	}
	
	public boolean newsResetSuccess()
	{
		return searchFieldTitle.isDisplayed(); 
	}
	

}
