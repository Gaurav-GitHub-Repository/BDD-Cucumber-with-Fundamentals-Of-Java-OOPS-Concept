@FunctionalTest
Feature: Verify cart
 	Scenario: Verify user is on "Checkout: Overview" page, details are entered and click on cancel button
    Given Launch browser and navigate to application_19
    When Enter valid username_19
   	 |Username|
   	 |standard_user|    
    When Enter valid password_19
   	 |Password|
     |secret_sauce|
    And Click on login button_19
		Then Add products to the cart_19
		And Click on cart button_19
		And Click on checkout button_19
		When Enter checkout details_19
		|FirstName|LastName|PostalCode|
		|Pathange |Gaurav  |500100    |
		And Click on continue button_19 	
		Then Click on cancel button_19 