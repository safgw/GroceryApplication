package automationCore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class Base {
	
	public WebDriver driver;
	

	@BeforeMethod
	public void initializeBrowser()
	{
		driver = new ChromeDriver(); // FirefoxDriver or EdgeDriver
		//driver = new FirefoxDriver();
		//driver = new EdgeDriver();
		driver.get("https://groceryapp.uniqassosiates.com/admin/login");
		driver.manage().window().maximize();  // To maximize
	}
	
	@AfterMethod
	public void closeAndQuit()
	{

		//driver.quit();
	}

}
