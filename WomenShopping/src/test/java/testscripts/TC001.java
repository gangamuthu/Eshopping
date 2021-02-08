package testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import generic.ExcelLibrary;
import pages.Homepage;
import pages.OrderDetailsPage;
import pages.ProductDetailspage;
import pages.ProductsListPage;

public class TC001  extends BaseTest
{

	 @Test(description="To verify the product Added Is Displayed in OTP")
	 
	 public void testProductInODP()
	 {
	 
        String menuName= ExcelLibrary.getdata(XL_PATH,"Sheet1",1,0);
		String ProductId= ExcelLibrary.getdata(XL_PATH,"Sheet1",1,1);
		int quantity=(int)(double)ExcelLibrary.getNumericData(XL_PATH,"Sheet1",1,2);
		String size= ExcelLibrary.getdata(XL_PATH,"Sheet1",1,3);
		String color= ExcelLibrary.getdata(XL_PATH,"Sheet1",1,4);

		 
		 Homepage hp= new Homepage(driver,webActionUtil);
	     //hp.clickOnMenu("dresses")	;
		 hp.clickOnMenu(menuName);
		 
		 ProductsListPage Plp= new ProductsListPage(driver , webActionUtil);
		// Plp.clickOnproduct("id_Product=5");
		 
		 Plp.clickOnproduct(ProductId);

		 
		 ProductDetailspage pdp=new ProductDetailspage(driver,webActionUtil);
		 // pdp.increaseQuantity(3);
		  pdp.increaseQuantity(quantity);

		  
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
