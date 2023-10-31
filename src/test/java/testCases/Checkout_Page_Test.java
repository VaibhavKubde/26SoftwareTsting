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
import pages.Checkout_Page;
import pages.Inventory_Page;
import pages.Login_Page;
import utility.ReadData;

public class Checkout_Page_Test extends TestBase
{
	Login_Page login;
	Inventory_Page invent;
	CartPage cart;
	Checkout_Page check;
	@BeforeMethod(alwaysRun = true)
	public void setUp() throws IOException
	{
		initialization();
		login = new Login_Page();
		invent = new Inventory_Page();
		cart = new CartPage();
		check = new Checkout_Page();
		login.loginToApplication();
		invent.remove2Product();
		invent.ClickCartCount();
		cart.clickCheckoutBtn();
	}
	@Test(enabled = true,groups = {"sanity"})
	public void verifyURLOfApplicationTest() throws EncryptedDocumentException, IOException
	{
		String expURL=ReadData.readExel(0, 7);
		String actURL=check.verifyURLOfApplication();
		Assert.assertEquals(expURL, actURL);
		Reporter.log("URL= "+actURL);
	}
	@Test(enabled = true, groups = {"retest"})
	public void inputInfoTest() throws EncryptedDocumentException, IOException
	{
		String expURL=ReadData.readExel(0, 8);
		String actURL=check.inputInfo();
		Assert.assertEquals(expURL, actURL);
		Reporter.log("URL= "+actURL);
		
	}
	@AfterMethod(alwaysRun = true)
	public void closeBrowser()
	{
		driver.close();
	}


}
