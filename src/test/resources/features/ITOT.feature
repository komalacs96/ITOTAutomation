@End2End
Feature: API Validation and UI Navigation

  Scenario: Validate Product Information API and Dashboard Display
    Given Get a payload from the file "orders.json"
    When  Send a "POST" request to "/api/order"
    And  Response status code should be 201
    Then the product information is accurately retrieved
    And Navigate to dashboard page
    And Navigate to the inventory section
    Then validate Inventory details

