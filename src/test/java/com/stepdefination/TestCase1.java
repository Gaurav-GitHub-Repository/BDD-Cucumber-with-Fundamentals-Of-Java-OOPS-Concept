package com.stepdefination;

import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.log4testng.Logger;
import com.pages.Login;
import com.setup.BrowserConfiguration;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class TestCase1 {

	private WebDriver driver;
	static Logger log = Logger.getLogger(TestCase1.class);

	@Given("Launch browser and navigate to application")
	public void launch_browser_and_navigate_to_application() {		
		BrowserConfiguration config =  new BrowserConfiguration();
		config.setup();	
		driver = config.driver;
		Assert.assertEquals(driver.getTitle(), "Swag Labs");
	}
	@When("Enter valid username")
	public void enter_valid_username(DataTable dataTable) throws IOException {
		List<Map<String,String>> credentials = dataTable.asMaps(String.class, String.class);
		for(Map<String,String> row : credentials)
		{
		  String username = row.get("Username");
		  Login login = new Login(driver);
	      login.verifyUsername(username);
		  Assert.assertTrue(login.flag);
		}
	}
	@When("Enter valid password")
	public void enter_valid_password(DataTable dataTable) throws IOException {
		List<Map<String,String>> credentials = dataTable.asMaps(String.class,String.class);
		for(Map<String,String> row : credentials)
		{
		  String password = row.get("Password");
		  Login login = new Login(driver);
		  login.verifyPassword(password);	
		  Assert.assertTrue(login.flag);
		}
	}
	@And("Click on login button")
	public void click_on_login_button() throws IOException {
		  Login login = new Login(driver);
		  login.verifyLoginButton();
		  Assert.assertTrue(login.flag);
	}
	@Then("Verify user is on dashboard page")
	public void verify_user_is_on_dashboard_page() throws IOException {
		  Login login = new Login(driver);
		  login.verifyDashboardPage();
		  Assert.assertTrue(login.flag);
		  BrowserConfiguration config =  new BrowserConfiguration();
		  config.close();
	}
}
