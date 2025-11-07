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

public class TestCase9 {

	private WebDriver driver;
	static Logger log = Logger.getLogger(TestCase9.class);

	@Given("Launch browser and navigate to application_2")
	public void launch_browser_and_navigate_to_application_2() {
		BrowserConfiguration config =  new BrowserConfiguration();
		config.setup();	
		driver = config.driver;
		Assert.assertEquals(driver.getTitle(), "Swag Labs");
	}
	@When("Enter blank username_2")
	public void enter_blank_username_2(DataTable dataTable) throws IOException {
		List<Map<String,String>> credentials = dataTable.asMaps(String.class,String.class);
		for(Map<String,String> row : credentials)
		{
			String username = row.get("Username");
			Login login = new Login(driver);
			login.verifyUsername(username);
			Assert.assertTrue(login.flag);
		}        
	}
	@When("Enter blank password_2")
	public void enter_blank_password_2(DataTable dataTable) throws IOException {
		List<Map<String,String>> credentials = dataTable.asMaps(String.class, String.class);
		for(Map<String,String> row : credentials)
		{
			String password = row.get("Password");
			Login login = new Login(driver);
			login.verifyPassword(password);
			Assert.assertTrue(login.flag);
		}
	}
	@When("Click on login button_2")
	public void click_on_login_button_2() throws IOException {
		Login login = new Login(driver);
		login.verifyLoginButton();
		Assert.assertTrue(login.flag);
	}
	@Then("Verify close button is displayed in error message <{string}>")
	public void verify_close_button_is_displayed_in_error_message(String expectedError) throws IOException {
		Login login = new Login(driver);
		login.verifyPopup2();
		Assert.assertTrue(login.flag);
	}
	@Then("Click on close button_2")
	public void click_on_close_button_2() throws IOException {
		Login login = new Login(driver);
		login.verifyCloseButton();
		Assert.assertTrue(login.flag);
		BrowserConfiguration config =  new BrowserConfiguration();
		config.close();
	} 
}
