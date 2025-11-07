@FunctionalTest
Feature: Verify login
 	Scenario: Verify login with blank username, blank password and click on login button
    Given launch browser and navigate to application
    When Enter blank username
   	 |Username|
    When Enter blank password
   	 |Password|
    And click on Login Button
    Then Verify Error Message <"Username is required">
    
    
    
    
  