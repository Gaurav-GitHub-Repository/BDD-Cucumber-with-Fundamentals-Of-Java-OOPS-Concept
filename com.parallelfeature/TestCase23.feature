@FunctionalTest
Feature: Verify cart
 	Scenario: Verify user is on "Your Cart" page and click on "CHECKOUT" button
    Given Launch browser and navigate to application_16
    When Enter valid username_16
   	 |Username|
   	 |standard_user|    
    When Enter valid password_16
   	 |Password|
     |secret_sauce|
    And Click on login button_16
		Then Add products to the cart_16
		And Click on cart button_16
		Then Click on checkout button
		