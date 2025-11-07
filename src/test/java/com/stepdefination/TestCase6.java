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

public class TestCase6 {

	private WebDriver driver;
	static Logger log = Logger.getLogger(TestCase6.class);

	@Given("Launch browser and Navigate to application")
	public void Launch_browser_and_Navigate_to_application() {
		BrowserConfiguration config =  new BrowserConfiguration();
		config.setup();	
		driver = config.driver;
		Assert.assertEquals(driver.getTitle(), "Swag Labs");
	}
	@When("Enter Valid username")
	public void Enter_Valid_username(DataTable dataTable) throws IOException {
		List<Map<String,String>> credentials = dataTable.asMaps(String.class, String.class);
		for(Map<String,String> row : credentials)
		{
			String username = row.get("Username");
			Login login = new Login(driver);
			login.verifyUsername(username);
			Assert.assertTrue(login.flag);
		}
	}
	@When("Enter Special Characters in password")
	public void Enter_Special_Characters_in_password(DataTable dataTable) throws IOException {
		List<Map<String,String>> credentials = dataTable.asMaps(String.class,String.class);
		for(Map<String,String> row : credentials)
		{
			String password = row.get("Password");
			Login login = new Login(driver);
			login.verifyPassword(password);	
			Assert.assertTrue(login.flag);
		}    
	}
	@When("Click On Login Button")
	public void Click_On_Login_Button() throws IOException {
		Login login = new Login(driver);
		login.verifyLoginButton();
		Assert.assertTrue(login.flag);
	}
	@Then("Verify Error message <{string}>")
	public void Verify_Error_message(String expectedErrorMessage) throws IOException {
		Login login = new Login(driver);
		login.verifyPopup();
		Assert.assertTrue(login.flag);
		BrowserConfiguration config =  new BrowserConfiguration();
		config.close();
	}
}
