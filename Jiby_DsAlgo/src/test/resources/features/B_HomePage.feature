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
@2
Feature: User is going to explore Home page 

  @tag1
  Scenario: User is on Home page and click on dropdown without sign in
    Given The user opens Home page
    When The user clicks on dropdown "<option>" without login    
    Then The user get warning message "You are not logged in"

   Examples: 
	| option         |
	| Arrays         |
	| Linkedlist     |
	| Stack          |
	| Queue          |
	| Tree           |
	| Graph          |
	
	
 @tag2
 Scenario: User is on Home page and click on sign in
   When The user clicks "Sign in"
   Then The user should be redirected to Sign in page
   
  @tag3
 Scenario: User is on Home page and going to click on Register    
   When The user clicking "Register"
   Then The user should be redirected to Register form