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
import java.util.List;

public class TestCase14 {

	private WebDriver driver;
	static Logger log = Logger.getLogger(TestCase14.class);

    @Given("Launch browser and navigate to application_7")
    public void launch_browser_and_navigate_to_application_7() {
		BrowserConfiguration config =  new BrowserConfiguration();
		config.setup();	
		driver = config.driver;
		Assert.assertEquals(driver.getTitle(), "Swag Labs");
    }
    @When("Enter valid username_7")
    public void enter_valid_username_7(DataTable dataTable) throws IOException {
        List<String> data = dataTable.column(0);
        String username = data.get(1);
        Login login = new Login(driver);
		login.verifyUsername(username);
		Assert.assertTrue(login.flag);
    }
    @When("Enter valid password_7")
    public void enter_valid_password_7(DataTable dataTable) throws IOException {
        List<String> data = dataTable.column(0);
        String password = data.get(1);
		Login login = new Login(driver);
		login.verifyPassword(password);
		Assert.assertTrue(login.flag);
    }
    @When("Click on login button_7")
    public void click_on_login_button_7() {
		Login login = new Login(driver);
		login.verifyLoginButton();
		Assert.assertTrue(login.flag);
    }
    @Then("Select price \\(high to low)")
    public void select_price_high_to_low(DataTable dataTable) {
    	 List<String> data = dataTable.column(0);
    	 String DropdownValue = data.get(1);
    	 Dashboard dashboard = new Dashboard(driver);
    	 dashboard.verifyPriceDropdown(DropdownValue);
    	 Assert.assertTrue(dashboard.flag);
    }
    @Then("Add all products to cart_7")
    public void add_all_products_to_cart_7() {
    	 Dashboard dashboard = new Dashboard(driver);
    	 dashboard.verifyAddToCart();
    	 Assert.assertTrue(dashboard.flag);
    }
    @Then("Click on cart button_7")
    public void click_on_cart_button_7() throws IOException, InterruptedException {
    	Dashboard dashboard = new Dashboard(driver);
    	dashboard.verifyCartButton();
    	Assert.assertTrue(dashboard.flag);
    }
    @Then("Verify added product details_7")
    public void verify_added_product_details_7() throws IOException {
		Dashboard dashboard = new Dashboard(driver);
		dashboard.verifyProductDetails();
		Assert.assertTrue(dashboard.flag);
		BrowserConfiguration config =  new BrowserConfiguration();
		config.close();
    }
}