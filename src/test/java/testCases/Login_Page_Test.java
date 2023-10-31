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
import pages.Login_Page;
import utility.ReadData;

public class Login_Page_Test extends TestBase
{

	Login_Page login;
	@BeforeMethod(alwaysRun = true)
	public void setUp() throws IOException
	{
		initialization();
		login = new Login_Page();
	}
	@Test(priority= 1,groups = {"sanity"})
	public void verifyTitleTest() throws EncryptedDocumentException, IOException
	{
		String expTitle=ReadData.readExel(0, 1);
		String actTitle=login.verifyTitle();
		AssertJUnit.assertEquals(expTitle, actTitle);
		Reporter.log("TItle= "+actTitle);
	}
	@Test(priority = 2,groups = {"sanity"})
	public void verifyURL() throws EncryptedDocumentException, IOException
	{
		String expURL=ReadData.readExel(0, 0);
		String actURL=login.verifyURL();
		AssertJUnit.assertEquals(expURL, actURL);
		Reporter.log("URL= "+actURL);
	}
	@Test(priority = 3,groups = {"regression"})
	public void loginToApplicationTest() throws IOException
	{
		String expURL=ReadData.readExel(0, 2);//(0,2)
		String actURL=login.loginToApplication();
		AssertJUnit.assertEquals(expURL, actURL);
		Reporter.log("URL after Login = "+actURL);
		
	}
	@AfterMethod(alwaysRun = true)
	public void closeBrowser()
	{
		report.flush();
		driver.close();
	}
	
}
