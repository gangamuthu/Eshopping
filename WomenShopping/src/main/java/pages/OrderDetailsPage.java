 package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import generic.WebActionUtil;

public class OrderDetailsPage extends Basepage
{
	String xpath="//tbody//td//a[contains(@href,'pid')]/../..//i[@class='icon-trash']";
	
	 @FindBy(xpath="//td[@class='cart_product']/a@)")
	 private List<WebElement>productsList;
	 
	 

	public OrderDetailsPage(WebDriver driver, WebActionUtil webActionUtil) {
		super(driver, webActionUtil);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath="//tbody//td[@class='cart_product']/a")
	private List<WebElement>ProductsList;
	
	public boolean isProductDisplayed(String productId)
	{
		for(WebElement product:ProductsList)
		{
			if(product.getAttribute("href").contains(productId))
					{
				       return true;
					}
		}
		return false;
	}

	
	public void deleteProductFromODP(String productId)
	{
		xpath=xpath.replace("pid", productId);
		
		WebElement productTrashIcon=driver.findElement(By.xpath(xpath));
		
		webActionUtil.clickOnElement(productTrashIcon);
		
		}
	
}