Feature: marvel characters rest api testing

  Scenario: Customer ordering from kodyorder
    When I selected the food
    And Click on checkout
    And pay the Amount By using card
    Then order should be placed successfully.

 