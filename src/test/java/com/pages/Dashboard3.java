package com.pages;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.log4testng.Logger;

import com.test.CheckoutBase;

public class Dashboard3 extends CheckoutBase{

	private WebDriver driver;
	private Logger log = Logger.getLogger(Dashboard.class);
	public boolean flag = false;
	ReusableComponents component = new ReusableComponents();

	//Assigning driver
	public Dashboard3(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}

	//=============================Web Elements=================================
	@FindBy(xpath="//div[@class='checkout_info_wrapper']/form/div[1]/input[1]")
	private WebElement firstName;

	@FindBy(xpath="//div[@class='checkout_info_wrapper']/form/div[1]/input[2]")
	private WebElement lastName;

	@FindBy(xpath="//div[@class='checkout_info_wrapper']/form/div[1]/input[3]")
	private WebElement postalCode;

	@FindBy(xpath="//*[text()='Cancel']")
	private WebElement cancelButton;

	@FindBy(xpath="//div[@id='header_container' and @class='header_container']/div[2]/a/*[@role='img']/*")
	private WebElement cartButton;

	@FindBy(xpath="//*[text()='CHECKOUT']")
	private WebElement checkoutButton;

	@FindBy(css="input.btn_primary")
	private WebElement continueButton;

	@FindBy(xpath="//*[text()='Finish']")
	private WebElement finishButton;

	//=============================Implementation===============================

	public void finalize()
	{
		System.out.println("Garbage value is collected");
	}

	@Override
	public boolean verifyUserDetails(String FirstName, String LastName, String PostalCode) {
		try{
			List<WebElement> credentialField = driver.findElements(By.xpath("//div[@class='checkout_info_wrapper']/form/div[1]/div"));
			for(int i=1;i<=credentialField.size();i++)
			{
				if(i==1)
				{
					WebElement credential1 = driver.findElement(By.xpath("//div[@class='checkout_info_wrapper']/form/div[1]/div[1]/input"));
					credential1.sendKeys(FirstName);
					flag=true;
					Assert.assertTrue(true, "First name is entered");
				}
				else if(i==2)
				{
					WebElement credential2 = driver.findElement(By.xpath("//div[@class='checkout_info_wrapper']/form/div[1]/div[2]/input"));
					credential2.sendKeys(LastName);
					flag=true;
					Assert.assertTrue(true, "Last name is entered");
				}
				else if(i==3)
				{
					WebElement credential3 = driver.findElement(By.xpath("//div[@class='checkout_info_wrapper']/form/div[1]/div[3]/input"));
					credential3.sendKeys(PostalCode);
					flag=true;
					Assert.assertTrue(true, "Postal code is entered");
				}
				else if(i==4)
				{
					continue;
				}
				else
				{
					System.out.println("Error Occured");
					Assert.assertTrue(false, "Error Occured");
				}
			}
		}catch(Exception e){
			System.out.println("Exception Occured");
		}finally{
			System.gc();
		}
		return flag;
	}	
	@Override
	public boolean verifyProductDetails(String Product1, String Product4, String Product6) throws IOException, InterruptedException {
		HashMap<String,String> map = new HashMap<String,String>();
		List<WebElement> TotalProducts = driver.findElements(By.xpath("//div[@id='inventory_container' and @class='inventory_container']/div/div"));
		for(int i=1;i<=TotalProducts.size();i++)
		{
			String AddProduct = driver.findElement(By.xpath("//div[@id='inventory_container' and @class='inventory_container']/div/div["+i+"]/div[2]/a/div")).getText();
			String Price = driver.findElement(By.xpath("//div[@id='inventory_container' and @class='inventory_container']/div/div["+i+"]/div[3]/div")).getText();
			if(AddProduct.contains(Product1) && AddProduct.contains(Product4) && AddProduct.contains(Product6))
			{
				map.put(AddProduct, Price);
				component.wait(driver, By.xpath("//div[@id='inventory_container' and @class='inventory_container']/div/div["+i+"]/div[2]/a/div"));
				driver.findElement(By.xpath("//div[@id='inventory_container' and @class='inventory_container']/div/div["+i+"]/div[2]/a/div")).click();
				if(i==TotalProducts.size())
				{
					Dashboard dashboard = new Dashboard(driver);
					dashboard.verifyCartButton();
					Dashboard2 dashboard2 = new Dashboard2(driver);
					dashboard2.verifyCheckoutButton();
					Dashboard3 dashboard3 = new Dashboard3(driver);
					dashboard3.verifyUserDetails("firstName", "lastName", "postalCode");
					continueButton.click();
				}
			}
		}
		return flag;
	}
	@Override
	public boolean verifyContinueButton() {
		if(continueButton.isDisplayed())
		{
			continueButton.click();
			flag=true;
			Assert.assertTrue(true,"Clicked on continue button");
		}
		else
		{
			System.out.println("Continue button is not displayed");
			Assert.assertTrue(false);
			log.error("Continue button is not displayed");
		}
		return flag;
	}
	@Override
	public boolean verifyCancelButton() {
		component.scrollToElement(driver, cancelButton);
		if(cancelButton.isDisplayed())
		{
			cancelButton.click();
			flag=true;
			Assert.assertTrue(true,"Clicked on cancel button");
		}
		else
		{
			System.out.println("Cancel button is not displayed");
			Assert.assertTrue(false);
			log.error("Cancel button is not displayed");
		}
		return flag;
	}
	@Override
	public boolean verifyFinishButton() {
		component.scrollToElement(driver, finishButton);
		if(finishButton.isDisplayed())
		{
			finishButton.click();
			flag=true;
			Assert.assertTrue(true,"Clicked on finish button");
		}
		else
		{
			System.out.println("Finish button is not displayed");
			Assert.assertTrue(false);
			log.error("Finish button is not displayed");
		}
		return flag;
	}
	@Override
	public boolean verifyCheckoutPage() {

		if(driver.getCurrentUrl().equals("https://www.saucedemo.com/checkout-step-one.html"))
		{
			flag=true;
			//Assert syntax
			//Assert.assertTrue("User is on cart page",true);
			log.info("User is on cart page");
		}
		else
		{
			flag=false;
			//Assert.assertTrue("User is not on the cart page",false);
			log.error("User is not on the cart page");
		}
		return false;
	} 
}
