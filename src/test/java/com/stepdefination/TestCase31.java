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
import com.pages.Dashboard3;
import com.pages.Login;
import com.pages.Logout;
import com.setup.BrowserConfiguration;

import java.io.IOException;
import java.net.SocketException;
import java.util.List;
import java.util.Map;

public class TestCase31 {

	private WebDriver driver;
	static Logger log = Logger.getLogger(TestCase31.class);

	@Given("Launch browser and navigate to application_24")
	public void Launch_browser_and_navigate_to_application_24() {
		BrowserConfiguration config =  new BrowserConfiguration();
		config.setup();	
		driver = config.driver;
		Assert.assertEquals(driver.getTitle(), "Swag Labs");
	}
	@When("Enter valid username_24")
	public void Enter_valid_username_24(DataTable dataTable) throws IOException {
		List<Map<String,String>> credentials = dataTable.asMaps(String.class,String.class);
		for(Map<String,String> row : credentials)
		{
			String username = row.get("Username");
			Login login = new Login(driver);
			login.verifyUsername(username);
			Assert.assertTrue(login.flag);
		}
	}
	@When("Enter valid password_24")
	public void Enter_valid_password_24(DataTable dataTable) throws IOException {
		List<Map<String,String>> credentials = dataTable.asMaps(String.class,String.class);
		for(Map<String,String> row : credentials)
		{
			String password = row.get("Password");
			Login login = new Login(driver);
			login.verifyPassword(password);
			Assert.assertTrue(login.flag);
		}  
	}
	@When("Click on login button_24")
	public void Click_on_login_button_24() {
		Login login = new Login(driver);
		login.verifyLoginButton();
		Assert.assertTrue(login.flag);
	}
	@Then("Add product to cart_24")
	public void Add_product_to_cart_24() {
		Dashboard dashboard = new Dashboard(driver);
		dashboard.verifyAddToCart();
		Assert.assertTrue(dashboard.flag);
	}
	@Then("Click on cart button_24")
	public void Click_on_cart_button_24() throws IOException, InterruptedException {
		Dashboard dashboard = new Dashboard(driver);
		dashboard.verifyCartButton();
		Assert.assertTrue(dashboard.flag);
	}
	@Then("Click on checkout button_24")
	public void Click_on_checkout_button_24() {
		Dashboard2 dashboard2 = new Dashboard2(driver);
		dashboard2.verifyCheckoutButton();
		Assert.assertTrue(dashboard2.flag);
	}
	@Then("Verify user is on \"Checkout: Your Information\" page_24")
	public void Verify_user_is_on_checkout_your_information_page_24() {
		Dashboard3 dashboard3 = new Dashboard3(driver);
		dashboard3.verifyCheckoutPage();
		//Assert.assertTrue(dashboard3.flag);
	}
	@Then("Click on logout button_24")
	public void Click_on_logout_button_24() throws SocketException {
		Logout logout = new Logout(driver);
		logout.verifyLogoutButton();
		BrowserConfiguration config =  new BrowserConfiguration();
		config.close();
	} 
}
