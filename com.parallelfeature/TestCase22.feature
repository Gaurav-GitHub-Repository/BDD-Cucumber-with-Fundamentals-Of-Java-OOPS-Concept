@FunctionalTest
Feature: Verify cart
 	Scenario: Verify user is on "Your Cart" page and click on "CONTINUE SHOPPING" button
    Given Launch browser and navigate to application_15
    When Enter valid username_15
   	 |Username|
   	 |standard_user|    
    When Enter valid password_15
   	 |Password|
     |secret_sauce|
    And Click on login button_15
		Then Add products to the cart_15
		And Click on cart button_15
		Then Click on continue shopping button
		