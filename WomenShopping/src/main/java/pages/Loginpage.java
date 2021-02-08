package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import generic.WebActionUtil;

public class Loginpage extends Basepage
{
  @FindBy(linkText="Sign in")
  private WebElement signInLink;
  
  @FindBy(id="email")
  private WebElement emailTextField;
  
  @FindBy(id="passwd")
  private WebElement passwordTextField;
  
  @FindBy(id="SubmitLogin")
  private WebElement signInButton;
  
  @FindBy(linkText="Forgot your password?")
    private WebElement forgotPasswordLink;

  public Loginpage(WebDriver driver,WebActionUtil webActionUtil)
  {
	  super(driver,webActionUtil);
	  
  }
  public void login(String emailID,String emailPassword)
  {
	  webActionUtil.clickOnElement(signInLink);
	  webActionUtil.enterDataUsingJs(emailTextField, emailID);
	  webActionUtil.enterDataUsingJs(passwordTextField, emailPassword);
	  webActionUtil.clickOnElement(signInButton);


  }
    
  
  
  
  
}
