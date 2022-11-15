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

Feature: TV
  Background:
    Given customer login to flipkart
  Scenario: TV Purchase
    When customer using  search box to search
    And customer choose the TV
    And Verify the branding is genuine by checking the manufacturing specifications
    And customer makes order 
    Then Check if the packaging is not damaged due to the shipping
    
  Scenario: TV Purchase by one dimensional list
    When customer using  search box to search using one dimensional list
     |SAMSUNG Crystal 4K|SONY Bravia|
    And customer choose the TV
    And Verify the branding is genuine by checking the manufacturing specifications
    And customer makes order 
    Then Check if the packaging is not damaged due to the shipping
    
  Scenario: TV Purchase by one dimensional map
    When customer using  search box to search using one dimensional map
    |TV1|SAMSUNG Crystal 4K|
    |TV2|SONY Bravia|
    |phone3|iPhone|
    And customer choose the TV
    And Verify the branding is genuine by checking the manufacturing specifications
    And customer makes order 
    Then Check if the packaging is not damaged due to the shipping
    
  Scenario Outline: TV Purchase
    When customer using  search box to search"<TV>"
    And customer choose the TV
    And Verify the branding is genuine by checking the manufacturing specifications
    And customer makes order 
    Then Check if the packaging is not damaged due to the shipping
    
  Examples:
    |TV|
    |SAMSUNG Crystal 4K|
    |SONY Bravia|