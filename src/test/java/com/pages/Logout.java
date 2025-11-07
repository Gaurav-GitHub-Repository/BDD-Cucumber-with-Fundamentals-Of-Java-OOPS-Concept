package com.pages;

import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.test.LogoutBase;

public class Logout extends LogoutBase{

	private WebDriver driver;
	private Logger log = Logger.getLogger(Logout.class.toString());
	public boolean flag=false;
	ReusableComponents component = new ReusableComponents();
	
	//Assigning driver
	public Logout(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//======================================Web Elements================================
	@FindBy(xpath="//*[contains(text(),'Your order has been dispatched, and will arrive just as fast as the pony can get there!')]")
	private WebElement dispatchMessage;
	
	@FindBy(css="button#react-burger-menu-btn")
	private WebElement sideBarMenu;
	
	@FindBy(xpath="//*[text()='Logout']")
	private WebElement logoutButton;
	//======================================Implementation==============================
	
	public void finalize()
	{
		System.out.println("Garbage value is collected");
	}
	@Override
	public boolean verifyOrderDispatchMessage() {
		if(dispatchMessage.getText().contains("Your order has been dispatched"))
		{
			flag=true;
			Assert.assertTrue(true, "Product is successfully dispatched");
			log.info("Product is successfully dispatched");
		}
		else
		{
			flag=false;
			Assert.assertTrue(false, "Product is not dispatched");
		}
		return flag;	
	}
	@Override
	public boolean verifyLogoutButton() {
		
		if(sideBarMenu.isDisplayed())
		{
			component.wait(driver, By.cssSelector("button#react-burger-menu-btn"));
			sideBarMenu.click();
			component.wait(driver, By.xpath("//*[text()='Logout']"));
			logoutButton.click();
			flag=true;
			Assert.assertTrue(true, "Clicked on logout button");
		}
		else
		{
			flag=false;
			Assert.assertTrue(false, "Error");
		}
		return flag;
	}
}
