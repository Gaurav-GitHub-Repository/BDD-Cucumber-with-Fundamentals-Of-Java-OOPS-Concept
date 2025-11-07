package com.test;

import java.io.IOException;

import org.openqa.selenium.WebElement;

public abstract class CheckoutBase {
	
	public abstract boolean verifyUserDetails(String FirstName, String LastName, String PostalCode);
	
	public abstract boolean verifyProductDetails(String Product1, String Product4, String Product6) throws IOException, InterruptedException;
	
	public abstract boolean verifyContinueButton();
	
	public abstract boolean verifyCancelButton();
	
	public abstract boolean verifyFinishButton();

	public abstract boolean verifyCheckoutPage();
	
}
