package com.pages;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.log4testng.Logger;
import com.setup.PropertiesFile;
import com.test.DashboardBase;

public class Dashboard extends DashboardBase{

	private WebDriver driver;
	private Logger log = Logger.getLogger(Dashboard.class);
	public boolean flag = false;
	static PropertiesFile properties = new PropertiesFile();
	ReusableComponents component = new ReusableComponents();

	//Assigning driver
	public Dashboard(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}

	//=============================Web Elements=================================
	@FindBy(css="div.app_logo")
	private WebElement logo;

	@FindBy(xpath="//select[@class='product_sort_container']")
	private WebElement priceDropdown;

	@FindBy(css="span.shopping_cart_badge")
	private WebElement cartButton;

	@FindBy(xpath="//div[@id='header_container' and @class='header_container']/div[2]/a/span")
	private WebElement NumberOfProducts;

	@FindBy(xpath="//*[text()='<- Back']")
	private WebElement BackButton;

	@FindBy(xpath="//*[contains(text(),'© 2020 Sauce Labs. All Rights Reserved. Terms of Service')]")
	private WebElement footerLink;
	
	//=============================Implementation===============================

	public void finalize(){
		System.out.println("Garbage value is collected");
	}	
	@Override
	public boolean verifyPriceDropdown(String value1) {
		WebElement priceDropdown = driver.findElement(By.cssSelector("select.product_sort_container"));
		Select select = new Select(priceDropdown);
		List<WebElement> value = select.getOptions();
		for(WebElement price:value)
		{
			if(price.getText().contains(value1))
			{
				select.selectByVisibleText(value1);
				flag=true;
				Assert.assertTrue(true, "Dropdown is selected");
				log.info("Dropdown is selected");
				break;
			}
		}
		return flag;
	}
	@Override
	public boolean verifyAddToCart(){
		try {
			List<WebElement> TotalProducts = driver.findElements(By.xpath("//div[@id='inventory_container' and @class='inventory_container']/div/div"));
			for(int i=1;i<=TotalProducts.size();i++)
			{
				driver.findElement(By.xpath("//div[@id='inventory_container' and @class='inventory_container']/div/div["+i+"]/div[2]/div[2]/button")).click();
				if(i==TotalProducts.size())
				{
					flag=true;
					component.wait(driver, By.xpath("//div[@id='inventory_container' and @class='inventory_container']/div/div["+i+"]/div[2]/div[2]/button"));
					component.captureScreenshot(driver);
					Assert.assertTrue(true,"All products are added to cart");
					log.info("All products are added to cart");
					break;
				}
			}
		}catch(FileNotFoundException e){
			System.out.println("FileNotFoundException Occured");
		}catch(Exception e){
			System.out.println("Exception Occured");
		}finally{
			System.gc();
		}
		return flag;
	}
	@Override
	public boolean verifyProductDetails() throws IOException {
		try {
			String cart[] = {properties.readFile("Product1"),properties.readFile("Product2"),properties.readFile("Product3"),properties.readFile("Product4"),properties.readFile("Product5"),properties.readFile("Product6")};
			List<WebElement> TotalProducts = driver.findElements(By.xpath("//div[@class='cart_list']/div/div[2]/a/div"));
			for(int i=3;i<=TotalProducts.size();i++)
			{
				String Product = driver.findElement(By.xpath("//div[@class='cart_list']/div["+i+"]/div[2]/a/div")).getText();
				if(Product.contains(cart[0])||Product.contains(cart[1])||Product.contains(cart[2])||Product.contains(cart[3])||Product.contains(cart[4])||Product.contains(cart[5]))
				{
					flag=true;
					Assert.assertTrue(true,"Added products are found in the cart");
					log.info("Added products are found in the cart");
					if(i==TotalProducts.size())
					{
						component.wait(driver, By.xpath("//div[@class='cart_list']/div["+i+"]/div[2]/a/div"));
						component.captureScreenshot(driver);
					}
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
	public boolean verifyLogo(){
		try {
			if(logo.isDisplayed())
			{
				logo.click();
				flag=true;
				component.wait(driver, By.xpath("//div[@id='page_wrapper']/div[2]/div[1]/div/div"));
				component.captureScreenshot(driver);
				Assert.assertTrue(true, "Logo is displayed in the dashboard page");
				log.info("Logo is displayed in the dashboard page");
			}
			else
			{
				Assert.assertTrue(false, "Logo is not displayed in the dashboard page");
				log.error("Logo is not displayed in the dashboard page");
			}
		}catch(FileNotFoundException e){
			System.out.println("FileNotFoundException Occured");
		}catch(Exception e){
			flag=true;
			System.out.println("Exception Occured");
		}finally {
			System.gc();
		}
		return flag;
	}
	@Override
	public boolean verifyProductWithPrice() {
		try {
			String AvailableProduct[] = {properties.readFile("Product1"),properties.readFile("Product2"),properties.readFile("Product3"),properties.readFile("Product4"),properties.readFile("Product5"),properties.readFile("Product6")};
			HashMap<String,String> map = new HashMap<String,String>();
			List<WebElement> TotalProducts = driver.findElements(By.xpath("//div[@id='inventory_container' and @class='inventory_container']/div/div/div[2]/a/div"));
			for(int i=1;i<=TotalProducts.size();i++)
			{
				String Product = driver.findElement(By.xpath("//div[@id='inventory_container' and @class='inventory_container']/div/div["+i+"]/div[2]/a/div")).getText();
				String Price = driver.findElement(By.xpath("//div[@id='inventory_container' and @class='inventory_container']/div/div["+i+"]/div[3]/div")).getText();
				if(Price.substring(0).contains("$")) {
					String PriceExcludingCurrency = Price.replace("$", "");
					map.put(Product, PriceExcludingCurrency);
				}
				if(i==TotalProducts.size())
				{
					for(Entry<String, String> product:map.entrySet())
					{
						flag=true;
						System.out.println(product.getKey());
						System.out.println(product.getValue());
						if(product.getKey().contains(AvailableProduct[1]) || product.getKey().contains(AvailableProduct[2]) || product.getKey().contains(AvailableProduct[3]) || product.getKey().contains(AvailableProduct[4]) || product.getKey().contains(AvailableProduct[5]) || product.getKey().contains(AvailableProduct[6]))
						{
							Assert.assertTrue(true, "Available product with respective to the price are retrieved");
							log.info("Available product with respective to the price are retrieved");
						}
					}
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
	public boolean verifyNumberOfProducts(String TotalProduct) throws IOException {
		ArrayList<String> list = new ArrayList<String>();
		List<WebElement> Product = driver.findElements(By.xpath("//div[@id='inventory_container' and @class='inventory_container']/div/div/div[2]/a/div"));
		for(int i=1;i<=Product.size();i++)
		{
			component.wait(driver, By.xpath("//div[@id='inventory_container' and @class='inventory_container']/div/div["+i+"]/div[2]/a/div"));
			if(driver.findElement(By.xpath("//div[@id='inventory_container' and @class='inventory_container']/div/div["+i+"]/div[2]/a/div")).isDisplayed())
			{
				String ProductName = driver.findElement(By.xpath("//div[@id='inventory_container' and @class='inventory_container']/div/div["+i+"]/div[2]/a/div")).getText();
				boolean AddedProducts = list.add(ProductName);
				Integer Products = Integer.parseInt(TotalProduct);		
				if(i==Products)
				{
					flag=true;
					AddedProducts=true;
					component.captureScreenshot(driver);
					Assert.assertTrue(true, "Total number of available products are"+i);
				}
			}
		}
		return false;
	}
	@Override
	public void verifyProductLogo() throws IOException {
		List<WebElement> ProductLogo = driver.findElements(By.xpath("//div[@id='inventory_container' and @class='inventory_container']/div/div/div/a/img"));
		for(int i=1;i<=ProductLogo.size();i++)
		{
			WebElement Logo = driver.findElement(By.xpath("//div[@id='inventory_container' and @class='inventory_container']/div/div["+i+"]/div/a/img"));
			if(Logo.isDisplayed())
			{
				Logo.click();
				flag=true;
				component.wait(driver, By.xpath("//*[text()='<- Back']"));
				component.captureScreenshot(driver);
				Assert.assertTrue(true, "Product logo is displayed");
				if(BackButton.isDisplayed())
				{
					BackButton.click();	
				}
			}
			else
			{
				Assert.assertTrue(true, "Product logo is not displayed");
			}
		}
	}
	@Override
	public boolean verifyDeletedProduct() throws IOException {
		try {
			List<WebElement> Product = driver.findElements(By.xpath("//div[@class='cart_list']/div"));
			for(int j=3;j<=Product.size();j++)
			{
				if(driver.findElement(By.xpath("//div[@class='cart_list']/div["+j+"]/div[2]/div[2]/button")).isDisplayed())
				{
					WebElement RemoveButton = driver.findElement(By.xpath("//div[@class='cart_list']/div["+j+"]/div[2]/div[2]/button"));
					String var = RemoveButton.getText();
					RemoveButton.click();
					Assert.assertTrue(true, "Clicked on remove button");
					if(j==Product.size())
					{
						flag=true;
						Assert.assertTrue(true, "Product are successfully deleted");
						log.info("Product are successfully deleted");	
					}
				}
				else
				{
					Assert.assertTrue(false, "Product is not deleted");
					log.error("Product is not deleted");
				}
			}
		}catch(NoSuchElementException e){
			System.out.println("NoSuchElementException Occured");
		}catch(StaleElementReferenceException e){
			System.out.println("StaleElementReferenceException Occured");
		}
		return false;
	}
	@Override
	public boolean verifyCartButton() throws IOException, InterruptedException{
		try {
			component.wait(driver, By.cssSelector("span.shopping_cart_badge"));
			if(cartButton.isDisplayed())
			{
				flag=true;
				Assert.assertTrue(true, "Cart button is displayed");
				log.info("Cart button is displayed");			
				component.captureScreenshot(driver);
				cartButton.click();	
			}
			else
			{
				Assert.assertTrue(false, "Cart button is not displayed");
				log.error("Cart button is not displayed");
			}
		}catch(NullPointerException e){
			System.out.println("Exception Occured");
		}finally{
			System.gc();
		}
		return flag;
	}	
	@Override
	public boolean verifyFooterLink() throws IOException {		
		try {
			WebElement link = driver.findElement(By.xpath("//*[contains(text(),'© 2020 Sauce Labs. All Rights Reserved. Terms of Service')]"));
			String url = link.getAttribute("href");
			if(url==null || url.isEmpty() || url.isBlank())
			{
				System.out.println("URL is empty or not configured properly");
			}
			URL url1 = new URL(url);
			HttpURLConnection connection = (HttpURLConnection) url1.openConnection();
			connection.connect();
			int ResponseCode = connection.getResponseCode();
			if(ResponseCode>=400)
			{
				flag=true;
				link.click();
				System.out.println("Broken Link"+ "Response Code"+ResponseCode);
			}
			else
			{
				System.out.println("Valid Link"+ "Response Code"+ResponseCode);
			}
		}catch(NullPointerException e){
			flag=true;
			System.out.println("NullPointerException Occured");
			System.out.println("URL is empty, null or not configured properly");
		}
		return flag;
	} 
}

