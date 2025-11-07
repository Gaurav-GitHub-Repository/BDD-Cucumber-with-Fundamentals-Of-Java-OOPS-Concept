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
import com.pages.Logout;
import com.setup.BrowserConfiguration;

import java.io.IOException;
import java.net.SocketException;
import java.util.List;
import java.util.Map;

public class TestCase30 {

	private WebDriver driver;
	static Logger log = Logger.getLogger(TestCase30.class);

	@Given("Launch browser and navigate to application_23")
	public void Launch_browser_and_navigate_to_application_23() {
		BrowserConfiguration config =  new BrowserConfiguration();
		config.setup();	
		driver = config.driver;
		Assert.assertEquals(driver.getTitle(), "Swag Labs");
	}
	@When("Enter valid username_23")
	public void Enter_valid_username_23(DataTable dataTable) throws IOException {
		List<Map<String,String>> credentials = dataTable.asMaps(String.class,String.class);
		for(Map<String,String> row : credentials)
		{
			String username = row.get("Username");
			Login login = new Login(driver);
			login.verifyUsername(username);
			Assert.assertTrue(login.flag);
		}
	}
	@When("Enter valid password_23")
	public void Enter_valid_password_23(DataTable dataTable) throws IOException {
		List<Map<String,String>> credentials = dataTable.asMaps(String.class,String.class);
		for(Map<String,String> row : credentials)
		{
			String password = row.get("Password");
			Login login = new Login(driver);
			login.verifyPassword(password);
			Assert.assertTrue(login.flag);
		}  
	}
	@When("Click on login button_23")
	public void Click_on_login_button_23() {
		Login login = new Login(driver);
		login.verifyLoginButton();
		Assert.assertTrue(login.flag);
	}
	@Then("Add product to cart_23")
	public void Add_product_to_cart_23() {
		Dashboard dashboard = new Dashboard(driver);
		dashboard.verifyAddToCart();
		Assert.assertTrue(dashboard.flag);
	}
	@Then("Click on cart button_23")
	public void Click_on_cart_button_23() throws IOException, InterruptedException {
		Dashboard dashboard = new Dashboard(driver);
		dashboard.verifyCartButton();
		Assert.assertTrue(dashboard.flag);
	}
	@Then("Verify user is on \"Your Cart\" page_23")
	public void Cerify_user_is_on_your_cart_page_23() {
		Dashboard2 dashboard2 = new Dashboard2(driver);
		dashboard2.verifyCartPage();
		Assert.assertTrue(dashboard2.flag);
	}
	@Then("Click on logout button_23")
	public void Click_on_logout_button_23() throws SocketException {
		Logout logout = new Logout(driver);
		logout.verifyLogoutButton();
		BrowserConfiguration config =  new BrowserConfiguration();
		config.close();
	}
}
