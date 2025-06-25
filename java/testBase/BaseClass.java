package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.text.RandomStringGenerator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {

	public WebDriver driver;
	public Properties p;
	
	@BeforeClass(groups= {"sanity","master","regressionTest"})
	@Parameters({"os","browser"})
	public void setup(String os, String br) throws IOException  {
		
		//For loading config.properties file
		
		FileReader file = new FileReader("./src//test//resources//config.properties");
		p=new Properties();
		p.load(file);
		
		//For selecting the browser
		
		switch(br.toLowerCase()) {
		
		case "chrome":driver=new ChromeDriver(); break;
		case "edge":driver=new EdgeDriver(); break;
		default: System.out.println("Invalid browser name"); return;
		
		}
		
		driver.manage().deleteAllCookies();
		driver.get(p.getProperty("appURL")); //reading URL from properties file
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	@AfterClass(groups= {"sanity","master"})
	public void tearDown() {
		
		driver.quit();
	}
	
	public String captureScreen(String tname) throws IOException{
		
		String timeStamp = new SimpleDateFormat().format(new Date(0));
		
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile=takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilepath = System.getProperty("user.dir")+"\\screenshots" + tname +timeStamp;
		File targetFile=new File(targetFilepath);
		
		sourceFile.renameTo(targetFile);
		return targetFilepath;
	}
	
	public String generateRandomString() {
		
		RandomStringGenerator stringGen= new RandomStringGenerator.Builder().withinRange('a','z').build();
		String	randomString=stringGen.generate(5);
		
	return randomString;
	}
	
	public String generateRandomNumbers() {
		String randomNumber=RandomStringUtils.randomNumeric(10);
		
		return randomNumber;
	}
	
	public String generateRandomAlphaNumericString() {
		
		String randomString=RandomStringUtils.randomAlphabetic(3);
		String randomNumber=RandomStringUtils.randomNumeric(3);

		return (randomString+randomNumber);
	}
	
}
