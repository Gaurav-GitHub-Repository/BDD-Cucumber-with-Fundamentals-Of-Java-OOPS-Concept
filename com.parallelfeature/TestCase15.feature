@FunctionalTest
Feature: Verify dashboard
 	Scenario Outline: Verify number (count) of products available in the dashboard and retrieve product name
    Given Launch browser and navigate to application_8
    When Enter valid username_8
   	 |Username|
   	 |standard_user|    
    When Enter valid password_8
   	 |Password|
     |secret_sauce|
    And Click on login button_8
    Then Verify number of available products 
    |TotalProduct|
		|6|