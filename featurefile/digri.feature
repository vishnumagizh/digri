	Feature: User upload functionlity
	
  Scenario: To upload the user data into Digri Application
    Given Launch the application on your browser
    When user enters the "testadmin1@digri.in" in the username field
    And user enters the "Abcd@1234" in the password field and clicks on the login button
    And user navigates to the settings page 
    And user uploads the students data in excel format 
    Then user clicks on submit botton to upload the file successfully
