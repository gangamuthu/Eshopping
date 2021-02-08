
package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import generic.WebActionUtil;


public class ProductsListPage extends Basepage
{
	@FindBy(className="producy_img_link")
	private List<WebElement>productsList;
   
	public ProductsListPage(WebDriver driver, WebActionUtil webActionUtil)
	{
		super(driver,webActionUtil);
	}
	
	public void clickOnproduct(String productId)
	{
		for(WebElement product :productsList)
		{
			if(product.getAttribute("href").contains(productId))
			{
				webActionUtil.jsClick(product);
				 break;
			}
		}
	}

	 
	}
	

