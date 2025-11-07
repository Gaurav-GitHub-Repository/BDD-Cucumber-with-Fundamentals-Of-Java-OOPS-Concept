@FunctionalTest
Feature: Verify cart
 	Scenario: Verify user is on "Your Cart" page and click on logout button
    Given Launch browser and navigate to application_23
    When Enter valid username_23
   	 |Username|
   	 |standard_user|    
    When Enter valid password_23
   	 |Password|
     |secret_sauce|
    And Click on login button_23
		Then Add product to cart_23
		And Click on cart button_23
		And Verify user is on "Your Cart" page_23
		Then Click on logout button_23