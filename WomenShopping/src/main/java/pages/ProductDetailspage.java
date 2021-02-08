package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import generic.WebActionUtil;

public class ProductDetailspage extends Basepage
{
   public ProductDetailspage(WebDriver driver, WebActionUtil webActionUtil) {
		super(driver, webActionUtil);
		// TODO Auto-generated constructor stub
	}

@FindBy(className="icon-plus")
   private WebElement plusIcon;
   
   @FindBy(id="group_1")
   private WebElement sizeListBox;
   
   @FindBy(xpath="//ul[@id='color_to_pick_list']//a")
   private List<WebElement>colorList;
   
   @FindBy(name="Submit")
   private WebElement addToKartButton;
   
   @FindBy(xpath="//al[@title='proceed to checkout']")
   private WebElement proceedToCheckoutButton;
  
    @FindBy(xpath="//a[@title='Proceed to checkouut']")
    private WebElement ProceedToCheckoutButton;
    
    public void increaseQuantity(int count)
  {
	  for(int i=1;i<=count;i++)
	  {
		  webActionUtil.clickOnElement(plusIcon);
	  }
  }
	  public void selectSize(String sizeText)
	  {
		   webActionUtil.selectByTextInListBox(sizeListBox,sizeText);
	  }
	  
	  public void selectColor(String colorName)
	  {
		  for(WebElement colorLink:colorList)
		  {
			  if(colorLink.getAttribute("name").contains(colorName))
			  {
				  colorLink.click();
			  }
		  }
	  
	  }
			  
			  
	  public void clickOnAddToKart()
	  {
		  webActionUtil.clickOnElement(addToKartButton);
		  
	  }
	  public void clickOnproceedToCheckout()
	  {
		  webActionUtil.clickOnElement(ProceedToCheckoutButton);
		  
	  }
  }
   

