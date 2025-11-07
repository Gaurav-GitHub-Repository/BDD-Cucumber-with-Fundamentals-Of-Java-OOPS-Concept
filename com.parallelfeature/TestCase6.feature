@FunctionalTest
Feature: Verify login
 	Scenario: Verify valid username, special characters in password are entered and click on login button
    Given Launch browser and Navigate to application
    When Enter Valid username
   	 |Username|
   	 |standard_user|    
    When Enter Special Characters in password
   	 |Password|
     |secret_sauce@#$%|
    And Click On Login Button
    Then Verify Error message <"Username and password do not match any user in this service">
    
    
    
    
  