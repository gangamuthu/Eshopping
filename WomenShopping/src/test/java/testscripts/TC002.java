package testscripts;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import generic.ExcelLibrary;
import pages.Homepage;
import pages.OrderDetailsPage;
import pages.ProductDetailspage;
import pages.ProductsListPage;

public class TC002  extends BaseTest
	{
		
	@DataProvider
	
	public String[][] getdata()
	{
		return ExcelLibrary.getMultiplendata1(XL_PATH, "Sheet2");
	}
	
	@Test(dataProvider="getdata",description="To verify the Multiple product Added Is Displayed in OTP")
		 
		 public void testProductInODP( String menuName, 
				                        String productId,
				                        String quantity,
				                        String size,
				                        String color)
		 {
						 
			 Homepage hp= new Homepage(driver,webActionUtil);
		     //hp.clickOnMenu("dresses")	;
			 hp.clickOnMenu(menuName);
			 
			 ProductsListPage Plp= new ProductsListPage(driver , webActionUtil);
			// Plp.clickOnproduct("id_Product=5");
			 
			 Plp.clickOnproduct(productId);

			 
			 ProductDetailspage pdp=new ProductDetailspage(driver,webActionUtil);
			 // pdp.increaseQuantity(3);
			  pdp.increaseQuantity((int)Double.parseDouble(quantity));

			  
			// pdp.selectSize("L");
			 pdp.selectSize(size);

			 
			 //pdp.selectColor("Blue");
			 pdp.selectColor(color);

			 
			 pdp.clickOnAddToKart();
	         pdp.clickOnproceedToCheckout();
	         
	         OrderDetailsPage odp=new OrderDetailsPage(driver,webActionUtil);
	         Assert.assertEquals(odp.isProductDisplayed("id_Product=5"), true);
	         // Assert.assertEquals(odp.isProductDisplayed("id_Product=6"), true,"Excepted Product Not Displayed in ODP"); For checking Scenario: invalid product id 

			 }
	}

