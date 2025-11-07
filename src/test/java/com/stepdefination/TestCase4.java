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

public class TestCase4 {

	private WebDriver driver;
	static Logger log = Logger.getLogger(TestCase4.class);

	@Given("Launch browser And navigate to application")
	public void launch_browser_And_navigate_to_application() {
		BrowserConfiguration config =  new BrowserConfiguration();
		config.setup();	
		driver = config.driver;
		Assert.assertEquals(driver.getTitle(), "Swag Labs");
	}
	@When("enter invalid username")
	public void enter_invalid_username(DataTable dataTable) throws IOException {
		List<Map<String,String>> credentials = dataTable.asMaps(String.class, String.class);
		for(Map<String,String> row : credentials)
		{
			String username = row.get("Username");
			Login login = new Login(driver);
			login.verifyUsername(username);
			Assert.assertTrue(login.flag);
		}
	}
	@When("enter invalid password")
	public void enter_invalid_password(DataTable dataTable) throws IOException {
		List<Map<String,String>> credentials = dataTable.asMaps(String.class,String.class);
		for(Map<String,String> row : credentials)
		{
			String password = row.get("Password");
			Login login = new Login(driver);
			login.verifyPassword(password);	
			Assert.assertTrue(login.flag);
		}
	}
	@When("click on login button")
	public void click_on_login_button() throws IOException {
		Login login = new Login(driver);
		login.verifyLoginButton();
		Assert.assertTrue(login.flag);
	}
	@Then("verify error message <{string}>")
	public void verify_error_message(String expectedErrorMessage) throws IOException {
		Login login = new Login(driver);
		login.verifyPopup();
		Assert.assertTrue(login.flag);
		BrowserConfiguration config =  new BrowserConfiguration();
		config.close();
	} 
}
