Feature: marvel characters rest api testing

  
  Scenario: Customer ordering from kodyorder
    When I open the kodyorder URL "https://pay-staging.kodypay.com/store/945e1c8c-0258-42d6-a850-2026c9507945/table?table=1"
    Then validate store name "Test Foods"
    Then validate the screen "main_menu_page.png"
    Then validate category names "Burgers,pizzas,Desserts,Milk shakes & cool drinks"
    When I selected the category "Burgers"
    And I selected the menu item "Cheeseburger"
    And I selected the addon "ketchup"
    And I selected the menu item "Chickenburger"
    And I selected the addon "ketchup"
    Then validate the screen "menu_burgers_selected.png"
    When I selected the category "pizzas"
    And I selected the menu item "Veggie Pizza"
    And I selected the menu item "Pepperoni Pizza"
    And I selected the menu item "Meat Pizza"
    Then validate the screen "menu_pizza_selected.png"
    When I selected the category "Desserts"
    And I selected the menu item "strawberry fool"
    And I selected the menu item "Jam Roly Poly"
    Then validate the screen "menu_desserts_selected.png"
     When I selected the category "Milk shakes & cool drinks"
    And I selected the menu item "Mango & Pineapple Smoothie Regular"
    And I selected the menu item "Diet coke"
    Then validate the screen "menu_drinks_selected.png"
    And Click on checkout
    Then validate the screen "Test Foods_checkout.png"
    When I click discount button
    Then validate the screen "apply_discount_code_12345.png"
    When applied the discount code "12345"
    Then validate the screen "checkout_discount_12345.png"
    When click on paybycard
    Then validate the screen "card_input_page.png"
    When I enter email "siva.nunna@kodypay.com"
    And pay the Amount By using card "4485040371536584"
    Then order should be placed successfully
    
    Scenario: Customer ordering from kodyorder with addons
    When I open the kodyorder URL "https://pay-staging.kodypay.com/store/945e1c8c-0258-42d6-a850-2026c9507945/table?table=1"
    Then validate store name "Test Foods"
    Then validate the screen "main_menu_page.png"
    Then validate category names "Burgers,pizzas,Desserts,Milk shakes & cool drinks"
    When I selected the category "Burgers"
    And I selected the menu item with addon "Cheeseburger","ketchup"
    And I selected the menu item with addon "Chickenburger","ketchup"
    Then validate the screen "menu_burgers_addons_selected.png"
    When I selected the category "pizzas"
    And I selected the menu item "Veggie Pizza"
    And I selected the menu item "Pepperoni Pizza"
    And I selected the menu item "Meat Pizza"
    Then validate the screen "menu_pizza_addons_selected.png"
    When I selected the category "Desserts"
    And I selected the menu item "strawberry fool"
    And I selected the menu item "Jam Roly Poly"
    Then validate the screen "menu_desserts_addons_selected.png"
     When I selected the category "Milk shakes & cool drinks"
    And I selected the menu item "Mango & Pineapple Smoothie Regular"
    And I selected the menu item "Diet coke"
    Then validate the screen "menu_drinks_addons_selected.png"
    And Click on checkout
    Then validate the screen "Test Foods_addons_checkout.png"
    When I click discount button
    Then validate the screen "apply_discount_code_12345.png"
    When applied the discount code "12345"
    Then validate the screen "checkout_discount_12345.png"
    When click on paybycard
    Then validate the screen "card_input_page.png"
    When I enter email "siva.nunna@kodypay.com"
    And pay the Amount By using card "4485040371536584"
    Then order should be placed successfully
    

 