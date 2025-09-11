package automationCore;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ScreenshotUtility;

public class Base {

	public WebDriver driver;

	@BeforeMethod(alwaysRun=true)
	@Parameters("browser")
	public void initializeBrowser(String browser) throws Exception {
		
		if(browser.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();		
		}
		
		else if(browser.equalsIgnoreCase("edge"))
			
		{
			WebDriverManager.edgedriver()
			.clearResolutionCache()
		    .forceDownload()
		    .setup();
			driver = new EdgeDriver();	
		}
		
		else if(browser.equalsIgnoreCase("Firefox"))
			
		{
			driver = new FirefoxDriver();	
		}
		
		else
		{
			throw new Exception("Invalid browser");
		}
		
				
		driver.get("https://groceryapp.uniqassosiates.com/admin/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); // Duration is a class
	}

	@AfterMethod(alwaysRun=true)
	public void driverQuit(ITestResult iTestResult) throws IOException {
		if (iTestResult.getStatus() == ITestResult.FAILURE) { // ITestResult is a built in Interface , that has the
																// method- getStatus . It has 3 modes- failure, pass,
																// skip. Screenshot is captured nly on failures
			ScreenshotUtility screenShot = new ScreenshotUtility();
			screenShot.getScreenshot(driver, iTestResult.getName());
		}
		 driver.quit();

	}

}
