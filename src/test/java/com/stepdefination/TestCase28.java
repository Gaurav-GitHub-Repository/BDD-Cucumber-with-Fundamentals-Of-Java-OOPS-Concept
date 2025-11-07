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

public class TestCase28 {

	private WebDriver driver;
	static Logger log = Logger.getLogger(TestCase28.class);
	
    @Given("Launch browser and navigate to application_21")
    public void Launch_browser_and_navigate_to_application_21() {
		BrowserConfiguration config =  new BrowserConfiguration();
		config.setup();	
		driver = config.driver;
		Assert.assertEquals(driver.getTitle(), "Swag Labs");
    }
    @When("Enter valid username_21")
    public void enter_valid_username_21(DataTable dataTable) throws IOException {
		List<Map<String,String>> credentials = dataTable.asMaps(String.class,String.class);
		for(Map<String,String> row : credentials)
		{
			String username = row.get("Username");
			Login login = new Login(driver);
			login.verifyUsername(username);
			Assert.assertTrue(login.flag);
		}
    }
    @When("Enter valid password_21")
    public void enter_valid_password_21(DataTable dataTable) throws IOException {
		List<Map<String,String>> credentials = dataTable.asMaps(String.class,String.class);
		for(Map<String,String> row : credentials)
		{
			String password = row.get("Password");
			Login login = new Login(driver);
			login.verifyPassword(password);
			Assert.assertTrue(login.flag);
		}  
    }
    @When("Click on login button_21")
    public void click_on_login_button_21() {
		Login login = new Login(driver);
		login.verifyLoginButton();
		Assert.assertTrue(login.flag);
    }
    @Then("Add products to the cart_21")
    public void add_products_to_the_cart_21() {
		Dashboard dashboard = new Dashboard(driver);
		dashboard.verifyAddToCart();
		Assert.assertTrue(dashboard.flag);
    }
    @Then("Click on cart button_21")
    public void click_on_cart_button_21() throws IOException, InterruptedException {
		Dashboard dashboard = new Dashboard(driver);
		dashboard.verifyCartButton();
		Assert.assertTrue(dashboard.flag);
    }
    @Then("Click on checkout button_21")
    public void click_on_checkout_button_21() {
		Dashboard2 dashboard2 = new Dashboard2(driver);
		dashboard2.verifyCheckoutButton();
		Assert.assertTrue(dashboard2.flag);
    }
    @When("Enter checkout details_21")
    public void enter_checkout_details_21(DataTable dataTable) {
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
    @When("Click on continue button_21")
    public void click_on_continue_button_21() {
		Dashboard3 dashboard3 = new Dashboard3(driver);
		dashboard3.verifyContinueButton();
		Assert.assertTrue(dashboard3.flag);
    }
    @When("Click on finish button_21")
    public void Click_on_finish_button_21() {
    	Dashboard3 dashboard3 = new Dashboard3(driver);
    	dashboard3.verifyFinishButton();
    	Assert.assertTrue(dashboard3.flag);
    }
    @Then("Verify order dispatch message <{string}>")
    public void verify_order_dispatch_message(String string) {
    	Logout logout = new Logout(driver);
    	logout.verifyOrderDispatchMessage();
    	Assert.assertTrue(logout.flag);
    }
    @Then("Click on logout button")
    public void click_on_logout_button() throws SocketException {
    	Logout logout = new Logout(driver);
    	logout.verifyLogoutButton();
    	BrowserConfiguration config =  new BrowserConfiguration();
    	config.close();
    }
}
