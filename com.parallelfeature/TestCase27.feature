@FunctionalTest
Feature: Verify cart
 	Scenario: Verify user is on "Checkout: Overview" page and click on finish button
    Given Launch browser and navigate to application_20
    When Enter valid username_20
   	 |Username|
   	 |standard_user|    
    When Enter valid password_20
   	 |Password|
     |secret_sauce|
    And Click on login button_20
		Then Add products to the cart_20
		And Click on cart button_20
		And Click on checkout button_20
		When Enter checkout details_20
		|FirstName|LastName|PostalCode|
		|Pathange |Gaurav  |500100    |
		And Click on continue button_20 	
		Then Click on finish button 