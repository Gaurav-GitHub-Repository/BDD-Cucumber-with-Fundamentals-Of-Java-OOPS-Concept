package com.stepdefination;

import io.cucumber.java.en.*;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.log4testng.Logger;

import com.pages.Dashboard;
import com.pages.Login;
import com.setup.BrowserConfiguration;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class TestCase13 {

	private WebDriver driver;
	static Logger log = Logger.getLogger(TestCase13.class);

	@Given("Launch browser and navigate to application_6")
	public void launch_browser_and_navigate_to_application_6() {
		BrowserConfiguration config =  new BrowserConfiguration();
		config.setup();	
		driver = config.driver;
		Assert.assertEquals(driver.getTitle(), "Swag Labs");
	}
	@When("Enter valid username_6")
	public void enter_valid_username_6(DataTable dataTable) throws IOException {
		List<Map<String,String>> credentials = dataTable.asMaps(String.class,String.class);
		for(Map<String,String> row : credentials)
		{
			String username = row.get("Username");
			Login login = new Login(driver);
			login.verifyUsername(username);
			Assert.assertTrue(login.flag);
		}            
	}
	@When("Enter valid password_6")
	public void enter_valid_password_6(DataTable dataTable) throws IOException {
		List<Map<String,String>> credentials = dataTable.asMaps(String.class, String.class);
		for(Map<String,String> row : credentials)
		{
			String password = row.get("Password");
			Login login = new Login(driver);
			login.verifyPassword(password);
			Assert.assertTrue(login.flag);
		}
	}
	@When("Click on login button_6")
	public void click_on_login_button_6() {
		Login login = new Login(driver);
		login.verifyLoginButton();
		Assert.assertTrue(login.flag);
	}
	@Then("Select price \\(low to high)")
	public void select_price_low_to_high(DataTable dataTable) {
		List<Map<String,String>> dropdown = dataTable.asMaps(String.class,String.class);
		for(Map<String,String> value:dropdown)
		{
			String selectDropdown = value.get("Dropdown");
			Dashboard dashboard = new Dashboard(driver);
			dashboard.verifyPriceDropdown(selectDropdown);
			Assert.assertTrue(dashboard.flag);
		}
	}
	@Then("Add all products to cart")
	public void add_all_products_to_cart() {
		Dashboard dashboard = new Dashboard(driver);
		dashboard.verifyAddToCart();
		Assert.assertTrue(dashboard.flag);
	}
	@Then("Click on cart button")
	public void click_on_cart_button() throws IOException, InterruptedException{
		Dashboard dashboard = new Dashboard(driver);
		dashboard.verifyCartButton();
		Assert.assertTrue(dashboard.flag);
	}
	@Then("Verify added product details")
	public void verify_added_product_details() throws IOException {
		Dashboard dashboard = new Dashboard(driver);
		dashboard.verifyProductDetails();
		Assert.assertTrue(dashboard.flag);
		BrowserConfiguration config =  new BrowserConfiguration();
		config.close();
	} 
}
