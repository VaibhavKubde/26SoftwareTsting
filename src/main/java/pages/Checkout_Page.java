package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class Checkout_Page extends TestBase
{
	@FindBy(xpath = "//input[@id='first-name']") private WebElement firstNameTxt;
	@FindBy(xpath = "//input[@id='last-name']") private WebElement LastNameTxt;
	@FindBy(xpath = "//input[@id='postal-code']") private WebElement zipCodeTxt;
	@FindBy(xpath = "//input[@id='continue']") private WebElement continueBtn;
	public Checkout_Page()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String verifyURLOfApplication()
	{
		return driver.getCurrentUrl();
		
	}
	public String inputInfo()
	{
		firstNameTxt.sendKeys("Harry");
		LastNameTxt.sendKeys("Potter");
		zipCodeTxt.sendKeys("444444");
		continueBtn.click();
		return driver.getCurrentUrl();
		
	}


}
