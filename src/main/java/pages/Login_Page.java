package pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import base.TestBase;
import utility.ReadData;

public class Login_Page extends TestBase
{
	@FindBy(xpath = "//input[@id='user-name']") private WebElement usernameTxtBox;
	@FindBy(xpath = "//input[@id='password']") private WebElement passTxtBox;
	@FindBy(xpath = "//input[@id='login-button']") private WebElement loginBtn;
	
	public Login_Page()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String verifyTitle()
	{
		return driver.getTitle();
		
	}
	public String verifyURL()
	{
		return driver.getCurrentUrl();
	}
	
	public String loginToApplication() throws IOException
	{
		logger=report.createTest("Login To SauceLab Application");
	
		usernameTxtBox.sendKeys(ReadData.readPropertyFile("Username"));
		logger.log(Status.INFO, "Username is Entered");
		passTxtBox.sendKeys(ReadData.readPropertyFile("Password"));
		logger.log(Status.INFO, "Password is Entered");
		loginBtn.click();
		logger.log(Status.INFO, "Login Button is Clicked");
		logger.log(Status.PASS, "Login is Successful");
		return driver.getCurrentUrl();
		
	}
	public String loginToApplicationWithMultipleData(String un,String pass)
	{
		usernameTxtBox.sendKeys(un);
		passTxtBox.sendKeys(pass);
		loginBtn.click();
		return driver.getCurrentUrl();
		
	}
	

}
