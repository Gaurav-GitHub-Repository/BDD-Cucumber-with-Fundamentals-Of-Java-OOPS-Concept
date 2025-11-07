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

public class TestCase20 {

	private WebDriver driver;
	static Logger log = Logger.getLogger(TestCase20.class);

    @Given("Launch browser and navigate to application_13")
    public void launch_browser_and_navigate_to_application_13() {
		BrowserConfiguration config =  new BrowserConfiguration();
		config.setup();	
		driver = config.driver;
		Assert.assertEquals(driver.getTitle(), "Swag Labs");
    }
    @When("Enter valid username_13")
    public void enter_valid_username_13(DataTable dataTable) throws IOException {
		List<Map<String,String>> credentials = dataTable.asMaps(String.class,String.class);
		for(Map<String,String> row : credentials)
		{
			String username = row.get("Username");
			Login login = new Login(driver);
			login.verifyUsername(username);
			Assert.assertTrue(login.flag);
		}        
    }
    @When("Enter valid password_13")
    public void enter_valid_password_13(DataTable dataTable) throws IOException {
		List<Map<String,String>> credentials = dataTable.asMaps(String.class,String.class);
		for(Map<String,String> row : credentials)
		{
			String password = row.get("Password");
			Login login = new Login(driver);
			login.verifyPassword(password);
			Assert.assertTrue(login.flag);
		}  
    }
    @When("Click on login button_13")
    public void click_on_login_button() {
		Login login = new Login(driver);
		login.verifyLoginButton();
		Assert.assertTrue(login.flag);
    }
    @Then("Add Products to cart and verify number of added product are displayed in the cart \\(Cart Page)")
    public void add_products_to_cart_and_verify_number_of_added_product_are_displayed_in_the_cart_cart_page() throws SocketException {
    	Dashboard2 dashboard2 = new Dashboard2(driver);
    	dashboard2.verifyNumberOfProducts(3);
    //	int[] selectProduct = {1, 4, 6};
    //	dashboard2.verifySpecificProducts(selectProduct);
    	Assert.assertTrue(dashboard2.flag);
    	BrowserConfiguration config =  new BrowserConfiguration();
    	config.close();
    }
}
