
@LandPage
Feature: Land Page features
  I want to use this  for Land Page features
	
	@Sanity
	Scenario: Take the List of all Items on Land Page
		Given 	User is on LandPage
		Then 		Print total number of Items and  Item Names on Land Page
		And 		Print total number of Items and  Item Names on Land Page in a File

	
	@Regression
	Scenario: Take the List of all Items on Land Page
		Given 	User is on LandPage
		Then 		Print total number of Items and  Item short Names on Land Page in a File
		 		
 
  @Regression
  Scenario Outline: Verify Itemname on Land Page and Product name are same
    Given User is on LandPage
    When User enters short name <itemName> in search
    
    Then validate the <itemName> in offers Page is same as itemName from landpage
    
    Examples: 
      |itemName| 
      |Bro|
			|Cau|
			|Cuc|
			|Bee|
			
			
			

      

  