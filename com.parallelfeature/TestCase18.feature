@FunctionalTest
Feature: Verify dashboard
 	Scenario: Verify all products are added to cart in the dashboard page and click on the remove button
    Given Launch browser and navigate to application_11
    When Enter valid username_11
   	 |Username|
   	 |standard_user|    
    When Enter valid password_11
   	 |Password|
     |secret_sauce|
    And Click on login button_11
		And Add all products to cart_11
		Then Verify products are added to cart_11
		And Click on remove button And verify products are cleared in cart
   