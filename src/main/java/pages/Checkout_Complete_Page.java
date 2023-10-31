package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class Checkout_Complete_Page extends TestBase
{
	@FindBy(xpath ="//span[@class='title']") private WebElement checkoutCompleteLable;
	@FindBy(xpath = "//img[@class='pony_express']") private WebElement checkImg;
	@FindBy(xpath = "//h2[@class='complete-header']") private WebElement thankUTxt;
	@FindBy(xpath = "//button[@id='back-to-products']") private WebElement backToHomeBtn;
	
	public Checkout_Complete_Page()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String verifycheckoutCompleteLable()
	{
		return checkoutCompleteLable.getText();
		
	}
	public boolean verifycheckImg()
	{
		return checkImg.isDisplayed();
		
	}
	public String verifythankUTxt()
	{
		return thankUTxt.getText();
		
	}
	public String verifyURL()
	{
		return driver.getCurrentUrl();
		
	}
	public void clickbackToHomeBtn()
	{
		backToHomeBtn.click();
	}

	
}
