@FunctionalTest
Feature: Verify login
 	Scenario: Verify login button is displayed and click on the login button
    Given Launch browser And Navigate To Application
    When Enter valid username_1
   	 |Username|
   	 |standard_user|    
    When Enter valid password_1
   	 |Password|
     |secret_sauce|
    And Click on login button_1
    Then Verify user is on dashboard page_1
    
    
    
    
  