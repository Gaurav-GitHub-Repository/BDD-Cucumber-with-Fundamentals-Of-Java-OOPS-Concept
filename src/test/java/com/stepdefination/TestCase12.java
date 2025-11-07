package com.stepdefination;

import io.cucumber.java.en.*;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.log4testng.Logger;

import com.pages.Dashboard;
import com.pages.Login;
import com.setup.BrowserConfiguration;

import java.io.IOException;
import java.net.SocketException;
import java.util.List;
import java.util.Map;

public class TestCase12 {

	private WebDriver driver;
	static Logger log = Logger.getLogger(TestCase12.class);

	@Given("Launch browser and navigate to application_5")
	public void launch_browser_and_navigate_to_application_5() {
		BrowserConfiguration config =  new BrowserConfiguration();
		config.setup();	
		driver = config.driver;
		Assert.assertEquals(driver.getTitle(), "Swag Labs");
	}
	@When("Enter valid username_5")
	public void enter_valid_username_5(DataTable dataTable) throws IOException {
		List<Map<String,String>> credentials = dataTable.asMaps(String.class,String.class);
		for(Map<String,String> row : credentials)
		{
			String username = row.get("Username");
			Login login = new Login(driver);
			login.verifyUsername(username);
			Assert.assertTrue(login.flag);
		}            
	}
	@When("Enter valid password_5")
	public void enter_valid_password_5(DataTable dataTable) throws IOException {
		List<Map<String,String>> credentials = dataTable.asMaps(String.class, String.class);
		for(Map<String,String> row : credentials)
		{
			String password = row.get("Password");
			Login login = new Login(driver);
			login.verifyPassword(password);
			Assert.assertTrue(login.flag);
		}
	}
	@When("Click on login button_5")
	public void click_on_login_button_5() {
		Login login = new Login(driver);
		login.verifyLoginButton();
		Assert.assertTrue(login.flag);
	}
	@Then("Verify logo is displayed and click on logo")
	public void Verify_logo_is_displayed_and_click_on_logo() throws SocketException {
		Dashboard dashboard = new Dashboard(driver);
		dashboard.verifyLogo();
		Assert.assertTrue(dashboard.flag);
		BrowserConfiguration config =  new BrowserConfiguration();
		config.close();
	}
}
