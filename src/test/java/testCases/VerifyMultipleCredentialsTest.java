package testCases;

import java.io.IOException;

import org.testng.AssertJUnit;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.TestBase;
import pages.Login_Page;
import utility.CaptureScreenShot;
import utility.ReadData;

public class VerifyMultipleCredentialsTest extends TestBase
{
	Login_Page login;
	@BeforeMethod(alwaysRun = true)
	public void setUp() throws IOException
	{
		initialization();
		login = new Login_Page();
	}
	@Test(dataProvider = "credentials")
	public void loginToApplicationWithMultipleDataTest(String un,String pass) throws IOException
	{
		SoftAssert s=new SoftAssert();
		String expURL=ReadData.readExel(0, 2);//(0,2)
		String actURL=login.loginToApplicationWithMultipleData(un, pass);
		AssertJUnit.assertEquals(expURL, actURL);
		s.assertAll();
		Reporter.log("URL after Login = "+actURL);
		
	}
	@DataProvider(name="credentials")
	public Object[][] getData()
	{
		return new Object[][]
				{
			{"standard_user","secret_sauce"},//RU,RP
			{"standard_user1","secret_sauce"},//WU,RP
			{"standard_user","standard_user"},//RU,WP
			{"secret_sauce","secret_sauce"}//WU,WP
			
				};
		
	}
	@AfterMethod(alwaysRun = true)
	public void closeBrowser(ITestResult it) throws IOException
	{
		if(it.FAILURE==it.getStatus())
		{
			CaptureScreenShot.screenshot(it.getName());
		}
		report.flush();
		driver.close();
	}

}
