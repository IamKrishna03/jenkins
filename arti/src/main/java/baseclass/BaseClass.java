package baseclass;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;




import action.Action;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static Properties pop ;
	public static WebDriver driver;
//	public static ExtentReports report;
//	public static ExtentHtmlReporter htmlReporter;
//	public static ExtentTest log ;
	public static Action actn = new Action();

	@BeforeSuite 
	public static void loadConfig () throws IOException  {
//		System.out.println(System.getProperty("user.dir"));
//		try {
//			pop = new Properties();
//			//System.out.println("Path1 "+System.getProperty("user.dir") + "\\Configuration\\config.properties");
//			
//			FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "\\configuration\\\\my.properties");
//			//System.out.println("Path2 "+System.getProperty("user.dir") + "\\Configuration\\config.properties");
//			pop.load(ip);
//			
//		}
//
//		catch (FileNotFoundException e) {
//			System.out.println("pop file not found");
//			e.printStackTrace();
//		} 
//		
//		report = new ExtentReports();
//		htmlReporter = new ExtentHtmlReporter("C:\\Users\\kaila\\eclipse-workspace\\Testngassign\\configuration\\reposk.html");
//
//		//htmlReporter = new ExtentHtmlReporter ("C:\\report\\reposk.html");
//		htmlReporter.config().setDocumentTitle("my title");
//		htmlReporter.config().setReportName("my report");
//		htmlReporter.config().setTheme(Theme.STANDARD);
//		report.attachReporter(null);
////		System.out.println("report initilized" + report);
	}
	@BeforeTest
	public static void Launch ()  {
		String Browsername = "Chrome";
		if (Browsername.equals("Chrome")) {
			WebDriverManager.chromedriver().setup();
			System.out.println("Chrome browser selected");
			driver = new ChromeDriver();
			System.out.println("Chrome browser setup");
			
		}
		else if (Browsername.equals("FireFox")) {
			WebDriverManager.firefoxdriver().setup();
			System.out.println("FireFox browser selected");
			driver = new FirefoxDriver();
			System.out.println("FireFox browser setup");
		}
		else {
			System.out.println("Browser not added");
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		//PageLoad TimeOuts
		driver.manage().timeouts().pageLoadTimeout(100,TimeUnit.SECONDS);
		System.out.println("nevigation");
		driver.get("https://www.google.com/");
		System.out.println("nevigationeddd");
	}

	@AfterSuite
	public void afterSuite() {
		driver.close();
		driver.quit();
//		  if (report != null) {
//			  
//		        report.flush();
//		        System.out.println("report");
//		    }
	}
	
//	@BeforeSuite
//	void setup () {
//		htmlReporter = new ExtentHtmlReporter ("C:\\New folder\\repo.html");
//		htmlReporter.config().setDocumentTitle("my title");
//		htmlReporter.config().setReportName("my report");
//		htmlReporter.config().setTheme(Theme.STANDARD);
//		
//		report.attachReporter(htmlReporter);
//		
//		
//	}
}
