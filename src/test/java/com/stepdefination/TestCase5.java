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

public class TestCase5 {

	private WebDriver driver;
	static Logger log = Logger.getLogger(TestCase5.class);

	@Given("launch browser and navigate to application")
	public void launch_browser_and_navigate_to_application() {
		BrowserConfiguration config =  new BrowserConfiguration();
		config.setup();	
		driver = config.driver;
		Assert.assertEquals(driver.getTitle(), "Swag Labs");
	}
	@When("Enter blank username")
	public void enter_blank_username(DataTable dataTable) throws IOException {
		List<Map<String,String>> credentials = dataTable.asMaps(String.class, String.class);
		for(Map<String,String> row : credentials)
		{
			String username = row.get("Username");
			Login login = new Login(driver);
			login.verifyUsername(username);
			Assert.assertTrue(login.flag);
		}
	}
	@When("Enter blank password")
	public void enter_blank_password(DataTable dataTable) throws IOException {
		List<Map<String,String>> credentials = dataTable.asMaps(String.class,String.class);
		for(Map<String,String> row : credentials)
		{
			String password = row.get("Password");
			Login login = new Login(driver);
			login.verifyPassword(password);	
			Assert.assertTrue(login.flag);
		}    
	}
	@When("click on Login Button")
	public void click_on_Login_Button() throws IOException {
		Login login = new Login(driver);
		login.verifyLoginButton();
		Assert.assertTrue(login.flag);
	}
	@Then("Verify Error Message <{string}>")
	public void verify_Error_Message(String expectedErrorMessage) throws IOException {
		Login login = new Login(driver);
		login.verifyPopup2();
//		Assert.assertTrue(login.flag);
//		BrowserConfiguration config =  new BrowserConfiguration();
//		config.close();
	} 
}
