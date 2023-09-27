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
@5
Feature: The user is logged in to DS Algo portal going to explore  datastructures_introduction module

  @tag1
  Scenario: The user is able to navigate to Data Structure introduction page
    Given The user is on the home page after logged in   
    When The user clicks the "Getting Started" button in Data Structure Page introduction Panel
    Then The user should be redirected to data_structure_introduction page with some topics
    
  @tag2
  Scenario: The user is able to navigate to Time Complexity page
  	When The user clicks Time Complexity link
  	Then The user should be redirected to Time Complexity page
  
  @tag3
  Scenario: The user is able to navigate to a page having an tryEditor from Time Complexity page
 	  When The user clicks "Try Here" button on Time Complexity page
  	Then The user redirected to the assignment page with a run button
  
  @Tag4
  Scenario: The user is able run code in tryEditor for Time Complexity page
  	When The user enter valid python code in tryEditor from sheet "<Sheetname>" and <RowNumber>
  	Then The user clicked runbutton to disply the result
  
  Examples:
    |Sheetname | RowNumber|
    |Sheet2    |         0|
    
    
   @tag5
   Scenario Outline: User is able to navigate to tryeditor page and run invalid python code
   		Given The user is on try edidor page    	
   	  When The user enter invalid python code in tryEditor from sheet "<Sheetname>" and <RowNumber>
    	And User click on run button
    	Then User should get alert message
    Examples:
    |Sheetname | RowNumber|
    |Sheet2    |         1|
    
    @tag6
    Scenario: 
    Given The user is in the Data structures-Introduction page
  