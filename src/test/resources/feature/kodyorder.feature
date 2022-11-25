Feature: marvel characters rest api testing

  
  Scenario: Customer ordering from kodyorder
    When I open the kodyorder URL "https://pay-staging.kodypay.com/store/945e1c8c-0258-42d6-a850-2026c9507945/table?table=1"
    Then validate store name "SIVA HOTEL"
    Then validate the screen "default_menu_page.png"
    Then validate category names "Biryani,Soups,Curries"
    When I selected the category "Biryani"
    And I selected the menu item "Chicken Biryani"
    Then validate the screen "menu_page_order_1.png"
    When I selected the category "Soups"
    And I selected the menu item "veg soup"
    Then validate the screen "menu_page_order_2.png"
    When I selected the category "Curries"
    And I selected the menu item "potato"
    Then validate the screen "menu_page_order_3.png"
    And Click on checkout
    Then validate the screen "checkout.png"
    When I click discount button
    Then validate the screen "apply_discount_code.png"
    When applied the discount code "12345"
    Then validate the screen "checkout_discount.png"
    When click on paybycard
    Then validate the screen "payment_input_page.png"
    When I enter email "siva.nunna@kodypay.com"
    And pay the Amount By using card "4485040371536584"
    Then order should be placed successfully

 