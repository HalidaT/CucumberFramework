@Regression
Feature: Amazon Login
  I want to be able to login with valid credentials.
  I sould not be logged in with invalid credentials.

  @amazonLogin
  Scenario: User should be directed to log in page
  Given I am on amazon home page
  And The sign in button displays
  When I click on the sign in button
  Then I should be directed to log in page 
  
  @amazonLogin @amazonInvalidUser
  Scenario: User should not bne directed to password field when input invalid log in was given
  Given I am on the login page
  When I enter invalid email "jon.dow@gmail.com" 
  And I click the continue button
  Then I should get error message says "We can not find this address"
  And I should still see the email boxin the log in page
   