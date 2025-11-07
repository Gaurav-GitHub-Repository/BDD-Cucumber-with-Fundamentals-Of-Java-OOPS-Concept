@FunctionalTest
Feature: Verify dashboard
 	Scenario: Verify price (low to high) products are successfully added to the cart and check product details
    Given Launch browser and navigate to application_6
    When Enter valid username_6
   	 |Username|
   	 |standard_user|    
    When Enter valid password_6
   	 |Password|
     |secret_sauce|
    And Click on login button_6
    Then Select price (low to high)
    |Dropdown|
    |Price (low to high)|
    And Add all products to cart
    And Click on cart button
    Then Verify added product details

    
    
    
  