@FunctionalTest
Feature: Verify cart
 	Scenario: Verify user is on "Checkout: Your Information" page and click on logout button
    Given Launch browser and navigate to application_24
    When Enter valid username_24
   	 |Username|
   	 |standard_user|    
    When Enter valid password_24
   	 |Password|
     |secret_sauce|
    And Click on login button_24
		Then Add product to cart_24
		And Click on cart button_24
		And Click on checkout button_24
		And Verify user is on "Checkout: Your Information" page_24
		Then Click on logout button_24