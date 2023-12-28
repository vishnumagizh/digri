	Feature: User upload functionlity in digri
	
  Scenario: To upload user data into Digri Application
    Given Launch the application in your browser
    When user enter the username and password and clicks login button
    |username|password|
    |testadmin1@digri.in|Abcd@1234|
    And user navigate to the settings section 
    And user uploads the students data in excel 
    Then user clicks on submit botton to upload the file 
