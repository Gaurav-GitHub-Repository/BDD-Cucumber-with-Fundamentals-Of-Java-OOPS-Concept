@FunctionalTest
Feature: Verify login
 	Scenario: Verify login with valid username, invalid password and click on login button
    Given Launch browser and navigate to Application
    When Enter valid Username
   	 |Username|
   	 |standard_user|    
    When Enter invalid Password
   	 |Password|
     |standard_user|
    And Click on login Button
    Then Verify error message <"Username and password do not match any user in this service">
    
    
    
    
  