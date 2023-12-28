
 Feature: Login Functionality
 
    @validlogin
    Scenario Outline: Login with valid credentials
    Given the user navigates to the login page and verify the page elements
    When the user enters "<username>" and "<password>" in the input field
    And clicks on the login button
    Then the user should be redirected to the dashboard
    And the user should see a welcome message
    
    Examples:
      | username         | password       |
      | nandinisunkara3107@gmail.com   | Abcd@1234 |
      | testadmin1@digri.in      | Abcd@1234 |
      
    
  
    @invalidlogin
    Scenario Outline: Login with Incorrect Credentials
    Given  user navigates to the login page and verify the page elements
    When the user enters invalid credentials "<username1>" and "<password1>"
    And clicks the login button
    Then an error message should be displayed
    And the user should stay on the login page
    

    Examples:
      | username1       | password1       |
      | flowtest1@gmail.com      | Abcd123456|
      | testadmin1@gmail.in      | Abcd@1234 |
     
