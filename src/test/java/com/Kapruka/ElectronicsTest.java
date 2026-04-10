package com.Kapruka;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.kapruka.pagesForElectronics.ElectronicsPOM;
import com.kapruka.pagesForElectronics.babyCokeerPOM;
import com.kapruka.utils.WaitFor;
import com.sourcePackage.BaseClass;

public class ElectronicsTest extends BaseClass

{
	//String title ="Product Removed From Cart";
	
	@Test(priority = 1)
public void verifyTheProductRemoveFromaddTOCart() throws InterruptedException {
	
	ElectronicsPOM electronic=new ElectronicsPOM();

	electronic.clickOnElectronics();
	electronic.mixtureclick();
	//Thread.sleep(2000);
	WaitFor.elementToBeVisible(By.xpath("//button[@id=\"addtocartbutton\"]"));
	electronic.clickonaddtocart();
//	Thread.sleep(2000);
	WaitFor.elementToBeClickable(By.xpath("//a[text()=\"View Cart\"]"));
	electronic.clickonview();
//	Thread.sleep(2000);
	WaitFor.elementToBeClickable(By.xpath("//img[@style=\"max-width: 14px\"]"));
	electronic.deletetheproduct();
	String deleteMsg = electronic.getMsg();
	Assert.assertEquals(deleteMsg, "Product Removed From Cart");
	

}
	@Test(priority = 2)
	public void verifyTheBabyCooker() throws InterruptedException {
		ElectronicsPOM electronic=new ElectronicsPOM();
		electronic.clickOnElectronics();
	//	Thread.sleep(2000);
		babyCokeerPOM cookerprice=new babyCokeerPOM();
		WaitFor.elementToBeVisible(By.xpath("//img[@title=\"Buy singer Panasonic in Sri Lanka\"]"));
		//cookerprice.clickONelectrinicsIcon();
		cookerprice.clickOnCookerr();
	    String prices = cookerprice.displayedPrice();
		Assert.assertEquals(prices, "US$41.66 (₹3,768)");
	}
	public void verifythe() {
		// TODO Auto-generated method stub

	}
}
