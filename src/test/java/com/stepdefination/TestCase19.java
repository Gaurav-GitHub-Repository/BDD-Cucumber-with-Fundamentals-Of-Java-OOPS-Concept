package com.stepdefination;

import io.cucumber.java.en.*;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
import java.util.Map;

public class TestCase19 {

	private WebDriver driver;
	static Logger log = Logger.getLogger(TestCase19.class);

    @Given("Launch browser and navigate to application_12")
    public void launch_browser_and_navigate_to_application_12() {
		BrowserConfiguration config =  new BrowserConfiguration();
		config.setup();	
		driver = config.driver;
		Assert.assertEquals(driver.getTitle(), "Swag Labs");
    }
    @When("Enter valid username_12")
    public void enter_valid_username_12(DataTable dataTable) throws IOException {
		List<Map<String,String>> credentials = dataTable.asMaps(String.class,String.class);
		for(Map<String,String> row : credentials)
		{
			String username = row.get("Username");
			Login login = new Login(driver);
			login.verifyUsername(username);
			Assert.assertTrue(login.flag);
		}        
    }
    @When("Enter valid password_12")
    public void enter_valid_password_12(DataTable dataTable) throws IOException {
		List<Map<String,String>> credentials = dataTable.asMaps(String.class,String.class);
		for(Map<String,String> row : credentials)
		{
			String password = row.get("Password");
			Login login = new Login(driver);
			login.verifyPassword(password);
			Assert.assertTrue(login.flag);
		}        
    }
    @When("Click on login button_12")
    public void click_on_login_button_12() {
		Login login = new Login(driver);
		login.verifyLoginButton();
		Assert.assertTrue(login.flag);
    }
    @Then("Scroll down to footer section and click on footer link <{string}>")
    public void scroll_down_to_footer_section(String string) throws IOException {
    	Dashboard dashboard = new Dashboard(driver);
    	dashboard.verifyFooterLink();
    	Assert.assertTrue(dashboard.flag);
    	BrowserConfiguration config =  new BrowserConfiguration();
    	config.close();
    }
}
