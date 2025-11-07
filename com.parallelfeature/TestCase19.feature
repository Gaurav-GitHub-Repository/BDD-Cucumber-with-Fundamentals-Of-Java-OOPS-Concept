@FunctionalTest
Feature: Verify dashboard
 	Scenario: Verify below mentioned link is displayed in the footer section and click on the link
    Given Launch browser and navigate to application_12
    When Enter valid username_12
   	 |Username|
   	 |standard_user|    
    When Enter valid password_12
   	 |Password|
     |secret_sauce|
    And Click on login button_12
		Then Scroll down to footer section and click on footer link <"© 2020 Sauce Labs. All Rights Reserved. Terms of Service | Privacy Policy">
		