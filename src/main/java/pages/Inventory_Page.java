package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;
import utility.HandleDropDown;

public class Inventory_Page extends TestBase
{
	@FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-backpack']") private WebElement addBackpackBtn;
	@FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-bike-light']") private WebElement addBikeLightBtn;
	@FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']") private WebElement addBoltTShirtBtn;
	@FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-fleece-jacket']") private WebElement addJacketBtn;
	@FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-onesie']") private WebElement addOnesieBtn;
	@FindBy(xpath = "//button[@id='add-to-cart-test.allthethings()-t-shirt-(red)']") private WebElement addRedTShirtBtn;
	@FindBy(xpath = "//span[@class='shopping_cart_badge']") private WebElement cartCount;
	@FindBy(xpath = "//button[@id='remove-sauce-labs-bolt-t-shirt']") private WebElement removeBoltTShirtBtn;
	@FindBy(xpath = "//button[@id='remove-sauce-labs-onesie']") private WebElement removeOnesieBtn;
	@FindBy(xpath = "//select[@class='product_sort_container']") private WebElement productSortDropDown;
	
	public Inventory_Page()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String add6Product()
	{
		HandleDropDown.handleSelectClass(productSortDropDown, "Name (Z to A)");
		addBackpackBtn.click();
		addBikeLightBtn.click();
		addBoltTShirtBtn.click();
		addJacketBtn.click();
		addOnesieBtn.click();
		addRedTShirtBtn.click();
		
		return cartCount.getText();
		
	}
	public String remove2Product()
	{
		add6Product();
		removeBoltTShirtBtn.click();
		removeOnesieBtn.click();
		return cartCount.getText();
		
	}
	
	public void ClickCartCount()
	{
		cartCount.click();
	}
	

}
