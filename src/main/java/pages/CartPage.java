package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class CartPage extends TestBase
{
	
	@FindBy(xpath = "//span[@class='title']") private WebElement titleOfCart;
	@FindBy(xpath = "//button[@id='checkout']") private WebElement checkoutBtn;
	
	public CartPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String verifyTitleOfCart()
	{
		return titleOfCart.getText();
		
	}
	public String verifyURLOfApplication()
	{
		return driver.getCurrentUrl();
		
	}
	
	public void clickCheckoutBtn()
	{
		checkoutBtn.click();
	}

}
