@FunctionalTest
Feature: Verify login
 	Scenario: Verify error pop up message is displayed when blank username, blank password are entered and clicked on login button
    Given Launch browser and navigate to application_4
    When Enter blank username_4
   	 |Username|
    When Enter blank password_4
   	 |Password|
    And Click on login button_4
    Then Verify error message_4 <"Username is required">

    
    
    
  