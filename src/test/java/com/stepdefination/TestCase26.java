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

public class TestCase26 {

	private WebDriver driver;
	static Logger log = Logger.getLogger(TestCase26.class);

	@Given("Launch browser and navigate to application_19")
	public void Launch_browser_and_navigate_to_application_19() {
		BrowserConfiguration config =  new BrowserConfiguration();
		config.setup();	
		driver = config.driver;
		Assert.assertEquals(driver.getTitle(), "Swag Labs");
	}
	@When("Enter valid username_19")
	public void Enter_valid_username_19(DataTable dataTable) throws IOException {
		List<Map<String,String>> credentials = dataTable.asMaps(String.class,String.class);
		for(Map<String,String> row : credentials)
		{
			String username = row.get("Username");
			Login login = new Login(driver);
			login.verifyUsername(username);
			Assert.assertTrue(login.flag);
		}
	}
	@When("Enter valid password_19")
	public void Enter_valid_password_19(DataTable dataTable) throws IOException {
		List<Map<String,String>> credentials = dataTable.asMaps(String.class,String.class);
		for(Map<String,String> row : credentials)
		{
			String password = row.get("Password");
			Login login = new Login(driver);
			login.verifyPassword(password);
			Assert.assertTrue(login.flag);
		}  
	}
	@When("Click on login button_19")
	public void Click_on_login_button_19() {
		Login login = new Login(driver);
		login.verifyLoginButton();
		Assert.assertTrue(login.flag);
	}
	@Then("Add products to the cart_19")
	public void Add_products_to_the_cart_19() {
		Dashboard dashboard = new Dashboard(driver);
		dashboard.verifyAddToCart();
		Assert.assertTrue(dashboard.flag);
	}
	@Then("Click on cart button_19")
	public void Click_on_cart_button_19() throws IOException, InterruptedException {
		Dashboard dashboard = new Dashboard(driver);
		dashboard.verifyCartButton();
		Assert.assertTrue(dashboard.flag);
	}
	@Then("Click on checkout button_19")
	public void Click_on_checkout_button_19() {
		Dashboard2 dashboard2 = new Dashboard2(driver);
		dashboard2.verifyCheckoutButton();
		Assert.assertTrue(dashboard2.flag);
	}
	@When("Enter checkout details_19")
	public void Enter_checkout_details_19(DataTable dataTable) {
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
	@When("Click on continue button_19")
	public void Click_on_continue_button_19() {
		Dashboard3 dashboard3 = new Dashboard3(driver);
		dashboard3.verifyContinueButton();
		Assert.assertTrue(dashboard3.flag);
	}
	@Then("Click on cancel button_19")
	public void click_on_cancel_button_19() throws SocketException {
		Dashboard3 dashboard3 = new Dashboard3(driver);
		dashboard3.verifyCancelButton();
		Assert.assertTrue(dashboard3.flag);
		BrowserConfiguration config =  new BrowserConfiguration();
		config.close();
	} 
}
