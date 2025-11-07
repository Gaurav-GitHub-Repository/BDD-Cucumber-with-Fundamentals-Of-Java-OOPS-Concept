@FunctionalTest
Feature: Verify cart
 	Scenario: Verify number of product displayed in cart page (Your Cart) is working according to the added products and click on the cart link
    Given Launch browser and navigate to application_13
    When Enter valid username_13
   	 |Username|
   	 |standard_user|    
    When Enter valid password_13
   	 |Password|
     |secret_sauce|
    And Click on login button_13
		Then Add Products to cart and verify number of added product are displayed in the cart (Cart Page)
