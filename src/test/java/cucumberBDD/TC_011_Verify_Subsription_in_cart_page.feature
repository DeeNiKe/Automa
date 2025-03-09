@TC_011
Feature: Testing cart page

Scenario: Check cart functionality

Given open browser
Given user is on homepage
  When user click on cart button
  And user verify subscription text
  When user enter email address
  And user click on arrow button
  When user close browser

