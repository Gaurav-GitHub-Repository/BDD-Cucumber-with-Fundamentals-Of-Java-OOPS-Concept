@FunctionalTest
Feature: Verify dashboard
 	Scenario: Verify product name with respective to the price are captured and check details are matching with the added product
    Given Launch browser and navigate to application_10
    When Enter valid username_10
   	 |Username|
   	 |standard_user|    
    When Enter valid password_10
   	 |Password|
     |secret_sauce|
    And Click on login button_10
	  When Product name with respective to the price are captured And Check product details are matching with the added product
   