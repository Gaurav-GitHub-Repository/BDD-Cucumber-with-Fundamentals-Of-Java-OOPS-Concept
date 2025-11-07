package com.stepdefination;

import io.cucumber.java.en.*;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.log4testng.Logger;

import com.pages.Login;
import com.setup.BrowserConfiguration;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class TestCase8 {

	private WebDriver driver;
	static Logger log = Logger.getLogger(TestCase8.class);

	@Given("Launch browser And Navigate To Application")
	public void launch_browser_And_Navigate_To_Application() {
		BrowserConfiguration config =  new BrowserConfiguration();
		config.setup();	
		driver = config.driver;
		Assert.assertEquals(driver.getTitle(), "Swag Labs");
	}
	@When("Enter valid username_1")
	public void enter_valid_username_1(DataTable dataTable) throws IOException {
		List<Map<String,String>> credentials = dataTable.asMaps(String.class,String.class);
		for(Map<String,String> row : credentials)
		{
			String username = row.get("Username");
			Login login = new Login(driver);
			login.verifyUsername(username);
			Assert.assertTrue(login.flag);
		}    
	}
	@When("Enter valid password_1")
	public void enter_valid_password_1(DataTable dataTable) throws IOException {
		List<Map<String,String>> credentials = dataTable.asMaps(String.class, String.class);
		for(Map<String,String> row : credentials)
		{
			String password = row.get("Password");
			Login login = new Login(driver);
			login.verifyPassword(password);
			Assert.assertTrue(login.flag);
		}
	}
	@When("Click on login button_1")
	public void click_on_login_button_1() throws IOException {
		Login login = new Login(driver);
		login.verifyLoginButton();
		Assert.assertTrue(login.flag);
	}
	@Then("Verify user is on dashboard page_1")
	public void Verify_user_is_on_dashboard_page_1() throws IOException {
		Login login = new Login(driver);
		login.verifyDashboardPage();
		Assert.assertTrue(login.flag);
		BrowserConfiguration config =  new BrowserConfiguration();
		config.close();
	} 
}
