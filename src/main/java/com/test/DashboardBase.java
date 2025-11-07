package com.test;

import java.io.IOException;

public abstract class DashboardBase {

	public abstract boolean verifyLogo() throws IOException;
	
	public abstract boolean verifyPriceDropdown(String value1) throws IOException;
	
	public abstract boolean verifyNumberOfProducts(String TotalProduct) throws IOException;
	
	public abstract boolean verifyAddToCart() throws IOException;
	
	public abstract boolean verifyProductWithPrice() throws IOException;
	
	public abstract boolean verifyProductDetails() throws IOException;
	
	public abstract boolean verifyDeletedProduct() throws IOException;
	
	public abstract void verifyProductLogo() throws IOException;
	
	public abstract boolean verifyCartButton() throws IOException, InterruptedException;
	
	public abstract boolean verifyFooterLink() throws IOException;
}
