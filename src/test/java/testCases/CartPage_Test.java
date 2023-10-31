package testCases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.CartPage;
import pages.Inventory_Page;
import pages.Login_Page;
import utility.ReadData;

public class CartPage_Test extends TestBase
{
	Login_Page login;
	Inventory_Page invent;
	CartPage cart;
	@BeforeMethod(alwaysRun = true)
	public void setUp() throws IOException
	{
		initialization();
		login = new Login_Page();
		invent = new Inventory_Page();
		cart = new CartPage();
		login.loginToApplication();
		invent.remove2Product();
		invent.ClickCartCount();
	}
	
	@Test(groups = {"retest"})
	public void verifyTitleOfCartTest() throws EncryptedDocumentException, IOException
	{
		String expTitle=ReadData.readExel(0, 5);
		String actTitle=cart.verifyTitleOfCart();
		Assert.assertEquals(expTitle, actTitle);
		Reporter.log("Title = "+actTitle);
	}
	@Test(groups = {"regression"})
	public void verifyURLOfApplicationTest() throws EncryptedDocumentException, IOException 
	{
		String expURL=ReadData.readExel(0, 6);
		String actURL=cart.verifyURLOfApplication();
		Assert.assertEquals(expURL, actURL);
		Reporter.log("URL= "+actURL);
		
	}
	@AfterMethod(alwaysRun = true)
	public void closeBrowser()
	{
		driver.close();
	}

}
