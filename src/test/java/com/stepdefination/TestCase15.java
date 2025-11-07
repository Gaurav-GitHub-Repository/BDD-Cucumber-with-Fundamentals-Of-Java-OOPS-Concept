package com.stepdefination;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.log4testng.Logger;

import com.pages.Dashboard;
import com.pages.Login;
import com.setup.BrowserConfiguration;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TestCase15 {

	private WebDriver driver;
	static Logger log = Logger.getLogger(TestCase15.class);

	@Given("Launch browser and navigate to application_8")
	public void launch_browser_and_navigate_to_application_8() {
		BrowserConfiguration config =  new BrowserConfiguration();
		config.setup();	
		driver = config.driver;
		Assert.assertEquals(driver.getTitle(), "Swag Labs");
	}
	@When("Enter valid username_8")
	public void enter_valid_username_8(DataTable dataTable) throws IOException {
		List<String> data = dataTable.column(0);
		String username = data.get(1);
		Login login = new Login(driver);
		login.verifyUsername(username);
		Assert.assertTrue(login.flag);
	}
	@When("Enter valid password_8")
	public void enter_valid_password_8(DataTable dataTable) throws IOException {
		List<String> data = dataTable.column(0);
		String password = data.get(1);
		Login login = new Login(driver);
		login.verifyPassword(password);
		Assert.assertTrue(login.flag);
	}
	@When("Click on login button_8")
	public void click_on_login_button_8() {
		Login login = new Login(driver);
		login.verifyLoginButton();
		Assert.assertTrue(login.flag);
	}
	@Then("Verify number of available products")
	public void Verify_number_of_available_products(DataTable dataTable) throws IOException {
		List<Map<String,String>> Products = dataTable.asMaps(String.class,String.class);
		for(Map<String,String> TotalProduct : Products)
		{
			String Total_Product = TotalProduct.get("TotalProduct");
			Dashboard dashboard = new Dashboard(driver);
			dashboard.verifyNumberOfProducts(Total_Product);
			Assert.assertTrue(dashboard.flag);
			BrowserConfiguration config =  new BrowserConfiguration();
			config.close();
		}        
	}
}
