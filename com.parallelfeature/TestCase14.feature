@FunctionalTest
Feature: Verify dashboard
 	Scenario: Verify price (high to low) products are successfully added to the cart and check product details
    Given Launch browser and navigate to application_7
    When Enter valid username_7
   	 |Username|
   	 |standard_user|    
    When Enter valid password_7
   	 |Password|
     |secret_sauce|
    And Click on login button_7
    Then Select price (high to low)
    |Dropdown|
    |Price (high to low)|
    And Add all products to cart_7
    And Click on cart button_7
    Then Verify added product details_7
  