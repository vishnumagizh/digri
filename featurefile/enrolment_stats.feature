Feature: Enrolment Stats Using Donut Chart

  Scenario: Display Enrolment Stats in pie Chart
    Given user enters the "testadmin1@digri.in" and "Abcd@1234" in the login input field
    When the user is on the Admin Dashboard page
    When the user hovers the pie Chart
    Then the pie Chart should display enrolment statistics
    And the total enrolment count should be displayed
    And the total number of enrolment could should be validated

