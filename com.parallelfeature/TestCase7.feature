@FunctionalTest
Feature: Verify login
 	Scenario: Verify valid password, special characters in username are entered and click on login button
    Given Launch Browser and Navigate to Application
    When Enter Valid Password
   	 |Password|
   	 |secret_sauce|    
    When Enter Special Characters in username
   	 |Username|
     |standard_user@#$%|
    And Click On Login button
    Then Verify error message1 <"Username and password do not match any user in this service">
    
    
    
    
  