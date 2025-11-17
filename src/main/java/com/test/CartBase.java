package com.test;

import java.io.IOException;

public abstract class CartBase {
	
	public abstract boolean verifyNumberOfProducts(int AddProducts);
	
	public abstract boolean verifyRemoveButton() throws IOException;
	
	public abstract boolean verifyCheckoutButton() throws IOException;
	
	public abstract boolean verifyContinueButton() throws IOException;
	
	public abstract boolean verifyCartPage() throws IOException;
}
