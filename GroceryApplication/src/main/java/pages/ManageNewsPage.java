package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage {

	public WebDriver driver;

	public ManageNewsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news' and text()='More info ']") private WebElement manageNewsPage;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/news/add']") private WebElement newNews;
	@FindBy(id="news") private WebElement enterNewsContent;
	@FindBy(name="create") private WebElement saveNewsContent;
	@FindBy(partialLinkText = "Search") private WebElement searchNews;
	@FindBy(name="un") private WebElement enterSearchNewsContent;
	@FindBy(name="Search") private WebElement searchButton;
	@FindBy(partialLinkText = "Reset") private WebElement resetNews;

	
	
	public void goToManageNewsPage()
	{
		manageNewsPage.click();
	}
	
	public void clickOnNewNewsButton()
	{
		newNews.click();
	}
	
	public void enterTheNewsContent(String randomNewsContent)
	{
		enterNewsContent.sendKeys(randomNewsContent);
	}
	
	public void saveNewNewsContent()
	{
		saveNewsContent.click();
	}
		
	
	public void clickOnSearchNewsButton()
	{
		searchNews.click();
	}
	
	public void enterTheSearchNewsContent(String newsContent)
	{
		enterSearchNewsContent.sendKeys(newsContent);
	}
	
	
	public void clickOnSearchButton()
	{
		searchButton.click();
	}
	
	public void clickOnResetNewsButton()
	{
		resetNews.click();
	}
	
	
}
