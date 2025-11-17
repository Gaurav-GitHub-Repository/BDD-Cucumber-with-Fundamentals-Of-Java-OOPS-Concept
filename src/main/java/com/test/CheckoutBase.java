package com.test;

import java.io.IOException;

import org.openqa.selenium.WebElement;

public abstract class CheckoutBase {
	
	public abstract boolean verifyUserDetails(String FirstName, String LastName, String PostalCode);
	
	public abstract boolean verifyProductDetails(String Product1, String Product4, String Product6) throws IOException, InterruptedException;
	
	public abstract boolean verifyContinueButton() throws IOException;
	
	public abstract boolean verifyCancelButton() throws IOException;
	
	public abstract boolean verifyFinishButton() throws IOException;

	public abstract boolean verifyCheckoutPage() throws IOException;
	
}
