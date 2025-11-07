@FunctionalTest
Feature: Verify cart
 	Scenario: Verify order dispatch message is displayed and click on the logout button
    Given Launch browser and navigate to application_21
    When Enter valid username_21
   	 |Username|
   	 |standard_user|    
    When Enter valid password_21
   	 |Password|
     |secret_sauce|
    And Click on login button_21
		Then Add products to the cart_21
		And Click on cart button_21
		And Click on checkout button_21
		When Enter checkout details_21
		|FirstName|LastName|PostalCode|
		|Pathange |Gaurav  |500100    |
		And Click on continue button_21 	
		And Click on finish button_21 
		Then Verify order dispatch message <"Your order has been dispatched, and will arrive just as fast as the pony can get there!">
		And Click on logout button