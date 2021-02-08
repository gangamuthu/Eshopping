package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import generic.WebActionUtil;


public class Homepage extends Basepage
{
   
public Homepage(WebDriver driver, WebActionUtil webActionUtil) {
		super(driver, webActionUtil);
		// TODO Auto-generated constructor stub
	}

@FindBy(linkText="Sign out")
   private WebElement signOutLink;
   
   @FindBy(linkText="Women")
   private WebElement womenMenu;
   
   @FindBy(xpath=" (//a[.='sDresses'])[2]")
   private WebElement dressesMenu;
   
   @FindBy(xpath="(//a[.='T-shirts'])[2]")
    private WebElement tShritsMenu;
   
   public void signOut()
   {
	     webActionUtil.clickOnElement(signOutLink);
   }
   
   public void clickOnMenu(String menuName)
   {
	   switch(menuName)
	   {
	   case "women": webActionUtil.clickOnElement(womenMenu);
	                  break;
	   case "dresses": webActionUtil.clickOnElement(dressesMenu);
                       break;
	   case "tshirts": webActionUtil.clickOnElement(tShritsMenu);
	                   break;             
	                  
	                  
	   }
   }
}
