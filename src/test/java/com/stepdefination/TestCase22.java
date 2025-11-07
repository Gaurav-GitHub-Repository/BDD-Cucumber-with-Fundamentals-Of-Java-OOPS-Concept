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
import java.net.SocketException;
import java.util.List;
import java.util.Map;

public class TestCase22 {

	private WebDriver driver;
	static Logger log = Logger.getLogger(TestCase22.class);
	
    @Given("Launch browser and navigate to application_15")
    public void launch_browser_and_navigate_to_application_15() {
		BrowserConfiguration config =  new BrowserConfiguration();
		config.setup();	
		driver = config.driver;
		Assert.assertEquals(driver.getTitle(), "Swag Labs");
    }
    @When("Enter valid username_15")
    public void enter_valid_username_15(DataTable dataTable) throws IOException {
		List<Map<String,String>> credentials = dataTable.asMaps(String.class,String.class);
		for(Map<String,String> row : credentials)
		{
			String username = row.get("Username");
			Login login = new Login(driver);
			login.verifyUsername(username);
			Assert.assertTrue(login.flag);
		}        
    }
    @When("Enter valid password_15")
    public void enter_valid_password_15(DataTable dataTable) throws IOException {
		List<Map<String,String>> credentials = dataTable.asMaps(String.class,String.class);
		for(Map<String,String> row : credentials)
		{
			String password = row.get("Password");
			Login login = new Login(driver);
			login.verifyPassword(password);
			Assert.assertTrue(login.flag);
		}  
    }
    @When("Click on login button_15")
    public void click_on_login_button() {
		Login login = new Login(driver);
		login.verifyLoginButton();
		Assert.assertTrue(login.flag);
    }
    @Then("Add products to the cart_15")
    public void add_products_to_the_cart() throws IOException, InterruptedException {
		Dashboard dashboard = new Dashboard(driver);
		dashboard.verifyAddToCart();
		Assert.assertTrue(dashboard.flag);
    }
    @Then("Click on cart button_15")
    public void click_on_cart_button_15() throws IOException, InterruptedException {
    	Dashboard dashboard = new Dashboard(driver);
    	dashboard.verifyCartButton();
    	Assert.assertTrue(dashboard.flag);
    }
    @Then("Click on continue shopping button")
    public void click_on_continue_shopping_button() throws SocketException {
    	Dashboard2 dashboard2 = new Dashboard2(driver);
    	dashboard2.verifyContinueButton();
    	Assert.assertTrue(dashboard2.flag);
    	BrowserConfiguration config =  new BrowserConfiguration();
    	config.close();
    } 
}
