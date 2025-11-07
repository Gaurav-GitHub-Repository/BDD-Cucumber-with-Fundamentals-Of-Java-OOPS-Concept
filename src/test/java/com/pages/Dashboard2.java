package com.pages;

import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.log4testng.Logger;
import com.test.CartBase;

public class Dashboard2 extends CartBase{

	private WebDriver driver;
	private Logger log = Logger.getLogger(Dashboard.class);
	public boolean flag = false;
	ReusableComponents component = new ReusableComponents();

	//Assigning driver
	public Dashboard2(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}

	//=============================Web Elements=================================
	@FindBy(xpath="//div[@id='header_container' and @class='header_container']/div[2]/a/*[@role='img']/*")
	private WebElement cartButton;

	@FindBy(xpath="//*[text()='Continue Shopping']")
	private WebElement continueShoppingButton;
	
	@FindBy(xpath="//*[text()='Checkout']")
	private WebElement checkoutButton;
	
	//=============================Implementation===============================

	public void finalize(){
		System.out.println("Garbage value is collected");
	}	
	@Override
	public boolean verifyNumberOfProducts(int AddProducts){
		try {
			for(int i=1;i<=AddProducts;i++)
			{
				driver.findElement(By.xpath("//div[@id='inventory_container' and @class='inventory_container']/div/div["+i+"]/div[3]/button")).click();
				if(i==AddProducts)
				{
					component.wait(driver, By.xpath("//div[@id='header_container' and @class='header_container']/div[2]/a/span"));
					WebElement cart = driver.findElement(By.xpath("//div[@id='header_container' and @class='header_container']/div[2]/a/span"));
					cart.click();
					WebElement CartDisplay = driver.findElement(By.xpath("//div[@id='header_container' and @class='header_container']/div[2]/a/span"));
					System.out.println(CartDisplay.getText());
					String AddedProducts = String.valueOf(AddProducts);
					if(CartDisplay.getText().equalsIgnoreCase(AddedProducts))
					{
						flag=true;
						//Assert 
						Assert.assertTrue("Added products in the cart are verified", true);	
						log.info("Added products in the cart are verified");
						component.captureScreenshot(driver);
					}
				}
			}
		}catch(Exception e){
			System.out.println("Exception Occured");
		}
		return flag;
	}
	@Override
	public boolean verifyCheckoutButton() {
		component.scrollToElement(driver, checkoutButton);
		if(checkoutButton.isDisplayed())
		{
			component.wait(driver, By.xpath("//*[text()='Checkout']"));
			checkoutButton.click();
			flag=true;
			//Assert
			Assert.assertTrue("Clicked on checkout button", true);
			log.info("Clicked on checkout button");
		}
		else
		{
			Assert.assertTrue("Checkout button is not displayed", false);	
			log.error("Checkout button is not displayed");
		}
		return flag;
	}
	@Override
	public boolean verifyContinueButton() {
		component.scrollToElement(driver,continueShoppingButton);
		if(continueShoppingButton.isDisplayed())
		{
			component.wait(driver, By.xpath("//*[text()='Continue Shopping']"));
			continueShoppingButton.click();
			flag=true;
			//Assert
			Assert.assertTrue("Clicked on continue shopping button", true);
			log.info("Clicked on continue shopping button");
		}
		else
		{
			//Assert
			Assert.assertTrue("Continue shopping button is not displayed", false);	
			log.error("Continue shopping button is not displayed");
		}
		return flag;
	}	
	@Override
	public boolean verifyRemoveButton() throws IOException {
		try {
			Dashboard dashboard = new Dashboard(driver);
			dashboard.verifyDeletedProduct();
		}catch(NoSuchElementException e){
			System.out.println("NoSuchElementException Occured");
		}catch(StaleElementReferenceException e){
			System.out.println("StaleElementReferenceException Occured");
		}
		return false;
	}
	@Override
	public boolean verifyCartPage() {

		if(driver.getCurrentUrl().equals("https://www.saucedemo.com/cart.html"))
		{
			flag=true;
			//Assert syntax
			Assert.assertTrue("User is on cart page",true);
			log.info("User is on cart page");
		}
		else
		{
			flag=false;
			Assert.assertTrue("User is not on the cart page",false);
			log.error("User is not on the cart page");
		}
		return false;
	} 
}
