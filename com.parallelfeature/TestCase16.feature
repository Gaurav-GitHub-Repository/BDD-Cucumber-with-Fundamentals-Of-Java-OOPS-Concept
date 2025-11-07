@FunctionalTest
Feature: Verify dashboard
 	Scenario Outline: Verify product logo are displayed in the dashboard and click on the back button
    Given Launch browser and navigate to application_9
    When Enter valid username_9
   	 |Username|
   	 |standard_user|    
    When Enter valid password_9
   	 |Password|
     |secret_sauce|
    And Click on login button_9
    Then Verify product logo are displayed And click on back button
  