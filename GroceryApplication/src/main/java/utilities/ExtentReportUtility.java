package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportUtility {

	public static final ExtentReports extentReports = new ExtentReports();// static and final instance of ExtentReports that can
	// be shared accross the application

	public synchronized static ExtentReports createExtentReports() {

		ExtentSparkReporter reporter = new ExtentSparkReporter("./extent-reports/extent-report.html");// Predefined class. Defines where the report will be saved.
		 			// 'extent-report.html' - This folder is created under project hierarchy
		reporter.config().setReportName("7RMartSupermarketProject"); // ProjectName - Displayed at the top of the report
		extentReports.attachReporter(reporter);//Attaches reporter to the extent report instance

		
		// Row 18 and 19 are configurable details that can be added in the report
		extentReports.setSystemInfo("Organization", "Obsqura"); 
		extentReports.setSystemInfo("Name", " Hima"); // provides context of the report
		return extentReports; // All these data is returned wherever this methid is called.

	}

}
