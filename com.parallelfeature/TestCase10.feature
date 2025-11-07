@FunctionalTest
Feature: Verify login
 	Scenario: Verify error pop up message is displayed when invalid username, invalid password are entered and clicked on login button
    Given Launch browser and navigate to application_3
    When Enter invalid username_3
   	 |Username|
   	 |secret_sauce|    
    When Enter invalid password_3
   	 |Password|
     |standard_user|
    And Click on login button_3
    Then Verify error message_3 <"Username and password do not match any user in this service">

    
    
    
  