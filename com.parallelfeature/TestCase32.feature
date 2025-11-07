@FunctionalTest
Feature: Verify cart
 	Scenario: Verify user is on "Checkout: Overview" page and click on logout button
    Given Launch browser and navigate to application_25
    When Enter valid username_25
   	 |Username|
   	 |standard_user|    
    When Enter valid password_25
   	 |Password|
     |secret_sauce|
    And Click on login button_25
		Then Add product to cart_25
		And Click on cart button_25
		And Click on checkout button_25
		And Click on continue button_25
		And Verify user is on Checkout: Overview page_25
		Then Click on logout button_25