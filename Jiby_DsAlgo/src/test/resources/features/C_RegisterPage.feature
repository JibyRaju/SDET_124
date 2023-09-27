#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@3
Feature: The user is going to register 
  @tag1
  Scenario: The user is presented with error message for empty fields below Username textbox
    Given The user opens Register Page
    When The user clicks "Register" button with all fields empty    
    Then It should display an error "Please fill out this field." below Username textbox  
    
   @tag2 
  Scenario: The user is presented with error message for empty fields below Password textbox
    Given The user opens Register Page
    When The user clicks Register button after entering "username" with other fields empty
      | username       |
      | Numpy@sdet84_1 |
    Then It should display an error message "Please fill out this field." below Password textbox
    
  @tag3
  Scenario: The user is presented with error message for empty fields below Password Confirmation textbox
    When  The user clicks Register button after entering "username" and "password" with Password Confirmation field empty    
    | username       | password     |
    | Numpy@sdet84_1 | testpassword |
      
    Then It should display an error "Please fill out this field." below Password Confirmation textbox  
    
  @tag4
  Scenario: The user is presented with error message for invalid username
     When The user enters a "username" "password" and "password confirmation" with characters other than Letters, digits and @/./+/-/_
      | username | password     | password confirmation |
      | &**&**&  | testpassword | testpassword          |
     Then It should display an error message "Please enter a valid username"
     
  
  @tag5
  Scenario: The user is presented with error message for password with characters less than eight.
     When The user enters a valid "username" and "password" with characters less than eight and "password confirmation"
      | username     | password | password confirmation |
      | Numpy@sdet84_1 | a1b2c3d  | a1b2c3d            |
      
      Then display an error message "Password should contain at least 8 characters"
      
  @tag6
  Scenario: The user is presented with error message for commonly used password
    When The user enters a valid "username" and commonly used password "password" and "password confirmation"
      | username     | password | password confirmation |
      | Numpy@sdet84_1 | Welcome1 | Welcome1          |
    Then  The error message is "Password can’t be commonly used password"
    
  @tag7
  Scenario: The user is succesfully able to register 
    When The user enters a valid "username" and "password" and "password confirmation"
      | username       | password  | password confirmation |
      | Numpy@sdet84_1 | RT56YU@78 | RT56YU@78             |     
    Then The user should be redirected to Homepage with the message "New Account Created. You are logged in as <username>" 
    
    
  @tag8
  Scenario: The user is presented with error message for username already exists
     When The user enters a valid existing "username" with "password" and "password confirmation"
      | username       | password  | password confirmation |
      | Numpy@sdet84_1 | RT56YUabc | RT56YUabc  |
      
     Then It need to display an error message "Username already exists"
     
     
  
      