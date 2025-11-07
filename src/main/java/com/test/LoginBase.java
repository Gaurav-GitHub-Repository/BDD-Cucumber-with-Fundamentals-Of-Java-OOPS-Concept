package com.test;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;

public abstract class LoginBase {

	public abstract boolean verifyUsername(String value) throws IOException;
	
	public abstract boolean verifyPassword(String value) throws IOException;
	
	public abstract boolean verifyCredentials(String user, String password) throws IOException;

	public abstract boolean verifyLoginButton() throws IOException;
	
	public abstract boolean verifyDashboardPage() throws IOException;
	
	public abstract boolean verifyPopup() throws IOException;
	
	public abstract boolean verifyPopup2() throws IOException;

	public abstract boolean verifyCloseButton() throws IOException;
}
