package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import generic.WebActionUtil;

public class Basepage
{
	WebDriver driver;
	WebActionUtil webActionUtil;
	
	public Basepage(WebDriver driver, WebActionUtil webActionUtil)
	{
		this.driver=driver;
		this.webActionUtil=webActionUtil;
		PageFactory.initElements(driver, this);
	}
}
