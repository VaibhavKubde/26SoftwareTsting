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
import pages.Checkout_Page_2;
import pages.Inventory_Page;
import pages.Login_Page;
import utility.ReadData;

public class Checkout_Page_2_Test extends TestBase
{
	Login_Page login;
	Inventory_Page invent;
	CartPage cart;
	Checkout_Page check;
	Checkout_Page_2 check2;
	@BeforeMethod(alwaysRun = true)
	public void setUp() throws IOException
	{
		initialization();
		login = new Login_Page();
		invent = new Inventory_Page();
		cart = new CartPage();
		check = new Checkout_Page();
		check2 = new Checkout_Page_2();
		login.loginToApplication();
		invent.remove2Product();
		invent.ClickCartCount();
		cart.clickCheckoutBtn();
		check.inputInfo();
	}
	@Test(groups = {"retest"})
	public void verifycheckoutPageLableTest() throws EncryptedDocumentException, IOException
	{
		String expLable=ReadData.readExel(0, 9);
		String actLable=check2.verifycheckoutPageLable();
		Assert.assertEquals(expLable, actLable);
		Reporter.log(actLable);
		
	}
	@Test(groups = {"sanity"})
	public void verifyTotalTxtTest() throws EncryptedDocumentException, IOException
	{
		String expTxt=ReadData.readExel(0, 10);
		String actTxt=check2.verifyTotalTxt();
		Assert.assertEquals(expTxt, actTxt);
		
	}
	@AfterMethod(alwaysRun = true)
	public void closeBrowser()
	{
		driver.close();
	}

}
