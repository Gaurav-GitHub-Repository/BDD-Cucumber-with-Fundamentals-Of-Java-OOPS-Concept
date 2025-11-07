@FunctionalTest
Feature: Verify login
 	Scenario: Verify close button is displayed in the error messagae and click on the button
    Given Launch browser and navigate to application_2
    When Enter blank username_2
   	 |Username|
    When Enter blank password_2
   	 |Password|
    And Click on login button_2
    Then Verify close button is displayed in error message <"Username is required">
    And Click on close button_2
    
    
    
  