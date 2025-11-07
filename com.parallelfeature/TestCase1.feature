@FunctionalTest
Feature: Verify login
 	Scenario: Verify login with valid username, valid password and click on login button
    Given Launch browser and navigate to application
    When Enter valid username
   	 |Username|
   	 |standard_user|    
    When Enter valid password
   	 |Password|
     |secret_sauce|
    And Click on login button
    Then Verify user is on dashboard page
    
    
    
    
  