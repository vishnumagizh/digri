Feature: User uploading functionlity
	
  Scenario Outline: To upload the user data into Application
    Given Launch the application 
    When user enters "<username>" in the username field
    And user enters "<password>" in the password field and click login button
    And user navigates to the settings page and uploads the students data
    Then user clicks on submit botton to upload the students data

    Examples: 
      | username  | password | 
      | testadmin1@digri.in | Abcd@1234 | 
  # | testadmin@digri.in |  Abcd@1234 |
