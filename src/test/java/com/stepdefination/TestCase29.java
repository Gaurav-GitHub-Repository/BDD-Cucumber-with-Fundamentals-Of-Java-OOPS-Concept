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
import com.pages.Logout;
import com.setup.BrowserConfiguration;

import java.io.IOException;
import java.net.SocketException;
import java.util.List;
import java.util.Map;

public class TestCase29 {

	private WebDriver driver;
	static Logger log = Logger.getLogger(TestCase29.class);

    @Given("Launch browser and navigate to application_22")
    public void Launch_browser_and_navigate_to_applicatiosn_22() {
		BrowserConfiguration config =  new BrowserConfiguration();
		config.setup();	
		driver = config.driver;
		Assert.assertEquals(driver.getTitle(), "Swag Labs");
    }
    @When("Enter valid username_22")
    public void Enter_valid_username_22(DataTable dataTable) throws IOException {
		List<Map<String,String>> credentials = dataTable.asMaps(String.class,String.class);
		for(Map<String,String> row : credentials)
		{
			String username = row.get("Username");
			Login login = new Login(driver);
			login.verifyUsername(username);
			Assert.assertTrue(login.flag);
		}
    }
    @When("Enter valid password_22")
    public void Enter_valid_password_22(DataTable dataTable) throws IOException {
		List<Map<String,String>> credentials = dataTable.asMaps(String.class,String.class);
		for(Map<String,String> row : credentials)
		{
			String password = row.get("Password");
			Login login = new Login(driver);
			login.verifyPassword(password);
			Assert.assertTrue(login.flag);
		}  
    }
    @When("Click on login button_22")
    public void Click_on_login_button_22() {
		Login login = new Login(driver);
		login.verifyLoginButton();
		Assert.assertTrue(login.flag);
    }
    @When("Verify user is on dashboard page_22")
    public void Verify_user_is_on_dashboard_page_22() {
    	Dashboard dashboard = new Dashboard(driver);
    	dashboard.verifyLogo();
    	Assert.assertTrue(dashboard.flag);
    }
    @Then("Click on logout button_22")
    public void Click_on_logout_button_22() throws SocketException {
       	Logout logout = new Logout(driver);
    	logout.verifyLogoutButton();
    	BrowserConfiguration config =  new BrowserConfiguration();
    	config.close();
    } 
}
