Feature: marvel characters rest api testing

  
  Scenario: Customer ordering from kodyorder
    When I open the kodyorder URL "https://pay-staging.kodypay.com/store/945e1c8c-0258-42d6-a850-2026c9507945/table?table=1"
    Then validate store name "SIVA HOTEL"
    #Then validate category names "Biryani,Soups,Curries"
    #When I selected the category "Biryani"
    #And I selected the menu item "Chicken Biryani"
    #When I selected the category "Soups"
    #And I selected the menu item "veg soup"
    #When I selected the category "Curries"
    #And I selected the menu item "potato"
    #And Click on checkout
    #When applied the discount code "12345"
    #And pay the Amount By using card "4485040371536584"
    #Then order should be placed successfully.

 