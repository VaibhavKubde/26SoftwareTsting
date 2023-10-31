package testCases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.CartPage;
import pages.Checkout_Complete_Page;
import pages.Checkout_Page;
import pages.Checkout_Page_2;
import pages.Inventory_Page;
import pages.Login_Page;
import utility.ReadData;

public class Checkout_Complete_Page_Test extends TestBase
{
	Login_Page login;
	Inventory_Page invent;
	CartPage cart;
	Checkout_Page check;
	Checkout_Page_2 check2;
	Checkout_Complete_Page check3;
	
	@BeforeMethod(alwaysRun = true)
	public void setUp() throws IOException
	{
		initialization();
		login = new Login_Page();
		invent = new Inventory_Page();
		cart = new CartPage();
		check = new Checkout_Page();
		check2 = new Checkout_Page_2();
		check3 = new Checkout_Complete_Page();
		login.loginToApplication();
		invent.remove2Product();
		invent.ClickCartCount();
		cart.clickCheckoutBtn();
		check.inputInfo();
		check2.clickFinishBtn();
	}
	@Test(groups = {"sanity"})
	public void verifycheckoutCompleteLableTest() throws EncryptedDocumentException, IOException
	{

		String expLable=ReadData.readExel(0, 11);
		String actLable=check3.verifycheckoutCompleteLable();
		AssertJUnit.assertEquals(expLable, actLable);
		Reporter.log("Lable of Page= "+actLable);
	}
	@Test(groups = {"regression"})
	public void verifycheckImgTest()
	{
		boolean exp=true;
		boolean act=check3.verifycheckImg();
		AssertJUnit.assertEquals(exp, act);
		
	}
	@Test(groups = {"regression"})
	public void verifythankUTxtTest() throws EncryptedDocumentException, IOException
	{
		String expTxt=ReadData.readExel(0, 12);
		String actTxt=check3.verifythankUTxt();
		AssertJUnit.assertEquals(expTxt, actTxt);
		Reporter.log("Thank U Text= "+actTxt);
		
	}
	@Test(groups = {"retest","sanity"})
	public void verifyURLTest() throws EncryptedDocumentException, IOException
	{
		String expUrl=ReadData.readExel(0, 13);
		String atUrl=check3.verifyURL();
		AssertJUnit.assertEquals(expUrl, atUrl);
		Reporter.log("URL Of Page = "+atUrl);
	}
	
	@AfterMethod(alwaysRun = true)
	public void closeBrowser()
	{
		check3.clickbackToHomeBtn();
		driver.close();
	}

}
