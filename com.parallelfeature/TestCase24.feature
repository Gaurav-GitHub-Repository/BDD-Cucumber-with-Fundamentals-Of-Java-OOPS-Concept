@FunctionalTest
Feature: Verify cart
 	Scenario: Verify details are entered in "Checkout: Your Information" page and click on cancel button
    Given Launch browser and navigate to application_17
    When Enter valid username_17
   	 |Username|
   	 |standard_user|    
    When Enter valid password_17
   	 |Password|
     |secret_sauce|
    And Click on login button_17
		Then Add products to the cart_17
		And Click on cart button_17
		And Click on checkout button_17
		When Enter user details in "Checkout: Your Information" page
		|FirstName|LastName|PostalCode|
		|Pathange |Gaurav  |500100    |
		Then Click on cancel button