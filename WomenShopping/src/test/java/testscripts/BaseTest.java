package testscripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import generic.AutoConstants;
import generic.CaptureScreenshot;
import generic.WebActionUtil;
import pages.Homepage;
import pages.Loginpage;

public class BaseTest implements AutoConstants
{
	 WebDriver driver;
	 WebActionUtil webActionUtil; 
	 
	@Parameters({"browserName", "appUrl", "implicitTo", "explicitTo"})
			
   @BeforeClass
   public void openApp( @Optional(DEFAULT_BROWSER)String browserName,
		                @Optional(DEFAULT_URL)String appUrl,
		                @Optional(ITO)String implicitTo,
		                @Optional(ETO)String explicitTo)
   {
		if(browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty(CHROME_KEY, CHROME_PATH);
			 driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			System.setProperty(GECKO_KEY, GECKO_PATH);
			 driver = new FirefoxDriver();
		}
		else 
		{
			 throw new IllegalArgumentException();
		
		}
		driver.manage().window().maximize();
		
		long impTO=Long.parseLong(implicitTo);
		long expTO=Long.parseLong(explicitTo);
		driver.manage().timeouts().implicitlyWait(impTO, TimeUnit.SECONDS);
		
		driver.get(appUrl);
    	webActionUtil=new WebActionUtil(driver,expTO); 
		
   }
	@Parameters({"emailId","emailpassword"})
	
	@BeforeMethod
	 
	public void loginToApp( @Optional(DEFAULT_USER)String emailId,
	                          @Optional(DEFAULT_PWD)String emailpassword)
	{
		Loginpage lp=new Loginpage(driver,webActionUtil);
		lp.login(emailId, emailpassword);
	}
	
	@AfterMethod
	
	public void logout(ITestResult result)
	{
		if(result.getStatus()==ITestResult.FAILURE)// ITestResult is a interface and it will take the screenshot
		{
			CaptureScreenshot.getImage(driver, result.getName());
		}
		  Homepage hp = new Homepage(driver, webActionUtil);
		  hp.signOut();
			}
	
	@AfterClass
	public void closeApp()
	{
		driver.quit();
		
	}
	
   }
