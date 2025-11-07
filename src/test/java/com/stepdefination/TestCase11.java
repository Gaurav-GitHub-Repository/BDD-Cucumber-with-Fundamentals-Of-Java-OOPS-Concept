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

public class TestCase11 {

	private WebDriver driver;
	static Logger log = Logger.getLogger(TestCase11.class);

	@Given("Launch browser and navigate to application_4")
	public void Launch_browser_and_navigate_to_application_4() {
		BrowserConfiguration config =  new BrowserConfiguration();
		config.setup();	
		driver = config.driver;
		Assert.assertEquals(driver.getTitle(), "Swag Labs");
	}
	@When("Enter blank username_4")
	public void Enter_blank_username_4(DataTable dataTable) throws IOException {
		List<Map<String,String>> credentials = dataTable.asMaps(String.class,String.class);
		for(Map<String,String> row : credentials)
		{
			String username = row.get("Username");
			Login login = new Login(driver);
			login.verifyUsername(username);
			Assert.assertTrue(login.flag);
		}        
	}
	@When("Enter blank password_4")
	public void Enter_blank_password_4(DataTable dataTable) throws IOException {
		List<Map<String,String>> credentials = dataTable.asMaps(String.class, String.class);
		for(Map<String,String> row : credentials)
		{
			String password = row.get("Password");
			Login login = new Login(driver);
			login.verifyPassword(password);
			Assert.assertTrue(login.flag);
		}
	}
	@When("Click on login button_4")
	public void Click_on_login_button_4() throws IOException {
		Login login = new Login(driver);
		login.verifyLoginButton();
		Assert.assertTrue(login.flag);
	}
	@Then("Verify error message_4 <{string}>")
	public void Verify_error_message_4(String expectedErrorMessage) throws IOException {
		Login login = new Login(driver);
		login.verifyPopup2();
		Assert.assertTrue(login.flag);
		BrowserConfiguration config =  new BrowserConfiguration();
		config.close();
	} 
}
