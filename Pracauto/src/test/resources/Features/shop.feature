Feature: US7 As a User I want From the Shop page, add items to my basket

  @shopAdd
  Scenario: Verify the ADD TO BASKET button
    Given User in shop page
    When User clicks add to basket
    Then the article should appear in cart page

  @shopView
  Scenario: Verify the View BASKET button
    Given User in shop page
    When User clicks add to basket
    Then view basket button should appear

  @topic
  Scenario: Verify the filter by topic
    Given User in shop page
    When User filter by topic
    Then only articles of that topic should appear

  @price
  Scenario: Verify the filter by price
    Given User in shop page
    When User filter by price
    Then only articles of that price should appear
