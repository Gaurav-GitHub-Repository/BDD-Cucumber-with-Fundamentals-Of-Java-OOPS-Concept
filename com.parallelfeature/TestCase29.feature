@FunctionalTest
Feature: Verify cart
 	Scenario: Verify user is on dashboard page and click on logout button
    Given Launch browser and navigate to application_22
    When Enter valid username_22
   	 |Username|
   	 |standard_user|    
    When Enter valid password_22
   	 |Password|
     |secret_sauce|
    And Click on login button_22
		And Verify user is on dashboard page_22
		Then Click on logout button_22