@CheckoutPage
Feature: Verify Features on Checkout Page
  I want to use this template for my feature file



  @Smoke
  Scenario Outline:  Verify Item Name on Check Out Page and Promo Code Apply Option and Place Order
    Given User is on LandPage
    When User enters short name <itemName> in search 
    And  adds <Quantity> for <itemName>  on land page
    And  Clicks on Add to cart 
    And  Proceed to Checkout
   	Then User verifies <itemName> and <Quantity> on Checkout Page
   

    Examples: 
      | itemName|Quantity|
      | tom|3|
      
