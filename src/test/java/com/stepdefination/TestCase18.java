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

public class TestCase18 {

	private WebDriver driver;
	static Logger log = Logger.getLogger(TestCase18.class);

	@Given("Launch browser and navigate to application_11")
	public void launch_browser_and_navigate_to_application_11() {
		BrowserConfiguration config =  new BrowserConfiguration();
		config.setup();	
		driver = config.driver;
		Assert.assertEquals(driver.getTitle(), "Swag Labs");
	}
	@When("Enter valid username_11")
	public void enter_valid_username_11(DataTable dataTable) throws IOException {
		List<Map<String,String>> credentials = dataTable.asMaps(String.class,String.class);
		for(Map<String,String> row : credentials)
		{
			String username = row.get("Username");
			Login login = new Login(driver);
			login.verifyUsername(username);
			Assert.assertTrue(login.flag);
		}        
	}
	@When("Enter valid password_11")
	public void enter_valid_password_11(DataTable dataTable) throws IOException {
		List<Map<String,String>> credentials = dataTable.asMaps(String.class,String.class);
		for(Map<String,String> row : credentials)
		{
			String password = row.get("Password");
			Login login = new Login(driver);
			login.verifyPassword(password);
			Assert.assertTrue(login.flag);
		}        
	}
	@When("Click on login button_11")
	public void click_on_login_button_11() {
		Login login = new Login(driver);
		login.verifyLoginButton();
		Assert.assertTrue(login.flag);
	}
	@When("Add all products to cart_11")
	public void add_all_products_to_cart_11() throws IOException, InterruptedException {
		Dashboard dashboard = new Dashboard(driver);
		dashboard.verifyAddToCart();
		dashboard.verifyCartButton();
		Assert.assertTrue(dashboard.flag);
	}
	@Then("Verify products are added to cart_11")
	public void verify_products_are_added_to_cart_11() throws IOException {
		Dashboard dashboard = new Dashboard(driver);
		dashboard.verifyProductDetails();
		Assert.assertTrue(dashboard.flag);
	}
	@Then("Click on remove button And verify products are cleared in cart")
	public void Click_on_remove_button_And_verify_products_are_cleared_in_cart() throws IOException {
		Dashboard dashboard = new Dashboard(driver);
		dashboard.verifyDeletedProduct();
		Assert.assertTrue(dashboard.flag);
		BrowserConfiguration config =  new BrowserConfiguration();
		config.close();
	} 
}
