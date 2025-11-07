@FunctionalTest
Feature: Verify login
 	Scenario: Verify login with invalid username, valid password and click on login button
    Given Launch browser and navigate To application
    When Enter Invalid username
   	 |Username|
   	 |secret_sauce|    
    When Enter Valid password
   	 |Password|
     |secret_sauce|
    And Click on Login button
    Then Verify error Message <"Username and password do not match any user in this service">
    
    
    
    
  