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
import java.net.SocketException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestCase17 {

	private WebDriver driver;
	static Logger log = Logger.getLogger(TestCase17.class);

	@Given("Launch browser and navigate to application_10")
	public void launch_browser_and_navigate_to_application_10() {
		BrowserConfiguration config =  new BrowserConfiguration();
		config.setup();	
		driver = config.driver;
		Assert.assertEquals(driver.getTitle(), "Swag Labs");
	}
	@When("Enter valid username_10")
	public void enter_valid_username_10(DataTable dataTable) throws IOException {
		List<Map<String,String>> credentials = dataTable.asMaps(String.class,String.class);
		for(Map<String,String> row : credentials)
		{
			String username = row.get("Username");
			Login login = new Login(driver);
			login.verifyUsername(username);
			Assert.assertTrue(login.flag);
		}        
	}
	@When("Enter valid password_10")
	public void enter_valid_password_10(DataTable dataTable) throws IOException {
		List<Map<String,String>> credentials = dataTable.asMaps(String.class,String.class);
		for(Map<String,String> row : credentials)
		{
			String password = row.get("Password");
			Login login = new Login(driver);
			login.verifyPassword(password);
			Assert.assertTrue(login.flag);
		}        
	}
	@When("Click on login button_10")
	public void click_on_login_button_10() {
		Login login = new Login(driver);
		login.verifyLoginButton();
		Assert.assertTrue(login.flag);
	}
	@When("Product name with respective to the price are captured And Check product details are matching with the added product")
	public void Product_name_with_respective_to_the_price_are_captured_And_Check_product_details_are_matching_with_the_added_product() throws SocketException {
		Dashboard dashboard = new Dashboard(driver);
		dashboard.verifyProductWithPrice();
		Assert.assertTrue(dashboard.flag);
		BrowserConfiguration config =  new BrowserConfiguration();
		config.close();
	}
}
