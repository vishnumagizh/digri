Feature: Forget Password with OTP
  @otprequest
  Scenario: User requests a password reset with OTP
    Given the user is on the login page
    When the user clicks on the Forgot Password? link
    Then the user should be redirected to the password recovery page
    And the user enters their registered email
    And clicks on the Continue button
    Then the user should see a confirmation message with OTP
    
    Scenario: User enters a valid OTP to proceed
    Given the user has requested a password reset
    And an OTP has been sent to their registered email
    When the user enters the correct OTP in the verification code field
    And clicks the "Verify OTP" button
    Then the user should be redirected to the password reset page
    

  Scenario: User provides an unregistered email for password reset
    Given the user is on password recovery page
    When the user enters an unregistered email
    And clicks on  "Continue" button
    Then the user should see an error message
    And no OTP should be sent


  Scenario: User enters an invalid OTP
    Given the user has requested for password reset
    And an OTP was sent to their registered email
    When the user enters an incorrect OTP in the verification code field
    And click on  "Verify OTP" button
    Then the user should see error message
    And the user should not be redirected to the password reset page

  Scenario: User cancels the password reset process
    Given the user is on the password reset page
    When the user clicks on "Back to login" button
    Then the user should be redirected to the login page
