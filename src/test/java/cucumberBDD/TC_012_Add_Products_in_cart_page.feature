@TC_012
Feature: Adding products to the cart page

Scenario: Add and check the products are added

Given open browser
Given user is on homepage
  When user click on Products
  Then user verify ALL PRODUCTS text
  When user hover over 1 and click Add to cart
  And user click continue Shopping button
  And user hover over 2 and click Add to cart
  When user click on view cart button
  Then user verify 1 is added as "Blue Top"
  And user verify 2 is added as "Men Tshirt"
  And user verify 1 price as "Rs. 500"
  And user verify 2 price as "Rs. 400"
  And user verify 1 quantity as 1
  And user verify 2 quantity as 1

