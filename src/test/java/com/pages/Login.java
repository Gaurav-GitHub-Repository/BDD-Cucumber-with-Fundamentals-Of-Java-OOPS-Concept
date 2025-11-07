package com.pages;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.log4testng.Logger;
import com.test.LoginBase;

public class Login extends LoginBase{

	private WebDriver driver;
	private Logger log = Logger.getLogger(Login.class);
	public boolean flag = false;
	ReusableComponents component = new ReusableComponents();

	//Assigning driver
	public Login(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	//======================================Web Elements================================

	@FindBy(xpath="//*[@id='user-name' or @name='user-name']")
	private WebElement Username;

	@FindBy(xpath="//*[@id='password' or @name='password']")
	private WebElement Password;

	@FindBy(css="input.submit-button")
	private WebElement loginButton;	

	@FindBy(xpath="//*[text()='Products']")
	private WebElement Products;

	@FindBy(xpath="//*[text()='Username and password do not match any user in this service']")
	private WebElement ErrorMessage;

	@FindBy(xpath="//*[text()='Username is required']")
	private WebElement ErrorMessage2;

	@FindBy(css="button.error-button")
	private WebElement closeButton;
	//======================================Implementation==============================

	public void finalize()
	{
		System.out.println("Garbage value is collected");
	}	
	@Override
	public boolean verifyUsername(String value) throws IOException {
		if(Username.isEnabled())
		{
			Username.sendKeys(value);
			flag=true;
			component.captureScreenshot(driver);
			Assert.assertTrue(true, "Username is entered");
			log.info("Username is entered");
			System.gc();
		}
		else
		{
			Assert.assertTrue(false, "Username is not entered");
			log.error("Username is not entered");
			System.gc();
		}
		return flag;
	}
	@Override
	public boolean verifyPassword(String value) throws IOException {
		if(Password.isEnabled())
		{
			Password.sendKeys(value);
			flag=true;
			component.captureScreenshot(driver);
			Assert.assertTrue(true,"Password is entered");
			log.info("Password is entered");
			System.gc();
		}
		else
		{
			Assert.assertTrue(false,"Password is not entered");
			log.error("Password is not entered");
			System.gc();
		}
		return flag;
	}
	@Override
	public boolean verifyCredentials(String user, String password){

		try{
			List<WebElement> credentialsField = driver.findElements(By.xpath("//form/input"));
			for(int i=1;i<=credentialsField.size();i++)
			{
				if(driver.findElement(By.xpath("//form/input["+i+"]")).isEnabled())
				{
					Username.sendKeys(user);
					Assert.assertTrue(true,"Username is entered");
					log.info("Username is entered");
					Password.sendKeys(password);
					Assert.assertTrue(true,"Password is entered");
					log.info("Password is entered");
					if(i==credentialsField.size())
					{
						flag=true;
						component.wait(driver, By.xpath("//form/input[2]"));
						component.captureScreenshot(driver);
						break;
					}
				}
			}
		}catch(FileNotFoundException e){
			System.out.println("FileNotFoundException Occured");
		}catch(Exception e){
			System.out.println("Exception Occured");
		}finally{
			System.gc();
		}
		return flag;
	}
	@Override
	public boolean verifyLoginButton(){

		try {
			if(loginButton.isDisplayed()) {
				loginButton.click();
				flag = true;
				System.out.println("Clicked on login button");
				log.info("Clicked on login button");
				if(flag==true)
				{
					component.wait(driver, By.xpath("//*[text()='Products']"));
					component.captureScreenshot(driver);
					Assert.assertEquals(Products.isDisplayed(), true, "User successfully navigated to dashboard");
				}
				else
				{
					Assert.assertTrue(false, "verifyLoginButton : Error Occured");
					log.error("verifyLoginButton : Error Occured");
				}
			}
		}catch(FileNotFoundException e) {
			System.out.println("FileNotFoundException Occured");
		}catch(Exception e){
			System.out.println("Exception Occured");
		}finally{
			System.gc();
		}
		return flag;
	}
	@Override
	public boolean verifyPopup(){
		try {
			if(ErrorMessage.isDisplayed())
			{
				if(ErrorMessage.getText().equalsIgnoreCase("Epic sadface: Username and password do not match any user in this service"))
				{
					flag=true;
					component.wait(driver, By.xpath("//*[text()='Username and password do not match any user in this service']"));
					component.captureScreenshot(driver);
					Assert.assertTrue(true,"Error message is displayed");
					log.info("Error message is displayed");
				}
				else
				{
					Assert.assertTrue(false,"Error message is displayed");
					log.error("Error message is not displayed");
				}
			}	
		}catch(FileNotFoundException e) {
			System.out.println("FileNotFoundException Occured");
		}catch(Exception e) {
			System.out.println("Exception Occured");
		}finally {
			System.gc();
		}
		return flag;
	}
	@Override
	public boolean verifyPopup2(){
		try {
			if(ErrorMessage2.isDisplayed())
			{
				if(ErrorMessage2.getText().equalsIgnoreCase("Epic sadface: Username is required"))
				{
					flag=true;
					component.wait(driver, By.xpath("//*[text()='Username is required']"));
					component.captureScreenshot(driver);
					Assert.assertTrue(true,"Error message is displayed");
					log.info("Error message is displayed");
				}
				else
				{
					Assert.assertTrue(false,"Error message is displayed");
					log.error("Error message is not displayed");
				}
			}
		}catch(FileNotFoundException e){
			System.out.println("FileNotFoundException Occured");
		}catch(Exception e){
			System.out.println("Exception Occured");
		}finally{
			System.gc();
		}
		return false;
	}
	@Override
	public boolean verifyDashboardPage() throws IOException {
		if(Products.isDisplayed())
		{
			flag=true;
			component.captureScreenshot(driver);
			Assert.assertTrue(true, "User successfully navigated to dashboard");
			log.info("User successfully navigated to dashboard");
			System.gc();
		}
		else
		{
			Assert.assertTrue(false, "User is not on the dashboard page");
			log.error("User is not on the dashboard page");
			System.gc();
		}
		return flag;
	}
	@Override
	public boolean verifyCloseButton() throws IOException {
		if(closeButton.isDisplayed())
		{
			flag=true;
			component.captureScreenshot(driver);
			Assert.assertTrue(true, "Close button is displayed in the error message");
			log.info("Close button is displayed in the error message");
			System.gc();
		}
		else
		{
			Assert.assertTrue(false, "Close button is not displayed in the error message");
			log.info("Close button is not displayed in the error message");
			System.gc();
		}
		return false;
	}
}
