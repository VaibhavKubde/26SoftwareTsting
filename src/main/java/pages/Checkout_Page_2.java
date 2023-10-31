package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class Checkout_Page_2 extends TestBase
{
	@FindBy(xpath = "//span[@class='title']") private WebElement checkoutPageLable;
	@FindBy(xpath = "//div[@class='summary_info_label summary_total_label']") private WebElement totalTxt;
	@FindBy(xpath = "//button[@id='finish']") private WebElement finishBtn;
	
	public Checkout_Page_2()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String verifycheckoutPageLable()
	{
		return checkoutPageLable.getText();
		
	}
	
	public String verifyTotalTxt()
	{
		return totalTxt.getText();
		
	}
	public void clickFinishBtn()
	{
		finishBtn.click();
		
	}
	

}
