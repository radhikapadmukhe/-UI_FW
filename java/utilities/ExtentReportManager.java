package utilities;

import java.sql.Date;
import java.text.SimpleDateFormat;

import org.testng.ITestContext;
import org.testng.ITestListener;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import freemarker.template.SimpleDate;

public class ExtentReportManager implements ITestListener{

	public ExtentSparkReporter sparkeReporter;
	public ExtentReports extent;
	public ExtentTest tets;
	
	String repName;
	
	public void OnStart(ITestContext testContext) {
		
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date(0));
		repName = "Test-Report-" +timeStamp+ ".html";
		sparkeReporter = new ExtentSparkReporter(".\\reports\\"+repName);
		
		sparkeReporter.config().setDocumentTitle("open cart automation report");
		sparkeReporter.config().setReportName("open cart functional testing");
		sparkeReporter.config().setTheme(Theme.DARK);
		
		extent = new ExtentReports();
		extent.attachReporter(sparkeReporter);
		extent.setSystemInfo("Application", "opencart");
		extent.setSystemInfo("Module", "Admin");
		extent.setSystemInfo("Sub Module", "Customers");
		
	}
}
