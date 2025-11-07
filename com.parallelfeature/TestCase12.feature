@FunctionalTest
Feature: Verify dashboard
 	Scenario: Verify logo is displayed in the dashboard page and click on the logo
    Given Launch browser and navigate to application_5
    When Enter valid username_5
   	 |Username|
   	 |standard_user|    
    When Enter valid password_5
   	 |Password|
     |secret_sauce|
    And Click on login button_5
    Then Verify logo is displayed and click on logo

    
    
    
  