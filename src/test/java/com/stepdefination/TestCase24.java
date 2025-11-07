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
import com.setup.BrowserConfiguration;

import java.io.IOException;
import java.net.SocketException;
import java.util.List;
import java.util.Map;

public class TestCase24 {

	private WebDriver driver;
	static Logger log = Logger.getLogger(TestCase24.class);

	@Given("Launch browser and navigate to application_17")
	public void launch_browser_and_navigate_to_application_17() {
		BrowserConfiguration config =  new BrowserConfiguration();
		config.setup();	
		driver = config.driver;
		Assert.assertEquals(driver.getTitle(), "Swag Labs");
	}
	@When("Enter valid username_17")
	public void Enter_valid_username_17(DataTable dataTable) throws IOException{
		List<Map<String,String>> credentials = dataTable.asMaps(String.class,String.class);
		for(Map<String,String> row : credentials)
		{
			String username = row.get("Username");
			Login login = new Login(driver);
			login.verifyUsername(username);
			Assert.assertTrue(login.flag);
		}        
	}
	@When("Enter valid password_17")
	public void Enter_valid_password_17(DataTable dataTable) throws IOException {
		List<Map<String,String>> credentials = dataTable.asMaps(String.class,String.class);
		for(Map<String,String> row : credentials)
		{
			String password = row.get("Password");
			Login login = new Login(driver);
			login.verifyPassword(password);
			Assert.assertTrue(login.flag);
		}  
	}
	@When("Click on login button_17")
	public void Click_on_login_button_17() {
		Login login = new Login(driver);
		login.verifyLoginButton();
		Assert.assertTrue(login.flag);
	}
	@Then("Add products to the cart_17")
	public void Add_products_to_the_cart_17() {
		Dashboard dashboard = new Dashboard(driver);
		dashboard.verifyAddToCart();
		Assert.assertTrue(dashboard.flag);
	}
	@Then("Click on cart button_17")
	public void Click_on_cart_button_17() throws IOException, InterruptedException {
		Dashboard dashboard = new Dashboard(driver);
		dashboard.verifyCartButton();
		Assert.assertTrue(dashboard.flag);
	}
	@Then("Click on checkout button_17")
	public void Click_on_checkout_button_17() {
		Dashboard2 dashboard2 = new Dashboard2(driver);
		dashboard2.verifyCheckoutButton();
		Assert.assertTrue(dashboard2.flag);
	}
	@When("Enter user details in \"Checkout: Your Information\" page")
	public void Enter_user_details_in_checkout_page(DataTable dataTable) {
		List<Map<String,String>> credentials = dataTable.asMaps(String.class,String.class);
		for(Map<String, String> row : credentials)
		{
			String firstName = row.get("FirstName");
			String lastName = row.get("LastName");
			String postalCode = row.get("PostalCode");
			Dashboard3 dashboard3 = new Dashboard3(driver);
			dashboard3.verifyUserDetails(firstName, lastName, postalCode);    	
			Assert.assertTrue(dashboard3.flag);
		}
	}
	@Then("Click on cancel button")
	public void click_on_cancel_button() throws SocketException {
		Dashboard3 dashboard3 = new Dashboard3(driver);
		dashboard3.verifyCancelButton();
		Assert.assertTrue(dashboard3.flag);
		BrowserConfiguration config =  new BrowserConfiguration();
		config.close();
	} 
}
