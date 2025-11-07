@FunctionalTest
Feature: Verify cart
 	Scenario: Verify "REMOVE" button in the "Your Cart" page and check if the cart is empty
    Given Launch browser and navigate to application_14
    When Enter valid username_14
   	 |Username|
   	 |standard_user|    
    When Enter valid password_14
   	 |Password|
     |secret_sauce|
    And Click on login button_14
		Then Add products to cart_14
		And Click on remove button and Check if cart is empty
		