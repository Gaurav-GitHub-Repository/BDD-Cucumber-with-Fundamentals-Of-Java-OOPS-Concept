@FunctionalTest
Feature: Verify login
 	Scenario: Verify login with invalid username, invalid password and click on login button
    Given Launch browser And navigate to application
    When enter invalid username
   	 |Username|
   	 |secret_sauce|    
    When enter invalid password
   	 |Password|
     |standard_user|
    And click on login button
    Then verify error message <"Username and password do not match any user in this service">
    
    
    
    
  