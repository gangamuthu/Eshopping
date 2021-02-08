package generic;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class CaptureScreenshot 
{
	public static String getImage(WebDriver driver,String testName) 
{

	TakesScreenshot ts= (TakesScreenshot)driver;
	File srcFile = ts.getScreenshotAs(OutputType.FILE);
	
	String path= AutoConstants.IMAGE_PATH + testName;
	File destFile= new File(path);
	
	try {
		FileUtils.copyFile(srcFile, destFile);
		return path;
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		
		return null;
	}
	
	
}
}
