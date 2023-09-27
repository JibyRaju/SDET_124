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
@4
Feature: User on signin page and testing signgin feature


  @tag1
  Scenario: Verifying Register link
    Given  The user is on signin page    
    When  The user clicks on register link on signin page    
    Then The user redirected to Registration page from signin page
  
 
  @tag2
  Scenario: User on signin page and signin with invalid inputs
    Given  The user is on signin page    
    When  The user enter invalid "username" and "password"
    |username  | |password    |
    |Numpy@sdet| |testpassword|
    
    Then click login button to verify
    
   @tag3
  Scenario: The user is able to signin with registered credential      
    When  The user enters a valid username as "NiSdet@1" and password as "Sdet$12w"       
    
    Then click login button to verify the credentials
   
   

  