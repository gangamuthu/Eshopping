package generic;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebActionUtil
{
	Actions actions;
	WebDriverWait wait;
	WebDriver driver;
	JavascriptExecutor js;

	
	public WebActionUtil(WebDriver driver,long eto)
	{
		this.driver=driver;
		actions = new Actions(driver);
		wait= new WebDriverWait(driver,eto);
	    js=(JavascriptExecutor)driver;

	}
	
  public void enterData(WebElement target, String textToEnter)//Wrapper Methods , user creating this method
  {
	  target.clear();
	  target.sendKeys(textToEnter);
  }
  
    
  public void clickOnElement(WebElement target)
  {
	  	  
	          //WebDriverWait wait= new WebDriverWait(driver,20);
	          wait.until(ExpectedConditions.elementToBeClickable(target));
			  target.click();
	            
  }
  
    public void clickOnImage(WebElement target)
    {
    	 //WebDriverWait wait = new WebDriverWait(driver,20);
    	 wait.until(ExpectedConditions.visibilityOf(target));
    	 target.click();
    }
    
    
    public void moveToElement(WebElement target)
  {
	  	  //Actions actions = new Actions(driver);
	  	  actions.moveToElement(target).perform();
  }
  
  
  public void rightClickOnElement(WebElement target)
  {
  	  //Actions actions = new Actions(driver);
        actions.contextClick(target).perform();
  }
  
  public void doubleclickOnElement(WebElement target)
  {
  	   //Actions actions = new Actions(driver); 
        actions.doubleClick(target).perform();
	  
  }
  
 
  public void jsClick(WebElement target)
  {
	//JavascriptExecutor js=(JavascriptExecutor)driver;//we are using in constructor because of repetition
	 js.executeScript("arguments[0].click();", target);
  }
  
  public void enterDataUsingJs(WebElement target,String text)
  {
		//JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeAsyncScript("arguments[0].value='"+text+"';",target);
  }
  
  public void switchToFrameAndClick(String indexNameOrId, WebElement target)
  {
	  try
	  {
		  int index=Integer.parseInt(indexNameOrId);
		  driver.switchTo().frame(index);
		  	  }
	  catch(NumberFormatException e) {
		          driver.switchTo().frame(indexNameOrId);
	  }
	  target.click();
  }
  
  
  public void selectByTextInListBox(WebElement target,String text)
  {
	  Select select=new Select(target);
	  select.selectByVisibleText(text);
  }
	  
  }
   

  
  





