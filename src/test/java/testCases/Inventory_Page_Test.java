package testCases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.Inventory_Page;
import pages.Login_Page;
import utility.CaptureScreenShot;
import utility.ReadData;

public class Inventory_Page_Test extends TestBase
{
	Inventory_Page invent;
	Login_Page login;
	@BeforeMethod(alwaysRun = true)
	public void setUp() throws IOException
	{
		initialization();
		invent = new Inventory_Page();
		login = new Login_Page();
		login.loginToApplication();
	}
	@Test(groups = {"regression"})
	public void add6ProductTest() throws EncryptedDocumentException, IOException
	{
		String expCount=ReadData.readExel(0, 3);
		String actCount=invent.add6Product();
		Assert.assertEquals(expCount, actCount);
		Reporter.log("Count= "+actCount);
		
	}
	@Test(groups = {"regression"})
	public void remove2ProductTest() throws EncryptedDocumentException, IOException
	{
		String expCount=ReadData.readExel(0,3);//(0,4)
		String actCount=invent.remove2Product();
		Assert.assertEquals(expCount, actCount);
		Reporter.log("Count after Remove"+actCount);
	}
	@AfterMethod(alwaysRun = true)
	public void closeBrowser(ITestResult it) throws IOException
	{
		if(it.FAILURE==it.getStatus())
		{
			CaptureScreenShot.screenshot(it.getName());
		}
		driver.close();
	}

}
