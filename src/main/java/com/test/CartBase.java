package com.test;

import java.io.IOException;

public abstract class CartBase {
	
	public abstract boolean verifyNumberOfProducts(int AddProducts);
	
	public abstract boolean verifyRemoveButton() throws IOException;
	
	public abstract boolean verifyCheckoutButton();
	
	public abstract boolean verifyContinueButton();
	
	public abstract boolean verifyCartPage();
}
