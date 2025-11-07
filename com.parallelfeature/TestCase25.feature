@FunctionalTest
Feature: Verify cart
 	Scenario: Verify user is on "Checkout: Overview" page and check if the product details are correct according to the added product in cart
    Given Launch browser and navigate to application_18
    When Enter valid username_18
   	 |Username|
   	 |standard_user|    
    When Enter valid password_18
   	 |Password|
     |secret_sauce|
    And Click on login button_18
		Then Add products to the cart_18
		And Click on cart button_18
		And Click on checkout button_18
		When Enter checkout details_18
		|FirstName|LastName|PostalCode|
		|Pathange |Gaurav  |500100    |
		And Click on continue button
		Then Check product details are correct