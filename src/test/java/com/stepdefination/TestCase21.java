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
import com.pages.Dashboard2;
import com.pages.Login;
import com.setup.BrowserConfiguration;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class TestCase21 {

	private WebDriver driver;
	static Logger log = Logger.getLogger(TestCase21.class);

	@Given("Launch browser and navigate to application_14")
	public void launch_browser_and_navigate_to_application_14() {
		BrowserConfiguration config =  new BrowserConfiguration();
		config.setup();	
		driver = config.driver;
		Assert.assertEquals(driver.getTitle(), "Swag Labs");
	}
	@When("Enter valid username_14")
	public void enter_valid_username_14(DataTable dataTable) throws IOException {
		List<Map<String,String>> credentials = dataTable.asMaps(String.class,String.class);
		for(Map<String,String> row : credentials)
		{
			String username = row.get("Username");
			Login login = new Login(driver);
			login.verifyUsername(username);
			Assert.assertTrue(login.flag);
		}        
	}
	@When("Enter valid password_14")
	public void enter_valid_password_14(DataTable dataTable) throws IOException {
		List<Map<String,String>> credentials = dataTable.asMaps(String.class,String.class);
		for(Map<String,String> row : credentials)
		{
			String password = row.get("Password");
			Login login = new Login(driver);
			login.verifyPassword(password);
			Assert.assertTrue(login.flag);
		}  
	}
	@When("Click on login button_14")
	public void click_on_login_button_14() {
		Login login = new Login(driver);
		login.verifyLoginButton();
		Assert.assertTrue(login.flag);
	}
	@Then("Add products to cart_14")
	public void add_products_to_cart_14() throws IOException, InterruptedException {
		Dashboard dashboard = new Dashboard(driver);
		dashboard.verifyAddToCart();
		dashboard.verifyCartButton();
	}
	@Then("Click on remove button and Check if cart is empty")
	public void Click_on_remove_button_and_Check_if_cart_is_empty() throws IOException {
		Dashboard2 dashboard2 = new Dashboard2(driver);
		dashboard2.verifyRemoveButton();
		BrowserConfiguration config =  new BrowserConfiguration();
		config.close();
	}
}
